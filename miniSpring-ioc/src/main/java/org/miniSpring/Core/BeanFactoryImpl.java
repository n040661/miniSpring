package org.miniSpring.Core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.miniSpring.ioc.Bean.BeanDefinition;
import org.miniSpring.ioc.Bean.ConstructorArg;
import org.miniSpring.utils.BeanUtils;
import org.miniSpring.utils.ClassUtils;
import org.miniSpring.utils.ReflectionUtils;


public class BeanFactoryImpl implements BeanFactory{

	private static final ConcurrentHashMap<String,Object> beanMap = 
			new ConcurrentHashMap<String,Object>();
	
	private static final ConcurrentHashMap<String,BeanDefinition> beanDefineMap = 
			new ConcurrentHashMap<String,BeanDefinition>();
	
	private static final Set<String> beanNameSet = 
			Collections.synchronizedSet(new HashSet<String>());
	
	public Object getBean(String name) throws Exception {
		// TODO Auto-generated method stub
		//查找对象是否已经实例化过
		Object bean = beanMap.get(name);
		if(bean!=null){
			return bean;
		}
		bean = createBean(beanDefineMap.get(name));
		if(bean != null){
			//注入对象需要的参数
			populatebean(bean);
			//把对象存入Map中方便下次使用
			beanMap.put(name, bean);
		}
		return bean;
	}
	
	protected void registerBean(String name,BeanDefinition bd){
		beanDefineMap.put(name, bd);
		beanNameSet.add(name);
	}
	
	private void populatebean(Object bean) throws Exception {
		Field[] fields = bean.getClass().getSuperclass().getDeclaredFields();
        if (fields != null && fields.length > 0) {
            for (Field field : fields) {
                String beanName = field.getName();
                beanName = StringUtils.uncapitalize(beanName);
                if (beanNameSet.contains(field.getName())) {
                    Object fieldBean = getBean(beanName);
                    if (fieldBean != null) {
                        ReflectionUtils.injectField(field,bean,fieldBean);
                    }
                }
            }
        }
	}

	private Object createBean(BeanDefinition beanDefinition) throws Exception {
		// TODO Auto-generated method stub
		String beanName = beanDefinition.getClassName();
		Class clz = ClassUtils.loadClass(beanName);
		if(clz == null){
			throw new Exception("Can not find bean by beanName");
		}
		List<ConstructorArg> constructorArgs = 
				beanDefinition.getConstructorArgs();
		if(constructorArgs != null && !constructorArgs.isEmpty()){
            List<Object> objects = new ArrayList<Object>();
            for (ConstructorArg constructorArg : constructorArgs) {
                if (constructorArg.getValue() != null) {
                    objects.add(constructorArg.getValue());
                } else {
                    objects.add(getBean(constructorArg.getRef()));
                }
            }
            Class[] constructorArgTypes = objects.stream().map(it -> it.getClass()).collect(Collectors.toList()).toArray(new Class[]{});
            Constructor constructor = clz.getConstructor(constructorArgTypes);
            return BeanUtils.instanceByCglib(clz, constructor, objects.toArray());
        } else {
            return BeanUtils.instanceByCglib(clz, null, null);
        }
	}

}