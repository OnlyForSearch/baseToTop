package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_07_01.复制数组;

//: arrays/CopyingArrays.java
// Using System.arraycopy()

import java.util.Arrays;

import static net.mindview.util.Print.print;
/**
 * Arrays实用功能

 Arrays类有一套用于数组的静态方法（所有这些方法对各种基本类型和Object类而重载过）：
 方法 	说明
 equals() 	比较两个数字是否相等
 deepEquals() 	用于多维数组比较
 fill() 	填充数组
 sort() 	数组排序
 binarySearch() 	在已经排序的数组中查找元素
 toString 	产生数组的String表示
 hashCode() 	产生数组的散列码
 asList() 	接受任意的序列或数组作为其参数，并转换为List容器
 *
 * */
/**
 * 复制数组
 *System.arraycopy(): 复制数组，比用for循环复制要快很多，该方法对所有类型做了重载
 注意复制对象数组的时候，只是浅复制。另外，System.arraycopy()不会执行自动包装和自动拆包，
 两个数组必须具有相同的类型。
 * @author fengyu
 * @date 2015年8月9日
 */
public class CopyingArrays {

    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        print("i = " + Arrays.toString(i));
        print("j = " + Arrays.toString(j));

        /**arraycopy需要的参数有,源数组,开始位置,目标数组,开始复制位置,以及需要复制的个数*/
        System.arraycopy(i, 0, j, 0, i.length);
        print("j = " + Arrays.toString(j));
        int[] k = new int[5];
        Arrays.fill(k, 103);
        System.arraycopy(i, 0, k, 0, k.length);
        print("k = " + Arrays.toString(k));
        Arrays.fill(k, 103);
        System.arraycopy(k, 0, i, 0, k.length);
        print("i = " + Arrays.toString(i));
        // Objects:
        Integer[] u = new Integer[10];
        Integer[] v = new Integer[5];
        Arrays.fill(u, new Integer(47));
        Arrays.fill(v, new Integer(99));
        print("u = " + Arrays.toString(u));
        print("v = " + Arrays.toString(v));
        System.arraycopy(v, 0, u, u.length / 2, v.length);
        print("u = " + Arrays.toString(u));
    }
} /* Output:
i = [47, 47, 47, 47, 47, 47, 47]
j = [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]
j = [47, 47, 47, 47, 47, 47, 47, 99, 99, 99]
k = [47, 47, 47, 47, 47]
i = [103, 103, 103, 103, 103, 47, 47]
u = [47, 47, 47, 47, 47, 47, 47, 47, 47, 47]
v = [99, 99, 99, 99, 99]
u = [47, 47, 47, 47, 47, 99, 99, 99, 99, 99]
*///:~
