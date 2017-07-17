package cn.feng.thinkInJava.a9_1_类型信息;

import cn.feng.utils.Print;
import org.junit.Test;

import static net.mindview.util.Print.print;

public class Class对象 {

    /**
     * Class对象 Class类的实例表示正在运行的 Java 应用程序中的类和接口
     * 当class被加载的时候,由JVM自动创建Class对象,或通过类加载器的defineClass方法生成. 
     * 对象可以通过object的getClass方法得到Class对象 而Class的众多方法又为反射机制提供了实现   获取Class实例的三种方式 
     * 1）利用对象调用getClass()方法获取该对象的Class实例。 
     * 2）使用Class类的静态方法forName()，用类的名字获取一个Class实例。 
     * 3）运用.class的方式来获取Class实例，对于基本数据类型的封装类，还可以采用.TYPE来获取相对应的基本数据类型的Class实例。 
     * 第三种方法不做初始化    为了使用类而做的准备工作包含三步: 
     * 1) 加载:这是由类加载器执行的.该步骤将查找字节码(通常在clsasspath所指定的路径中
     * 查找,但这并非是必需的),并从这些字节码中创建一个Class对象 
     * 2) 链接:在链接阶段将验证类中的字节码,为静态域分配存储空间,并且如果必需的话,将解析 这个类创建的对其他类的所有引用 
     * 3) 初始化:如果该类具有超类,则对其初始化,执行静态初始化器和静态初始化块
     */
    public static void main(String args[]) {

    }
    public static void printInfo(Class calzz) {
        // calzz.getName()全限定名(包含包名)
        print("Class name: " + calzz.getName() + " is interface? [" + calzz.isInterface() + "]");
        // calzz.getSimpleName()不包含包名
        print("Simple name: " + calzz.getSimpleName());
        // 全限定名(包含包名)
        print("Canonical name : " + calzz.getCanonicalName());
    }
    /*
     * 1.加载，这是由类加载器执行的。改步骤将查找字节码，并从字节码中创建一个Class对象。
     *
     * 2.链接。在链接阶段将验证类中的字节码，为静态域分配存储空间，并且如果必需的话，将解析这个类创建的对其他类的所有引用。
     *
     * 3.初始化。如果该类具有超类，则对其初始化，执行静态初始化器和静态初始化块。
     */
    @Test
    public void refect() {
        Print.println("main start");
        //  加载类的同时加载static的内容
        new Class1();
        //  使用.class方式取得class对象时,只做加载和链接,不会做初始化 
        // Class<Class1>
        // class1=Class1.class;这样是不行的,Class1的Class类不是Object的Class类的子类
        Class<Class1> class1 = Class1.class;
        printInfo(class1);
        try {
            // class1只是一个Class的引用,在编译期不具备任何更进一步的类型信息
            // newInstance()方法是实现"虚拟构造器"的一种途径;虚拟构造器允许你声明:我不知道你的确切类型,当时无论如何要正确的创建你自己
            // 使用newInstance()来创建的类,必须带有默认的构造器
            Class1 newInstance = class1.newInstance();

            // Class.forName("Class2");//方法找不到要加载的类就会抛出ClassNotFoundException
            //  使用包名+类名  三步都做:加载,链接,初始化  使用 Class.forName()方法要使用全限定名(包含包名)
            Class<?> class2 = Class.forName("cn.feng.test.类型信息.Class2");
        } catch (Exception e) {
            System.out.println("类不存在");
            System.exit(1);
        }
        new Class3();
        Print.println("main end");
    }
    // 泛化的Class引用
    @Test
    public void genericClassReference() throws InstantiationException, IllegalAccessException {
        // Class引用总是指向某个Class对象,它可以制造类的实例,并包含可作用于这些实例的所有方法代码.
        // 它还包含该类的静态成员,因此,Class引用表示的就是它所指向的对象的确切类型,而该对象便是Class类的一个对象
        // 使用?来表示 任务事物 
        // Class<? extends Object> i = Integer.class; 
        // ?可以理解为通配符  Class<?> 表示任何类  
        //  Class<? extends T>表示T的子类 Class<? super T>表示T的超类

        Class intClasss = int.class;
        // 向Class添加泛型语法的原因仅仅只是为了提供编译期检查,将泛型语法用语Class对象时,会发生一件很有趣的事情,newInstance()方法
        // 会返回该对象的具体类型
        Class<Integer> integerClasss = Integer.class;
        Integer integer = integerClasss.newInstance();
        //
        Class<? super Integer> superclass = integerClasss.getSuperclass();
        print(superclass.getCanonicalName());
    }

}

// 当main方法中执行注释或者输出语句时都会执行类P中的静态域和静态块里面的语句。
// 如果一个static域不是final的，那么在对它访问时，总是要求在它被读取之前，要先进行链接（为这个域分配存储空间）和初始化（初始化存储空间）。
class Class1 {

    static int a = 47;

    static {
        Print.println("loading Class1");
    }
}

class Class2 {

    // 可是为什么没有输出静态块里面的内容呢（Initializing
    // Initable）？，这是因为静态域staticFinal是final的，如果一个静态域是final的，那么这个值就是“编译器常量”，
    // 就像Initable.staticFinal那样，那么这个值不需要对Initable类进行初始化就可以读取。但是，如果只是将一个域设置为static和final的，还不足以确保这种行为。
    static final int staticFinal = 47;

    static {
        Print.println("loading Class2");
    }
}

class Class3 {

    static {
        Print.println("loading Class3");
    }
}
