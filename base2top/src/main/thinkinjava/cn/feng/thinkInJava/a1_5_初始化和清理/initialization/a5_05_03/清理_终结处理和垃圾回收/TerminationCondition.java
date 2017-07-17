package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_05_03.清理_终结处理和垃圾回收;
//: initialization/TerminationCondition.java

// Using finalize() to detect an object that
// hasn't been properly cleaned up.

/**
 * 清理:终结处理和垃圾回收
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Book {        //checkedOut检查过了

    boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    protected void finalize() {
        if (checkedOut)
            System.out.println("Error: checked out");
        // Normally, you'll also do this:
        // super.finalize(); // Call the base-class version
    }
}

public class TerminationCondition {

    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup:
        novel.checkIn();
        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();
    }
} /* Output:
Error: checked out
*///:~
