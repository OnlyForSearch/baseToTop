package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_02.实现参数化接口.exercise;// generics/MultipleInterfaceVariants31.java

// TIJ4 Chapter Generics, Exercise 31, page 697
// Remove all generics from MultipleInterfaceVariants.java and modify
// the code so that the example compiles.
//从MultipleInterfaceVariants.java中移除所有的泛型,并修改代码,使这个示例可以编译
interface Payable {

    float getPay();
}

class Employee implements Payable {

    private float weeklyPay;
    public float getPay() {
        return weeklyPay;
    }
}

class Hourly extends Employee {

    public String name;
    public int hoursWorked;
    protected float hourlyPay;
    Hourly(String s, float pay, int hours) {
        name = s;
        hourlyPay = pay;
        hoursWorked = hours;
    }
    public float getPay() {
        System.out.println("Pay " + name +
                " $" + hourlyPay * hoursWorked);
        return hourlyPay * hoursWorked;
    }
}

public class MultipleInterfaceVariants31 {

    public static void main(String[] args) {
        Hourly h = new Hourly("Joe", 50.00f, 40);
        h.getPay();
    }
}