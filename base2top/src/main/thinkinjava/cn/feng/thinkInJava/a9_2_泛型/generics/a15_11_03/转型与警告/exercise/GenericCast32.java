package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_03.转型与警告.exercise;// generics/GenericCast32.java
// TIJ4 Chapter Genericss, Exercise 32, page 699
/*
* Verify that FixedSizeStack in GenericCast.java generates exceptions
* if you try to go out of its bounds. Does this mean that bounds-checking
* code is not required?
*/

/**
 * 验证 in GenericCast.java 中FixedSizeStack将产生异常,如果试图超出边界的话,这是否意味着边界检查代码是不需要的?
 *
 * @param <T>
 */
class FixedSizeStack<T> {

    private int index = 0;
    private Object[] storage;
    public FixedSizeStack(int size) {
        storage = new Object[size];
    }
    int getIndex() { return index; }
    public void push(T item) { storage[index++] = item; }
    @SuppressWarnings("unchecked")
    public T pop() { return (T) storage[--index]; }
}

public class GenericCast32 {

    public static final int SIZE = 10;
    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
        for (String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        // Runtime ArrayIndexOutOfBoundsException:
        // strings.push("oops"); // Bounds-checking required:
        if (strings.getIndex() < SIZE)
            strings.push("oops");
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }

}