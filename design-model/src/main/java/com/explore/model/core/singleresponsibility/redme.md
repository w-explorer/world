####1.单一职责原则:
 对类来说，即一个类只负责一项职责。如类A负责两个不同的职责：职责1、职责2.当职责需求变更而改变类A时，可能造成职责2的执行错误。所以需要将A分为A1  A2 两个
 细粒度的类。

####2.单一职责原则注意事项和细节

1.降低类的复杂度，一个类只负责一项职责
2.提高类的可读性、可维护性
3.降低变更降低的风险
4.通常情况下，应当遵守单一职责原则，只有代码逻辑足够简单才可以在代码级违反单一职责原则；
只有类中方法数量足够少，可以在方法级别保持单一职责原则