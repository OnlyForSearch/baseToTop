package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_01_00.泛型和类型安全的容器;

//: holding/ApplesAndOrangesWithoutGenerics.java
// Simple container example (produces compiler warnings).
// {ThrowsException}

import java.util.ArrayList;

class Apple {

    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}

class Orange {}


/**
 * 没有用泛型的展示
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class ApplesAndOrangesWithoutGenerics {

    // 这个注解及其参数表示只有有关"不受检查的异常"的警告信息应该被抑制
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        // Not prevented from adding an Orange to apples:
        apples.add(new Orange());
        for (int i = 0; i < apples.size(); i++)
        /**发生运行期错误*/
            ((Apple) apples.get(i)).id();
        // Orange is detected only at run time
    }
} /* (Execute to see output) */// :~
