//: enumerated/Competitor.java
// Switching one enum on another.
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_11_00.多路分发;

public interface Competitor<T extends Competitor<T>> {

    Outcome compete(T competitor);
} ///:~
