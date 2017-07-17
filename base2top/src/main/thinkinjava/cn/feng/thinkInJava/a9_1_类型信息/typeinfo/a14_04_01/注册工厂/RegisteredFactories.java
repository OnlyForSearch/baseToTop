package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_04_01.注册工厂;

//: typeinfo/RegisteredFactories.java
// Registering Class Factories in the base class.

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Part {

    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    private static Random rand = new Random(47);

    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    /**
     * 参数的类型
     */
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Filter extends Part {}

class FuelFilter extends Filter {

    // Create a Class Factory for each specific type:
    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<FuelFilter> {

        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<AirFilter> {

        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<CabinAirFilter> {

        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<OilFilter> {

        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<FanBelt> {

        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<GeneratorBelt> {

        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.factory.a14_04_00.Factory<PowerSteeringBelt> {

        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}

/**
 * *注册工厂
 *
 * @author fengyu
 * @date 2015年8月12日
 */
public class RegisteredFactories {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
} /* Output:
GeneratorBelt
CabinAirFilter
GeneratorBelt
AirFilter
PowerSteeringBelt
CabinAirFilter
FuelFilter
PowerSteeringBelt
PowerSteeringBelt
FuelFilter
*///:~
