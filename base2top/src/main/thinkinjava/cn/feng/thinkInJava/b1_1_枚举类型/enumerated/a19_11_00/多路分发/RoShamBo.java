//: enumerated/RoShamBo.java
// Common tools for RoShamBo examples.
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_11_00.多路分发;

import net.mindview.util.Enums;

public class RoShamBo {

    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " vs. " + b + ": " + a.compete(b));
    }
    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> rsbClass, int size) {
        for (int i = 0; i < size; i++)
            match(Enums.random(rsbClass), Enums.random(rsbClass));
    }
} ///:~
