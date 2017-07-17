package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_03.参数协变;
//: generics/GenericsAndReturnTypes.java

interface GenericGetter<T extends GenericGetter<T>> {

    T get();
}

interface Getter extends GenericGetter<Getter> {}

public class GenericsAndReturnTypes {

    void test(Getter g) {
        Getter result = g.get();
        GenericGetter gg = g.get(); // Also the base type
    }
} ///:~
