package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_06_00.随机抽取;
//: enumerated/RandomTest.java

import net.mindview.util.Enums;

enum Activity {
    SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, JUMPING, FALLING, FLYING
}

/**
 * 随机选取测试
 *工具类net.mindview.util.Enums可以实现enum实例的随机选择。
 * @author fengyu
 * @date 2015年8月9日
 * enum只是一个相当短小的类,可以消除很多重复的代码,重复总会制造麻烦,因此消除重复总是有用处的
 */
public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            System.out.print(Enums.random(Activity.class) + " ");
    }
} /* Output:
STANDING FLYING RUNNING STANDING RUNNING STANDING LYING DODGING SITTING RUNNING HOPPING HOPPING HOPPING RUNNING STANDING LYING FALLING RUNNING FLYING LYING
*///:~
