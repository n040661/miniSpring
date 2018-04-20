package org.miniSpring.aop.Bean;

import java.util.List;

/**
 * 适用于AOP的数据结构
 */
import org.miniSpring.ioc.Bean.BeanDefinition;

public class AopBeanDefinition extends BeanDefinition {
	//目标类名
	private String target;
	//拦截器名
	private List<String> interceptorName;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List<String> getInterceptorName() {
		return interceptorName;
	}

	public void setInterceptorName(List<String> interceptorName) {
		this.interceptorName = interceptorName;
	}
	
}