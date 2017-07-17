package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_03_04.动态的instanceof;

//: typeinfo/PetCount3.java
// Using isInstance()

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pets;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.a14_03_02.使用类字面常量.LiteralPetCreator;
import net.mindview.util.MapData;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * 动态的instanceof
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class PetCount3 {

    public static void main(String[] args) {
        PetCounter petCount = new PetCounter();
        for (Pet pet : Pets.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");
            petCount.count(pet);
        }
        print();
        print(petCount);
    }

    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer> {

        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes, 0));//首先预加载了LiteralPetCreator.allTypes的类型
        }

        public void count(Pet pet) {
            // Class.isInstance() eliminates instanceofs:
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet())
                // Class.isInstance() 动态地测试对象的途径
                if (pair.getKey().isInstance(pet))
                    put(pair.getKey(), pair.getValue() + 1);
        }

        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
                result.append(pair.getKey().getSimpleName());
                result.append("=");
                result.append(pair.getValue());
                result.append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }
    }
} /* Output:
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Pet=20, Dog=6, Cat=9, Rodent=5, Mutt=3, Pug=3, EgyptianMau=2, Manx=7, Cymric=5, Rat=2, Mouse=2, Hamster=1}
*///:~
