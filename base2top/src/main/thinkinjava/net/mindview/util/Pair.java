//: net/mindview/util/Pair.java
package net.mindview.util;

public class Pair<K, V> {
/**key和value都是public final,这还是为了使Pair成为只读数据传输对象(或信使)**/
      public final K key;
    public final V value;
    public Pair(K k, V v) {
        key = k;
        value = v;
    }
} ///:~
