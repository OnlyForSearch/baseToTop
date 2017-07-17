package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_05_00.方法与作用域内的内部类.exercise;// innerclasses/Ex11.java
// TIJ4 Chapter Innerclasses, Exercise 11, page 356
/* Create a private inner class that implements a public interface.
* Write a method that returns a reference to an instance of the private
* inner class, upcast to the interface. Show that the inner class is 
* completely hidden by trying to downcast to it.
*/
/**
 * 创建一个private内部类,然他实现一个public接口,写一个方法,他返回一个指向此
 * private内部类的实例引用,并将此引用向上转型为该接口类型,通过尝试向下转型
 * 说明此内部类被完全隐藏了
 * */
/* public interface Ex11Interface {
*	void say(String s); 
* }
*/

interface Ex11Interface {

    void say(String s);
}

class Test {

    Ex11Interface f() {
        return new Inner();
    }

    private class Inner implements Ex11Interface {

        public void say(String s) {
            System.out.println(s);
        }
    }
}

public class Ex11 {

    public static void main(String[] args) {
        Test t = new Test();
        t.f().say("hi");
        // Error: cannot find symbol: class Inner:
        // ((Inner)t.f()).say("hello");
    }
}