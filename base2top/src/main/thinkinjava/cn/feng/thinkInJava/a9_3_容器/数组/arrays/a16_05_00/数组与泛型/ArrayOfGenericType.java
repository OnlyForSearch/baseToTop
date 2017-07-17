package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_05_00.数组与泛型;
//: arrays/ArrayOfGenericType.java
// Arrays of generic types won't compile.
//一般而言，泛型在类或方法的边界处很有效，而在类或方法的内部，擦除会使得
// 泛型变得不适用，例如，你不能创建泛型数组：
public class ArrayOfGenericType<T> {

    T[] array; // OK
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        //! array = new T[size]; // Illegal
        array = (T[]) new Object[size]; // "unchecked" Warning
    }
    // Illegal:
    //! public <U> U[] makeArray() { return new U[10]; }
} ///:~
