package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_13_00.Foreach和迭代器.b_11_13_02;

//: holding/ArrayIsNotIterable.java

import java.util.Arrays;

/**
 * 数组不是Iterable,而且任何自动包装不会自动发生
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class ArrayIsNotIterable {

    static <T> void test(Iterable<T> ib) {
        for (T t : ib)
            System.out.print(t + " ");
    }

    public static void main(String[] args) {
        test(Arrays.asList(1, 2, 3));
        String[] strings = {"A", "B", "C"};
        // An array works in foreach, but it's not Iterable:
        // ! test(strings);
        // You must explicitly convert it to an Iterable:
        // Iterable用于数组,但是这并不意味着数组肯定也是一个Iterable,而且也不会发生任何自动包装,所以必须手动执行这种转换
        test(Arrays.asList(strings));
    }
} /*
 * Output: 1 2 3 A B C
 */// :~
