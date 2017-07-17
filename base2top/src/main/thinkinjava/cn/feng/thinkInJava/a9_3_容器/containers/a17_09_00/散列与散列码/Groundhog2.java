package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_00.散列与散列码;
//: containers/Groundhog2.java
// A class that's used as a key in a HashMap
// must override hashCode() and equals().


/**
 * 正确的equals()方法必须满足下列5个条件：

 自反性。对任意x，x.equals(x)一定返回true。
 对称性。对任意x和y，如果y.equals(x)返回true，则x.equals(y)也返回true。
 传递性。对任意x、y、z，如果x.equals(y)返回true，y.equals(z)返回true，则x.equals(z)一定返回true。
 一致性。对任意x和y，如果对象中用于等价比较的信息没有改变，那么无论调用x.equals(y)多少次，返回的结果应该保持一致，要么一直是true，要么一直是false。
 对任何不是null的x，x.equals(null)一定返回false。

 再次强调，默认的Object.equals()只是比较对象的地址，所以一个Groundhog(3)并不等于另一个Groundhog(3)。因此，如果要使用自己的类作为HashMap的键，必须同时重载hashCode()和equals()。

 hashCode()并不需要总是能够返回唯一的标识码，但是equals()方法必须严格地判断两个对象是否相同。
 instanceof悄悄地检查了此对象是否为null，因为如果instanceof左边的参数为null，它会返回false。
 *
 * */
public class Groundhog2 extends Groundhog {

    public Groundhog2(int n) { super(n); }
    public int hashCode() { return number; }
    public boolean equals(Object o) {
        return o instanceof Groundhog2 && (number == ((Groundhog2) o).number);
    }
} ///:~
