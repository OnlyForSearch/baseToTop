package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_01_00.基本的enum特性;

//: enumerated/EnumClass.java
// Capabilities of the Enum class

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

enum Shrubbery {
    GROUND, CRAWLING, HANGING
}

/**
 * 基本的enum特性
 * 关键字enum可以将一组具名的值的有限集合创建为一种新的类型,而这些具名的只可以作为常规的程序组件使用
 *
 *基本enum特性

 Enum类是枚举的一个封装类，是所有枚举类型的超类，它是一个没有抽象方法的抽象类。Enum类实现了Comparable接口
 ，所以它具有compareTo() 方法。同时它还实现了Serializable接口。

 ordinal() : 获取枚举元素声明时的顺序，从0开始计算
 可以使用”==”来比较两个枚举实例相同与否，由于编译器自动实现了equals()和hashCode()两个方法
 调用getDeclaringClass()方法，我们就能知道其所属的enum类
 name() : 返回enum实例声明时的名字，与使用toString()方法效果相同
 valueOf() : Enum中的static方法，根据给定的名字返回相应的enum实例，如果不存在给定实例的名字，将会抛出异常。
 values() : 这个方法不是Enum提供的。

 *
 * @author fengyu
 * @date 2015年8月9日
 */

public class EnumClass {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        //values()方法在返回enum实例的数组,而且该数组中的元素严格保持其在enum中的声明顺序,因此可以在循环中使用values()返回的数组
        for (Shrubbery s : Shrubbery.values()) {
            print(s + " ordinal: " + s.ordinal());// ordinal返回一个int值这是每个enum实例在声明时候的值,从0开始
            printnb(s.compareTo(Shrubbery.CRAWLING) + " ");//Enum类实现了Comparable接口所以它具有compareTo()方法,
            printnb(s.equals(Shrubbery.CRAWLING) + " ");
            // 可以使用==来比较enum实例,编译器自动提供equals()和hashCode()方法,同时还实现了Serializable接口
            print(s == Shrubbery.CRAWLING);
            print(s.getDeclaringClass());//获取enum实例所属的enum类
            print(s.name());//方法返回enum实例的名字和tostring()方法效果相同
            print("----------------------");
        }
        // Produce an enum value from a string name:
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            //valueOf()是在Enum中定义的静态方法,它根据给定的名字返回相应的enum实例,如果不存在给定名字的实例将抛出异常java.lang.IllegalArgumentException
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            print(shrub);
        }
    }
} /*
     * Output: GROUND ordinal: 0 -1 false false class Shrubbery GROUND
	 * ---------------------- CRAWLING ordinal: 1 0 true true class Shrubbery
	 * CRAWLING ---------------------- HANGING ordinal: 2 1 false false class
	 * Shrubbery HANGING ---------------------- HANGING CRAWLING GROUND
	 */// :~
