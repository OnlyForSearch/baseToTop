package cn.feng.thinkInJava.a0_0.exercise;

/**
 * Created by Administrator on 2015/9/19.
 * 展示自动包装功能对所有的基本类型和包装类型都起作用
 */
public class Exe9 {

    public static void main(String[] args) {

        boolean bool = false;
        byte b = 12;
        char ch = 'c';
        short s = 14;
        int i = 56;
        long l = 254l;
        float f = 242.1f;
        double d = 24.254;

        Boolean bools = bool;
        System.out.println("Boolean = " + bools);
        System.out.println("boolean = " + bool);

        Byte bytes = b;
        System.out.println("Byte = " + bytes);
        System.out.println("byte = " + b);

        Character character = ch;
        System.out.println("character = " + character);
        System.out.println("char= " + ch);

        Short sh = s;
        System.out.println("Short= " + sh);
        System.out.println("short= " + s);

        Integer integer = i;
        System.out.println("integer = " + integer);
        System.out.println("in = " + i);
        Long lon = l;
        System.out.println("Long = " + lon);
        System.out.println("long = " + l);

        Float fl = f;
        System.out.println("Float = " + fl);
        System.out.println("float = " + f);

        Double doub = d;
        System.out.println("Double= " + doub);
        System.out.println("double= " + d);


    }

}
