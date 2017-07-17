package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_04_00.多维数组;
//: arrays/RaggedArray.java

import java.util.Arrays;
import java.util.Random;
//数组中构成矩阵的每个向量都可以具有任意的长度(被称为粗糙数组)

/**
 * 不规则数组
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class RaggedArray {

    public static void main(String[] args) {
        Random rand = new Random(47);
        // 3-D array with varied-length vectors:
        int[][][] a = new int[rand.nextInt(7)][][];//创建了一个数组,第一维长度是随机决定的,其他维长度则没有定义
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[rand.nextInt(5)][];//决定第二维的长度
            for (int j = 0; j < a[i].length; j++)
                a[i][j] = new int[rand.nextInt(5)];//决定第三维的长度
        }
        System.out.println(Arrays.deepToString(a));
    }
} /* Output:
[[], [[0], [0], [0, 0, 0, 0]], [[], [0, 0], [0, 0]], [[0, 0, 0], [0], [0, 0, 0, 0]], [[0, 0, 0], [0, 0, 0], [0], []], [[0], [], [0]]]
*///:~
