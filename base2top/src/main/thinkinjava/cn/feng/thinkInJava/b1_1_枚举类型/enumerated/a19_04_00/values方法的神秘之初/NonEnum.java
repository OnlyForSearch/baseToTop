package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_04_00.values方法的神秘之初;
//: enumerated/NonEnum.java

/**
 * 实现，而非继承

 所有enum都继承了Enum类，所以enum不能再继承其他类，但是可以实现一个或多个接口。
 */
public class NonEnum {

    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            //getEnumConstants是Class上的方法,所以可以对不是枚举的类调用此方法,只不过返回null,所以当你试图使用其返回的结果时就会发生异常
            for (Object en : intClass.getEnumConstants())
                System.out.println(en);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
} /* Output:
java.lang.NullPointerException
*///:~
