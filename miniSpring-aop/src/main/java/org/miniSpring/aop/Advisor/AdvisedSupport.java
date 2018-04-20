package org.miniSpring.aop.Advisor;

import java.util.LinkedList;
import java.util.List;

import org.miniSpring.aop.Interceptor.AopMethodInterceptor;

public class AdvisedSupport extends Advisor {

	//目标对象
	private TargetSource targetSource;
	//拦截器列表
	private List<AopMethodInterceptor> list = 
			new LinkedList<AopMethodInterceptor>();

	public TargetSource getTargetSource() {
		return targetSource;
	}

	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}

	public List<AopMethodInterceptor> getList() {
		return list;
	}

	public void setList(List<AopMethodInterceptor> list) {
		this.list = list;
	}

	public void addAopMethodInterceptor(AopMethodInterceptor interceptor){
		list.add(interceptor);
	}
	
	public void addAopMethodInterceptors(List<AopMethodInterceptor> interceptors){
		list.addAll(interceptors);
	}
	
}