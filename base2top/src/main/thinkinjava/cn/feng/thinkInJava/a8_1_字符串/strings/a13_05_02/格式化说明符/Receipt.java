package cn.feng.thinkInJava.a8_1_字符串.strings.a13_05_02.格式化说明符;

//: strings/Receipt.java

import java.util.Formatter;

/**
 * 1
 * 格式化说明符
 * <p>
 * 在插入数据时，如果想要控制空格与对齐，你需要更精细复杂的更是修饰符。以下是其抽象的语法：
 * %[argument_index$][flags][width][.precision]conversion
 * <p>
 * <p>
  1 ,可选的 argument_index 是一个十进制整数，用于表明参数在参数列表中的位置。
 第一个参数由 “1$” 引用，第二个参数由 “2$” 引用，依此类推。

 2,可选 flags 是修改输出格式的字符集。有效标志集取决于转换类型。在默认的情况下
 ，数据是右对齐的，不过可以通过使用“-”编制来改变对齐方向。

 3,可选 width 是一个非负十进制整数，表明要向输出中写入的最少字符数。
 必要时添加空格以达到指定长度。

  4, 可选 precision 是一个非负十进制整数，通常用来限制字符数。
 特定行为取决于转换类型。与width相对应用来指定最大尺寸。precision的意义也不同。
 在将precision应用于String时，它表示打印String时输出字符串的最大数量。
 而在将precision应用于浮点数时，它表示小数部分要显示出来的位数（默认是6
 位小数），如果小数位过多则舍入，太少则在尾补零。由于整数没有小数部分，
 所以precision无法应用于整数。


 5,所需 conversion 是一个表明应该如何格式化参数的字符。给定参数的有效转换集取决于参数的数据类型。
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class Receipt {

    private double total = 0;
    private Formatter f = new Formatter(System.out);
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
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
} /*
 * Output: Item Qty Price ---- --- ----- Jack's Magic Be 4 4.25 Princess Peas 3
 * 5.10 Three Bears Por 1 14.29 Tax 1.42 ----- Total 25.06
 */// :~
