package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_00.创建自定义异常.a12_04_01.exercise;// exceptions/Ex5.java
// TIJ4 Chapter Exceptions, Exercise 5, page 452
/* Create you own resumption-like behavior using a while loop that repeats
* until an exception is no longer thrown.
*/

/**
 * 使用while循环建立类似"恢复模型"的异常处理行为,,它将不断重复,直到异常不再抛出
 */
public class Ex5 {

    static int x = 5;
    private static int[] ia = new int[2];
    public static void main(String[] args) {
        while (true) {
            try {
                ia[x] = 1;
                System.out.println(ia[x]);
                break;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Caught ArrayIndexOutOfBoundsException");
                e.printStackTrace();
                x--;
            } finally {
                System.out.println("Are we done yet?");
            }
        }
        System.out.println("Now, we're done.");
    }
}