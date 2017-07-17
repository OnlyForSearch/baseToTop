package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_05.对Map的选择.exercise;
//: containers/E37_SimpleHashMapArrays.java
// {Args: 100 5000} Small to keep build testing short
/**
 * *************** Exercise 37 *****************
 * Modify SimpleHashMap to use ArrayLists instead
 * of LinkedLists. Modify MapPerformance.java to
 * compare the performance of the two
 * implementations.
 * *********************************************
 *//**
 *
 * 修改SimpleHashMap,令其使用ArrayLists来代替LinkedList,修
 * */

import cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.MapEntry;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.TestParam;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Tester;

import java.util.*;


class SimpleHashMap6<K, V> extends AbstractMap<K, V> {

    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    ArrayList<MapEntry<K, V>>[] buckets = new ArrayList[SIZE];
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new ArrayList<MapEntry<K, V>>();
        ArrayList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        for (ArrayList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
    @SuppressWarnings("unchecked")
    public void clear() {
        // Effectively erase everything by allocating
        // a new empty array of buckets:
        buckets = new ArrayList[SIZE];
    }
    public V remove(Object key) {
        // Code is copied from get(), except that
        // before returning the value, the Map.Entry is
        // removed from the list:
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        Iterator<MapEntry<K, V>> it = buckets[index].iterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                // Changes are here:
                V value = iPair.getValue();
                // Removes the last fetched value:
                it.remove();
                return value;
            }
        }
        return null;
    }
    public int size() {
        // Could rely on the inherited implementation, which
        // returns entrySet().size(), but this is faster:
        int sz = 0;
        for (ArrayList<MapEntry<K, V>> bucket : buckets)
            if (bucket != null)
                sz += bucket.size();
        return sz;
    }
    public boolean isEmpty() {
        // Could just say return size() == 0;
        // but this is faster:
        for (ArrayList<MapEntry<K, V>> bucket : buckets)
            if (bucket != null)
                return false;
        return true;
    }
    public boolean containsKey(Object key) {
        // A slight modification of the previous method:
        for (ArrayList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> mPair : bucket)
                if (mPair.getKey().equals(key))
                    return true;
        }
        return false;
    }
}

public class E37_SimpleHashMapArrays {

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        //Tester.run(new SimpleHashMap4<Integer, Integer>(), E35_MapPerformance2.tests);
        //Tester.run(new SimpleHashMap5<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new SimpleHashMap6<Integer, Integer>(), E35_MapPerformance2.tests);
    }
} /* Output: (Sample)
------- SimpleHashMap4 -------
size put get iterate
100 293 92 419
------- SimpleHashMap5 -------
size put get iterate
100 118 54 1389
------- SimpleHashMap6 -------
size put get iterate
100 278 92 407
*///:~
/**
 * Earlier exercises explain the SimpleHashMap4 and SimpleHashMap5
 * classes. SimpleHashMap5 uses its own singly-linked list, like HashMap from
 * the JDK. Check the source code for HashMap in the JDK to see how chaining
 * works. Sometimes your own data structure is more efficient than general
 * purpose List objects.
 * The iteration in SimpleHashMap5 is clearly not optimized.
 */