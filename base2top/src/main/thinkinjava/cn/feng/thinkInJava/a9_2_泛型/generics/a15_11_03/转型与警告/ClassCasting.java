package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_03.转型与警告;
//: generics/ClassCasting.java

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;


interface FactoryI<T> {

    T create();
}

public class ClassCasting {

    @SuppressWarnings("unchecked")
    public void f(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        // Won't Compile:
        //    List<Widget> lw1 =
        //    List<Widget>.class.cast(in.readObject());
        //你会被强制要求转型,但是又被告知不应该转型,javase5 引入了新的转型形式,既通过泛型类来转型
        List<Widget> lw2 = List.class.cast(in.readObject());
    }
} ///:~

class Foo2<T> {

    private T x;
    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
    // ...
}

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

///:~
