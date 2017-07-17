package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_06_00.protected关键字;

//: reusing/Orc.java
// The protected keyword.

import static net.mindview.util.Print.print;

/**
 * protected关键字:就类用户而言,这是private的,但对于任何继承于此类的导出类或其他任何位于同一包内的类来说,它却是可以访问的
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Villain {

    private String name;
    /**
     * 尽管可以创建protected域,但是最好的方式还是将域保持private;应当一直保留"改底层实现"的权利,然后通过protected方法来控制类的继承者的访问权限
    */
    protected void set(String nm) {

        name = nm;
    }

    public Villain(String name) {

        this.name = name;
    }

    public String toString() {

        return "I'm a Villain and my name is " + name;
    }
}

public class Orc extends Villain {

    private int orcNumber;

    public Orc(String name, int orcNumber) {

        super(name);
        this.orcNumber = orcNumber;
    }

    public void change(String name, int orcNumber) {

        set(name); // Available because it's protected
        this.orcNumber = orcNumber;
    }

    public String toString() {

        return "Orc " + orcNumber + ": " + super.toString();
    }

    public static void main(String[] args) {

        Orc orc = new Orc("Limburger", 12);
        print(orc);
        orc.change("Bob", 19);
        print(orc);
    }
} /* Output:
Orc 12: I'm a Villain and my name is Limburger
Orc 19: I'm a Villain and my name is Bob
*///:~
