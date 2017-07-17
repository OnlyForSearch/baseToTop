package cn.feng.thinkInJava.a10_1_IO.window;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class MyMenuDemo {

    private Frame f;
    private MenuBar mb;
    private Menu m, subMenu;
    private MenuItem closeItem, subItem;

    MyMenuDemo() {
        init();
    }
    public static void main(String[] args) {
        new MyMenuDemo();
    }
    public void init() {
        f = new Frame("my window");
        f.setBounds(300, 100, 500, 600);
        f.setLayout(new FlowLayout());

        mb = new MenuBar();

        m = new Menu("�ļ�");

        subMenu = new Menu("�Ӳ˵�");


        subItem = new MenuItem("����Ŀ");
        closeItem = new MenuItem("�˳�");

        subMenu.add(subItem);

        m.add(subMenu);
        m.add(closeItem);
        mb.add(m);

        f.setMenuBar(mb);

        myEvent();

        f.setVisible(true);


    }
    private void myEvent() {

        closeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
