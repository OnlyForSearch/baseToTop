package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_05.对Map的选择.exercise;
//: containers/E38_HashMapLoadFactor.java
// {RunByHand}
/**
 * *************** Exercise 38 *****************
 * Look up the HashMap class in the JDK documentation.
 * Create a HashMap, fill it with elements, and
 * determine the load factor. Test the lookup speed
 * with this map, then attempt to increase the speed
 * by making a new HashMap with a larger initial
 * capacity and copying the old map into the new one,
 * then run your lookup speed test again on the new map.
 * *********************************************
 *//**
 * 在JDK文档中,查找HashMap,创建一个HashMap,用元素填充它,并确定其负载因子,
 * 测试这个映射表的查找速度,然后尝试着通过创建具有更大的初始容量的新的HashMap,
 * 并将旧映射表中的元素赋值到这个新表中,来创建提高查找速度秒之后在这个新表上,子啊次运行查找速度测试程序
 * */

import net.mindview.util.Countries;

import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;

public class E38_HashMapLoadFactor {

    public static void testGet(Map<String, String> filledMap, int n) {
        for (int tc = 0; tc < 1000000; tc++)
            for (int i = 0; i < Countries.DATA.length; i++) {
                String key = Countries.DATA[i][0];
                filledMap.get(key);
            }
    }
    public static void main(String args[]) {
        // Initial capacity 16:
        HashMap<String, String> map1 = new HashMap<String, String>();
        // Fill to less than threshold:
        map1.putAll(Countries.capitals(11));
        // Initial capacity 32:
        HashMap<String, String> map2 = new HashMap<String, String>(32);
        map2.putAll(map1);
        long t1 = System.currentTimeMillis();
        testGet(map1, 11);
        long t2 = System.currentTimeMillis();
        print("map1 : " + (t2 - t1));
        t1 = System.currentTimeMillis();
        testGet(map2, 11);
        t2 = System.currentTimeMillis();
        print("map2 : " + (t2 - t1));
    }
} ///:~
/**
 * From TIJ4:
 * Load factor: size/capacity. A load factor of 0 is an empty table, 0.5 is a halffull table, etc.; map1’s load factor before executing the test is 11/16 = 0.69, and
 * map2’s is 11/32 = 0.34.
 * There are no public methods to access capacity, which you must calculate using
 * data from the map. Either call the appropriate HashMap constructor or look up
 * the default source code in the JDK, as we do here. The default constructor has
 * initial values of:
 * initialCapacity = 16
 * loadFactor = .75
 * The source code also has the threshold — the value at which rehash( ) is
 * called to reorganize the table. From the JDK:
 * threshold = (int)(initialCapacity * loadFactor);
 * The table size increases when the number of elements is greater than or equal to
 * (int)(0.75 * 16) = 12. So when we add a twelfth element the table rehashes.
 * Thinking in Java, 4 486 th Edition Annotated Solution Guide
 * Use HashMap(int initialCapacity), a one-argument constructor, to make a
 * HashMap with a larger initial capacity:
 * HashMap<String,String> map = new HashMap<String,String>(32);
 * Now we have a HashMap with double the default initial capacity, and a
 * threshold of (int)(0.75 * 32) = 24.
 * The output from one run is:
 * map1 : 8469
 * map2 : 7671
 * Lookups make the map with a higher load factor less efficient but higher initial
 * capacity minimizes (or even eliminates) rehash operations.
 */
