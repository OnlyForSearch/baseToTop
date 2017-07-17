package cn.feng.thinkInJava.a9_3_容器.containers.a17_02_00.填充容器;

//: containers/CollectionDataTest.java

import net.mindview.util.CollectionData;
import net.mindview.util.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

class Government implements Generator<String> {

    String[] foundation = ("strange women lying in ponds " + "distributing swords is no basis for a system of " + "government").split(" ");
    private int index;

    public String next() {
        return foundation[index++];
    }
}

/**
 * 事实上所有的Collection子类型都有一个接受另一个Collection对象的构造器,用所接收的Collection对象中的
 * 元素填充新的容器
 *
 * @author fengyu
 * @date 2015年8月13日
 */
public class CollectionDataTest {

    public static void main(String[] args) {//LinkedHashSet维护的是保持了插入顺序的链接列表,这些元素的顺序与它们的插入顺序相同
        Set<String> set = new LinkedHashSet<String>(new CollectionData<String>(new Government(), 15));
        // Using the convenience method:
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
} /* Output:
[strange, women, lying, in, ponds, distributing, swords, is, no, basis, for, a, system, of, government]
*///:~
