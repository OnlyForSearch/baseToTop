package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法;

//: containers/SlowMap.java
// A Map implemented with ArrayLists.

import net.mindview.util.Countries;

import java.util.*;

/**
 *
 * 理解hashCode()
 * 首先使用散列的目的在于:想要使用一个对象来查找另一个对象
 *
 *如果不为你的键覆盖hashCode()和equals()，那么使用散列的数据结构（HashSet，HashMap，LinkedHashSet或LinkedHashMap）就无法正确处理你的键。
 * @param <K>
 * @param <V>
 * @author fengyu
 * @date 2015年8月9日
 *///示例展示了用一对ArrayList实现了一个Map,其中包含了Map接口的完整实现因此提供了entrySet()方法
public class SlowMap<K, V> extends AbstractMap<K, V> {

    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<String, String>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }

    /**方法只是将键与值放入相应的ArrayList,为了与Map接口保持一直,它必须返回旧键,或者在没有
     * 任何旧键的情况下返回null
     * */
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }
    /**get遵循了Map规范,会在key不在SlowMap中时候产生null,,如果键存在它将被用来查找表示他在
     * keys列表中的位置的数值型索引,并且这个数字被用作索引来产生与values列表相关联的值,
     *
     * */
    public V get(Object key) { // key is type Object, not K
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }
    //entrySet产生一个Map.Entry对象集,但是Map.Entry是一个接口,用来描述依赖于实现的结构,因此必须实现Entry几口
    public Set<Entry<K, V>> entrySet() {
        //使用HashSet
        Set<Entry<K, V>> set = new HashSet<Entry<K, V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext())
            set.add(new MapEntry<K, V>(ki.next(), vi.next()));
        return set;
    }
} /* Output:
{CAMEROON=Yaounde, CHAD=N'djamena, CONGO=Brazzaville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni, CENTRAL AFRICAN REPUBLIC=Bangui, BOTSWANA=Gaberone, BURUNDI=Bujumbura,
BENIN=Porto-Novo, BULGARIA=Sofia, EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti}
Sofia
[CAMEROON=Yaounde, CHAD=N'djamena, CONGO=Brazzaville, CAPE VERDE=Praia, ALGERIA=Algiers, COMOROS=Moroni, CENTRAL AFRICAN REPUBLIC=Bangui, BOTSWANA=Gaberone, BURUNDI=Bujumbura,
BENIN=Porto-Novo, BULGARIA=Sofia, EGYPT=Cairo, ANGOLA=Luanda, BURKINA FASO=Ouagadougou, DJIBOUTI=Dijibouti]
*///:~
