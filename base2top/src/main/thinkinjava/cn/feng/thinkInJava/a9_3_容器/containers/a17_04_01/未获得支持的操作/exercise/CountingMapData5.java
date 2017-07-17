package cn.feng.thinkInJava.a9_3_容器.containers.a17_04_01.未获得支持的操作.exercise;// containers/CountingMapData5.java
// TIJ4 Chapter Containers, Exercise 5, page 809
// Modify CountingMapData.java to fully implement the flyweight
// by adding a custom EntrySet class like the one in Countries.java.
// See also alternate solution CountingMapData5Alt.java. 

import java.util.*;

import static cn.feng.utils.Print.println;

/**
 * 修改 CountingMapData.java ,通过添加像Countries.java.中那样的定制 EntrySet 类,来完全实现享元
 */
public class CountingMapData5 extends AbstractMap<Integer, String> {

    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    private static Set<Map.Entry<Integer, String>> entries = new EntrySet(chars.length);
    static Map<Integer, String> select(final int size) {
        return new CountingMapData5() {
            public Set<Map.Entry<Integer, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }
    public static void main(String[] args) {
        println(new CountingMapData5());
        println(select(10));
    }
    public Set<Map.Entry<Integer, String>> entrySet() { return entries; }

    static class Entry implements Map.Entry<Integer, String> {

        int index;
        Entry(int index) { this.index = index; }
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }
        public Integer getKey() { return index; }
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }

    // Use AbstractSet by implementing size() & iterator()
    static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {

        private int size;
        EntrySet(int size) {
            if (size < 0)
                this.size = 0;
            else
                this.size = size;
        }
        public int size() { return size; }
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iter();
        }

        private class Iter implements Iterator<Map.Entry<Integer, String>> {

            // Only one Entry object per Iterator:
            private Entry entry = new Entry(-1);
            public boolean hasNext() {
                return entry.index < size - 1;
            }
            public Map.Entry<Integer, String> next() {
                entry.index++;
                return entry;
            }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }

} 