# Lenguaje — Descripción del Programa

## Índice
- [Resumen](#resumen)
- [Estructura del programa](#estructura-del-programa)
- [Definición de variables](#definición-de-variables)
- [Definición de funciones](#definición-de-funciones)
- [Tipos](#tipos)
- [Sentencias](#sentencias)
- [Expresiones](#expresiones)
- [Ejemplos y notas](#ejemplos-y-notas)

## Resumen
Un programa es una secuencia de definiciones. Las definiciones pueden ser de variables o de funciones. Esta guía recoge la sintaxis y las reglas principales del lenguaje.

## Estructura del programa
Un programa está formado por una lista de definiciones (variables y funciones). Las definiciones de variables terminan con `;`. Las funciones contienen un cuerpo con definiciones locales y sentencias.

## Definición de variables
- Sintaxis: una lista (al menos un elemento) de identificadores separados por comas, seguida de `:` y un tipo.
- Terminador: `;`

Ejemplo:
```
a, b: int;
```

## Definición de funciones
- Empiezan con la palabra reservada `def`, seguida del identificador de la función.
- Parámetros: lista separada por comas entre `(` y `)`.
- Tipo de retorno: `->` seguido de un tipo simple, o `None` si no retorna.
- Cuerpo: comienza con `:` y va entre `{` y `}`.
- En el cuerpo: cero o más definiciones de variables (cada una terminada en `;`) seguidas de cero o más sentencias (cada una terminada en `;`).
- La función `main`:
  - No devuelve valor.
  - No recibe parámetros.
  - Debe declararse obligatoriamente en último lugar.

Ejemplo:
```
def suma(a: int, b: int) -> int:
{
    result: int;
    return result;
}
```

## Tipos
- Tipos simples: `int`, `double`, `char`.
- Arrays: uso del constructor `[]`, especificando tamaño con una constante entera (similar a C), p. ej. `int[10]`.
- Registros (structs): construidos con `struct { ... }` sin identificador; los campos se declaran como variables dentro de `{` `}`.
- Restricción: no se permiten definiciones de tipos anidadas (por ejemplo `typedef`).

## Sentencias
- Escritura: `print` seguido de una lista de una o más expresiones separadas por comas.
- Lectura: `input` seguido de una lista de una o más expresiones separadas por comas.
- Asignación: dos expresiones separadas por el operador `=`.
- Condicionales: `if`-`else` con sintaxis similar a Python en la condición (sin paréntesis y con `:` después de la condición y de `else`), pero el cuerpo puede usar sintaxis de Java: `{ ... }`. Si el cuerpo tiene una sola sentencia, las llaves son opcionales.
- Iteración: `while` sigue la misma convención que `if`.
- `return` requiere siempre una expresión (no está permitido `return` sin valor).
- Invocación a procedimiento: llamar a una función que no retorna (procedimiento) se considera siempre una sentencia.

Ejemplos:
```
print a, b;
input x;
if x > 0:
{
    print x;
} else:
    print 0;
```

## Expresiones
- Pueden ser:
  - Constantes: enteras, reales y caracteres (sin signo).
  - Identificadores.
  - Invocación a función (es expresión si la función retorna).
  - Casts: conversión explícita a tipos simples con la sintaxis de C, p. ej. `(int) x`.
- Precedencia y asociatividad (de mayor a menor precedencia):
  1. `()` (no asociativo)
  2. `[]` (no asociativo)
  3. `.` (asociatividad izquierda)
  4. `CAST` (no asociativo)
  5. `-` (unario, no asociativo)
  6. `!` (no asociativo)
  7. `* / %` (izquierda)
  8. `+ -` (izquierda)
  9. `> >= < <= != ==` (izquierda)
  10. `&& ||` (izquierda)

## Ejemplos y notas
- El tipo de retorno y los tipos de parámetros deben ser simples (no arrays ni structs).
- Mantener la función `main` al final del fichero fuente.
- Los arrays requieren un tamaño constante entero en su declaración.

Si necesitas ejemplos adicionales o un fichero README separado, indícalo y lo genero.
