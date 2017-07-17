package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_01.创建类型的实例;
/**模版方法设计模式*/
//: generics/CreatorGeneric.java
abstract class GenericWithCreate<T> {

    final T element;

    GenericWithCreate() {
        element = create();
    }
//create()方法实在子类中定义的,用来产生子类类型的对象
    abstract T create();
}

class X {}

class Creator extends GenericWithCreate<X> {

    X create() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {

    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
} /*
 * Output: X
 */// :~
