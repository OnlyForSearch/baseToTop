package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_2_5_2_.静态方法不具有多态性;

//: polymorphism/StaticPolymorphism.java
// Static methods are not polymorphic.

class StaticSuper {

    /**
     * 静态方法是静态的,它的行为就不具有多态,静态方法是与类,而非单个的对象相关联的
     *
     * @return
     */
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {

    public static String staticGet() {
        return "Derived staticGet()";
    }

    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism {

    public static void main(String[] args) {
        StaticSuper sup = new StaticSub(); // Upcast
        System.out.println(StaticSuper.staticGet());
        System.out.println(sup.dynamicGet());
        System.out.println(sup.staticGet());
    }
} /*
 * Output: Base staticGet() Derived dynamicGet()
 */// :~
