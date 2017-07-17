package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_07_06.Semaphone;
//: concurrency/Fat.java
// Objects that are expensive to create.
//为了创建一个示例,我们可以使用Fat,这是一种创建代价高昂的对象类型
//应为他的构造器运行起来很耗时
public class Fat {

    private static int counter = 0;
    private final int id = counter++;
    private volatile double d; // Prevent optimization
    public Fat() {
        // Expensive, interruptible operation:
        for (int i = 1; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }
    public void operation() { System.out.println(this); }
    public String toString() { return "Fat id: " + id; }
} ///:~
