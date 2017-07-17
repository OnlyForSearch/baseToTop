package cn.feng.thinkInJava.a6_1_多态.polymorphism.test;

import static net.mindview.util.Print.print;

public class PrivateOverride {

    public static void main(String[] args) {
        PrivateOverride privateOverride = new Dervied();
        privateOverride.f();

    }
    private void f() {
        print("private f()");
    }
}

class Dervied extends PrivateOverride {

    public void f() {
        print("public f()");
    }
}

