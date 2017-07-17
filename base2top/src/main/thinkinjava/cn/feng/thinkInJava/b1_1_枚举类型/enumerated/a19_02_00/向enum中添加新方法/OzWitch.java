package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_02_00.向enum中添加新方法;

//: enumerated/OzWitch.java
// The witches in the land of Oz.

import static net.mindview.util.Print.print;

/**
 * 向enum中添加新方法
 * 基本上可以将enum看作一个常规的类，也就是说可以向enum添加方法，甚至可以有main方法。

 如果打算添加自己的方法，那么必须在enum实例的最后添加一个分号，而且必须先定义enum实例，
 实例之前不能有任何方法，否则报错。

 因为我们只能在enum定义的内部使用其构造器创建enum实例，所以enum构造器声明为private并没有什么影响。

 此外我们也可以覆盖enum的方法
 * 除了不能继承自一个enum之外,我们基本上可以将enum看做一个常规的类,也就是说
 * enum可以添加方法,enum也可以有main方法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public enum OzWitch {
    // Instances must be defined first, before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinda, the Good Witch of the North"),
    EAST("Wicked Witch of the East, wearer of the Ruby " + "Slippers, crushed by Dorothy's house"),
    SOUTH("Good by inference, but missing");//enum实例序列最后添加一个分号.java要求你必须先定义enum实例,如果在定义enum实例之前定义了任何方法或属性,那么编译时就会得到错误信息
    private String description;

    // Constructor must be package or private access:
    //有意识的将构造器私有化,但对于他的可访问性而言没有多大的变化,因为(即使不声明为private)我们只能在enum定义的内部使用其构造器创建enum实例
    //一旦enum定义结束,编译器就不允许我们再使用其构造器来创建任何实例了
    OzWitch(String description) {
        this.description = description;
    }
    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values())
            print(witch + ": " + witch.getDescription());
    }
    public String getDescription() {
        return description;
    }
} /* Output:
WEST: Miss Gulch, aka the Wicked Witch of the West
NORTH: Glinda, the Good Witch of the North
EAST: Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house
SOUTH: Good by inference, but missing
*///:~
