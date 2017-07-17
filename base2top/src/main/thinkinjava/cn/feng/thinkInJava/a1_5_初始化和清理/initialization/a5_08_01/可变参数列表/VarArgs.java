package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_01.可变参数列表;
//: initialization/VarArgs.java

// Using array syntax to create variable argument lists.
class A {}

/**
 * 可变参数列表
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class VarArgs {

    static void printArray(Object[] args) {
        for (Object obj : args)
            System.out.print(obj + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        printArray(new Object[]{new Integer(47), new Float(3.14), new Double(11.11)});
        printArray(new Object[]{"one", "two", "three"});
        printArray(new Object[]{new A(), new A(), new A()});
    }
} /* Output: (Sample)
47 3.14 11.11
one two three
A@1a46e30 A@3e25a5 A@19821f
*///:~
