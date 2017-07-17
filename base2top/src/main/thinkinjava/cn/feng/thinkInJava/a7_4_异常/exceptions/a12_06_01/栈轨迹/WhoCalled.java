package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_06_01.栈轨迹;
//: exceptions/WhoCalled.java
// Programmatic access to stack trace information.

/**
 * 栈轨迹
 * printStackTrace()方法所提供的信息可以通过getStackTrace()方法来直接访问，这个方法将返回
 * 一个由栈轨迹中的元素所构成的数组，其中每一个元素都表示栈中的一帧。元素0是栈顶元素，并且
 * 是调用序列中最后一个方法调用（这个Throwable被创建和抛出之处）。
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class WhoCalled {

    static void f() {
        // Generate an exception to fill in the stack trace
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace())//printStackTrace()方法所提供的信息可以通过getStackTrace()方法来直接访问
                System.out.println(ste.getMethodName());
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String[] args) {
        f();
        System.out.println("--------------------------------");
        g();
        System.out.println("--------------------------------");
        h();
    }
} /* Output:
f
main
--------------------------------
f
g
main
--------------------------------
f
g
h
main
*///:~
