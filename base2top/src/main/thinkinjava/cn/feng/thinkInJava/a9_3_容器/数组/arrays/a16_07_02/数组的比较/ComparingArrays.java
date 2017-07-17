package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_07_02.数组的比较;
//: arrays/ComparingArrays.java
// Using Arrays.equals()

import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * 数组的比较
 *Arrays.equals(): 相等的条件：元素个数相等，对应位置的元素也相等。
 * 通过每一个元素使用equals()作比较来判断,(对于基本类型,需要使用基本
 * 类型的包装器类的equals()方法,例如int类型使用Integer.equals()做比较)
 * @author fengyu
 * @date 2015年8月9日
 */
public class ComparingArrays {

    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);
        print(Arrays.equals(a1, a2));
        a2[3] = 11;
        print(Arrays.equals(a1, a2));
        String[] s1 = new String[4];
        Arrays.fill(s1, "Hi");
        String[] s2 = {new String("Hi"), new String("Hi"), new String("Hi"), new String("Hi")};
        //因为数组的相等是基于内容的
        print(Arrays.equals(s1, s2));
    }
} /* Output:
true
false
true
*///:~
