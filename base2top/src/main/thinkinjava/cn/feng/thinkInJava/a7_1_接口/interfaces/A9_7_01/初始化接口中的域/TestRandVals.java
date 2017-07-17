package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_7_01.初始化接口中的域;
//: interfaces/TestRandVals.java

import static net.mindview.util.Print.print;

public class TestRandVals {

    /**
     * 初始化接口中的域
     * 既然域是static,它们就可以在第一次被加载时候初始化,这发生在任何域首次被访问时候
     *
     * @param args
     * @author fengyu
     * @date 2015年8月8日
     */
    public static void main(String[] args) {
        print(RandVals.RANDOM_INT);
        print(RandVals.RANDOM_LONG);
        print(RandVals.RANDOM_FLOAT);
        print(RandVals.RANDOM_DOUBLE);
    }
} /* Output:
8
-32032247016559954
-8.5939291E18
5.779976127815049
*///:~
