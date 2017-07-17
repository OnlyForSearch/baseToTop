package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_05.对Map的选择.exercise;

//: containers/E39_SimpleHashMapRehash.java
/**
 * *************** Exercise 39 *****************
 * Invoke a private rehash() method in SimpleHashMap when
 * the load factor exceeds 0.75. During rehash, determine
 * the new number of buckets by finding the first prime
 * number greater than twice the original number of buckets.
 * *********************************************
 */
/**
 *
 * 在SimpleHashMap中添加private rehash()方法,它将在负载因子超过0.75时候被调用,
 * 在再散列过程中,先求出桶位的数量加倍的值,然后搜索大于这个值的第一个质数,将其作为
 * 新的桶位数
 * */
import cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.MapEntry;
import net.mindview.util.Countries;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

@SuppressWarnings("unchecked")
class SimpleHashMap7<K, V> extends SimpleHashMap<K, V> {

    private static final double loadFactor = 0.75;
    // Use a prime initial capacity; the JDK uses a number,
    // which is a power of 2:
    private final static int initialCapacity = 11;
    private int count; // Number of elements
    private int capacity = initialCapacity;
    private int threshold = (int) (capacity * loadFactor);

    { buckets = new LinkedList[capacity]; }

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % capacity;
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
        if (!found) {
            if (count >= threshold)
                rehash();
            if (buckets[index] == null)
                buckets[index] = new LinkedList<MapEntry<K, V>>();
            buckets[index].add(pair);
            ++count;
        }
        return oldValue;
    }
    private boolean isPrime(int candidate) {
        for (int j = 2; j < candidate; j++)
            if (candidate % j == 0)
                return false;
        return true;
    }
    private int nextPrime(int candidate) {
        while (!isPrime(candidate))
            candidate++;
        return candidate;
    }
    private void rehash() {
        // Points to a new Set of the entries, so it
        // won't be bothered by what we're about to do:
        Iterator<Entry<K, V>> it = entrySet().iterator();
        // Get next prime capacity:
        capacity = nextPrime(capacity * 2);
        System.out.println("Rehashing, new capacity = " + capacity);
        buckets = new LinkedList[capacity];
        threshold = (int) (capacity * loadFactor);
        count = 0;
        // Fill new buckets (crude, but it works):
        while (it.hasNext()) {
            Entry<K, V> me = it.next();
            put(me.getKey(), me.getValue());
        }
    }

}

public class E39_SimpleHashMapRehash {

    public static void main(String[] args) {
        SimpleHashMap7<String, String> m = new SimpleHashMap7<String, String>();
        m.putAll(Countries.capitals(50));
        System.out.println(m);
    }
} /* Output:
Rehashing, new capacity = 23
Rehashing, new capacity = 47
Rehashing, new capacity = 97
{CHAD=N'djamena, BISSAU=Bissau, MOROCCO=Rabat,
LIBERIA=Monrovia, GUINEA=Conakry, LESOTHO=Maseru,
BENIN=Porto-Novo, NAMIBIA=Windhoek, GABON=Libreville,
ETHIOPIA=Addis Ababa, SOUTH AFRICA=Pretoria/Cape Town, SAO
TOME E PRINCIPE=Sao Tome, COMOROS=Moroni, ANGOLA=Luanda,
CAPE VERDE=Praia, THE GAMBIA=Banjul,
MADAGASCAR=Antananarivo, CONGO=Brazzaville,
BURUNDI=Bujumbura, MALI=Bamako, DJIBOUTI=Dijibouti,
SOMALIA=Mogadishu, EQUATORIAL GUINEA=Malabo, SUDAN=Khartoum,
SWAZILAND=Mbabane, EGYPT=Cairo, GHANA=Accra, MAURITIUS=Port
Louis, CENTRAL AFRICAN REPUBLIC=Bangui, SEYCHELLES=Victoria,
COTE D'IVOIR (IVORY COAST)=Yamoussoukro, KENYA=Nairobi,
RWANDA=Kigali, ALGERIA=Algiers, BOTSWANA=Gaberone,
NIGER=Niamey, ERITREA=Asmara, LIBYA=Tripoli, TOGO=Lome,
NIGERIA=Abuja, MOZAMBIQUE=Maputo, MAURITANIA=Nouakchott,
BURKINA FASO=Ouagadougou, UGANDA=Kampala, SENEGAL=Dakar,
CAMEROON=Yaounde, TANZANIA=Dodoma, SIERRA LEONE=Freetown,
MALAWI=Lilongwe, TUNISIA=Tunis}
*///:~
/**
 * The solution is more simple than efficient. Some information comes from the
 * source code for java.util.HashMap in the JDK.
 * Note the new fields at the top of the class: count keeps track of the number of
 * elements; loadFactor is fixed at the default for HashMap, 0.75;
 * initialCapacity is 11; capacity is the current number of buckets (called SIZE in
 * SimpleHashMap.java in TIJ4); and threshold determines when to call
 * rehash( ).
 * We also add code in put( ) to call rehash( ), while the other methods do not
 * change. At the bottom of the class there are three new methods: isPrime( ) and
 * nextPrime( ) generate prime numbers; and rehash( ) itself.
 * rehash( ) begins by getting an Iterator to the entrySet( ) (a set of all keys
 * and values) for this map. The code for entrySet( ) makes a new collection to
 * hold the objects, so the objects are not garbage-collected when we change the
 * bucket container.
 * First we increase the buckets to a new prime number that is more than double
 * the current number. This doubles the capacity, then gives it to nextPrime( ),
 * which calls isPrime( ) to see if the number is prime, and if not, increments the
 * candidate and repeats its test; the process is not very efficient. For further
 * exercise, create a lookup table for prime numbers to use in the map.
 * New capacity creates a new bucket array, the new threshold is calculated,
 * and the entrySet( ) iterator and put( ) reload the elements into the hash
 * table—again, effective but inefficient. (See the java.util.HashMap source code
 * for a better approach.)
 */
