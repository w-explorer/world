###适配者模式

####场景介绍
1.充电器转换接口
2.显示器转接线


####基本介绍
1.主要的目的就是兼容性。将某个类的接口通过转换得到客户期望的接口，让原本不能协同工作的类可以协同工作。
2.属于结构模式
3.三种类型：类适配器模式、对象适配器模式、接口适配器模式

####工作原理
1.用户调用适配器转换出来的接口，适配器调用被适配者的接口方法。让用户感觉只是在和目标接口交互。

####类适配器
#####基本介绍
Adapter类，通过继承src类，实现dst类接口，完成src->dst的适配。
#####注意事项
类适配器需要继承src类算一个缺点，src中的所有方法在adapter中暴露出来增加了使用成本。要求dst必须是
接口，有一定的局限性。

由于继承了src类，可以重写src中的方法，使得adapter变得更加灵活。

####对象适配器
#####基本介绍
根据”合成复用原则“，通过合成的方式替代继承。Adapter类，通过实例化src类（聚合的方式），实现dst类接口，完成src->dst的适配。

是常用的模式。
#####注意事项
和类适配器是以中思想，只不过实现方式不同。
根据”合成复用原则“，使用组合替代继承，解决了适配器必须继承src的局限性，也不再要求dst必须是接口。


####接口适配器
#####基本介绍
有些称之为”缺省适配器模式“

#####工作原理

当不需要全部实现接口提供的方法时，可以先设计一个抽象类实现接口，并为该接口中每个方法提供一个默认的空实现（空方法），
那么该抽象类的子类可以有选择的覆盖父类的某些方法来实现需求。

使用于一个接口不想使用其所有的方法的情况。

####适配器模式在SpringMvc框架应用的源码剖析



####适配器模式注意事项

1)三种命名方式，是根据src是以怎样的形式给到Adapter(在Adapter里的形式)来命名的。

2)类适配器：以类给到，在Adapter里，就是将src当做类，继承
对象适配器：以对象给到，在Adapter里，将src作为一个对象，持有
接口适配器：以接口给到，在Adapter里，将src作为一个接口，实现

3)Adapter模式最大的作用还是将原本不兼容的接口融合在一起工作。

4)实际开发中，实现起来不拘泥于我们讲解的三种经典形式