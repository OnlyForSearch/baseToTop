package cn.feng.thinkInJava.a10_1_IO.io.a18_10_03.视图缓冲器.exercise;

//: io/E24_DoubleBufferDemo.java
/**
 * ****************** Exercise 24 ***********************
 * Modify IntBufferDemo.java to use doubles.
 * *******************************************************
 *///修改IntBufferDemo使用double

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class E24_DoubleBufferDemo {

    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        // Store an array of double:
        db.put(new double[]{1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6});
        // Absolute location read and write:
        System.out.println(db.get(3));
        db.put(3, 0.3);
        db.flip();
        while (db.hasRemaining()) {
            double d = db.get();
            System.out.println(d);
        }
    }
} /* Output:
1.3
1.0
1.1
1.2
0.3
1.4
1.5
1.6
*///:~