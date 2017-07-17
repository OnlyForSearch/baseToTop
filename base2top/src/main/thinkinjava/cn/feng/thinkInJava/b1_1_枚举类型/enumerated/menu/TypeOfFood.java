//: enumerated/menu/TypeOfFood.java
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.menu;

import cn.feng.thinkInJava.b1_1_枚举类型.enumerated.menu.Food.Appetizer;
import cn.feng.thinkInJava.b1_1_枚举类型.enumerated.menu.Food.Coffee;
import cn.feng.thinkInJava.b1_1_枚举类型.enumerated.menu.Food.Dessert;
import cn.feng.thinkInJava.b1_1_枚举类型.enumerated.menu.Food.MainCourse;

public class TypeOfFood {

    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCINO;
    }
} ///:~
