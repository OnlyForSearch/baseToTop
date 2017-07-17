package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_00.通配符;

//: generics/CovariantArrays.java
class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}

/**
 * 展示数组的一种特殊行为:可以向导出类型的数组赋予基本类型的数组引用
 * 通配符
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class CovariantArrays {

    public static void main(String[] args) {
        //创建Apple数组,并将其赋值给一个Fruit数组引用.但是实际的数组类型是Apple[]
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {    //编译器允许你将Fruit放置在数组中
            // Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // 运行时抛出ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch (Exception e) {
            System.out.println(e);
        }
    }
} /*
 * Output: java.lang.ArrayStoreException: Fruit java.lang.ArrayStoreException:
 * Orange
 *///:~
