package cn.feng.thinkInJava.a10_1_IO.io.a18_12_00.对象的序列换.exercise;
//: io/E27_ObjectSerialization.java
/**
 * ******************* Exercise 27 *********************
 * Create a Serializable class containing a reference to an
 * object of a second Serializable class. Create an instance
 * of your class, serialize it to disk, then restore it and
 * verify that the process worked correctly.
 * ******************************************************
 */
/**创建一个Serializable,它包含一个对第二个Serializable类的对象的引用,创建你的类的实例,将其序列化到硬盘上,然后恢复它,并验证这个过程可以正确地工作*/
import java.io.*;

import static net.mindview.util.Print.print;


class Thing1 implements Serializable {

    private Thing2 next;
    public Thing1(int id) { next = new Thing2(id); }
    public String toString() {
        StringBuilder result = new StringBuilder("Thing1(Thing2(");
        result.append(next);
        result.append("))");
        return result.toString();
    }
}

class Thing2 implements Serializable {

    private int id;
    public Thing2(int id) { this.id = id; }
    public String toString() { return Integer.toString(id); }
}

public class E27_ObjectSerialization {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Thing1 t1 = new Thing1(1);
        print("t1 = " + t1);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("thing1.out"));
        out.writeObject("Thing1 storage\n");
        out.writeObject(t1);
        out.close(); // Also flushes output
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("thing1.out"));
        String s = (String) in.readObject();
        Thing1 t2 = (Thing1) in.readObject();
        print(s + "t2 = " + t2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Thing1 storage\n");
        out2.writeObject(t1);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        Thing1 t3 = (Thing1) in2.readObject();
        print(s + "t3 = " + t3);
    }
} /* Output:
I/O 533
t1 = Thing1(Thing2(1))
Thing1 storage
t2 = Thing1(Thing2(1))
Thing1 storage
t3 = Thing1(Thing2(1))
*///:~