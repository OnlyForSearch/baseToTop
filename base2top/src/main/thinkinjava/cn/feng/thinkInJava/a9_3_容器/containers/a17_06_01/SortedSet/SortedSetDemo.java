package cn.feng.thinkInJava.a9_3_容器.containers.a17_06_01.SortedSet;

//: containers/SortedSetDemo.java
// What you can do with a TreeSet.

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

import static net.mindview.util.Print.print;

/**\
 *SortedSet的意思是"按对像的比较函数对元素排序",而不是指"元素插入的次序"
 * SortedSet中的元素可以保证处于排序状态：
 Comparator comparator() 返回当前Set使用的Comparator；或者返回null，表示以自然方式排序。
 Object first()返回容器中的第一个元素
 Object last()返回容器中的最末一个元素
 SortedSet subSet(fromElement,toElement)生成此Set的子集，范围从fromElement(包含)到toElement(不包含)
 SortedSet headSet(toElement)生成此Set的子集，由小于toElement的元素组成
 SortedSet tailSet(fromElement) 生成此Set的子集，由大于或等于fromElement的元素组成
 * */
public class SortedSetDemo {

    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<String>();
        Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
        print(sortedSet);
        String low = sortedSet.first();
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
        print(sortedSet.subSet(low, high));
        print(sortedSet.headSet(high));
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
