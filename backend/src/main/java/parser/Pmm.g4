grammar Pmm;
@header{
    import ast.*;
    import ast.definition.*;
    import ast.expressions.*;
    import ast.expressions.binary.*;
    import ast.expressions.literal.*;
    import ast.expressions.unary.*;
    import ast.statements.*;
    import ast.types.*;
    import errorhandler.ErrorHandler;
}

program returns[Program main.java.ast]
        locals [List<Definition> optional = new ArrayList<Definition>()]:
        (definition {$optional.addAll($definition.main.java.ast);} )* mainDefinition {$optional.add($mainDefinition.main.java.ast);} EOF
           {$main.java.ast = new Program($optional);}
        ;

mainDefinition returns [Definition main.java.ast]
        locals [List<VarDefinition> bodyVarDefs = new ArrayList<VarDefinition>(),
                List<Statement> bodyStmt = new ArrayList<Statement>()]:
        'def' id='main' '('')' '->' 'None'':''{'
                ( vd=var_definition {$bodyVarDefs.addAll($vd.main.java.ast);})* (statement {$bodyStmt.addAll($statement.main.java.ast);} )* '}'
        {$main.java.ast = new FunctionDefinition(
               $id.getLine(), $id.getCharPositionInLine(), $id.text,
                    new FunctionType(VoidType.getInstance(), new ArrayList()), $bodyVarDefs, $bodyStmt) ;}
        ;

definition returns[List<Definition> main.java.ast = new ArrayList<Definition>()]:
           var_definition           {$main.java.ast.addAll($var_definition.main.java.ast);}
           | function_definition    {$main.java.ast.addAll($function_definition.main.java.ast);}
           ;

var_definition returns[List<VarDefinition> main.java.ast = new ArrayList<VarDefinition>()]
              locals[List<Token> tokens = new ArrayList<Token>()]:
              id1=ID {$tokens.add($id1);} (',' id2=ID {$tokens.add($id2);})* ':' type ';'
                    {$tokens.stream().forEach(token -> {
                        if($main.java.ast.stream().anyMatch(vdef -> vdef.name.equals(token.getText()))) {
                            new ErrorType(token.getText(), new VarDefinition(token.getLine(),
                                    token.getCharPositionInLine() + 1, token.getText(), $type.main.java.ast));
                        }

                        $main.java.ast.add( new VarDefinition(token.getLine(), token.getCharPositionInLine() + 1,
                                token.getText(), $type.main.java.ast ));
                        });
                    ;}
              ;

function_definition returns[List<Definition> main.java.ast = new ArrayList<Definition>()]
                    locals [List<VarDefinition> bodyVarDefs = new ArrayList<VarDefinition>(),
                            List<Statement> bodyStmt = new ArrayList<Statement>()]:
                    'def' ID '(' function_parameters ')' '->' (built_in_types) ':'
                        '{' ( vd=var_definition {$bodyVarDefs.addAll($vd.main.java.ast);} )* ( statement {$bodyStmt.addAll($statement.main.java.ast);} )* '}'
                        {$main.java.ast.add(new FunctionDefinition(
                            $ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text,
                            new FunctionType( $built_in_types.main.java.ast, $function_parameters.main.java.ast), $bodyVarDefs, $bodyStmt )); }

                    | 'def' ID '(' function_parameters ')' '->' 'None' ':'
                        '{' ( vd=var_definition {$bodyVarDefs.addAll($vd.main.java.ast);} )* ( statement {$bodyStmt.addAll($statement.main.java.ast);} )* '}'
                        {$main.java.ast.add(new FunctionDefinition(
                            $ID.getLine(), $ID.getCharPositionInLine() + 1, $ID.text,
                            new FunctionType( VoidType.getInstance(), $function_parameters.main.java.ast), $bodyVarDefs, $bodyStmt )); }
                   ;

function_parameters returns [List<VarDefinition> main.java.ast = new ArrayList<VarDefinition>()]:
    (id1=ID ':' t1=built_in_types
        {$main.java.ast.add(
            new VarDefinition(
                $id1.getLine(),
                $id1.getCharPositionInLine() + 1,
                $id1.getText(),
                $t1.main.java.ast)
            );
        }
    )
    (',' id2=ID ':' t2=built_in_types
        {$main.java.ast.add(
            new VarDefinition(
                $id2.getLine(),
                $id2.getCharPositionInLine() + 1,
                $id2.getText(),
                $t2.main.java.ast
            )
        );}
    )*
    | /* empty */
    ;

