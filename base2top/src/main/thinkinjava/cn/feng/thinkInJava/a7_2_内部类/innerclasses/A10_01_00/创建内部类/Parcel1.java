package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_01_00.创建内部类
        ;

//: innerclasses/Parcel1.java
// Creating inner classes.
//创建内部类就是:把类的定义置于外围类的里面
public class Parcel1 {

    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }
    // Using inner classes looks just like
    // using any other class, within Parcel1:
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
    }

    class Contents {

        private int i = 11;
        public int value() { return i; }
    }

    class Destination {

        private String label;
        Destination(String whereTo) {
            label = whereTo;
        }
        String readLabel() { return label; }
    }
} /* Output:
Tasmania
*///:~
