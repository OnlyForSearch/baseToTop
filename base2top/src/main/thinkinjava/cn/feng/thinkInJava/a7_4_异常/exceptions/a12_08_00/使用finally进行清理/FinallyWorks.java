package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_00.使用finally进行清理;
//: exceptions/FinallyWorks.java
// The finally clause is always executed.

class ThreeException extends Exception {}
//决解java的异常不允许我们回到异常抛出的地点
public class FinallyWorks {

    static int count = 0;//放置一个static类型的计数器或者别的装置,使循环在放弃以前能尝试一定的次数,这将使程序的健壮性更上一个台阶
    public static void main(String[] args) {
        while (true) {
            try {
                // Post-increment is zero first time:
                if (count++ == 0)
                    throw new ThreeException();
                System.out.println("No exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {//无论异常是否被抛出,finally都会被执行
                System.out.println("In finally clause");
                if (count == 2)
                    break; // out of "while"
            }
        }
    }
} /* Output:
ThreeException
In finally clause
No exception
In finally clause
*///:~