expression returns[Expression main.java.ast]:
          ID                  { $main.java.ast = new Variable(
                                            $ID.getLine(),
                                            $ID.getCharPositionInLine() + 1,
                                            $ID.text); }

          | REAL_CONSTANT       { $main.java.ast = new DoubleLiteral(
                                    $REAL_CONSTANT.getLine(),
                                    $REAL_CONSTANT.getCharPositionInLine() + 1,
                                    LexerHelper.lexemeToReal($REAL_CONSTANT.text) ); }

          | INT_CONSTANT        { $main.java.ast = new IntLiteral(
                                        $INT_CONSTANT.getLine(),
                                        $INT_CONSTANT.getCharPositionInLine() + 1,
                                        LexerHelper.lexemeToInt($INT_CONSTANT.text) ); }

          | CHAR_CONSTANT       { $main.java.ast = new CharLiteral(
                                        $CHAR_CONSTANT.getLine(),
                                        $CHAR_CONSTANT.getCharPositionInLine() + 1,
                                        LexerHelper.lexemeToChar($CHAR_CONSTANT.text) ); }
          |  '(' e1=expression ')'                 {$main.java.ast = $e1.main.java.ast;}

          | e1=expression '[' e2=expression ']'   {$main.java.ast = new ArrayAccess($e1.main.java.ast.getLine(), $e1.main.java.ast.getColumn(),
                                                                    $e1.main.java.ast, $e2.main.java.ast);}

          | e1=expression  '.' ID              {$main.java.ast = new StructAccess($e1.main.java.ast.getLine(), $e1.main.java.ast.getColumn(),
                                                                    $e1.main.java.ast, $ID.text);}

          | '(' type ')' expression            {$main.java.ast = new Cast($expression.main.java.ast.getLine(), $expression.main.java.ast.getColumn(),
                                                                    $expression.main.java.ast, $type.main.java.ast);}

          | '-' expression                     {$main.java.ast = new Minus($expression.main.java.ast.getLine(), $expression.main.java.ast.getColumn(),
                                                                    $expression.main.java.ast);}

          | '!' expression                     {$main.java.ast = new Not($expression.main.java.ast.getLine(), $expression.main.java.ast.getColumn(),
                                                                    $expression.main.java.ast);}

          | e1=expression OP=('*'|'/'|'%') e2=expression       {$main.java.ast = new Arithmetic($e1.main.java.ast.getLine(),
                                                                    $e1.main.java.ast.getColumn(), $OP.text, $e1.main.java.ast, $e2.main.java.ast);}

          | e1=expression OP=('+'|'-') e2=expression           {$main.java.ast = new Arithmetic($e1.main.java.ast.getLine(),
                                                                    $e1.main.java.ast.getColumn(), $OP.text, $e1.main.java.ast, $e2.main.java.ast);}

          | e1=expression OP=('>'|'>='|'<'|'<='|'!='|'==') e2=expression      {$main.java.ast = new Comparison(
                                                                                    $e1.main.java.ast.getLine(),
                                                                                    $e1.main.java.ast.getColumn(),
                                                                                    $OP.text, $e1.main.java.ast, $e2.main.java.ast);}

          | e1=expression OP=('&&'|'||') e2=expression       {$main.java.ast = new Logical(
                                                                    $e1.main.java.ast.getLine(), $e1.main.java.ast.getColumn(),
                                                                    $OP.text, $e1.main.java.ast, $e2.main.java.ast);}

          | ID '(' e=expressions_optional ')'   {$main.java.ast = new FunctionInvocation(
                                                       $ID.getLine(),
                                                       $ID.getCharPositionInLine() + 1,
                                                       new Variable(
                                                            $ID.getLine(),
                                                            $ID.getCharPositionInLine() + 1,
                                                            $ID.text),
                                                       $e.main.java.ast
                                                 );}
          ;

expressions returns[List<Expression> main.java.ast = new ArrayList<Expression>()]:
           e1=expression { $main.java.ast.add($e1.main.java.ast); } ( ',' e2=expression { $main.java.ast.add($e2.main.java.ast); } )*
           ;

expressions_optional returns[List<Expression> main.java.ast = new ArrayList<Expression>()]:
                    expressions         { $main.java.ast.addAll($expressions.main.java.ast); }
                    | /* empty */
                    ;

type returns[Type main.java.ast]
    locals [List<Field> aux]:
    built_in_types                  { $main.java.ast = $built_in_types.main.java.ast; }
    | '[' INT_CONSTANT ']' type     { $main.java.ast = new Array(LexerHelper.lexemeToInt($INT_CONSTANT.text), $type.main.java.ast); }
    | 'struct' '{' {$aux = new ArrayList<>();} (field {$aux.addAll($field.main.java.ast);} )+ '}'
        {
            $aux.stream()
                .map(field -> field.name)
                .distinct()
                .forEach(name -> {
                    if ($aux.stream().filter(f -> f.name.equals(name)).count() > 1) {
                        new ErrorType("Duplicated field in struct: " + name,
                                $aux.stream().filter(f -> f.name.equals(name)).findFirst().get());
                    }
                });


            $main.java.ast = new Struct($aux);
        }
    ;

