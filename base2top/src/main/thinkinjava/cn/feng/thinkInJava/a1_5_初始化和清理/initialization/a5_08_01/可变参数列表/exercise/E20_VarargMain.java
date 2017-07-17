package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_01.可变参数列表.exercise;
//: initialization/E20_VarargMain.java
// {Args: These, are, some, strings}
/**
 * *************** Exercise 20 *****************
 * Create a main() that uses varargs instead
 * of the ordinary main() syntax. Print all the
 * elements in the resulting args array. Test it
 * with various numbers of command-line
 * arguments.
 * **********************************************
 */

public class E20_VarargMain {

    public static void main(String... args) {
        E19_VarargStringArray.printStrings(args);
    }
} /* Output:
These,
are,
some,
strings
*///:~