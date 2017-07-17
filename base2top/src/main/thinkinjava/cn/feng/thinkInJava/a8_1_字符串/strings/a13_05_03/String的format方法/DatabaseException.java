package cn.feng.thinkInJava.a8_1_字符串.strings.a13_05_03.String的format方法;

//: strings/DatabaseException.java

/**
 * String.format()
 *Java SE5也参考了C中的sprintf()方法，以生成格式化的String对象。String.format()是一个static方法，它接受与Formatter.format()方法一样的参数，但是返回一个String对象。当你只需要使用format()方法一次时，String.format()用起来很方便。其实，在String.format
 * ()内部，它也是创建了一个Formatter对象，然后将你传入的参数转给该Formatter。不过，与其自己做这些事情，不如使用便捷的String.format()方法，何况这样的代码更清晰易读。
 * @author fengyu
 * @date 2015年8月8日
 */
public class DatabaseException extends Exception {

    public DatabaseException(int transactionID, int queryID, String message) {
        super(String.format("(t%d, q%d) %s", transactionID, queryID, message));
    }

    public static void main(String[] args) {
        try {
            throw new DatabaseException(3, 7, "Write failed");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
} /*
 * Output: DatabaseException: (t3, q7) Write failed
 */// :~
