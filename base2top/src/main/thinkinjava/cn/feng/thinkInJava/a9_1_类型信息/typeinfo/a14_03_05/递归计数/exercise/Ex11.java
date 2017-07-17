package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_03_05.递归计数.exercise;// typeinfo/Ex11.java
// TIJ4 Chapter Typeinfo, Exercise 11, page 582
// Add Gerbil to the typeinfo.pets library and modify all the examples
// in this chapter to adapt to this new class.

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pets;
import net.mindview.util.TypeCounter;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

/* 	
    // Made following additions:
	// typeinfo.pets package:
	// typeinfo/pets/Gerbil.java
	package typeinfo.pets;
	public class Gerbil extends Rodent {
		public Gerbil(String name) { super(name); }
		public Gerbil() { super(); }
	} 
	// ForNameCreator.java
	"typeinfo.pets.Gerbil" 
	// PetCount.java
	if(pet instanceof Gerbil) counter.count("Gerbil"); 
	// LiteralPetCreator.java
	Gerbil.class 
*/

/**
 * 在typeinfo.pets.类库中添加Gerbil,并修改本章中所有示例,让它们适应还这个新类
 */
public class Ex11 {

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        print();
        print(counter);
    }
}