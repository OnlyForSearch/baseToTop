//typeinfo/toys/ToyTest1.java
// TIJ4 Chapter Typeinfo, Exercise 1, page 561
//在ToyTest.java中,将Toy的默认构造器注释掉,并解释发生的现象
// In ToyTest.java, comment out Toy's default constructor and
// explain what happens.
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.class对象.exercise.exe1;

import static net.mindview.util.Print.print;

interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

class Toy {

    // With default constructor commented out will be
    // unable to instantiate this Toy, super of FancyToy:
    // Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {

    FancyToy() { super(1); }
}

public class ToyTest1 {

    static void printInfo(Class cc) {
        print("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name: " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.class对象.exercise.exe1.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor in order to需要默认构造器来创建一个 对象
            // create a super or Toy object:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException i) {
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}