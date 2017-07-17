package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_03_00.使用代理;//: reusing/SpaceShip.java

public class SpaceShip extends SpaceShipControls {//使用继承
    private String name;
    public SpaceShip(String name) { this.name = name; }
    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }
    public String toString() { return name; }
} ///:~
