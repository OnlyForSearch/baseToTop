package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_9_01.接口与工厂;
//: interfaces/Factories.java

import static net.mindview.util.Print.print;

interface Service {

    void method1();

    void method2();
}

interface ServiceFactory {

    Service getService();
}

class Implementation1 implements Service {

    Implementation1() {} // Package access
    public void method1() {print("Implementation1 method1");}
    public void method2() {print("Implementation1 method2");}
}

class Implementation1Factory implements ServiceFactory {

    public Service getService() {
        return new Implementation1();
    }
}

class Implementation2 implements Service {

    Implementation2() {} // Package access
    public void method1() {print("Implementation2 method1");}
    public void method2() {print("Implementation2 method2");}
}

class Implementation2Factory implements ServiceFactory {

    public Service getService() {
        return new Implementation2();
    }
}

/**
 * 接口与工厂:接口是实现多重继承的途径,而生成遵循某个接口的对象典型方式就是工厂设计模式
 * <p>
 * ,通过这种方式,我们的代码将完全与接口的实现分离,这使得我们可以透明的将一个实现替换为另一个实现
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class A9_9_01_Factories {

    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        // Implementations are completely interchangeable:
        serviceConsumer(new Implementation2Factory());
    }
} /* Output:
Implementation1 method1
Implementation1 method2
Implementation2 method1
Implementation2 method2
*///:~
