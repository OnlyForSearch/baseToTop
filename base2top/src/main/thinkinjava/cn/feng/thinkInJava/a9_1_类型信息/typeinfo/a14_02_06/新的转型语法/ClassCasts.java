package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_02_06.新的转型语法;

//: typeinfo/ClassCasts.java
class Building {}

/**
 * 新的转型语法(非常少用)
 *Java SE5还添加了用于Class引用的转型语法，即cast()方法：
 * @author fengyu
 * @date 2015年8月9日
 */
class House extends Building {}

public class ClassCasts {

    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House) b; // ... or just do this.
    }
} // /:~
