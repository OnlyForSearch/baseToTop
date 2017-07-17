package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_01.理解hashCode方法;
//: containers/MapEntry.java
// A simple Map.Entry for sample Map implementations.

import java.util.Map;
//十分简单的类可以保存和读取键与值,在entrySet中产生键-值对Set
public class MapEntry<K, V> implements Map.Entry<K, V> {

    private K key;
    private V value;
    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }
    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }
    public boolean equals(Object o) {
        if (!(o instanceof MapEntry))
            return false;
        MapEntry me = (MapEntry) o;
        return (key == null ? me.getKey() == null : key.equals(me.getKey())) && (value == null ? me.getValue() == null : value.equals(me.getValue()));
    }
    public String toString() { return key + "=" + value; }
} ///:~
