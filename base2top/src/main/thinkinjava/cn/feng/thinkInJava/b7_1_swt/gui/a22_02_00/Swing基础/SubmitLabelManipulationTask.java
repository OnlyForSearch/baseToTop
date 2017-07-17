package cn.feng.thinkInJava.b7_1_swt.gui.a22_02_00.Swing基础;
//: gui/SubmitLabelManipulationTask.java

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class SubmitLabelManipulationTask {

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Hello Swing");
        final JLabel label = new JLabel("A Label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                label.setText("Hey! This is Different!");
            }
        });
    }
} ///:~
