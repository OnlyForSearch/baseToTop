package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_00.不正确的访问资源;
//: concurrency/EvenGenerator.java
// When threads collide.

public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
    public int next() {
        ++currentEvenValue; // Danger point here!
        Thread.yield();//为了更快地发现失败
        ++currentEvenValue;
        return currentEvenValue;
    }
} /* Output: (Sample)
Press Control-C to exit
89476993 not even!
89476993 not even!
*///:~
