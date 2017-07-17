package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_05_00.方法与作用域内的内部类.exercise;// innerclasses/Ex9.java
// TIJ4 Chapter Innerclasses, Exercise 9, page 356
/* Create an interface with at least one method, and implement that
* interface by defining an inner class within a method, which returns a
* reference to your interface.
*/
/**
 * 创建一个至少有一个方法的接口,在某个方法内定义一个内部类以实现此接口,
 * 这个方法返回此接口的引用
 * */
interface Ex9Interface {

    void say(String s);
}

public class Ex9 {

    public static void main(String[] args) {
        Ex9 x = new Ex9();
        x.f().say("hi");
    }
    Ex9Interface f() {
        class Inner implements Ex9Interface {

            public void say(String s) {
                System.out.println(s);
            }
        }
        return new Inner();
    }
}