package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_7_01.初始化接口中的域;

//: interfaces/RandVals.java
// Initializing interface fields with
// non-constant initializers.

import java.util.Random;

//域,但是隐式地是static和final,由于是静态(static)的就可以在类第一次加载时候初始化,
//不能是"空final",但是可以被非常量表达式初始化
public interface RandVals {

    // 接口可以包含域,但是隐式地是static和final,这些域不是接口的一部分,他们储存在该接口的静态存储区域内
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt(10);// 可以被非常量表达式初始化
    long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextLong() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;
} // /:~
