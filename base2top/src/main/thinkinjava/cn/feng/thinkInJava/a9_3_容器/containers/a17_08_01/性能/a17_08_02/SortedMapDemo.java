package cn.feng.thinkInJava.a9_3_容器.containers.a17_08_01.性能.a17_08_02;
//: containers/SortedMapDemo.java
// What you can do with a TreeMap.

import net.mindview.util.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;

import static net.mindview.util.Print.print;
/**
 *使用SortedMap(TreeMap是其现阶段的唯一实现)，可以确保键处于排序状态。这使得它具有额外的功能。

 Comparator comparator()：返回当前Map使用的Comparator；或者返回null，表示以自然方式排序。K firstKey()返回Map中的第一个键。K lastKey()返回Map中的最末一个键。SortedMap subMap(K fromKey, K toKey)
 生成此Map的子集，范围由fromKey（包含）到toKey（不包含）的键确定。SortedMap headMap(K toKey)生成此Map的子集，由键小于toKey的所有键值对组成。SortedMap tailMap(K fromKey)生成此Map的子集，由键大于或等于fromKey的所有键值对组成。
 * */
public class SortedMapDemo {

    public static void main(String[] args) {
        //键值是按照键的次序排列的,TreeMap中的次序是有意义的,因此位置的概念是才有意义,所以才可以取得第一个和最后一个元素,并且可以提取TreeMap的子集
        TreeMap<Integer, String> sortedMap = new TreeMap<Integer, String>(new CountingMapData(10));
        print(sortedMap);
        Integer low = sortedMap.firstKey();
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
        //SortedMap subMap(K fromKey, K toKey)
        //生成此Map的子集，范围由fromKey（包含）到toKey（不包含）的键确定
        print(sortedMap.subMap(low, high));
        //headMap(K toKey) 生成此Map的子集，由键小于toKey的所有键值对组成。
        print(sortedMap.headMap(high));
        //tailMap(K fromKey)生成此Map的子集，由键大于或等于fromKey的所有键值对组成。
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
