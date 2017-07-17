package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_00.数组初始化;
//: initialization/ArraysOfPrimitives.java

import static net.mindview.util.Print.print;

/**
 * 数组初始化
 *数组只是一个相同类型的,用一个标识符名称封装到一起的一个对象序列,或基本类型数据序列
 * @author fengyu
 * @date 2015年8月9日
 */
public class ArraysOfPrimitives {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2;
        a2 = a1;
        for (int i = 0; i < a2.length; i++)
            a2[i] = a2[i] + 1;
        for (int i = 0; i < a1.length; i++)
            print("a1[" + i + "] = " + a1[i]);

    }

} /* Output:
a1[0] = 2
a1[1] = 3
a1[2] = 4
a1[3] = 5
a1[4] = 6
*///:~
