package org.miniSpring.aop.Core;

import org.miniSpring.aop.Advisor.AdvisedSupport;
import org.miniSpring.utils.ClassUtils;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class CglibAopProxy implements AopProxy {

	private AdvisedSupport advised;
	private Object[] constructorArgs;
	private Class<?>[] constructorArgTypes;
	
	public CglibAopProxy(AdvisedSupport config){
		this.advised = config;
	}
	
	public Object getProxy() {
		// TODO Auto-generated method stub
		return getProxy(null);
	}

	public Object getProxy(ClassLoader classLoader) {

		Class<?> rootClass = advised.getTargetSource().getClass();
		if(classLoader == null){
			classLoader = ClassUtils.getDefaultClassLoader();
		}
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(rootClass.getSuperclass());
		Callback callbacks = getCallBack(advised);
		enhancer.setCallback(callbacks);
		enhancer.setClassLoader(classLoader);
		if(constructorArgs!=null&&constructorArgs.length>0){
			return enhancer.create(constructorArgTypes, constructorArgTypes);
		}
		return enhancer.create();
	}

	private Callback getCallBack(AdvisedSupport advised2) {
		// TODO Auto-generated method stub
		return new DynamicAdvisedInterceptor(advised.getList(),
				advised.getTargetSource());
	}

}
