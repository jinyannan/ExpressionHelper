// $ANTLR 3.5.1 D:\\antlr\\Expression.g 2015-05-06 15:52:20
package org.antlr.ext.ConditionExpression.Generated;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

@SuppressWarnings("all")
public class ExpressionParser extends Parser {
	public static final String[] tokenNames = new String[] { "<invalid>",
			"<EOR>", "<DOWN>", "<UP>", "AND", "COMMA", "DATA", "DIV", "DOT",
			"Digit", "EQUALS", "EXPRESSION", "FIELD", "FUNCTION", "GT", "GTEQ",
			"IDENTIFIER", "INDEX", "LBRACKET", "LETTER", "LPAREN", "LT",
			"LTEQ", "MEMBERACCESS", "MINUS", "MUL", "NOT", "NOTEQUALS", "OR",
			"PLUS", "POW", "RBRACKET", "RPAREN", "TYPE_BOOLEAN",
			"TYPE_DATETIME", "TYPE_DOUBLE", "TYPE_INTEGER", "TYPE_STRING",
			"UNARY", "WS", "ZERO" };
	public static final int EOF = -1;
	public static final int AND = 4;
	public static final int COMMA = 5;
	public static final int DATA = 6;
	public static final int DIV = 7;
	public static final int DOT = 8;
	public static final int Digit = 9;
	public static final int EQUALS = 10;
	public static final int EXPRESSION = 11;
	public static final int FIELD = 12;
	public static final int FUNCTION = 13;
	public static final int GT = 14;
	public static final int GTEQ = 15;
	public static final int IDENTIFIER = 16;
	public static final int INDEX = 17;
	public static final int LBRACKET = 18;
	public static final int LETTER = 19;
	public static final int LPAREN = 20;
	public static final int LT = 21;
	public static final int LTEQ = 22;
	public static final int MEMBERACCESS = 23;
	public static final int MINUS = 24;
	public static final int MUL = 25;
	public static final int NOT = 26;
	public static final int NOTEQUALS = 27;
	public static final int OR = 28;
	public static final int PLUS = 29;
	public static final int POW = 30;
	public static final int RBRACKET = 31;
	public static final int RPAREN = 32;
	public static final int TYPE_BOOLEAN = 33;
	public static final int TYPE_DATETIME = 34;
	public static final int TYPE_DOUBLE = 35;
	public static final int TYPE_INTEGER = 36;
	public static final int TYPE_STRING = 37;
	public static final int UNARY = 38;
	public static final int WS = 39;
	public static final int ZERO = 40;

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

	@Override
	public String[] getTokenNames() {
		return ExpressionParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "D:\\antlr\\Expression.g";
	}

	public static class expression_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "expression"
	// D:\\antlr\\Expression.g:29:1: expression : expr EOF !;
	public final ExpressionParser.expression_return expression()
			throws RecognitionException {
		ExpressionParser.expression_return retval = new ExpressionParser.expression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken EOF2 = null;
		ParserRuleReturnScope expr1 = null;

		CommonTree EOF2_tree = null;

		try {
			// D:\\antlr\\Expression.g:30:3: ( expr EOF !)
			// D:\\antlr\\Expression.g:30:5: expr EOF !
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_expr_in_expression118);
				expr1 = expr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, expr1.getTree());

				EOF2 = (CommonToken) match(input, EOF,
						FOLLOW_EOF_in_expression120);
				if (state.failed)
					return retval;
			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "expression"

	public static class expr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "expr"
	// D:\\antlr\\Expression.g:33:1: expr : logicalOrExpr ;
	public final ExpressionParser.expr_return expr()
			throws RecognitionException {
		ExpressionParser.expr_return retval = new ExpressionParser.expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope logicalOrExpr3 = null;

		try {
			// D:\\antlr\\Expression.g:34:3: ( logicalOrExpr )
			// D:\\antlr\\Expression.g:34:5: logicalOrExpr
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_logicalOrExpr_in_expr134);
				logicalOrExpr3 = logicalOrExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, logicalOrExpr3.getTree());

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "expr"

