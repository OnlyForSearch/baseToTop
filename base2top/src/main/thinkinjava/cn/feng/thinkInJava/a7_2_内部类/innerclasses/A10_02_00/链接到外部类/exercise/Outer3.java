package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_02_00.链接到外部类.exercise;// innerclasses/Outer3.java
// TIJ4 Chapter Innerclasses, Exercise 3, page 350
/* Modify Exercise 1 so that Outer has a private String field (initialized
* by the constructor), and Inner has a toString() that displays this field.
* Create an object of type Inner and display it.
*/
//使用的Outer类包含一个private String 域(由构造器初始化),而Inner包含一个显示
// 这个域的toString()方法,创建一个Inner类型对象并显示它

public class Outer3 {

    private String s;

    Outer3(String s) {
        System.out.println("Outer1()");
        this.s = s;
    }
    public static void main(String[] args) {
        Outer3 o = new Outer3("Hi is risen!");
        Inner3 i = o.makeInner3();
        System.out.println(i.toString());
    }
    Inner3 makeInner3() {
        return new Inner3();
    }

    class Inner3 {

        Inner3() { System.out.println("Inner()"); }
        public String toString() { return s; }
    }
}