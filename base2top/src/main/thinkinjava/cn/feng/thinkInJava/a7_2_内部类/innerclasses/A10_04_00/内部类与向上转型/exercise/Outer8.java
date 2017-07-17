package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型.exercise;// innerclasses/Outer8.java
// TIJ4 Chapter Innerclasses, Exercise 8, page 354
/* Determine whether an outer class has access to the private elements of 
* its inner class. 
*///确定外部类是否可以访问其内部类的private元素

class Outer8 {
    //需要创建内部类对象才可以访问私有元素
    // Need to create objects to access private elements of Inner:
    int oi = new Inner().ii1;
    public static void main(String[] args) {
        Outer8 out = new Outer8();
        out.showOi();
        out.showIi2();
        out.outerHi();
    }
    void showOi() { System.out.println(oi); }
    void showIi2() { new Inner().showIi2(); }
    void outerHi() { new Inner().hi(); }

    class Inner {

        private int ii1 = 1;
        private int ii2 = 2;
        private void showIi2() { System.out.println(ii2); }
        private void hi() { System.out.println("Inner hi"); }
    }
}