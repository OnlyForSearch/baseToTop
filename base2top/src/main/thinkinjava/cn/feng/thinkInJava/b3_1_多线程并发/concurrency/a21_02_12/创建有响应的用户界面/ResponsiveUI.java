package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_02_12.创建有响应的用户界面;
//: concurrency/ResponsiveUI.java
// User interface responsiveness.
// {RunByHand}

/**
 * 创建有响应的用户界面
 *
 * @author fengyu
 * @date 2015年8月9日
 */
//这个版本关注于运算,所有不能读取控制台输入
class UnresponsiveUI {

    /**
     * UnresponsiveUI在一个无限的while循环里执行运算,显然程序
     * 不可能到达读取控制台输入的那一行(编译器被欺骗,相信while的条件使得程序
     * 能达到读取控制台输入的那一行).如果把建立UnresponsiveUI的那一行
     * 注释解除掉在运行程序,那么要终止,就只能杀死这个进程,要想让程序有响应,就得
     * 把计算程序放在run()方法,那样它就能让出处理器给别的程序,当你按下"回车键"
     * 的时候,可以看到计算确实在作为后台程序运行,同时还在等待用户输入
     * )
     */
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception {
        while (d > 0)
            d = d + (Math.PI + Math.E) / d;
        System.in.read(); // Never gets here
    }
}
//这个版本吧运算放在任务里单独运行,此时就可以在进行
// 运算的同时监听控制台输入
public class ResponsiveUI extends Thread {

    private static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }
    public static void main(String[] args) throws Exception {
       /**注释解除掉在运行程序,那么要终止,就只能杀死这个进程,要想让程
        * 序有响应,就得把计算程序放在run()方法,那样它就能让出处理器给
        * 别的程序,当你按下"回车键"的时候,可以看到计算确实在作为后台程
        * 序运行,同时还在等待用户输入*/
        //! new UnresponsiveUI(); // Must kill this process
        new ResponsiveUI();
        System.in.read();
        System.out.println(d); // Shows progress
    }
    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }
} ///:~
