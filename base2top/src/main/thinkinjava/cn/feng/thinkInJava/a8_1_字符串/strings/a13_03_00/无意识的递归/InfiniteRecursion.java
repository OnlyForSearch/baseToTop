package cn.feng.thinkInJava.a8_1_字符串.strings.a13_03_00.无意识的递归;
//: strings/InfiniteRecursion.java
// Accidental recursion.
// {RunByHand}

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
        for (int i = 0; i < 10; i++)
            v.add(new InfiniteRecursion());
        System.out.println(v);
    }
    /**如果你希望toString()方法打印出对象的内存地址，也许你会考虑使用关键字this。
     * 但是，你会得到一串非常长的异常。这是因为编译器会将this转换成String，怎么转换呢，
     * 调用的就是toString()方法，发生了递归调用。因此，如果你真的想要打印出对象的内存地址，应该调用Object.toString()方法，而不是返回this。
     * */
    public String toString() {
        return " InfiniteRecursion address: " + this + "\n";
    }
} ///:~
