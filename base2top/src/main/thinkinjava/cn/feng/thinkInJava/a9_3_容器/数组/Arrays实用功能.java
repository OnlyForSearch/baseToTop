package cn.feng.thinkInJava.a9_3_容器.数组;

import cn.feng.utils.Print;
import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static net.mindview.util.Print.print;

public class Arrays实用功能 {

    /**
     * 数组的复制
     */
    @Test
    public void copyingArrays() {
        int[] i = new int[10];
        int[] j = new int[12];
        // Arrays.fill() 数组填充
        Arrays.fill(i, 45);
        // Arrays.toString()产生数组的表示
        Print.println(Arrays.toString(i));
        // System.arraycopy(_)复制数组比用for循环要快的很多,对所有的类型进行了重载
        // arraycopy(_)需要的参数有:源数组,源数组中什么位置开始复制的偏移量,目标数组,从目标数组什么位置开始复制,以及需要复制的个数
        System.arraycopy(i, 0, j, 0, i.length);// 对象数组复制引用
        Print.println(Arrays.toString(j));

    }

    /**
     * 数组的比较
     */
    @Test
    public void ComparingArrays() {
        String[] s1 = new String[4];
        String[] s2 = new String[4];
        Arrays.fill(s1, "String");
        System.arraycopy(s1, 0, s2, 0, s2.length);
        // Arrays.equals()用于比较整个数组.相等条件元素必须相等,并且元素位置也相等
        // 基本类型,使用包装类
        Print.println(Arrays.equals(s1, s2));
        int[] i = new int[4];
        int[] j = new int[4];
        Arrays.fill(i, 3);
        System.arraycopy(i, 0, j, 0, i.length);
        Print.println(Arrays.equals(i, j));
    }

    /**
     * 数组元素 的比较
     */
    @Test
    public void compareType() {
        CompType[] a = Generated.array(new CompType[12], CompType.generator());
        print("before sorting:");
        print(Arrays.toString(a));
        Arrays.sort(a);
        print("after sorting:");
        print(Arrays.toString(a));
    }

    /**
     * 数组的排序
     */
    @Test
    public void arraysSorting() {
        String[] sa = Generated.array(new String[20], new RandomGenerator.String(5));
        print("Before sort: " + Arrays.toString(sa));
        // String的排序算法依据词典编排顺序排序,所以大写放在输出前面
        Arrays.sort(sa);
        print("After sort: " + Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        print("Reverse sort: " + Arrays.toString(sa));
        // String.CASE_INSENSITIVE_ORDER忽略大小写 排序
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        print("Case-insensitive sort: " + Arrays.toString(sa));

    }

    /**
     * 在已经排序的数组中查找
     */
    @Test
    public void arraysSearching() {

        {
            Generator<Integer> gen = new RandomGenerator.Integer(1000);
            int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
            Arrays.sort(a);
            print("Sorted array: " + Arrays.toString(a));
            while (true) {
                int r = gen.next();
                // Arrays.binarySearch()执行快速查找,如果对未排序的数组使用,那么产生的结果是不可预测的
                int location = Arrays.binarySearch(a, r);
                if (location >= 0) {
                    print("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
                    break; // Out of while loop
                }
            }
        }
    }
}
