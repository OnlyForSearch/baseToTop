package cn.feng.thinkInJava.a9_3_容器.containers.a17_10_03.维基测试的危险;
//: containers/RandomBounds.java
// Does Exe4.random() produce 0.0 and 1.0?
// {RunByHand}

import static net.mindview.util.Print.print;

/**
 * 为基准测试的危险性
 *在编写所谓的微基准测试时，你必须要当心，不能做太多的假设，并且要将你的测试窄化。
 * 你还必须仔细地确保你的测试运行足够长的时间，以产生有意义的数据，并且要考虑到某
 * 些Java HotSpot技术只有在程序运行了一段时间之后才会踢爆问题（这对于短期运行的
 * 程序来说也很重要）。根据计算机和所使用的JVM的不同，所产生的结果也会有所不同。

 剖析器可以把性能分析工作做得比你好。Java提供了一个剖析器。
 * @author fengyu
 * @date 2015年8月9日
 */
public class RandomBounds {

    static void usage() {
        print("Usage:");
        print("\tRandomBounds lower");
        print("\tRandomBounds upper");
        System.exit(1);
    }
    public static void main(String[] args) {
        if (args.length != 1)
            usage();
        if (args[0].equals("lower")) {
            while (Math.random() != 0.0)
                ; // Keep trying
            print("Produced 0.0!");
        } else if (args[0].equals("upper")) {
            while (Math.random() != 1.0)
                ; // Keep trying
            print("Produced 1.0!");
        } else
            usage();
    }
} ///:~
