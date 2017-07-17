package cn.feng.thinkInJava.a0_0基础.Object;

// TIJ4 Chapter Object, Exericise 1, page 89
// object/PrimitiveTest.java
// Create a class containing an int and a char that are not intitialized
// and print their values to verify that Java performs default initialization.
//创建一个类,它包含一个int域和一个char域,它们都没有被初始化,将它们的值打印出来,以验证java执行默认初始化
public class PrimitiveTest {

    static int i;
    static char c;
    public static void main(String[] args) {
        System.out.println("int = " + i);
        System.out.println("char = [" + c+"]");
    }
}