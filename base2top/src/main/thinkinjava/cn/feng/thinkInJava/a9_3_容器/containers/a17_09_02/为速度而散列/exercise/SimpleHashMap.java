package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_02.为速度而散列.exercise;
//: containers/SimpleHashMap.java
// A demonstration hashed Map.

import cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.MapEntry;
import net.mindview.util.Countries;

import java.util.*;

/**
 * 为速度而散列
 *
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
