package org.miniSpring.aop.Main;

import org.miniSpring.aop.Core.AopApplicationContext;
import org.miniSpring.aop.Test.TestService;

public class Main {

	public static void main(String[] args) throws Exception{
		AopApplicationContext aopApplicationContext = new AopApplicationContext("application.json");
        aopApplicationContext.init();
        TestService testService = (TestService) aopApplicationContext.getBean("TestService");
        testService.testMethod();
	}
	
}
