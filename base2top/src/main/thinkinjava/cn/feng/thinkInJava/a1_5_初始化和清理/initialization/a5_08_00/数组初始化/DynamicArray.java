package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_08_00.数组初始化;
//: initialization/DynamicArray.java

// Array initialization.
public class DynamicArray {

    public static void main(String[] args) {
        Other.main(new String[]{"fiddle", "de", "dum"});
    }
}

class Other {

    public static void main(String[] args) {
        for (String s : args)
            System.out.print(s + " ");
    }
} /* Output:
fiddle de dum
*///:~
