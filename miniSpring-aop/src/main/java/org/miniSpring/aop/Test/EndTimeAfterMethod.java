package org.miniSpring.aop.Test;

import java.lang.reflect.Method;

import org.miniSpring.aop.Advisor.AfterRunningAdvice;

public class EndTimeAfterMethod implements AfterRunningAdvice {

	public Object after(Object returnVal, Method method, Object[] args,
			Object targer) {
		// TODO Auto-generated method stub
		long endTime = System.currentTimeMillis();
		System.out.println("方法结束时间："+endTime);
		return returnVal;
	}

}
