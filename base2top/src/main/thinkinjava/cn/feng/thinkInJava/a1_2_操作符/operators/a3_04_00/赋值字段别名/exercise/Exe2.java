package cn.feng.thinkInJava.a1_2_操作符.operators.a3_04_00.赋值字段别名.exercise;

/**
 * Created by Administrator on 2015/9/28.
 */
public class Exe2 {
    
    public static void main(String[] args) {
        Tank tank1 = new Tank();
        tank1.level = 3.0f;
        System.out.println("tank1.level = " + tank1.level);
        Tank tank2 = new Tank();

        System.out.println("tank2.level = " + tank2.level);
        tank2 = tank1;
        System.out.println("tank1.level = " + tank1.level);
        System.out.println("tank2.level = " + tank2.level);
        tank1.level = 24.9f;
        System.out.println("tank1.level = " + tank1.level);
        System.out.println("tank2.level = " + tank2.level);


    }
    
}

class Tank {
    
    float level;
}
