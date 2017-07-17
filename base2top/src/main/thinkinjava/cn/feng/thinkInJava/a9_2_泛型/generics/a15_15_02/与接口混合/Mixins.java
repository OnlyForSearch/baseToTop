package cn.feng.thinkInJava.a9_2_泛型.generics.a15_15_02.与接口混合;
//: generics/Mixins.java

import java.util.Date;

/**
 * 混型:与接口的混合
 *混型最基本的概念是混合多个类的能力，以产生一个可以表示混型中所有类型的类。混型的价值之一是它们可以将特性和行为一致地应用于多个类之上。C++有多重继承机制，模板，可以方便地实现混型。

 与接口混合
 Java中推荐解决方案是使用接口产生混型效果。基本上使用代理。
 使用装饰器模式
 装饰器是通过使用组合和形式化结构来实现的，而混型是基于继承的。其明显缺陷是它只能有效地工作于装饰中的一层（最后一层），只是一种局限的解决方案。
 与动态代理混合
 更接近真正的混型

 * @author fengyu
 * @date 2015年8月9日
 */
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

class TimeStampedImp implements TimeStamped {

    private final long timeStamp;
    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }
    public long getStamp() { return timeStamp; }
}

class SerialNumberedImp implements SerialNumbered {

    private static long counter = 1;
    private final long serialNumber = counter++;
    public long getSerialNumber() { return serialNumber; }
}

class BasicImp implements Basic {

    private String value;
    public void set(String val) { value = val; }
    public String get() { return value; }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {

    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    public long getStamp() { return timeStamp.getStamp(); }
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }
}

public class Mixins {

    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " +
                mixin1.getStamp() + " " + mixin1.getSerialNumber());
        System.out.println(mixin2.get() + " " +
                mixin2.getStamp() + " " + mixin2.getSerialNumber());
    }
} /* Output: (Sample)
test string 1 1132437151359 1
test string 2 1132437151359 2
*///:~
