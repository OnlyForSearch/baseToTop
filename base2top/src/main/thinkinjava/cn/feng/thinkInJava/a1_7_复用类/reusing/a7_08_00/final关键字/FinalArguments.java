package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_08_00.final关键字;
//: reusing/FinalArguments.java

// Using "final" with method arguments.

/**
 * final 参数 :java允许在参数列表中以声明的方式将参数指定为final,这就意味着无法在方法中更改参数引用所指向的对象,
 * 你可以读取参数,但是却无法修改参数,这一特性主要用来向匿名内部类传递数据
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Gizmo {

    public void spin() {
    }
}

public class FinalArguments {

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
    void with(final Gizmo g) {
        // ! g = new Gizmo(); // Illegal -- g is final
    }
    void without(Gizmo g) {
        g = new Gizmo(); // OK -- g not final
        g.spin();
    }
    // void f(final int i) { i++; } // Can't change
    // You can only read from a final primitive:
    int g(final int i) {
        return i + 1;
    }
} /// :~
