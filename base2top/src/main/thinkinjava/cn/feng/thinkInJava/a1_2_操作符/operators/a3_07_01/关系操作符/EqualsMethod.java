package cn.feng.thinkInJava.a1_2_操作符.operators.a3_07_01.关系操作符;
//: operators/EqualsMethod.java

public class EqualsMethod {

    public static void main(String[] args) {
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        //若想对比两个对象的实际内容是否相同,必须使用所有对象都适用的特殊方法equals(),但是这个方法不适用于基本数据类型
        System.out.println(n1.equals(n2));
    }
} /* Output:
true
*///:~
