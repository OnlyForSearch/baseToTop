package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_07_02.数组的比较.exercise.exercise;// arrays/Ex19.java
// TIJ4 Chapter Arrays, Exercise 19, page 778
/* Create a class with an int field that's initialized from a constructor
* argument. Create two arrays of these objects, using identical
* intitialization values for each array, and show that Arrays.equals() says
* that they are unequal. Add an equals() method to your class to fix the
* problem.
*/

import java.util.Arrays;

import static net.mindview.util.Print.print;

/**
 * 创建一个类,它有一个用构造器中的参数初始化的int域,创建a由这个类的对象构成的两个数组,
 * 每个数组都是用了相同的初始化值,然后并展示他们不相等的Arrays.equals()声明,在你的类中
 * 添加一个equals()方法来解决此问题
 */

class A {

    protected int x;
    A(int x) { this.x = x; }
    public boolean equals(Object b) {
        return (b.getClass().getSimpleName() == "A" && this.x == ((A) b).x) ? true : false;
    }
}

public class Ex19 {

    public static void main(String[] args) {
        A[] a1 = {new A(1), new A(2), new A(3)};
        A[] a2 = {new A(1), new A(2), new A(3)};
        print(Arrays.toString(a1));
        print(Arrays.toString(a2));
        print(Arrays.equals(a1, a2));
    }
}