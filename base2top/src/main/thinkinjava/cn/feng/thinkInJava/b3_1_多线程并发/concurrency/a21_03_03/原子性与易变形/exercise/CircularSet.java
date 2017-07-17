package cn.feng.thinkInJava.b3_1_多线程并发.concurrency.a21_03_03.原子性与易变形.exercise;
//: concurrency/SerialNumberChecker.java
// Operations that may seem safe are not,
// when threads are present.
// {Args: 4}

// Reuses storage so we don't run out of memory:
class CircularSet {

    private int[] array;
    private int len;
    private int index = 0;
    public CircularSet(int size) {
        array = new int[size];
        len = size;
        // Initialize to a value not produced
        // by the SerialNumberGenerator:
        for (int i = 0; i < size; i++)
            array[i] = -1;
    }
    public synchronized void add(int i) {
        array[index] = i;
        // Wrap index and write over old elements:
        index = ++index % len;
    }
    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++)
            if (array[i] == val)
                return true;
        return false;
    }
}

