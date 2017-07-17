package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_02.为速度而散列.exercise;

/**
 * Created by fengYu Administrator on 2015/11/9.
 * <p>
 * *************** Exercise 20 *****************
 * Modify SimpleHashMap so it reports
 * collisions, and test this by adding the same
 * data set twice so you see collisions.
 * *********************************************
 */
/**x修改SimpleHashMap,令其能能够报告冲突,并添加相同数据来测试,以便能够看到冲突*/

//: containers/E20_SimpleHashMapCollisons.java
/**
 * *************** Exercise 20 *****************
 * Modify SimpleHashMap so it reports
 * collisions, and test this by adding the same
 * data set twice so you see collisions.
 * *********************************************
 */

import cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.MapEntry;
import net.mindview.util.Countries;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

class SimpleHashMap2<K, V> extends SimpleHashMap<K, V> {

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        if (buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K, V>>();
            // Lines added here:
        else {
            System.out.println("Collision while adding\n" + pair + "\nBucket already contains:");
            Iterator<MapEntry<K, V>> it = buckets[index].iterator();
            while (it.hasNext())
                System.out.println(it.next());
        }
        // End of lines added
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
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
}

public class E20_SimpleHashMapCollisons {

    public static void main(String[] args) {
        SimpleHashMap2<String, String> m = new SimpleHashMap2<String, String>();
        m.putAll(Countries.capitals(25));
        m.putAll(Countries.capitals(25));
        System.out.println(m);
    }
} /* Output:
Collision while adding
ALGERIA=Algiers
Bucket already contains:
ALGERIA=Algiers
Collision while adding
ANGOLA=Luanda
Bucket already contains:
ANGOLA=Luanda
Collision while adding
BENIN=Porto-Novo
Bucket already contains:
BENIN=Porto-Novo
Collision while adding
BOTSWANA=Gaberone
Bucket already contains:
BOTSWANA=Gaberone
Collision while adding
BURKINA FASO=Ouagadougou
Bucket already contains:
BURKINA FASO=Ouagadougou
Collision while adding
BURUNDI=Bujumbura
Bucket already contains:
BURUNDI=Bujumbura
Collision while adding
CAMEROON=Yaounde
Bucket already contains:
Thinking in Java, 4 438 th Edition Annotated Solution Guide
CAMEROON=Yaounde
Collision while adding
CAPE VERDE=Praia
Bucket already contains:
CAPE VERDE=Praia
Collision while adding
CENTRAL AFRICAN REPUBLIC=Bangui
Bucket already contains:
CENTRAL AFRICAN REPUBLIC=Bangui
Collision while adding
CHAD=N'djamena
Bucket already contains:
CHAD=N'djamena
Collision while adding
COMOROS=Moroni
Bucket already contains:
COMOROS=Moroni
Collision while adding
CONGO=Brazzaville
Bucket already contains:
CONGO=Brazzaville
Collision while adding
DJIBOUTI=Dijibouti
Bucket already contains:
DJIBOUTI=Dijibouti
Collision while adding
EGYPT=Cairo
Bucket already contains:
EGYPT=Cairo
Collision while adding
EQUATORIAL GUINEA=Malabo
Bucket already contains:
EQUATORIAL GUINEA=Malabo
Collision while adding
ERITREA=Asmara
Bucket already contains:
ERITREA=Asmara
Collision while adding
ETHIOPIA=Addis Ababa
Bucket already contains:
ETHIOPIA=Addis Ababa
Collision while adding
GABON=Libreville
Bucket already contains:
GABON=Libreville
Collision while adding
THE GAMBIA=Banjul
Containers in Depth 439
Bucket already contains:
THE GAMBIA=Banjul
Collision while adding
GHANA=Accra
Bucket already contains:
GHANA=Accra
Collision while adding
GUINEA=Conakry
Bucket already contains:
GUINEA=Conakry
Collision while adding
BISSAU=Bissau
Bucket already contains:
BISSAU=Bissau
Collision while adding
COTE D'IVOIR (IVORY COAST)=Yamoussoukro
Bucket already contains:
COTE D'IVOIR (IVORY COAST)=Yamoussoukro
Collision while adding
KENYA=Nairobi
Bucket already contains:
KENYA=Nairobi
Collision while adding
LESOTHO=Maseru
Bucket already contains:
LESOTHO=Maseru
{CHAD=N'djamena, BISSAU=Bissau, CONGO=Brazzaville,
BURUNDI=Bujumbura, DJIBOUTI=Dijibouti, EQUATORIAL
GUINEA=Malabo, GUINEA=Conakry, LESOTHO=Maseru, EGYPT=Cairo,
GHANA=Accra, CENTRAL AFRICAN REPUBLIC=Bangui, BENIN=PortoNovo, GABON=Libreville, COTE D'IVOIR (IVORY
COAST)=Yamoussoukro, KENYA=Nairobi, ETHIOPIA=Addis Ababa,
ALGERIA=Algiers, BOTSWANA=Gaberone, COMOROS=Moroni,
ANGOLA=Luanda, ERITREA=Asmara, CAPE VERDE=Praia, BURKINA
FASO=Ouagadougou, THE GAMBIA=Banjul, CAMEROON=Yaounde}
*///:~
//We added the lines surrounded by comments in the put()method,and moved the creation of the pair object so it prints when the collision occurs.Everything else is the same.