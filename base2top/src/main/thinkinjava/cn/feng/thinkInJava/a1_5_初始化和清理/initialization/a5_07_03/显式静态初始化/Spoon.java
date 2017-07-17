package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_07_03.显式静态初始化;
//: initialization/Spoon.java

/**
 * 显式静态初始化
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Spoon {

    public void f() {}
    public static void g() {

    }
    static int i;
    int j;

    //允许将多个静态初始化动作组织成一个特殊的"静态子句"("静态代码块")
    static {//看起来像一个方法,实际上只是一段跟在static后面的代码,与其他静态初始化一样,只执行一次
        i = 47;
        g();
        //  f();//不能存在非静态
        //j=254;
    }

} ///:~
