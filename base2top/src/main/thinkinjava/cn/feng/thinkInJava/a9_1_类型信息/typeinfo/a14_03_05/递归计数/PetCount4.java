package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_03_05.递归计数;
//: typeinfo/PetCount4.java

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pets;
import net.mindview.util.TypeCounter;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/**
 * 递归计数
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class PetCount4 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        print();
        print(counter);
    }
} /* Output: (Sample)
Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
{Mouse=2, Dog=6, Manx=7, EgyptianMau=2, Rodent=5, Pug=3, Mutt=3, Cymric=5, Cat=9, Hamster=1, Pet=20, Rat=2}
*///:~
