package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_02_00.继承语法;

//: reusing/Detergent.java
// Inheritance syntax & properties.继承语法

import static net.mindview.util.Print.print;

/**
 * 继承语法:当创建一个类时候总是在继承,除非已明确指出要从其他类中继承,否则就是
 * 在隐式的继承java的标准根类Object进行继承
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Cleanser {

    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        print(x);
    }
}
//extends表明"新类与旧类相似",会自动得到父类中所有的域和方法
public class Detergent extends Cleanser {

    // Change a method:
    public void scrub() {
        append(" Detergent.scrub()");
        //java用super关键字表示超类的意思,,当前类就是从基类继承过来的
        //super.scrub()就表示从将调用基类版本的scrub()方法
        super.scrub(); // Call base-class version//
    }
    // Add methods to the interface:
    public void foam() { append(" foam()"); }
    // Test the new class:
    public static void main(String[] args) {

        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);
    }
} /* Output:
Cleanser dilute() apply() Detergent.scrub() scrub() foam()
Testing base class:
Cleanser dilute() apply() scrub()
*///:~