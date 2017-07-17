package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_01.finally用来做什么.exercise;// exceptions/OnOffSwitch14.java
// TIJ4 Chapter Exceptions, Exercise 14, page 476
// Show that the OnOffSwitch.java can fail by throwing a
// RuntimeException inside the try block.
//试着说明在OnOffSwitch.java的try块内部抛出RuntimeException,程序可能会出现错误

import cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_01.finally用来做什么.OnOffException1;
import cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_01.finally用来做什么.OnOffException2;
import cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_01.finally用来做什么.Switch;

public class OnOffSwitch14 {

    static Integer[] x = new Integer[1];
    private static Switch sw = new Switch();
    public static void f(int i) throws OnOffException1, OnOffException2 {}
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw RuntimeException
            // and leave Switch on:
            f(x[0]);
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
} 

