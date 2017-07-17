package cn.feng.thinkInJava.a9_3_容器.containers.a17_08_03.LinkedHashMap;
//: containers/LinkedHashMapDemo.java
// What you can do with a LinkedHashMap.

import net.mindview.util.CountingMapData;

import java.util.LinkedHashMap;

import static net.mindview.util.Print.print;
/**
 * 为了提高速度，LinkedHashSet散列化所有的元素，但是在遍历键值对时，却又以元素的插入顺序返回键值对。
 * 此外，可以在构造器中设定LinkedHashSet，使之采用基于访问的最少使用(LRU)算法，于是没有被访问过的（可被看作需要删除
 * 的）元素就会出现在队列的前面。对于需要定期清理元素以节省空间的程序来说，此功能使得程序很容易得以实现。
 * */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<Integer, String>(new CountingMapData(9));
        print(linkedMap);
        // Least-recently-used order:
        linkedMap = new LinkedHashMap<Integer, String>(16, 0.75f, true);
        linkedMap.putAll(new CountingMapData(9));
        //可以看到键值对是以插入的顺序进行遍历的使之LRU算法的版本也是如此
        print(linkedMap);
        for (int i = 0; i < 6; i++) // Cause accesses:在访问前面六个元素之后
            linkedMap.get(i);
        //最后 三个排到了前面
        print(linkedMap);
        linkedMap.get(0);
        //在访问元素0时候,就被移动到了最后端了
        print(linkedMap);
    }
} /* Output:
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0}
{6=G0, 7=H0, 8=I0, 0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0}
{6=G0, 7=H0, 8=I0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 0=A0}
*///:~
