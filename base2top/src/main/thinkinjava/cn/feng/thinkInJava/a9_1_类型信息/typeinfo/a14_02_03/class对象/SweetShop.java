package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.class对象;
//: typeinfo/SweetShop.java
// Examination of the way the class loader works.

import static net.mindview.util.Print.print;

/**
 * Class对象
 * <p>
 * 每个类都有一个Class 对象，每当编写并且编译一个新类，就会产生一个Class对象（更恰当的说，是被保存在一个同名的.class文件中）。为了生成这个类的对象，运行这个程序的java虚拟机将使用被称为“类加载器”的子系统。
 * <p>
 * 所有的类都是在对其第一次使用的时候，动态加载到JVM中的。当程序创建第一个对类的静态成员的引用时，就会加载这个类。这个证明构造器也是类的静态方法，即使在构造器之前并没有使用static关键字。
 * <p>
 * 类加载器首先检查这个类的Class对象是否已加载。如果尚未加载，默认的类加载器就会根据类名查找.class文件。在这个类的字节码被加载时，它们会接受验证，确保其没有被破坏，并且不包含不良java代码。
 * <p>
 * forName()的调用会产生“副作用”：如果类还没有被加载就加载它。在加载的过程中，static子句被执行。注意，在传递给forName()的字符串中，你必须使用全限定名（包含包名）。
 * <p>
 * getSimpleName()不包含包名，getName()，getCanonicalName()包含包名。
 * isInterface()这个Class对象是否表示某个接口。
 * getInterfaces()返回的是Class对象，它们表示在感兴趣的Class对象中所包含的接口。
 * getSuperclass()返回其直接基类。
 * newInstance()创建新实例，会得到Object对象。使用newInstance()创建的实例的类必须有默认构造器。
 */
class Candy {

    static { print("Loading Candy"); }
}

class Gum {

    static { print("Loading Gum"); }
}

class Cookie {

    static { print("Loading Cookie"); }
}

public class SweetShop {

    public static void main(String[] args) {
        print("inside main");
        new Candy();//Class对象仅在需要的时候才被加载,static初始化实在类加载的时候进行的
        print("After creating Candy");
        try {
            //对 Class.forName()的调用为了它产生的副作用:如果类没有加载就加载它,在加载的过程中static字句被执行
            Class.forName("cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_03.class对象.Gum");
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"Gum\")");
        new Cookie();
        print("After creating Cookie");
    }
} /* Output:
inside main
Loading Candy
After creating Candy
Loading Gum
After Class.forName("Gum")
Loading Cookie
After creating Cookie
*///:~
