package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_03_02.for循环.exercise;
//: control/E03_RandomInts2.java
// {RunByHand}
/**
 * *************** Exercise 3 ******************
 * Modify Exercise 2 so your code is
 * surrounded by an "infinite" while loop. It
 * will then run until you interrupt it,
 * typically with Control-C.
 * **********************************************
 */

public class E03_RandomInts2 {

    public static void main(String[] args) {
        while (true)
            E02_RandomInts.compareRand();
    }
} ///:~

/**
 A method outside of main( ) did most of the work in the previous exercise, so
 this solution requires only a minor change to main( ). Structure a program
 properly and it requires fewer code changes during its lifetime. The benefit may
 lie in reducing the maintenance costs of the software rather than the cost of the
 initial release, but a well-designed program is usually easier to get running in the
 first place.
 * */