package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_07_00.动态代理;

//: typeinfo/SimpleProxyDemo.java

import static net.mindview.util.Print.print;

/**
 * 代理的普通结构
 *
 * @author fengyu
 * @date 2015年8月9日
 */
interface Interface {

    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {

    public void doSomething() {
        print("doSomething");
    }

    public void somethingElse(String arg) {
        print("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface {

    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        print("SimpleProxy doSomething");
        proxied.doSomething();
    }

    public void somethingElse(String arg) {
        print("SimpleProxy somethingElse " + arg);
        proxied.somethingElse(arg);
    }
}

/**
 * @author fengyu
 * @date 2015年8月9日
 */
class SimpleProxyDemo {

    /**
     * 接受Interface,所以它无法知道正在获取的到底是RealObject还是SimpleProxy
     * 因为这二者都实现了Interface接口,,但是SimpleProxy已经被插入到客户端和RealObject之间,因此它会执行操作,然后调用RealObject上相同的方法
     *
     * @param iface
     * @author fengyu
     * @date 2015年8月12日
     */
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
} /* Output:
doSomething
somethingElse bonobo
SimpleProxy doSomething
doSomething
SimpleProxy somethingElse bonobo
somethingElse bonobo
*///:~
