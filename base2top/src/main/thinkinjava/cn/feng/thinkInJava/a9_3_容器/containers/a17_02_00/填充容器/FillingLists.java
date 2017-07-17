package cn.feng.thinkInJava.a9_3_容器.containers.a17_02_00.填充容器;

//: containers/FillingLists.java
// The Collections.fill() & Collections.nCopies() methods.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 容器的填充
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class StringAddress {

    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    public String toString() {
        return super.toString() + " " + s;
    }
}

/**
 * @author fengyu
 * @date 2015年8月9日
 */
public class FillingLists {

    public static void main(String[] args) {    //Collections.nCopies()创建传递给构造器的List
        List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);
        //Collections.fill()方法的用处更有限,因为只能替换已经在list中存在的元素,而不能添加新的元素
        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
} /* Output: (Sample)
[StringAddress@82ba41 Hello, StringAddress@82ba41 Hello, StringAddress@82ba41 Hello, StringAddress@82ba41 Hello]
[StringAddress@923e30 World!, StringAddress@923e30 World!, StringAddress@923e30 World!, StringAddress@923e30 World!]
*///:~
