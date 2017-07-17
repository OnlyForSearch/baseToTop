package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_00.散列与散列码;
//: containers/Groundhog.java
// Looks plausible, but doesn't work as a HashMap key.

/**
 * 散列码和散列
 *标准类库中的类被用作HashMap的键，它用得很好，因为它具备了键所需的全部性质。
 * 当你创建用作HashMap的键的类，有可能会忘记在其中放置必需的方法，而这是通常会犯的一个错误。
 *
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class Groundhog {

    protected int number;
    //给予一个表示数字
    public Groundhog(int n) { number = n; }
    public String toString() {//
        return "Groundhog #" + number;
    }
} ///:~
