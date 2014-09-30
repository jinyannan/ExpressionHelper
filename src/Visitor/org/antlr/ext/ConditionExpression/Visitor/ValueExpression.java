package org.antlr.ext.ConditionExpression.Visitor;

import org.antlr.ext.ConditionExpression.Generated.ExpressionLexer;
import org.antlr.runtime.tree.Tree;

public class ValueExpression extends BaseExpression
{
	public ValueExpression(BaseExpression exp, Tree tree)
	{
		super(exp, tree);
	}

	@Override
	public Object Evaluate(Object data)
	{
		String text = _tree.getText();
		

		/**时间和字符串类型有分隔符，需要去掉
		*/
		switch (_tree.getType())
		{
			case ExpressionLexer.TYPE_INTEGER:
				return Integer.parseInt(text);
			case ExpressionLexer.TYPE_DOUBLE:
				return Double.parseDouble(text);
			case ExpressionLexer.TYPE_BOOLEAN:
				return Boolean.parseBoolean(text);
			case ExpressionLexer.TYPE_DATETIME:
				text = text.substring(1, 1 + text.length() - 2);
				return new java.util.Date(java.util.Date.parse(text));
				/**为提高效率时间类型也按字符串处理
				//return text.Substring(1, text.Length - 2);
				*/
			case ExpressionLexer.TYPE_STRING:
				text = text.substring(1, 1 + text.length() - 2);
				try {
					java.util.Date t = new java.util.Date(text);
					// RefObject<java.util.Date> tempRef_t = new
					// RefObject<java.util.Date>(t);//MZHY
						
					return t;					
				} catch (Exception e) {
					// TODO: handle exception
					return text;
				}
				
			default:
				throw GetTreeException(String.format("无法识别的操作符[%1$s]", _tree.getType()));
		}

	}
}