built_in_types returns[Type main.java.ast]:
    'int'           {$main.java.ast = Int.getInstance();}
    |'char'         {$main.java.ast = Char.getInstance();}
    |'double'       {$main.java.ast = DoubleType.getInstance();}
    ;

field returns [List<Field> main.java.ast = new ArrayList<Field>()]
    locals[List<Token> tokens = new ArrayList<Token>()]:
    (id1=ID {$tokens.add($id1);} (',' id2=ID {$tokens.add($id2);})* ':' t=type ';'
        {
            for (Token token : $tokens) {
                $main.java.ast.add(new Field(token.getLine(), token.getCharPositionInLine() + 1, $t.main.java.ast, token.getText()));
            }
        }
    )
    ;

statement returns[List<Statement> main.java.ast = new ArrayList<Statement>()]
         locals [List else]:
         K='print' expressions ';'         {$expressions.main.java.ast.forEach(exp ->
                                                $main.java.ast.add(new Write(
                                                           $K.getLine(),
                                                           $K.getCharPositionInLine() + 1,
                                                           exp ))); }

         | K='input' expressions ';'         {$expressions.main.java.ast.forEach(exp ->
                                                 $main.java.ast.add(new Read(
                                                           $K.getLine(),
                                                           $K.getCharPositionInLine() + 1,
                                                           exp ))); }

         | e1=expression '=' e2=expression ';'        {$main.java.ast.add(new Assigment(
                                                             $e1.main.java.ast.getLine(),
                                                             $e1.main.java.ast.getColumn(),
                                                             $e1.main.java.ast,
                                                             $e2.main.java.ast )); }

         | 'while' expression ':' block               {$main.java.ast.add(new While(
                                                             $expression.main.java.ast.getLine(),
                                                             $expression.main.java.ast.getColumn(),
                                                             $expression.main.java.ast,
                                                             $block.main.java.ast )); }

         | 'if' exp=expression ':' b1=block {$else = new ArrayList<>();} ( 'else' ':' b2=block{$else = $b2.main.java.ast;} )?
                {$main.java.ast.add(new IfElse($exp.main.java.ast.getLine(), $exp.main.java.ast.getColumn(), $exp.main.java.ast, $b1.main.java.ast, $else));}

         | 'return' expression ';'                    {$main.java.ast.add(new Return(
                                                             $expression.main.java.ast.getLine(),
                                                             $expression.main.java.ast.getColumn(),
                                                             $expression.main.java.ast )); }

         | ID '(' e=expressions_optional ')' ';'      {$main.java.ast.add(new FunctionInvocation(
                                                             $ID.getLine(),
                                                             $ID.getCharPositionInLine() + 1,
                                                             new Variable(
                                                                    $ID.getLine(),
                                                                    $ID.getCharPositionInLine() + 1,
                                                                    $ID.text),
                                                             $e.main.java.ast )); }
         ;

block returns[List<Statement> main.java.ast = new ArrayList<Statement>()]:
     statement                  { $main.java.ast.addAll($statement.main.java.ast); }
     | '{' (statement { $main.java.ast.addAll($statement.main.java.ast); })* '}'
     ;

fragment
DIGIT: [0-9]
     ;

fragment
LETTER: [a-zA-Z]
      ;

INT_CONSTANT: '0'
            | [1-9] DIGIT*
            ;

WS: [ \t\n\r\f]+ -> skip
  ;

ID: (LETTER|'_') (LETTER|DIGIT|'_')*
   ;

REAL_CONSTANT: (INT_CONSTANT)+ '.' (INT_CONSTANT)*
             | (INT_CONSTANT)* '.' (INT_CONSTANT)+
             | ((INT_CONSTANT)+ '.' (INT_CONSTANT)* | (INT_CONSTANT)* '.' (INT_CONSTANT)+) [eE] ('-'|'+')? INT_CONSTANT
             | INT_CONSTANT [eE] ('-'|'+')? INT_CONSTANT
             ;

CHAR_CONSTANT: '\'\\' INT_CONSTANT '\''
             |  '\'\\' [nt] '\''
             | '\'' . '\''
             ;

SINGLE_LINE_COMMENT: '#' ~[\r\n]* -> skip
                   ;

MULTI_LINE_COMMENT: '"""' .*? '"""' -> skip
                  ;





