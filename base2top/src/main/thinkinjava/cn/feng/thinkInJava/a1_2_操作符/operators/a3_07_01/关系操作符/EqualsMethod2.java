package cn.feng.thinkInJava.a1_2_操作符.operators.a3_07_01.关系操作符;
//: operators/EqualsMethod2.java
// Default equals() does not compare contents.

class Value {

    int i;
}

public class EqualsMethod2 {

    public static void main(String[] args) {
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        //equals的默认行为是比较引用的
        System.out.println(v1.equals(v2));
    }
} /* Output:
false
*///:~
