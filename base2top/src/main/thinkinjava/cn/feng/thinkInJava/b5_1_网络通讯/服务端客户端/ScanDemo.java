package cn.feng.thinkInJava.b5_1_网络通讯.服务端客户端;

import java.net.Socket;

class ScanDemo {

    public static void main(String[] args) {
        for (int x = 130; x < 145; x++) {
            try {

                Socket s = new Socket("192.168.1.254", x);

                System.out.println(x + "...open");

            } catch (Exception e) {
                System.out.println(x + "...closed");
            }
        }
    }
}
