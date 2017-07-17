package cn.feng.thinkInJava.a1_1_数据类型.test;

public class Test1 {


    public static void main(String[] args) {

        Parameter parameter = new Parameter();
        System.out.println(parameter.i);
        System.out.println(parameter.c);
        ATypeName aTypeName = new ATypeName();

        DateOnly dateOnly = new DateOnly();
        dateOnly.i = 99;
        dateOnly.d = 99.99;
        dateOnly.b = false;
        System.out.println(dateOnly);
    }
}

class DateOnly {

    int i;
    double d;
    boolean b;
    @Override
    public String toString() {
        return "DateOnly [i=" + i + ", d=" + d + ", b=" + b + "]";
    }
}

class Parameter {

    int i;
    char c;
}

class ATypeName {

}