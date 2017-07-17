package cn.feng.thinkInJava.a6_1_多态.polymorphism.A8_4_0_1_.协变返回类型;

//: polymorphism/CovariantReturn.java

class Grain {

    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {

    public String toString() {
        return "Wheat";
    }
}

class Mill {

    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {

    /**
     * 协变返回:表示在导出类中被覆盖的方法可以返回基类方法的返回类型的某种导出类型;
     *///返回更为具体的导出类类型
    Wheat process() {
        return new Wheat();
    }
}

/**
 * 协变返回:表示在导出类中被覆盖的方法可以返回基类方法的返回类型的某种导出类型;
 */
public class CovariantReturn {

    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
} /*
 * Output: Grain Wheat
 */// :~
