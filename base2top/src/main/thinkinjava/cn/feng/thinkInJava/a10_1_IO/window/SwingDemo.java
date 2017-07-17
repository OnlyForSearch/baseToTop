package cn.feng.thinkInJava.a10_1_IO.window;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class SwingDemo {

    public static void main(String[] args) {
        JFrame f = new JFrame();

        f.setBounds(300, 100, 500, 400);

        f.setLayout(new FlowLayout());

        JButton but = new JButton("����һ����ť");

        f.add(but);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        f.setVisible(true);
    }
}
