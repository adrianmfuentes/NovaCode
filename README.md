# NovaCode

**NovaCode** es un compilador funcional para el lenguaje **P--**, desarrollado en **Java** en el contexto de la asignatura **Desarrollo de Lenguajes de Programación (DLP)** de la **Universidad de Oviedo**.

Este proyecto tiene como objetivo implementar, de forma práctica y estructurada, las fases fundamentales de un compilador, desde el análisis del código fuente hasta la generación de una representación intermedia o código de salida, según el alcance definido para la práctica académica.

---

## Descripción general

NovaCode nace como una solución académica orientada al estudio y aplicación de los principios de diseño e implementación de compiladores. El proyecto se centra en el lenguaje **P--**, un lenguaje docente utilizado habitualmente para introducir conceptos clave como:

- análisis léxico,
- análisis sintáctico,
- análisis semántico,
- gestión de símbolos,
- tratamiento de errores,
- y generación de código o representación intermedia.

La implementación en Java permite mantener una base de código modular, portable y adecuada para el desarrollo incremental de las distintas fases del compilador.

---

## Objetivos del proyecto

Los objetivos principales de NovaCode son:

- Implementar un compilador funcional para el lenguaje P--.
- Aplicar los conceptos teóricos vistos en la asignatura de DLP.
- Diseñar una arquitectura clara y mantenible para las diferentes fases de compilación.
- Facilitar la validación de programas fuente mediante detección y reporte de errores.
- Servir como base de trabajo para futuras mejoras, ampliaciones o experimentación académica.

---

## Características principales

Entre las capacidades y enfoques del proyecto se incluyen:

- Implementación en **Java**.
- Enfoque académico y estructurado.
- Separación lógica por fases del compilador.
- Procesamiento de programas escritos en **P--**.
- Validación léxica, sintáctica y semántica según las reglas definidas para el lenguaje.
- Base adecuada para pruebas, depuración y ampliación del compilador.

> **Nota:** El alcance exacto de las funcionalidades disponibles puede depender del estado actual de desarrollo del repositorio.

---

## Arquitectura del compilador

De forma general, un compilador como NovaCode se organiza en varias etapas. Este proyecto está orientado a reflejar esa división clásica:

### 1. Análisis léxico
Transforma el texto fuente en una secuencia de tokens reconocibles por el compilador.

Responsabilidades habituales:
- reconocimiento de palabras clave,
- identificadores,
- literales,
- operadores,
- separadores,
- y detección de errores léxicos.

### 2. Análisis sintáctico
Comprueba que la secuencia de tokens cumple la gramática del lenguaje P--.

Responsabilidades habituales:
- construcción o validación de la estructura del programa,
- detección de errores sintácticos,
- generación de estructuras intermedias para fases posteriores.

### 3. Análisis semántico
Verifica restricciones no expresables únicamente mediante la gramática.

Ejemplos típicos:
- uso correcto de identificadores,
- comprobación de tipos,
- control de ámbitos,
- validación de declaraciones y expresiones.

### 4. Gestión de símbolos
Mantiene la información asociada a variables, funciones, constantes y otros elementos del programa.

### 5. Generación de salida
Según el alcance de la práctica, esta fase puede consistir en:
- generación de código intermedio,
- representación estructurada,
- código objeto simplificado,
- o cualquier forma de salida definida para el compilador.

---

## Tecnologías utilizadas

Este proyecto ha sido desarrollado con:

- **Java** como lenguaje principal de implementación.
- Herramientas y utilidades propias del ecosistema Java para compilación y ejecución.
- Organización modular orientada a separar responsabilidades entre componentes del compilador.

Si el proyecto incorpora herramientas adicionales concretas, pueden documentarse aquí más adelante.

---

## Requisitos

Para trabajar con NovaCode, normalmente se necesita:

- **JDK** instalado.
- Un entorno de desarrollo Java o herramientas de línea de comandos.
- El código fuente del proyecto clonado localmente.

Requisitos recomendados:
- IDE como IntelliJ IDEA, Eclipse o Visual Studio Code con soporte para Java.
- Conocimientos básicos de compiladores y del lenguaje P--.

> Si el proyecto depende de una versión específica de Java, conviene indicarla explícitamente en esta sección.

---

## Instalación y puesta en marcha

### 1. Clonar el repositorio

```bash
git clone <URL_DEL_REPOSITORIO>
cd NovaCode
```

### 2. Abrir el proyecto

Puede abrirse en cualquier entorno compatible con Java, o compilarse desde terminal según la estructura concreta del repositorio.

### 3. Compilar

El proceso exacto dependerá de cómo esté organizado el proyecto:

- compilación manual con `javac`,
- uso de un IDE,
- o integración con una herramienta de construcción si existe.

Ejemplo genérico:

```bash
javac -d out src/**/*.java
```

### 4. Ejecutar

