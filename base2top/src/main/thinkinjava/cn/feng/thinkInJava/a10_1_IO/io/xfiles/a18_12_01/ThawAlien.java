package cn.feng.thinkInJava.a10_1_IO.io.xfiles.a18_12_01;
//: io/xfiles/ThawAlien.java
// Try to recover a serialized file without the
// class of object that's stored in that file.
// {RunByHand}

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 寻找类
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class ThawAlien {

    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("..", "X.file")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
} /* Output:
class Alien
*///:~
