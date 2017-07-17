package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_02.C的方式;
//: generics/Manipulator2.java
//<T extends HasF>声明T必须具有类型HasF或者从HashF导出的类型,如果情况确实是这样子的
// 话那么就可以安全的在obj上调用f()方法了

/**
 * 我们说泛型类型参数将擦除到它的第一个边界(他可能会有多个边界),就好像T擦除到了HashF,
 * 就好像在类的声明中用HashF替换了T一样
 */
class Manipulator2<T extends HasF> {

    private T obj;
    public Manipulator2(T x) { obj = x; }
    public void manipulate() { obj.f(); }
} ///:~
