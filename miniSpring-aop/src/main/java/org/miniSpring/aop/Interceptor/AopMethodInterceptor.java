package org.miniSpring.aop.Interceptor;

import org.miniSpring.aop.Invocation.MethodInvocation;

/**
 * 拦截器的基础接口
 * @author hongyang.jiang
 *
 */
public interface AopMethodInterceptor {

	Object invoke(MethodInvocation meIn) throws Throwable;
	
}