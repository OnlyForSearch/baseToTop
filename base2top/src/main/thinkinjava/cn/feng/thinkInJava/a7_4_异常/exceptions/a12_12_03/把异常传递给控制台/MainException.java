package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_12_03.把异常传递给控制台;
//: exceptions/MainException.java

import java.io.FileInputStream;

/**
 * 把异常传递给控制台
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class MainException {

    // Pass all exceptions to the console:
    public static void main(String[] args) throws Exception {
        // Open the file:
        FileInputStream file = new FileInputStream("MainException.java");
        // Use the file ...
        // Close the file:
        file.close();
    }
} ///:~
