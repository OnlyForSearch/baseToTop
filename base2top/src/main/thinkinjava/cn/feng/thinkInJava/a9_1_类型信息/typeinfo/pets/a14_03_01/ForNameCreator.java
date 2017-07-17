//: typeinfo/pets/ForNameCreator.java
package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.a14_03_01;

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.a14_03_00.PetCreator;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
    // Types that you want to be randomly created:
    private static String[] typeNames = {"typeinfo.pets.Mutt", "typeinfo.pets.Pug", "typeinfo.pets.EgyptianMau", "typeinfo.pets.Manx", "typeinfo.pets.Cymric", "typeinfo.pets" +
            ".Rat", "typeinfo.pets.Mouse", "typeinfo.pets.Hamster"};

    static { loader(); }
    @SuppressWarnings("unchecked")//因为@SuppressWarnings("unchecked")不能直接放置于静态初始化子句上
    private static void loader() {
        try {
            for (String name : typeNames)
                types.add((Class<? extends Pet>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Class<? extends Pet>> types() {return types;}
} ///:~
