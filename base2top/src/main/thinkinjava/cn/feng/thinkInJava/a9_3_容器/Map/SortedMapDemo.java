package cn.feng.thinkInJava.a9_3_容器.Map;

//: containers/SortedMapDemo.java
// What you can do with a TreeMap.

import net.mindview.util.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;

import static net.mindview.util.Print.print;

/**
 * SortedMap(TreeMap是其唯一的实现),可以确保键处于排序状态
 */
public class SortedMapDemo {

    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(new CountingMapData(10));
        print(sortedMap);
        //返回第一个键
        Integer low = sortedMap.firstKey();
        //返回最后一个键
        Integer high = sortedMap.lastKey();
        print(low);
        print(high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
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
        print(sortedMap.subMap(low, high));
        print(sortedMap.headMap(high));
        print(sortedMap.tailMap(low));
    }
} /* Output:
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
0
9
3
7
{3=D0, 4=E0, 5=F0, 6=G0}
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0}
{3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0}
*///:~
