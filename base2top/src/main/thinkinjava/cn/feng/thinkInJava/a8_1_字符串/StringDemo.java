package cn.feng.thinkInJava.a8_1_字符串;

import cn.feng.utils.Print;
import org.junit.Test;

import java.util.Formatter;

/**
 * String 对象具有只读性,所以指向它的任何引用都不可能改变它的值
 */
public class StringDemo {

    private Formatter f = new Formatter(System.out);
    private double total = 0;
    // immutable 不可变的
    @Test
    public void immutable() {
        String string = "aBc";
        Print.println(string);
        // 这种方式产生大量需要垃圾回收的对象
        String string2 = "a" + "b" + "c" + "d";
        this.upCase(string);
        Print.println(string);
    }
    // String 对象作为方法的参数的时候传递的是引用
    public String upCase(String s) {
        // s是局部引用,方法结束s就是消失了
        return s.toUpperCase();
    }
    /**
     * 格式化输出
     */
    @Test
    public void simpleFormat() {
        int i = 5;
        double y = 5.332542;
        System.out.println("[" + i + " " + y + "]");
        System.out.printf("[%d %f]\n", i, y);
        System.out.format("[%d %f]\n", i, y);
        /* printf与format是等价的 */
    }
    /**
     * 在Java中所有格式化功能都由java.util.Formatter类处理 Formatter转换
     */
    @Test
    public void formatterDemo() {
        // 创建一个Formatter对象的时候需要向其构造器传递一些信息,告诉它最终的结果将向哪里输出
        Formatter f = new Formatter(System.out);
        f.format("%s 直接 上升%d", "水流", 5);
        /* 格式化说明符 */
        // 抽象语法 :%[argument_index$][flags][width][.precision]conversion
        // 可选的 argument_index 是一个十进制整数，用于表明参数在参数列表中的位置。第一个参数由 "1$" 引用，第二个参数由
        // "2$" 引用，依此类推。
        // 可选 flags 是修改输出格式的字符集。有效标志集取决于转换类型。
        // width: 是一个非负十进制整数，表明要向输出中写入的最少字符数。
        // 最小尺寸,Formatter对象通过在必要时添加空格,来保证达到一个长度,默认数据右对齐,可以使用"-改变"标志改变对齐方向
        // precision:是一个非负十进制整数，通常用来限制字符数。特定行为取决于转换类型。
        // 最大尺寸,应用于String时候表示输出的字符的最大数量,浮点数表示要显示出来的位数,默认是6位,如果小数位过多则舍入,太少则补0,由于整数没有小数位所以不能应用,应用会报异常
        // 所需 conversion 是一个表明应该如何格式化参数的字符。给定参数的有效转换集取决于参数的数据类型。

        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
        f.format("%-15.15s %5d %10.2f\n", "Jack's Magic Beans", 4, 4.25);
        printTitle();
        print("Jack's Magic Beans", 4, 4.25);
        print("Princess Peas", 3, 5.1);
        print("Three Bears Porridge", 1, 14.29);
        printTotal();
		/*
		 * 常用类型转换 d :整数（十进制） c:Unicode字符 ；b boolen值 s :String f：浮点型 （十进制）
		 * e:浮点数（科学计数） x:整数（十六进制） h:散列码 （十六进制） % 字符（%）
		 */
        // 用来表示日期和时间类型的格式说明符的语法如下：
        // %[argument_index$][flags][width]conversion
        // 可选的 argument_index、flags 和 width 的定义同上。
        //
        // 所需的 conversion 是一个由两字符组成的序列。第一个字符是 't' 或
        // 'T'。第二个字符表明所使用的格式。这些字符类似于但不完全等同于那些由 GNU date 和 POSIX strftime(3c)
        // 定义的字符。
        //
        // 与参数不对应的格式说明符的语法如下：
        // %[flags][width]conversion
        // 可选 flags 和 width 的定义同上。
        //
        // 所需的 conversion 是一个表明要在输出中所插内容的字符。

    }
    public void printTitle() {
        f.format("%-15s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-15s %5s %10s\n", "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format("%-15.15s %5d %10.2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format("%-15s %5s %10.2f\n", "Tax", "", total * 0.06);
        f.format("%-15s %5s %10s\n", "", "", "-----");
        f.format("%-15s %5s %10.2f\n", "Total", "", total * 1.06);
    }

    @Test
    public void StringFormat() {
        try {

            throw new StringDemo().new MyException(2, 3, "Wirte faile");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    class MyException extends Exception {

        public MyException(int tId, int qId, String message) {

            super(String.format("(t%d,q%d) %s", tId, qId, message));
        }

    }

}
