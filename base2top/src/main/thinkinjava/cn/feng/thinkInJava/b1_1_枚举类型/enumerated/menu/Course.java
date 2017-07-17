//: enumerated/menu/Course.java
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.menu;

import net.mindview.util.Enums;

/**
 * 每个Course实例都将其对应的Class对象作为构造器的参数,通过getEnumConstants方法,可以从该
 * Class对象中取得摸个Food子类的所有enum实例,这些实例zairandomSelection中被用到
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection() {
        return Enums.random(values);
    }
} ///:~
