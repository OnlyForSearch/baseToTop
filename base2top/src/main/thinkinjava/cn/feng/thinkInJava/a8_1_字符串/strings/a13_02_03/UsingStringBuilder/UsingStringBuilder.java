package cn.feng.thinkInJava.a8_1_字符串.strings.a13_02_03.UsingStringBuilder;

//: strings/UsingStringBuilder.java

import java.util.Random;

public class UsingStringBuilder {

    public static Random rand = new Random(47);
    public static void main(String[] args) {
        UsingStringBuilder usb = new UsingStringBuilder();
        System.out.println(usb);
    }

    /**如果要在toString()方法中使用循环,那么最好自己创建一个StringBuilder对象,用它来构造最终的结果
     * ,最终的结果使用append()语句一点点的拼接起来的
     * */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }
} /*
 * Output: [58, 55, 93, 61, 61, 29, 68, 0, 22, 7, 88, 28, 51, 89, 9, 78, 98, 61,
 * 20, 58, 16, 40, 11, 22, 4]
 */// :~
