package cn.feng.thinkInJava.a1_2_操作符.operators.a3_07_01.关系操作符.exerciese;

/**
 * Created by fengyu on 2015-09-29.
 */
public class Equivalence {
    
    public static void main(String args[]) {
        Integer integer = new Integer(47);
        Integer integer1 = new Integer(47);
        System.out.println("(integer1==integer) = " + (integer1 == integer));
        System.out.println("(integer1!=integer) = " + (integer1 != integer));
        System.out.println("integer1.equals(integer )  = " + integer1.equals(integer));
        Value value = new Value();
        Value value1 = new Value();
        value.i = value1.i = 100;
        System.out.println("value1.equals(value)  = " + value1.equals(value));
    }
}

class Value {

    int i;
}

