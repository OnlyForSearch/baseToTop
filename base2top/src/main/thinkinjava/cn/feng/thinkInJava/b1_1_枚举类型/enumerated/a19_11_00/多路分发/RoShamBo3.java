//: enumerated/RoShamBo3.java
// Using constant-specific methods.
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_11_00.多路分发;

import static cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_11_00.多路分发.Outcome.*;

/**
 * 使用常量相关的方法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public enum RoShamBo3 implements Competitor<RoShamBo3> {
    PAPER {
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default: // To placate the compiler
                case PAPER:
                    return DRAW;
                case SCISSORS:
                    return LOSE;
                case ROCK:
                    return WIN;
            }
        }
    },
    SCISSORS {
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return WIN;
                case SCISSORS:
                    return DRAW;
                case ROCK:
                    return LOSE;
            }
        }
    },
    ROCK {
        public Outcome compete(RoShamBo3 it) {
            switch (it) {
                default:
                case PAPER:
                    return LOSE;
                case SCISSORS:
                    return WIN;
                case ROCK:
                    return DRAW;
            }
        }
    };
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo3.class, 20);
    }
    public abstract Outcome compete(RoShamBo3 it);
} /* Same output as RoShamBo2.java *///:~
