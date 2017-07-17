package cn.feng.thinkInJava.a1_2_操作符.operators.a3_04_00.赋值字段别名;
//: operators/Assignment.java
// Assignment with objects is a bit tricky.展示别名机制

import static net.mindview.util.Print.print;

class Tank {

    int level;
}

/**
 * 赋值,字段别名
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Assignment {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 47;
        print("1: t1.level: " + t1.level +
                ", t2.level: " + t2.level);
        t1 = t2;
        print("2: t1.level: " + t1.level +
                ", t2.level: " + t2.level);
        t1.level = 27;
        print("3: t1.level: " + t1.level +
                ", t2.level: " + t2.level);
    }
} /* Output:
1: t1.level: 9, t2.level: 47
2: t1.level: 47, t2.level: 47
3: t1.level: 27, t2.level: 27
*///:~
