package cn.feng.thinkInJava.a6_1_多态.polymorphism.test;

public class FiledAccess {

    public static void main(String[] args) {
        Super super1 = new Sub();
        Sub sub = new Sub();
        System.out.println(super1.filed + "" + super1.getFiled() + ";" + sub.getFiled() + sub.filed);

    }
}

class Super {

    public int filed = 0;

    public int getFiled() {
        return filed;
    }

    public void setFiled(int filed) {
        this.filed = filed;
    }


}

class Sub extends Super {

    public int filed = 1;

    public int getFiled() {
        return filed;
    }

    public void setFiled(int filed) {
        this.filed = filed;
    }


}