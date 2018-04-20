package org.miniSpring.aop.Adapter;

import org.miniSpring.aop.Advisor.Advisor;
import org.miniSpring.aop.Interceptor.AopMethodInterceptor;

public interface AdviceAdapter {

	AopMethodInterceptor getInterceptor(Advisor advisor);
	
}
