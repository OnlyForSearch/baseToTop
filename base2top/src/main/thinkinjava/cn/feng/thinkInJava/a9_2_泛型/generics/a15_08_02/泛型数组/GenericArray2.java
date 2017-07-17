package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_02.泛型数组;
//: generics/GenericArray2.java

public class GenericArray2<T> {

    private Object[] array;
    public GenericArray2(int sz) {
        array = new Object[sz];
    }
    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<Integer>(10);
        for (int i = 0; i < 10; i++)
            gai.put(i, i);
        for (int i = 0; i < 10; i++)
            System.out.print(gai.get(i) + " ");
        System.out.println();
        try {
            Integer[] ia = gai.rep();
        } catch (Exception e) { System.out.println(e); }
    }//没有任何方式可以推翻底层数组类型,他只能是Object[].在内部将array当做Object[]而不是T[]处理的优势:我们不太可能忘记这个数组的运行时类型,从而意外地引入缺陷
    public void put(int index, T item) {
        array[index] = item;
    }
    @SuppressWarnings("unchecked")
    public T get(int index) { return (T) array[index]; }
    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array; // Warning: unchecked cast
    }
} /* Output: (Sample)
0 1 2 3 4 5 6 7 8 9
java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
*///:~
