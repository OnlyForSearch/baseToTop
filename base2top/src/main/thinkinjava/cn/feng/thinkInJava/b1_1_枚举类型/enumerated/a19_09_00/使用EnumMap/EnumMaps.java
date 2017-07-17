//: enumerated/EnumMaps.java
// Basics of EnumMaps.
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_09_00.使用EnumMap;

import java.util.EnumMap;
import java.util.Map;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

interface Command {

    void action();
}

/**
 * EnumMap速度很快，只能讲enum的实例作为键来调用put()方法，其它操作和一般Map差不多。

 需要在EnumMap的构造器中指定enum类型。

 与EnumSet一样，enum实例定义时的次序决定了其在EnumMap中的顺序。

 与常量相关的方法相比，EnumMap有一个优点，那EnumMap允许程序员改变值对象，而常量相关的方法在编译期就固定了。
 *
 * EnumMap是一种特殊的Map,他要求其中的键必须来自一个Enum,由于enum本身的限制,所以EnumMap在内部可由数组实现
 * ,因此EnumMap速度很快
 *
 * @author fengyu
 * @date 2015年8月14日
 */
public class EnumMaps {    //演示命令设计模式,命令模式首先需要一个只有单一方法的接口,然后从该接口实现具有各自不同的行为的多个子类

    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(AlarmPoints.KITCHEN, new Command() {
            public void action() {
                print("Kitchen fire!");
            }
        });
        em.put(AlarmPoints.BATHROOM, new Command() {
            public void action() {
                print("Bathroom alert!");
            }
        });
        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            printnb(e.getKey() + ": ");
            e.getValue().action();
        }
        try { // If there's no value for a particular key:
            //如果没有为这个键调用put()方法来存入相应的值的话,其值就是null
            em.get(AlarmPoints.UTILITY).action();
        } catch (Exception e) {
            print(e);
        }
    }
} /*
 * Output: BATHROOM: Bathroom alert! KITCHEN: Kitchen fire!
 * java.lang.NullPointerException
 */// :~