	public static class logicalOrExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "logicalOrExpr"
	// D:\\antlr\\Expression.g:37:1: logicalOrExpr : logicalAndExpr ( OR ^
	// logicalAndExpr )* ;
	public final ExpressionParser.logicalOrExpr_return logicalOrExpr()
			throws RecognitionException {
		ExpressionParser.logicalOrExpr_return retval = new ExpressionParser.logicalOrExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken OR5 = null;
		ParserRuleReturnScope logicalAndExpr4 = null;
		ParserRuleReturnScope logicalAndExpr6 = null;

		CommonTree OR5_tree = null;

		try {
			// D:\\antlr\\Expression.g:38:3: ( logicalAndExpr ( OR ^
			// logicalAndExpr )* )
			// D:\\antlr\\Expression.g:38:5: logicalAndExpr ( OR ^
			// logicalAndExpr )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_logicalAndExpr_in_logicalOrExpr149);
				logicalAndExpr4 = logicalAndExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, logicalAndExpr4.getTree());

				// D:\\antlr\\Expression.g:38:20: ( OR ^ logicalAndExpr )*
				loop1: while (true) {
					int alt1 = 2;
					int LA1_0 = input.LA(1);
					if ((LA1_0 == OR)) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
					// D:\\antlr\\Expression.g:38:21: OR ^ logicalAndExpr
					{
						OR5 = (CommonToken) match(input, OR,
								FOLLOW_OR_in_logicalOrExpr152);
						if (state.failed)
							return retval;
						if (state.backtracking == 0) {
							OR5_tree = (CommonTree) adaptor.create(OR5);
							root_0 = (CommonTree) adaptor.becomeRoot(OR5_tree,
									root_0);
						}

						pushFollow(FOLLOW_logicalAndExpr_in_logicalOrExpr155);
						logicalAndExpr6 = logicalAndExpr();
						state._fsp--;
						if (state.failed)
							return retval;
						if (state.backtracking == 0)
							adaptor.addChild(root_0, logicalAndExpr6.getTree());

					}
						break;

					default:
						break loop1;
					}
				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "logicalOrExpr"

	public static class logicalAndExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "logicalAndExpr"
	// D:\\antlr\\Expression.g:41:1: logicalAndExpr : equalityExpr ( AND ^
	// equalityExpr )* ;
	public final ExpressionParser.logicalAndExpr_return logicalAndExpr()
			throws RecognitionException {
		ExpressionParser.logicalAndExpr_return retval = new ExpressionParser.logicalAndExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken AND8 = null;
		ParserRuleReturnScope equalityExpr7 = null;
		ParserRuleReturnScope equalityExpr9 = null;

		CommonTree AND8_tree = null;

		try {
			// D:\\antlr\\Expression.g:42:3: ( equalityExpr ( AND ^ equalityExpr
			// )* )
			// D:\\antlr\\Expression.g:42:5: equalityExpr ( AND ^ equalityExpr
			// )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_equalityExpr_in_logicalAndExpr195);
				equalityExpr7 = equalityExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, equalityExpr7.getTree());

				// D:\\antlr\\Expression.g:42:18: ( AND ^ equalityExpr )*
				loop2: while (true) {
					int alt2 = 2;
					int LA2_0 = input.LA(1);
					if ((LA2_0 == AND)) {
						alt2 = 1;
					}

					switch (alt2) {
					case 1:
					// D:\\antlr\\Expression.g:42:19: AND ^ equalityExpr
					{
						AND8 = (CommonToken) match(input, AND,
								FOLLOW_AND_in_logicalAndExpr198);
						if (state.failed)
							return retval;
						if (state.backtracking == 0) {
							AND8_tree = (CommonTree) adaptor.create(AND8);
							root_0 = (CommonTree) adaptor.becomeRoot(AND8_tree,
									root_0);
						}

						pushFollow(FOLLOW_equalityExpr_in_logicalAndExpr201);
						equalityExpr9 = equalityExpr();
						state._fsp--;
						if (state.failed)
							return retval;
						if (state.backtracking == 0)
							adaptor.addChild(root_0, equalityExpr9.getTree());

					}
						break;

					default:
						break loop2;
					}
				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "logicalAndExpr"

	public static class equalityExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "equalityExpr"
	// D:\\antlr\\Expression.g:45:1: equalityExpr : relationalExpr ( ( EQUALS |
	// NOTEQUALS ) ^ relationalExpr )* ;
	public final ExpressionParser.equalityExpr_return equalityExpr()
			throws RecognitionException {
		ExpressionParser.equalityExpr_return retval = new ExpressionParser.equalityExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set11 = null;
		ParserRuleReturnScope relationalExpr10 = null;
		ParserRuleReturnScope relationalExpr12 = null;

		CommonTree set11_tree = null;

		try {
			// D:\\antlr\\Expression.g:46:3: ( relationalExpr ( ( EQUALS |
			// NOTEQUALS ) ^ relationalExpr )* )
			// D:\\antlr\\Expression.g:46:5: relationalExpr ( ( EQUALS |
			// NOTEQUALS ) ^ relationalExpr )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_relationalExpr_in_equalityExpr244);
				relationalExpr10 = relationalExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, relationalExpr10.getTree());

				// D:\\antlr\\Expression.g:46:20: ( ( EQUALS | NOTEQUALS ) ^
				// relationalExpr )*
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if ((LA3_0 == EQUALS || LA3_0 == NOTEQUALS)) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
					// D:\\antlr\\Expression.g:46:21: ( EQUALS | NOTEQUALS ) ^
					// relationalExpr
					{
						set11 = (CommonToken) input.LT(1);
						set11 = (CommonToken) input.LT(1);
						if (input.LA(1) == EQUALS || input.LA(1) == NOTEQUALS) {
							input.consume();
							if (state.backtracking == 0)
								root_0 = (CommonTree) adaptor.becomeRoot(
										(CommonTree) adaptor.create(set11),
										root_0);
							state.errorRecovery = false;
							state.failed = false;
						} else {
							if (state.backtracking > 0) {
								state.failed = true;
								return retval;
							}
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							throw mse;
						}
						pushFollow(FOLLOW_relationalExpr_in_equalityExpr254);
						relationalExpr12 = relationalExpr();
						state._fsp--;
						if (state.failed)
							return retval;
						if (state.backtracking == 0)
							adaptor.addChild(root_0, relationalExpr12.getTree());

					}
						break;

					default:
						break loop3;
					}
				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "equalityExpr"

	public static class relationalExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "relationalExpr"
	// D:\\antlr\\Expression.g:49:1: relationalExpr : additiveExpr ( ( LT | LTEQ
	// | GT | GTEQ ) ^ additiveExpr )? ;
	public final ExpressionParser.relationalExpr_return relationalExpr()
			throws RecognitionException {
		ExpressionParser.relationalExpr_return retval = new ExpressionParser.relationalExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set14 = null;
		ParserRuleReturnScope additiveExpr13 = null;
		ParserRuleReturnScope additiveExpr15 = null;

		CommonTree set14_tree = null;

		try {
			// D:\\antlr\\Expression.g:50:3: ( additiveExpr ( ( LT | LTEQ | GT |
			// GTEQ ) ^ additiveExpr )? )
			// D:\\antlr\\Expression.g:50:5: additiveExpr ( ( LT | LTEQ | GT |
			// GTEQ ) ^ additiveExpr )?
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_additiveExpr_in_relationalExpr271);
				additiveExpr13 = additiveExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, additiveExpr13.getTree());

				// D:\\antlr\\Expression.g:50:18: ( ( LT | LTEQ | GT | GTEQ ) ^
				// additiveExpr )?
				int alt4 = 2;
				int LA4_0 = input.LA(1);
				if (((LA4_0 >= GT && LA4_0 <= GTEQ) || (LA4_0 >= LT && LA4_0 <= LTEQ))) {
					alt4 = 1;
				}
				switch (alt4) {
				case 1:
				// D:\\antlr\\Expression.g:50:19: ( LT | LTEQ | GT | GTEQ ) ^
				// additiveExpr
				{
					set14 = (CommonToken) input.LT(1);
					set14 = (CommonToken) input.LT(1);
					if ((input.LA(1) >= GT && input.LA(1) <= GTEQ)
							|| (input.LA(1) >= LT && input.LA(1) <= LTEQ)) {
						input.consume();
						if (state.backtracking == 0)
							root_0 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(set14), root_0);
						state.errorRecovery = false;
						state.failed = false;
					} else {
						if (state.backtracking > 0) {
							state.failed = true;
							return retval;
						}
						MismatchedSetException mse = new MismatchedSetException(
								null, input);
						throw mse;
					}
					pushFollow(FOLLOW_additiveExpr_in_relationalExpr285);
					additiveExpr15 = additiveExpr();
					state._fsp--;
					if (state.failed)
						return retval;
					if (state.backtracking == 0)
						adaptor.addChild(root_0, additiveExpr15.getTree());

				}
					break;

				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "relationalExpr"

	public static class additiveExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "additiveExpr"
	// D:\\antlr\\Expression.g:53:1: additiveExpr : multiplyExpr ( ( PLUS |
	// MINUS ) ^ multiplyExpr )* ;
	public final ExpressionParser.additiveExpr_return additiveExpr()
			throws RecognitionException {
		ExpressionParser.additiveExpr_return retval = new ExpressionParser.additiveExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set17 = null;
		ParserRuleReturnScope multiplyExpr16 = null;
		ParserRuleReturnScope multiplyExpr18 = null;

		CommonTree set17_tree = null;

		try {
			// D:\\antlr\\Expression.g:54:3: ( multiplyExpr ( ( PLUS | MINUS ) ^
			// multiplyExpr )* )
			// D:\\antlr\\Expression.g:54:5: multiplyExpr ( ( PLUS | MINUS ) ^
			// multiplyExpr )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_multiplyExpr_in_additiveExpr302);
				multiplyExpr16 = multiplyExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, multiplyExpr16.getTree());

				// D:\\antlr\\Expression.g:54:18: ( ( PLUS | MINUS ) ^
				// multiplyExpr )*
				loop5: while (true) {
					int alt5 = 2;
					int LA5_0 = input.LA(1);
					if ((LA5_0 == MINUS || LA5_0 == PLUS)) {
						alt5 = 1;
					}

					switch (alt5) {
					case 1:
					// D:\\antlr\\Expression.g:54:19: ( PLUS | MINUS ) ^
					// multiplyExpr
					{
						set17 = (CommonToken) input.LT(1);
						set17 = (CommonToken) input.LT(1);
						if (input.LA(1) == MINUS || input.LA(1) == PLUS) {
							input.consume();
							if (state.backtracking == 0)
								root_0 = (CommonTree) adaptor.becomeRoot(
										(CommonTree) adaptor.create(set17),
										root_0);
							state.errorRecovery = false;
							state.failed = false;
						} else {
							if (state.backtracking > 0) {
								state.failed = true;
								return retval;
							}
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							throw mse;
						}
						pushFollow(FOLLOW_multiplyExpr_in_additiveExpr312);
						multiplyExpr18 = multiplyExpr();
						state._fsp--;
						if (state.failed)
							return retval;
						if (state.backtracking == 0)
							adaptor.addChild(root_0, multiplyExpr18.getTree());

					}
						break;

					default:
						break loop5;
					}
				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "additiveExpr"

	public static class multiplyExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "multiplyExpr"
	// D:\\antlr\\Expression.g:57:1: multiplyExpr : powExpr ( ( MUL | DIV ) ^
	// powExpr )* ;
	public final ExpressionParser.multiplyExpr_return multiplyExpr()
			throws RecognitionException {
		ExpressionParser.multiplyExpr_return retval = new ExpressionParser.multiplyExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set20 = null;
		ParserRuleReturnScope powExpr19 = null;
		ParserRuleReturnScope powExpr21 = null;

		CommonTree set20_tree = null;

		try {
			// D:\\antlr\\Expression.g:58:5: ( powExpr ( ( MUL | DIV ) ^ powExpr
			// )* )
			// D:\\antlr\\Expression.g:58:7: powExpr ( ( MUL | DIV ) ^ powExpr
			// )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_powExpr_in_multiplyExpr331);
				powExpr19 = powExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, powExpr19.getTree());

				// D:\\antlr\\Expression.g:58:15: ( ( MUL | DIV ) ^ powExpr )*
				loop6: while (true) {
					int alt6 = 2;
					int LA6_0 = input.LA(1);
					if ((LA6_0 == DIV || LA6_0 == MUL)) {
						alt6 = 1;
					}

					switch (alt6) {
					case 1:
					// D:\\antlr\\Expression.g:58:16: ( MUL | DIV ) ^ powExpr
					{
						set20 = (CommonToken) input.LT(1);
						set20 = (CommonToken) input.LT(1);
						if (input.LA(1) == DIV || input.LA(1) == MUL) {
							input.consume();
							if (state.backtracking == 0)
								root_0 = (CommonTree) adaptor.becomeRoot(
										(CommonTree) adaptor.create(set20),
										root_0);
							state.errorRecovery = false;
							state.failed = false;
						} else {
							if (state.backtracking > 0) {
								state.failed = true;
								return retval;
							}
							MismatchedSetException mse = new MismatchedSetException(
									null, input);
							throw mse;
						}
						pushFollow(FOLLOW_powExpr_in_multiplyExpr343);
						powExpr21 = powExpr();
						state._fsp--;
						if (state.failed)
							return retval;
						if (state.backtracking == 0)
							adaptor.addChild(root_0, powExpr21.getTree());

					}
						break;

					default:
						break loop6;
					}
				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "multiplyExpr"

	public static class powExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "powExpr"
	// D:\\antlr\\Expression.g:61:1: powExpr : unaryExpr ( POW ^ unaryExpr )* ;
	public final ExpressionParser.powExpr_return powExpr()
			throws RecognitionException {
		ExpressionParser.powExpr_return retval = new ExpressionParser.powExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken POW23 = null;
		ParserRuleReturnScope unaryExpr22 = null;
		ParserRuleReturnScope unaryExpr24 = null;

		CommonTree POW23_tree = null;

		try {
			// D:\\antlr\\Expression.g:62:7: ( unaryExpr ( POW ^ unaryExpr )* )
			// D:\\antlr\\Expression.g:62:11: unaryExpr ( POW ^ unaryExpr )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_unaryExpr_in_powExpr373);
				unaryExpr22 = unaryExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, unaryExpr22.getTree());

				// D:\\antlr\\Expression.g:62:21: ( POW ^ unaryExpr )*
				loop7: while (true) {
					int alt7 = 2;
					int LA7_0 = input.LA(1);
					if ((LA7_0 == POW)) {
						alt7 = 1;
					}

					switch (alt7) {
					case 1:
					// D:\\antlr\\Expression.g:62:22: POW ^ unaryExpr
					{
						POW23 = (CommonToken) match(input, POW,
								FOLLOW_POW_in_powExpr376);
						if (state.failed)
							return retval;
						if (state.backtracking == 0) {
							POW23_tree = (CommonTree) adaptor.create(POW23);
							root_0 = (CommonTree) adaptor.becomeRoot(
									POW23_tree, root_0);
						}

						pushFollow(FOLLOW_unaryExpr_in_powExpr379);
						unaryExpr24 = unaryExpr();
						state._fsp--;
						if (state.failed)
							return retval;
						if (state.backtracking == 0)
							adaptor.addChild(root_0, unaryExpr24.getTree());

					}
						break;

					default:
						break loop7;
					}
				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "powExpr"

	public static class unaryExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "unaryExpr"
	// D:\\antlr\\Expression.g:65:1: unaryExpr : ( MINUS memberExpr -> ^( UNARY
	// MINUS memberExpr ) | NOT memberExpr -> ^( UNARY NOT memberExpr ) | PLUS
	// memberExpr -> ^( UNARY PLUS memberExpr ) | memberExpr );
	public final ExpressionParser.unaryExpr_return unaryExpr()
			throws RecognitionException {
		ExpressionParser.unaryExpr_return retval = new ExpressionParser.unaryExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken MINUS25 = null;
		CommonToken NOT27 = null;
		CommonToken PLUS29 = null;
		ParserRuleReturnScope memberExpr26 = null;
		ParserRuleReturnScope memberExpr28 = null;
		ParserRuleReturnScope memberExpr30 = null;
		ParserRuleReturnScope memberExpr31 = null;

		CommonTree MINUS25_tree = null;
		CommonTree NOT27_tree = null;
		CommonTree PLUS29_tree = null;
		RewriteRuleTokenStream stream_PLUS = new RewriteRuleTokenStream(
				adaptor, "token PLUS");
		RewriteRuleTokenStream stream_NOT = new RewriteRuleTokenStream(adaptor,
				"token NOT");
		RewriteRuleTokenStream stream_MINUS = new RewriteRuleTokenStream(
				adaptor, "token MINUS");
		RewriteRuleSubtreeStream stream_memberExpr = new RewriteRuleSubtreeStream(
				adaptor, "rule memberExpr");

		try {
			// D:\\antlr\\Expression.g:66:3: ( MINUS memberExpr -> ^( UNARY
			// MINUS memberExpr ) | NOT memberExpr -> ^( UNARY NOT memberExpr )
			// | PLUS memberExpr -> ^( UNARY PLUS memberExpr ) | memberExpr )
			int alt8 = 4;
			switch (input.LA(1)) {
			case MINUS: {
				alt8 = 1;
			}
				break;
			case NOT: {
				alt8 = 2;
			}
				break;
			case PLUS: {
				alt8 = 3;
			}
				break;
			case DATA:
			case IDENTIFIER:
			case LPAREN:
			case TYPE_BOOLEAN:
			case TYPE_DATETIME:
			case TYPE_DOUBLE:
			case TYPE_INTEGER:
			case TYPE_STRING: {
				alt8 = 4;
			}
				break;
			default:
				if (state.backtracking > 0) {
					state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 8, 0,
						input);
				throw nvae;
			}
			switch (alt8) {
			case 1:
			// D:\\antlr\\Expression.g:66:5: MINUS memberExpr
			{
				MINUS25 = (CommonToken) match(input, MINUS,
						FOLLOW_MINUS_in_unaryExpr398);
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					stream_MINUS.add(MINUS25);

				pushFollow(FOLLOW_memberExpr_in_unaryExpr400);
				memberExpr26 = memberExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					stream_memberExpr.add(memberExpr26.getTree());
				// AST REWRITE
				// elements: memberExpr, MINUS
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (CommonTree) adaptor.nil();
					// 66:23: -> ^( UNARY MINUS memberExpr )
					{
						// D:\\antlr\\Expression.g:66:25: ^( UNARY MINUS
						// memberExpr )
						{
							CommonTree root_1 = (CommonTree) adaptor.nil();
							root_1 = (CommonTree) adaptor
									.becomeRoot((CommonTree) adaptor.create(
											UNARY, "UNARY"), root_1);
							adaptor.addChild(root_1, stream_MINUS.nextNode());
							adaptor.addChild(root_1,
									stream_memberExpr.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;
				}

			}
				break;
			case 2:
			// D:\\antlr\\Expression.g:67:7: NOT memberExpr
			{
				NOT27 = (CommonToken) match(input, NOT,
						FOLLOW_NOT_in_unaryExpr418);
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					stream_NOT.add(NOT27);

				pushFollow(FOLLOW_memberExpr_in_unaryExpr420);
				memberExpr28 = memberExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					stream_memberExpr.add(memberExpr28.getTree());
				// AST REWRITE
				// elements: memberExpr, NOT
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (CommonTree) adaptor.nil();
					// 67:25: -> ^( UNARY NOT memberExpr )
					{
						// D:\\antlr\\Expression.g:67:27: ^( UNARY NOT
						// memberExpr )
						{
							CommonTree root_1 = (CommonTree) adaptor.nil();
							root_1 = (CommonTree) adaptor
									.becomeRoot((CommonTree) adaptor.create(
											UNARY, "UNARY"), root_1);
							adaptor.addChild(root_1, stream_NOT.nextNode());
							adaptor.addChild(root_1,
									stream_memberExpr.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;
				}

			}
				break;
			case 3:
			// D:\\antlr\\Expression.g:68:5: PLUS memberExpr
			{
				PLUS29 = (CommonToken) match(input, PLUS,
						FOLLOW_PLUS_in_unaryExpr438);
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					stream_PLUS.add(PLUS29);

				pushFollow(FOLLOW_memberExpr_in_unaryExpr440);
				memberExpr30 = memberExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					stream_memberExpr.add(memberExpr30.getTree());
				// AST REWRITE
				// elements: memberExpr, PLUS
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (CommonTree) adaptor.nil();
					// 68:23: -> ^( UNARY PLUS memberExpr )
					{
						// D:\\antlr\\Expression.g:68:25: ^( UNARY PLUS
						// memberExpr )
						{
							CommonTree root_1 = (CommonTree) adaptor.nil();
							root_1 = (CommonTree) adaptor
									.becomeRoot((CommonTree) adaptor.create(
											UNARY, "UNARY"), root_1);
							adaptor.addChild(root_1, stream_PLUS.nextNode());
							adaptor.addChild(root_1,
									stream_memberExpr.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;
				}

			}
				break;
			case 4:
			// D:\\antlr\\Expression.g:69:5: memberExpr
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_memberExpr_in_unaryExpr457);
				memberExpr31 = memberExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, memberExpr31.getTree());

			}
				break;

			}
			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "unaryExpr"

	public static class memberExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "memberExpr"
	// D:\\antlr\\Expression.g:79:1: memberExpr : basicExpr ( DOT ^ functionExpr
	// )* ;
	public final ExpressionParser.memberExpr_return memberExpr()
			throws RecognitionException {
		ExpressionParser.memberExpr_return retval = new ExpressionParser.memberExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken DOT33 = null;
		ParserRuleReturnScope basicExpr32 = null;
		ParserRuleReturnScope functionExpr34 = null;

		CommonTree DOT33_tree = null;

		try {
			// D:\\antlr\\Expression.g:80:5: ( basicExpr ( DOT ^ functionExpr )*
			// )
			// D:\\antlr\\Expression.g:80:7: basicExpr ( DOT ^ functionExpr )*
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_basicExpr_in_memberExpr476);
				basicExpr32 = basicExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, basicExpr32.getTree());

				// D:\\antlr\\Expression.g:80:17: ( DOT ^ functionExpr )*
				loop9: while (true) {
					int alt9 = 2;
					int LA9_0 = input.LA(1);
					if ((LA9_0 == DOT)) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// D:\\antlr\\Expression.g:80:18: DOT ^ functionExpr
					{
						DOT33 = (CommonToken) match(input, DOT,
								FOLLOW_DOT_in_memberExpr479);
						if (state.failed)
							return retval;
						if (state.backtracking == 0) {
							DOT33_tree = (CommonTree) adaptor.create(DOT33);
							root_0 = (CommonTree) adaptor.becomeRoot(
									DOT33_tree, root_0);
						}

						pushFollow(FOLLOW_functionExpr_in_memberExpr482);
						functionExpr34 = functionExpr();
						state._fsp--;
						if (state.failed)
							return retval;
						if (state.backtracking == 0)
							adaptor.addChild(root_0, functionExpr34.getTree());

					}
						break;

					default:
						break loop9;
					}
				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "memberExpr"

	public static class basicExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "basicExpr"
	// D:\\antlr\\Expression.g:83:1: basicExpr : ( parenExpr | literal |
	// functionExpr );
	public final ExpressionParser.basicExpr_return basicExpr()
			throws RecognitionException {
		ExpressionParser.basicExpr_return retval = new ExpressionParser.basicExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope parenExpr35 = null;
		ParserRuleReturnScope literal36 = null;
		ParserRuleReturnScope functionExpr37 = null;

		try {
			// D:\\antlr\\Expression.g:84:3: ( parenExpr | literal |
			// functionExpr )
			int alt10 = 3;
			switch (input.LA(1)) {
			case LPAREN: {
				alt10 = 1;
			}
				break;
			case TYPE_BOOLEAN:
			case TYPE_DATETIME:
			case TYPE_DOUBLE:
			case TYPE_INTEGER:
			case TYPE_STRING: {
				alt10 = 2;
			}
				break;
			case DATA:
			case IDENTIFIER: {
				alt10 = 3;
			}
				break;
			default:
				if (state.backtracking > 0) {
					state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 10, 0,
						input);
				throw nvae;
			}
			switch (alt10) {
			case 1:
			// D:\\antlr\\Expression.g:84:6: parenExpr
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_parenExpr_in_basicExpr504);
				parenExpr35 = parenExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, parenExpr35.getTree());

			}
				break;
			case 2:
			// D:\\antlr\\Expression.g:84:18: literal
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_literal_in_basicExpr508);
				literal36 = literal();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, literal36.getTree());

			}
				break;
			case 3:
			// D:\\antlr\\Expression.g:84:29: functionExpr
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_functionExpr_in_basicExpr513);
				functionExpr37 = functionExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, functionExpr37.getTree());

			}
				break;

			}
			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "basicExpr"

	public static class parenExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "parenExpr"
	// D:\\antlr\\Expression.g:89:1: parenExpr : LPAREN ! expr RPAREN !;
	public final ExpressionParser.parenExpr_return parenExpr()
			throws RecognitionException {
		ExpressionParser.parenExpr_return retval = new ExpressionParser.parenExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken LPAREN38 = null;
		CommonToken RPAREN40 = null;
		ParserRuleReturnScope expr39 = null;

		CommonTree LPAREN38_tree = null;
		CommonTree RPAREN40_tree = null;

		try {
			// D:\\antlr\\Expression.g:90:5: ( LPAREN ! expr RPAREN !)
			// D:\\antlr\\Expression.g:90:7: LPAREN ! expr RPAREN !
			{
				root_0 = (CommonTree) adaptor.nil();

				LPAREN38 = (CommonToken) match(input, LPAREN,
						FOLLOW_LPAREN_in_parenExpr562);
				if (state.failed)
					return retval;
				pushFollow(FOLLOW_expr_in_parenExpr565);
				expr39 = expr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, expr39.getTree());

				RPAREN40 = (CommonToken) match(input, RPAREN,
						FOLLOW_RPAREN_in_parenExpr568);
				if (state.failed)
					return retval;
			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "parenExpr"

	public static class literal_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "literal"
	// D:\\antlr\\Expression.g:93:1: literal : ( numbericLiteral | stringLiteral
	// | boolLiteral );
	public final ExpressionParser.literal_return literal()
			throws RecognitionException {
		ExpressionParser.literal_return retval = new ExpressionParser.literal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope numbericLiteral41 = null;
		ParserRuleReturnScope stringLiteral42 = null;
		ParserRuleReturnScope boolLiteral43 = null;

		try {
			// D:\\antlr\\Expression.g:94:5: ( numbericLiteral | stringLiteral |
			// boolLiteral )
			int alt11 = 3;
			switch (input.LA(1)) {
			case TYPE_DATETIME:
			case TYPE_DOUBLE:
			case TYPE_INTEGER: {
				alt11 = 1;
			}
				break;
			case TYPE_STRING: {
				alt11 = 2;
			}
				break;
			case TYPE_BOOLEAN: {
				alt11 = 3;
			}
				break;
			default:
				if (state.backtracking > 0) {
					state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 11, 0,
						input);
				throw nvae;
			}
			switch (alt11) {
			case 1:
			// D:\\antlr\\Expression.g:94:9: numbericLiteral
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_numbericLiteral_in_literal594);
				numbericLiteral41 = numbericLiteral();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, numbericLiteral41.getTree());

			}
				break;
			case 2:
			// D:\\antlr\\Expression.g:95:9: stringLiteral
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_stringLiteral_in_literal604);
				stringLiteral42 = stringLiteral();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, stringLiteral42.getTree());

			}
				break;
			case 3:
			// D:\\antlr\\Expression.g:96:7: boolLiteral
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_boolLiteral_in_literal613);
				boolLiteral43 = boolLiteral();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, boolLiteral43.getTree());

			}
				break;

			}
			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "literal"

	public static class numbericLiteral_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "numbericLiteral"
	// D:\\antlr\\Expression.g:99:1: numbericLiteral : ( TYPE_DOUBLE |
	// TYPE_INTEGER | TYPE_DATETIME );
	public final ExpressionParser.numbericLiteral_return numbericLiteral()
			throws RecognitionException {
		ExpressionParser.numbericLiteral_return retval = new ExpressionParser.numbericLiteral_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken set44 = null;

		CommonTree set44_tree = null;

		try {
			// D:\\antlr\\Expression.g:100:5: ( TYPE_DOUBLE | TYPE_INTEGER |
			// TYPE_DATETIME )
			// D:\\antlr\\Expression.g:
			{
				root_0 = (CommonTree) adaptor.nil();

				set44 = (CommonToken) input.LT(1);
				if ((input.LA(1) >= TYPE_DATETIME && input.LA(1) <= TYPE_INTEGER)) {
					input.consume();
					if (state.backtracking == 0)
						adaptor.addChild(root_0,
								(CommonTree) adaptor.create(set44));
					state.errorRecovery = false;
					state.failed = false;
				} else {
					if (state.backtracking > 0) {
						state.failed = true;
						return retval;
					}
					MismatchedSetException mse = new MismatchedSetException(
							null, input);
					throw mse;
				}
			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "numbericLiteral"

	public static class stringLiteral_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "stringLiteral"
	// D:\\antlr\\Expression.g:105:1: stringLiteral : TYPE_STRING ;
	public final ExpressionParser.stringLiteral_return stringLiteral()
			throws RecognitionException {
		ExpressionParser.stringLiteral_return retval = new ExpressionParser.stringLiteral_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken TYPE_STRING45 = null;

		CommonTree TYPE_STRING45_tree = null;

		try {
			// D:\\antlr\\Expression.g:106:5: ( TYPE_STRING )
			// D:\\antlr\\Expression.g:106:9: TYPE_STRING
			{
				root_0 = (CommonTree) adaptor.nil();

				TYPE_STRING45 = (CommonToken) match(input, TYPE_STRING,
						FOLLOW_TYPE_STRING_in_stringLiteral682);
				if (state.failed)
					return retval;
				if (state.backtracking == 0) {
					TYPE_STRING45_tree = (CommonTree) adaptor
							.create(TYPE_STRING45);
					adaptor.addChild(root_0, TYPE_STRING45_tree);
				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "stringLiteral"

	public static class boolLiteral_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "boolLiteral"
	// D:\\antlr\\Expression.g:109:1: boolLiteral : TYPE_BOOLEAN ;
	public final ExpressionParser.boolLiteral_return boolLiteral()
			throws RecognitionException {
		ExpressionParser.boolLiteral_return retval = new ExpressionParser.boolLiteral_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken TYPE_BOOLEAN46 = null;

		CommonTree TYPE_BOOLEAN46_tree = null;

		try {
			// D:\\antlr\\Expression.g:110:3: ( TYPE_BOOLEAN )
			// D:\\antlr\\Expression.g:110:5: TYPE_BOOLEAN
			{
				root_0 = (CommonTree) adaptor.nil();

				TYPE_BOOLEAN46 = (CommonToken) match(input, TYPE_BOOLEAN,
						FOLLOW_TYPE_BOOLEAN_in_boolLiteral701);
				if (state.failed)
					return retval;
				if (state.backtracking == 0) {
					TYPE_BOOLEAN46_tree = (CommonTree) adaptor
							.create(TYPE_BOOLEAN46);
					adaptor.addChild(root_0, TYPE_BOOLEAN46_tree);
				}

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "boolLiteral"

	public static class functionExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "functionExpr"
	// D:\\antlr\\Expression.g:113:1: functionExpr : methodExpr ;
	public final ExpressionParser.functionExpr_return functionExpr()
			throws RecognitionException {
		ExpressionParser.functionExpr_return retval = new ExpressionParser.functionExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope methodExpr47 = null;

		try {
			// D:\\antlr\\Expression.g:114:3: ( methodExpr )
			// D:\\antlr\\Expression.g:114:29: methodExpr
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_methodExpr_in_functionExpr720);
				methodExpr47 = methodExpr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, methodExpr47.getTree());

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "functionExpr"

	public static class methodExpr_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "methodExpr"
	// D:\\antlr\\Expression.g:124:1: methodExpr : ( IDENTIFIER LPAREN (
	// argument ( COMMA argument )* )? RPAREN -> ^( FUNCTION IDENTIFIER (
	// argument )* ) | IDENTIFIER | DATA );
	public final ExpressionParser.methodExpr_return methodExpr()
			throws RecognitionException {
		ExpressionParser.methodExpr_return retval = new ExpressionParser.methodExpr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonToken IDENTIFIER48 = null;
		CommonToken LPAREN49 = null;
		CommonToken COMMA51 = null;
		CommonToken RPAREN53 = null;
		CommonToken IDENTIFIER54 = null;
		CommonToken DATA55 = null;
		ParserRuleReturnScope argument50 = null;
		ParserRuleReturnScope argument52 = null;

		CommonTree IDENTIFIER48_tree = null;
		CommonTree LPAREN49_tree = null;
		CommonTree COMMA51_tree = null;
		CommonTree RPAREN53_tree = null;
		CommonTree IDENTIFIER54_tree = null;
		CommonTree DATA55_tree = null;
		RewriteRuleTokenStream stream_RPAREN = new RewriteRuleTokenStream(
				adaptor, "token RPAREN");
		RewriteRuleTokenStream stream_COMMA = new RewriteRuleTokenStream(
				adaptor, "token COMMA");
		RewriteRuleTokenStream stream_IDENTIFIER = new RewriteRuleTokenStream(
				adaptor, "token IDENTIFIER");
		RewriteRuleTokenStream stream_LPAREN = new RewriteRuleTokenStream(
				adaptor, "token LPAREN");
		RewriteRuleSubtreeStream stream_argument = new RewriteRuleSubtreeStream(
				adaptor, "rule argument");

		try {
			// D:\\antlr\\Expression.g:125:3: ( IDENTIFIER LPAREN ( argument (
			// COMMA argument )* )? RPAREN -> ^( FUNCTION IDENTIFIER ( argument
			// )* ) | IDENTIFIER | DATA )
			int alt14 = 3;
			int LA14_0 = input.LA(1);
			if ((LA14_0 == IDENTIFIER)) {
				int LA14_1 = input.LA(2);
				if ((LA14_1 == LPAREN)) {
					alt14 = 1;
				} else if ((LA14_1 == EOF || (LA14_1 >= AND && LA14_1 <= COMMA)
						|| (LA14_1 >= DIV && LA14_1 <= DOT) || LA14_1 == EQUALS
						|| (LA14_1 >= GT && LA14_1 <= GTEQ)
						|| (LA14_1 >= LT && LA14_1 <= LTEQ)
						|| (LA14_1 >= MINUS && LA14_1 <= MUL)
						|| (LA14_1 >= NOTEQUALS && LA14_1 <= POW) || LA14_1 == RPAREN)) {
					alt14 = 2;
				}

				else {
					if (state.backtracking > 0) {
						state.failed = true;
						return retval;
					}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae = new NoViableAltException(
								"", 14, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			} else if ((LA14_0 == DATA)) {
				alt14 = 3;
			}

			else {
				if (state.backtracking > 0) {
					state.failed = true;
					return retval;
				}
				NoViableAltException nvae = new NoViableAltException("", 14, 0,
						input);
				throw nvae;
			}

			switch (alt14) {
			case 1:
			// D:\\antlr\\Expression.g:125:5: IDENTIFIER LPAREN ( argument (
			// COMMA argument )* )? RPAREN
			{
				IDENTIFIER48 = (CommonToken) match(input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_methodExpr739);
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					stream_IDENTIFIER.add(IDENTIFIER48);

				LPAREN49 = (CommonToken) match(input, LPAREN,
						FOLLOW_LPAREN_in_methodExpr741);
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					stream_LPAREN.add(LPAREN49);

				// D:\\antlr\\Expression.g:125:23: ( argument ( COMMA argument
				// )* )?
				int alt13 = 2;
				int LA13_0 = input.LA(1);
				if ((LA13_0 == DATA || LA13_0 == IDENTIFIER || LA13_0 == LPAREN
						|| LA13_0 == MINUS || LA13_0 == NOT || LA13_0 == PLUS || (LA13_0 >= TYPE_BOOLEAN && LA13_0 <= TYPE_STRING))) {
					alt13 = 1;
				}
				switch (alt13) {
				case 1:
				// D:\\antlr\\Expression.g:125:24: argument ( COMMA argument )*
				{
					pushFollow(FOLLOW_argument_in_methodExpr744);
					argument50 = argument();
					state._fsp--;
					if (state.failed)
						return retval;
					if (state.backtracking == 0)
						stream_argument.add(argument50.getTree());
					// D:\\antlr\\Expression.g:125:33: ( COMMA argument )*
					loop12: while (true) {
						int alt12 = 2;
						int LA12_0 = input.LA(1);
						if ((LA12_0 == COMMA)) {
							alt12 = 1;
						}

						switch (alt12) {
						case 1:
						// D:\\antlr\\Expression.g:125:34: COMMA argument
						{
							COMMA51 = (CommonToken) match(input, COMMA,
									FOLLOW_COMMA_in_methodExpr747);
							if (state.failed)
								return retval;
							if (state.backtracking == 0)
								stream_COMMA.add(COMMA51);

							pushFollow(FOLLOW_argument_in_methodExpr749);
							argument52 = argument();
							state._fsp--;
							if (state.failed)
								return retval;
							if (state.backtracking == 0)
								stream_argument.add(argument52.getTree());
						}
							break;

						default:
							break loop12;
						}
					}

				}
					break;

				}

				RPAREN53 = (CommonToken) match(input, RPAREN,
						FOLLOW_RPAREN_in_methodExpr755);
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					stream_RPAREN.add(RPAREN53);

				// AST REWRITE
				// elements: IDENTIFIER, argument
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				if (state.backtracking == 0) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(
							adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (CommonTree) adaptor.nil();
					// 125:60: -> ^( FUNCTION IDENTIFIER ( argument )* )
					{
						// D:\\antlr\\Expression.g:125:63: ^( FUNCTION
						// IDENTIFIER ( argument )* )
						{
							CommonTree root_1 = (CommonTree) adaptor.nil();
							root_1 = (CommonTree) adaptor.becomeRoot(
									(CommonTree) adaptor.create(FUNCTION,
											"FUNCTION"), root_1);
							adaptor.addChild(root_1,
									stream_IDENTIFIER.nextNode());
							// D:\\antlr\\Expression.g:125:85: ( argument )*
							while (stream_argument.hasNext()) {
								adaptor.addChild(root_1,
										stream_argument.nextTree());
							}
							stream_argument.reset();

							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;
				}

			}
				break;
			case 2:
			// D:\\antlr\\Expression.g:126:5: IDENTIFIER
			{
				root_0 = (CommonTree) adaptor.nil();

				IDENTIFIER54 = (CommonToken) match(input, IDENTIFIER,
						FOLLOW_IDENTIFIER_in_methodExpr772);
				if (state.failed)
					return retval;
				if (state.backtracking == 0) {
					IDENTIFIER54_tree = (CommonTree) adaptor
							.create(IDENTIFIER54);
					adaptor.addChild(root_0, IDENTIFIER54_tree);
				}

			}
				break;
			case 3:
			// D:\\antlr\\Expression.g:127:5: DATA
			{
				root_0 = (CommonTree) adaptor.nil();

				DATA55 = (CommonToken) match(input, DATA,
						FOLLOW_DATA_in_methodExpr778);
				if (state.failed)
					return retval;
				if (state.backtracking == 0) {
					DATA55_tree = (CommonTree) adaptor.create(DATA55);
					adaptor.addChild(root_0, DATA55_tree);
				}

			}
				break;

			}
			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "methodExpr"

	public static class argument_return extends ParserRuleReturnScope {
		CommonTree tree;

		@Override
		public CommonTree getTree() {
			return tree;
		}
	};

	// $ANTLR start "argument"
	// D:\\antlr\\Expression.g:131:1: argument : expr ;
	public final ExpressionParser.argument_return argument()
			throws RecognitionException {
		ExpressionParser.argument_return retval = new ExpressionParser.argument_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr56 = null;

		try {
			// D:\\antlr\\Expression.g:132:5: ( expr )
			// D:\\antlr\\Expression.g:132:9: expr
			{
				root_0 = (CommonTree) adaptor.nil();

				pushFollow(FOLLOW_expr_in_argument805);
				expr56 = expr();
				state._fsp--;
				if (state.failed)
					return retval;
				if (state.backtracking == 0)
					adaptor.addChild(root_0, expr56.getTree());

			}

			retval.stop = input.LT(-1);

			if (state.backtracking == 0) {
				retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
				adaptor.setTokenBoundaries(retval.tree, retval.start,
						retval.stop);
			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (CommonTree) adaptor.errorNode(input, retval.start,
					input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "argument"

	/**
	 * 每次重新生成需要添加的部分
	 */
	ArrayList exceptions = new ArrayList();

	public Override ReportError(RecognitionException e) {
		exceptions.add(e);
		return null;
	}

	public Override DisplayRecognitionError(String[] tokenNames,
			RecognitionException e) {
		return DisplayRecognitionError(tokenNames, e);
	}

	public Boolean HasError() {
		return exceptions.size() > 0;
	}

	public String GetErrorMessage() {

		StringBuilder sb = new StringBuilder();
		for (Object m : exceptions) {
			RecognitionException t = (RecognitionException) m;
			sb.append(String.format("Œª÷√:{0}£¨¥ÌŒÛ:{1}\r\n",
					this.getErrorHeader(t),
					this.getErrorMessage(t, this.getTokenNames())));
		}
		return sb.toString();
	}

	// Delegated rules

	public static final BitSet FOLLOW_expr_in_expression118 = new BitSet(
			new long[] { 0x0000000000000000L });
	public static final BitSet FOLLOW_EOF_in_expression120 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_logicalOrExpr_in_expr134 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_logicalAndExpr_in_logicalOrExpr149 = new BitSet(
			new long[] { 0x0000000010000002L });
	public static final BitSet FOLLOW_OR_in_logicalOrExpr152 = new BitSet(
			new long[] { 0x0000003E25110040L });
	public static final BitSet FOLLOW_logicalAndExpr_in_logicalOrExpr155 = new BitSet(
			new long[] { 0x0000000010000002L });
	public static final BitSet FOLLOW_equalityExpr_in_logicalAndExpr195 = new BitSet(
			new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_AND_in_logicalAndExpr198 = new BitSet(
			new long[] { 0x0000003E25110040L });
	public static final BitSet FOLLOW_equalityExpr_in_logicalAndExpr201 = new BitSet(
			new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_relationalExpr_in_equalityExpr244 = new BitSet(
			new long[] { 0x0000000008000402L });
	public static final BitSet FOLLOW_set_in_equalityExpr247 = new BitSet(
			new long[] { 0x0000003E25110040L });
	public static final BitSet FOLLOW_relationalExpr_in_equalityExpr254 = new BitSet(
			new long[] { 0x0000000008000402L });
	public static final BitSet FOLLOW_additiveExpr_in_relationalExpr271 = new BitSet(
			new long[] { 0x000000000060C002L });
	public static final BitSet FOLLOW_set_in_relationalExpr274 = new BitSet(
			new long[] { 0x0000003E25110040L });
	public static final BitSet FOLLOW_additiveExpr_in_relationalExpr285 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_multiplyExpr_in_additiveExpr302 = new BitSet(
			new long[] { 0x0000000021000002L });
	public static final BitSet FOLLOW_set_in_additiveExpr305 = new BitSet(
			new long[] { 0x0000003E25110040L });
	public static final BitSet FOLLOW_multiplyExpr_in_additiveExpr312 = new BitSet(
			new long[] { 0x0000000021000002L });
	public static final BitSet FOLLOW_powExpr_in_multiplyExpr331 = new BitSet(
			new long[] { 0x0000000002000082L });
	public static final BitSet FOLLOW_set_in_multiplyExpr334 = new BitSet(
			new long[] { 0x0000003E25110040L });
	public static final BitSet FOLLOW_powExpr_in_multiplyExpr343 = new BitSet(
			new long[] { 0x0000000002000082L });
	public static final BitSet FOLLOW_unaryExpr_in_powExpr373 = new BitSet(
			new long[] { 0x0000000040000002L });
	public static final BitSet FOLLOW_POW_in_powExpr376 = new BitSet(
			new long[] { 0x0000003E25110040L });
	public static final BitSet FOLLOW_unaryExpr_in_powExpr379 = new BitSet(
			new long[] { 0x0000000040000002L });
	public static final BitSet FOLLOW_MINUS_in_unaryExpr398 = new BitSet(
			new long[] { 0x0000003E00110040L });
	public static final BitSet FOLLOW_memberExpr_in_unaryExpr400 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_NOT_in_unaryExpr418 = new BitSet(
			new long[] { 0x0000003E00110040L });
	public static final BitSet FOLLOW_memberExpr_in_unaryExpr420 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_PLUS_in_unaryExpr438 = new BitSet(
			new long[] { 0x0000003E00110040L });
	public static final BitSet FOLLOW_memberExpr_in_unaryExpr440 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_memberExpr_in_unaryExpr457 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_basicExpr_in_memberExpr476 = new BitSet(
			new long[] { 0x0000000000000102L });
	public static final BitSet FOLLOW_DOT_in_memberExpr479 = new BitSet(
			new long[] { 0x0000000000010040L });
	public static final BitSet FOLLOW_functionExpr_in_memberExpr482 = new BitSet(
			new long[] { 0x0000000000000102L });
	public static final BitSet FOLLOW_parenExpr_in_basicExpr504 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_literal_in_basicExpr508 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_functionExpr_in_basicExpr513 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_LPAREN_in_parenExpr562 = new BitSet(
			new long[] { 0x0000003E25110040L });
	public static final BitSet FOLLOW_expr_in_parenExpr565 = new BitSet(
			new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_RPAREN_in_parenExpr568 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_numbericLiteral_in_literal594 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_stringLiteral_in_literal604 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_boolLiteral_in_literal613 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TYPE_STRING_in_stringLiteral682 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_TYPE_BOOLEAN_in_boolLiteral701 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_methodExpr_in_functionExpr720 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_methodExpr739 = new BitSet(
			new long[] { 0x0000000000100000L });
	public static final BitSet FOLLOW_LPAREN_in_methodExpr741 = new BitSet(
			new long[] { 0x0000003F25110040L });
	public static final BitSet FOLLOW_argument_in_methodExpr744 = new BitSet(
			new long[] { 0x0000000100000020L });
	public static final BitSet FOLLOW_COMMA_in_methodExpr747 = new BitSet(
			new long[] { 0x0000003E25110040L });
	public static final BitSet FOLLOW_argument_in_methodExpr749 = new BitSet(
			new long[] { 0x0000000100000020L });
	public static final BitSet FOLLOW_RPAREN_in_methodExpr755 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_IDENTIFIER_in_methodExpr772 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DATA_in_methodExpr778 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expr_in_argument805 = new BitSet(
			new long[] { 0x0000000000000002L });
}
