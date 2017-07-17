package cn.feng.thinkInJava.a1_6_访问权限控制.access.a6_02_02;
//: access/Cake.java
// Accesses a class in a separate compilation unit.

class Cake {

    public static void main(String[] args) {
        Pie x = new Pie();
        x.f();
    }
} /* Output:
Pie.f()
*///:~
