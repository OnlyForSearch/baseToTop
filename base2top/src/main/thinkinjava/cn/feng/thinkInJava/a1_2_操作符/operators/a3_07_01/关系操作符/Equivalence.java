package cn.feng.thinkInJava.a1_2_操作符.operators.a3_07_01.关系操作符;
//: operators/Equivalence.java

/**
 * 关系操作符:测试对象的等价性
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Equivalence {

    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
    }
} /* Output:
false
true
*///:~
