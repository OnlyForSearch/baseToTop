//: enumerated/menu/Meal.java
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.menu;

public class Meal {

    /**
     * 使用接口组织枚举
     *
     * @param args
     * @author fengyu
     * @date 2015年8月9日
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
} /* Output:
SPRING_ROLLS
VINDALOO
FRUIT
DECAF_COFFEE
---
SOUP
VINDALOO
FRUIT
TEA
---
SALAD
BURRITO
FRUIT
TEA
---
SALAD
BURRITO
CREME_CARAMEL
LATTE
---
SOUP
BURRITO
TIRAMISU
ESPRESSO
---
*///:~
