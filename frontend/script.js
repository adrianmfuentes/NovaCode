let editor;
let currentGeneratedCode = "";

// Configuración de Monaco Editor
require.config({ paths: { vs: 'https://cdnjs.cloudflare.com/ajax/libs/monaco-editor/0.44.0/min/vs' } });

require(['vs/editor/editor.main'], function () {
    editor = monaco.editor.create(document.getElementById('monaco-editor'), {
        value: "def main()->None: {\n    print 'Hola NovaCode';\n}",
        language: 'cpp', // Usamos C++ como base para el coloreado inicial
        theme: 'vs-dark',
        automaticLayout: true,
        fontSize: 14,
        fontFamily: 'Fira Code',
        minimap: { enabled: false },
        lineNumbers: 'on',
        padding: { top: 16 }
    });
});

async function compileCode() {
    const code = editor.getValue();
    const outputElement = document.getElementById('console-output');
    const statusBar = document.getElementById('status-bar');
    const downloadBtn = document.getElementById('downloadBtn');

    outputElement.innerHTML = '<div class="text-blue-400 animate-pulse">Compilando...</div>';
    statusBar.innerText = "Procesando...";
    statusBar.className = "h-8 border-t border-gray-800 flex items-center px-4 text-[10px] font-bold uppercase tracking-widest text-blue-500 bg-blue-900/10";

    try {
        const response = await fetch('http://localhost:8080/api/compile', {
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
        outputElement.innerHTML = `<div class="text-red-500">Error de conexión: Asegúrate de que el backend está corriendo en el puerto 8080.</div>`;
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