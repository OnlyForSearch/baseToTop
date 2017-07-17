//: net/mindview/util/Generated.java
package cn.feng.thinkInJava.数据生成器;

/**
 * 这个工具使用任意的Generator来产生Object子类型的数组
 */
public class Generated {

    // Fill an existing array:
    // 该方法接受一个已存在的数组,并使用某个Generator来填充它
    public static <T> T[] array(T[] a, Generator<T> gen) {
        return new CollectionData<T>(gen, a.length).toArray(a);
    }

    // Create a new array:
    @SuppressWarnings("unchecked")
    // 该方法接受一个Class对象,一个Generator和所需要的元素数量,然后创建一个数组,并使用所接受的
    // Generator来填充和它
    public static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] a = (T[]) java.lang.reflect.Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(a);
    }
} // /:~
