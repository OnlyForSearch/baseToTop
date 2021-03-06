package cn.feng.thinkInJava.a1_2_操作符.operators.a3_05_00.算术操作符;
//: operators/MathOps.java
// Demonstrates the mathematical operators.

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * 算术操作符
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class MathOps {

    public static void main(String[] args) {
        // Create a seeded random number generator:
        // 如果构造器没有传递任何参数,那么java就会将当前时间作为随机数生成器的种子
        // ,随机数生成器对于特定的种子总是产生相同的随机数序列
        Random rand = new Random(47);
        int i, j, k;
        // Choose value from 1 to 100:
        j = rand.nextInt(100) + 1;//随机数设置了上限,其下限为0,但是并不需要这个下限,为了排除产生0的可能性,对结果加1
        print("j : " + j);
        k = rand.nextInt(100) + 1;
        print("k : " + k);
        i = j + k;
        print("j + k : " + i);
        i = j - k;
        print("j - k : " + i);
        i = k / j;
        print("k / j : " + i);
        i = k * j;
        print("k * j : " + i);
        i = k % j;
        print("k % j : " + i);
        j %= k;
        print("j %= k : " + j);
        // Floating-point number tests:
        float u, v, w; // Applies to doubles, too
        v = rand.nextFloat();
        print("v : " + v);
        w = rand.nextFloat();
        print("w : " + w);
        u = v + w;
        print("v + w : " + u);
        u = v - w;
        print("v - w : " + u);
        u = v * w;
        print("v * w : " + u);
        u = v / w;
        print("v / w : " + u);
        // The following also works for char,
        // byte, short, int, long, and double:
        u += v;
        print("u += v : " + u);
        u -= v;
        print("u -= v : " + u);
        u *= v;
        print("u *= v : " + u);
        u /= v;
        print("u /= v : " + u);
    }
} /* Output:
j : 59
k : 56
j + k : 115
j - k : 3
k / j : 0
k * j : 3304
k % j : 56
j %= k : 3
v : 0.5309454
w : 0.0534122
v + w : 0.5843576
v - w : 0.47753322
v * w : 0.028358962
v / w : 9.940527
u += v : 10.471473
u -= v : 9.940527
u *= v : 5.2778773
u /= v : 9.940527
*///:~
