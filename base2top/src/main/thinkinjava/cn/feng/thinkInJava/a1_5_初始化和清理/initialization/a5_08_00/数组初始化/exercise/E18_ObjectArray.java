package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_00.数组初始化.exercise;
//: initialization/E18_ObjectArray.java
/**
 * *************** Exercise 18 *****************
 * Create objects to attach to the array of
 * references for Exercise 17.
 * **********************************************
 */

public class E18_ObjectArray {

    public static void main(String args[]) {
        Test[] array = new Test[5];
        for (int i = 0; i < array.length; i++)
            array[i] = new Test(Integer.toString(i));
    }
} /* Output:
String constructor; s = 0
String constructor; s = 1
String constructor; s = 2
String constructor; s = 3
String constructor; s = 4
*///:~

/**
 Integer.toString( ) returns a String object representing the specified integer.
 Can you find a way to convert an integer into a String without using this utility
 method? (Hint: Recall previous discussions of the overloaded String operator
 +.)
 * */