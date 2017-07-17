//: enumerated/menu/Meal2.java
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.menu;

import net.mindview.util.Enums;

/**
 * 重新组织了代码,不过多数情况下,这种方式使你的代码具有更清晰的结构
 *
 * @author fengyu
 * @date 2015年8月14日
 */
public enum Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    Meal2(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Meal2 meal : Meal2.values()) {
                Food food = meal.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
    public Food randomSelection() {
        return Enums.random(values);
    }
    public interface Food {

        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROLLS
        }

        enum MainCourse implements Food {
            LASAGNE, BURRITO, PAD_THAI,
            LENTILS, HUMMOUS, VINDALOO
        }

        enum Dessert implements Food {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE,
            FRUIT, CREME_CARAMEL
        }

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
            LATTE, CAPPUCCINO, TEA, HERB_TEA
        }
    }
} /* Same output as Meal.java *///:~
