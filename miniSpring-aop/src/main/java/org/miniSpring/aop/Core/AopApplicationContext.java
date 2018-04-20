package org.miniSpring.aop.Core;

import java.io.InputStream;
import java.util.List;

import org.miniSpring.aop.Bean.AopBeanDefinition;
import org.miniSpring.ioc.Bean.BeanDefinition;
import org.miniSpring.utils.ClassUtils;
import org.miniSpring.utils.JsonUtils;

import com.fasterxml.jackson.core.type.TypeReference;

public class AopApplicationContext extends AopBeanFactoryImpl {

	private String fileName;

	public AopApplicationContext(String fileName) {
		this.fileName = fileName;
	}

	public void init() {
		loadFile();
	}

	private void loadFile() {

		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(fileName);
		List<AopBeanDefinition> beanDefinitions = JsonUtils.readValue(is,
				new TypeReference<List<AopBeanDefinition>>() {
				});

		if (beanDefinitions != null && !beanDefinitions.isEmpty()) {

			for (AopBeanDefinition beanDefinition : beanDefinitions) {

				Class<?> clz = ClassUtils.loadClass(beanDefinition
						.getClassName());

				if (clz == ProxyFactoryBean.class) {

					registerBean(beanDefinition.getName(), beanDefinition);

				} else {

					registerBean(beanDefinition.getName(),
							(BeanDefinition) beanDefinition);

				}

			}

		}

	}
}
