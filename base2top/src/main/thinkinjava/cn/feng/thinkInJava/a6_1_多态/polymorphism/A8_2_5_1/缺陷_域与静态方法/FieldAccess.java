package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_2_5_1.缺陷_域与静态方法;

//: polymorphism/FieldAccess.java
// Direct field access is determined at compile time.
//任何域访问操作都在编译期进行解析，因此不是多态的(如果通常将所有域设置成为private；将基类和导出类的域赋予不同名称。这种混淆是可以避免的)。如果某个方法是静态的，它的行为就不具有多态性。
class Super {

    //public int field = 0;
    public int field = 3;

    public int getField() {
        return field;
    }
}

class Sub extends Super {

    public int field = 1;

    public int getField() {
        return field;
    }

    public int getSuperField() {
        // 为了得到Super.field因此必须显式指明super.field
        return super.field;
    }
}

/**
 * 只有普通方法调用才可以是多态的 缺陷:域与静态方法
 *
 * @author Administrator
 */
public class FieldAccess {

    public static void main(String[] args) {
        // Sub对象向上转型为Super引用时候,任何域访问操作都将由编译器解析,因此也不是多态的
        Super sup = new Sub(); // Upcast
        System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field + ", sub.getField() = " + sub.getField() + ", sub.getSuperField() = " + sub.getSuperField());
    }
} /*
 * Output: sup.field = 0, sup.getField() = 1 sub.field = 1, sub.getField() = 1,
 * sub.getSuperField() = 0
 */// :~
