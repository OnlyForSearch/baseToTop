package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_13_12.适配器方法习惯用法.b_11_13_13.总结;

//: holding/ModifyingArraysAsList.java

import java.util.*;

public class ModifyingArraysAsList {

    public static void main(String[] args) {
        Random rand = new Random(47);
        Integer[] ia = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 第一种情况Arrays.asList()的输出被传递给ArrayList()的构造器,将创建一个引用ia的元素的ArrayList
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(ia));
        System.out.println("Before shuffling: " + list1);
        // 打乱
        Collections.shuffle(list1, rand);
        // 打乱这些引用不会修改数组
        System.out.println("After shuffling: " + list1);
        list1.remove(1);
        System.out.println("After remove: " + list1);
        System.out.println("array: " + Arrays.toString(ia));
        // 直接使用Arrays.asList(ia)
        List<Integer> list2 = Arrays.asList(ia);
        System.out.println("Before shuffling: " + list2);
        // 打乱
        Collections.shuffle(list2, rand);
        // 打乱就会修改ia的顺序,意识得到Arrays.asList()产生的List对象会使用底层数组作为其物理实现很重要
        //只要你执行的操作会修改这个List,并且你不想原来的数组别修改,那么就应该在另一个容器中创建一个副本
        System.out.println("After shuffling: " + list2);
        System.out.println("array: " + Arrays.toString(ia));
        //list2.remove(1);
    }
} /*
 * Output: Before shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] After shuffling:
 * [4, 6, 3, 1, 8, 7, 2, 5, 10, 9] array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] Before
 * shuffling: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] After shuffling: [9, 1, 6, 3, 7,
 * 2, 5, 10, 4, 8] array: [9, 1, 6, 3, 7, 2, 5, 10, 4, 8]
 */// :~
