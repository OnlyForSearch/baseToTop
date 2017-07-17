package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_04_00.values方法的神秘之初;
//: enumerated/UpcastEnum.java
// No values() method if you upcast an enum

enum Search {HITHER, YON}

/**
 * 是由编译器添加的static 方法,将enum实例向上转型为Enum,那么values()就不可访问了
 *
 * @author fengyu
 * @date 2015年8月14日
 */
public class UpcastEnum {

    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER; // Upcast
        // e.values(); // No values() in Enum

        for (Enum en : e.getClass().getEnumConstants())
            System.out.println(en);
    }
} /* Output:
HITHER
YON
*///:~
