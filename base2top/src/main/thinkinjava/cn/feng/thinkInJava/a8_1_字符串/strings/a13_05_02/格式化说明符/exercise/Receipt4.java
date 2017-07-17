package cn.feng.thinkInJava.a8_1_字符串.strings.a13_05_02.格式化说明符.exercise;// strings/Receipt4.java
// TIJ4 Chapter Strings, Exercise 4, page 518
/* Modify Receipt.java so that the widths are all controlled by a single
* set of constant values. The goal is to allow you to easily change a width
* by changing a single value in one place.
*/

import java.util.Formatter;

//修改Receipt.java,令所有的宽度都有一个常量来控制,目的是使用宽度的改变更容易,只需修改一处的值就可以
public class Receipt4 {

    private static final int W1 = 15;
    private static final int W2 = 5;
    private static final int W3 = 10;
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private String s1 = "%-" + W1 + "s %" + W2 + "s %" + W3 + "s\n";
    private String s2 = "%-" + W1 + ".15s %" + W2 + "d %" + W3 + ".2f\n";
    private String s3 = "%-" + W1 + "s %" + W2 + "s %" + W3 + ".2f\n";
    public static void main(String[] args) {
        Receipt4 receipt = new Receipt4();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
    public void printTitle() {
        f.format(s1, "Item", "Qty", "Price");
        f.format(s1, "----", "---", "-----");
    }
    public void print(String name, int qty, double price) {
        f.format(s2, name, qty, price);
        total += price;
    }
    public void printTotal() {
        f.format(s3, "Tax", "", total * 0.06);
        f.format(s1, "", "", "-----");
        f.format(s3, "Total", "", total * 1.06);
    }
}
