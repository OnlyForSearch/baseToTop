//: enumerated/menu/Food.java
// Subcategorization of enums within interfaces.
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.menu;

/**
 * 在一个接口内部,创建实现该接口的枚举,以此将元素进行分组,可以达到将枚举元素分类组织的目的
 *
 * @author fengyu
 * @date 2015年8月14日
 */
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
} ///:~
