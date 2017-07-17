package cn.feng.thinkInJava.a10_1_IO.FileReaderAndWriter;


//��ȡһ��.java�ļ�������ӡ�ڿ���̨�ϡ�

import java.io.FileReader;
import java.io.IOException;

class FileReaderTest {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("DateDemo.java");

        char[] buf = new char[1024];

        int num = 0;

        while ((num = fr.read(buf)) != -1) {
            System.out.print(new String(buf, 0, num));
        }

        fr.close();
    }

}
