package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_07_00.动态代理;

//: typeinfo/SimpleDynamicProxy.java

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理可以将所有的调用从定向到调用处理器,因此通常会向调用处理器的构造器传递一个"实际对象"得引用,从而使
 * 调用处理器在执行其中介任务,可以将请求转发
 *
 * @author fengyu
 * @date 2015年8月12日
 */
class DynamicProxyHandler implements InvocationHandler {

    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    /**
     * invoke方法中传递来了代理对象,以防止你需要区分请求的来源,但是在多种情况下
     * ,你并不关心这一点,然而在invoke内部,在代理调用
     * 方法时需要格外的小心,因为对接口 的调用将被从定向到对代理的调用
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if (args != null)
            for (Object arg : args)
                System.out.println("  " + arg);
        //通常执行被代理操作,然后使用Method.invoke()将请求转发给被代理对象,并传入必须的参数,可以传递其他参数,来过滤某些方法的调用
        return method.invoke(proxied, args);
    }
}

/**
 * 动态代理
 *
 * @author fengyu
 * @date 2015年8月12日
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
        //可以创建动态代理,这个方法需要得到一个类加载器(从已加载的对象中获取其类加载器然后传递给它),
        // 一个希望该代理实现的接口列表(不是类或抽象类),以及一个InvocationHandler接口的实现
        /** Proxy.newProxyInstance()可以创建动态代理,这个方法需要
         * 1,一个类加载器,通常可以从已经加载的对象中获取其类加载器,然后传递给它(Interface.class.getClassLoader())
         * 2一个希望该代理实现的接口列表(不是类或抽象类)( new Class[]{Interface.class)
         * 3以及一个InvocationHandler接口的一个实现(new DynamicProxyHandler(real))
         *
         * 动态代理可以将所有调用重定向到调用处理器,因此通常会向调用处理器的构造器传递一个"实际对象"的引用
         * ,从而使得调用处理器在执行其中任务时,可以将请求转发
         * */
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class}, new DynamicProxyHandler(real));
        consumer(proxy);
    }
} /* Output: (95% match)	
doSomething
somethingElse bonobo
**** proxy: class $Proxy0, method: public abstract void Interface.doSomething(), args: null
doSomething
**** proxy: class $Proxy0, method: public abstract void Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@42e816
  bonobo
somethingElse bonobo
*///:~
