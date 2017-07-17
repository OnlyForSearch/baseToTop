package cn.feng.thinkInJava.a10_1_IO.io.a18_12_02.序列化的控制;
//: io/Logon.java
// Demonstrates the "transient" keyword.

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * translent(瞬时)关键字
 *即使那种信息在对象中具有“private”（私有）属性，
 * 但一旦经序列化处理，人们就可以通过读取一个文件，或者拦截网络传输得到它
 * 为解决这个问题，可以用transient（临时）逐个字段地关闭序列化

 static 代表类成员，也不会被序列化
 * @author fengyu
 * @date 2015年8月9日
 */
public class Logon implements Serializable {

    private Date date = new Date();
    private String username;
    private transient String password;
    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }
    public static void main(String[] args) throws Exception {
        Logon a = new Logon("Hulk", "myLittlePony");
        print("logon a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1); // Delay
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Logon.out"));
        print("Recovering object at " + new Date());
        a = (Logon) in.readObject();
        print("logon a = " + a);
    }
    public String toString() {
        return "logon info: \n   username: " + username +
                "\n   date: " + date + "\n   password: " + password;
    }
} /* Output: (Sample)
logon a = logon info:
   username: Hulk
   date: Sat Nov 19 15:03:26 MST 2005
   password: myLittlePony
Recovering object at Sat Nov 19 15:03:28 MST 2005
logon a = logon info:
   username: Hulk
   date: Sat Nov 19 15:03:26 MST 2005
   password: null
*///:~
