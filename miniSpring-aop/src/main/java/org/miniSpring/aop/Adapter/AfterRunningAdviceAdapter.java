package org.miniSpring.aop.Adapter;

import org.miniSpring.aop.Advisor.Advisor;
import org.miniSpring.aop.Advisor.AfterRunningAdvice;
import org.miniSpring.aop.Interceptor.AfterRunningAdviceInterceptor;
import org.miniSpring.aop.Interceptor.AopMethodInterceptor;

public class AfterRunningAdviceAdapter implements AdviceAdapter {

	private AfterRunningAdviceAdapter(){

    }

    private static final AfterRunningAdviceAdapter INSTANTS = 
    		new AfterRunningAdviceAdapter();
    
    public static AfterRunningAdviceAdapter getInstants(){
        return INSTANTS;
    }

    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        AfterRunningAdvice advice = (AfterRunningAdvice) advisor.getAdvice();
        return new AfterRunningAdviceInterceptor(advice);
    }
}