package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_03.参数协变;

/**
 * 自限定类型的价值在于可以产生协变参数类型----方法参数类型会随子类而变化
 * 参数协变
 *
 * @author fengyu
 * @date 2015年8月9日
 */
interface OrdinaryGetter {

    Base get();
}

interface DerivedGetter extends OrdinaryGetter {

    // Return type of overridden method is allowed to vary://覆盖了了OrdinaryGetter并返回从OrdinaryGetter.get()返回的类型中的导出类型
    Derived get();
}

//: generics/CovariantReturnTypes.java
class Base {}

class Derived extends Base {}

public class CovariantReturnTypes {

    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }
} // /:~
