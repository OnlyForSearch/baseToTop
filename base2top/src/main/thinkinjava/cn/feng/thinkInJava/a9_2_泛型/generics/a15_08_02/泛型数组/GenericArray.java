package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_02.泛型数组;

//: generics/GenericArray.java

/**
 * 简单的泛型数组包装器
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月12日
 */
public class GenericArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }
    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<Integer>(10);
        // This causes a ClassCastException:
        // ! Integer[] ia = gai.rep();//实际上运行时的类型是Object[]
        // This is OK:
        Object[] oa = gai.rep();
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) {
        return array[index];
    }
    // Method that exposes the underlying representation:
    public T[] rep()//返回T[]
    {
        return array;
    }
} // /:~
