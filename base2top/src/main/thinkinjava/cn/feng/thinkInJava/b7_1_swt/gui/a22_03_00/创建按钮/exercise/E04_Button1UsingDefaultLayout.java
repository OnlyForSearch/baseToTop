package cn.feng.thinkInJava.b7_1_swt.gui.a22_03_00.创建按钮.exercise;
//: gui/E04_Button1UsingDefaultLayout.java
/**
 * ***************** Exercise 04 ************************
 * Verify that without the setLayout() call in
 * Button1.java, only one button will appear in the
 * resulting program.
 * *******************************************************
 */

import javax.swing.*;

import static net.mindview.util.SwingConsole.run;

public class E04_Button1UsingDefaultLayout extends JFrame {

    private JButton b1 = new JButton("Button 1"), b2 = new JButton("Button 2");
    public E04_Button1UsingDefaultLayout() {
        add(b1);
        add(b2);
    }
    public static void main(String[] args) {
        run(new E04_Button1UsingDefaultLayout(), 200, 100);
    }
} ///:~