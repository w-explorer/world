###建造者模式

复合《开闭原则》设计原理


####应用场景
产品和建造流程解耦。不需要知道构建的细节。通过组装不同的部件得到不同的产品。


####重要的四个角色

1)product(产品) ： 一个具体的产品对象
2)Builder(抽象建造者)： 创建Product对象的各个部件指定的接口/抽象类
3)ConcreteBuilder(具体建造者):实现接口，构建和装配各个部件
4)Director(指挥者)：构建一个使用Builder接口的对象。主要作用有两个，一是隔离了客户与对象的
生产过程，二是负责控制产品的生产过程。



###建造者模式在jdk源码应用
StringBuild 使用了建造者模式

###注意事项
1.如果产品之间的差异性很大，就不适合使用建造者模式。
2.抽象工厂模式VS建造者模式
>1.抽象工厂：是具有不同维度的产品的组合，不需要关注创造的过程。横向维度
>
>2.建造模式：是需要按照指定的流程（步骤）来创建不同的产品，主要是通过组装部件产生产品。纵向维度。



