package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_01_00.数组为什么特殊;

//: arrays/ContainerComparison.java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.mindview.util.Print.print;

class BerylliumSphere {

    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}
//数组与泛型容器 比较

/**
 * 两种持有对象的方式都是类型检查型,并且唯一明显的差异就是数组使用[]来访问元素,而List使用的是add()和get()这样的方法
 * 数组与其它容器之间的区别  效率 类型和保存基本类型  而在泛型出现之后,唯一的区别就在于效率,而效率又是以固定长度为代价
 * 数组是一种效率最高的存储和随机访问对象引用序列的方式
 */
public class ContainerComparison {
/***
 * */
    public static void main(String[] args) {
        BerylliumSphere[] spheres = new BerylliumSphere[10];
        for (int i = 0; i < 5; i++)
            spheres[i] = new BerylliumSphere();
        print(Arrays.toString(spheres));
        print(spheres[4]);
        List<BerylliumSphere> sphereList = new ArrayList<BerylliumSphere>();
        for (int i = 0; i < 5; i++)
            sphereList.add(new BerylliumSphere());
        print(sphereList);
        print(sphereList.get(4));
        int[] integers = {0, 1, 2, 3, 4, 5};
        print(Arrays.toString(integers));
        print(integers[4]);
        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5));
        intList.add(97);
        print(intList);
        print(intList.get(4));

    }
} /* Output:
[Sphere 0, Sphere 1, Sphere 2, Sphere 3, Sphere 4, null, null, null, null, null]
Sphere 4
[Sphere 5, Sphere 6, Sphere 7, Sphere 8, Sphere 9]
Sphere 9
[0, 1, 2, 3, 4, 5]
4
[0, 1, 2, 3, 4, 5, 97]
4
*///:~
