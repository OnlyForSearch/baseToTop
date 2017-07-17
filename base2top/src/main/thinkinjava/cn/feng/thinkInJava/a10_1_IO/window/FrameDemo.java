package cn.feng.thinkInJava.a10_1_IO.window;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class FrameDemo {

    //�����ͼ�����������������á�
    private Frame f;
    private Button but;

    FrameDemo() {
        init();
    }
    public static void main(String[] args) {
        new FrameDemo();
    }
    public void init() {
        f = new Frame("my frame");

        //��frame���л����á�
        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout());

        but = new Button("my button");

        //�������ӵ�frame��
        f.add(but);


        //����һ�´������¼���
        myEvent();

        //��ʾ����;
        f.setVisible(true);

    }
    private void myEvent() {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //�ð�ť�߱��˳�����Ĺ���
        /*
        ��ť�����¼�Դ��
		��ôѡ���ĸ��������أ�
		ͨ��رմ���ʾ���˽⵽����Ҫ֪���ĸ�����߱�ʲô������м�������
		��Ҫ�鿴���������Ĺ��ܡ�
		 ͨ�����button�����������ְ�ť֧��һ�����м���addActionListener��

		*/
        but.addActionListener(new ActionListener() {
            private int count = 1;
            public void actionPerformed(ActionEvent e) {
                //System.out.println("�˳�����ť�ɵ�");
                //System.exit(0);

                //f.add(new Button("Button-"+(count++)));
                //f.setVisible(true);
                //f.validate();

                //System.out.println(e.getSource());
                Button b = (Button) e.getSource();

                Frame f1 = (Frame) b.getParent();

                f1.add(new Button("button-" + count++));
                f1.validate();


            }
        });
    }
}
