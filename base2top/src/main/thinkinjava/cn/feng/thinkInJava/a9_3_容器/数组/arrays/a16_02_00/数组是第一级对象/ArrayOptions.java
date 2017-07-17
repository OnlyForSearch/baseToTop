package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_02_00.数组是第一级对象;

//: arrays/ArrayOptions.java
// Initialization & re-assignment of arrays.

import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * 数组是第一级对象
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class BerylliumSphere {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}
// 无论使用哪一种类型的数组数组标识符其实只是一个引用,指向在堆中创建的一个真实对象,这个(数组)对象用以保存指向其他对象的引用,可以作为数组初始化语法
// 的一部分隐式地创建此对象,或者使用new表达式显式的创建,只读成员length是数组对象的一部分(事实上,这是唯一一个可以访问的字段或方法)
// ,表示此数组对象可以存储多少个元素,"[]"语法是访问数组对象的唯一方式

// 总结初始化数组的各种方式,对象数组和基本类型数组在使用上几乎是相同的，唯一区别是对象数组保存的是引用，基本类型数组直接保存基本类型的值。
public class ArrayOptions {

    public static void main(String[] args) {
        // Arrays of objects:
        // variable尚未初始化华的局部变量,在你对它正确的初始化之前,编译器不允许用此引用做任何事
        BerylliumSphere[] a; // Local uninitialized

		/**
         * 初始化为指向一个BerylliumSphere引用的数组,当其实并没有BerylliumSphere独显放置入数组中然而可以询问数组的大小
		 * ,因为b指向一个合法的对象,但是这样做有个小缺点:你无法知道在此数组中确切地有多少个元素,
		 */
        BerylliumSphere[] b = new BerylliumSphere[5];

        // The references inside the array are
        // automatically initialized to null:
        //新生成一个数组的对象时,其中的所有的引用被自动初始化为null,所有检查其中的引用是否为null即可知道某个位置是否存在对象,基本类型也初始化为初始化值
        print("b: " + Arrays.toString(b));
        BerylliumSphere[] c = new BerylliumSphere[4];
        for (int i = 0; i < c.length; i++)
            if (c[i] == null) // Can test for null reference
                c[i] = new BerylliumSphere();//为数组的各个位置赋值
        // Aggregate initialization:
        //数组d表名使用"聚集初始化"语法创建数组对象(隐式地使用new在堆中创建,)
        BerylliumSphere[] d = {new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()};
        // Dynamic aggregate initialization:动态聚集初始化
        a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere(),};
        // (Trailing comma is optional in both cases)
        print("a.length = " + a.length);
        print("b.length = " + b.length);
        print("c.length = " + c.length);
        print("d.length = " + d.length);

        //说明如何将指向某个数组对象的引用赋给另一个数组对象,a与d都指向堆中的同一个数组对象
        a = d;
        print("a.length = " + a.length);
        // Arrays of primitives:
        int[] e; // Null reference
        int[] f = new int[5];
        // The primitives inside the array are
        // automatically initialized to zero:
        print("f: " + Arrays.toString(f));
        int[] g = new int[4];
        for (int i = 0; i < g.length; i++)
            g[i] = i * i;
        int[] h = {11, 47, 93};
        // Compile error: variable e not initialized:
        // !print("e.length = " + e.length);
        print("f.length = " + f.length);
        print("g.length = " + g.length);
        print("h.length = " + h.length);
        e = h;
        print("e.length = " + e.length);
        e = new int[]{1, 2};
        print("e.length = " + e.length);
    }
} /*
	 * Output: b: [null, null, null, null, null] a.length = 2 b.length = 5
	 * c.length = 4 d.length = 3 a.length = 3 f: [0, 0, 0, 0, 0] f.length = 5
	 * g.length = 4 h.length = 3 e.length = 3 e.length = 2
	 */// :~
