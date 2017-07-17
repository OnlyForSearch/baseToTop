package cn.feng.thinkInJava.b7_1_swt.gui.a22_02_00.Swing基础.exercise;
//: gui/E01_HelloSwing2.java
/**
 * ***************** Exercise 01 ************************
 * Modify HelloSwing.java to prove to yourself that the
 * application will not close without the call to
 * setDefaultCloseOperation().
 * *******************************************************
 */

import javax.swing.*;

        import javax.swing.*;

public class E01_HelloSwing2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
} ///:~