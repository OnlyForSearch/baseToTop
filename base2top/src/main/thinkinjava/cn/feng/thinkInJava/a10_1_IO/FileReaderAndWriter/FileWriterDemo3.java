package cn.feng.thinkInJava.a10_1_IO.FileReaderAndWriter;
/*
��ʾ�������ļ��������д��
*/

import java.io.FileWriter;
import java.io.IOException;

class FileWriterDemo3 {

    public static void main(String[] args) throws IOException {

        //����һ��true�����?�������е��ļ������������ļ���ĩβ�����������д��
        FileWriter fw = new FileWriter("demo.txt", true);

        fw.write("\r\nnihao\r\nxiexie");

        fw.close();
    }
}
