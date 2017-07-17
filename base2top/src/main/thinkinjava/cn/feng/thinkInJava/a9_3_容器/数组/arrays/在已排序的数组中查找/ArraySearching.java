package cn.feng.thinkInJava.a9_3_容器.数组.arrays.在已排序的数组中查找;

//: arrays/ArraySearching.java
// Using Arrays.binarySearch().

import net.mindview.util.ConvertTo;
import net.mindview.util.Generated;
import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * 在已排序的数组中查找
 *如果数组排好序了，可以使用Arrays.binarySearch()进行查找，对未排序的数组使用binarySearch，会产生意想不到的结果。

 查找到了则返回大于等于0的整数
 否则返回负值，表示保持数组排序状态下此目标所应该插入的位置，此负值计算方法： -(插入点) - 1

 如果使用Comparator排序对象数组（基本类型数组无法使用Comparator进行排序）了，使用binarySearch对对象数组进行排序的时候必须提供同样的Comparator

 优先容器而不是数组，只有在证明性能成为问题，并且切换到数组对性能有所帮助时，你才应该将程序重构为使用数组。
 * @author fengyu
 * @date 2015年8月9日
 */
public class ArraySearching {

    public static void main(String[] args) {
        Generator<Integer> gen = new RandomGenerator.Integer(1000);
        int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
        Arrays.sort(a);
        print("Sorted array: " + Arrays.toString(a));
        while (true) {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                print("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
                break; // Out of while loop
            }
        }
    }
} /* Output:
Sorted array: [128, 140, 200, 207, 258, 258, 278, 288, 322, 429, 511, 520, 522, 551, 555, 589, 693, 704, 809, 861, 861, 868, 916, 961, 998]
Location of 322 is 8, a[8] = 322
*///:~
