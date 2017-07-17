//: typeinfo/pets/PetCreator.java
// Creates random sequences of Pets.
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.a14_03_00;

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 类型转换前先做检查
 *为了使用该工具类能够适应多种不同的实现,我们将其定义为抽象类
 * @author fengyu
 * @date 2015年8月9日
 */
public abstract class PetCreator {

    private Random rand = new Random(47);

    // The List of the different types of Pet to create:
    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() { // Create one random Pet
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {//表示违反了Java的安全机制,在本例中表示构造器为private的情况
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++)
            result[i] = randomPet();
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<Pet>();
        Collections.addAll(result, createArray(size));
        return result;
    }
} // /:~
