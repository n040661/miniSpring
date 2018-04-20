package org.miniSpring.utils;

import java.lang.reflect.Constructor;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * 负责处理对象的实例化
 * @author hongyang.jiang
 *
 */
public class BeanUtils {

	public static <T> T instanceByCglib(Class<T> clz,
			Constructor con,Object[] args){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clz);
		enhancer.setCallback(NoOp.INSTANCE);
		if(con==null){
			return (T)enhancer.create();
		}else{
			return (T) enhancer.create(con.getParameterTypes(), args);
		}
	}
	
}
