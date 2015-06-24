	package org.antlr.ext.ConditionExpression.Visitor;

import java.util.Date;
import java.util.HashMap;

import org.antlr.ext.ConditionExpression.ExpressionException;
import org.antlr.ext.ConditionExpression.Utility.ReflectionHelper;

public class ExpressionValueTypeWalkerHelper{

	public ExpressionValueTypeWalkerHelper(){
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object logicAnd(Object left, Object right) throws RuntimeException{
		return Boolean.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object logicOr(Object left, Object right) throws RuntimeException{
		return Boolean.class;
	}

	/**
	 * 
	 * @param o
	 */
	public Object logicNot(Object o) throws RuntimeException{
		return Boolean.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object mathMul(Object left, Object right) throws RuntimeException{
		if(left.equals(Double.class)) return Double.class;
		if(right.equals(Double.class))return Double.class;
		
		return Integer.class;
		
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object mathDiv(Object left, Object right) throws RuntimeException{
		
		if(left.equals(Double.class)) return Double.class;
		if(right.equals(Double.class))return Double.class;
		
		return Integer.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object mathPlus(Object left, Object right) throws RuntimeException{
		//string
		if(left.equals(String.class) || right.equals(String.class)) return String.class;
		//date
		if(left.equals(Date.class) || right.equals(Date.class)) return Date.class;
		//double
		if(left.equals(Double.class) || right.equals(Double.class)) return Double.class;
		//finally Integer
		return Integer.class;
		
		
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object mathMinus(Object left, Object right) throws RuntimeException{
		
		//date
		if(left.equals(Date.class))
		{
			if(right.equals(Date.class)){
				return Integer.class;
			}
			else{
				return Date.class;
			}
		}
		
		//double
		if(left.equals(Double.class) || right.equals(Double.class)) return Double.class;
		//finally Integer
		return Integer.class;
		
	}

	/**
	 * 
	 * @param o
	 */
	public Object unaryMinus(Object o) throws RuntimeException{
		
		if(o.equals(Integer.class)){
			return Integer.class;
		}
		else{
			return Double.class;
		}
	}

	/**
	 * 
	 * @param o
	 */
	public Object unaryPlus(Object o) throws RuntimeException{
		if(o.equals(Integer.class)){
			return Integer.class;
		}
		else{
			return Double.class;
		}
	}
	
	/**
	 * 
	 * @param o
	 */
	public Object unaryNot(Object o) throws RuntimeException{
			return Boolean.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object compareEqual(Object left, Object right) throws RuntimeException{
		
		return Boolean.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object compareNotEqual(Object left, Object right) throws RuntimeException{
		
		return Boolean.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object compareGreater(Object left, Object right) throws RuntimeException{
		return Boolean.class;
						
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object compareLess(Object left, Object right) throws RuntimeException{
		return Boolean.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object compareGreaterEqual(Object left, Object right) throws RuntimeException{
		return Boolean.class;
	}

	/**
	 * 
	 * @param left
	 * @param right
	 */
	public Object compareLessEqual(Object left, Object right) throws RuntimeException{
		return Boolean.class;
	}

	/**
	 * 
	 * @param target
	 * @param prop
	 */
	public Object classPropertyDot(Object target, String prop) throws Exception{
		return ReflectionHelper.getPropertyType((Class)target, prop);
	}

	/**
	 * 
	 * @param target
	 * @param info
	 */
	public Object classMethodDot(Object target, FunctionInfo info) throws Exception{
		Class[] temp=null;
		if(info.params!=null){
			temp=new Class[info.params.length];
			for(int i=0; i < info.params.length;i++){
				temp[i]=(Class)info.params[i];
			}
		}
		return ReflectionHelper.getMethodReturnType((Class)target, info.funcname, temp);
	}

	/**
	 * 
	 * @param key
	 */
	public Object keyDollar(String key,HashMap<String,Object> data,HashMap<String,Object> local) throws RuntimeException{
		//first:find in local
		if(local.containsKey(key)){
			if(local.get(key) instanceof Class) return local.get(key);
			return (local.get(key)).getClass();
		}
		//second:find in global data
		if(data.containsKey(key)){
			if(data.get(key) instanceof Class) return data.get(key);
			return (data.get(key)).getClass();
		}
		//throw exception when key not found in both hashmap
		throw new ExpressionException();

	}

	/**
	 * 
	 * @param str
	 */
	public Object basicTypeInt(String str) throws RuntimeException{
		return Integer.class;
	}

	/**
	 * 
	 * @param str
	 */
	public Object basicTypeDouble(String str) throws RuntimeException{
		return Double.class;
	}

	/**
	 * 
	 * @param str
	 */
	public Object basicTypeString(String str) throws RuntimeException{
		return String.class;
	}

	/**
	 * 
	 * @param str
	 */
	public Object basicTypeDateTime(String str) throws Exception{
		return Date.class;

	}

	/**
	 * 
	 * @param str
	 */
	public Object basicTypeBoolean(String str) throws RuntimeException{
		return Boolean.class;
	}

	/**
	 * 
	 * @param str
	 */
	public String basicIdentifier(String str) throws RuntimeException{
		return str;
	}
	
	
	

}
