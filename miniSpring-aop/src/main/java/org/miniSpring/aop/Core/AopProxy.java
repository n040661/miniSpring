package org.miniSpring.aop.Core;

public interface AopProxy {

	Object getProxy();
	
	Object getProxy(ClassLoader classLoader);
	
}
