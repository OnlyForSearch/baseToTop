package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_07_00.使用接口组织枚举;
//: enumerated/SecurityCategory.java
// More succinct subcategorization of enums.

import net.mindview.util.Enums;

/**
 * 将一个enum嵌套在另一个enum内
 *我们希望从enum继承子类，是由于有时我们希望扩展远enum中的元素，
 * 有时是因为我们希望使用子类将一个enum中的元素进行分组。

 在一个接口的内部，创建实现该接口的枚举，以此将元素进行分组，
 可以达到将枚举元素分类组织的目的。
 * @author fengyu
 * @date 2015年8月14日
 */
enum SecurityCategory {
    STOCK(Security.Stock.class), BOND(Security.Bond.class);
    Security[] values;
    SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " +
                    category.randomSelection());
        }
    }
    public Security randomSelection() {
        return Enums.random(values);
    }
    /**
     * Security 接口的作用将其所包含的enum组合成一个公共类型,,这一点是必要的,然后,SecurityCategory才能将
     * Security中的enum作为其构造器参数使用,以起到组织的效果
     */
    interface Security {

        enum Stock implements Security {SHORT, LONG, MARGIN}

        enum Bond implements Security {MUNICIPAL, JUNK}
    }
} /* Output:
BOND: MUNICIPAL
BOND: MUNICIPAL
STOCK: MARGIN
STOCK: MARGIN
BOND: JUNK
STOCK: SHORT
STOCK: LONG
STOCK: LONG
BOND: MUNICIPAL
BOND: JUNK
*///:~
