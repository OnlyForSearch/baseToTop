package cn.feng.thinkInJava.a8_1_字符串.strings.a13_03_00.无意识的递归;

//: strings/ArrayListDisplay.java

import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.Coffee;
import cn.feng.thinkInJava.a9_2_泛型.generics.coffee.泛型接口.a15_03_00.CoffeeGenerator;

import java.util.ArrayList;

/**
 * 无意识的递归
 *Java中的每个类从根本上都是继承自Object，标准容器类自然也不例外。因此容器类都有toString()方法，
 * 并且重写了该方法，使得它生成的String结果能够表达容器自身，以及容器所包含的对象。
 * @author fengyu
 * @date 2015年8月8日
 */
public class ArrayListDisplay {

    public static void main(String[] args) {
        ArrayList<Coffee> coffees = new ArrayList<Coffee>();
        for (Coffee c : new CoffeeGenerator(10))
            coffees.add(c);
        System.out.println(coffees);//遍历ArrayList中包含的每个对象,调用每个元素的toString()方法
    }
} /*
 * Output: [Americano 0, Latte 1, Americano 2, Mocha 3, Mocha 4, Breve 5,
 * Americano 6, Latte 7, Cappuccino 8, Cappuccino 9]
 */// :~
