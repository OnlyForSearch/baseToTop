package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_02.C的方式;
//: generics/Manipulator3.java
/**很容易地执行擦除,就可以创建出没有泛型的类*/
class Manipulator3 {

    private HasF obj;
    public Manipulator3(HasF x) { obj = x; }
    public void manipulate() { obj.f(); }
} ///:~
