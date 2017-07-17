package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_12_04.把被检查的异常转换为不检查的异常.exercise;// exceptions/StormyInning29.java
// TIJ4 Chapter Exceptions, Exercise 29, page 500
/* Modify all the exception types in StormyInning.java so that they extend
* RuntimeException, and show that no exception specifications or try blocks
* are necessary. Remove the '//!' comments and show how the methods can be 
* compiled without specifications.
*/

interface Storm {

    public void event();

    public void rainHard();
}

/**
 * 修改StormyInning.java中所有的异常类型,使它们扩展RuntimeException,并展示这里
 * 不需要任何异常说明或try语句块.移除"//!"注释并展示这些方法不需要说明就可以编译
 */
class BaseballException extends RuntimeException {}

class Foul extends RuntimeException {}

class Strike extends RuntimeException {}

abstract class Inning {

    public Inning() {}
    public void event() {}
    public abstract void atBat();
    public void walk() {}
}

class StormException extends RuntimeException {}

class RainedOut extends RuntimeException {}

class PopFoul extends RuntimeException {}

public class StormyInning29 extends Inning implements Storm {

    public StormyInning29() {}
    public StormyInning29(String s) {}
    public static void main(String[] args) {
        StormyInning29 si = new StormyInning29();
        si.atBat();
        // What happens if you upcast?
        Inning i = new StormyInning29();
        i.atBat();
    }
    public void walk() {}
    public void event() {}
    public void rainHard() {}
    public void atBat() {}
}