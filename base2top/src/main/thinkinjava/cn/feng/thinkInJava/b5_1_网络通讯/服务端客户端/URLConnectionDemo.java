package cn.feng.thinkInJava.b5_1_网络通讯.服务端客户端;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

class URLConnectionDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://192.168.1.254:8080/myweb/demo.html");

        URLConnection conn = url.openConnection();
        System.out.println(conn);

        InputStream in = conn.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        System.out.println(new String(buf, 0, len));


    }
}
