package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_01.创建类型的实例.exericse.exe24;// generics/ClassTypeCapture24.java
// TIJ4 Chapter Generics, Exercise 24, page 667
// Modify Exercise 21 so that factory objects are held in the Map instead of Class<?>.
//修改练习21,使得工厂对象由一个Map而不是Class<?>持有的

import java.util.HashMap;
import java.util.Map;

import static cn.feng.utils.Print.println;
import static net.mindview.util.Print.print;

interface Factory<T> {

    T create();
}

class Building {}

class House extends Building {}

class BuildingFactory implements Factory<Building> {

    public Building create() {
        return new Building();
    }
}

class HouseFactory implements Factory<House> {

    public House create() {
        return new House();
    }
}

public class ClassTypeCapture24<T> {

    Class<?> kind;
    Map<String, Factory> map;
    public ClassTypeCapture24(Class<?> kind) {
        this.kind = kind;
    }
    public ClassTypeCapture24(Class<?> kind, Map<String, Factory> map) {
        this.kind = kind;
        this.map = map;
    }
    public static void main(String[] args) {
        ClassTypeCapture24<Building> ctt1 = new ClassTypeCapture24<Building>(Building.class);
        println(ctt1.f(new Building()));
        println(ctt1.f(new House()));
        ClassTypeCapture24<House> ctt2 = new ClassTypeCapture24<House>(House.class);
        println(ctt2.f(new Building()));
        println(ctt2.f(new House()));
        ClassTypeCapture24<Building> ct = new ClassTypeCapture24<Building>(Building.class, new HashMap<String, Factory>());
        ct.addType("House", new HouseFactory());
        ct.addType("Building", new BuildingFactory());
        println("ct.map = " + ct.map);
        try {
            Building b = (Building) ct.createNew("Building");
            House h = (House) ct.createNew("House");
            print("b.getClass().getName(): ");
            println(b.getClass().getName());
            print("h.getClass().getName(): ");
            println(h.getClass().getName());
            print("House h is instance House: ");
            println(h instanceof House);
            print("House h is instance of Building: ");
            println(h instanceof Building);
            print("Building b is instance of House: ");
            println(b instanceof House);
            ct.createNew("String");  // String class not available
        } catch (IllegalAccessException e) {
            println("IllegalAccessException in main");
        } catch (InstantiationException e) {
            println("InstantiationException in main");
        }
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
    public void addType(String typename, Factory factory) {
        map.put(typename, factory);
    }
    public Object createNew(String typename) throws IllegalAccessException, InstantiationException {
        if (map.containsKey(typename))
            return map.get(typename).create();
        System.out.println(typename + " class not available");
        return null;
    }
}