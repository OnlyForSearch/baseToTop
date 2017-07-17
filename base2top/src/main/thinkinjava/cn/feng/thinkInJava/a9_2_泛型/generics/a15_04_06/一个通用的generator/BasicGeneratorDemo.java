package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_06.一个通用的generator;

//: generics/BasicGeneratorDemo.java

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

public class BasicGeneratorDemo {

    public static void main(String[] args) {//使用泛型方法大大减少我们要编写的代码,
        Generator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
    }
} /* Output:
CountedObject 0
CountedObject 1
CountedObject 2
CountedObject 3
CountedObject 4
*///:~
