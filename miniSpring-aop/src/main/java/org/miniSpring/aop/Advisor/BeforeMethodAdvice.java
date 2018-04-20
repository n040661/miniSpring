package org.miniSpring.aop.Advisor;

import java.lang.reflect.Method;

public interface BeforeMethodAdvice extends Advice {

	void before(Method method,Object[] args,Object target);
	
}
