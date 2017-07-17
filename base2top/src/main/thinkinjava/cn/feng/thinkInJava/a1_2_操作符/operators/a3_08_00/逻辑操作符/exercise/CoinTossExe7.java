package cn.feng.thinkInJava.a1_2_操作符.operators.a3_08_00.逻辑操作符.exercise;

import java.util.Random;

/**
 * 模拟扔硬币的结果
 * Created by fengyu on 2015-09-29.
 */
public class CoinTossExe7 {
    
    public static void main(String args[]) {
        Random random = new Random();
        int rand = random.nextInt();
        if (rand % 2 == 0) {
            System.out.println("正面");
        } else {
            System.out.println("反面");
        }

    }
}
