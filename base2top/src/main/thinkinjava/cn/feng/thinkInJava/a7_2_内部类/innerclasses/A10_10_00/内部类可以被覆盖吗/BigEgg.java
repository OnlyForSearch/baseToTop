package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_10_00.内部类可以被覆盖吗;
//: innerclasses/BigEgg.java
// An inner class cannot be overriden like a method.

import static net.mindview.util.Print.print;

class Egg {

    private Yolk y;

    public Egg() {
        print("New Egg()");
        y = new Yolk();
    }

    protected class Yolk {

        public Yolk() { print("Egg.Yolk()"); }
    }
}

/**继承外部类，像重写方法一样重写内部类并不起作用，此时两个内部类只是两个独立的实体。
 * 覆盖内部类就好像覆盖他是外围类的一个方法,其实并不起什么作用
 * ,内部类不存在覆盖
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class BigEgg extends Egg {

    public static void main(String[] args) {
        new BigEgg();
    }

    public class Yolk {

        public Yolk() { print("BigEgg.Yolk()"); }
    }
} /* Output:
New Egg()
Egg.Yolk()
*///:~
