package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_01.创建类型的实例;
//: generics/FactoryConstraint.java

interface FactoryI<T> {

    T create();
}

class Foo2<T> {

    private T x;
    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
    // ...
}

/**可以使用显示的工厂。
 * 内建工厂对象,创建一个显式的工厂对象,但是却获得编译期检查
 *
 * @author fengyu
 * @date 2015年8月12日
 */
class IntegerFactory implements FactoryI<Integer> {

    public Integer create() {
        return new Integer(0);
    }
}

class Widget {

    public static class Factory implements FactoryI<Widget> {

        public Widget create() {
            return new Widget();
        }
    }
}

public class FactoryConstraint {

    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
    }
} ///:~
