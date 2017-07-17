package cn.feng.thinkInJava.a8_1_字符串.strings.a13_05_00.格式化输出;
//: strings/SimpleFormat.java

/**
 * 格式化输出
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class SimpleFormat {

    public static void main(String[] args) {
        int x = 5;
        double y = 5.332542;
        // The old way:
        System.out.println("Row 1: [" + x + " " + y + "]");
        // The new way:
        System.out.format("Row 1: [%d %f]\n", x, y);
        // or
        System.out.printf("Row 1: [%d %f]\n", x, y);
    }
} /* Output:
Row 1: [5 5.332542]
Row 1: [5 5.332542]
Row 1: [5 5.332542]
*///:~
