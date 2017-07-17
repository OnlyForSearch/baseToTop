// typeinfo/toys/ToyTest19.java
// TIJ4 Chapter Typeinfo, Exercise 19, page 593
// In ToyTest.java, use reflection to create a Toy object using
// the non-default constructor.
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_06_00.类方法的提取器.exercise;

import java.lang.reflect.InvocationTargetException;

import static net.mindview.util.Print.print;

interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

/**
 * 在ToyTest.java中使用反射机制,通过默认构造器创建Toy对象
 */
class Toy {

    Toy() {
        print("Creating Toy() object");
    }
    Toy(int i) {
        print("Creating Toy(" + i + ") object");
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {

    FancyToy() { super(1); }
}

public class ToyTest19 {

    public static void main(String[] args) {
        // get appropriate constructor and create new instance:
        try {
            Toy.class.getDeclaredConstructor(int.class).newInstance(1);
            // catch four exceptions:
        } catch (NoSuchMethodException e) {
            print("No such method: " + e);
        } catch (InstantiationException e) {
            print("Unable makeD1 Toy: " + e);
        } catch (IllegalAccessException e) {
            print("Unable access: " + e);
        } catch (InvocationTargetException e) {
            print("Target invocation problem: " + e);
        }
    }
}