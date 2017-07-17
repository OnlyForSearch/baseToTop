//: interfaces/InterfaceCollision.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_5_01.组合接口时的名字冲突;

interface I1 {

    void f();
}

interface I2 {

    int f(int i);
}

interface I3 {

    int f();
}

class C {

    public int f() {
        return 1;
    }
}

class C2 implements I1, I2 {

    public void f() {
    }

    public int f(int i) {
        return 1;
    } // overloaded,因为覆盖 实现和重载令人不愉快的搅在了一起,而且重载方法仅仅通过返回类型是分不开的
}

class C3 extends C implements I2 {

    public int f(int i) {
        return 1;
    } // overloaded
}

class C4 extends C implements I3 {

    // Identical, no problem:
    public int f() {
        return 1;
    }
}

// Methods differ only by return type:
// ! class C5 extends C implements I1 {}
// ! interface I4 extends I1, I3 {} ///:~
/**
 * 组合接口时的名字冲突,相同的方法不有什么问题,但是如果它们的签名或者返回类型不同,此时困难就有了
 * 因为覆盖,实现和重载令人不愉快的搅在一起,而且重载方法仅通过返回类型不同是区分不开的,
 * 所以打算组合不同的接口中使用相同的方法名通常会造成代码的可读性慌乱,要尽量避免
 * *****
 */
