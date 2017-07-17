package cn.feng.thinkInJava.a1_2_操作符.operators.a3_05_00.算术操作符.exercise;
//: operators/E04_Velocity.java
// {Args: 30.5 3.2}
/**
 * *************** Exercise 4 *****************
 * Write a program that calculates velocity
 * using a constant distance and a constant time.
 * *********************************************
 */
/**
 * 计算速度的程序,它所使用的距离和时间都是常量
 * Created by Administrator on 2015/9/28.
 */
public class Exe4 {

    public static void main(String[] args) {

        float d = 25.1f;
        System.out.println("d = " + d);
        float t = 2.4f;
        System.out.println("t = " + t);
        Velocity velocity = new Velocity();
        float velocity1 = velocity.velocity(d, t);
        System.out.println("velocity1 = " + velocity1);
    }


}

class Velocity {

    public float velocity(float d, float t) {
        if (t == 0)
            return 0f;
        else
            return d / t;
    }

}