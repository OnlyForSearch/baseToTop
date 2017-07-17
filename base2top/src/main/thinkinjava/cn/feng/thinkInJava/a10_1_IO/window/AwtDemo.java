package cn.feng.thinkInJava.a10_1_IO.window;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
����ͼ�λ����棺
1������frame���塣
2���Դ�����л����á�
	�����С��λ�ã����֡�
3�����������
4�������ͨ�����add������ӵ������С�
5���ô�����ʾ��ͨ��setVisible(true)




�¼�������Ƶ��ص㣺
1���¼�Դ��
2���¼���
3����������
4���¼����?

�¼�Դ������awt�����swing���е���Щͼ�ν��������
	
�¼���ÿһ���¼�Դ�����Լ����еĶ�Ӧ�¼��͹����¼���

�������������Դ���ĳһ���¼��Ķ�������ֻһ�����������Ѿ���װ���˼������С�

�������ߣ���java�ж��Ѿ�������ˡ�
ֱ�ӻ�ȡ��������þͿ����ˡ�

����Ҫ���������ǣ����ǶԲ���Ķ������д��?


	
*/
class AwtDemo {

    public static void main(String[] args) {
        Frame f = new Frame("my awt");
        f.setSize(500, 400);
        f.setLocation(300, 200);
        f.setLayout(new FlowLayout());


        Button b = new Button("����һ����ť");

        f.add(b);


        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("�ҹ�");
                System.exit(0);
            }
            public void windowActivated(WindowEvent e) {
                System.out.println("�һ��ˡ�");

            }

            public void windowOpened(WindowEvent e) {
                System.out.println("�ұ�����,hahahhahah");
            }

        });


        f.setVisible(true);

        //System.out.println("Hello World!");
    }
}
/*

class MyWin implements WindowListener
{
	//����7��������������ֻ�õ��˹رյĶ�����
	//��������û���õ�������ȴ���븴д��

}



//��ΪWindowListener������WindowAdapter�Ѿ�ʵ����WindowListener�ӿڡ�
//�����������е����з�������ô��ֻҪ�̳���Windowadapter��������Ҫ�ķ������ɡ�
class MyWin extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		//System.out.println("window closing---"+e.toString());
		System.exit(0);
	}
}

*/

//��ϰ������һ�����壬�ڴ��������һ����ť�߱��رոô���Ĺ��ܡ�
