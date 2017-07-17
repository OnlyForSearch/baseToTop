package cn.feng.thinkInJava.a9_2_泛型.generics.a15_15_04.与动态代理混合.exercise;// generics/DynamicProxyMixin39.java
// TIJ4 Chapter Generics, Exercise 39, page 721
// Add a new mixin class Colored to DynamicProxyMixin.java, mix it into mixin and 
// show that it works.
//向 DynamicProxyMixin.java,添加一个新的混型类Colored,将其混入minxin并展示它可以工作

import net.mindview.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Tuple.tuple;

interface TimeStamped {

    long getStamp();
}

interface SerialNumbered {

    long getSerialNumber();
}

interface Basic {

    void set(String val);

    String get();
}

class MixinProxy implements InvocationHandler {

    Map<String, Object> delegatesByMethod;
    public MixinProxy(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<String, Object>();
        for (TwoTuple<Object, Class<?>> pair : pairs) {
            for (Method method : pair.second.getMethods()) {
                String methodName = method.getName();
                // The first interface in the map
                // implements the method.
                if (!delegatesByMethod.containsKey(methodName))
                    delegatesByMethod.put(methodName, pair.first);
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }
}

public class DynamicProxyMixin39 {

    public static void main(String[] args) {
        Object mixin = MixinProxy.newInstance(tuple(new BasicImp(), Basic.class), tuple(new TimeStampedImp(), TimeStamped.class), tuple(new SerialNumberedImp(), SerialNumbered
                        .class)
                //	,tuple(new Colored(), Color.class)
        );
        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        b.set("Hello");
        //Color c = (Color)mixin;
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());
        //System.out.println(c.getColor());
    }
}

class TimeStampedImp implements TimeStamped {

    private final long timeStamp;

    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumberedImp implements SerialNumbered {

    private static long counter = 1;
    private final long serialNumber = counter++;

    public long getSerialNumber() {
        return serialNumber;
    }
}

class BasicImp implements Basic {

    private String value;

    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {

    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();

    public long getStamp() {
        return timeStamp.getStamp();
    }

    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}
