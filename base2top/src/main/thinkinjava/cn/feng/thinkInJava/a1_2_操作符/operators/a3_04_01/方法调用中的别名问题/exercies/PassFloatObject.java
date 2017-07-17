package cn.feng.thinkInJava.a1_2_操作符.operators.a3_04_01.方法调用中的别名问题.exercies;

/**
 * Created by Administrator on 2015/9/28.
 */
public class PassFloatObject {
    
    public static void f(FloatNum floatNum) {
        floatNum.f = .0f;
        
    }
    public static void main(String[] args) {
        FloatNum floatNum = new FloatNum();
        floatNum.f = 2.0f;
        System.out.println("floatNum.f = " + floatNum.f);
        f(floatNum);
        System.out.println("floatNum.f = " + floatNum.f);


    }
}

class FloatNum {
    
    float f;
}

