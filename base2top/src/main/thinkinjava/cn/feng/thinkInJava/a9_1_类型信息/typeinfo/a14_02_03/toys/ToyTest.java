//: typeinfo/toys/ToyTest.java
// Testing class Class.
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.toys;

import static net.mindview.util.Print.print;

interface HasBatteries {}

interface Waterproof {}

interface Shoots {}

class Toy {

    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {

    FancyToy() {
        super(1);
    }
}

public class ToyTest {

    static void printInfo(Class cc) {
        //Class.getName()得到全限定的类名,  isInterface判断是否是接口
        print("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        //getSimpleName不包含包名的类名
        print("Simple name: " + cc.getSimpleName());
        //全限定的类名
        print("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {    //传递个Class.forName()中的字符串必须使用全限定名(包含包名)
            c = Class.forName("cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            print("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        //getInterfaces返回Class对象,它们表示感兴趣的Class对象中所包含的接口
        for (Class face : c.getInterfaces())
            printInfo(face);
        //直接使用getSuperclass方法查询其直接基类,这将返回你可以用来进一步查询的Class对象,
        // ,因此可以在运行时候发现一个对象完整的类继承结构
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            //newInstance()实现"虚拟构造器"的一种途径,虚拟构造器允许你声明:"我不知道你的确切类型,但是无
            // 论如何要正确地创建你自己",必须具有默认构造器
            obj = up.newInstance();
        } catch (InstantiationException e) {
            print("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
} /* Output:
Class name: typeinfo.toys.FancyToy is interface? [false]
Simple name: FancyToy
Canonical name : typeinfo.toys.FancyToy
Class name: typeinfo.toys.HasBatteries is interface? [true]
Simple name: HasBatteries
Canonical name : typeinfo.toys.HasBatteries
Class name: typeinfo.toys.Waterproof is interface? [true]
Simple name: Waterproof
Canonical name : typeinfo.toys.Waterproof
Class name: typeinfo.toys.Shoots is interface? [true]
Simple name: Shoots
Canonical name : typeinfo.toys.Shoots
Class name: typeinfo.toys.Toy is interface? [false]
Simple name: Toy
Canonical name : typeinfo.toys.Toy
*///:~
