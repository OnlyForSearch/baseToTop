package cn.feng.thinkInJava.a10_1_IO.FileReaderAndWriter;


/*
��ȡ����¼�롣
System.out:��Ӧ���Ǳ�׼����豸������̨��
System.in:��Ӧ�ı�׼�����豸�����̡�


����
ͨ�����¼����ݡ�
��¼��һ����ݺ󣬾ͽ�������ݽ��д�ӡ��
���¼��������over����ôֹͣ¼�롣

*/

import java.io.IOException;
import java.io.InputStream;

class ReadIn {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int ch = in.read();
            if (ch == '\r')
                continue;
            if (ch == '\n') {
                String s = sb.toString();
                if ("over".equals(s))
                    break;
                System.out.println(s.toUpperCase());
                sb.delete(0, sb.length());
            } else
                sb.append((char) ch);

        }
    }
}
