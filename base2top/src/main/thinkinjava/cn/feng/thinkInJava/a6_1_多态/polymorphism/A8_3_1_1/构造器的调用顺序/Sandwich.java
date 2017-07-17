//: polymorphism/Sandwich.java
// Order of constructor calls.
package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_3_1_1.构造器的调用顺序;
import static net.mindview.util.Print.print;
class Meal {
    /**
     * 只有基类的构造器才具有 合适的知识和权限来对自己的元素进行初始化
     */
    Meal() {
        print("Meal()");
    }
}
class Bread {
    Bread() {
        print("Bread()");
    }
}
class Cheese {

    Cheese() {
        print("Cheese()");
    }
}

class Lettuce {

    Lettuce() {
        print("Lettuce()");
    }
}

class Lunch extends Meal {

    Lunch() {
        print("Lunch()");
    }
}

class PortableLunch extends Lunch {

    PortableLunch() {
        print("PortableLunch()");
    }
}

/**
 * 基类的构造器总是在导出类的构造过程中被调用,而且按照继承层次逐渐向上链接,以使每个基类的构造器都被调用,构造器的的一个特殊任务是:检查对象是否被正确调用.
 *
 * @author Administrator
 */
@SuppressWarnings("unused")
public class Sandwich extends PortableLunch {

    //三个成员对象
    private Bread b = new Bread();

    private Cheese c = new Cheese();

    private Lettuce l = new Lettuce();
    /**
     * 导出类只能访问它自己的成员,不能访问基类中的成员(基类成员通常是private类型)
     */
    private Sandwich() {
        print("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();


    }
} /*
 * Output: Meal() Lunch() PortableLunch() Bread() Cheese() Lettuce() Sandwich()
 */// :~
