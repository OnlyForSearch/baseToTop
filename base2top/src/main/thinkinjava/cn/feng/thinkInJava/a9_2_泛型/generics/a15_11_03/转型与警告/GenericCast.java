package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_03.转型与警告;

//: generics/GenericCast.java

/**
 * 转型和警告:使用带有泛型类型参数的转型或instance不会有任何效果
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月9日
 */
class FixedSizeStack<T> {

    private int index = 0;
    private Object[] storage;

    public FixedSizeStack(int size) {
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    public T pop() {
        // 由于擦除原因,编译器无法知道这个转型是否安全的,并且pop方法实际上并没有执行任何转型,这是因为,T被擦除到他的第一个边界,默认情况下是
        //Object,因此pop方法实际上只是将Object转型为Object
        return (T) storage[--index];
    }
}

public class GenericCast {

    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
        for (String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
} /*
     * Output: J I H G F E D C B A
	 */// :~
