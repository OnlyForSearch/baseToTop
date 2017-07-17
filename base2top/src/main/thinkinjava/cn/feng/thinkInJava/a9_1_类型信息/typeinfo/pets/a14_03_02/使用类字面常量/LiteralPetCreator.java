//: typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.a14_03_02.使用类字面常量;

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.*;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.a14_03_00.PetCreator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使用类字面常量
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class LiteralPetCreator extends PetCreator {
    
    // No try block needed.
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class,
            EgyptianMau.class, Manx.class, Cymric.class, Rat.class, Mouse.class, Hamster.class));
    // Types for random creation:
    private static final List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());
    public static void main(String[] args) {
        System.out.println(types);
    }
    public List<Class<? extends Pet>> types() {
        return types;
    }
} /*
 * Output: [class typeinfo.pets.Mutt, class typeinfo.pets.Pug, class
 * typeinfo.pets.EgyptianMau, class typeinfo.pets.Manx, class
 * typeinfo.pets.Cymric, class typeinfo.pets.Rat, class typeinfo.pets.Mouse,
 * class typeinfo.pets.Hamster]
 */// :~
