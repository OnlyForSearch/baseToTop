package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_02.为速度而散列;
//: containers/SimpleHashMap.java
// A demonstration hashed Map.

import cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.MapEntry;
import net.mindview.util.Countries;

import java.util.*;

/**
 * 为速度而散列
 *为速度而散列

 散列的价值在于速度：散列使得查询得以快速进行。由于瓶颈位于键的查询速度，因此解决方案之一就是保持键的排序状态，
 然后使用Collections.binarySearch()进行查询。

 存储一组元素最快的数据结构是数组，所以使用它来表示键的信息（请小心留意，我是说键的信息，而不是键本身）。
 数组并不保存键本身。而是通过键对象生成一个数字，将其作为数组的下标。这个数字就是散列码，由定义在Object中的、
 且可能由你的类覆盖的hashCode()方法（在计算机科学的术语中称为散列函数）生成。

 为解决数组容量被固定的问题，不同的键可以产生相同的下标。也就是说，可能会有冲突。因此，数组多大就不重要了，
 任何键总能在数组中找到它的位置。通常，冲突由外部链接处理：数组并不直接保存值，而是保持值的list。然后对list
 中的值使用equals()
 方法进行线性的查询。这部分的查询自然会比较慢，但是，如果散列函数好的话，数组的每个位置就只有较少的值。因此，
 不是查询整个list，而是快速地跳到数组的某个位置，只对很少的元素进行比较。这便是HashMap会如此快的原因。

 散列表中的槽位通常称为桶位(bucket)。

 为使散列分布均匀，桶的数量通常使用质数。事实证明，质数实际上并不是散列桶的理想容量。近来，（经过广泛的测试）
 Java的散列函数都使用2的整数次方。对现在的处理器来说，除法与求余是最慢的操作。使用2的整数次方长度的散列表，可以用掩码代替除法。因为get()
 是使用最多的操作，求余数的%操作是其开销最大的部分，而使用2的整数次方可以消除此开销（也可能对hashCode()有些影响）。
 * @param <K>
 * @param <V>
 * @author fengyu
 * @date 2015年8月9日
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<String, String>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());
    }
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
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
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
} /* Output:
{CAMEROON=Yaounde, CONGO=Brazzaville, CHAD=N'djamena, COTE D'IVOIR (IVORY COAST)=Yamoussoukro, CENTRAL AFRICAN REPUBLIC=Bangui, GUINEA=Conakry, BOTSWANA=Gaberone, BISSAU=Bissau,
 EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, ERITREA=Asmara, THE GAMBIA=Banjul, KENYA=Nairobi, GABON=Libreville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni,
 EQUATORIAL GUINEA=Malabo, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, GHANA=Accra, DJIBOUTI=Dijibouti, ETHIOPIA=Addis Ababa}
Asmara
[CAMEROON=Yaounde, CONGO=Brazzaville, CHAD=N'djamena, COTE D'IVOIR (IVORY COAST)=Yamoussoukro, CENTRAL AFRICAN REPUBLIC=Bangui, GUINEA=Conakry, BOTSWANA=Gaberone, BISSAU=Bissau,
 EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, ERITREA=Asmara, THE GAMBIA=Banjul, KENYA=Nairobi, GABON=Libreville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni,
 EQUATORIAL GUINEA=Malabo, BURUNDI=Bujumbura, BENIN=Porto-Novo, BULGARIA=Sofia, GHANA=Accra, DJIBOUTI=Dijibouti, ETHIOPIA=Addis Ababa]
*///:~
