package cn.feng.thinkInJava.b1_1_枚举类型;

import org.junit.Test;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

//静态导入

//创建enum时候编译器会为你生成一个相关的类,这个类继承自java.lang.Enum
enum Shrubbery {
    GROUND, CRAWLING, HANGING;// 需要定于方法就必须在实例序列的最后添加一个分号";"
    public void method() {

    }
}

public class 基本枚举enum的特性 {

    public static void main(String[] args) {
        for (Shrubbery s : Shrubbery.values()) {
            // ordinal()返回一个int值,这个是每一个enum实例在声明时候的次序
            print(s + " ordinal: " + s.ordinal());
            printnb(s.compareTo(Shrubbery.CRAWLING) + " ");
            printnb(s.equals(Shrubbery.CRAWLING) + " ");
            // 使用==比较enum实例,编译器会自动为你提供equals()和hashCode()方法.Enum实现了Comparable接口所以具有compareTo方法,同时还实现了Serializable
            print(s == Shrubbery.CRAWLING);
            // getDeclaringClass()可以得到其所属的enum类
            print(s.getDeclaringClass());
            // name()方法返回enum声明的名字
            print(s.name());
            print("----------------------");
        }
        // Produce an enum value from a string name:
        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
            print(shrub);
        }
    }

    /**
     * 在switch中使用enum
     */
    @Test
    public void enumSwitch() {
        Shrubbery shrubbery = Shrubbery.CRAWLING;
        switch (shrubbery) {
            case GROUND:
                shrubbery = Shrubbery.HANGING;
                break;
            case HANGING:
                shrubbery = Shrubbery.GROUND;
                break;


        }
    }
}