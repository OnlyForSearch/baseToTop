package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_03_05.递归计数.exercise;// typeinfo/Ex12.java
// TIJ4 Chapter Typeinfo, Exercise 12, page 582
// Use TypeCounter with the CoffeeGenerator.java class in the Generics chapter.
//将15章中的CoffeeGenerator.java 类用于TypeCounter

import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.Coffee;
import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.a15_03_00.CoffeeGenerator;
import net.mindview.util.TypeCounter;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class Ex12 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Coffee.class);
        for (Coffee coffee : new CoffeeGenerator(20)) {
            printnb(coffee.getClass().getSimpleName() + " ");
            counter.count(coffee);
        }
        print();
        print(counter);
    }
}