##Spring
大致流程：
    
加载->解析->创建实例->使用->销毁

容器->存放->bean->数据结构->list,set,map(k,v)


Spring源码架构设计

IOC container

bean定的定义信息
xml，注解，json  通过实现抽象规范接口（BeanDefinitionReader）

然后创建BeanDefinitionB的bean定义信息

存放Bean定义对象，实例化对象（）
context = new ClasspathXmlApplicationContext();
context.getBean()

对象的实例化过程
在堆中开辟一块空间，属性都是默认值

初始化
给属性赋值 
    ->填充属性
    ->执行初始化方法
    
    
PostProcessor (增强器，后置处理器) 进行扩展