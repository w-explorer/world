###原型设计模式


####应用场景
为了解决对象克隆问题


原型图在Spring框架中源码分析

1.Spring中原型bean的创建，就是原型模式的应用
@Scope("singleton")//单例
@Scope("prototype")//原型模式--多例

```xml
<bean id="sheep" class="com.explore.model.biz.cha03prototype.improve.Sheep" scope="prototype"/>
```

在Java语言中需要拷贝一个对象时，有两种类型：浅拷贝与深拷贝。

浅拷贝：只是拷贝了源对象的地址，所以源对象的值发生变化时，拷贝对象的值也会发生变化。

深拷贝：只是拷贝了源对象的值，所以即使源对象的值发生变化时，拷贝对象的值也不会改变。