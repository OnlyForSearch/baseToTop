package cn.feng.thinkInJava.b3_1_多线程并发.concurrency;
//: concurrency/SerialNumberGenerator.java

public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;
    public static int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
} ///:~
