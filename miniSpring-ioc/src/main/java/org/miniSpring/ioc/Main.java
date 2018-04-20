package org.miniSpring.ioc;

import org.miniSpring.Core.JsonApplicationContext;
import org.miniSpring.ioc.entity.Robot;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ){
       JsonApplicationContext applicationContext = 
    		   new JsonApplicationContext("application.json"); 
       applicationContext.init();
       try {
    	   Robot aiRobot = (Robot) applicationContext.getBean("robot");
    	   aiRobot.show();
       } catch (Exception e) {
    	   // TODO Auto-generated catch block
    	   e.printStackTrace();
       }
    }
}
