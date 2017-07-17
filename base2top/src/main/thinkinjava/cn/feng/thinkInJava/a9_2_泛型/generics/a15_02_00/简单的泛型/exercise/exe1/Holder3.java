package cn.feng.thinkInJava.a9_2_泛型.generics.a15_02_00.简单的泛型.exercise.exe1;// generics/Holder3.java
// TIJ4 Chapter Generics, Exercise 1, page 621
// Use Holder3 with the typeinfo.pets library to show that a Holder3 that is
// specified to hold a base type can also hold a derived type.
//配合使用typeinfo.pets类库,用Holder3来证明,如果指定Holder3可以持有某个基类类型,那么他也能持有导出类型

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Dog;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;

public class Holder3<T> {

    private T a;
    public Holder3(T a) { this.a = a; }
    public static void main(String[] args) {
        Holder3<Pet> h3 = new Holder3<Pet>(new Pet());
        Pet a = h3.get(); // No cast needed
        System.out.println(h3.get());
        // can also hold a subclass of Pet:
        h3.set(new Dog());
        System.out.println(h3.get());
        // can also hold a sububclass of Pet:
        //h3.set(new Gerbil());
        //System.out.println(h3.get());
    }
    public void set(T a) { this.a = a; }
    public T get() { return a; }
}