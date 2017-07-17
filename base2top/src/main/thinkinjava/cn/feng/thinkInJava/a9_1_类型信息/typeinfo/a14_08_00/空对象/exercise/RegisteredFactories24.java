package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_08_00.空对象.exercise;// typeinfo/RegisteredFactories24.java
// TIJ4 Chapter Typeinfo, Exercise 24, page 606
// Add Null Objects to RegisteredFactories.java.
//在RegisteredFactories.java.添加Null对象

/*class Part {

    static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
    private static Random rand = new Random();

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
        partFactories.add(new NullPart.Factory());
    }
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
    public String toString() {
        return getClass().getSimpleName();
    }


}*/
/*

class NullPart extends Part implements Null {

    public static final Part NULL = new NullPart();
private NullPart() { super(); }
    public String toString() { return "NULL"; }
}


public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.Factory<NullPart> {

        public NullPart create() { return (NullPart) NULL; }
    }
   class Filter extends Part {}


class FuelFilter extends Filter {

    // Create a Class Factory for each specific type:
    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.Factory<FuelFilter> {

        public FuelFilter create() { return new FuelFilter(); }
    }
}

class AirFilter extends Filter {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.Factory<AirFilter> {

        public AirFilter create() { return new AirFilter(); }
    }
}

class CabinAirFilter extends Filter {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.Factory<CabinAirFilter> {

        public CabinAirFilter create() { return new CabinAirFilter(); }
    }
}

class OilFilter extends Filter {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.Factory<OilFilter> {

        public OilFilter create() { return new OilFilter(); }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.Factory<FanBelt> {

        public FanBelt create() { return new FanBelt(); }
    }
}

class GeneratorBelt extends Belt {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.Factory<GeneratorBelt> {

        public GeneratorBelt create() { return new GeneratorBelt(); }
    }
}

class PowerSteeringBelt extends Belt {

    public static class Factory implements cn.feng.thinkInJava.a9_1_类型信息.typeinfo.Factory<PowerSteeringBelt> {

        public PowerSteeringBelt create() { return new PowerSteeringBelt(); }
    }
}

public class RegisteredFactories24 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println(Part.createRandom());
    }
}*/
