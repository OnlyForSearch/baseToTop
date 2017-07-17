package cn.feng.thinkInJava.a10_1_IO.io.a18_12_00.对象的序列换;
//: io/Worm.java
// Demonstrates object serialization.

import java.io.*;
import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * 对象谢列化
 *如果需要一个更严格的持久性机制，可以考虑像Hibernate之类的工具。对象序列化加入到语言中是为了支持两种主要特性，一是Java的远程方法调用（Remote Method Invocation，RMI）；二是Java Beans，后者由 Java 1.1 引入。使用一个 Bean 时，它的状态信息通常在设计期间配置好。

 对象实现了Serializable接口，序列化对象就会很简单。首先要创建某些 OutputStream 对象，然后将其封装到 ObjectOutputStream 对象内。此时，只需调用 writeObject() 即可完成对象的序列化，并将其发送给 OutputStream。相反的过程是将一个InputStream 封装到
 ObjectInputStream 内，然后调用 readObject()。和往常一样，我们最后获得的是指向一个上溯造型 Object 的句柄，所以必须下溯造型，以便能够直接设置。

 每个类都持有一个特定的serialVersionUID，如果待序列化的对象和目标对象的serialVersionUID不同，那么在反序列化时就会抛出InvalidClassException异常。

 对象序列化特别“聪明”的一个地方是它不仅保存了对象的“全景图”，而且能追踪对象内包含的所有句柄并保存那些对象；接着又能对每个对象内包含的句柄进行追踪；以此类推。我们有时将这种情况称为“对象网”
 * @author fengyu
 * @date 2015年8月9日
 */
class Data implements Serializable {

    private int n;
    public Data(int n) { this.n = n; }
    public String toString() { return Integer.toString(n); }
}

public class Worm implements Serializable {

    private static Random rand = new Random(47);
    private Data[] d = {new Data(rand.nextInt(10)), new Data(rand.nextInt(10)), new Data(rand.nextInt(10))};
    private Worm next;
    private char c;
    // Value of i == number of segments
    public Worm(int i, char x) {
        print("Worm constructor: " + i);
        c = x;
        if (--i > 0)
            next = new Worm(i, (char) (x + 1));
    }
    public Worm() {
        print("Default constructor");
    }
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Worm w = new Worm(6, 'a');
        print("w = " + w);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close(); // Also flushes output
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("worm.out"));
        String s = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        print(s + "w2 = " + w2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        print(s + "w3 = " + w3);
    }
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data dat : d)
            result.append(dat);
        result.append(")");
        if (next != null)
            result.append(next);
        return result.toString();
    }
} /* Output:
Worm constructor: 6
Worm constructor: 5
Worm constructor: 4
Worm constructor: 3
Worm constructor: 2
Worm constructor: 1
w = :a(853):b(119):c(802):d(788):e(199):f(881)
Worm storage
w2 = :a(853):b(119):c(802):d(788):e(199):f(881)
Worm storage
w3 = :a(853):b(119):c(802):d(788):e(199):f(881)
*///:~
