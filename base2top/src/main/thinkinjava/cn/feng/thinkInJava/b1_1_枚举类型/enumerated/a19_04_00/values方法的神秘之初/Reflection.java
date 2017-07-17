package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_04_00.values方法的神秘之初;

//: enumerated/Reflection.java
// Analyzing enums using reflection.

import net.mindview.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;
//编译器将Explore标记为final类,所以无法继承自enum
enum Explore {
    HERE, THERE
}

/**
 * values()的神秘之处
 * enum类都继承自Enum类，但是Enum类中并没有values()方法。values()是由编译器添加的static
 * 方法。编译器还添加了一个只有一个参数的valueOf()方法，和一个static初始化语句块。

由于values()方法是由编译器插入到enum定义中的static方法,
 如果将enum实例向上转型为Enum，那么values()方法就不可访问了。不过，在Class中有一个
 getEnumConstants()方法，所以即便Enum接口中没有values()方法，我们仍然可以通过Class对象取得所有enum实例。
 * Enum类并没有values()方法,是由编译器添加的static 方法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Reflection {

    //利用反射编
    public static Set<String> analyze(Class<?> enumClass) {
        print("----- Analyzing " + enumClass + " -----");
        print("Interfaces:");
        for (Type t : enumClass.getGenericInterfaces())
            print(t);
        print("Base: " + enumClass.getSuperclass());
        print("Methods: ");
        Set<String> methods = new TreeSet<String>();
        for (Method m : enumClass.getMethods())
            methods.add(m.getName());
        print(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        print("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        printnb("Explore.removeAll(Enum): ");
        exploreMethods.removeAll(enumMethods);
        print(exploreMethods);
        // Decompile the code for the enum:
        OSExecute.command("javap Explore");
    }
} /* Output:
----- Analyzing class Explore -----
Interfaces:
Base: class java.lang.Enum
Methods:
[compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, values, wait]
----- Analyzing class java.lang.Enum -----
Interfaces:
java.lang.Comparable<E>
interface java.io.Serializable
Base: class java.lang.Object
Methods:
[compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, wait]
Explore.containsAll(Enum)? true
Explore.removeAll(Enum): [values]
Compiled from "Reflection.java"
final class Explore extends java.lang.Enum{
    public static final Explore HERE;
    public static final Explore THERE;
    public static final Explore[] values();
    public static Explore valueOf(java.lang.String);
    static {};
}
*///:~
