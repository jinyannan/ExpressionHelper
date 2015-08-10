package org.antlr.ext.ConditionExpression;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.ext.ConditionExpression.Generated.ExpressionParser;
import org.antlr.ext.ConditionExpression.Utility.GetTypeUtility;
import org.antlr.ext.ConditionExpression.Utility.IGetValue;
import org.antlr.ext.ConditionExpression.Utility.ReflectionHelper;
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
import org.antlr.runtime.tree.Tree;

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
	
	public boolean is_hasCompile() {
		return _hasCompile;
	}

	public void set_hasCompile(boolean _hasCompile) {
		this._hasCompile = _hasCompile;
	}

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

	/**
	 * 如果需要缓存tree以提高工作效率，使用下列两个方法直接传入tree，不通过compile生成
	 * 
	 * @return
	 */
	public CommonTree get_tree() {
		return _tree;
	}

	public void set_tree(CommonTree _tree) {
		this._tree = _tree;
	}

	public final Object Calculate(Object data) throws Exception {
		HashMap<String, Object> local = new HashMap<String, Object>();
		return Calculate(data, (Object)local);
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
		HashMap<String, Object> local = new HashMap<String, Object>();
		return ExecuteExpression(exprCond, data, (Object)local);
	}

	public final Object ExecuteExpression(String exprCond, Object data,
			Object local) {
		Object result = null;
		_expressionString = exprCond;
		
		if (exprCond == null || exprCond.trim().equals("")) {
			return true;
		}
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
				//result = m.toString();
				result = m;
			}
		} catch (Exception e) {
			result = "error";
		}
		return m;
	}

	public final Object ExecuteExpression(String exprCond, Object data,
			Object local, Object cache) {
		String result = "";
		Object m = null;

		try {
			if (cache != null) {
				HashMap<String, Tree> treeCache = (HashMap<String, Tree>)cache;
				if (treeCache.containsKey(exprCond)) {
					_tree = (CommonTree)treeCache.get(exprCond);
					_hasCompile = true;
				}else {
					Compile();
					treeCache.put(exprCond, _tree);
				}
			}
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
	
	public final String[] GetKeys(String exprCond){
		HashMap<String, Object> data = new HashMap<String, Object>();
		HashMap<String, Object> local = new HashMap<String, Object>();
		return GetKeys(exprCond, data, local);
	}
	
	public final String[] GetKeys(String exprCond, Object data,
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
			return (String[]) hs.toArray();

		} catch (Exception e) {
			//result = "error";
			e.printStackTrace();
			
			return null;
		}
	}
	
	public Object getType(String exprCond, Object data) throws Exception{
		HashMap<String, Object> local = new HashMap<String, Object>();
		return getType(exprCond, data, (Object)local);
	}
	
	public Object getType(String exprCond, Object data, Object local) throws Exception {
		String result = "";
		Object m = null;
		_expressionString = cutExpression(exprCond);
		
		try {
			Compile();
			if (!_hasCompile) {
				Compile();
			}
			TypeExpression exp = new TypeExpression(_tree);
			return (Object) exp.Evaluate(data, local);
			
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 返回表达式结果对象的方法
	 * @param exprCond
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<Method> getTypeMethods(String exprCond, Object data) throws Exception {
		return ReflectionHelper.getMethods((Class) getType(exprCond, data), "");
	}
	
	/**
	 * 返回表达式结果对象的属性
	 * @param exprCond
	 * @param data
	 * @return
	 * @throws Exception 
	 */
	public ArrayList<Field> getTypeFields(String exprCond, Object data) throws Exception {
		return ReflectionHelper.getFields((Class) getType(exprCond, data), "");
	}
	
	/**
	 * 计算表达式返回类型时剪切不完整的表达式
	 * @param exp
	 * @return
	 */
	public String cutExpression(String exp) {
		return new GetTypeUtility().cutExpression(exp);
	}
	
}