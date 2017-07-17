//: enumerated/RoShamBo6.java
// Enums using "tables" instead of multiple dispatch.
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_11_00.多路分发;

/**
 * 使用二维数组
 *
 * @author fengyu
 * @date 2015年8月9日
 */
enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER, SCISSORS, ROCK;
    private static Outcome[][] table = {{Outcome.DRAW, Outcome.LOSE, Outcome.WIN}, // PAPER
            {Outcome.WIN, Outcome.DRAW, Outcome.LOSE}, // SCISSORS
            {Outcome.LOSE, Outcome.WIN, Outcome.DRAW}, // ROCK
    };
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }
} ///:~
