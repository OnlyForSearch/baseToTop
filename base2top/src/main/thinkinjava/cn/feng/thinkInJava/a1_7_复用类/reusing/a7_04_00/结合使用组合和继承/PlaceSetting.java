package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_04_00.结合使用组合和继承;

//: reusing/PlaceSetting.java
// Combining composition & inheritance.

import static net.mindview.util.Print.print;

/**
 * 结合使用组合和继承
 *
 * @author fengyu
 * @date 2015年8月9日
 */
class Plate {

    Plate(int i) {
        print("Plate constructor");
    }
}

class DinnerPlate extends Plate {

    DinnerPlate(int i) {
        super(i);
        print("DinnerPlate constructor");
    }
}

class Utensil {

    Utensil(int i) {
        print("Utensil constructor");
    }
}

class Spoon extends Utensil {

    Spoon(int i) {
        super(i);
        print("Spoon constructor");
    }
}

class Fork extends Utensil {

    Fork(int i) {
        super(i);
        print("Fork constructor");
    }
}

class Knife extends Utensil {

    Knife(int i) {
        super(i);
        print("Knife constructor");
    }
}

// A cultural way of doing something:
class Custom {

    Custom(int i) {
        print("Custom constructor");
    }
}

public class PlaceSetting extends Custom {

    private Spoon sp;
    private Fork frk;
    private Knife kn;
    private DinnerPlate pl;

    public PlaceSetting(int i) {
        //编译器强制初始化基类,并且要求你在构造器起始处就要这么做,但是它并不监督你必须去将成员对象初始化,因此这一点必须注意
        super(i + 1);
        sp = new Spoon(i + 2);
        frk = new Fork(i + 3);
        kn = new Knife(i + 4);
        pl = new DinnerPlate(i + 5);
        print("PlaceSetting constructor");
    }

    public static void main(String[] args) {
        PlaceSetting x = new PlaceSetting(9);
    }
} /* Output:
Custom constructor
Utensil constructor
Spoon constructor
Utensil constructor
Fork constructor
Utensil constructor
Knife constructor
Plate constructor
DinnerPlate constructor
PlaceSetting constructor
*///:~
