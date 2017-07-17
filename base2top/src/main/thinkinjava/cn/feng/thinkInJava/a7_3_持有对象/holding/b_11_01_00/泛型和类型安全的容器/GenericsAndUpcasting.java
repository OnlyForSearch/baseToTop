package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_01_00.泛型和类型安全的容器;


//: holding/GenericsAndUpcasting.java

import java.util.ArrayList;

class GrannySmith extends Apple {}

class Gala extends Apple {}

class Fuji extends Apple {}

class Braeburn extends Apple {}

public class GenericsAndUpcasting {

    public static void main(String[] args) {
        //指定了某个类型作为泛型参数时候,不仅限于只能将该确切类型的对象放置到容器中,向上转
        // 型,也可以作用于其他类型一样作用于泛型
        ArrayList<Apple> apples = new ArrayList<Apple>();
        apples.add(new GrannySmith());
        apples.add(new Gala());
        apples.add(new Fuji());
        apples.add(new Braeburn());
        for (Apple c : apples)
            System.out.println(c);
    }
}
/**
 * 输出是Object默认的toString()方法产生的,该方法打印类名,后面跟随该对象的
 * 散列码的无符号十六进制(这个散列码通过hashCode()方法产生)
 */
/* Output: (Sample)


GrannySmith@7d772e
Gala@11b86e7
Fuji@35ce36
Braeburn@757aef
*///:~

