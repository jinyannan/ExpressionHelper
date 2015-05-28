package org.antlr.ext.ConditionExpression.Utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @author SEESEE
 * @version 1.0
 * @created 11-����-2015 14:39:00
 */
public class ReflectionHelper {

	private static HashMap<String,Method> METHOD_CACHER=new HashMap<String,Method>();
	
	private static String getMethodKey(Object target,String funcname,Class[] classes)
	{
		String key=target.getClass().getName()+"|"+funcname+"|";
		if(classes != null)
		{
			for(int i=0; i < classes.length; i++)
			{
				key=key+classes[i].getName()+"|";
			}
		}
		
		return key;
		
	}
	
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
	
	public static Object invokeMethod(Object target,String funcname,Object[] params,Class[] classes) throws Exception
	{
		Object result=null;
		//get data class
		
		
		Method setter = null;
		
		//check cache
		String key=ReflectionHelper.getMethodKey(target,funcname, classes);
		if(ReflectionHelper.METHOD_CACHER.containsKey(key))
		{
			setter=ReflectionHelper.METHOD_CACHER.get(key);
		}
		else
		{
			/*
			//����target��������ʵ�ֵ����нӿ�
			for (Class superInterface : target.getClass().getInterfaces())
			{
				try
				{
					//��ȡ��ֵע�������setter����
					setter = target.getClass().getMethod(
						funcname , superInterface);
					//���ɹ�ȡ�øýӿڶ�Ӧ�ķ�����ֱ�����ѭ��
					break;
				}
				catch (NoSuchMethodException ex)
				{
					//���û���ҵ���Ӧ��setter�����������´�ѭ��
					continue;
				}
			}
			*/
			try
			{
				//��ȡ��ֵע�������setter����
				setter = target.getClass().getMethod(funcname , classes);
				//cache method
				ReflectionHelper.METHOD_CACHER.put(key, setter);
			}
			catch (NoSuchMethodException ex)
			{
				//���û���ҵ���Ӧ��setter�����������´�ѭ��
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
						setter=target.getClass().getMethod(funcname,primitiveClasses);
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
			
			
			/*
			//���setter������ȻΪnull��
			//��ֱ��ȡ��targetʵ�����Ӧ��setter����
			if (setter == null)
			{
				setter=ReflectionHelper.getDeclaredMethod(target,funcname,classes);
				if(setter==null){
					throw new Exception("��Ա����("+funcname+")�Ҳ�����Ϊ˽�з�����");
				}
			}
			*/
			
			//cache method
			//ReflectionHelper.METHOD_CACHER.put(key, setter);
			
		}
		
		
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
	
	
	private static HashMap<Method,Class[]> getMethod(Object target,String methodName)
	{
		HashMap<Method,Class[]> map=new HashMap<Method,Class[]>();
		
		Method[] methods=target.getClass().getMethods();
		for(int i=0; i<methods.length; i++)
		{
			if(methods[i].getName().equals(methodName))
			{
				map.put(methods[i],methods[i].getParameterTypes());
			}
		}
		return map;
	}


	private static Method getDeclaredMethod(Object object, String methodName, Class<?> ... parameterTypes){   
        Method method = null ;   
           
        for(Class<?> clazz = object.getClass() ;clazz != null ; clazz = clazz.getSuperclass()) {   
            try {   
            	method = clazz.getDeclaredMethod(methodName, parameterTypes) ;
                /*
            	System.out.println(clazz.getName());
                Method[] m=clazz.getDeclaredMethods();
                for(int i=0; i<m.length;i++)
                {
                	System.out.println("----"+m[i].getName());
                	Type[] t=m[i].getGenericParameterTypes();
                	for(int k=0; k < t.length; k++)
                	{
                		System.out.println(t[k].toString());
                	}
                	
                	
                }
                
                
                m=clazz.getMethods();
                for(int i=0; i<m.length;i++)
                {
                	System.out.println("*****"+m[i].getName());
                	Type[] t=m[i].getGenericParameterTypes();
                	for(int k=0; k < t.length; k++)
                	{
                		System.out.println(t[k].toString());
                	}
                	
                	
                }
                */
            	
                return method ;   
            } catch (Exception e) {   
                //������ô����Ҫ��������������쳣��������д�������׳�ȥ��   
                //���������쳣��ӡ���������ף���Ͳ���ִ��clazz = clazz.getSuperclass(),���Ͳ�����뵽��������   
            	continue;
               
            }
            
        }   
           
        return null;   
    }   

	
	public static Object getProperty(Object data,String propsname) throws Exception
	{
		Object result=null;
		boolean getted=false;
		
		if(data ==null){
			throw new Exception("����Ϊ�գ�");
		}
		
		if(propsname==null || propsname.equals("")){
			throw new Exception ("����ֵΪ��");
		}
		
		
		Field   fields[]   =   data.getClass().getDeclaredFields();
        try{ 
            for   (int   i   =   0;   i   <   fields.length;   i++)   
            {
            	if(fields[i].getName().equals(propsname))
            	{
            		result= fields[i].get(data);
            		getted=true;
            		break;
            		
            	}
            } 
        } 
        catch(Exception   e){ 
	         // e.printStackTrace();
        } 
        
        //try to invoke getProperty method
   		String firstName = propsname.substring(0,1).toUpperCase();
   		firstName="get"+firstName + propsname.substring(1);


        if(!getted){
        	result=ReflectionHelper.invokeMethod(data, firstName, null,null);
        }
        
        return result;
        
	}
}