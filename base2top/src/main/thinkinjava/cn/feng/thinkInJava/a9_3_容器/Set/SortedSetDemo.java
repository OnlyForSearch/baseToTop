package cn.feng.thinkInJava.a9_3_容器.Set;

//: containers/SortedSetDemo.java
// What you can do with a TreeSet.

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import static net.mindview.util.Print.print;

/**
 * SortedSet中的元素可以保证处于排序状态
 * 意思是:按照对象的比较函数对元素排序
 */
public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        print(sortedSet);
        //返回容器中的第一个元素
        String low = sortedSet.first();
        //返回容器中的最后一个元素
        String high = sortedSet.last();
        print(low);
        print(high);
        Iterator<String> it = sortedSet.iterator();
        for (int i = 0; i <= 6; i++) {
            if (i == 3)
                low = it.next();
            if (i == 6)
                high = it.next();
            else
                it.next();
        }
        print(low);
        print(high);
        //生成Set子集从low到high,不包含high
        print(sortedSet.subSet(low, high));
        //生成Set子集小于high的元素组成
        print(sortedSet.headSet(high));
        //生成Set子集大等于low的元素组成

        print(sortedSet.tailSet(low));
    }
} /* Output:
[eight, five, four, one, seven, six, three, two]
eight
two
one
two
[one, seven, six, three]
[eight, five, four, one, seven, six, three]
[one, seven, six, three, two]
*///:~
