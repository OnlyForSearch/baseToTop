package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_05.对Map的选择.exercise;
//: containers/E36_MapEntrySlowMap.java
// {Args: 100 5000} Small to keep build testing short
/**
 * *************** Exercise 36 *****************
 * Modify SlowMap so that instead of two ArrayLists,
 * it holds a single ArrayList of MapEntry objects.
 * Verify that the modified version works correctly.
 * Using MapPerformance.java, test the speed of your
 * new Map. Now change the put() method so that it
 * performs a sort() after each pair is entered, and
 * modify get() to use Collections.binarySearch() to
 * look up the key. Compare the performance of the new
 * version with the old ones.
 * *********************************************
 */

/**
 * 修改SlowMap,使之不再使用两个ArrayList,而是只保持一个MapEntry组成的ArrayList,
 * 验证修改后版本能否正常工作,使用MapPerformance来测试新的Map的速度.然后修改put()
 * 方法,令其插入键值对后执行sort(),修改get(),令其使用eCollections.binarySearch()查询键,比较新旧版本的性能
 * */

import cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.MapEntry;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.exercise.E16_SlowMapTest;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.TestParam;
import cn.feng.thinkInJava.a9_3_容器.containers.a17_10_00.性能测试框架.Tester;

import java.util.*;


// Does not support 'null' keys.
@SuppressWarnings("unchecked")
class MapEntrySlowMap1<K, V> extends AbstractMap<K, V> {

    protected List<MapEntry<K, V>> entries = new ArrayList<MapEntry<K, V>>();
    private EntrySet entrySet = new EntrySet();
    // Returns the entry matching the specified key, or null.
    protected MapEntry<K, V> getEntry(Object key) {
        for (MapEntry<K, V> entry : entries)
            if (entry.getKey().equals(key))
                return entry;
        return null;
    }
    @Override
    public V put(K key, V value) {
        if (key == null)
            throw new NullPointerException();
        MapEntry<K, V> oldEntry = getEntry(key);
        V oldValue = null;
        if (oldEntry == null)
            entries.add(new MapEntry<K, V>(key, value));
        else {
            oldValue = oldEntry.getValue();
            oldEntry.setValue(value);
        }
        return oldValue;
    }
    @Override
    public V get(Object key) {
        if (key == null)
            throw new NullPointerException();
        MapEntry<K, V> entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }
    // Uses the 'Flyweight' pattern
    private class EntrySet extends AbstractSet<Entry<K, V>> {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                boolean canRemove;
                private int index = -1;
                public boolean hasNext() {
                    return index < entries.size() - 1;
                }
                public Entry<K, V> next() {
                    canRemove = true;
                    ++index;
                    return entries.get(index);
                }
                public void remove() {
                    if (!canRemove)
                        throw new IllegalStateException();
                    canRemove = false;
                    entries.remove(index--);

                }
            };
        }
        @Override
        public boolean contains(Object o) {
            if (o instanceof MapEntry) {
                MapEntry<K, V> e = (MapEntry<K, V>) o;
                return e.equals(getEntry(e.getKey()));
            }
            return false;
        }
        @Override
        public boolean remove(Object o) {
            if (contains(o)) {
                entries.remove((MapEntry<K, V>) o);
                return true;
            }
            return false;
        }
        @Override
        public int size() { return entries.size(); }
        @Override
        public void clear() { entries.clear(); }
    }
}

@SuppressWarnings("unchecked")
class MapEntryComp<K, V> implements Comparator<MapEntry<K, V>> {

    public int compare(MapEntry<K, V> o1, MapEntry<K, V> o2) {
        Comparable<K> c1 = (Comparable<K>) o1.getKey();
        return c1.compareTo(o2.getKey());
    }
}

@SuppressWarnings("unchecked")
class MapEntrySlowMap2<K, V> extends MapEntrySlowMap1<K, V> {

