package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_04_00.内部类与向上转型;

//: innerclasses/TestParcel.java

class Parcel4 {
    // 内部类向上转型为接口,隐藏实现的细节,private修饰,只能Parcel4才可以访问

    public Destination destination(String s) {
        return new PDestination(s);
    }
    public Contents contents() {
        return new PContents();
    }

    // private 内部类给类的设计者提供了一种途径,这种方式完全阻止任何依赖类型的编码,并完全隐藏了实现的细节
    //此外,客户端程序员,由于不能访问任何新增的原本不属于公共接口的方法,所以扩展接口是没有价值的
    //这个给java编译器生成一个更高效的代码的机会
    private class PContents implements Contents {

        private int i = 11;

        public int value() {
            return i;
        }
    }

    // 内部类向上转型为接口,隐藏实现的细节private修饰,只能Parcel4以及它的子类才可以访问
    protected class PDestination implements Destination {

        private String label;

        private PDestination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return label;
        }
    }
}

public class TestParcel {

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        // 隐藏实现的细节
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        // Illegal -- can't access private class:
        // ! Parcel4.PContents pc = p.new PContents();
    }
} // /:~
