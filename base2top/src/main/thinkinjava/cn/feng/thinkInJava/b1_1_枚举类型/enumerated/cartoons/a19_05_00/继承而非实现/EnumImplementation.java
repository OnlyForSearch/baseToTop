//: enumerated/cartoons/EnumImplementation.java
// An enum can implement an interface
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.cartoons.a19_05_00.继承而非实现;

import net.mindview.util.Generator;

import java.util.Random;

/**
 * 实现而非继承
 * 所有的enum都继承自java.lang.Enum类,由于将java不支持多重继承,所以enum不能再继承其他类
 * 但是可以同时实现一个或多个接口
 *
 * @author fengyu
 * @date 2015年8月9日
 */
enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);

    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {

    public static <T> void printNext(Generator<T> rg) {
        System.out.print(rg.next() + ", ");
    }

    public static void main(String[] args) {
        // Choose any instance:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++)
            printNext(cc);
    }
} /*
 * Output: BOB, PUNCHY, BOB, SPANKY, NUTTY, PUNCHY, SLAPPY, NUTTY, NUTTY,
 * SLAPPY,
 */// :~
