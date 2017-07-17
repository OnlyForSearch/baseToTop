package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法.exercise;

//: containers/E18_SlowSet.java
/**
 * *************** Exercise 18 *****************
 * Using SlowMap.java for inspiration, create a
 * SlowSet.
 * *********************************************
 *//**参考ShowMap.java创建一个SlowSet)*/

import net.mindview.util.Countries;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SlowSet<K> extends AbstractSet<K> {

    private List<K> keys = new ArrayList<K>();
    public boolean add(K key) {
        if (!contains(key)) {
            keys.add(key);
            return true;
        }
        return false;
    }

    public Iterator<K> iterator() { return keys.iterator(); }
    public int size() { return keys.size(); }
}

public class E18_SlowSet {

    public static void main(String[] args) {
        SlowSet<String> slowSet = new SlowSet<String>();
        slowSet.addAll(Countries.names(10));
        slowSet.addAll(Countries.names(10));
        slowSet.addAll(Countries.names(10));
        System.out.println(slowSet);
    }
} /* Output:
[ALGERIA, ANGOLA, BENIN, BOTSWANA, BURKINA FASO, BURUNDI,
CAMEROON, CAPE VERDE, CENTRAL AFRICAN REPUBLIC, CHAD]
*///:~
//We test by repeatedlyadding the same elements to the set.