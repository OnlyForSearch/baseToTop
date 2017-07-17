package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_09_00.异常的限制;

//: exceptions/StormyInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

interface Storm {

    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}

/**
 * 异常的限制
 * 当覆盖方法的时候，只能抛出在基类方法的异常说明里列出的那些异常（可以不抛出异常，但是如果抛出，必须是基类方法的声明的异常)
 * 。这个限制很有用，因为这意味着，当基类使用的代码应用到派生类对象的时候，一样能够工作（当然，这是面向对象的基本概念），异常也不例外。异常限制对构造器不起作用。派生类构造器的异常说明必须包含基类构造器的异常说明（应该是必须包含基类默认构造器的异常说明，因为基类默认构造器会被默认调用，如果显示的调用其它基类构造器，就需要声明调用的基类构造器的异常了）。派生类构造器不能捕获基类构造器的异常（不能通过try-catch捕获基类抛出的异常，必须使用异常声明）。
 *
 * @author fengyu
 * @date 2015年8月8日
 */
class BaseballException extends Exception {}

class Foul extends BaseballException {}

class Strike extends BaseballException {}

/**
 * Inning类的构造器和event()都申明了将抛出异常,但是实际上没有抛出任何异常*
 * 这种方式可以使你强制用户去捕获可能在覆盖后的event()版本中增强的异常
 */
abstract class Inning {

    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {
        // Doesn't actually have to throw anything
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
    } // Throws no checked exceptions
}

class StormException extends Exception {}

class RainedOut extends StormException {}

class PopFoul extends Foul {}
/**Storm包含了一个在Inning中定义的方法event()和不在Inning中的方法,这两个方法都抛出新的异常RainOut,
 * StormyInning如果在继承Inning的同时又实现了Storm接口,那么Sotrm里的event()方法就不能改变Inning中的
 * event()方法的异常接口,否则的话使用基类的时候就不能判断是否捕获了正确的异常
 * */
public class StormyInning extends Inning implements Storm {
    //异常限制对构造器没有任何作用.
    // OK to add new exceptions for constructors, but you
    // must deal with the base constructor exceptions:
    public StormyInning() throws RainedOut, BaseballException {
    //    子类的异常说明必须包含基类构造器的异常说明,子类构造器不能捕获基类构造器 抛出的异常
    }

    public StormyInning(String s) throws BaseballException {
    }

    /**
     *
     在main()方法中,可以看到,如果处理的刚好是StormyInning对象的话,编译器会强制要求你捕获这个类所抛出的所有异常,
     但是将它向上转型成基类类型,那么编译器会正确的要求你捕获基类的异常,所有的这些的限制都是为了能更为强壮的异常
     处理代码
     * */
    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        // Strike not thrown in derived version.
        try {
            // What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
            // You must catch the exceptions from the
            // base-class version of the method:
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
    // Regular methods must conform to base class:编译不通过的原因是:它抛出了异常,Inning.walk()并没有声明此异常
    /**如果编译器允许的话,在调用Inning.walk()的时候不做异常处理,而把它替换成Inning的子类时候,这个方法就有可能
     * 抛出异常,程序就失灵了.
     *
     * 通过强制派生类遵守基类的方法的异常声明,对象的可替换性得到了保证
     * */
    // ! void walk() throws PopFoul {} //Compile error


    // Interface CANNOT add exceptions to existing
    // methods from the base class:
    // ! public void event() throws RainedOut {}
    // If the method doesn't already exist in the
    // base class, the exception is OK:
    public void rainHard() throws RainedOut {
    }

    //覆盖后的event()表明,子类方法可以不抛出任何异常,即使父类定义了异常,
    // You can choose to not throw any exceptions,
    // even if the base version does:
    public void event() {
    }
    // Overridden methods can throw inherited exceptions:
    public void atBat() throws PopFoul {
    }
} // /:~
