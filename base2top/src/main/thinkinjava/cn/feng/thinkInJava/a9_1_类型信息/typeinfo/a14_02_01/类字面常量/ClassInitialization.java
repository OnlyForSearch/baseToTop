package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_01.类字面常量;
//: typeinfo/ClassInitialization.java

import java.util.Random;

/**
 * 类字面常量:另一种生成Class对象的引用的方法,Initable.class,这样更简单,而且更安全,因为它在编译期间    就会受到检查
 * 因此不需要放置于try语句块中,并且根除了对forName()方法的调用,所以更高效.
 * 可以应用与普通类,也可以应用于接口,数组,基本数据类型,另外对于基本包装类型,还有标准字段TYPE.
 * TYPE字段是一个引用指向对应的基本数据类型的Class对象boolean,比如boolean.class 等价于Boolean.TYPE
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Initable {    //如果static final的值是"编译期常量",不需要对Initable类进行初始化就可以被读取了

    static final int staticFinal = 47;
    //但是,如果只是将一个域设置为static 和 final的还不足以确保这种行为,例如staticFinal2访问将强制进行类的初始化,因为它不是一个编译期常量
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {

    //如果一个static域不是final的,那么对它访问之前,总是要求在它读取之前,要进行先进行链接(为这个域分配存储空间)和初始化(初始化该存储空间)
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {

    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

/**
 * 为了使用类而做的准备工作包含三步: 
 * 1) 加载:这是由类加载器执行的.该步骤将查找字节码(通常在clsasspath所指定的路径中查找,但这并非是必需的),并从这些字节码中创建一个Class对象 
 * 2) 链接:在链接阶段将验证类中的字节码,为静态域分配存储空间,并且如果必需的话,将解析 这个类创建的对其他类的所有引用 
 * 3) 初始化:如果该类具有超类,则对其初始化,执行静态初始化器和静态初始化块
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class ClassInitialization {

    public static Random rand = new Random(47);

    @SuppressWarnings({"unused", "rawtypes"})
    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;//仅用.class语法来获得对类的引用不会引发初始化
        System.out.println("After creating Initable ref");
        // Does not trigger initialization:
        //如果static final的值是"编译期常量",不需要对Initable类进行初始化就可以被读取了
        System.out.println(Initable.staticFinal);
        // Does trigger initialization:
        System.out.println(Initable.staticFinal2);
        // Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);
        //为了产生Class引用,Class.forName()立即就进行初始化
        Class initable3 = Class.forName("cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_01.类字面常量.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
} /* Output:
After creating Initable ref
47
Initializing Initable
258
Initializing Initable2
147
Initializing Initable3
After creating Initable3 ref
74
*///:~
