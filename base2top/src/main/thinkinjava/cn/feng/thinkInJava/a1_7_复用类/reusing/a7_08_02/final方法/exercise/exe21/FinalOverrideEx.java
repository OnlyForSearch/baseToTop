package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_08_02.final方法.exercise.exe21;// reusing/FinalOverrideEx.java
// TIJ4 Chapter Reusing, Exercise 21, page 269
/* Create a class with a final method. Inherit from that class and attempt to 
* override that method.
*/
//创建一个带final的方法的类,由此继承产生并尝试覆盖此方法

import static net.mindview.util.Print.print;

class WithFinal {

    final void f() { print("WithFinal.f()"); }
    void g() { print("WithFinal.g()"); }
    final void h() { print("WitFinal.h()"); }
}

class OverrideFinal extends WithFinal {

    // attempt to override://final方法不能被覆盖,但是子类还是可以从父类继承过来,仍可以调用
    // public final void f() { print("OverrideFinal.f()"); } // no can do
    @Override
    public void g() { print("OverrideFinal.g()"); } // OK, not final
    // final void h(); { print("OVerrideFinal.h()"); } // cannot override final
}

public class FinalOverrideEx {

    public static void main(String[] args) {
        OverrideFinal of = new OverrideFinal();
        of.f();
        of.g();
        of.h();
        // Upcast:
        WithFinal wf = of;
        wf.f();
        wf.g();
        wf.h();
    }
}
