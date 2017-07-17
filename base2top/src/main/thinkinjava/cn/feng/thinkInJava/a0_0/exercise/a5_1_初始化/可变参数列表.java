package cn.feng.thinkInJava.a0_0.exercise.a5_1_初始化;

import static cn.feng.utils.Print.*;

public class 可变参数列表 {


    static void printArray(Object... args) {
        for (Object object : args) {
            print(object + " ");
        }
        printb();
    }
    /**
     * 可变参数，不用再显式的写数组语法，指定参数的时候编译器会填充数组。实际上获取仍然是数组
     *
     * @param required
     * @param args
     */
    static void printArray2(int required, Integer... args) {

        println(required);
        for (Object object : args) {
            print(object + " ");
        }
        printb();
    }
}
