package cn.feng.thinkInJava.a0_0.exercise.a4_1_面向对象.a2_static静态;
/*
静态代码块。
格式：
static
{
	静态代码块中的执行语句。
}

特点：随着类的加载而执行，只执行一次,并优先于主函数。
用于给类进行初始化的。

*/

public class 静态代码块 {

    static {
        System.out.println("静态代码块 :b");
    }

    static {
        System.out.println(":静态代码块 c");
    }
    public static void main(String[] args) {
        new StaticCode(4);//a c d
        //new StaticCode();
        //new StaticCode();
        //System.out.println("over");
        //StaticCode.show();
        //StaticCode s = null;
        //s = new StaticCode();

        //StaticCode.show();


    }

}

class StaticCode {

    static {
        System.out.println("StaticCode:a");
    }

    int num = 9;

    {
        System.out.println("StaticCode:c" + this.num);
    }
    StaticCode() {
        System.out.println("b");
    }

    StaticCode(int x) {
        System.out.println("StaticCode:d" + num);
    }
    public static void show() {
        System.out.println("StaticCode show run");
    }
}

//d:\>java0217\day06>java StaticCodeDemo
//b c a over