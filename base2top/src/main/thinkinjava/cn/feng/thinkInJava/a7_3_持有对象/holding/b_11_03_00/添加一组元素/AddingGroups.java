package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_03_00.添加一组元素;

//: holding/AddingGroups.java
// Adding groups of elements to Collection objects.

import java.util.*;

/**
 * 添加一组元素
 *
 * @author fengyu
 * @date 2015年8月8日
 */

/**
 * java.util包的Arrays和Collections有很多有用的方法
 */
public class AddingGroups {

    public static void main(String[] args) {
        /**Arrays.asList()接受一个数组或者一个用逗号分隔的元素列表*/
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = {6, 7, 8, 9, 10};
        /**Collection.addAll()只能接受一个Collection对象,不如Collections.addAll()灵活*/
        collection.addAll(Arrays.asList(moreInts));
        // Runs significantly faster, but you can't
        // construct a Collection this way:
        /**Collections.addAll()接受一个Collection对象,以及一个数组,一个用逗号分隔的元素列表,方法运行起来快的多*/
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        // Produces a list "backed by" an array:
        /**Arrays.asList底层是数组,因此不能调整尺寸,增加或者删除元素会发生错误*/
        List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
        list.set(1, 99); // OK -- modify an element
        // list.add(21); // Runtime error because the
        // underlying array cannot be resized.
    }
} // /:~
/***/
/***/
/***/
/***/
/***/