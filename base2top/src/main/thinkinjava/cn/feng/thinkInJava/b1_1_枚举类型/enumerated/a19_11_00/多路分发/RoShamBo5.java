//: enumerated/RoShamBo5.java
// Multiple dispatching using an EnumMap of EnumMaps.
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_11_00.多路分发;

import java.util.EnumMap;

import static cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_11_00.多路分发.Outcome.*;

/**
 * 使用EnumMap分发
 *
 * @author fengyu
 * @date 2015年8月9日
 */
enum RoShamBo5 implements Competitor<RoShamBo5> {
    PAPER, SCISSORS, ROCK;
    static EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>> table = new EnumMap<RoShamBo5, EnumMap<RoShamBo5, Outcome>>(RoShamBo5.class);

    static {
        for (RoShamBo5 it : RoShamBo5.values())
            table.put(it, new EnumMap<RoShamBo5, Outcome>(RoShamBo5.class));
        initRow(PAPER, DRAW, LOSE, WIN);
        initRow(SCISSORS, WIN, DRAW, LOSE);
        initRow(ROCK, LOSE, WIN, DRAW);
    }

    static void initRow(RoShamBo5 it, Outcome vPAPER, Outcome vSCISSORS, Outcome vROCK) {
        EnumMap<RoShamBo5, Outcome> row = RoShamBo5.table.get(it);
        row.put(RoShamBo5.PAPER, vPAPER);
        row.put(RoShamBo5.SCISSORS, vSCISSORS);
        row.put(RoShamBo5.ROCK, vROCK);
    }
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo5.class, 20);
    }
    public Outcome compete(RoShamBo5 it) {
        return table.get(this).get(it);
    }
} /* Same output as RoShamBo2.java *///:~
