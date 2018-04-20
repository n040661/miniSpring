package org.miniSpring.Core;

import java.io.InputStream;
import java.util.List;

import org.miniSpring.ioc.Bean.BeanDefinition;
import org.miniSpring.utils.JsonUtils;

import com.fasterxml.jackson.core.type.TypeReference;

public class JsonApplicationContext extends BeanFactoryImpl {

	private String fileName;
	
	public JsonApplicationContext(String fileName){
		this.fileName = fileName;
	}
	
	public void init(){
		loadFile();
	}

	private void loadFile() {
		// TODO Auto-generated method stub
		InputStream is = Thread.currentThread().getContextClassLoader().
				getResourceAsStream(fileName);
		List<BeanDefinition> beanDefinitions = JsonUtils.readValue
				(is,new TypeReference<List<BeanDefinition>>(){});
		if(beanDefinitions!=null&&!beanDefinitions.isEmpty()){
			for(BeanDefinition beanDefinition:beanDefinitions){
				registerBean(beanDefinition.getName(),beanDefinition);
			}
		}
	} 
	
}