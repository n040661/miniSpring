package org.miniSpring.aop.Interceptor;

import org.miniSpring.aop.Advisor.BeforeMethodAdvice;
import org.miniSpring.aop.Invocation.MethodInvocation;

public class BeforeMethodAdviceInterceptor implements AopMethodInterceptor {

    private BeforeMethodAdvice advice;

    public BeforeMethodAdviceInterceptor(BeforeMethodAdvice advice) {
        this.advice = advice;
    }

    public Object invoke(MethodInvocation mi) throws Throwable {
        advice.before(mi.getMethod(),mi.getArguments(),mi);
        return mi.proceed();
    }
}
