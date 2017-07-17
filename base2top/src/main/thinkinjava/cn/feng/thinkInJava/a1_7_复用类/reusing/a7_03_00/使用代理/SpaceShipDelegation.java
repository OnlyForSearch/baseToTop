package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_03_00.使用代理;//: reusing/SpaceShipDelegation.java

/**
 * 使用代理:不想暴露所有的方法
 * 使用代理:接口与使用继承得到的接口相同了,但是使用代理时可以拥有更多的控制力,因为
 * 我们可以选择只提供成员对象的方法的某个子集
 */
public class SpaceShipDelegation {

    private String name;
    private SpaceShipControls controls = new SpaceShipControls();
    public SpaceShipDelegation(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");
        protector.forward(100);
    }
    // Delegated methods:
    public void back(int velocity) {
        controls.back(velocity);
    }
    public void down(int velocity) {
        controls.down(velocity);
    }
    public void forward(int velocity) {
        controls.forward(velocity);
    }
    public void left(int velocity) {
        controls.left(velocity);
    }
    public void right(int velocity) {
        controls.right(velocity);
    }
    public void turboBoost() {
        controls.turboBoost();
    }
    public void up(int velocity) {
        controls.up(velocity);
    }
} ///:~
