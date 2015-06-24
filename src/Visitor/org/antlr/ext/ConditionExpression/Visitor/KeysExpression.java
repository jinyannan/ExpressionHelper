package org.antlr.ext.ConditionExpression.Visitor;

import java.util.HashMap;
import java.util.HashSet;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.runtime.tree.Tree;

public class KeysExpression extends BaseExpression {
	
	public KeysExpression(Tree tree) {
		super(tree);
	}

	public KeysExpression(BaseExpression exp, Tree tree) {
		super(exp, tree);
	}
	
	@Override
	@SuppressWarnings(value = { "unchecked" ,"unused"})
	public Object Evaluate(Object data, Object local) throws Exception {

		Object leftResult, rightResult;
		int treeType = _tree.getType();
		switch (treeType) {
		case ExpressionLexer.TYPE_INTEGER:
		case ExpressionLexer.TYPE_STRING:
		case ExpressionLexer.TYPE_DOUBLE:
		case ExpressionLexer.TYPE_BOOLEAN:
		case ExpressionLexer.TYPE_DATETIME:
		case ExpressionLexer.IDENTIFIER:
			return (Object)_tree.getText();
		case ExpressionLexer.PLUS:
		case ExpressionLexer.MINUS:
		case ExpressionLexer.MUL:
		case ExpressionLexer.DIV:
		case ExpressionLexer.POW:
		case ExpressionLexer.AND:
		case ExpressionLexer.OR:
		case ExpressionLexer.EQUALS:
		case ExpressionLexer.NOTEQUALS:
		case ExpressionLexer.GT:
		case ExpressionLexer.GTEQ:
		case ExpressionLexer.LT:
		case ExpressionLexer.LTEQ:
		case ExpressionLexer.DOT:
			leftResult = new KeysExpression(_tree.getChild(0)).Evaluate(data, local);
			rightResult = new KeysExpression(_tree.getChild(1)).Evaluate(data, local);
			return null;
		case ExpressionLexer.UNARY:
			rightResult = new KeysExpression(_tree.getChild(1)).Evaluate(data, local);
			return null;
		case ExpressionLexer.DATA:
			String keyvalue = _tree.getText();
			String key = "DataKeys";
			
			HashMap<String, Object>hmlocal = (local == null ? new HashMap<String, Object>() 
																	: (HashMap<String, Object>)local);
			HashSet<String> keys = (HashSet<String>) (hmlocal.containsKey(key) ? hmlocal.get(key) 
													: new HashSet<String>());
			keys.add(keyvalue.substring(1, keyvalue.length()));
			hmlocal.put(key, keys);
			return (Object)keyvalue;

		case ExpressionLexer.FUNCTION:
			if (_tree.getParent() != null
					&& _tree.getParent().getType() == ExpressionLexer.DOT) {
				Object funcname = VisitSubTree(_tree.getChild(0), data, local);
				Object[] params = null;
				Class[] classes = null;
				if (_tree.getChildCount() > 1) {
					params = new Object[_tree.getChildCount() - 1];
					classes = new Class[_tree.getChildCount() - 1];
				}
				for (int i = 0; i < _tree.getChildCount() - 1; i++) {
					params[i] = new KeysExpression(_tree.getChild(i + 1)).Evaluate(data, local);
					classes[i] = params[i].getClass();
				}
				return null;
			} else {
				Object[] params = null;
				Class[] classes = null;
				Object obj = null;
				for (int i = 0; i < _tree.getChildCount() - 1; i++) {
					try {
						obj = new KeysExpression(_tree.getChild(i + 1)).Evaluate(data, local);
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("");
					}
				}
			}
		default:
			//throw GetTreeException("无法识别的节点类型");
			return null;
		}

	}

	@Override
	public Object Evaluate(Object data) throws Exception {
		return Evaluate(data, null);
	}

	@Override
	public Object Evaluate() throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();
		HashMap<String, Object> local = new HashMap<String, Object>();
		Object object = Evaluate((Object)data, (Object)local);
		HashSet<String> hs = (HashSet<String>)local.get("DataKeys");
		return hs.toArray();
	}
}