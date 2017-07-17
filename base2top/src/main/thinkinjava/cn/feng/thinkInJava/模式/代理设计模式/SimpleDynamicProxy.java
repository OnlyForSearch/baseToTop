package cn.feng.thinkInJava.模式.代理设计模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null)
            for (Object arg : args)
                System.out.println("  " + arg);

        //使用Method.invoke()将请求转发给代理对象,并必须传入必须的参数
        return method.invoke(proxied, args);
    }
}

/**
 * 动态代理
 */
class SimpleDynamicProxy {

    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        // Proxy.newProxyInstance()可以创建动态代理,方法需要可以得到一个类加载器,一个希望代理的接口列表(不是类或者抽象类),
        Interface proxy = (Interface) Proxy.newProxyInstance(
                // 类加载器
                Interface.class.getClassLoader(),
                //希望代理的接口列表
                new Class[]{Interface.class},

                // InvocationHandler的实现接口
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
} /*
 * Output: (95% match) doSomething somethingElse bonobo*** proxy: class $Proxy0,
 * method: public abstract void Interface.doSomething(), args: null doSomething
 * *** proxy: class $Proxy0, method: public abstract void
 * Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
 * bonobo somethingElse bonobo
 */// :~
