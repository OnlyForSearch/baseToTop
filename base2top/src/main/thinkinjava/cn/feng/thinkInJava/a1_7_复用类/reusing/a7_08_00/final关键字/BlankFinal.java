package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_08_00.final关键字;
//: reusing/BlankFinal.java

// "Blank" final fields.

/**
 * 空白final:被声明为final但是又未给定初始化值的域,
 * 必须在域的定义处或者每个构造器中用表达式对final进
 * 行赋值,这个也是final在使用前被初始化的原因
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Poppet {

    private int i;

    Poppet(int ii) {
        i = ii;
    }
}

public class BlankFinal {

    private final int i = 0; // Initialized final
    //空白final的关键字使用上提供了更大的灵活性,为此一个类中的final域可以做到根据对象的不同
    //却又有恒定不变的特性
    private final int j; // Blank final
    private final Poppet p; // Blank final reference
    // Blank finals MUST be initialized in the constructor:

    public BlankFinal() {
        j = 1; // Initialize blank final
        p = new Poppet(1); // Initialize blank final reference
    }

    public BlankFinal(int x) {
        j = x; // Initialize blank final
        p = new Poppet(x); // Initialize blank final reference
    }

    public static void main(String[] args) {
        new BlankFinal();
        new BlankFinal(47);
    }
} /// :~
