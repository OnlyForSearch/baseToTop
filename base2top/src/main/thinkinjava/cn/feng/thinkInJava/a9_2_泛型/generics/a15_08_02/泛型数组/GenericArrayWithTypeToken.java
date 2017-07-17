package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_02.泛型数组;

//: generics/GenericArrayWithTypeToken.java

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    // 类型标记Class<T>被传递到构造器中,以便从擦除中恢复,使得我们可以创建需要的实际类型数组,一旦我们获得了实际类型就可以返回它,并获得想要的结果
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }
    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<Integer>(Integer.class, 10);
        // This now works://数组运行时的确切类型是T[]
        Integer[] ia = gai.rep();
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) {
        return array[index];
    }
    // Expose the underlying representation:
    public T[] rep() {
        return array;
    }
} /// :~
