package org.miniSpring.aop.Core;

import java.lang.reflect.Method;
import java.util.List;

import org.miniSpring.aop.Advisor.TargetSource;
import org.miniSpring.aop.Interceptor.AopMethodInterceptor;
import org.miniSpring.aop.Invocation.CglibMethodInvocation;
import org.miniSpring.aop.Invocation.MethodInvocation;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DynamicAdvisedInterceptor implements MethodInterceptor {

	protected final List<AopMethodInterceptor> interceptorList;
	protected final TargetSource targetSource;
	
	public DynamicAdvisedInterceptor(List<AopMethodInterceptor> interceptorLists,
			TargetSource targetSource){
		this.interceptorList = interceptorLists;
		this.targetSource = targetSource;
	}
	
	public Object intercept(Object obj, Method method, Object[] arg,
			MethodProxy proxy) throws Throwable {

        MethodInvocation invocation = new CglibMethodInvocation(obj,targetSource.getTargetObject(),method, arg,interceptorList,proxy);
		return invocation.proceed();
	}

}
