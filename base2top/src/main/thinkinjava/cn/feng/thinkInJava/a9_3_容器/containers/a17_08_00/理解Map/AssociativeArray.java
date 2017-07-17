package cn.feng.thinkInJava.a9_3_容器.containers.a17_08_00.理解Map;

//: containers/AssociativeArray.java
// Associates keys with values.

import static net.mindview.util.Print.print;

/**
 * 理解Map
 *散列码是“相对唯一的”、用以代表对象的int值，它是通过将该对象的某些信息进行转换而生成的。
 class 	description
 HashMap(默认选择，速度最快) 	Map基于散列表的实现（它取代了Hashtable）。插入和查询“键值对”的开销是固定的。可以通过构造器设置容量和负载因子，以调整容器的性能。
 LinkedHashMap 	类似于HashMap，但是迭代遍历它时，取得“键值对”的顺序是其插入次序，或者是最近最少使用(LRU)的次序。只比HashMap慢一点；而在迭代访问时反而更快，因为它使用链表维护内部次序。
 TreeMap 	基于红黑树的实现。查看“键”或“键值对”时，它们会被排序（次序由Comparable或Comparator决定）。TreeMap的特点在于，所得到的结果是经过排序的。TreeMap是唯一的带有subMap()方法的Map，它可以访问一个子树。
 WeakHashMap 	弱键(weak key)映射，允许释放映射所指向的对象；这是为解决某类特殊问题而设计的。如果映射之外没有引用指向某个“键”，则此“键”可以被垃圾回收器回收
 ConcurrentHashMap 	一种线程安全的Map，它不涉及同步加锁。
 IdentityHashMap 	使用==代替equals()对“键”进行比较的散列映射。专为解决特殊问题而设计的。

 对Map中使用的键的要求与对Set中的元素的要求一样，任何键都必须具有一个equals()方法；如果键被用于散列Map，那么它必须还具有恰当的hashCode()方法；如果键被用于TreeMap，那么它必须实现Comparable。
 * @param <K>
 * @param <V>
 * @author fengyu
 * @date 2015年8月9日
 */
public class AssociativeArray<K, V> {

    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }
    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<String, String>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object"); // Past the end
        } catch (ArrayIndexOutOfBoundsException e) {
            print("Too many objects!");
        }
        print(map);
        print(map.get("ocean"));
    }
    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null; // Did not find key
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }
} /* Output:
Too many objects!
sky : blue
grass : green
ocean : dancing
tree : tall
earth : brown
sun : warm
dancing
*///:~
