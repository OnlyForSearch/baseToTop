package cn.feng.thinkInJava.a10_1_IO.复制文件;





/*
锟斤拷示mp3锟侥革拷锟狡★拷通锟斤拷锟斤拷锟�
BufferedOutputStream
BufferedInputStream


*/

import java.io.*;

class CopyMp3 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        copy_2();
        long end = System.currentTimeMillis();

        System.out.println((end - start) + "锟斤拷锟斤拷");
    }

    public static void copy_2() throws IOException {
        MyBufferedInputStream bufis = new MyBufferedInputStream(new FileInputStream("c:\\9.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("c:\\3.mp3"));

        int by = 0;

        //System.out.println("锟斤拷一锟斤拷锟街斤拷:"+bufis.myRead());

        while ((by = bufis.myRead()) != -1) {
            bufos.write(by);
        }

        bufos.close();
        bufis.myClose();
    }

    //通锟斤拷锟街斤拷锟斤拷锟侥伙拷锟斤拷锟斤拷锟斤拷筛锟斤拷啤锟�
    public static void copy_1() throws IOException {
        BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("c:\\0.mp3"));
        BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("c:\\1.mp3"));

        int by = 0;

        while ((by = bufis.read()) != -1) {
            bufos.write(by);
        }

        bufos.close();
        bufis.close();


    }
}
