package cn.feng.thinkInJava.a8_1_字符串.strings.a13_02_01;

//: strings/WhitherStringBuilder.java
public class WhitherStringBuilder {

    public String implicit(String[] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i++)
            result += fields[i];
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++)
            result.append(fields[i]);
        return result.toString();
    }
} // /:~
