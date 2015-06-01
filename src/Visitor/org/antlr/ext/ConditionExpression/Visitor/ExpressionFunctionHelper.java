package org.antlr.ext.ConditionExpression.Visitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.antlr.ext.ConditionExpression.*;
import org.antlr.ext.ConditionExpression.Utility.*;
import org.antlr.runtime.tree.Tree;

public class ExpressionFunctionHelper {
	/**
	 * 
	 * @param func_name
	 * @param params
	 * @param needParamsCount
	 * @param paramsType
	 */
	private static void checkParams(String func_name,Object[] params,int needParamsCount,Class[] paramsType)
	{
		//no params
		if(needParamsCount==0) return;
		
		if(params==null) throw new ExpressionException(func_name);
		
		if(params.length != needParamsCount) throw new ExpressionException(func_name);
		
		for(int i=0 ; i < params.length ; i++)
		{
			if(!params[i].getClass().equals(paramsType[i])  && !paramsType[i].isAssignableFrom(params[i].getClass())){
				throw new ExpressionException(func_name);
			}
		}
	}
	
	/**
	 * 
	 * @param func_name
	 * @param params
	 * @param walker
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	public static Object execute(String func_name,Object[] params,HashMap<String,Object> data,HashMap<String,Object> local) throws Exception
	{
		Object o=null;
		
		//FILTER
		if(func_name.equalsIgnoreCase("FILTER"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("FILTER", params, 3, new Class[]{ArrayList.class,String.class,String.class});
			//call filter
			o=ExpressionFunctionHelper.filter((ArrayList)params[0],(String)params[1], (String)params[2], data, local);
			return o;
		}
		
		//Count
		if(func_name.equalsIgnoreCase("Count"))
		{
			if(params==null) throw new ExpressionException(func_name);
			if(params.length==0) throw new ExpressionException(func_name);
			if(params.length==1)
			{
				//check params
				ExpressionFunctionHelper.checkParams("Count", params, 1, new Class[]{ArrayList.class});
				//call count
				o=ExpressionFunctionHelper.count((ArrayList)params[0]);
			}
			else{
				//check params
				ExpressionFunctionHelper.checkParams("Count", params, 3, new Class[]{ArrayList.class,String.class,String.class});
				//call count
				o=ExpressionFunctionHelper.count((ArrayList)params[0],(String)params[1], (String)params[2], data, local);
			}
			return o;
		}
		
		//Count
		if(func_name.equalsIgnoreCase("Exist"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("Exist", params, 3, new Class[]{ArrayList.class,String.class,String.class});
			//call exist
			o=ExpressionFunctionHelper.exist((ArrayList)params[0],(String)params[1], (String)params[2], data, local);
			return o;
		}
		
		//existKey
		if(func_name.equalsIgnoreCase("ExistKey"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("ExistKey", params, 1, new Class[]{String.class});
			//call
			o=ExpressionFunctionHelper.existKey((String)params[0], data, local);
			return o;
		}
		
		//isnull
		if(func_name.equalsIgnoreCase("IsNull"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("IsNull", params, 1, new Class[]{Object.class});
			//call
			o=ExpressionFunctionHelper.isNull((Object)params[0]);
			return o;
		}
		
		//isnotnull
		if(func_name.equalsIgnoreCase("IsNotNull"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("IsNotNull", params, 1, new Class[]{Object.class});
			//call
			o=ExpressionFunctionHelper.isNotNull((Object)params[0]);
			return o;
		}
		
		//string func
		//charIndex
		if(func_name.equalsIgnoreCase("CHARINDEX"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("CHARINDEX", params, 2, new Class[]{String.class,String.class});
			//call
			o=ExpressionFunctionHelper.charIndex((String)params[0],(String)params[1]);
			return o;
		}
		
		//instr
		if(func_name.equalsIgnoreCase("INSTR"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("INSTR", params, 2, new Class[]{String.class,String.class});
			//call
			o=ExpressionFunctionHelper.inStr((String)params[0],(String)params[1]);
			return o;
		}
				
		//left
		if(func_name.equalsIgnoreCase("LEFT"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("LEFT", params, 2, new Class[]{String.class,Integer.class});
			//call existkey
			o=ExpressionFunctionHelper.left((String)params[0],((Integer)params[1]).intValue());
			return o;
		}
		
		//right
		if(func_name.equalsIgnoreCase("RIGHT"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("RIGHT", params, 2, new Class[]{String.class,Integer.class});
			//call existkey
			o=ExpressionFunctionHelper.right((String)params[0],((Integer)params[1]).intValue());
			return o;
		}
		
		//len
		if(func_name.equalsIgnoreCase("LEN"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("LEN", params, 1, new Class[]{String.class});
			//call existkey
			o=ExpressionFunctionHelper.len((String)params[0]);
			return o;
		}
		
		//like
		if(func_name.equalsIgnoreCase("LIKE"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("LIKE", params, 2, new Class[]{String.class,String.class});
			//call existkey
			o=ExpressionFunctionHelper.like((String)params[0],(String)params[1]);
			return o;
		}
		
		//lower
		if(func_name.equalsIgnoreCase("LOWER"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("LOWER", params, 1, new Class[]{String.class});
			//call existkey
			o=ExpressionFunctionHelper.lower((String)params[0]);
			return o;
		}
		
		//upper
		if(func_name.equalsIgnoreCase("UPPER"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("UPPER", params, 1, new Class[]{String.class});
			//call existkey
			o=ExpressionFunctionHelper.upper((String)params[0]);
			return o;
		}
		
		//mid
		if(func_name.equalsIgnoreCase("MID"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("MID", params, 3, new Class[]{String.class,Integer.class,Integer.class});
			//call existkey
			o=ExpressionFunctionHelper.mid((String)params[0],((Integer)params[1]).intValue(),((Integer)params[2]).intValue());
			return o;
		}
		
		//trim
		if(func_name.equalsIgnoreCase("TRIM"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("TRIM", params, 1, new Class[]{String.class});
			//call existkey
			o=ExpressionFunctionHelper.trim((String)params[0]);
			return o;
		}
		//isdate
		if(func_name.equalsIgnoreCase("ISDATE"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("ISDATE", params, 1, new Class[]{Object.class});
			//call
			o=ExpressionFunctionHelper.isDate(params[0]);
			return o;
		}
		//toDate
		if(func_name.equalsIgnoreCase("TODATE"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("TODATE", params, 1, new Class[]{String.class});
			//call
			o=ExpressionFunctionHelper.toDate((String)params[0]);
			return o;
		}
		//now
		if(func_name.equalsIgnoreCase("NOW"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("NOW", params, 0, new Class[]{String.class});
			//call
			o=ExpressionFunctionHelper.now();
			return o;
		}
		//datediff
		if(func_name.equalsIgnoreCase("DATEDIFF"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("DATEDIFF", params, 2, new Class[]{Date.class,Date.class});
			//call
			o=ExpressionFunctionHelper.dateDiff((Date)params[0],(Date)params[1]);
			return o;
		}
		//dayofweek
		if(func_name.equalsIgnoreCase("DAYOFWEEK"))
		{
			if(params==null)
			{
				//call
				o=ExpressionFunctionHelper.dayOfWeek(null);
			}
			else{
				if(params.length >0){
					//check params
					ExpressionFunctionHelper.checkParams("DAYOFWEEK", params, 1, new Class[]{Date.class});
					//call
					o=ExpressionFunctionHelper.dayOfWeek((Date)params[0]);
				}
				else{
					//call
					o=ExpressionFunctionHelper.dayOfWeek(null);
				}
			}
			return o;
		}
		//rand
		if(func_name.equalsIgnoreCase("RAND"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("RAND", params, 0, new Class[]{});
			//call
			o=ExpressionFunctionHelper.rand();
			return o;
		}
		//valid
		if(func_name.equalsIgnoreCase("VALID"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("VALID", params, 3, new Class[]{String.class,String.class,String.class});
			//call
			o=ExpressionFunctionHelper.valid((String)params[0],(String)params[1],(String)params[2]);
			return o;
		}
		//globalVar
		if(func_name.equalsIgnoreCase("GLOBALVAR"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("GLOBALVAR", params, 3, new Class[]{String.class,String.class,String.class});
			//call
			o=ExpressionFunctionHelper.globalVar((String)params[0],(String)params[1],(String)params[2]);
			return o;
		}
		
		//SUM
		if(func_name.equalsIgnoreCase("SUM"))
		{
			if(params==null) throw new ExpressionException(func_name);
			if(params.length==2)
			{
				//check params
				ExpressionFunctionHelper.checkParams("SUM", params, 2, new Class[]{ArrayList.class,String.class});
				//call
				o=ExpressionFunctionHelper.sum((ArrayList)params[0],(String)params[1]);
			}
			else{
				//check params
				ExpressionFunctionHelper.checkParams("SUM", params, 4, new Class[]{ArrayList.class,String.class,String.class,String.class});
				//call
				o=ExpressionFunctionHelper.sum((ArrayList)params[0],(String)params[1], (String)params[2],(String)params[3], data, local);
			}
			return o;
		}
		
		//MAX
		if(func_name.equalsIgnoreCase("MAX"))
		{
			if(params==null) throw new ExpressionException(func_name);
			if(params.length==2)
			{
				//check params
				ExpressionFunctionHelper.checkParams("MAX", params, 2, new Class[]{ArrayList.class,String.class});
				//call
				o=ExpressionFunctionHelper.max((ArrayList)params[0],(String)params[1]);
			}
			else{
				//check params
				ExpressionFunctionHelper.checkParams("MAX", params, 4, new Class[]{ArrayList.class,String.class,String.class,String.class});
				//call
				o=ExpressionFunctionHelper.max((ArrayList)params[0],(String)params[1], (String)params[2],(String)params[3], data, local);
			}
			return o;
		}
	
		//MIN
		if(func_name.equalsIgnoreCase("MIN"))
		{
			if(params==null) throw new ExpressionException(func_name);
			if(params.length==2)
			{
				//check params
				ExpressionFunctionHelper.checkParams("MIN", params, 2, new Class[]{ArrayList.class,String.class});
				//call
				o=ExpressionFunctionHelper.min((ArrayList)params[0],(String)params[1]);
			}
			else{
				//check params
				ExpressionFunctionHelper.checkParams("MIN", params, 4, new Class[]{ArrayList.class,String.class,String.class,String.class});
				//call
				o=ExpressionFunctionHelper.min((ArrayList)params[0],(String)params[1], (String)params[2],(String)params[3], data, local);
			}
			return o;
		}
		
		//avg
		if(func_name.equalsIgnoreCase("AVG"))
		{
			if(params==null) throw new ExpressionException(func_name);
			if(params.length==2)
			{
				//check params
				ExpressionFunctionHelper.checkParams("AVG", params, 2, new Class[]{ArrayList.class,String.class});
				//call
				o=ExpressionFunctionHelper.avg((ArrayList)params[0],(String)params[1]);
			}
			else{
				//check params
				ExpressionFunctionHelper.checkParams("AVG", params, 4, new Class[]{ArrayList.class,String.class,String.class,String.class});
				//call
				o=ExpressionFunctionHelper.avg((ArrayList)params[0],(String)params[1], (String)params[2],(String)params[3], data, local);
			}
			return o;
		}	
		
		//bt
		if(func_name.equalsIgnoreCase("BT"))
		{
			//check params
			ExpressionFunctionHelper.checkParams("BT", params, 3, new Class[]{Object.class,Object.class,Object.class});
			//call
			o=ExpressionFunctionHelper.Bt(params[0],params[1],params[2]);
			return o;
		}	
		
		//in
		if(func_name.equalsIgnoreCase("IN"))
		{
			if(params==null) throw new ExpressionException(func_name);
			if(params.length < 2) throw new ExpressionException(func_name);
			//copy to new array
			Object[] arr=new Object[params.length-1];
			for(int i=0; i < arr.length; i++)
			{
				arr[i]=params[i+1];
			}
			//build new params
			Object[] real_params=new Object[2];
			real_params[0]=params[0];
			real_params[1]=real_params;
			//check params
			ExpressionFunctionHelper.checkParams("IN", real_params,2, new Class[]{Object.class,Object[].class});
			//call
			o=new Boolean(ExpressionFunctionHelper.in(params[0],arr));
			return o;
		}	
		
		//contain
		if(func_name.equalsIgnoreCase("CONTAINS"))
		{
			if(params==null) throw new ExpressionException(func_name);
			if(params.length < 2) throw new ExpressionException(func_name);
			//copy to new array
			Object[] arr=new Object[params.length-1];
			for(int i=0; i < arr.length; i++)
			{
				arr[i]=params[i+1];
			}
			//build new params
			Object[] real_params=new Object[2];
			real_params[0]=params[0];
			real_params[1]=real_params;
			//check params
			ExpressionFunctionHelper.checkParams("CONTAINS", real_params,2, new Class[]{Object.class,Object[].class});
			//call
			o=new Boolean(ExpressionFunctionHelper.contains(params[0],arr));
			return o;
		}
		
		throw new ExpressionException(func_name);
		
		//return o;
	}

	
	/**
	 * 
	 * @param collection
	 * @param key
	 * @param filter
	 * @param walker
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	public static ArrayList filter(ArrayList collection,String key,String filter, HashMap<String,Object> data,HashMap<String,Object> local) throws Exception
	{
		ArrayList<Object> result=new ArrayList<Object>();
		//check key exist
		if(!key.equals("") && local.containsKey(key)) throw new ExpressionException("FILTER");
		
		//format string
		String real_filter=filter.replace("\\\"", "\"");
		
		for(int i=0; i < collection.size(); i++)
		{
			Object item=collection.get(i);
			//put key to local
			if(!key.equals("")) local.put(key,item);
			
			//calculate expression
			Object value=new Boolean(true);
			
			//test filter
			if(real_filter==null || real_filter.equals("")){
				//has not filter
			}
			else{
				//System.out.println(real_filter);
				//filter="$Person.age>1";
				value = new Expression().ExecuteExpression(real_filter, data, local);
				//value=walker.value(real_filter, data, local);
			}
			
			if(value instanceof Boolean){
				//add to result list after hit filter
				if(((Boolean) value).booleanValue()) result.add(item);
			}
			else{
				throw new ExpressionException();
			}
			
			//remove key from local
			if(!key.equals("")) local.remove(key);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param collection
	 * @param key
	 * @param filter
	 * @param walker
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	public static int count(ArrayList collection,String key,String filter, HashMap<String,Object> data,HashMap<String,Object> local) throws Exception
	{
		return ExpressionFunctionHelper.filter(collection, key, filter , data, local).size();
	}
	
	/**
	 * 
	 * @param collection
	 * @return
	 * @throws Exception
	 */
	public static int count(ArrayList collection) throws Exception
	{
		if(collection==null) return 0;
		return collection.size();
	}
	
