package cn.feng.thinkInJava.a10_1_IO.io.a18_12_02.序列化的控制.exercise;
//: io/E28_BlipCheck.java
// {RunByHand}
/**
 * *************** Exercise 28 *****************
 * In Blips.java, copy the file and rename it to
 * BlipCheck.java and rename the class Blip2 to
 * BlipCheck (making it public and removing the
 * public scope from the class Blips in the
 * process). Remove the //! marks in the file and
 * execute the program including the offending
 * lines. Next, comment out the default
 * constructor for BlipCheck. Run it and explain
 * why it works. Note that after compiling, you
 * must execute the program with "java Blips"
 * because the main() method is still in class
 * Blips.
 * *********************************************
 */
/**
  复制Blips.java并重命名为BlipCheck.java,然后将类Blip2重命名为BlipCheck(
 使其成为public的,在此过程中删除类Blips中的公共作用域)删除文件中的//!标记
 然后执行含有这几个错误行的程序,接下来,注释掉,BlipCheck的默认构造器,执行并
 解释它可以运行的原因,,注意编译后我们必须使用java Blips执行文件,因为main()方法

 然在类Blips中
 *
 *
 * */
import java.io.*;

import static net.mindview.util.Print.print;

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

public class E28_BlipCheck implements Externalizable {

    public static void main(String[] args) throws Exception {
        // To make it run with Ant.
        Blips.main(args);
    }
    // E28_BlipCheck() {
    // print("BlipCheck Constructor");
    // }
    public void writeExternal(ObjectOutput out) throws IOException {
        print("BlipCheck.writeExternal");
    }
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        print("BlipCheck.readExternal");
    }
}

class Blips {

    // Throw exceptions to console:
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        E28_BlipCheck b2 = new E28_BlipCheck();
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
        print("Recovering b2:");
        b2 = (E28_BlipCheck) in.readObject();
    }
} ///:~

/**
 * When we remove the //!’s, the output is:
 * Constructing objects:
 * Blip1 Constructor
 * BlipCheck Constructor
 * Saving objects:
 * I/O 535
 * Blip1.writeExternal
 * BlipCheck.writeExternal
 * Recovering b1:
 * Blip1 Constructor
 * Blip1.readExternal
 * Recovering b2:
 * Exception in thread "main" java.io.InvalidClassException:
 * E28_BlipCheck; no valid constructor
 * at java.io.ObjectStreamClass.<init>(Unknown Source)
 * at java.io.ObjectStreamClass.lookup(Unknown Source)
 * at java.io.ObjectOutputStream.writeObject0(Unknown
 * Source)
 * at java.io.ObjectOutputStream.writeObject(Unknown
 * Source)
 * at Blips.main(E28_BlipCheck.java:64)
 * at E28_BlipCheck.main(E28_BlipCheck.java:48)
 * When we comment out the constructor (as above) the output is:
 * Constructing objects:
 * Blip1 Constructor
 * Saving objects:
 * Blip1.writeExternal
 * BlipCheck.writeExternal
 * Recovering b1:
 * Blip1 Constructor
 * Blip1.readExternal
 * Recovering b2:
 * BlipCheck.readExternal
 * Eliminating the explicit default constructor allows the compiler to generate the
 * default constructor, which removes the exception. When the compiler
 * synthesizes the default constructor for a public class, it makes that constructor
 * public, so it works as an Externalizable object.
 * *
 */