La ejecución también dependerá del punto de entrada definido en el proyecto. Un ejemplo genérico sería:

```bash
java -cp out paquete.Main
```

> Sustituye los comandos anteriores por los que correspondan a la estructura real del repositorio.

---

## Uso

De forma general, NovaCode está pensado para recibir como entrada uno o varios archivos fuente escritos en **P--** y procesarlos a través de las distintas fases del compilador.

El flujo habitual de uso es el siguiente:

1. Escribir un programa en P--.
2. Pasarlo al compilador.
3. Revisar la salida generada.
4. Analizar los errores, si los hubiera.
5. Corregir el código fuente y repetir el proceso.

Ejemplo conceptual:

```bash
java -cp out paquete.Main programa.pmm
```

Posibles resultados:
- aceptación correcta del programa,
- listado de errores léxicos,
- errores sintácticos con localización,
- errores semánticos,
- o generación de una salida intermedia/final.

---

## Estructura del proyecto

La organización exacta puede variar, pero en un compilador de este tipo suele incluir módulos o paquetes similares a los siguientes:

```text
NovaCode/
├─ src/
│  ├─ lexer/        # Análisis léxico
│  ├─ parser/       # Análisis sintáctico
│  ├─ semantic/     # Análisis semántico
│  ├─ symbols/      # Tabla de símbolos
│  ├─ codegen/      # Generación de código o salida
│  └─ ...           # Utilidades y clases auxiliares
├─ test/            # Casos de prueba
├─ examples/        # Programas de ejemplo en P--
└─ README.md
```

Si la estructura real del repositorio es distinta, esta sección puede ajustarse para reflejarla con precisión.

---

## Gestión de errores

Uno de los aspectos más importantes de cualquier compilador es la calidad del diagnóstico de errores. NovaCode está orientado a facilitar:

- detección temprana de errores,
- mensajes claros y localizables,
- separación por tipo de error,
- y soporte para depuración durante el desarrollo.

Idealmente, el compilador debería informar de:
- línea y columna,
- tipo de error,
- descripción breve,
- y contexto suficiente para su corrección.

---

## Enfoque académico

NovaCode no solo busca ser una herramienta funcional, sino también un proyecto útil desde el punto de vista formativo. Su desarrollo permite trabajar competencias como:

- diseño de gramáticas,
- implementación de analizadores,
- estructuras de datos para compilación,
- modelado de AST o representaciones intermedias,
- validación semántica,
- y organización de software a medio tamaño.

Este enfoque lo convierte en una base especialmente valiosa para estudiantes de compiladores y lenguajes de programación.

---

## Estado del proyecto

Estado actual:
- **Compilador funcional para P--**
- desarrollado como práctica/proyecto académico
- susceptible de ampliación, refactorización y mejora

Posibles líneas de evolución:
- ampliar la cobertura del lenguaje,
- mejorar los mensajes de error,
- incorporar más pruebas automáticas,
- añadir documentación técnica interna,
- optimizar la arquitectura del compilador,
- y mejorar la generación de código.

---

## Posibles mejoras futuras

Algunas extensiones razonables para el proyecto podrían ser:

- soporte para más construcciones del lenguaje,
- mejor recuperación ante errores sintácticos,
- visualización del árbol sintáctico o AST,
- integración de pruebas automatizadas,
- generación de informes de compilación,
- documentación detallada de la gramática de P--,
- y automatización del proceso de build.

---

## Contexto académico

Proyecto desarrollado para la asignatura:

**Desarrollo de Lenguajes de Programación (DLP)**  
**Universidad de Oviedo**

NovaCode representa la aplicación práctica de los contenidos de la materia en un entorno real de desarrollo, con especial atención a la implementación de un compilador completo o parcialmente funcional para un lenguaje docente.

---

## Contribución

Al tratarse de un proyecto académico, las contribuciones dependerán del contexto en el que se utilice el repositorio. Si se desea ampliar el proyecto, se recomienda:

1. mantener una estructura modular,
2. documentar cada cambio relevante,
3. añadir casos de prueba,
4. y preservar la coherencia entre las fases del compilador.

---

## Licencia

Si este repositorio va a compartirse públicamente, conviene añadir aquí la licencia correspondiente.

Ejemplo:
- MIT
- Apache-2.0
- o la licencia académica que proceda

---

## Autoría

Proyecto desarrollado como parte de una práctica académica de compiladores.

Si se desea, esta sección puede ampliarse con:
- nombre del autor o autores,
- curso académico,
- grupo de prácticas,
- y profesores o contexto docente.

---

## Resumen

NovaCode es un compilador en Java para el lenguaje P-- con enfoque académico, diseñado para poner en práctica las fases esenciales de construcción de compiladores. El proyecto sirve tanto como herramienta funcional como base de aprendizaje en el ámbito de los lenguajes de programación y la compilación.
