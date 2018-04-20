package org.miniSpring.aop.Interceptor;

import org.miniSpring.aop.Advisor.AfterRunningAdvice;
import org.miniSpring.aop.Invocation.MethodInvocation;

/**
 * @author hongyang.jiang
 */
public class AfterRunningAdviceInterceptor implements AopMethodInterceptor {

    private AfterRunningAdvice advice;

    public AfterRunningAdviceInterceptor(AfterRunningAdvice advice) {
        this.advice = advice;
    }

    public Object invoke(MethodInvocation mi) throws Throwable {
        Object returnVal = mi.proceed();
        advice.after(returnVal,mi.getMethod(),mi.getArguments(),mi);
        return returnVal;
    }
}
