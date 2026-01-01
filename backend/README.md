# Programming Language Design Project
This project is part of the Programming Language Design course in the third year (second semester) of the Software Engineering degree. The goal of this project is to design and implement a main.java.parser and compiler using ANTLR, along with other necessary components for a custom programming language.

## Project Overview
In this project, we will:

- Design the syntax and semantics of a custom programming language.
- Implement a lexer and main.java.parser using ANTLR.
- Develop an Abstract Syntax Tree (AST) to represent the structure of the parsed code.
- Implement main.java.semantic analysis to check for errors and enforce language rules.
- Generate intermediate code or bytecode for the target platform.
- Implement a runtime environment to execute the generated code.

## Project Structure
The project is organized into the following directories:

- `src/main.java.ast/`: Contains the classes and interfaces for the Abstract Syntax Tree (AST).
  - `definition/`: Contains classes for function and variable definitions.
  - `expressions/`: Contains classes for different types of expressions.
  - `statements/`: Contains classes for different types of statements.
  - `types/`: Contains classes for different data types.

## Getting Started
To get started with the project, follow these steps:

1. Clone the repository:
   git clone https://github.com/yourusername/DLP.git
   cd DLP

2. Install the necessary dependencies:
    antlr4 -Dlanguage=Java -o src/antlr grammar/YourGrammar.g4

3. Compile the project:
    javac -d out src/**/*.java

4. Run the project:
    java -cp out MainClass


## Usage
To use the compiler, you can provide a source file written in the custom programming language. The compiler will parse the file, perform main.java.semantic analysis, and generate the corresponding intermediate code or bytecode. Example: java -cp out MainClass examples/HelloWorld.src

## License
This project is licensed under the MIT License. See the LICENSE file for more details.

## Acknowledgements
This project was developed as part of the Programming Language Design course at [Your University]. Special thanks to the course instructors and teaching assistants for their guidance and support.