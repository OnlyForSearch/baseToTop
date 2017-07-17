package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_04_02.名称屏蔽;

//: reusing/Hide.java
// Overloading a base-class method name in a derived
// class does not hide the base-class versions.

import static net.mindview.util.Print.print;

/**
 * 名称屏蔽
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Homer {

    /**
     * 如果Java的基类拥有的方法被多次重载过,那么在其导出类中重新定义该方法名称并不会屏蔽其在基类中的任何版本,
     * 因此,无论是在该层或者它的基类中对方法进行定义,重载机制都可以正常工作
     */
    char doh(char c) {

        print("doh(char)");
        return 'd';
    }

    float doh(float f) {

        print("doh(float)");
        return 1.0f;
    }
}

class Milhouse {}

/**
 * 在Bart 中Homer的所有重载方法都可以使用
 */
class Bart extends Homer {

    void doh(Milhouse m) {

        print("doh(Milhouse)");
    }
}

public class Hide {

    public static void main(String[] args) {
        //正常重载
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
} /* Output:
doh(float)
doh(char)
doh(float)
doh(Milhouse)
*///:~
