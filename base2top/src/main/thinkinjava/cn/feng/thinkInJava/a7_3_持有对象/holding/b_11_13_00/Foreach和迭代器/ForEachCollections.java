package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_13_00.Foreach和迭代器;

//: holding/ForEachCollections.java
// All collections work with foreach.

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/*展示foreach能够和Collection对象的特性
 * @author fengyu
 * @date  2015年8月8日
 */
public class ForEachCollections {

    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<String>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs)
            System.out.print("'" + s + "' ");
    }
} /*
 * Output: 'Take' 'the' 'long' 'way' 'home'
 */// :~
