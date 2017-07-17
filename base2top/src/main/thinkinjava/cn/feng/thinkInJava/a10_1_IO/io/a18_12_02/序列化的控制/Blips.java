package cn.feng.thinkInJava.a10_1_IO.io.a18_12_02.序列化的控制;
//: io/Blips.java
// Simple use of Externalizable & a pitfall.

import java.io.*;

import static net.mindview.util.Print.print;

/**
 * 序列化的控制
 *通过实现 Externalizable 接口，用它代替 Serializable 接口，便可控制序列化的具体过程。这个 Externalizable 接口扩展了 Serializable，并增添了两个方法：writeExternal()和 readExternal() 。在序列化和重新装配的过程中，会自动调用这两个方法，以便我们执行一些特殊操作。

 与恢复一个 Serializable（可序列化）对象不同。在后者的情况下，对象完全以它保存下来的二进制位为基础恢复，不存在构建器调用。而对一个 Externalizable 对象，所有普通的默认构建行为都会发生（包括在字段定义时的初始化），而且会调用 readExternal()
 。必须注意这一事实——特别注意所有默认的构建行为都会进行——否则很难在自己的 Externalizable 对象中产生正确的行为。所以默认构造器得是public的，否则会抛出异常。

 为了让一切正常运作起来，千万不可仅在 writeExternal()方法执行期间写入对象的重要数据（没有默认的行为可用来为一个 Externalizable 对象写入所有成员对象）的，而是必须在 readExternal()方法中也恢复那些数据。
 * @author fengyu
 * @date 2015年8月9日
 */
class Blip1 implements Externalizable {

    public Blip1() {
        print("Blip1 Constructor");
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip1.writeExternal");
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {

    Blip2() {
        print("Blip2 Constructor");
    }
    public void writeExternal(ObjectOutput out) throws IOException {
        print("Blip2.writeExternal");
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("Blip2.readExternal");
    }
}

public class Blips {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        print("Recovering b1:");
        b1 = (Blip1) in.readObject();
        // OOPS! Throws an exception:
        //! print("Recovering b2:");
        //! b2 = (Blip2)in.readObject();
    }
} /* Output:
Constructing objects:
Blip1 Constructor
Blip2 Constructor
Saving objects:
Blip1.writeExternal
Blip2.writeExternal
Recovering b1:
Blip1 Constructor
Blip1.readExternal
*///:~
