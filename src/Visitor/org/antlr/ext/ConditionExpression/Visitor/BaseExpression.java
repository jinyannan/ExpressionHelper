package  org.antlr.ext.ConditionExpression.Visitor;

//import ExpressionParser;
//import FunctionInfo;
//import ExpressionParser;
//import FunctionInfo;
import java.util.HashMap;
//import ExpressionParser;
import org.antlr.ext.ConditionExpression.ExpressionException;
import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.ext.ConditionExpression.Utility.IGetValue;
import org.antlr.runtime.tree.Tree;
import org.stringtemplate.v4.compiler.STParser.andConditional_return;

import com.sun.org.apache.bcel.internal.generic.NEW;

public abstract class BaseExpression
{
	private static final int HashMap = 0;
	//public RootVisit rootVisit;
	//public abstract object Evaluate(ITree tree);
	public abstract Object Evaluate() throws Exception;
	public abstract Object Evaluate(Object data) throws Exception;
	public abstract Object Evaluate(Object data, Object local) throws Exception;
	protected Tree _tree;
	private IGetValue _getValueOperation;
	public final IGetValue getUserFunction()
	{
		return _getValueOperation;
	}
	public final void setUserFunction(IGetValue value)
	{
		_getValueOperation = value;
	}

	public BaseExpression(Tree tree)
	{
		_tree = tree;
	}

	/** 
	 根据一个表达式基类创建子类,其中的_userFunction等内容与基类相同
	 
	 @param exp
	 @param tree
	*/
	public BaseExpression(BaseExpression exp, Tree tree)
	{
		_tree = tree;
		_getValueOperation = exp._getValueOperation;
	}


	public Object VisitSubTree(Tree tree, Object data, Object local) throws Exception
	{
		try
		{
			switch (tree.getType())
			{
					///#region value
				case ExpressionLexer.TYPE_INTEGER:
				case ExpressionLexer.TYPE_STRING:
				case ExpressionLexer.TYPE_DOUBLE:
				case ExpressionLexer.TYPE_BOOLEAN:
				case ExpressionLexer.TYPE_DATETIME:
					return new ValueExpression(this, tree).Evaluate(data, local);
					///#endregion

					///#region basicCalc
				case ExpressionLexer.PLUS:
				case ExpressionLexer.MINUS:
				case ExpressionLexer.MUL:
				case ExpressionLexer.DIV:
				case ExpressionLexer.POW:
					return new BasicCalExpression(this, tree).Evaluate(data, local);
					///#endregion

					///#region LogicCalc
				case ExpressionLexer.AND:
				case ExpressionLexer.OR:
					return new LogicalExpression(this, tree).Evaluate(data, local);
					///#endregion

					///#region Unary
				//case ExpressionLexer.NOT:
				case ExpressionLexer.UNARY:
					return new UnaryExpression(this, tree).Evaluate(data, local);
					///#endregion

					///#region Compare
				case ExpressionLexer.EQUALS:
				case ExpressionLexer.NOTEQUALS:
				case ExpressionLexer.GT:
				case ExpressionLexer.GTEQ:
				case ExpressionLexer.LT:
				case ExpressionLexer.LTEQ:
					return new CompareExpression(this, tree).Evaluate(data, local);
					///#endregion

					///#region Function
					//XXX:查找数据集，如果local中存在该记录集，则使用local的
				case ExpressionLexer.DATA:
					String keyvalue=tree.getText();
					String realKeyValue = keyvalue.substring(1,keyvalue.length());
					HashMap<String, Object> hm = (HashMap<String, Object>) data;
					if (local != null) {
						HashMap<String, Object> hmlocal = (HashMap<String, Object>)local;
						if (hmlocal.containsKey(realKeyValue)) {
							return (Object)hmlocal.get(realKeyValue);
						}else {
							return (Object)hm.get(realKeyValue);
						}
					}else {
						return (Object)hm.get(realKeyValue);
					}
				case ExpressionLexer.IDENTIFIER:
					String result=tree.getText();
					//if(data.containsKey(tree.getText())){
					//	result=data.get(tree.getText());
					//}
					return result;
				case ExpressionLexer.DOT:
					DotExpression expression = new DotExpression(this, tree);
					return expression.Evaluate(data, local);
				case ExpressionLexer.FUNCTION:
					//return new FunctionExpression(this, tree).Evaluate(data);
					
					if(tree.getParent() != null && tree.getParent().getType()==ExpressionLexer.DOT)
					{
						Object funcname=VisitSubTree(tree.getChild(0), data, local);
						Object[] params=null;
						Class[] classes=null;
						if(tree.getChildCount()>1){
							params=new Object[tree.getChildCount()-1];
							classes=new Class[tree.getChildCount()-1];
						}
						for(int i=0; i <tree.getChildCount()-1; i++)
						{
							params[i]=VisitSubTree(tree.getChild(i+1), data, local);
							classes[i]=params[i].getClass();
						}
						//call class's member method
						return new FunctionInfo((String)funcname,params,classes);
					}
					else
					{
						return new FunctionExpression(this, tree).Evaluate(data, local);    
					}
					///#endregion
				default:
					throw GetTreeException("无法识别的节点类型");
			}
		}
		catch (RuntimeException e)
		{
			throw GetTreeException("出现错误", e);
		}
	}

	private java.util.HashMap HashMap(Object data) {
		// TODO Auto-generated method stub
		return null;
	}
	protected final RuntimeException GetTreeException(String message)
	{
		String t = String.format("%1$s,位置:%2$s,详细信息：%3$s", message, _tree.getCharPositionInLine(), _tree.toStringTree());
		return new ExpressionException(t);
	}

	protected final RuntimeException GetTreeException(String message, RuntimeException e)
	{
		String t = String.format("%1$s,位置:%2$s", message, _tree.getCharPositionInLine());
		return new ExpressionException(t, e);
	}
	
}