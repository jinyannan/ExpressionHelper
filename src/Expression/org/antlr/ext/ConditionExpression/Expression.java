package org.antlr.ext.ConditionExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.ext.ConditionExpression.Generated.ExpressionParser;
import org.antlr.ext.ConditionExpression.Utility.IGetValue;
import org.antlr.ext.ConditionExpression.Visitor.KeysExpression;
import org.antlr.ext.ConditionExpression.Visitor.RootExpression;
import org.antlr.ext.ConditionExpression.Visitor.TypeExpression;
import org.antlr.grammar.v3.ANTLRParser.finallyClause_return;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import ExpressionHelper.EntryHelper;

/**
 * @param funcName
 * @param funcParams
 * @param data
 * @return
 */
// public delegate object GetValue(string funcName, object[] funcParams, object
// data);

public class Expression {
	private String _expressionString;
	private boolean _hasCompile;
	private CommonTree _tree;
	private IGetValue _getValueOperation;

	public final IGetValue getUserFunction() {
		return _getValueOperation;
	}

	public final void setUserFunction(IGetValue value) {
		_getValueOperation = value;
	}

	public Expression() {
		_expressionString = "";
		_hasCompile = false;
	}

	public Expression(String expressionString) {
		_expressionString = expressionString;
		_hasCompile = false;
	}

	public Expression(String expressionString, IGetValue userFunc) {
		_expressionString = expressionString;
		_getValueOperation = userFunc;
		_hasCompile = false;
	}

	/**
	 * 解析表达式
	 * 
	 * @throws Exception
	 * @throws RecognitionException
	 */
	public final void Compile() throws Exception {
		CharStream input = new ANTLRStringStream(_expressionString);
		ExpressionLexer lex = new ExpressionLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lex);
		ExpressionParser parser = new ExpressionParser(tokens);
		ParserRuleReturnScope r;
		try {
			r = parser.expression();
			if (lex.HasError()) {
				throw new ExpressionException(lex.GetErrorMessage());
			}
			if (parser.HasError()) {
				throw new ExpressionException(parser.GetErrorMessage());
			}

			_tree = (CommonTree) r.getTree();
			_hasCompile = true;
		} catch (RecognitionException e) {
			throw new Exception(e.getMessage());
		}

	}

	public final Object Calculate(Object data) throws Exception {
		return Calculate(data, null);
	}

	public final Object Calculate(Object data, Object local) throws Exception {
		if (!_hasCompile) {
			Compile();
		}
		RootExpression exp = new RootExpression(_tree);
		exp.setUserFunction(_getValueOperation);
		return exp.Evaluate(data, local);
	}

	public final Object Calculate(Object data, Object local, IGetValue func)
			throws Exception {
		this.setUserFunction(func);
		return this.Calculate(data, local);
	}

	public final Object ExecuteExpression(String exprCond, Object data) {
		return ExecuteExpression(exprCond, data, null);
	}

	public final Object ExecuteExpression(String exprCond, Object data,
			Object local) {
		String result = "";
		Object m = null;

		try {
			Compile();
			if (data == null) {
				// data = (Object) ExecRuleHelper.getTestData();
				result = "";
			}
			m = Calculate(data, local);
			if (m == null) {
				result = "error";
			} else {
				result = m.toString();
			}
		} catch (Exception e) {
			result = "error";
		}
		return m;
	}

	public final Object[] GetKeys(String exprCond){
		HashMap<String, Object> data = new HashMap<String, Object>();
		HashMap<String, Object> local = new HashMap<String, Object>();
		return GetKeys(exprCond, data, local);
	}
	
	public final Object[] GetKeys(String exprCond, Object data,
			Object local) {
		String result = "";
		Object m = null;
		_expressionString = exprCond;
		
		try {
			Compile();
			if (!_hasCompile) {
				Compile();
			}
			KeysExpression exp = new KeysExpression(_tree);
			m = (Object) exp.Evaluate(data, local);
			HashMap<String, HashSet<String>> hmlocal = (HashMap<String, HashSet<String>>) local;
			HashSet<String> hs = hmlocal.get("DataKeys");
			return hs.toArray();

		} catch (Exception e) {
			//result = "error";
			e.printStackTrace();
			
			return null;
		}
	}
	
	public final Object getType(String exprCond) {
		String result = "";
		Object m = null;
		_expressionString = exprCond;
		
		try {
			Compile();
			if (!_hasCompile) {
				Compile();
			}
			TypeExpression exp = new TypeExpression(_tree);
			return (Object) exp.Evaluate();
			
		} catch (Exception e) {
			result = "error";
			return null;
		}
	}
	
}