package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.exercise;// innerclasses/Outer7.java
// TIJ4 Chapter Innerclasses, Exercise 7, page 354
/* Create a class with a private field and a private method. Create an
* inner class with a method that modifies the outer-class field and calls
* the outer class method. In a second outer-class method, create an object
* of the inner class and call its method, then show the effect on the
* outer-class object. 
*//**
 * 创建一个包含private和private方法的类,创建一个内部类,他有一个方法可用来
 *
 * 修改外围类的域,并调用外围类的方法,在外围类的另一个方法中,创建此内部类的对象
 * ,并且调用它的方法,然后说明对外围类对象的影响
 * */

class Outer7 {

    private int oi = 1;
    public static void main(String[] args) {
        Outer7 out = new Outer7();
        out.showOi();
        out.testInner();
        out.showOi();
    }
    private void hi() { System.out.println("Outer hi"); }
    public void showOi() { System.out.println(oi); }
    void testInner() {
        Inner in = new Inner();
        in.modifyOuter();
    }

    class Inner {

        void modifyOuter() {
            oi *= 2;
            hi();
        }
    }
}