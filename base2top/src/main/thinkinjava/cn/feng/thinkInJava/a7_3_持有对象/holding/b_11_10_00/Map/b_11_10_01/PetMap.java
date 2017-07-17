package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_10_00.Map.b_11_10_01;
//: holding/PetMap.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Cat;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Dog;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Hamster;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Print.print;

public class PetMap {

    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<String, Pet>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        print(petMap);
        Pet dog = petMap.get("My Dog");
        print(dog);
        print(petMap.containsKey("My Dog"));//判断是否包含某个键
        print(petMap.containsValue(dog));//判断是否包含某个值
    }
} /* Output:
{My Cat=Cat Molly, My Hamster=Hamster Bosco, My Dog=Dog Ginger}
Dog Ginger
true
true
*///:~
