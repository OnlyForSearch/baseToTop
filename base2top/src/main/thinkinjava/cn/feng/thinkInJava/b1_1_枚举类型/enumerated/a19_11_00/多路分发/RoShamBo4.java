//: enumerated/RoShamBo4.java
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_11_00.多路分发;


/**
 * @author fengyu
 * @date 2015年8月9日
 */
public enum RoShamBo4 implements Competitor<RoShamBo4> {
    ROCK {
        public Outcome compete(RoShamBo4 opponent) {
            return compete(SCISSORS, opponent);
        }
    },
    SCISSORS {
        public Outcome compete(RoShamBo4 opponent) {
            return compete(PAPER, opponent);
        }
    },
    PAPER {
        public Outcome compete(RoShamBo4 opponent) {
            return compete(ROCK, opponent);
        }
    };
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return ((opponent == this) ? Outcome.DRAW : ((opponent == loser) ? Outcome.WIN : Outcome.LOSE));
    }
} /* Same output as RoShamBo2.java *///:~
