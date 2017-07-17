package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_01_00.初始化方式_4种方式;

/**SpaceShipControls中所有的方法都暴露在SpaceSihp中*/
public class SpaceShip extends SpaceShipControls {

    private String name;

    public SpaceShip(String name) {

        this.name = name;
    }
    public static void main(String[] args) {

        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }
    public String toString() {

        return name;
    }
} /// :~
