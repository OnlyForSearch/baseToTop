package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_05.用于Gengerator的泛型方法;

//: generics/Generators.java
// A utility to use with Generators.

import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.Coffee;
import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.a15_03_00.CoffeeGenerator;
import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.a15_03_01.Fibonacci;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 用Generator的泛型方法
 *利用生成器,我们可以很方便地填充一个Collection,而泛型化这种操作是有实际意义的,
 * @author fengyu
 * @date 2015年8月12日
 */
public class Generators {

    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }

    public static void main(String[] args) {
        //生成器透明的应用于Integer和Coffee
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee)
            System.out.println(c);
        Collection<Integer> fnumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for (int i : fnumbers)
            System.out.print(i + ", ");
    }
} /* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,
*///:~
