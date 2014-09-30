package org.antlr.ext.ConditionExpression.Generated;
// $ANTLR 3.5.2 Expression.g 2014-09-01 15:44:05

import org.antlr.runtime.*;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ExpressionParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "COMMA", "DATA", "DIV", 
		"Digit", "EQUALS", "EXPRESSION", "FIELD", "FUNCTION", "GT", "GTEQ", "IDENTIFIER", 
		"INDEX", "LBRACKET", "LETTER", "LPAREN", "LT", "LTEQ", "MEMBERACCESS", 
		"MINUS", "MUL", "NOT", "NOTEQUALS", "OR", "PLUS", "POW", "RBRACKET", "RPAREN", 
		"TYPE_BOOLEAN", "TYPE_DATETIME", "TYPE_DOUBLE", "TYPE_INTEGER", "TYPE_STRING", 
		"UNARY", "WS", "ZERO", "'.'"
	};
	public static final int EOF=-1;
	public static final int T__40=40;
	public static final int AND=4;
	public static final int COMMA=5;
	public static final int DATA=6;
	public static final int DIV=7;
	public static final int Digit=8;
	public static final int EQUALS=9;
	public static final int EXPRESSION=10;
	public static final int FIELD=11;
	public static final int FUNCTION=12;
	public static final int GT=13;
	public static final int GTEQ=14;
	public static final int IDENTIFIER=15;
	public static final int INDEX=16;
	public static final int LBRACKET=17;
	public static final int LETTER=18;
	public static final int LPAREN=19;
	public static final int LT=20;
	public static final int LTEQ=21;
	public static final int MEMBERACCESS=22;
	public static final int MINUS=23;
	public static final int MUL=24;
	public static final int NOT=25;
	public static final int NOTEQUALS=26;
	public static final int OR=27;
	public static final int PLUS=28;
	public static final int POW=29;
	public static final int RBRACKET=30;
	public static final int RPAREN=31;
	public static final int TYPE_BOOLEAN=32;
	public static final int TYPE_DATETIME=33;
	public static final int TYPE_DOUBLE=34;
	public static final int TYPE_INTEGER=35;
	public static final int TYPE_STRING=36;
	public static final int UNARY=37;
	public static final int WS=38;
	public static final int ZERO=39;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExpressionParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExpressionParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ExpressionParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Expression.g"; }


	public static class expression_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// Expression.g:29:1: public expression : expr EOF !;
	public final ExpressionParser.expression_return expression() throws RecognitionException {
		ExpressionParser.expression_return retval = new ExpressionParser.expression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken EOF2=null;
		ParserRuleReturnScope expr1 =null;

		CommonTree EOF2_tree=null;

		try {
			// Expression.g:30:2: ( expr EOF !)
			// Expression.g:30:4: expr EOF !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_expression111);
			expr1=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr1.getTree());

			EOF2=(CommonToken)match(input,EOF,FOLLOW_EOF_in_expression113); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr"
	// Expression.g:33:1: expr : logicalOrExpr ;
	public final ExpressionParser.expr_return expr() throws RecognitionException {
		ExpressionParser.expr_return retval = new ExpressionParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope logicalOrExpr3 =null;


		try {
			// Expression.g:34:2: ( logicalOrExpr )
			// Expression.g:34:4: logicalOrExpr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_logicalOrExpr_in_expr125);
			logicalOrExpr3=logicalOrExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalOrExpr3.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expr"


	public static class logicalOrExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logicalOrExpr"
	// Expression.g:37:1: logicalOrExpr : logicalAndExpr ( OR ^ logicalAndExpr )* ;
	public final ExpressionParser.logicalOrExpr_return logicalOrExpr() throws RecognitionException {
		ExpressionParser.logicalOrExpr_return retval = new ExpressionParser.logicalOrExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken OR5=null;
		ParserRuleReturnScope logicalAndExpr4 =null;
		ParserRuleReturnScope logicalAndExpr6 =null;

		CommonTree OR5_tree=null;

		try {
			// Expression.g:38:2: ( logicalAndExpr ( OR ^ logicalAndExpr )* )
			// Expression.g:38:4: logicalAndExpr ( OR ^ logicalAndExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_logicalAndExpr_in_logicalOrExpr138);
			logicalAndExpr4=logicalAndExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalAndExpr4.getTree());

			// Expression.g:38:19: ( OR ^ logicalAndExpr )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==OR) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// Expression.g:38:20: OR ^ logicalAndExpr
					{
					OR5=(CommonToken)match(input,OR,FOLLOW_OR_in_logicalOrExpr141); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					OR5_tree = (CommonTree)adaptor.create(OR5);
					root_0 = (CommonTree)adaptor.becomeRoot(OR5_tree, root_0);
					}

					pushFollow(FOLLOW_logicalAndExpr_in_logicalOrExpr144);
					logicalAndExpr6=logicalAndExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalAndExpr6.getTree());

					}
					break;

				default :
					break loop1;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "logicalOrExpr"


	public static class logicalAndExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logicalAndExpr"
	// Expression.g:41:1: logicalAndExpr : equalityExpr ( AND ^ equalityExpr )* ;
	public final ExpressionParser.logicalAndExpr_return logicalAndExpr() throws RecognitionException {
		ExpressionParser.logicalAndExpr_return retval = new ExpressionParser.logicalAndExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken AND8=null;
		ParserRuleReturnScope equalityExpr7 =null;
		ParserRuleReturnScope equalityExpr9 =null;

		CommonTree AND8_tree=null;

		try {
			// Expression.g:42:2: ( equalityExpr ( AND ^ equalityExpr )* )
			// Expression.g:42:4: equalityExpr ( AND ^ equalityExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_equalityExpr_in_logicalAndExpr182);
			equalityExpr7=equalityExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpr7.getTree());

			// Expression.g:42:17: ( AND ^ equalityExpr )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==AND) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// Expression.g:42:18: AND ^ equalityExpr
					{
					AND8=(CommonToken)match(input,AND,FOLLOW_AND_in_logicalAndExpr185); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					AND8_tree = (CommonTree)adaptor.create(AND8);
					root_0 = (CommonTree)adaptor.becomeRoot(AND8_tree, root_0);
					}

					pushFollow(FOLLOW_equalityExpr_in_logicalAndExpr188);
					equalityExpr9=equalityExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpr9.getTree());

					}
					break;

				default :
					break loop2;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "logicalAndExpr"


	public static class equalityExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "equalityExpr"
	// Expression.g:45:1: equalityExpr : relationalExpr ( ( EQUALS | NOTEQUALS ) ^ relationalExpr )* ;
	public final ExpressionParser.equalityExpr_return equalityExpr() throws RecognitionException {
		ExpressionParser.equalityExpr_return retval = new ExpressionParser.equalityExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set11=null;
		ParserRuleReturnScope relationalExpr10 =null;
		ParserRuleReturnScope relationalExpr12 =null;

		CommonTree set11_tree=null;

		try {
			// Expression.g:46:2: ( relationalExpr ( ( EQUALS | NOTEQUALS ) ^ relationalExpr )* )
			// Expression.g:46:4: relationalExpr ( ( EQUALS | NOTEQUALS ) ^ relationalExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_relationalExpr_in_equalityExpr228);
			relationalExpr10=relationalExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpr10.getTree());

			// Expression.g:46:19: ( ( EQUALS | NOTEQUALS ) ^ relationalExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==EQUALS||LA3_0==NOTEQUALS) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// Expression.g:46:20: ( EQUALS | NOTEQUALS ) ^ relationalExpr
					{
					set11=(CommonToken)input.LT(1);
					set11=(CommonToken)input.LT(1);
					if ( input.LA(1)==EQUALS||input.LA(1)==NOTEQUALS ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set11), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_relationalExpr_in_equalityExpr238);
					relationalExpr12=relationalExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpr12.getTree());

					}
					break;

				default :
					break loop3;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "equalityExpr"


	public static class relationalExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "relationalExpr"
	// Expression.g:49:1: relationalExpr : additiveExpr ( ( LT | LTEQ | GT | GTEQ ) ^ additiveExpr )? ;
	public final ExpressionParser.relationalExpr_return relationalExpr() throws RecognitionException {
		ExpressionParser.relationalExpr_return retval = new ExpressionParser.relationalExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set14=null;
		ParserRuleReturnScope additiveExpr13 =null;
		ParserRuleReturnScope additiveExpr15 =null;

		CommonTree set14_tree=null;

		try {
			// Expression.g:50:2: ( additiveExpr ( ( LT | LTEQ | GT | GTEQ ) ^ additiveExpr )? )
			// Expression.g:50:4: additiveExpr ( ( LT | LTEQ | GT | GTEQ ) ^ additiveExpr )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_additiveExpr_in_relationalExpr252);
			additiveExpr13=additiveExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpr13.getTree());

			// Expression.g:50:17: ( ( LT | LTEQ | GT | GTEQ ) ^ additiveExpr )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= GT && LA4_0 <= GTEQ)||(LA4_0 >= LT && LA4_0 <= LTEQ)) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// Expression.g:50:18: ( LT | LTEQ | GT | GTEQ ) ^ additiveExpr
					{
					set14=(CommonToken)input.LT(1);
					set14=(CommonToken)input.LT(1);
					if ( (input.LA(1) >= GT && input.LA(1) <= GTEQ)||(input.LA(1) >= LT && input.LA(1) <= LTEQ) ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set14), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_additiveExpr_in_relationalExpr266);
					additiveExpr15=additiveExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpr15.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "relationalExpr"


	public static class additiveExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "additiveExpr"
	// Expression.g:53:1: additiveExpr : multiplyExpr ( ( PLUS | MINUS ) ^ multiplyExpr )* ;
	public final ExpressionParser.additiveExpr_return additiveExpr() throws RecognitionException {
		ExpressionParser.additiveExpr_return retval = new ExpressionParser.additiveExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set17=null;
		ParserRuleReturnScope multiplyExpr16 =null;
		ParserRuleReturnScope multiplyExpr18 =null;

		CommonTree set17_tree=null;

		try {
			// Expression.g:54:2: ( multiplyExpr ( ( PLUS | MINUS ) ^ multiplyExpr )* )
			// Expression.g:54:4: multiplyExpr ( ( PLUS | MINUS ) ^ multiplyExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_multiplyExpr_in_additiveExpr281);
			multiplyExpr16=multiplyExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplyExpr16.getTree());

			// Expression.g:54:17: ( ( PLUS | MINUS ) ^ multiplyExpr )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==MINUS||LA5_0==PLUS) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// Expression.g:54:18: ( PLUS | MINUS ) ^ multiplyExpr
					{
					set17=(CommonToken)input.LT(1);
					set17=(CommonToken)input.LT(1);
					if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set17), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multiplyExpr_in_additiveExpr291);
					multiplyExpr18=multiplyExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplyExpr18.getTree());

					}
					break;

				default :
					break loop5;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "additiveExpr"


	public static class multiplyExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "multiplyExpr"
	// Expression.g:57:1: multiplyExpr : powExpr ( ( MUL | DIV ) ^ powExpr )* ;
	public final ExpressionParser.multiplyExpr_return multiplyExpr() throws RecognitionException {
		ExpressionParser.multiplyExpr_return retval = new ExpressionParser.multiplyExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set20=null;
		ParserRuleReturnScope powExpr19 =null;
		ParserRuleReturnScope powExpr21 =null;

		CommonTree set20_tree=null;

		try {
			// Expression.g:58:4: ( powExpr ( ( MUL | DIV ) ^ powExpr )* )
			// Expression.g:58:6: powExpr ( ( MUL | DIV ) ^ powExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_powExpr_in_multiplyExpr308);
			powExpr19=powExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr19.getTree());

			// Expression.g:58:14: ( ( MUL | DIV ) ^ powExpr )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==DIV||LA6_0==MUL) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// Expression.g:58:15: ( MUL | DIV ) ^ powExpr
					{
					set20=(CommonToken)input.LT(1);
					set20=(CommonToken)input.LT(1);
					if ( input.LA(1)==DIV||input.LA(1)==MUL ) {
						input.consume();
						if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(set20), root_0);
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_powExpr_in_multiplyExpr320);
					powExpr21=powExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, powExpr21.getTree());

					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "multiplyExpr"


	public static class powExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "powExpr"
	// Expression.g:61:1: powExpr : unaryExpr ( POW ^ unaryExpr )* ;
	public final ExpressionParser.powExpr_return powExpr() throws RecognitionException {
		ExpressionParser.powExpr_return retval = new ExpressionParser.powExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken POW23=null;
		ParserRuleReturnScope unaryExpr22 =null;
		ParserRuleReturnScope unaryExpr24 =null;

		CommonTree POW23_tree=null;

		try {
			// Expression.g:62:6: ( unaryExpr ( POW ^ unaryExpr )* )
			// Expression.g:62:10: unaryExpr ( POW ^ unaryExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_unaryExpr_in_powExpr349);
			unaryExpr22=unaryExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr22.getTree());

			// Expression.g:62:20: ( POW ^ unaryExpr )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==POW) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// Expression.g:62:21: POW ^ unaryExpr
					{
					POW23=(CommonToken)match(input,POW,FOLLOW_POW_in_powExpr352); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					POW23_tree = (CommonTree)adaptor.create(POW23);
					root_0 = (CommonTree)adaptor.becomeRoot(POW23_tree, root_0);
					}

					pushFollow(FOLLOW_unaryExpr_in_powExpr355);
					unaryExpr24=unaryExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpr24.getTree());

					}
					break;

				default :
					break loop7;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "powExpr"


	public static class unaryExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unaryExpr"
	// Expression.g:65:1: unaryExpr : ( MINUS memberExpr -> ^( UNARY MINUS memberExpr ) | NOT memberExpr -> ^( UNARY NOT memberExpr ) | PLUS memberExpr -> ^( UNARY PLUS memberExpr ) | memberExpr );
	public final ExpressionParser.unaryExpr_return unaryExpr() throws RecognitionException {
		ExpressionParser.unaryExpr_return retval = new ExpressionParser.unaryExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken MINUS25=null;
		CommonToken NOT27=null;
		CommonToken PLUS29=null;
		ParserRuleReturnScope memberExpr26 =null;
		ParserRuleReturnScope memberExpr28 =null;
		ParserRuleReturnScope memberExpr30 =null;
		ParserRuleReturnScope memberExpr31 =null;

		CommonTree MINUS25_tree=null;
		CommonTree NOT27_tree=null;
		CommonTree PLUS29_tree=null;
		RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
		RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
		RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
		RewriteRuleSubtreeStream stream_memberExpr=new RewriteRuleSubtreeStream(adaptor,"rule memberExpr");

		try {
			// Expression.g:66:2: ( MINUS memberExpr -> ^( UNARY MINUS memberExpr ) | NOT memberExpr -> ^( UNARY NOT memberExpr ) | PLUS memberExpr -> ^( UNARY PLUS memberExpr ) | memberExpr )
			int alt8=4;
			switch ( input.LA(1) ) {
			case MINUS:
				{
				alt8=1;
				}
				break;
			case NOT:
				{
				alt8=2;
				}
				break;
			case PLUS:
				{
				alt8=3;
				}
				break;
			case IDENTIFIER:
			case LPAREN:
			case TYPE_BOOLEAN:
			case TYPE_DATETIME:
			case TYPE_DOUBLE:
			case TYPE_INTEGER:
			case TYPE_STRING:
				{
				alt8=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// Expression.g:66:4: MINUS memberExpr
					{
					MINUS25=(CommonToken)match(input,MINUS,FOLLOW_MINUS_in_unaryExpr372); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_MINUS.add(MINUS25);

					pushFollow(FOLLOW_memberExpr_in_unaryExpr374);
					memberExpr26=memberExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_memberExpr.add(memberExpr26.getTree());
					// AST REWRITE
					// elements: MINUS, memberExpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 66:21: -> ^( UNARY MINUS memberExpr )
					{
						// Expression.g:66:23: ^( UNARY MINUS memberExpr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY, "UNARY"), root_1);
						adaptor.addChild(root_1, stream_MINUS.nextNode());
						adaptor.addChild(root_1, stream_memberExpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// Expression.g:67:5: NOT memberExpr
					{
					NOT27=(CommonToken)match(input,NOT,FOLLOW_NOT_in_unaryExpr389); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_NOT.add(NOT27);

					pushFollow(FOLLOW_memberExpr_in_unaryExpr391);
					memberExpr28=memberExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_memberExpr.add(memberExpr28.getTree());
					// AST REWRITE
					// elements: NOT, memberExpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 67:21: -> ^( UNARY NOT memberExpr )
					{
						// Expression.g:67:23: ^( UNARY NOT memberExpr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY, "UNARY"), root_1);
						adaptor.addChild(root_1, stream_NOT.nextNode());
						adaptor.addChild(root_1, stream_memberExpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// Expression.g:68:4: PLUS memberExpr
					{
					PLUS29=(CommonToken)match(input,PLUS,FOLLOW_PLUS_in_unaryExpr406); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_PLUS.add(PLUS29);

					pushFollow(FOLLOW_memberExpr_in_unaryExpr408);
					memberExpr30=memberExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_memberExpr.add(memberExpr30.getTree());
					// AST REWRITE
					// elements: memberExpr, PLUS
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 68:21: -> ^( UNARY PLUS memberExpr )
					{
						// Expression.g:68:23: ^( UNARY PLUS memberExpr )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY, "UNARY"), root_1);
						adaptor.addChild(root_1, stream_PLUS.nextNode());
						adaptor.addChild(root_1, stream_memberExpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// Expression.g:69:4: memberExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_memberExpr_in_unaryExpr423);
					memberExpr31=memberExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, memberExpr31.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "unaryExpr"


	public static class memberExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "memberExpr"
	// Expression.g:72:1: memberExpr : basicExpr ( '.' ^ functionExpr )* ;
	public final ExpressionParser.memberExpr_return memberExpr() throws RecognitionException {
		ExpressionParser.memberExpr_return retval = new ExpressionParser.memberExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken char_literal33=null;
		ParserRuleReturnScope basicExpr32 =null;
		ParserRuleReturnScope functionExpr34 =null;

		CommonTree char_literal33_tree=null;

		try {
			// Expression.g:73:5: ( basicExpr ( '.' ^ functionExpr )* )
			// Expression.g:73:7: basicExpr ( '.' ^ functionExpr )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_basicExpr_in_memberExpr438);
			basicExpr32=basicExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, basicExpr32.getTree());

			// Expression.g:73:17: ( '.' ^ functionExpr )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==40) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Expression.g:73:18: '.' ^ functionExpr
					{
					char_literal33=(CommonToken)match(input,40,FOLLOW_40_in_memberExpr441); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal33_tree = (CommonTree)adaptor.create(char_literal33);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal33_tree, root_0);
					}

					pushFollow(FOLLOW_functionExpr_in_memberExpr444);
					functionExpr34=functionExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, functionExpr34.getTree());

					}
					break;

				default :
					break loop9;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "memberExpr"


	public static class basicExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "basicExpr"
	// Expression.g:76:1: basicExpr : ( parenExpr | literal | functionExpr );
	public final ExpressionParser.basicExpr_return basicExpr() throws RecognitionException {
		ExpressionParser.basicExpr_return retval = new ExpressionParser.basicExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope parenExpr35 =null;
		ParserRuleReturnScope literal36 =null;
		ParserRuleReturnScope functionExpr37 =null;


		try {
			// Expression.g:77:2: ( parenExpr | literal | functionExpr )
			int alt10=3;
			switch ( input.LA(1) ) {
			case LPAREN:
				{
				alt10=1;
				}
				break;
			case TYPE_BOOLEAN:
			case TYPE_DATETIME:
			case TYPE_DOUBLE:
			case TYPE_INTEGER:
			case TYPE_STRING:
				{
				alt10=2;
				}
				break;
			case IDENTIFIER:
				{
				alt10=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// Expression.g:77:5: parenExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_parenExpr_in_basicExpr464);
					parenExpr35=parenExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, parenExpr35.getTree());

					}
					break;
				case 2 :
					// Expression.g:77:17: literal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_literal_in_basicExpr468);
					literal36=literal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, literal36.getTree());

					}
					break;
				case 3 :
					// Expression.g:77:28: functionExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_functionExpr_in_basicExpr473);
					functionExpr37=functionExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, functionExpr37.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "basicExpr"


	public static class parenExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "parenExpr"
	// Expression.g:79:1: parenExpr : LPAREN ! expr RPAREN !;
	public final ExpressionParser.parenExpr_return parenExpr() throws RecognitionException {
		ExpressionParser.parenExpr_return retval = new ExpressionParser.parenExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken LPAREN38=null;
		CommonToken RPAREN40=null;
		ParserRuleReturnScope expr39 =null;

		CommonTree LPAREN38_tree=null;
		CommonTree RPAREN40_tree=null;

		try {
			// Expression.g:80:5: ( LPAREN ! expr RPAREN !)
			// Expression.g:80:7: LPAREN ! expr RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			LPAREN38=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_parenExpr498); if (state.failed) return retval;
			pushFollow(FOLLOW_expr_in_parenExpr501);
			expr39=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr39.getTree());

			RPAREN40=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_parenExpr504); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "parenExpr"


	public static class literal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "literal"
	// Expression.g:83:1: literal : ( numbericLiteral | stringLiteral | boolLiteral );
	public final ExpressionParser.literal_return literal() throws RecognitionException {
		ExpressionParser.literal_return retval = new ExpressionParser.literal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope numbericLiteral41 =null;
		ParserRuleReturnScope stringLiteral42 =null;
		ParserRuleReturnScope boolLiteral43 =null;


		try {
			// Expression.g:84:4: ( numbericLiteral | stringLiteral | boolLiteral )
			int alt11=3;
			switch ( input.LA(1) ) {
			case TYPE_DATETIME:
			case TYPE_DOUBLE:
			case TYPE_INTEGER:
				{
				alt11=1;
				}
				break;
			case TYPE_STRING:
				{
				alt11=2;
				}
				break;
			case TYPE_BOOLEAN:
				{
				alt11=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// Expression.g:84:7: numbericLiteral
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_numbericLiteral_in_literal528);
					numbericLiteral41=numbericLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, numbericLiteral41.getTree());

					}
					break;
				case 2 :
					// Expression.g:85:7: stringLiteral
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_stringLiteral_in_literal536);
					stringLiteral42=stringLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, stringLiteral42.getTree());

					}
					break;
				case 3 :
					// Expression.g:86:6: boolLiteral
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_boolLiteral_in_literal544);
					boolLiteral43=boolLiteral();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, boolLiteral43.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "literal"


	public static class numbericLiteral_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "numbericLiteral"
	// Expression.g:89:1: numbericLiteral : ( TYPE_DOUBLE | TYPE_INTEGER | TYPE_DATETIME );
	public final ExpressionParser.numbericLiteral_return numbericLiteral() throws RecognitionException {
		ExpressionParser.numbericLiteral_return retval = new ExpressionParser.numbericLiteral_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set44=null;

		CommonTree set44_tree=null;

		try {
			// Expression.g:90:4: ( TYPE_DOUBLE | TYPE_INTEGER | TYPE_DATETIME )
			// Expression.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set44=(CommonToken)input.LT(1);
			if ( (input.LA(1) >= TYPE_DATETIME && input.LA(1) <= TYPE_INTEGER) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set44));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "numbericLiteral"


	public static class stringLiteral_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stringLiteral"
	// Expression.g:95:1: stringLiteral : TYPE_STRING ;
	public final ExpressionParser.stringLiteral_return stringLiteral() throws RecognitionException {
		ExpressionParser.stringLiteral_return retval = new ExpressionParser.stringLiteral_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken TYPE_STRING45=null;

		CommonTree TYPE_STRING45_tree=null;

		try {
			// Expression.g:96:4: ( TYPE_STRING )
			// Expression.g:96:7: TYPE_STRING
			{
			root_0 = (CommonTree)adaptor.nil();


			TYPE_STRING45=(CommonToken)match(input,TYPE_STRING,FOLLOW_TYPE_STRING_in_stringLiteral606); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TYPE_STRING45_tree = (CommonTree)adaptor.create(TYPE_STRING45);
			adaptor.addChild(root_0, TYPE_STRING45_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "stringLiteral"


	public static class boolLiteral_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "boolLiteral"
	// Expression.g:99:1: boolLiteral : TYPE_BOOLEAN ;
	public final ExpressionParser.boolLiteral_return boolLiteral() throws RecognitionException {
		ExpressionParser.boolLiteral_return retval = new ExpressionParser.boolLiteral_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken TYPE_BOOLEAN46=null;

		CommonTree TYPE_BOOLEAN46_tree=null;

		try {
			// Expression.g:100:3: ( TYPE_BOOLEAN )
			// Expression.g:100:5: TYPE_BOOLEAN
			{
			root_0 = (CommonTree)adaptor.nil();


			TYPE_BOOLEAN46=(CommonToken)match(input,TYPE_BOOLEAN,FOLLOW_TYPE_BOOLEAN_in_boolLiteral624); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TYPE_BOOLEAN46_tree = (CommonTree)adaptor.create(TYPE_BOOLEAN46);
			adaptor.addChild(root_0, TYPE_BOOLEAN46_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "boolLiteral"


	public static class functionExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "functionExpr"
	// Expression.g:103:1: functionExpr : ( fieldPropertyExpr | methodExpr );
	public final ExpressionParser.functionExpr_return functionExpr() throws RecognitionException {
		ExpressionParser.functionExpr_return retval = new ExpressionParser.functionExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope fieldPropertyExpr47 =null;
		ParserRuleReturnScope methodExpr48 =null;


		try {
			// Expression.g:104:2: ( fieldPropertyExpr | methodExpr )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==IDENTIFIER) ) {
				int LA12_1 = input.LA(2);
				if ( (LA12_1==LBRACKET) ) {
					alt12=1;
				}
				else if ( (LA12_1==EOF||(LA12_1 >= AND && LA12_1 <= COMMA)||LA12_1==DIV||LA12_1==EQUALS||(LA12_1 >= GT && LA12_1 <= GTEQ)||(LA12_1 >= LPAREN && LA12_1 <= LTEQ)||(LA12_1 >= MINUS && LA12_1 <= MUL)||(LA12_1 >= NOTEQUALS && LA12_1 <= RPAREN)||LA12_1==40) ) {
					alt12=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// Expression.g:104:4: fieldPropertyExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_fieldPropertyExpr_in_functionExpr640);
					fieldPropertyExpr47=fieldPropertyExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fieldPropertyExpr47.getTree());

					}
					break;
				case 2 :
					// Expression.g:104:24: methodExpr
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_methodExpr_in_functionExpr644);
					methodExpr48=methodExpr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, methodExpr48.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "functionExpr"


	public static class fieldPropertyExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "fieldPropertyExpr"
	// Expression.g:107:1: fieldPropertyExpr : IDENTIFIER LBRACKET argument ( COMMA argument )* RBRACKET -> ^( INDEX IDENTIFIER ( argument )+ ) ;
	public final ExpressionParser.fieldPropertyExpr_return fieldPropertyExpr() throws RecognitionException {
		ExpressionParser.fieldPropertyExpr_return retval = new ExpressionParser.fieldPropertyExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken IDENTIFIER49=null;
		CommonToken LBRACKET50=null;
		CommonToken COMMA52=null;
		CommonToken RBRACKET54=null;
		ParserRuleReturnScope argument51 =null;
		ParserRuleReturnScope argument53 =null;

		CommonTree IDENTIFIER49_tree=null;
		CommonTree LBRACKET50_tree=null;
		CommonTree COMMA52_tree=null;
		CommonTree RBRACKET54_tree=null;
		RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
		RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");

		try {
			// Expression.g:108:2: ( IDENTIFIER LBRACKET argument ( COMMA argument )* RBRACKET -> ^( INDEX IDENTIFIER ( argument )+ ) )
			// Expression.g:108:4: IDENTIFIER LBRACKET argument ( COMMA argument )* RBRACKET
			{
			IDENTIFIER49=(CommonToken)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_fieldPropertyExpr656); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER49);

			LBRACKET50=(CommonToken)match(input,LBRACKET,FOLLOW_LBRACKET_in_fieldPropertyExpr658); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET50);

			pushFollow(FOLLOW_argument_in_fieldPropertyExpr660);
			argument51=argument();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_argument.add(argument51.getTree());
			// Expression.g:108:33: ( COMMA argument )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==COMMA) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// Expression.g:108:34: COMMA argument
					{
					COMMA52=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_fieldPropertyExpr663); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA52);

					pushFollow(FOLLOW_argument_in_fieldPropertyExpr665);
					argument53=argument();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_argument.add(argument53.getTree());
					}
					break;

				default :
					break loop13;
				}
			}

			RBRACKET54=(CommonToken)match(input,RBRACKET,FOLLOW_RBRACKET_in_fieldPropertyExpr669); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET54);

			// AST REWRITE
			// elements: argument, IDENTIFIER
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 108:60: -> ^( INDEX IDENTIFIER ( argument )+ )
			{
				// Expression.g:108:63: ^( INDEX IDENTIFIER ( argument )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(INDEX, "INDEX"), root_1);
				adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
				if ( !(stream_argument.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_argument.hasNext() ) {
					adaptor.addChild(root_1, stream_argument.nextTree());
				}
				stream_argument.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "fieldPropertyExpr"


	public static class methodExpr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "methodExpr"
	// Expression.g:111:1: methodExpr : ( IDENTIFIER LPAREN ( argument ( COMMA argument )* )? RPAREN -> ^( FUNCTION IDENTIFIER ( argument )* ) | IDENTIFIER -> ^( FUNCTION IDENTIFIER ) );
	public final ExpressionParser.methodExpr_return methodExpr() throws RecognitionException {
		ExpressionParser.methodExpr_return retval = new ExpressionParser.methodExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken IDENTIFIER55=null;
		CommonToken LPAREN56=null;
		CommonToken COMMA58=null;
		CommonToken RPAREN60=null;
		CommonToken IDENTIFIER61=null;
		ParserRuleReturnScope argument57 =null;
		ParserRuleReturnScope argument59 =null;

		CommonTree IDENTIFIER55_tree=null;
		CommonTree LPAREN56_tree=null;
		CommonTree COMMA58_tree=null;
		CommonTree RPAREN60_tree=null;
		CommonTree IDENTIFIER61_tree=null;
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");

		try {
			// Expression.g:112:2: ( IDENTIFIER LPAREN ( argument ( COMMA argument )* )? RPAREN -> ^( FUNCTION IDENTIFIER ( argument )* ) | IDENTIFIER -> ^( FUNCTION IDENTIFIER ) )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==IDENTIFIER) ) {
				int LA16_1 = input.LA(2);
				if ( (LA16_1==LPAREN) ) {
					alt16=1;
				}
				else if ( (LA16_1==EOF||(LA16_1 >= AND && LA16_1 <= COMMA)||LA16_1==DIV||LA16_1==EQUALS||(LA16_1 >= GT && LA16_1 <= GTEQ)||(LA16_1 >= LT && LA16_1 <= LTEQ)||(LA16_1 >= MINUS && LA16_1 <= MUL)||(LA16_1 >= NOTEQUALS && LA16_1 <= RPAREN)||LA16_1==40) ) {
					alt16=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 16, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// Expression.g:112:4: IDENTIFIER LPAREN ( argument ( COMMA argument )* )? RPAREN
					{
					IDENTIFIER55=(CommonToken)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodExpr696); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER55);

					LPAREN56=(CommonToken)match(input,LPAREN,FOLLOW_LPAREN_in_methodExpr698); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN56);

					// Expression.g:112:22: ( argument ( COMMA argument )* )?
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==IDENTIFIER||LA15_0==LPAREN||LA15_0==MINUS||LA15_0==NOT||LA15_0==PLUS||(LA15_0 >= TYPE_BOOLEAN && LA15_0 <= TYPE_STRING)) ) {
						alt15=1;
					}
					switch (alt15) {
						case 1 :
							// Expression.g:112:23: argument ( COMMA argument )*
							{
							pushFollow(FOLLOW_argument_in_methodExpr701);
							argument57=argument();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_argument.add(argument57.getTree());
							// Expression.g:112:32: ( COMMA argument )*
							loop14:
							while (true) {
								int alt14=2;
								int LA14_0 = input.LA(1);
								if ( (LA14_0==COMMA) ) {
									alt14=1;
								}

								switch (alt14) {
								case 1 :
									// Expression.g:112:33: COMMA argument
									{
									COMMA58=(CommonToken)match(input,COMMA,FOLLOW_COMMA_in_methodExpr704); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_COMMA.add(COMMA58);

									pushFollow(FOLLOW_argument_in_methodExpr706);
									argument59=argument();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_argument.add(argument59.getTree());
									}
									break;

								default :
									break loop14;
								}
							}

							}
							break;

					}

					RPAREN60=(CommonToken)match(input,RPAREN,FOLLOW_RPAREN_in_methodExpr712); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN60);

					// AST REWRITE
					// elements: argument, IDENTIFIER
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 112:59: -> ^( FUNCTION IDENTIFIER ( argument )* )
					{
						// Expression.g:112:62: ^( FUNCTION IDENTIFIER ( argument )* )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION, "FUNCTION"), root_1);
						adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
						// Expression.g:112:84: ( argument )*
						while ( stream_argument.hasNext() ) {
							adaptor.addChild(root_1, stream_argument.nextTree());
						}
						stream_argument.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// Expression.g:113:4: IDENTIFIER
					{
					IDENTIFIER61=(CommonToken)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_methodExpr728); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER61);

					// AST REWRITE
					// elements: IDENTIFIER
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 113:15: -> ^( FUNCTION IDENTIFIER )
					{
						// Expression.g:113:17: ^( FUNCTION IDENTIFIER )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION, "FUNCTION"), root_1);
						adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "methodExpr"


	public static class argument_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "argument"
	// Expression.g:117:1: argument : expr ;
	public final ExpressionParser.argument_return argument() throws RecognitionException {
		ExpressionParser.argument_return retval = new ExpressionParser.argument_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr62 =null;


		try {
			// Expression.g:118:4: ( expr )
			// Expression.g:118:7: expr
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_in_argument757);
			expr62=expr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr62.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "argument"
	ArrayList exceptions = new ArrayList();

    public Override  ReportError(RecognitionException e)
    {
        exceptions.add(e);
		 return null;
    }

    public Override  DisplayRecognitionError(String[] tokenNames, RecognitionException e)
    {
        return DisplayRecognitionError(tokenNames, e);
    }


    public Boolean HasError()
    {
        return exceptions.size() > 0; 
    }

    public String GetErrorMessage()
    {

            StringBuilder sb = new StringBuilder();
            for (Object m : exceptions)
            {
                RecognitionException t = (RecognitionException) m;
                sb.append(String.format("Œª÷√:{0}£¨¥ÌŒÛ:{1}\r\n", 
                    this.getErrorHeader(t), 
                    this.getErrorMessage(t, this.getTokenNames())));
            }
            return sb.toString(); 
    }
	// Delegated rules



	public static final BitSet FOLLOW_expr_in_expression111 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_expression113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logicalOrExpr_in_expr125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logicalAndExpr_in_logicalOrExpr138 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_OR_in_logicalOrExpr141 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_logicalAndExpr_in_logicalOrExpr144 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_equalityExpr_in_logicalAndExpr182 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_AND_in_logicalAndExpr185 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_equalityExpr_in_logicalAndExpr188 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_relationalExpr_in_equalityExpr228 = new BitSet(new long[]{0x0000000004000202L});
	public static final BitSet FOLLOW_set_in_equalityExpr231 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_relationalExpr_in_equalityExpr238 = new BitSet(new long[]{0x0000000004000202L});
	public static final BitSet FOLLOW_additiveExpr_in_relationalExpr252 = new BitSet(new long[]{0x0000000000306002L});
	public static final BitSet FOLLOW_set_in_relationalExpr255 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_additiveExpr_in_relationalExpr266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multiplyExpr_in_additiveExpr281 = new BitSet(new long[]{0x0000000010800002L});
	public static final BitSet FOLLOW_set_in_additiveExpr284 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_multiplyExpr_in_additiveExpr291 = new BitSet(new long[]{0x0000000010800002L});
	public static final BitSet FOLLOW_powExpr_in_multiplyExpr308 = new BitSet(new long[]{0x0000000001000082L});
	public static final BitSet FOLLOW_set_in_multiplyExpr311 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_powExpr_in_multiplyExpr320 = new BitSet(new long[]{0x0000000001000082L});
	public static final BitSet FOLLOW_unaryExpr_in_powExpr349 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_POW_in_powExpr352 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_unaryExpr_in_powExpr355 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_MINUS_in_unaryExpr372 = new BitSet(new long[]{0x0000001F00088000L});
	public static final BitSet FOLLOW_memberExpr_in_unaryExpr374 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_unaryExpr389 = new BitSet(new long[]{0x0000001F00088000L});
	public static final BitSet FOLLOW_memberExpr_in_unaryExpr391 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_unaryExpr406 = new BitSet(new long[]{0x0000001F00088000L});
	public static final BitSet FOLLOW_memberExpr_in_unaryExpr408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_memberExpr_in_unaryExpr423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_basicExpr_in_memberExpr438 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_40_in_memberExpr441 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_functionExpr_in_memberExpr444 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_parenExpr_in_basicExpr464 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_basicExpr468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_functionExpr_in_basicExpr473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_parenExpr498 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_expr_in_parenExpr501 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_RPAREN_in_parenExpr504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_numbericLiteral_in_literal528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_stringLiteral_in_literal536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_boolLiteral_in_literal544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_STRING_in_stringLiteral606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TYPE_BOOLEAN_in_boolLiteral624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fieldPropertyExpr_in_functionExpr640 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_methodExpr_in_functionExpr644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_fieldPropertyExpr656 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_LBRACKET_in_fieldPropertyExpr658 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_argument_in_fieldPropertyExpr660 = new BitSet(new long[]{0x0000000040000020L});
	public static final BitSet FOLLOW_COMMA_in_fieldPropertyExpr663 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_argument_in_fieldPropertyExpr665 = new BitSet(new long[]{0x0000000040000020L});
	public static final BitSet FOLLOW_RBRACKET_in_fieldPropertyExpr669 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_methodExpr696 = new BitSet(new long[]{0x0000000000080000L});
	public static final BitSet FOLLOW_LPAREN_in_methodExpr698 = new BitSet(new long[]{0x0000001F92888000L});
	public static final BitSet FOLLOW_argument_in_methodExpr701 = new BitSet(new long[]{0x0000000080000020L});
	public static final BitSet FOLLOW_COMMA_in_methodExpr704 = new BitSet(new long[]{0x0000001F12888000L});
	public static final BitSet FOLLOW_argument_in_methodExpr706 = new BitSet(new long[]{0x0000000080000020L});
	public static final BitSet FOLLOW_RPAREN_in_methodExpr712 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_methodExpr728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_in_argument757 = new BitSet(new long[]{0x0000000000000002L});
}
