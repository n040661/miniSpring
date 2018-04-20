package org.miniSpring.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {

	//设置field的值为value
	public static void injectField(Field field,Object obj,Object value)
			throws IllegalArgumentException, IllegalAccessException{
		if(field!=null){
			field.setAccessible(true);
			field.set(obj, value);
		}
	}
	
	public static Object invokeMethodUseReflection(Object target, Method method,Object[] args){
        method.setAccessible(true);
        try {
            return method.invoke(target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
