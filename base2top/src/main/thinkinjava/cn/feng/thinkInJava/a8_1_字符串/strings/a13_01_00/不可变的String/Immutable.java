package cn.feng.thinkInJava.a8_1_字符串.strings.a13_01_00.不可变的String;

//: strings/Immutable.java

import static net.mindview.util.Print.print;

//不可变的String
public class Immutable {

    //当把q传递给upcase()方法时候,实际上传递的是引用的一个拷贝
    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        print(q); // howdy
        String qq = upcase(q);
        print(qq); // HOWDY
        print(q); // howdy
    }
} /*
 * Output: howdy HOWDY howdy
 */// :~
