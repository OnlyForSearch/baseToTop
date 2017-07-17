package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_01.杠杆利用类型参数推断;
//: generics/SimplerPets.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Person;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import net.mindview.util.New;

import java.util.List;
import java.util.Map;

/**
 * 参数类型推断,避免重复的泛型参数列表,类型推断只对赋值操作有效
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class SimplerPets {

    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> petPeople = New.map();
        // Rest of the code is the same...
    }
} ///:~
