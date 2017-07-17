package cn.feng.thinkInJava.模式.工厂方法设计模式.用匿名内部类;

import static cn.feng.utils.Print.println;

/**
 * 使用匿名内部类实现的工厂
 */
public class Factories {

    public static void serviceConsumer(ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String args[]) {
        serviceConsumer(ServiceImplA.serviceFactory);
        serviceConsumer(ServiceImplB.serviceFactory);
    }
}

interface Service {

    void method1();

    void method2();

}

interface ServiceFactory {

    Service getService();
}

class ServiceImplA implements Service {

    /**
     * 构造器可以是private，并且没有任何必有创建作为工厂的具名类
     */
    private ServiceImplA() {
        super();
    }

    @Override
    public void method1() {
        println("ServiceImplA method1");
    }

    @Override
    public void method2() {
        println("ServiceImplA method2");

    }
    //使用static域
    public static ServiceFactory serviceFactory = new ServiceFactory() {

        @Override
        public Service getService() {
            return new ServiceImplA();
        }
    };

}

class ServiceImplB implements Service {

    /**
     * 构造器可以是private，并且没有任何必有创建作为工厂的具名类
     */
    private ServiceImplB() {
        super();
    }

    @Override
    public void method1() {
        println("ServiceImplB method1");
    }

    @Override
    public void method2() {
        println("ServiceImplB method2");

    }
    //使用static域
    public static ServiceFactory serviceFactory = new ServiceFactory() {

        @Override
        public Service getService() {
            return new ServiceImplB();
        }
    };

}