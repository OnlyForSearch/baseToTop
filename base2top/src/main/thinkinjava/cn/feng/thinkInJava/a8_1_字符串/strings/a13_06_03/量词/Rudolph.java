package cn.feng.thinkInJava.a8_1_字符串.strings.a13_06_03.量词;
//: strings/Rudolph.java

public class Rudolph {

    public static void main(String[] args) {
        for (String pattern : new String[]{"Rudolph", "[rR]udolph", "[rR][aeiou][a-z]ol.*", "R.*"})
            System.out.println("Rudolph".matches(pattern));
    }
} /* Output:
true
true
true
true
*///:~
