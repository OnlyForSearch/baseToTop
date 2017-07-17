package cn.feng.thinkInJava.a10_1_IO.FileReaderAndWriter;
/*
IO�쳣�Ĵ��?ʽ��
*/

import java.io.FileWriter;
import java.io.IOException;

class FileWriterDemo2 {

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("demo.txt", true);
            fw.write("abcdefg");

        } catch (IOException e) {
            System.out.println("catch:" + e.toString());
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }

        }

    }
}
