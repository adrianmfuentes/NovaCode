// Generated from C:/Users/34644/OneDrive - Universidad de Oviedo/Tercero - Segundo Cuatrimestre/DLP/Laboratorio/DLP/src/main.java.parser/Pmm.g4 by ANTLR 4.13.2
package parser;

    import ast.*;
    import ast.definition.*;
    import ast.expressions.*;
    import ast.expressions.binary.*;
    import ast.expressions.literal.*;
    import ast.expressions.unary.*;
    import ast.statements.*;
    import ast.types.*;

    import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
    import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, INT_CONSTANT=40, WS=41, ID=42, REAL_CONSTANT=43, CHAR_CONSTANT=44, 
		SINGLE_LINE_COMMENT=45, MULTI_LINE_COMMENT=46;
	public static final int
		RULE_program = 0, RULE_mainDefinition = 1, RULE_definition = 2, RULE_var_definition = 3, 
		RULE_function_definition = 4, RULE_function_parameters = 5, RULE_expression = 6, 
		RULE_expressions = 7, RULE_expressions_optional = 8, RULE_type = 9, RULE_built_in_types = 10, 
		RULE_field = 11, RULE_statement = 12, RULE_block = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainDefinition", "definition", "var_definition", "function_definition", 
			"function_parameters", "expression", "expressions", "expressions_optional", 
			"type", "built_in_types", "field", "statement", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'def'", "'main'", "'('", "')'", "'->'", "'None'", "':'", "'{'", 
			"'}'", "','", "';'", "'['", "']'", "'.'", "'-'", "'!'", "'*'", "'/'", 
			"'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", 
			"'struct'", "'int'", "'char'", "'double'", "'print'", "'input'", "'='", 
			"'while'", "'if'", "'else'", "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "INT_CONSTANT", "WS", "ID", "REAL_CONSTANT", 
			"CHAR_CONSTANT", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> optional = new ArrayList<Definition>();
		public DefinitionContext definition;
		public MainDefinitionContext mainDefinition;
		public MainDefinitionContext mainDefinition() {
			return getRuleContext(MainDefinitionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(28);
					((ProgramContext)_localctx).definition = definition();
					_localctx.optional.addAll(((ProgramContext)_localctx).definition.ast);
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(36);
			((ProgramContext)_localctx).mainDefinition = mainDefinition();
			_localctx.optional.add(((ProgramContext)_localctx).mainDefinition.ast);
			setState(38);
			match(EOF);
			((ProgramContext)_localctx).ast =  new Program(_localctx.optional);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainDefinitionContext extends ParserRuleContext {
		public Definition ast;
		public List<VarDefinition> bodyVarDefs = new ArrayList<VarDefinition>();
		public List<Statement> bodyStmt = new ArrayList<Statement>();
		public Token id;
		public Var_definitionContext vd;
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public MainDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDefinition; }
	}

	public final MainDefinitionContext mainDefinition() throws RecognitionException {
		MainDefinitionContext _localctx = new MainDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
			((MainDefinitionContext)_localctx).id = match(T__1);
			setState(43);
			match(T__2);
			setState(44);
			match(T__3);
			setState(45);
			match(T__4);
			setState(46);
			match(T__5);
			setState(47);
			match(T__6);
			setState(48);
			match(T__7);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49);
					((MainDefinitionContext)_localctx).vd = var_definition();
					_localctx.bodyVarDefs.addAll(((MainDefinitionContext)_localctx).vd.ast);
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32667521351688L) != 0)) {
				{
				{
				setState(57);
				((MainDefinitionContext)_localctx).statement = statement();
				_localctx.bodyStmt.addAll(((MainDefinitionContext)_localctx).statement.ast);
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			match(T__8);
			((MainDefinitionContext)_localctx).ast =  new FunctionDefinition(
			               ((MainDefinitionContext)_localctx).id.getLine(), ((MainDefinitionContext)_localctx).id.getCharPositionInLine(), (((MainDefinitionContext)_localctx).id!=null?((MainDefinitionContext)_localctx).id.getText():null),
			                    new FunctionType(VoidType.getInstance(), new ArrayList()), _localctx.bodyVarDefs, _localctx.bodyStmt) ;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Var_definitionContext var_definition;
		public Function_definitionContext function_definition;
		public Var_definitionContext var_definition() {
			return getRuleContext(Var_definitionContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				((DefinitionContext)_localctx).var_definition = var_definition();
				_localctx.ast.addAll(((DefinitionContext)_localctx).var_definition.ast);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				((DefinitionContext)_localctx).function_definition = function_definition();
				_localctx.ast.addAll(((DefinitionContext)_localctx).function_definition.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_definitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public List<Token> tokens = new ArrayList<Token>();
		public Token id1;
		public Token id2;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public Var_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_definition; }
	}

	public final Var_definitionContext var_definition() throws RecognitionException {
		Var_definitionContext _localctx = new Var_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			((Var_definitionContext)_localctx).id1 = match(ID);
			_localctx.tokens.add(((Var_definitionContext)_localctx).id1);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(78);
				match(T__9);
				setState(79);
				((Var_definitionContext)_localctx).id2 = match(ID);
				_localctx.tokens.add(((Var_definitionContext)_localctx).id2);
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(T__6);
			setState(87);
			((Var_definitionContext)_localctx).type = type();
			setState(88);
			match(T__10);
			_localctx.tokens.stream().forEach(token -> {
			                        if(_localctx.ast.stream().anyMatch(vdef -> vdef.name.equals(token.getText()))) {
			                            new ErrorType(token.getText(), new VarDefinition(token.getLine(),
			                                    token.getCharPositionInLine() + 1, token.getText(), ((Var_definitionContext)_localctx).type.ast));
			                        }

			                        _localctx.ast.add( new VarDefinition(token.getLine(), token.getCharPositionInLine() + 1,
			                                token.getText(), ((Var_definitionContext)_localctx).type.ast ));
			                        });
			                    ;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_definitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public List<VarDefinition> bodyVarDefs = new ArrayList<VarDefinition>();
		public List<Statement> bodyStmt = new ArrayList<Statement>();
		public Token ID;
		public Function_parametersContext function_parameters;
		public Built_in_typesContext built_in_types;
		public Var_definitionContext vd;
		public StatementContext statement;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public Built_in_typesContext built_in_types() {
			return getRuleContext(Built_in_typesContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_definition);
		int _la;
		try {
			int _alt;
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(T__0);
				setState(92);
				((Function_definitionContext)_localctx).ID = match(ID);
				setState(93);
				match(T__2);
				setState(94);
				((Function_definitionContext)_localctx).function_parameters = function_parameters();
				setState(95);
				match(T__3);
				setState(96);
				match(T__4);
				{
				setState(97);
				((Function_definitionContext)_localctx).built_in_types = built_in_types();
				}
				setState(98);
				match(T__6);
				setState(99);
				match(T__7);
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(100);
						((Function_definitionContext)_localctx).vd = var_definition();
						_localctx.bodyVarDefs.addAll(((Function_definitionContext)_localctx).vd.ast);
						}
						} 
					}
					setState(107);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32667521351688L) != 0)) {
					{
					{
					setState(108);
					((Function_definitionContext)_localctx).statement = statement();
					_localctx.bodyStmt.addAll(((Function_definitionContext)_localctx).statement.ast);
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(116);
				match(T__8);
				_localctx.ast.add(new FunctionDefinition(
				                            ((Function_definitionContext)_localctx).ID.getLine(), ((Function_definitionContext)_localctx).ID.getCharPositionInLine() + 1, (((Function_definitionContext)_localctx).ID!=null?((Function_definitionContext)_localctx).ID.getText():null),
				                            new FunctionType( ((Function_definitionContext)_localctx).built_in_types.ast, ((Function_definitionContext)_localctx).function_parameters.ast), _localctx.bodyVarDefs, _localctx.bodyStmt )); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				match(T__0);
				setState(120);
				((Function_definitionContext)_localctx).ID = match(ID);
				setState(121);
				match(T__2);
				setState(122);
				((Function_definitionContext)_localctx).function_parameters = function_parameters();
				setState(123);
				match(T__3);
				setState(124);
				match(T__4);
				setState(125);
				match(T__5);
				setState(126);
				match(T__6);
				setState(127);
				match(T__7);
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(128);
						((Function_definitionContext)_localctx).vd = var_definition();
						_localctx.bodyVarDefs.addAll(((Function_definitionContext)_localctx).vd.ast);
						}
						} 
					}
					setState(135);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32667521351688L) != 0)) {
					{
					{
					setState(136);
					((Function_definitionContext)_localctx).statement = statement();
					_localctx.bodyStmt.addAll(((Function_definitionContext)_localctx).statement.ast);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(144);
				match(T__8);
				_localctx.ast.add(new FunctionDefinition(
				                            ((Function_definitionContext)_localctx).ID.getLine(), ((Function_definitionContext)_localctx).ID.getCharPositionInLine() + 1, (((Function_definitionContext)_localctx).ID!=null?((Function_definitionContext)_localctx).ID.getText():null),
				                            new FunctionType( VoidType.getInstance(), ((Function_definitionContext)_localctx).function_parameters.ast), _localctx.bodyVarDefs, _localctx.bodyStmt )); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_parametersContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();
		public Token id1;
		public Built_in_typesContext t1;
		public Token id2;
		public Built_in_typesContext t2;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public List<Built_in_typesContext> built_in_types() {
			return getRuleContexts(Built_in_typesContext.class);
		}
		public Built_in_typesContext built_in_types(int i) {
			return getRuleContext(Built_in_typesContext.class,i);
		}
		public Function_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameters; }
	}

	public final Function_parametersContext function_parameters() throws RecognitionException {
		Function_parametersContext _localctx = new Function_parametersContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_parameters);
		int _la;
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(149);
				((Function_parametersContext)_localctx).id1 = match(ID);
				setState(150);
				match(T__6);
				setState(151);
				((Function_parametersContext)_localctx).t1 = built_in_types();
				_localctx.ast.add(
				            new VarDefinition(
				                ((Function_parametersContext)_localctx).id1.getLine(),
				                ((Function_parametersContext)_localctx).id1.getCharPositionInLine() + 1,
				                ((Function_parametersContext)_localctx).id1.getText(),
				                ((Function_parametersContext)_localctx).t1.ast)
				            );
				        
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(154);
					match(T__9);
					setState(155);
					((Function_parametersContext)_localctx).id2 = match(ID);
					setState(156);
					match(T__6);
					setState(157);
					((Function_parametersContext)_localctx).t2 = built_in_types();
					_localctx.ast.add(
					            new VarDefinition(
					                ((Function_parametersContext)_localctx).id2.getLine(),
					                ((Function_parametersContext)_localctx).id2.getCharPositionInLine() + 1,
					                ((Function_parametersContext)_localctx).id2.getText(),
					                ((Function_parametersContext)_localctx).t2.ast
					            )
					        );
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public Token ID;
		public Token REAL_CONSTANT;
		public Token INT_CONSTANT;
		public Token CHAR_CONSTANT;
		public ExpressionContext expression;
		public TypeContext type;
		public Expressions_optionalContext e;
		public Token OP;
		public ExpressionContext e2;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Expressions_optionalContext expressions_optional() {
			return getRuleContext(Expressions_optionalContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(169);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(
				                                            ((ExpressionContext)_localctx).ID.getLine(),
				                                            ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                                            (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 2:
				{
				setState(171);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(
				                                    ((ExpressionContext)_localctx).REAL_CONSTANT.getLine(),
				                                    ((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine() + 1,
				                                    LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)) ); 
				}
				break;
			case 3:
				{
				setState(173);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(
				                                        ((ExpressionContext)_localctx).INT_CONSTANT.getLine(),
				                                        ((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine() + 1,
				                                        LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)) ); 
				}
				break;
			case 4:
				{
				setState(175);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(
				                                        ((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(),
				                                        ((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine() + 1,
				                                        LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)) ); 
				}
				break;
			case 5:
				{
				setState(177);
				match(T__2);
				setState(178);
				((ExpressionContext)_localctx).e1 = ((ExpressionContext)_localctx).expression = expression(0);
				setState(179);
				match(T__3);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast;
				}
				break;
			case 6:
				{
				setState(182);
				match(T__2);
				setState(183);
				((ExpressionContext)_localctx).type = type();
				setState(184);
				match(T__3);
				setState(185);
				((ExpressionContext)_localctx).expression = expression(8);
				((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).expression.ast.getLine(), ((ExpressionContext)_localctx).expression.ast.getColumn(),
				                                                                    ((ExpressionContext)_localctx).expression.ast, ((ExpressionContext)_localctx).type.ast);
				}
				break;
			case 7:
				{
				setState(188);
				match(T__14);
				setState(189);
				((ExpressionContext)_localctx).expression = expression(7);
				((ExpressionContext)_localctx).ast =  new Minus(((ExpressionContext)_localctx).expression.ast.getLine(), ((ExpressionContext)_localctx).expression.ast.getColumn(),
				                                                                    ((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 8:
				{
				setState(192);
				match(T__15);
				setState(193);
				((ExpressionContext)_localctx).expression = expression(6);
				((ExpressionContext)_localctx).ast =  new Not(((ExpressionContext)_localctx).expression.ast.getLine(), ((ExpressionContext)_localctx).expression.ast.getColumn(),
				                                                                    ((ExpressionContext)_localctx).expression.ast);
				}
				break;
			case 9:
				{
				setState(196);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(197);
				match(T__2);
				setState(198);
				((ExpressionContext)_localctx).e = expressions_optional();
				setState(199);
				match(T__3);
				((ExpressionContext)_localctx).ast =  new FunctionInvocation(
				                                                       ((ExpressionContext)_localctx).ID.getLine(),
				                                                       ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                                                       new Variable(
				                                                            ((ExpressionContext)_localctx).ID.getLine(),
				                                                            ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                                                            (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)),
				                                                       ((ExpressionContext)_localctx).e.ast
				                                                 );
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(234);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(205);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 917504L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(206);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(6);
						((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(),
						                                                                              ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(210);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__14 || _la==T__19) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(211);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(5);
						((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(),
						                                                                              ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(215);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(216);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(4);
						((ExpressionContext)_localctx).ast =  new Comparison(
						                                                                                              ((ExpressionContext)_localctx).e1.ast.getLine(),
						                                                                                              ((ExpressionContext)_localctx).e1.ast.getColumn(),
						                                                                                              (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(220);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__27) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(3);
						((ExpressionContext)_localctx).ast =  new Logical(
						                                                                              ((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(),
						                                                                              (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(224);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(225);
						match(T__11);
						setState(226);
						((ExpressionContext)_localctx).e2 = ((ExpressionContext)_localctx).expression = expression(0);
						setState(227);
						match(T__12);
						((ExpressionContext)_localctx).ast =  new ArrayAccess(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(),
						                                                                              ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(230);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(231);
						match(T__13);
						setState(232);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new StructAccess(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(),
						                                                                              ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						}
						break;
					}
					} 
				}
				setState(238);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expressions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			((ExpressionsContext)_localctx).e1 = expression(0);
			 _localctx.ast.add(((ExpressionsContext)_localctx).e1.ast); 
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(241);
				match(T__9);
				setState(242);
				((ExpressionsContext)_localctx).e2 = expression(0);
				 _localctx.ast.add(((ExpressionsContext)_localctx).e2.ast); 
				}
				}
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expressions_optionalContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionsContext expressions;
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public Expressions_optionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions_optional; }
	}

	public final Expressions_optionalContext expressions_optional() throws RecognitionException {
		Expressions_optionalContext _localctx = new Expressions_optionalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expressions_optional);
		try {
			setState(254);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__14:
			case T__15:
			case INT_CONSTANT:
			case ID:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				((Expressions_optionalContext)_localctx).expressions = expressions();
				 _localctx.ast.addAll(((Expressions_optionalContext)_localctx).expressions.ast); 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public List<Field> aux;
		public Built_in_typesContext built_in_types;
		public Token INT_CONSTANT;
		public TypeContext type;
		public FieldContext field;
		public Built_in_typesContext built_in_types() {
			return getRuleContext(Built_in_typesContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
			case T__30:
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				((TypeContext)_localctx).built_in_types = built_in_types();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).built_in_types.ast; 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(T__11);
				setState(260);
				((TypeContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				setState(261);
				match(T__12);
				setState(262);
				((TypeContext)_localctx).type = type();
				 ((TypeContext)_localctx).ast =  new Array(LexerHelper.lexemeToInt((((TypeContext)_localctx).INT_CONSTANT!=null?((TypeContext)_localctx).INT_CONSTANT.getText():null)), ((TypeContext)_localctx).type.ast); 
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
				match(T__28);
				setState(266);
				match(T__7);
				((TypeContext)_localctx).aux =  new ArrayList<>();
				setState(271); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(268);
					((TypeContext)_localctx).field = field();
					_localctx.aux.addAll(((TypeContext)_localctx).field.ast);
					}
					}
					setState(273); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(275);
				match(T__8);

				            _localctx.aux.stream()
				                .map(field -> field.name)
				                .distinct()
				                .forEach(name -> {
				                    if (_localctx.aux.stream().filter(f -> f.name.equals(name)).count() > 1) {
				                        new ErrorType("Duplicated field in struct: " + name,
				                                _localctx.aux.stream().filter(f -> f.name.equals(name)).findFirst().get());
				                    }
				                });


				            ((TypeContext)_localctx).ast =  new Struct(_localctx.aux);
				        
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Built_in_typesContext extends ParserRuleContext {
		public Type ast;
		public Built_in_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_types; }
	}

	public final Built_in_typesContext built_in_types() throws RecognitionException {
		Built_in_typesContext _localctx = new Built_in_typesContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_built_in_types);
		try {
			setState(286);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				match(T__29);
				((Built_in_typesContext)_localctx).ast =  Int.getInstance();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(282);
				match(T__30);
				((Built_in_typesContext)_localctx).ast =  Char.getInstance();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 3);
				{
				setState(284);
				match(T__31);
				((Built_in_typesContext)_localctx).ast =  DoubleType.getInstance();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldContext extends ParserRuleContext {
		public List<Field> ast = new ArrayList<Field>();
		public List<Token> tokens = new ArrayList<Token>();
		public Token id1;
		public Token id2;
		public TypeContext t;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(288);
			((FieldContext)_localctx).id1 = match(ID);
			_localctx.tokens.add(((FieldContext)_localctx).id1);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(290);
				match(T__9);
				setState(291);
				((FieldContext)_localctx).id2 = match(ID);
				_localctx.tokens.add(((FieldContext)_localctx).id2);
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(298);
			match(T__6);
			setState(299);
			((FieldContext)_localctx).t = type();
			setState(300);
			match(T__10);

			            for (Token token : _localctx.tokens) {
			                _localctx.ast.add(new Field(token.getLine(), token.getCharPositionInLine() + 1, ((FieldContext)_localctx).t.ast, token.getText()));
			            }
			        
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public List else_;
		public Token K;
		public ExpressionsContext expressions;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public ExpressionContext expression;
		public BlockContext block;
		public ExpressionContext exp;
		public BlockContext b1;
		public BlockContext b2;
		public Token ID;
		public Expressions_optionalContext e;
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public Expressions_optionalContext expressions_optional() {
			return getRuleContext(Expressions_optionalContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				((StatementContext)_localctx).K = match(T__32);
				setState(304);
				((StatementContext)_localctx).expressions = expressions();
				setState(305);
				match(T__10);
				((StatementContext)_localctx).expressions.ast.forEach(exp ->
				                                                _localctx.ast.add(new Write(
				                                                           ((StatementContext)_localctx).K.getLine(),
				                                                           ((StatementContext)_localctx).K.getCharPositionInLine() + 1,
				                                                           exp ))); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				((StatementContext)_localctx).K = match(T__33);
				setState(309);
				((StatementContext)_localctx).expressions = expressions();
				setState(310);
				match(T__10);
				((StatementContext)_localctx).expressions.ast.forEach(exp ->
				                                                 _localctx.ast.add(new Read(
				                                                           ((StatementContext)_localctx).K.getLine(),
				                                                           ((StatementContext)_localctx).K.getCharPositionInLine() + 1,
				                                                           exp ))); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				((StatementContext)_localctx).e1 = expression(0);
				setState(314);
				match(T__34);
				setState(315);
				((StatementContext)_localctx).e2 = expression(0);
				setState(316);
				match(T__10);
				_localctx.ast.add(new Assigment(
				                                                             ((StatementContext)_localctx).e1.ast.getLine(),
				                                                             ((StatementContext)_localctx).e1.ast.getColumn(),
				                                                             ((StatementContext)_localctx).e1.ast,
				                                                             ((StatementContext)_localctx).e2.ast )); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(319);
				match(T__35);
				setState(320);
				((StatementContext)_localctx).expression = expression(0);
				setState(321);
				match(T__6);
				setState(322);
				((StatementContext)_localctx).block = block();
				_localctx.ast.add(new While(
				                                                             ((StatementContext)_localctx).expression.ast.getLine(),
				                                                             ((StatementContext)_localctx).expression.ast.getColumn(),
				                                                             ((StatementContext)_localctx).expression.ast,
				                                                             ((StatementContext)_localctx).block.ast )); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(325);
				match(T__36);
				setState(326);
				((StatementContext)_localctx).exp = expression(0);
				setState(327);
				match(T__6);
				setState(328);
				((StatementContext)_localctx).b1 = block();
				((StatementContext)_localctx).else_ =  new ArrayList<>();
				setState(335);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(330);
					match(T__37);
					setState(331);
					match(T__6);
					setState(332);
					((StatementContext)_localctx).b2 = block();
					((StatementContext)_localctx).else_ =  ((StatementContext)_localctx).b2.ast;
					}
					break;
				}
				_localctx.ast.add(new IfElse(((StatementContext)_localctx).exp.ast.getLine(), ((StatementContext)_localctx).exp.ast.getColumn(), ((StatementContext)_localctx).exp.ast, ((StatementContext)_localctx).b1.ast, _localctx.else_));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(339);
				match(T__38);
				setState(340);
				((StatementContext)_localctx).expression = expression(0);
				setState(341);
				match(T__10);
				_localctx.ast.add(new Return(
				                                                             ((StatementContext)_localctx).expression.ast.getLine(),
				                                                             ((StatementContext)_localctx).expression.ast.getColumn(),
				                                                             ((StatementContext)_localctx).expression.ast )); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(344);
				((StatementContext)_localctx).ID = match(ID);
				setState(345);
				match(T__2);
				setState(346);
				((StatementContext)_localctx).e = expressions_optional();
				setState(347);
				match(T__3);
				setState(348);
				match(T__10);
				_localctx.ast.add(new FunctionInvocation(
				                                                             ((StatementContext)_localctx).ID.getLine(),
				                                                             ((StatementContext)_localctx).ID.getCharPositionInLine() + 1,
				                                                             new Variable(
				                                                                    ((StatementContext)_localctx).ID.getLine(),
				                                                                    ((StatementContext)_localctx).ID.getCharPositionInLine() + 1,
				                                                                    (((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null)),
				                                                             ((StatementContext)_localctx).e.ast )); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext statement;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block);
		int _la;
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__14:
			case T__15:
			case T__32:
			case T__33:
			case T__35:
			case T__36:
			case T__38:
			case INT_CONSTANT:
			case ID:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				((BlockContext)_localctx).statement = statement();
				 _localctx.ast.addAll(((BlockContext)_localctx).statement.ast); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				match(T__7);
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32667521351688L) != 0)) {
					{
					{
					setState(357);
					((BlockContext)_localctx).statement = statement();
					 _localctx.ast.addAll(((BlockContext)_localctx).statement.ast); 
					}
					}
					setState(364);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(365);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u0171\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		" \b\u0000\n\u0000\f\u0000#\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00015\b\u0001\n\u0001\f\u00018\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001=\b\u0001\n\u0001\f\u0001@\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002K\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003R\b\u0003"+
		"\n\u0003\f\u0003U\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004h\b\u0004\n\u0004\f\u0004k\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004p\b\u0004\n\u0004\f\u0004s\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u0084\b\u0004\n\u0004"+
		"\f\u0004\u0087\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"\u008c\b\u0004\n\u0004\f\u0004\u008f\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004\u0094\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005\u00a1\b\u0005\n\u0005\f\u0005\u00a4\t\u0005"+
		"\u0001\u0005\u0003\u0005\u00a7\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00cb\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00eb\b\u0006\n\u0006"+
		"\f\u0006\u00ee\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u00f6\b\u0007\n\u0007\f\u0007\u00f9"+
		"\t\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ff\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u0110\b\t\u000b\t\f\t\u0111"+
		"\u0001\t\u0001\t\u0001\t\u0003\t\u0117\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u011f\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u0126\b\u000b\n\u000b\f\u000b\u0129"+
		"\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0150\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0160\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u0169\b\r\n\r\f\r\u016c\t\r\u0001\r\u0003\r"+
		"\u016f\b\r\u0001\r\u0000\u0001\f\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0004\u0001\u0000\u0011\u0013"+
		"\u0002\u0000\u000f\u000f\u0014\u0014\u0001\u0000\u0015\u001a\u0001\u0000"+
		"\u001b\u001c\u018d\u0000!\u0001\u0000\u0000\u0000\u0002)\u0001\u0000\u0000"+
		"\u0000\u0004J\u0001\u0000\u0000\u0000\u0006L\u0001\u0000\u0000\u0000\b"+
		"\u0093\u0001\u0000\u0000\u0000\n\u00a6\u0001\u0000\u0000\u0000\f\u00ca"+
		"\u0001\u0000\u0000\u0000\u000e\u00ef\u0001\u0000\u0000\u0000\u0010\u00fe"+
		"\u0001\u0000\u0000\u0000\u0012\u0116\u0001\u0000\u0000\u0000\u0014\u011e"+
		"\u0001\u0000\u0000\u0000\u0016\u0120\u0001\u0000\u0000\u0000\u0018\u015f"+
		"\u0001\u0000\u0000\u0000\u001a\u016e\u0001\u0000\u0000\u0000\u001c\u001d"+
		"\u0003\u0004\u0002\u0000\u001d\u001e\u0006\u0000\uffff\uffff\u0000\u001e"+
		" \u0001\u0000\u0000\u0000\u001f\u001c\u0001\u0000\u0000\u0000 #\u0001"+
		"\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000"+
		"\u0000\"$\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0003\u0002"+
		"\u0001\u0000%&\u0006\u0000\uffff\uffff\u0000&\'\u0005\u0000\u0000\u0001"+
		"\'(\u0006\u0000\uffff\uffff\u0000(\u0001\u0001\u0000\u0000\u0000)*\u0005"+
		"\u0001\u0000\u0000*+\u0005\u0002\u0000\u0000+,\u0005\u0003\u0000\u0000"+
		",-\u0005\u0004\u0000\u0000-.\u0005\u0005\u0000\u0000./\u0005\u0006\u0000"+
		"\u0000/0\u0005\u0007\u0000\u000006\u0005\b\u0000\u000012\u0003\u0006\u0003"+
		"\u000023\u0006\u0001\uffff\uffff\u000035\u0001\u0000\u0000\u000041\u0001"+
		"\u0000\u0000\u000058\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u0000"+
		"67\u0001\u0000\u0000\u00007>\u0001\u0000\u0000\u000086\u0001\u0000\u0000"+
		"\u00009:\u0003\u0018\f\u0000:;\u0006\u0001\uffff\uffff\u0000;=\u0001\u0000"+
		"\u0000\u0000<9\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000AB\u0005\t\u0000\u0000BC\u0006\u0001\uffff\uffff"+
		"\u0000C\u0003\u0001\u0000\u0000\u0000DE\u0003\u0006\u0003\u0000EF\u0006"+
		"\u0002\uffff\uffff\u0000FK\u0001\u0000\u0000\u0000GH\u0003\b\u0004\u0000"+
		"HI\u0006\u0002\uffff\uffff\u0000IK\u0001\u0000\u0000\u0000JD\u0001\u0000"+
		"\u0000\u0000JG\u0001\u0000\u0000\u0000K\u0005\u0001\u0000\u0000\u0000"+
		"LM\u0005*\u0000\u0000MS\u0006\u0003\uffff\uffff\u0000NO\u0005\n\u0000"+
		"\u0000OP\u0005*\u0000\u0000PR\u0006\u0003\uffff\uffff\u0000QN\u0001\u0000"+
		"\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001"+
		"\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"VW\u0005\u0007\u0000\u0000WX\u0003\u0012\t\u0000XY\u0005\u000b\u0000\u0000"+
		"YZ\u0006\u0003\uffff\uffff\u0000Z\u0007\u0001\u0000\u0000\u0000[\\\u0005"+
		"\u0001\u0000\u0000\\]\u0005*\u0000\u0000]^\u0005\u0003\u0000\u0000^_\u0003"+
		"\n\u0005\u0000_`\u0005\u0004\u0000\u0000`a\u0005\u0005\u0000\u0000ab\u0003"+
		"\u0014\n\u0000bc\u0005\u0007\u0000\u0000ci\u0005\b\u0000\u0000de\u0003"+
		"\u0006\u0003\u0000ef\u0006\u0004\uffff\uffff\u0000fh\u0001\u0000\u0000"+
		"\u0000gd\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000jq\u0001\u0000\u0000\u0000ki\u0001"+
		"\u0000\u0000\u0000lm\u0003\u0018\f\u0000mn\u0006\u0004\uffff\uffff\u0000"+
		"np\u0001\u0000\u0000\u0000ol\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005\t\u0000\u0000uv\u0006\u0004"+
		"\uffff\uffff\u0000v\u0094\u0001\u0000\u0000\u0000wx\u0005\u0001\u0000"+
		"\u0000xy\u0005*\u0000\u0000yz\u0005\u0003\u0000\u0000z{\u0003\n\u0005"+
		"\u0000{|\u0005\u0004\u0000\u0000|}\u0005\u0005\u0000\u0000}~\u0005\u0006"+
		"\u0000\u0000~\u007f\u0005\u0007\u0000\u0000\u007f\u0085\u0005\b\u0000"+
		"\u0000\u0080\u0081\u0003\u0006\u0003\u0000\u0081\u0082\u0006\u0004\uffff"+
		"\uffff\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u0083\u0080\u0001\u0000"+
		"\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u008d\u0001\u0000"+
		"\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0003\u0018"+
		"\f\u0000\u0089\u008a\u0006\u0004\uffff\uffff\u0000\u008a\u008c\u0001\u0000"+
		"\u0000\u0000\u008b\u0088\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0005\t\u0000\u0000\u0091\u0092\u0006\u0004\uffff"+
		"\uffff\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093[\u0001\u0000\u0000"+
		"\u0000\u0093w\u0001\u0000\u0000\u0000\u0094\t\u0001\u0000\u0000\u0000"+
		"\u0095\u0096\u0005*\u0000\u0000\u0096\u0097\u0005\u0007\u0000\u0000\u0097"+
		"\u0098\u0003\u0014\n\u0000\u0098\u0099\u0006\u0005\uffff\uffff\u0000\u0099"+
		"\u00a2\u0001\u0000\u0000\u0000\u009a\u009b\u0005\n\u0000\u0000\u009b\u009c"+
		"\u0005*\u0000\u0000\u009c\u009d\u0005\u0007\u0000\u0000\u009d\u009e\u0003"+
		"\u0014\n\u0000\u009e\u009f\u0006\u0005\uffff\uffff\u0000\u009f\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a0\u009a\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a7\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a7\u0001\u0000\u0000\u0000\u00a6\u0095\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u000b\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0006\u0006\uffff\uffff\u0000\u00a9\u00aa"+
		"\u0005*\u0000\u0000\u00aa\u00cb\u0006\u0006\uffff\uffff\u0000\u00ab\u00ac"+
		"\u0005+\u0000\u0000\u00ac\u00cb\u0006\u0006\uffff\uffff\u0000\u00ad\u00ae"+
		"\u0005(\u0000\u0000\u00ae\u00cb\u0006\u0006\uffff\uffff\u0000\u00af\u00b0"+
		"\u0005,\u0000\u0000\u00b0\u00cb\u0006\u0006\uffff\uffff\u0000\u00b1\u00b2"+
		"\u0005\u0003\u0000\u0000\u00b2\u00b3\u0003\f\u0006\u0000\u00b3\u00b4\u0005"+
		"\u0004\u0000\u0000\u00b4\u00b5\u0006\u0006\uffff\uffff\u0000\u00b5\u00cb"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0003\u0000\u0000\u00b7\u00b8"+
		"\u0003\u0012\t\u0000\u00b8\u00b9\u0005\u0004\u0000\u0000\u00b9\u00ba\u0003"+
		"\f\u0006\b\u00ba\u00bb\u0006\u0006\uffff\uffff\u0000\u00bb\u00cb\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0005\u000f\u0000\u0000\u00bd\u00be\u0003"+
		"\f\u0006\u0007\u00be\u00bf\u0006\u0006\uffff\uffff\u0000\u00bf\u00cb\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0005\u0010\u0000\u0000\u00c1\u00c2\u0003"+
		"\f\u0006\u0006\u00c2\u00c3\u0006\u0006\uffff\uffff\u0000\u00c3\u00cb\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0005*\u0000\u0000\u00c5\u00c6\u0005\u0003"+
		"\u0000\u0000\u00c6\u00c7\u0003\u0010\b\u0000\u00c7\u00c8\u0005\u0004\u0000"+
		"\u0000\u00c8\u00c9\u0006\u0006\uffff\uffff\u0000\u00c9\u00cb\u0001\u0000"+
		"\u0000\u0000\u00ca\u00a8\u0001\u0000\u0000\u0000\u00ca\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ca\u00ad\u0001\u0000\u0000\u0000\u00ca\u00af\u0001\u0000"+
		"\u0000\u0000\u00ca\u00b1\u0001\u0000\u0000\u0000\u00ca\u00b6\u0001\u0000"+
		"\u0000\u0000\u00ca\u00bc\u0001\u0000\u0000\u0000\u00ca\u00c0\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c4\u0001\u0000\u0000\u0000\u00cb\u00ec\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\n\u0005\u0000\u0000\u00cd\u00ce\u0007\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0003\f\u0006\u0006\u00cf\u00d0\u0006\u0006\uffff\uffff"+
		"\u0000\u00d0\u00eb\u0001\u0000\u0000\u0000\u00d1\u00d2\n\u0004\u0000\u0000"+
		"\u00d2\u00d3\u0007\u0001\u0000\u0000\u00d3\u00d4\u0003\f\u0006\u0005\u00d4"+
		"\u00d5\u0006\u0006\uffff\uffff\u0000\u00d5\u00eb\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d7\n\u0003\u0000\u0000\u00d7\u00d8\u0007\u0002\u0000\u0000\u00d8"+
		"\u00d9\u0003\f\u0006\u0004\u00d9\u00da\u0006\u0006\uffff\uffff\u0000\u00da"+
		"\u00eb\u0001\u0000\u0000\u0000\u00db\u00dc\n\u0002\u0000\u0000\u00dc\u00dd"+
		"\u0007\u0003\u0000\u0000\u00dd\u00de\u0003\f\u0006\u0003\u00de\u00df\u0006"+
		"\u0006\uffff\uffff\u0000\u00df\u00eb\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\n\n\u0000\u0000\u00e1\u00e2\u0005\f\u0000\u0000\u00e2\u00e3\u0003\f\u0006"+
		"\u0000\u00e3\u00e4\u0005\r\u0000\u0000\u00e4\u00e5\u0006\u0006\uffff\uffff"+
		"\u0000\u00e5\u00eb\u0001\u0000\u0000\u0000\u00e6\u00e7\n\t\u0000\u0000"+
		"\u00e7\u00e8\u0005\u000e\u0000\u0000\u00e8\u00e9\u0005*\u0000\u0000\u00e9"+
		"\u00eb\u0006\u0006\uffff\uffff\u0000\u00ea\u00cc\u0001\u0000\u0000\u0000"+
		"\u00ea\u00d1\u0001\u0000\u0000\u0000\u00ea\u00d6\u0001\u0000\u0000\u0000"+
		"\u00ea\u00db\u0001\u0000\u0000\u0000\u00ea\u00e0\u0001\u0000\u0000\u0000"+
		"\u00ea\u00e6\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ed\r\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0003\f\u0006\u0000\u00f0\u00f7\u0006\u0007\uffff\uffff\u0000\u00f1"+
		"\u00f2\u0005\n\u0000\u0000\u00f2\u00f3\u0003\f\u0006\u0000\u00f3\u00f4"+
		"\u0006\u0007\uffff\uffff\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8"+
		"\u000f\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0003\u000e\u0007\u0000\u00fb\u00fc\u0006\b\uffff\uffff\u0000\u00fc"+
		"\u00ff\u0001\u0000\u0000\u0000\u00fd\u00ff\u0001\u0000\u0000\u0000\u00fe"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff"+
		"\u0011\u0001\u0000\u0000\u0000\u0100\u0101\u0003\u0014\n\u0000\u0101\u0102"+
		"\u0006\t\uffff\uffff\u0000\u0102\u0117\u0001\u0000\u0000\u0000\u0103\u0104"+
		"\u0005\f\u0000\u0000\u0104\u0105\u0005(\u0000\u0000\u0105\u0106\u0005"+
		"\r\u0000\u0000\u0106\u0107\u0003\u0012\t\u0000\u0107\u0108\u0006\t\uffff"+
		"\uffff\u0000\u0108\u0117\u0001\u0000\u0000\u0000\u0109\u010a\u0005\u001d"+
		"\u0000\u0000\u010a\u010b\u0005\b\u0000\u0000\u010b\u010f\u0006\t\uffff"+
		"\uffff\u0000\u010c\u010d\u0003\u0016\u000b\u0000\u010d\u010e\u0006\t\uffff"+
		"\uffff\u0000\u010e\u0110\u0001\u0000\u0000\u0000\u010f\u010c\u0001\u0000"+
		"\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000"+
		"\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000"+
		"\u0000\u0000\u0113\u0114\u0005\t\u0000\u0000\u0114\u0115\u0006\t\uffff"+
		"\uffff\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116\u0100\u0001\u0000"+
		"\u0000\u0000\u0116\u0103\u0001\u0000\u0000\u0000\u0116\u0109\u0001\u0000"+
		"\u0000\u0000\u0117\u0013\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u001e"+
		"\u0000\u0000\u0119\u011f\u0006\n\uffff\uffff\u0000\u011a\u011b\u0005\u001f"+
		"\u0000\u0000\u011b\u011f\u0006\n\uffff\uffff\u0000\u011c\u011d\u0005 "+
		"\u0000\u0000\u011d\u011f\u0006\n\uffff\uffff\u0000\u011e\u0118\u0001\u0000"+
		"\u0000\u0000\u011e\u011a\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000"+
		"\u0000\u0000\u011f\u0015\u0001\u0000\u0000\u0000\u0120\u0121\u0005*\u0000"+
		"\u0000\u0121\u0127\u0006\u000b\uffff\uffff\u0000\u0122\u0123\u0005\n\u0000"+
		"\u0000\u0123\u0124\u0005*\u0000\u0000\u0124\u0126\u0006\u000b\uffff\uffff"+
		"\u0000\u0125\u0122\u0001\u0000\u0000\u0000\u0126\u0129\u0001\u0000\u0000"+
		"\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000"+
		"\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000"+
		"\u0000\u012a\u012b\u0005\u0007\u0000\u0000\u012b\u012c\u0003\u0012\t\u0000"+
		"\u012c\u012d\u0005\u000b\u0000\u0000\u012d\u012e\u0006\u000b\uffff\uffff"+
		"\u0000\u012e\u0017\u0001\u0000\u0000\u0000\u012f\u0130\u0005!\u0000\u0000"+
		"\u0130\u0131\u0003\u000e\u0007\u0000\u0131\u0132\u0005\u000b\u0000\u0000"+
		"\u0132\u0133\u0006\f\uffff\uffff\u0000\u0133\u0160\u0001\u0000\u0000\u0000"+
		"\u0134\u0135\u0005\"\u0000\u0000\u0135\u0136\u0003\u000e\u0007\u0000\u0136"+
		"\u0137\u0005\u000b\u0000\u0000\u0137\u0138\u0006\f\uffff\uffff\u0000\u0138"+
		"\u0160\u0001\u0000\u0000\u0000\u0139\u013a\u0003\f\u0006\u0000\u013a\u013b"+
		"\u0005#\u0000\u0000\u013b\u013c\u0003\f\u0006\u0000\u013c\u013d\u0005"+
		"\u000b\u0000\u0000\u013d\u013e\u0006\f\uffff\uffff\u0000\u013e\u0160\u0001"+
		"\u0000\u0000\u0000\u013f\u0140\u0005$\u0000\u0000\u0140\u0141\u0003\f"+
		"\u0006\u0000\u0141\u0142\u0005\u0007\u0000\u0000\u0142\u0143\u0003\u001a"+
		"\r\u0000\u0143\u0144\u0006\f\uffff\uffff\u0000\u0144\u0160\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u0005%\u0000\u0000\u0146\u0147\u0003\f\u0006"+
		"\u0000\u0147\u0148\u0005\u0007\u0000\u0000\u0148\u0149\u0003\u001a\r\u0000"+
		"\u0149\u014f\u0006\f\uffff\uffff\u0000\u014a\u014b\u0005&\u0000\u0000"+
		"\u014b\u014c\u0005\u0007\u0000\u0000\u014c\u014d\u0003\u001a\r\u0000\u014d"+
		"\u014e\u0006\f\uffff\uffff\u0000\u014e\u0150\u0001\u0000\u0000\u0000\u014f"+
		"\u014a\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150"+
		"\u0151\u0001\u0000\u0000\u0000\u0151\u0152\u0006\f\uffff\uffff\u0000\u0152"+
		"\u0160\u0001\u0000\u0000\u0000\u0153\u0154\u0005\'\u0000\u0000\u0154\u0155"+
		"\u0003\f\u0006\u0000\u0155\u0156\u0005\u000b\u0000\u0000\u0156\u0157\u0006"+
		"\f\uffff\uffff\u0000\u0157\u0160\u0001\u0000\u0000\u0000\u0158\u0159\u0005"+
		"*\u0000\u0000\u0159\u015a\u0005\u0003\u0000\u0000\u015a\u015b\u0003\u0010"+
		"\b\u0000\u015b\u015c\u0005\u0004\u0000\u0000\u015c\u015d\u0005\u000b\u0000"+
		"\u0000\u015d\u015e\u0006\f\uffff\uffff\u0000\u015e\u0160\u0001\u0000\u0000"+
		"\u0000\u015f\u012f\u0001\u0000\u0000\u0000\u015f\u0134\u0001\u0000\u0000"+
		"\u0000\u015f\u0139\u0001\u0000\u0000\u0000\u015f\u013f\u0001\u0000\u0000"+
		"\u0000\u015f\u0145\u0001\u0000\u0000\u0000\u015f\u0153\u0001\u0000\u0000"+
		"\u0000\u015f\u0158\u0001\u0000\u0000\u0000\u0160\u0019\u0001\u0000\u0000"+
		"\u0000\u0161\u0162\u0003\u0018\f\u0000\u0162\u0163\u0006\r\uffff\uffff"+
		"\u0000\u0163\u016f\u0001\u0000\u0000\u0000\u0164\u016a\u0005\b\u0000\u0000"+
		"\u0165\u0166\u0003\u0018\f\u0000\u0166\u0167\u0006\r\uffff\uffff\u0000"+
		"\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u0165\u0001\u0000\u0000\u0000"+
		"\u0169\u016c\u0001\u0000\u0000\u0000\u016a\u0168\u0001\u0000\u0000\u0000"+
		"\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u016d\u0001\u0000\u0000\u0000"+
		"\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u016f\u0005\t\u0000\u0000\u016e"+
		"\u0161\u0001\u0000\u0000\u0000\u016e\u0164\u0001\u0000\u0000\u0000\u016f"+
		"\u001b\u0001\u0000\u0000\u0000\u0019!6>JSiq\u0085\u008d\u0093\u00a2\u00a6"+
		"\u00ca\u00ea\u00ec\u00f7\u00fe\u0111\u0116\u011e\u0127\u014f\u015f\u016a"+
		"\u016e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}