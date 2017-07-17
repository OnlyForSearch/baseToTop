package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_03.显式的类型说明;

//: generics/ExplicitTypeSpecification.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Person;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import net.mindview.util.New;

import java.util.List;
import java.util.Map;

/**
 * 显式的类型说明:在泛型方法中显式的指明类型,不过这语法很少用
 *显示的类型说明，在点操作符和方法名之间插入尖括号，然后把类型置于尖括号内。

 类.<实际类型参数…>method()
 对象.<实际类型参数…>method()
 this.<实际类型参数…>method()
,只有非赋值语句时候
 * @author fengyu
 * @date 2015年8月9日
 */
public class ExplicitTypeSpecification {

    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        //使用静态方法必须在点操作符之前加类名
        f(New.<Person, List<Pet>>map());
    }
} // /:~