    final MapEntryComp<K, V> comp = new MapEntryComp<K, V>();
    // Returns the entry matching the specified key, or null.
    @Override
    protected MapEntry<K, V> getEntry(Object key) {
        MapEntry<K, V> searchEntry = new MapEntry<K, V>((K) key, null);
        int index = Collections.binarySearch(entries, searchEntry, comp);
        if (index >= 0)
            return entries.get(index);
        return null;
    }
    @Override
    public V put(K key, V value) {
        if (key == null)
            throw new NullPointerException();
        MapEntry<K, V> oldEntry = getEntry(key);
        V oldValue = null;
        if (oldEntry == null) {
            entries.add(new MapEntry<K, V>(key, value));
            Collections.sort(entries, comp);
        } else {
            oldValue = oldEntry.getValue();
            oldEntry.setValue(value);
        }
        return oldValue;
    }
}

public class E36_MapEntrySlowMap {

    public static void main(String[] args) {
        // Testing correctness...
        System.out.println("Testing MapEntrySlowMap1");
        E16_SlowMapTest.test(new MapEntrySlowMap1<Integer, String>());
        System.out.println("Testing MapEntrySlowMap2");
        E16_SlowMapTest.test(new MapEntrySlowMap2<Integer, String>());
        // Measuring performance...
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester.run(new TreeMap<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new HashMap<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new LinkedHashMap<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new IdentityHashMap<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new WeakHashMap<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new Hashtable<Integer, Integer>(), E35_MapPerformance2.tests);
        //Tester.run(new SlowMap2<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new MapEntrySlowMap1<Integer, Integer>(), E35_MapPerformance2.tests);
        Tester.run(new MapEntrySlowMap2<Integer, Integer>(), E35_MapPerformance2.tests);
    }
} /* Output: (Sample)
Testing MapEntrySlowMap1
Thinking in Java, 4 480 th Edition Annotated Solution Guide
MapEntrySlowMap1
Size = 25, Keys: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
Values: [A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0,
N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0]
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0,
10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0,
18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0}
map.containsKey(11): true
map.get(11): L0
map.containsValue("F0"): true
First key in map: 0
Size = 24, Keys: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
map.isEmpty(): true
map.isEmpty(): true
Testing MapEntrySlowMap2
MapEntrySlowMap2
Size = 25, Keys: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
Values: [A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0,
N0, O0, P0, Q0, R0, S0, T0, U0, V0, W0, X0, Y0]
{0=A0, 1=B0, 2=C0, 3=D0, 4=E0, 5=F0, 6=G0, 7=H0, 8=I0, 9=J0,
10=K0, 11=L0, 12=M0, 13=N0, 14=O0, 15=P0, 16=Q0, 17=R0,
18=S0, 19=T0, 20=U0, 21=V0, 22=W0, 23=X0, 24=Y0}
map.containsKey(11): true
map.get(11): L0
map.containsValue("F0"): true
First key in map: 0
Size = 24, Keys: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]
map.isEmpty(): true
map.isEmpty(): true
---------- TreeMap ----------
size put get iterate
100 1564 842 148
---------- HashMap ----------
size put get iterate
100 499 213 168
------- LinkedHashMap -------
size put get iterate
100 704 293 115
------ IdentityHashMap ------
size put get iterate
100 598 580 181
-------- WeakHashMap --------
size put get iterate
Containers in Depth 481
100 687 317 220
--------- Hashtable ---------
size put get iterate
100 460 265 219
---------- SlowMap2 ----------
size put get iterate
100 6238 6228 363
------ MapEntrySlowMap1 ------
size put get iterate
100 10334 15029 195
------ MapEntrySlowMap2 ------
size put get iterate
100 28463 1484 196
*///:~
/**
 * The MapEntrySlowMap2’s get( ) method performs well, but put( ) is
 * disastrous. Notice that the @SuppressWarnings("unchecked") annotations
 * appear immediately before class definitions; always confine these annotations by
 * placing them near the problem.
 */