//: net/mindview/util/MapData.java
// A Map filled with data using a generator object.
package net.mindview.util;

import java.util.LinkedHashMap;

/**
 * Map生成器
 *
 *
 * 这个类接受一个Iterator(allTypes List),和一个常数值,然后用allType中元素作为键,用0作为值,来填充Map.
 * @param <K>
 * @param <V>
 * @author fengyu
 * @date 2015年8月9日
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {

    // A single Pair Generator:使用单一的Generator<Pair<K, V>>
    public MapData(Generator<Pair<K, V>> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> p = gen.next();
            put(p.key, p.value);
        }
    }
    // Two separate Generators:两个分离的Generator
    public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), genV.next());
        }
    }
    // A key Generator and a single value:一个Generator和一个常量值
    public MapData(Generator<K> genK, V value, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(genK.next(), value);
        }
    }
    // An Iterable and a value Generator:一个Iterable(包括任何Collection)和一个Generator
    public MapData(Iterable<K> genK, Generator<V> genV) {
        for (K key : genK) {
            put(key, genV.next());
        }
    }
    // An Iterable and a single value:一个Iterable和一个单一值
    public MapData(Iterable<K> genK, V value) {
        for (K key : genK) {
            put(key, value);
        }
    }
    // Generic convenience methods:
    public static <K, V> MapData<K, V> map(Generator<Pair<K, V>> gen, int quantity) {
        return new MapData<K, V>(gen, quantity);
    }
    public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData<K, V>(genK, genV, quantity);
    }
    public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity) {
        return new MapData<K, V>(genK, value, quantity);
    }
    public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<K, V>(genK, genV);
    }
    public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
        return new MapData<K, V>(genK, value);
    }
} ///:~
