package cn.feng.thinkInJava.a9_3_容器.containers.a17_04_01.未获得支持的操作;

//: containers/Unsupported.java
// Unsupported operations in Java containers.

import java.util.*;

/**
 * 未获支持的操作
 *最常见的未获支持的操作，都来源于背后由固定尺寸的数据结构支持的容器。当你用Arrays.asList()将数组转换为List时，就会得到这样的容器。你还可以通过使用Collection类中“不可修改”的方法，选择创建任何会抛出UnsupportedOperationException的容器（包括Map）。

 因为Arrays.asList()会生成一个List，它基于一个固定大小的数组，任何会引起对底层数据结构的尺寸进行修改的方法都会产生一个UnsupportedOperationException异常，以表示对未获支持操作的调用（一个编程错误）。
 * @author fengyu
 * @date 2015年8月9日
 */
public class Unsupported {

    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        // Copy of the sublist:
        Collection<String> c2 = new ArrayList<String>(subList);
        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }
        try {
            c.removeAll(c2);
        } catch (Exception e) {
            System.out.println("removeAll(): " + e);
        }
        try {
            c.clear();
        } catch (Exception e) {
            System.out.println("clear(): " + e);
        }
        try {
            c.add("X");
        } catch (Exception e) {
            System.out.println("add(): " + e);
        }
        try {
            c.addAll(c2);
        } catch (Exception e) {
            System.out.println("addAll(): " + e);
        }
        try {
            c.remove("C");
        } catch (Exception e) {
            System.out.println("remove(): " + e);
        }
        // The List.set() method modifies the value but
        // doesn't change the size of the data structure:
        try {
            list.set(0, "X");
        } catch (Exception e) {
            System.out.println("List.set(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<String>(list)));
    }
} /* Output:
--- Modifiable Copy ---
--- Arrays.asList() ---
retainAll(): java.lang.UnsupportedOperationException
removeAll(): java.lang.UnsupportedOperationException
clear(): java.lang.UnsupportedOperationException
add(): java.lang.UnsupportedOperationException
addAll(): java.lang.UnsupportedOperationException
remove(): java.lang.UnsupportedOperationException
--- unmodifiableList() ---
retainAll(): java.lang.UnsupportedOperationException
removeAll(): java.lang.UnsupportedOperationException
clear(): java.lang.UnsupportedOperationException
add(): java.lang.UnsupportedOperationException
addAll(): java.lang.UnsupportedOperationException
remove(): java.lang.UnsupportedOperationException
List.set(): java.lang.UnsupportedOperationException
*///:~
