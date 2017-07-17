package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_04_01.注册工厂.exercise.exe14;// typeinfo/RegisteredClasses14.java
// TIJ4 Chapter Typeinfo, Exercise 14, page 586
/* A constructor is a kind of factory method. Modify RegisteredFactories.java
* so that instead of using explicit factories, the class object is stored in
* the List, and newInstance() is used to create each object.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 构造器就是一种工厂方法,修改RegisteredFactories.java.使其不要使用显式的工厂,然后调用其create()方法
 * ,并使用newInstance()来创建对象
 */
class Part {

    static List<Class<? extends Part>> partClasses = new ArrayList<Class<? extends Part>>();
    private static Random rand = new Random();

    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        partClasses.add(FuelFilter.class);
        partClasses.add(AirFilter.class);
        partClasses.add(CabinAirFilter.class);
        partClasses.add(OilFilter.class);
        partClasses.add(FanBelt.class);
        partClasses.add(PowerSteeringBelt.class);
        partClasses.add(GeneratorBelt.class);
    }
    public static Part createRandom() {
        int n = rand.nextInt(partClasses.size());
        try {
            return partClasses.get(n).newInstance();//,并使用newInstance()来创建对象
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {

    // Create a Class Factory for each specific type:
    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<FuelFilter> {

        public FuelFilter create() { return new FuelFilter(); }
    }
}

class AirFilter extends Filter {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<AirFilter> {

        public AirFilter create() { return new AirFilter(); }
    }
}

class CabinAirFilter extends Filter {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<CabinAirFilter> {

        public CabinAirFilter create() { return new CabinAirFilter(); }
    }
}

class OilFilter extends Filter {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<OilFilter> {

        public OilFilter create() { return new OilFilter(); }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<FanBelt> {

        public FanBelt create() { return new FanBelt(); }
    }
}

class GeneratorBelt extends Belt {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<GeneratorBelt> {

        public GeneratorBelt create() { return new GeneratorBelt(); }
    }
}

class PowerSteeringBelt extends Belt {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<PowerSteeringBelt> {

        public PowerSteeringBelt create() { return new PowerSteeringBelt(); }
    }
}

public class RegisteredClasses14 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}