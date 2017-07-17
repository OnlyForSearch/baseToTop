package cn.feng.thinkInJava.a9_3_容器.containers.a17_12_01.WeekHashMap;
//: containers/CanonicalMapping.java
// Demonstrates WeakHashMap.

import java.util.WeakHashMap;

/**
 * WeekHashMap
 *容器类中有一种特殊的Map，即WeakHashMap，它被用来保存WeakReference。它使得规范映射更易于使用。
 * 在这种映射中，每个值只保存一份实例以节省存储空间。当程序需要那个“值”的时候，便在映射中查询
 * 现有的对象，然后使用它（而不是重新再创建）。映射可将值作为其初始化中的一部分，不过通常是在需要
 * 的时候才生成“值”。

 这是一种节约存储空间的技术，因为WeakHashMap允许垃圾回收器自动清理键和值，所以它显得十分便
 利。对于向WeakHashMap添加键和值的操作，则没有什么特殊要求。映射会自动使用WeakReference包装它们。
 允许清理元素的触发条件是：不再需要此键了。

 运行此程序，会看到垃圾回收器每个三个键就跳过一个，因为那个键的普通引用被存入keys数组，所
 以那些对象不能被垃圾回收器回收。
 * @author fengyu
 * @date 2015年8月9日
 */
class Element {

    private String ident;
    public Element(String id) { ident = id; }
    public String toString() { return ident; }
    public int hashCode() { return ident.hashCode(); }
    public boolean equals(Object r) {
        return r instanceof Element && ident.equals(((Element) r).ident);
    }
    protected void finalize() {
        System.out.println("Finalizing " +
                getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {

    public Key(String id) { super(id); }
}

class Value extends Element {

    public Value(String id) { super(id); }
}

public class CanonicalMapping {

    public static void main(String[] args) {
        int size = 1000;
        // Or, choose size via the command line:
        if (args.length > 0)
            size = new Integer(args[0]);
        Key[] keys = new Key[size];
        WeakHashMap<Key, Value> map = new WeakHashMap<Key, Value>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(Integer.toString(i));
            Value v = new Value(Integer.toString(i));
            if (i % 3 == 0)
                keys[i] = k; // Save as "real" references
            map.put(k, v);
        }
        System.gc();
    }
} /* (Execute to see output) *///:~
