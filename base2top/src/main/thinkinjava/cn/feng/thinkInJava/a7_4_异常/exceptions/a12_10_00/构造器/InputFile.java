package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_10_00.构造器;
//: exceptions/InputFile.java
// Paying attention to exceptions in constructors.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 构造器
 * 有一点很重要，即你要时刻询问自己“如果异常发生了，所有东西能被正确的清理吗“？尽管大多数情况下是非常安全的，但涉及构造器时，问题就出现了。构造器会把对象设置成安全的初始状态，但还会有别的动作，比如打开一个文件，这样的动作只有在对象使用完毕并且用户调用了特殊的清理方法之后才能得以清理。如果在构造器内抛出了异常，这清理行为也许就不能正常工作。这意味着在编写构造器是要格外的小心。
 * <p>
 * 读者也许会认为使用finally就可以解决问题。但问题并非如此简单，因为finally会每次都执行清理代码。如果构造器在执行过程中半途而废，也许该对象的某些部分还没有被成功创建，而这些部分在finally子句中确是要被清理的。
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class InputFile {

    private BufferedReader in;
    public InputFile(String fname) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fname));
            // Other code that might throw exceptions
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + fname);
            // Wasn't open, so don't close it
            throw e;
        } catch (Exception e) {
            // All other exceptions must close it
            try {
                in.close();
            } catch (IOException e2) {
                System.out.println("in.close() unsuccessful");
            }
            throw e; // Rethrow
        } finally {//finally会在每次完成构造器之后都执行一遍,因此它实在不该是调用close()关闭文件的地方
            // Don't close it here!!!
        }
    }
    public String getLine() {//表示文件下一行内容的字符串,抛出异常,并且在内部处理了
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");//异常转换为RuntimeException,表示一个编程错误
        }
        return s;
    }
    //这也是java的缺陷:除了内存的清理之后,所有的清理都不会自动发生,所以就必须告诉客户端程序员,这是他们的责任
    /**
     * 用户不再需要InputFile对象时候,就必须调用dispose(),将释放BufferedReader和FileReader对象所占用的系统资源
     */
    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e2) {
            throw new RuntimeException("in.close() failed");
        }
    }
} ///:~
