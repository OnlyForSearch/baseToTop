package cn.feng.thinkInJava.a9_2_泛型.generics.a15_17_02.讲一个方法应用于序列.exercise;// generics/Apply40.java
// {main: ApplyTest40}
// TIJ4 Chapter Generics, Exercise 40, page 731
// Add a speak() method to all the pets in tyepinfo.pets. Modify Apply.java to call the speak
// method for a heterogeneous collection of Pet.
//想typeinfo.java中的所有宠物,中添加一个speak()方法,修改Apple.java使得我们可以对Pet的异构集合调用speak()

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Dog;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pets;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static net.mindview.util.Print.print;

public class Apply40 {

    public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq)
                f.invoke(t, args);
        } catch (Exception e) {
            // Failures are programmer errors
            throw new RuntimeException(e);
        }
    }
}

class FilledList<T> extends ArrayList<T> {

    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++)
                // Assumes default constructor:
                add(type.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest40 {

    public static void main(String[] args) throws Exception {
        // Random list of 10 pets:
        List<Pet> pets = Pets.arrayList(10);
        print("Random pets: " + pets);
        // Applies the overridden methods:
        Apply40.apply(pets, Pet.class.getMethod("speak"));
        // FilledList contains only one type:
        Apply40.apply(new FilledList<Pet>(Dog.class, 5), Pet.class.getMethod("speak"));
    }
}