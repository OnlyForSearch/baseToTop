//typeinfo/toys/ToyTest2.java
// TIJ4 Chapter Typeinfo, Exercise 2, page 561
// Incorporate a new kind of interface into ToyTest.java and
//将新的interface加到ToyTest.java中,看看这个程序是否能够正确检测出来并加以显示
// verify that it is detected and displayed properly.
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.class对象.exercise.exe2;

import static net.mindview.util.Print.print;

interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

interface Flies {}

class Toy {

    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    Toy() {}
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, Flies {

    FancyToy() { super(1); }
}

public class ToyTest2 {

    static void printInfo(Class cc) {
        print("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        print("Simple name: " + cc.getSimpleName());
        print("Canonical name: " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.class对象.exercise.exe2.FancyToy");
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
            // Requires default constructor:
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