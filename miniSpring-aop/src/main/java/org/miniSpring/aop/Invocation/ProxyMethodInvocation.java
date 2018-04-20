package org.miniSpring.aop.Invocation;

/**
 * 对代理方法的调用
 * @author hongyang.jiang
 *
 */
public interface ProxyMethodInvocation extends MethodInvocation {

	//获取代理的方法
	Object getProxy();
	
}