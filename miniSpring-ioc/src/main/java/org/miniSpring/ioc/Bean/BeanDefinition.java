package org.miniSpring.ioc.Bean;

import java.util.List;

/**
 * 核心数据结构，IOC框架管理的对象
 * @author hongyang.jiang
 *
 */
public class BeanDefinition {
	
	private String name;
	
	private String className;
	
	private String interfaceName;
	
	private List<ConstructorArg> constructorArgs;
	
	private List<PropertyArg> propertyArgs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public List<ConstructorArg> getConstructorArgs() {
		return constructorArgs;
	}

	public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
		this.constructorArgs = constructorArgs;
	}

	public List<PropertyArg> getPropertyArgs() {
		return propertyArgs;
	}

	public void setPropertyArgs(List<PropertyArg> propertyArgs) {
		this.propertyArgs = propertyArgs;
	}

}
