//: net/mindview/util/Enums.java
package net.mindview.util;

import java.util.Random;

/**
 * 随机选取
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Enums {

    private static Random rand = new Random(47);
    /**
     * 利用泛型,从而使工作更一般化
     * <T extends Enum<T>> 表示T是一个Enum,而将Class<T>作为参数的话,我们就可以利用CLass对象得到enum实例的数组l
     */
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }
    /**
     * 只需要使用T[]作为参数,因为它并不会调用Enum上的任何参数,它只需从数组中随机选择一个元素即可,这样最终的返回类型正是enum类型
     */
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
} ///:~
