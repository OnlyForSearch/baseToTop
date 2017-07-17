package cn.feng.thinkInJava.a1_5_初始化和清理.initialization.a5_09_00.枚举类型.exercise;
//: initialization/E21_PaperCurrencyTypesEnum.java
/**
 * *************** Exercise 21 ****************
 * Create an enum of the six lowest denominations
 * of paper currency. Loop through the values()
 * and print each value and its ordinal().
 * *********************************************
 */

enum PaperCurrencyTypes {
    ONE, TWO, FIVE, TEN, TWENTY, FIFTY
}

public class E21_PaperCurrencyTypesEnum {

    public static void main(String args[]) {
        for (PaperCurrencyTypes s : PaperCurrencyTypes.values())
            System.out.println(s + ", ordinal " + s.ordinal());
    }
} /* Output:
ONE, ordinal 0
TWO, ordinal 1
FIVE, ordinal 2
TEN, ordinal 3
TWENTY, ordinal 4
FIFTY, ordinal 5
*///:~