package cn.feng.thinkInJava.a7_2_内部类;

/**
 * @author Administrator
 *         内部类的向上转型
 */
public class Parcel4Demo {

    public static void main(String args[]) {
        Parcel4 parcel4 = new Parcel4();
        InnerClassOne innerClassOne = parcel4.innerClassOne();
        InnerClassTwo innerClassTwo = parcel4.innerClassTwo("Tamac");
        //外部其他类的无法访问私有的其他类
        //Parcel4Demo.PContents p4=parcel4.new PContents();
    }
}

class Parcel4 {

    public static void main(String args[]) {
        Parcel4 parcel4 = new Parcel4();
        InnerClassOne innerClassOne = parcel4.innerClassOne();
        InnerClassTwo innerClassTwo = parcel4.innerClassTwo("Tamac");
        //外部其他类的无法访问私有的其他类
        PContents p4 = parcel4.new PContents();
    }

    //private修饰的，只有Parcel4内部才可以访问通过这种方式可以忘却阻止任何依赖于类型的编码，并完全隐藏了实现的细节
    private class PContents implements InnerClassOne {

        private int value = 2;
        @Override
        public int readValue() {
            return value;
        }

    }

    protected class PDestination implements InnerClassTwo {

        private String label;
        public PDestination(String whereTo) {
            super();
            this.label = whereTo;
        }

        public String readLabel() {

            return label;
        }

    }

    public InnerClassOne innerClassOne() {
        return new PContents();
    }

    public InnerClassTwo innerClassTwo(String whereTo) {
        return new PDestination(whereTo);
    }


}


interface InnerClassOne {

    int readValue();
}

interface InnerClassTwo {

    String readLabel();
}