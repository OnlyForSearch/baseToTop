package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_01_00.泛型和类型安全的容器;


//: holding/ApplesAndOrangesWithGenerics.java

import java.util.ArrayList;

/**
 * 使用泛型:通过使用泛型,就可以在编译期间防止将错误类型对象放置到容器中
 *
 * @author fengyu
 * @date 2015年8月8日
 */

public class ApplesAndOrangesWithGenerics {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        // Compile-time error:
        // apples.add(new Orange());//变成了编译期错误,而不再是运行期错误
        for (int i = 0; i < apples.size(); i++)
            //取出元素时不再需要类型转换了,因为List知道保存什么类型,因此会在调用get()时替你执行转型
            System.out.println(apples.get(i).id());
        // Using foreach:
        for (Apple c : apples)
            System.out.println(c.id());
    }
} /* Output:
    0
	1
	2
	0
	1
	2
	*///:~

