package cn.feng.thinkInJava.a1_2_操作符.operators.a3_08_01.短路.exercise;

/**
 * Created by Administrator on 2015/9/29.
 */
public class ShortCircuit {


    public static void main(String[] args) {
        boolean b = method1(0)||method2(2)|| method3(3);
        System.out.println("b = " + b);
    }

    public static boolean method1(int val) {
        System.out.println("ShortCircuit.method1" + val);
        System.out.println("val = [" + (val < 1) + "]");
        return val < 1;
    }
    public static boolean method2(int val) {
        System.out.println("ShortCircuit.method1" + val);
        System.out.println("val = [" + (val < 2) + "]");
        return val < 2;
    }
    public static boolean method3(int val) {
        System.out.println("ShortCircuit.method1" + val);
        System.out.println("val = [" + (val < 3) + "]");
        return val < 3;
    }


}
