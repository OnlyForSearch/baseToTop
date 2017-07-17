package cn.feng.thinkInJava.b7_1_swt.gui.a22_06_01.控制布局.a22_06_02;
//: gui/GridLayout1.java
// Demonstrates GridLayout.

import javax.swing.*;
import java.awt.*;

import static net.mindview.util.SwingConsole.run;

public class GridLayout1 extends JFrame {

    public GridLayout1() {
        setLayout(new GridLayout(7, 3));
        for (int i = 0; i < 20; i++)
            add(new JButton("Button " + i));
    }
    public static void main(String[] args) {
        run(new GridLayout1(), 300, 300);
    }
} ///:~
