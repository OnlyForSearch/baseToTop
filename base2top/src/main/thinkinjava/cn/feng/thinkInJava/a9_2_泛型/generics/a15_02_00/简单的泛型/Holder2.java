package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_00.简单的泛型;

//: generics/Holder2.java

/**
 * 简单泛型
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Holder2 {

    private Object a;

    public Holder2(Object a) {
        this.a = a;
    }
    public static void main(String[] args) {
        Holder2 h2 = new Holder2(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not an Automobile");
        String s = (String) h2.get();
        h2.set(1); // Autoboxes to Integer
        Integer x = (Integer) h2.get();
    }
    public void set(Object a) {
        this.a = a;
    }
    public Object get() {
        return a;
    }
} // /:~
