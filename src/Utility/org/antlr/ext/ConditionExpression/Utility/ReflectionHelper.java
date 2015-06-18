package org.antlr.ext.ConditionExpression.Utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author SEESEE
 * @version 1.0
 * @created 11-����-2015 14:39:00
 */
public class ReflectionHelper {

	private static HashMap<String,Method> METHOD_CACHER=new HashMap<String,Method>();
	
	/**
	 * 
	 * @param target
	 * @param funcname
	 * @param classes
	 * @return
	 */
	private static String getMethodKey(Class target,String funcname,Class[] classes)
	{
		String key=target.getName()+"|"+funcname+"|";
		if(classes != null)
		{
			for(int i=0; i < classes.length; i++)
			{
				key=key+classes[i].getName()+"|";
			}
		}
		
		return key;
		
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	private static Class[] convertToPrimivite(Class[] c)
	{
		if(c==null) return null;
		
		Class[] result=new Class[c.length];
		for(int i=0; i < c.length; i++)
		{
			result[i]=c[i];
			//expression support (Double & Integer)->(double & int)
			if(c[i]==Integer.class)
			{
				result[i]=int.class;
			}
			
			if(c[i]==Double.class)
			{
				result[i]=double.class;
			}
			
		}
		
		return result;
		
	}
	
	/**
	 * 
	 * @param target
	 * @param funcname
	 * @param params
	 * @param classes
	 * @return
	 * @throws Exception
	 */
	private static Method find(Class target,String funcname,Class[] classes) throws Exception
	{
		Method setter = null;
		
		//check cache
		String key=ReflectionHelper.getMethodKey(target,funcname, classes);
		if(ReflectionHelper.METHOD_CACHER.containsKey(key))
		{
			setter=ReflectionHelper.METHOD_CACHER.get(key);
		}
		else
		{
			try
			{
				setter = target.getMethod(funcname , classes);
				//cache method
				ReflectionHelper.METHOD_CACHER.put(key, setter);
			}
			catch (NoSuchMethodException ex)
			{
			}
			
			if(setter==null)
			{
				Class[] primitiveClasses=ReflectionHelper.convertToPrimivite(classes);
				key=ReflectionHelper.getMethodKey(target,funcname, primitiveClasses);
				if(ReflectionHelper.METHOD_CACHER.containsKey(key))
				{
					setter=ReflectionHelper.METHOD_CACHER.get(key);
				}
				else{
					try{
						setter=target.getMethod(funcname,primitiveClasses);
						ReflectionHelper.METHOD_CACHER.put(key, setter);
					}
					catch(Exception e)
					{
						
					}
				}
				
			}
			
			//try last way
			if(setter==null)
			{
				HashMap<Method,Class[]> map=ReflectionHelper.getMethod(target, funcname);
				Object[] methods =  map.keySet().toArray();
				for(int i=0; i<methods.length; i++)
				{
					Method tmp=(Method)methods[i];
					Class[] paramType=map.get(tmp);
					if(paramType.length==classes.length)
					{
						boolean hit=true;
						for(int k=0; k < classes.length; k++)
						{
							if(!paramType[k].isAssignableFrom(classes[k])) hit=false;
						}
						
						if(hit){
							setter=tmp;
						}
					}
				}
			}
			
			if(setter==null){
				throw new Exception("��Ա����("+funcname+")�Ҳ�����Ϊ˽�з�����");
			}
			
		}
		
		return setter;
	}
	
	/**
	 * 
	 * @param target
	 * @param funcname
	 * @param params
	 * @param classes
	 * @return
	 * @throws Exception
	 */
	public static Class getMethodReturnType(Class target,String funcname,Class[] classes) throws Exception
	{
		Method method=ReflectionHelper.find(target, funcname,  classes);
		
		return method.getReturnType();
		
	}
	
	/**
	 * 
	 * @param target
	 * @param funcname
	 * @param params
	 * @param classes
	 * @return
	 * @throws Exception
	 */
	public static Object invokeMethod(Object target,String funcname,Object[] params,Class[] classes) throws Exception
	{
		Object result=null;
		//get data class
		
		
		Method setter = ReflectionHelper.find(target.getClass(), funcname, classes);
		
		try{
			//ִ��setterע��,no params
			result=setter.invoke(target,params);
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
		
		return result;
	}
	
	/**
	 * 
	 * @param target
	 * @param methodName
	 * @return
	 */
	private static HashMap<Method,Class[]> getMethod(Class target,String methodName)
	{
		HashMap<Method,Class[]> map=new HashMap<Method,Class[]>();
		
		Method[] methods=target.getMethods();
		for(int i=0; i<methods.length; i++)
		{
			if(methods[i].getName().equals(methodName))
			{
				map.put(methods[i],methods[i].getParameterTypes());
			}
		}
		return map;
	}
	
	/**
	 * 
	 * @param target
	 * @param propsname
	 * @return
	 * @throws Exception
	 */
	public static Class getPropertyType(Class target,String propsname) throws Exception
	{
		Class fieldType=null;
		try{
			fieldType=ReflectionHelper.getProperFiled(target, propsname).getType();
			return fieldType;
		}
		catch(Exception e)
		{
			
		}
		
		//try to invoke get property method
		String firstName = propsname.substring(0,1).toUpperCase();
   		firstName="get"+firstName + propsname.substring(1);
   		fieldType=ReflectionHelper.getMethodReturnType(target, firstName,null);
   		
   		return fieldType;
	}
	
	/**
	 * 
	 * @param data
	 * @param propsname
	 * @return
	 * @throws Exception
	 */
	private static Field getProperFiled(Class data,String propsname) throws Exception
	{
		Field   fields[]   =   data.getDeclaredFields();
		for   (int   i   =   0;   i   <   fields.length;   i++)   
        {
          	if(fields[i].getName().equals(propsname))
           	{
           		return fields[i];
           	}
        } 
		
		throw new Exception ("û��ָ������("+propsname+")");
        
	}
	
	/**
	 * 
	 * @param data
	 * @param propsname
	 * @return
	 * @throws Exception
	 */
	public static Object getProperty(Object data,String propsname) throws Exception
	{
		Object result=null;
		//boolean getted=false;
		
		if(data ==null){
			throw new Exception("����Ϊ�գ�");
		}
		
		if(propsname==null || propsname.equals("")){
			throw new Exception ("����ֵΪ��");
		}
		
		try{
			Field field=ReflectionHelper.getProperFiled(data.getClass(), propsname);
			result=field.get(data);
		}
		catch(Exception e)
		{
			
		}
        
        if(result==null){
        	//try to invoke getProperty method
       		String firstName = propsname.substring(0,1).toUpperCase();
       		firstName="get"+firstName + propsname.substring(1);
       		//try to invoke get method
        	result=ReflectionHelper.invokeMethod(data, firstName, null,null);
        }
        
        return result;
        
	}
	
	/**
	 * 
	 * @param target
	 * @param name
	 * @return
	 */
	public static ArrayList<Method> getMethods(Class target,String name)
	{
		ArrayList<Method> list=new ArrayList<Method>();
			
		Method[] methods=target.getMethods();
		for(int i=0; i<methods.length; i++)
		{
			if(methods[i].getName().startsWith(name)) list.add(methods[i]);
		}
		
		return list;
	}
	
	public static ArrayList<Field> getFields(Class target,String name)
	{
		ArrayList<Field> list=new ArrayList<Field>();
			
		Field[] fields=target.getFields();
		for(int i=0; i<fields.length; i++)
		{
			if(fields[i].getName().startsWith(name)) list.add(fields[i]);
		}
		
		return list;
	}
}