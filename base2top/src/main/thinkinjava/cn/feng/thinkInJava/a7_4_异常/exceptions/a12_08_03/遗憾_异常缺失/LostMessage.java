package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_03.遗憾_异常缺失;

//: exceptions/LostMessage.java
// How an exception can be lost.

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 缺憾:异常缺失
 *异常作为程序出错的标志,绝不应该被忽略,但是它还是可能被轻易的忽略
 * ,要把所有的异常都抛出,全部打包在try-catch子句中
 * @author fengyu
 * @date 2015年8月8日
 */
class VeryImportantException extends Exception {

    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {

    public String toString() {
        return "A trivial exception";
    }
}
//特殊方式的使用finally子句
public class LostMessage {

    private static Logger logger = LogManager.getLogger("LostMessage");
    public static void main(String[] args) {
        logger.debug("Will not show.");
        logger.error("Hello, World!");
        try {

            LostMessage lm = new LostMessage();
            try {
                lm.f();//VeryImportantException方法抛出的异常不见了
            } finally {//被dispose()抛出的HoHumException取代了
                lm.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
} /*
 * Output: A trivial exception
 */// :~
