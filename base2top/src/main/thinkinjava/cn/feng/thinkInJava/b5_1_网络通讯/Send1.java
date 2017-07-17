package cn.feng.thinkInJava.b5_1_网络通讯;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

class Send1 implements Runnable {

    public void run() {
        try {
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

            String line = null;

            while ((line = bufr.readLine()) != null) {


                byte[] buf = line.getBytes();

                Socket s = new Socket("192.168.1.254", 10004);

                OutputStream out = s.getOutputStream();
                out.write(buf);

                if ("886".equals(line))
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException("���Ͷ�ʧ��");
        }
    }
}

class Rece1 implements Runnable {

    private DatagramSocket ds;
    public Rece1(DatagramSocket ds) {
        this.ds = ds;
    }
    public void run() {
        try {
            while (true) {
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);

                ds.receive(dp);


                String ip = dp.getAddress().getHostAddress();

                String data = new String(dp.getData(), 0, dp.getLength());

                if ("886".equals(data)) {
                    System.out.println(ip + "....�뿪������");
                    break;
                }


                System.out.println(ip + ":" + data);
            }
        } catch (Exception e) {
            throw new RuntimeException("���ն�ʧ��");
        }
    }
}
