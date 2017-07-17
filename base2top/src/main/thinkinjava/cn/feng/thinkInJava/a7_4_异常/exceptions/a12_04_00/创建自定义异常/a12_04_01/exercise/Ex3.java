package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_04_00.创建自定义异常.a12_04_01.exercise;// exceptions/Ex3.java

// TIJ4 Chapter Exceptions, Exercise 3, page 452
// Write code to generate and catch an ArrayIndexOutOfBoundsException.
//编写捕获ArrayIndexOutOfBoundsException异常的代码
public class Ex3 {

    private static int[] ia = new int[2];
    public static void main(String[] args) {
        try {
            ia[2] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        }
    }
}