package org.miniSpring.aop.Adapter;

import org.miniSpring.aop.Advisor.Advisor;
import org.miniSpring.aop.Advisor.BeforeMethodAdvice;
import org.miniSpring.aop.Interceptor.AopMethodInterceptor;
import org.miniSpring.aop.Interceptor.BeforeMethodAdviceInterceptor;

public class BeforeMethodAdviceAdapter implements AdviceAdapter {

	public BeforeMethodAdviceAdapter() {
		
	}

	private static final BeforeMethodAdviceAdapter INSTANTS = 
			new BeforeMethodAdviceAdapter();
	
	public static BeforeMethodAdviceAdapter getInstants(){
		return INSTANTS;
	}
	
	public AopMethodInterceptor getInterceptor(Advisor advisor) {
		// TODO Auto-generated method stub
		BeforeMethodAdvice advice = (BeforeMethodAdvice) advisor.getAdvice();
		return new BeforeMethodAdviceInterceptor(advice);
	}

}