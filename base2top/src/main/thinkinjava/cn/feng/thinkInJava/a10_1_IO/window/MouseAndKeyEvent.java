package cn.feng.thinkInJava.a10_1_IO.window;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


class MouseAndKeyEvent {

    private Frame f;
    private Button but;
    private TextField tf;

    MouseAndKeyEvent() {
        init();
    }
    public static void main(String[] args) {
        new MouseAndKeyEvent();
    }
    public void init() {
        f = new Frame("my frame");

        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout());

        tf = new TextField(20);

        but = new Button("my button");


        f.add(tf);
        f.add(but);


        myEvent();

        f.setVisible(true);

    }
    private void myEvent() {
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)) {
                    System.out.println(code + ".....�ǷǷ���");
                    e.consume();
                }


            }
        });

        //��But���һ�����̼���
        but.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
                    //System.exit(0);
                    System.out.println("ctrl+enter is run");

                //System.out.println(KeyEvent.getKeyText(e.getKeyCode())+"...."+e.getKeyCode());
            }
        });



		/*
        but.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("action ok");
			}
		});
		*/

		/*

		but.addMouseListener(new MouseAdapter()
		{
			private int count = 1;
			private int clickCount = 1;
			public void mouseEntered(MouseEvent e)
			{
				System.out.println("�����뵽�����"+count++);
			}
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()==2)
					System.out.println("˫������"+clickCount++);
			}
		});
		*/
    }
}
