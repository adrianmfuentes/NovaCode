let editor;
let currentGeneratedCode = "";

// Configuración del API Backend
// En desarrollo local: http://localhost:8247/api/compile
// Por IP directa: http://{misma-ip}:8247/api/compile
// En Docker: http://novacode-backend:8080/api/compile
// En producción (Nginx): /api/compile (mismo dominio)
const getBackendUrl = () => {
    const hostname = window.location.hostname;
    const protocol = window.location.protocol;
    
    if (hostname === 'localhost') {
        return 'http://localhost:8247';  // Desarrollo local
    } else if (hostname.includes('amfserver.duckdns.org')) {
        return `${protocol}//${hostname}`;  // Producción: mismo dominio (Nginx maneja /api)
    } else if (/^\d+\.\d+\.\d+\.\d+$/.test(hostname)) {
        return `http://${hostname}:8247`;  // Por IP
    } else {
        return 'http://novacode-backend:8080';  // Docker interno
    }
};

const API_BASE_URL = getBackendUrl();
const COMPILE_ENDPOINT = API_BASE_URL.includes('amfserver.duckdns.org') 
    ? '/api/compile'  // Por dominio, ruta relativa (Nginx lo redirige)
    : `${API_BASE_URL}/api/compile`;  // Por IP o localhost

// Configuración de Monaco Editor - usando jsdelivr que es más confiable
require.config({ paths: { vs: 'https://cdn.jsdelivr.net/npm/monaco-editor@0.50.0/min/vs' } });

let editorReady = false;
require(['vs/editor/editor.main'], function () {
    try {
        editor = monaco.editor.create(document.getElementById('monaco-editor'), {
            value: "def main()->None: {\n    print 'H', 'o', 'l', 'a', ' ', 'N', 'o', 'v', 'a', 'C', 'o', 'd', 'e';\n}",
            language: 'cpp', // Usamos C++ como base para el coloreado inicial
            theme: 'vs-dark',
            automaticLayout: true,
            fontSize: 14,
            fontFamily: 'Fira Code',
            minimap: { enabled: false },
            lineNumbers: 'on',
            padding: { top: 16 },
            renderWhitespace: 'none',
            wordWrap: 'on',
            smoothScrolling: true,
            cursorStyle: 'line',
            cursorBlinking: 'blink'
        });
        editorReady = true;
        console.log('✓ Monaco Editor cargado correctamente');
    } catch (error) {
        console.error('✗ Error al inicializar Monaco Editor:', error);
    }
}, function (err) {
    console.error('✗ Error cargando módulos de Monaco:', err);
});

async function compileCode() {
    if (!editorReady || !editor) {
        const outputElement = document.getElementById('console-output');
        outputElement.innerHTML = '<div class="text-red-500">⚠️ El editor aún se está cargando. Por favor espera un momento...</div>';
        return;
    }

    const code = editor.getValue();
    const outputElement = document.getElementById('console-output');
    const statusBar = document.getElementById('status-bar');
    const downloadBtn = document.getElementById('downloadBtn');

    outputElement.innerHTML = '<div class="text-blue-400 animate-pulse">Compilando...</div>';
    statusBar.innerText = "Procesando...";
    statusBar.className = "h-8 border-t border-gray-800 flex items-center px-4 text-[10px] font-bold uppercase tracking-widest text-blue-500 bg-blue-900/10";

    try {
        const response = await fetch(COMPILE_ENDPOINT, {
            method: 'POST',
            headers: { 'Content-Type': 'text/plain' },
            body: code
        });

        const data = await response.json();

        if (data.status === "success") {
            currentGeneratedCode = data.generatedCode;
            outputElement.innerHTML = `<pre class="text-green-400">${escapeHtml(data.generatedCode)}</pre>`;
            statusBar.innerText = "Éxito";
            statusBar.className = "h-8 border-t border-gray-800 flex items-center px-4 text-[10px] font-bold uppercase tracking-widest text-green-500 bg-green-900/10";
            downloadBtn.classList.remove('hidden');
        } else {
            outputElement.innerHTML = `
                <div class="text-red-500 font-bold mb-2">Error en etapa: ${data.stage}</div>
                <pre class="text-red-400 bg-red-900/20 p-2 rounded border border-red-900/50">${escapeHtml(data.errors || "Error desconocido")}</pre>`;
            statusBar.innerText = "Fallo";
            statusBar.className = "h-8 border-t border-gray-800 flex items-center px-4 text-[10px] font-bold uppercase tracking-widest text-red-500 bg-red-900/10";
            downloadBtn.classList.add('hidden');
        }

    } catch (error) {
        console.error('Backend connection error:', error);
        outputElement.innerHTML = `<div class="text-red-500">Error de conexión: No se pudo conectar al backend en ${COMPILE_ENDPOINT}.</div>`;
        statusBar.innerText = "Error de Servidor";
    }
}

function downloadCode() {
    const blob = new Blob([currentGeneratedCode], { type: 'text/plain' });
    const url = window.URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = 'output.mapl';
    a.click();
}

function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}