	/**
	 * 
	 * @param collection
	 * @param key
	 * @param filter
	 * @param walker
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	public static boolean exist(ArrayList collection,String key,String filter ,HashMap<String,Object> data,HashMap<String,Object> local) throws Exception
	{
		return (ExpressionFunctionHelper.filter(collection, key, filter, data, local).size() >0);
	}

	/**
	 * 
	 * @param key
	 * @param data
	 * @param local
	 * @return
	 */
	public static boolean existKey(String key,HashMap<String,Object> data,HashMap<String,Object> local)
	{
		//test null&""
		if(key==null) return false;
		if(key.equals("")) return false;
		
		if(local != null){
			if(local.containsKey(key)) return true;
		}
		
		if(data != null){
			if(data.containsKey(key)) return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isNull(Object o)
	{
		if(o==null) return true;
		
		if(o instanceof String){
			if(o.equals("")) return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isNotNull(Object o)
	{
		return ExpressionFunctionHelper.isNull(o);
	}
	
	//***************************************string function****************************/
	/**
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	private static String left(String str,int length)
	{
		//return ""
		if(str==null) return "";
		
		str=str.trim();
		
		if(length > str.length()){
			return "";
		}
		
		return str.substring(0,length);
	}
	
	/**
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	private static String right(String str, int length)
	{
		if(str==null) return "";
		
		str=str.trim();
		
		if(length > str.length()){
			return "";
		}
		
		return str.substring(str.length()-length,str.length());
	}
	
	/**
	 * 
	 * @param str
	 * @param position
	 * @param length
	 * @return
	 */
	private static String mid(String str,int position,int length)
	{
		if(str==null) return "";
		
		str=str.trim();
		
		if(str.length() < position+length){
			return "";
		}
		
		return str.substring(position,position+length);
		
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static int len(String str)
	{
		if(str==null) return 0;
		
		return str.length();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String trim(String str)
	{
		return str.trim();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String upper(String str)
	{
		if(str==null) return "";
		
		return str.toUpperCase();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	private static String lower(String str)
	{
		if(str==null) return "";
		
		return str.toLowerCase();
	}
	
	/**
	 * 
	 * @param son
	 * @param father
	 * @return
	 */
	private static boolean inStr(String father,String son)
	{
		return (ExpressionFunctionHelper.charIndex(father, son) > -1);
	}
	
	/**
	 * 
	 * @param son
	 * @param father
	 * @return
	 */
	private static int charIndex(String father,String son)
	{
		if( son==null || father==null) return -1;
		return father.indexOf(son);
	}
	
	/**
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	private static boolean like(String str,String pattern)
	{
		if(str==null) return false;
		
		return str.matches(pattern);
		
	}
	/*********************************DATETIME***************************************************/
	public static boolean isDate(Object o)
	{
		if(o==null) return false;
		
		if(o instanceof Date) return true;
		
		if(o instanceof String){
			//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try{
				ExpressionFunctionHelper.toDate((String)o);
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
			
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static Date toDate(String str) throws Exception
	{
		
		Date date=null;
		
		if(str==null || str.equals("")){
			throw new RuntimeException("use of null string.");
		}
		
		if(str.length()<6) throw new RuntimeException("bad format of date("+str+").");
		String strdate=str;
		if(str.substring(0,1).equals("#") && str.substring(str.length()-1,str.length()).equals("#"))
		{
			strdate=str.substring(1,str.length()-1);
		}
		
		//try format yyyy-MM-dd HH:mm:ss
		try{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date=sdf.parse(strdate);
		}
		catch(Exception e){
			
		}
		
		//try format yyyy-MM-dd
		if(date==null)
		{
			try{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				date=sdf.parse(strdate);
			}
			catch(Exception e)
			{
				
			}
		}
		
		//try format yyyy.MM.dd HH:mm:ss
		if(date==null)
		{
			try{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				date=sdf.parse(strdate);
			}
			catch(Exception e)
			{
				
			}
		}
				
		//try format yyyy.MM.dd
		if(date==null)
		{
			try{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
				date=sdf.parse(strdate);
			}
			catch(Exception e)
			{
				
			}
		}

		//try format yyyyMMdd HH:mm:ss
		if(date==null)
		{
			try{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				date=sdf.parse(strdate);
			}
			catch(Exception e)
			{
				
			}
		}
						
		//try format yyyyMMdd
		if(date==null)
		{
			try{
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
				date=sdf.parse(strdate);
			}
			catch(Exception e)
			{
			}
		}
						
		if(date==null) throw new RuntimeException("bad format of date("+str+").");
				
		//remove ##
		return date;
		
		
	}
	
	/**
	 * 
	 * @return
	 */
	private static Date now()
	{
		return new Date();
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	private static int dateDiff(Date date1,Date date2)
	{
		long time1=0;
		long time2=0;

		if(date1==null){
			time1=0;
		}
		else{
			time1=date1.getTime();
		}
		if(date2==null){
			time2=0;
		}
		else{
			time2=date2.getTime();
		}
		
		return Math.round((time1-time2)/(24*60*60*1000));
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	private static int dayOfWeek(Date date)
	{
		if(date==null) date=new Date();
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}
	
	/**
	 * 
	 * @return
	 */
	private static double rand()
	{
		return Math.random();
	}
	
	/**
	 * 
	 * @param system
	 * @param varname
	 * @param customs
	 * @return
	 */
	private static String globalVar(String system,String varname,String customs)
	{
		//TODO:implements
		return "1";
	}
	
	/**
	 * 
	 * @param value
	 * @param table
	 * @param field
	 * @return
	 */
	private static boolean valid(String value,String table,String field)
	{
		return true;
	}
	
	/**
	 * 
	 * @param value:current value
	 * @param min:min value
	 * @param max:max value
	 * @return:boolean value>=min && value<=max
	 * @throws Exception
	 */
	public static boolean Bt(Object value,Object min,Object max) throws Exception
	{
		if(value instanceof Date){
			Date real1,real2;
			//min
			if(min instanceof String){
				real1=ExpressionFunctionHelper.toDate((String)min);
			}
			else{
				if(min instanceof Date){
					real1=(Date)min;
				}
				else{
					throw new ExpressionException("bt");
				}
			}
			//max
			if(max instanceof String){
				real2=ExpressionFunctionHelper.toDate((String)max);
			}
			else{
				if(max instanceof Date){
					real2=(Date)max;
				}
				else{
					throw new ExpressionException("bt");
				}
			}
			
			return (((Date) value).getTime()>=real1.getTime() && ((Date)value).getTime() <= real2.getTime());
		}

		if(value instanceof Integer || value instanceof Float || value instanceof Double)
		{
			double real1,real2;
			//min
			if(min instanceof Integer || min instanceof Float || min instanceof Double)
			{
				real1=new Double(min.toString());
			}
			else{
				throw new ExpressionException("bt");
			}
			//max
			if(max instanceof Integer || max instanceof Float || max instanceof Double)
			{
				real2=new Double(max.toString());
			}
			else{
				throw new ExpressionException("bt");
			}
			
			return (new Double(value.toString()) >= real1 && new Double(value.toString()) <= real2);
			
		}
		
		if(value instanceof String)
		{
			//min
			if(min instanceof String && max instanceof String)
			{
				return (((String) value).compareTo((String)min) >=0 && ((String)value).compareTo((String)max)<=0);
			}

			throw new ExpressionException("bt");
		}
		
		throw new ExpressionException("bt");
		
	}
	
	/**
	 * 
	 * @param col
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public static Object sum(ArrayList col,String field) throws Exception
	{
		Object result=null;
		
		if(col==null) throw new ExpressionException("sum");
		if(col.size()==0) throw new ExpressionException("sum");
		if(field==null) throw new ExpressionException("sum");
		if(field.equals("")) throw new ExpressionException("sum");
		
		
		for(int i=0; i<col.size(); i++)
		{
			Object o=ReflectionHelper.getProperty(col.get(i), field);
			if(o instanceof Integer)
			{
				result=(result==null ? o : (Integer)result+(Integer)o);
			}
			else{
				if(o instanceof Double)
				{
					result=(result==null ? o : (Double)result+(Double)o);
				}
				else{
					//skip loop
					throw new ExpressionException("sum");
				}
			}
			
		}
		
		return result;
		
	}
	
	/**
	 * 
	 * @param collection
	 * @param key
	 * @param filter
	 * @param field
	 * @param walker
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	public static Object sum(ArrayList collection,String key,String filter,String field,HashMap<String,Object> data,HashMap<String,Object> local) throws Exception
	{
		//call filter
		ArrayList list=ExpressionFunctionHelper.filter(collection, key, filter, data, local);
		//return
		return ExpressionFunctionHelper.sum(list, field);
				
	}
	
	
	/**
	 * 
	 * @param col
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public static Object max(ArrayList col,String field) throws Exception
	{
		Object result=null;
		
		if(col==null) throw new ExpressionException("max");
		if(col.size()==0) throw new ExpressionException("max");
		if(field==null) throw new ExpressionException("max");
		if(field.equals("")) throw new ExpressionException("max");
		
		for(int i=0; i<col.size(); i++)
		{
			Object o=ReflectionHelper.getProperty(col.get(i), field);
			if(o instanceof Integer)
			{
				result=(result==null ? o :  ((Integer)result > (Integer)o ? result : o));
			}
			else{
				if(o instanceof Double)
				{
					result=(result==null ? o :  ((Double)result > (Double)o ? result : o));
				}
				else{
					//skip loop
					throw new ExpressionException("max");
				}
			}
			
		}
		
		return result;
		
	}
	
	/**
	 * 
	 * @param collection
	 * @param key
	 * @param filter
	 * @param field
	 * @param walker
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	public static Object max(ArrayList collection,String key,String filter,String field,HashMap<String,Object> data,HashMap<String,Object> local) throws Exception
	{
		//call filter
		ArrayList list=ExpressionFunctionHelper.filter(collection, key, filter, data, local);
		//return
		return ExpressionFunctionHelper.max(list, field);
				
	}
	
	/**
	 * 
	 * @param col
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public static Object min(ArrayList col,String field) throws Exception
	{
		Object result=null;
		
		if(col==null) throw new ExpressionException("min");
		if(col.size()==0) throw new ExpressionException("min");
		if(field==null) throw new ExpressionException("min");
		if(field.equals("")) throw new ExpressionException("min");
		
		for(int i=0; i<col.size(); i++)
		{
			Object o=ReflectionHelper.getProperty(col.get(i), field);
			if(o instanceof Integer)
			{
				result=(result==null ? o :  ((Integer)result < (Integer)o ? result : o));
			}
			else{
				if(o instanceof Double)
				{
					result=(result==null ? o :  ((Double)result < (Double)o ? result : o));
				}
				else{
					//skip loop
					throw new ExpressionException("min");
				}
			}
			
		}
		
		return result;
		
	}
	
	/**
	 * 
	 * @param collection
	 * @param key
	 * @param filter
	 * @param field
	 * @param walker
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	public static Object min(ArrayList collection,String key,String filter,String field,HashMap<String,Object> data,HashMap<String,Object> local) throws Exception
	{
		//call filter
		ArrayList list=ExpressionFunctionHelper.filter(collection, key, filter, data, local);
		//return
		return ExpressionFunctionHelper.min(list, field);
				
	}
	
	/**
	 * 
	 * @param col
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public static Object avg(ArrayList col,String field) throws Exception
	{
		Object result=ExpressionFunctionHelper.sum(col, field);
		//sum function ensure result type in (Integer/Double);
		if(result instanceof Integer)
		{
			return ((Integer)result*1.0)/col.size();
		}
		
		if(result instanceof Double)
		{
			return (Double)result/col.size();
		}
		
		//can't reach here
		return new Integer(0);
	}
	
	/**
	 * 
	 * @param collection
	 * @param key
	 * @param filter
	 * @param field
	 * @param walker
	 * @param data
	 * @param local
	 * @return
	 * @throws Exception
	 */
	public static Object avg(ArrayList collection,String key,String filter,String field,HashMap<String,Object> data,HashMap<String,Object> local) throws Exception
	{
		//call filter
		ArrayList list=ExpressionFunctionHelper.filter(collection, key, filter, data, local);
		//return
		return ExpressionFunctionHelper.avg(list, field);
				
	}
	
	/**
	 * 
	 * @param o
	 * @param col
	 * @return
	 */
	private static boolean in(Object o,Object[] col)
	{
		if(col==null) return false;
		
		for(int i=0; i < col.length; i++)
		{
			if(o.equals(col[i])) return true;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param o
	 * @param col
	 * @return
	 */
	public static boolean contains(Object o,Object[] col)
	{
		if(col==null) return false;
		
		//string
		if(o instanceof String)
		{
			for(int i=0; i < col.length; i++)
			{
				if(((String)o).indexOf(col[i].toString()) == -1) return false;
			}
			
			return true;
		}
		
		//list
		if(o instanceof ArrayList)
		{
			for(int i=0; i < col.length ; i++)
			{
				if(!((ArrayList)o).contains(col[i])) return false;
			}
			
			return true;
		}
		
		throw new ExpressionException("CONTAINS");
		
	}
	
}
