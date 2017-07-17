package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_04.非静态实例初始化.exercise;

/**
 * Created by fengyu on 2015-10-14.
 */
public class Exe15 {

    private String string;

    {
        string = new String("demo");
        System.out.println("string = " + string);
    }

    Exe15() {
        System.out.println("Exe15 Initializing ");
    }
    ;

    public static void main(String args[]) {
        new Exe15();
    }
}
