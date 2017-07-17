package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_01.finally用来做什么;


public class WithFinally {

    static Switch sw = new Switch();
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            OnOffSwitch.f();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {//sw.off()被移动到一处,并且保证在任何情况下都能得到执行
            sw.off();
        }
    }
} /* Output:
on
off
*///:~
