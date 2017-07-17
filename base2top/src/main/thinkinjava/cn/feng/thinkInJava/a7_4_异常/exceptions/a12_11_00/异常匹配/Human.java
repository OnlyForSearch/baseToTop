package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_11_00.异常匹配;
//: exceptions/Human.java
// Catching exception hierarchies.

class Annoyance extends Exception {}

class Sneeze extends Annoyance {}

/**
 * 异常的匹配
 *抛出异常的时候，异常处理系统会按照代码的书写顺序找出”最近“的处理程序。查找的时候不要求抛出的异常同
 * 处理程序所声明的异常完全匹配。派生类的对象也可以匹配其基类的处理程序。如果把捕获基类的catch子句放在
 * 最前面，就会把派生类的异常全给”屏蔽“掉。
 * @author fengyu
 * @date 2015年8月8日
 */
public class Human {

    public static void main(String[] args) {
        // Catch the exact type:
        try {
            throw new Sneeze();
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
        // Catch the base type:
        try {
            throw new Sneeze();
        } catch (Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
} /* Output:
Caught Sneeze
Caught Annoyance
*///:~
