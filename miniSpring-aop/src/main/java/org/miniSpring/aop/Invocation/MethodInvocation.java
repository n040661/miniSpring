package org.miniSpring.aop.Invocation;

import java.lang.reflect.Method;

/**
 * 作为所有方法调用的接口，用来描述一个方法的调用过程
 * @author hongyang.jiang
 *
 */
public interface MethodInvocation {

	//获取方法
	Method getMethod();
	
	//获取方法的参数
	Object[] getArguments();
	
	//执行方法本身
	Object proceed() throws Throwable;
	
}
