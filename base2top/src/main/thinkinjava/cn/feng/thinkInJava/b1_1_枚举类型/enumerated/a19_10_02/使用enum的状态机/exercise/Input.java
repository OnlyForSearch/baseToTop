//: enumerated/Input.java
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_10_02.使用enum的状态机.exercise;

import java.util.Random;

/**
 * 使用enum的状态机,一个状态机可以具有有限个特定的状态,它根据输入,从一个状态转移到下一个状态,不过也可能存在瞬时状态(transient states)
 * ,而一旦任务执行结束,状态机就会立刻离开瞬时状态.
 * 每个状态都具有某些可接受的输入,不同的输入会使状态机从当前的状态转移到不同的新状态,由于enum对其实例有严格限制,
 * 非常适合来表现不同的状态和输入,一般而言,每个状态都具有一些相关的输出
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount() { // Disallow
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP { // This must be the last instance.
        public int amount() { // Disallow
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };
    // In cents
    static Random rand = new Random(47);
    int value; // In cents
    Input(int value) { this.value = value; }
    Input() {}
    public static Input randomSelection() {
        // Don't include STOP:
        return values()[rand.nextInt(values().length - 1)];
    }
    int amount() { return value; }
} ///:~
