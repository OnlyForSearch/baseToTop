package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_05_00.List.exercise;// holding/Ex7.java
// TIJ4 Chapter Holding, Exercise 7, page 406
/* Create a class, then makeD1 an initialized array of objects of your class
* Fill a List from your array. Create a subset of your List by using 
* subList(), then remove this subset from your List.
*//**
 *创建一个类,然后创建一个用你的类的对象进行初始化的数组,通过使用subList()方法,创建
 * 你的List的子集,然后在你的List中移除这个子集
 * */

import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

class Tester {

    public static int counter = 0;
    private int id = counter++;
    public String toString() { return String.valueOf(id); }
}

public class Ex7 {

    public static void main(String[] args) {
        Tester[] t = new Tester[10];
        for (int i = 0; i < t.length; i++)
            t[i] = new Tester();
        List<Tester> lt = new ArrayList<Tester>();
        for (Tester x : t)
            lt.add(x);
        print("list of Tester: " + lt);
        List<Tester> sub = lt.subList(2, 6);
        print("subList: " + sub);
        // produces run time ConcurrentModificationException:
        // lt.removeAll(sub);
        // so, first makeD1 copy, remove sub, re-assign lt:
        List<Tester> copy = new ArrayList<Tester>(lt);
        copy.removeAll(sub);
        print("copy: " + copy);
        lt = copy;
        print("list of Tester: " + lt);
    }
}