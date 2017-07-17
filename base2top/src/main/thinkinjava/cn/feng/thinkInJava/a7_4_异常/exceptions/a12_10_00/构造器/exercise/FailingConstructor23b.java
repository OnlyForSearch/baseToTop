package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_10_00.构造器.exercise;// exceptions/FailingConstructor23b.java
// TIJ4 Chapter Exceptions, Exercise 23, page 489
/* Add a class with a dispose() method to the previous exercise. Modify 
* FailingConstructor so that the constructor creates one of these disposable objects 
* as a member object, after which the constructor might throw and exception, after 
* which it creates a second disposable member object. Write code to properly guard 
* against failure, and in main() verify that all possible failure situations are covered. 
*/
/**
 * 在前一个练习中添加一个dispose()方法,修改FailingConstructor,使其构造器可以将那些去除对象
 * 之一当作一个成员对象创建,然后该构造器可能会抛出一个异常,之后它将创建第二个可去除对象,编写能够
 * 确保不会出现故障的代码,并在main()中验证所有可能的故障情形都被覆盖了
 * <p>
 * *
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class NeedsCleanup {

    private static long counter = 1;
    private final long id = counter++;
    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

public class FailingConstructor23b {

    NeedsCleanup nc1;
    NeedsCleanup nc2;
    private BufferedReader in;
    public FailingConstructor23b(String fname) throws Exception {
        nc1 = new NeedsCleanup();
        try {
            in = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file " + fname);
            throw e;
        } catch (Exception e) {
            try {
                in.close();
            } catch (IOException e2) {
                System.out.println("in.close() failed");
            }
            throw e;
        }
        nc2 = new NeedsCleanup();
    }
    public static void main(String[] args) {
        try {
            FailingConstructor23b fc = new FailingConstructor23b("AlwaysFinally.java");
            try {
                String s;
                int i = 1;
                while ((s = fc.getLine()) != null) {
                    // code to print to new file:
                    // println(i + " " + s);
                    // i++;
                }
            } catch (Exception e) {
                System.out.println("Exception caught in main()");
                e.printStackTrace(System.err);
            } finally {
                fc.nc1.dispose();
                fc.nc2.dispose();
            }
        } catch (Exception e) {
            System.out.println("FailingConstructor23b construction failed");
        }
    }
    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }
}

