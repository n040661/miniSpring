# miniSpring
阅读Spring源码的过程中遇到了巨大的困难，过于繁杂的设计对初学者的阅读流畅和理解极不友好，所以尝试着将其中核心的部分抽离出来，集成一个小型的Spring框架

IOC执行总结：

1、初始化IOC容器

2、读取配置文件

3、将配置文件转换为容器识别的数据结构，即BeanDefinition

4、利用BeanDefinition并结合java的反射机制实例化相应的对象

5、注入对象之间的依赖关系

AOP执行总结：

1、初始化 Aop 容器。

2、读取配置文件。

3、将配置文件装换为 Aop 能够识别的数据结构 – Advisor。这里展开讲一讲这个advisor。Advisor对象中包又含了两个重要的数据结构，一个是 Advice，一个是 Pointcut。Advice的作用就是描述一个切面的行为，pointcut描述的是切面的位置。两个数据结的组合就是”在哪里，干什么“。这样 Advisor 就�包含了”在哪里干什么“的信息，就能够全面的描述切面了。

4、Spring 将这个 Advisor 转换成自己能够识别的数据结构 – AdvicedSupport。Spirng 动态的将这些方法拦截器织入到对应的方法。

5、生成动态代理代理。

6、提供调用，在使用的时候，调用方调用的就是代理方法。也就是已经织入了增强方法的方法。

