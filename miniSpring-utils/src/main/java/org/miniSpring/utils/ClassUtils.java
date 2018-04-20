package org.miniSpring.utils;

public class ClassUtils {

	public static ClassLoader getDefaultClassLoader(){
		return Thread.currentThread().getContextClassLoader();
	}
	
	/**
	 * 通过className这个参数获取对象的Class
	 * @param name
	 * @return
	 */
	public static Class loadClass(String className){
		try {
			return getDefaultClassLoader().loadClass(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}	
	
}