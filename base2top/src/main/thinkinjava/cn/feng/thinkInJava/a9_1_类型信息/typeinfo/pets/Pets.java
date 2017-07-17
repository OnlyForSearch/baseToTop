//: typeinfo/pets/Pets.java
// Facade to produce a default PetCreator.
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets;

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.a14_03_00.PetCreator;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.a14_03_02.使用类字面常量.LiteralPetCreator;

import java.util.ArrayList;
/**创建一个使用LiteralPetCreator的外观*/
public class Pets {

    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    /**
     * 返回一个填充了随机选取Pet对象的ArrayList
     */
    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
} // /:~
