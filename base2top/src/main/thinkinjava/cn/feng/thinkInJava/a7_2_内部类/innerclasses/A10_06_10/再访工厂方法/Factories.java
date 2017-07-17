package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_10.再访工厂方法;

//: innerclasses/Factories.java

import static net.mindview.util.Print.print;

interface Service {

    void method1();

    void method2();
}

interface ServiceFactory {

    Service getService();
}

class Implementation1 implements Service {

    // 用匿名时候,可以把构造器都是private的
    private Implementation1() {
    }

    public void method1() {
        print("Implementation1 method1");
    }

    public void method2() {
        print("Implementation1 method2");
    }

    // 只需要单一的工厂对象,所以被创建的实例是一个static
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new Implementation1();
        }
    };
}

class Implementation2 implements Service {

    // 用匿名时候,可以把构造器都是private的
    private Implementation2() {
    }

    public void method1() {
        print("Implementation2 method1");
    }

    public void method2() {
        print("Implementation2 method2");
    }

    // 只需要单一的工厂对象,所以被创建的实例是一个static
    public static ServiceFactory factory = new ServiceFactory() {
        public Service getService() {
            return new Implementation2();
        }
    };
}

/**
 * 使用匿名内部类实现工厂方法
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class Factories {

    public static void serviceConsumer(ServiceFactory fact) {
        Service s = fact.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        // Implementations are completely interchangeable:
        serviceConsumer(Implementation2.factory);
    }
} /*
 * Output: Implementation1 method1 Implementation1 method2 Implementation2
 * method1 Implementation2 method2
 */// :~
