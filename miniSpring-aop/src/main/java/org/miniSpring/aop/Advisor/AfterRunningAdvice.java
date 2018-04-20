package org.miniSpring.aop.Advisor;

import java.lang.reflect.Method;

public interface AfterRunningAdvice extends Advice {

	Object after(Object returnVal,Method method,Object[] args,Object targer);
	
}
