package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_6_00.适配接口;
//: interfaces/RandomDoubles.java

import java.util.Random;

/**
 * 产生随机浮点数
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class RandomDoubles {

    private static Random rand = new Random(47);
    public static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles();
        for (int i = 0; i < 7; i++)
            System.out.print(rd.next() + " ");
    }
    public double next() { return rand.nextDouble(); }
} /* Output:
0.7271157860730044 0.5309454508634242 0.16020656493302599 0.18847866977771732 0.5166020801268457 0.2678662084200585 0.2613610344283964
*///:~
