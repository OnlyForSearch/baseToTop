package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_12_04.把被检查的异常转换为不检查的异常.exercise;// exceptions.Ex27.java

// TIJ4 Chapter Exceptions, Exercise 27, page 500
// Modify Exercise 3 to convert the exception to a Runtime Exception.
//修改练习3,将异常装换为RuntimeException
public class Ex27 {

    private static int[] ia = new int[2];
    public static void main(String[] args) {
        try {
            ia[2] = 3;
        } catch (ArrayIndexOutOfBoundsException e) { // convert to RuntimeException:
            throw new RuntimeException(e);
        }
    }
}