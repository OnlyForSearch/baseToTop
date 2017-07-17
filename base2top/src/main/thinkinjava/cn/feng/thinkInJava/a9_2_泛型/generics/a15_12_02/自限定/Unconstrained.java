package cn.feng.thinkInJava.a9_2_泛型.generics.a15_12_02.自限定;

//: generics/Unconstrained.java
class Other {}

class BasicOther extends BasicHolder<Other> {}

/**
 * 自限定
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Unconstrained {

    public static void main(String[] args) {
        BasicOther b = new BasicOther(), b2 = new BasicOther();
        b.set(new Other());
        Other other = b.get();
        b.f();
    }
} /*
 * Output: Other
 */// :~
