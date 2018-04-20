package org.miniSpring.ioc.Bean;

/**
 * 构造属性
 * @author hongyang.jiang
 *
 */
public class ConstructorArg {

	private int index;
	
	private String ref;
	
	private String name;
	
	private Object value;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
}
