package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_05_00.数组与泛型.exercise;// arrays//Ex9.java
// TIJ4 Chapter Arrays, Exercise 9, page 762
/* Create the classes necessary for the Peel<Banana> example and
* show that the compiler doesn't accept it. Fix the problem
* using an ArrayList.
*/

import java.util.ArrayList;
import java.util.List;

/**
 * 创建Peel<Banana>所必须的类,并展示编译器不会接受它,使用 ArrayList.来改此问题
 */
class Banana {

    private static long counter;
    private final long id = counter++;
    public String toString() { return "Banana " + id; }
}

class Peel<T> {

    private static long counter;
    private final long id = counter++;
    private T t;
    public Peel(T t) { this.t = t; }
    public String toString() { return "Peel " + id + " " + t.toString(); }
}

public class Ex9<T> {

    public static void main(String[] args) {
        // error: generic array creation:
        // Peel<Banana>[] peels = new Peel<Banana>[10];
        List<Peel<Banana>> peels = new ArrayList<Peel<Banana>>();
        for (int i = 0; i < 10; i++)
            peels.add(new Peel<Banana>(new Banana()));
        System.out.println(peels);
        System.out.println("peels.get(0).getClass(): " + peels.get(0).getClass());
    }
}