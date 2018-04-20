package org.miniSpring.aop.Core;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.miniSpring.Core.BeanFactoryImpl;
import org.miniSpring.aop.Adapter.AfterRunningAdviceAdapter;
import org.miniSpring.aop.Adapter.BeforeMethodAdviceAdapter;
import org.miniSpring.aop.Advisor.Advice;
import org.miniSpring.aop.Advisor.AdvisedSupport;
import org.miniSpring.aop.Advisor.Advisor;
import org.miniSpring.aop.Advisor.AfterRunningAdvice;
import org.miniSpring.aop.Advisor.BeforeMethodAdvice;
import org.miniSpring.aop.Advisor.TargetSource;
import org.miniSpring.aop.Bean.AopBeanDefinition;
import org.miniSpring.aop.Interceptor.AopMethodInterceptor;

public class AopBeanFactoryImpl extends BeanFactoryImpl {

	private static final ConcurrentHashMap<String,AopBeanDefinition> 
		aopBeanDefinitionMap = new ConcurrentHashMap<String,AopBeanDefinition>();
	
	private static final ConcurrentHashMap<String,Object> 
		aopBeanMap =  new ConcurrentHashMap<String,Object>();
	
	@Override
	public Object getBean(String name) throws Exception{
		Object aopBean = aopBeanMap.get(name);
		if(aopBean!=null){
			return aopBean;
		}
		if(aopBeanDefinitionMap.contains(name)){
			AopBeanDefinition aopBeanDefinition = aopBeanDefinitionMap.get(name);
			AdvisedSupport advisedSupport = getAdvisedSupport(aopBeanDefinition);
			aopBean = new CglibAopProxy(advisedSupport).getProxy();
			aopBeanMap.put(name, aopBean);
			return aopBean;
		}
		return super.getBean(name);
	}
	
	protected void registerBean(String name,AopBeanDefinition aopBeanDefinition){
		aopBeanDefinitionMap.put(name, aopBeanDefinition);
	}

	private AdvisedSupport getAdvisedSupport(AopBeanDefinition aopBeanDefinition) throws Exception {
		// TODO Auto-generated method stub
		AdvisedSupport advisedSupport = new AdvisedSupport();
		List<String> interceptorNames = aopBeanDefinition.getInterceptorName();
		if(interceptorNames!= null && !interceptorNames.isEmpty()){
			for(String interceptorName:interceptorNames){
				Advice advice = (Advice)getBean(interceptorName);
				Advisor advisor = new Advisor();
				advisor.setAdvice(advice);
				if(advice instanceof BeforeMethodAdvice){
                    AopMethodInterceptor interceptor = BeforeMethodAdviceAdapter.getInstants().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }

                if(advice instanceof AfterRunningAdvice){
                    AopMethodInterceptor interceptor = AfterRunningAdviceAdapter.getInstants().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }
			}
		}
		TargetSource targetSource = new TargetSource();
		Object object = getBean(aopBeanDefinition.getTarget());
		targetSource.setTargetClass(object.getClass());
		targetSource.setTargetObject(object);
		advisedSupport.setTargetSource(targetSource);
		return advisedSupport;
	}
	
}
