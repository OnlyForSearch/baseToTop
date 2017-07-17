package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_00.擦除的神秘之处.a15_07_01;

//: generics/LostInformation.java

import java.util.*;

class Frob {}

class Fnorkle {}

class Quark<Q> {}

class Particle<POSITION, MOMENTUM> {}

/**
 * 泛型擦除的神秘之处
 * <p>
 * 在泛型代码的内部,无法获得任何有关泛型参数类型信息,java泛型是使用擦除来实现的,这意味着当你使用泛型时,任何具体类型都被擦除.
 * 你唯一知道的是你使用了一个对象
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class LostInformation {

    public static void main(String[] args) {
        List<Frob> list = new ArrayList<Frob>();
        Map<Frob, Fnorkle> map = new HashMap<Frob, Fnorkle>();
        Quark<Fnorkle> quark = new Quark<Fnorkle>();
        Particle<Long, Double> p = new Particle<Long, Double>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));
    }
} /* Output:
[E]
[K, V]
[Q]
[POSITION, MOMENTUM]
*///:~
