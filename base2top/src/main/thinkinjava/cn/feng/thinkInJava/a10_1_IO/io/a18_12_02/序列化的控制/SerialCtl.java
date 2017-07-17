package cn.feng.thinkInJava.a10_1_IO.io.a18_12_02.序列化的控制;
//: io/SerialCtl.java
// Controlling serialization by adding your own
// writeObject() and readObject() methods.

import java.io.*;

/**
 * Externalizable的替代方法
 *
 * 我们可以实现 Serializable 接口，并添加（注意是“添加”，而非“覆盖”或者“实现”）名为 writeObject()
 * 和 readObject()的方法。一旦对象被序列化或者重新装配，就会分别调用那两个方法。也就是说，只
 * 要提供了这两个方法，就会优先使用它们，而不考虑默认的序列化机制。
 这些方法必须含有下列准确的签名：

 2 private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException

 从设计的角度出发，情况变得有些扑朔迷离。首先，大家可能认为这些方法不属于基础类或者 Serializable接口的一部分，它们应该在自己的接口中得到定义。但请注意它们被定义成“private”，这意味着它们只能由这个类的其他成员调用。然而，我们实际并不从这个类的其他成员中调用它们，而是由ObjectOutputStream 和
 ObjectInputStream 的 writeObject() 及 readObject()方法来调用我们对象的writeObject() 和 readObject()方法。

 我们调用 ObjectOutputStream.writeObject()的时候，我们传递给它的 Serializable 对象似乎会被检查是否实现了自己的 writeObject() 。若答案是肯定的是，便会跳过常规的序列化过程，并调用writeObject() 。readObject()也同样。

 在我们的 writeObject() 内部，可以调用 defaultWriteObject()，从而决定执行默认的writeObject()。准备通过默认机制写入对象的非 transient 部分，那么必须调用 defaultWriteObject()，令其作为writeObject() 中的第一个操作；并调用 defaultReadObject()
 ，令其作为 readObject()的第一个操作。
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class SerialCtl implements Serializable {

    private String a;
    private transient String b;
    public SerialCtl(String aa, String bb) {
        a = "Not Transient: " + aa;
        b = "Transient: " + bb;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before:\n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);
        // Now get it back:
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("After:\n" + sc2);
    }
    public String toString() { return a + "\n" + b; }
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }
} /* Output:
Before:
Not Transient: Test1
Transient: Test2
After:
Not Transient: Test1
Transient: Test2
*///:~
