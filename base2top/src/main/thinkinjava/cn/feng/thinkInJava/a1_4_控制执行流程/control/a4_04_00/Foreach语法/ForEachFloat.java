package cn.feng.thinkInJava.a1_4_控制执行流程.control.a4_04_00.Foreach语法;

//: control/ForEachFloat.java

import java.util.Random;

/**
 * Foreach语法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class ForEachFloat {

    public static void main(String[] args) {
        Random rand = new Random(47);
        float f[] = new float[10];
        for (int i = 0; i < 10; i++)
            f[i] = rand.nextFloat();
        for (float x : f)
            System.out.println(x);
    }
} /* Output:
0.72711575
0.39982635
0.5309454
0.0534122
0.16020656
0.57799757
0.18847865
0.4170137
0.51660204
0.73734957
*///:~
