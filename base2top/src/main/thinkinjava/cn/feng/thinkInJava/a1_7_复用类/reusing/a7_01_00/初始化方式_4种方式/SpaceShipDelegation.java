package cn.feng.thinkInJava.a1_7_复用类.reusing.a7_01_00.初始化方式_4种方式;
//: reusing/SpaceShipDelegation.java

/**
 * 代理决解了继承父类中的方法暴露在导出类的难题,使用代理时候可以拥有更多的控制力,因为我们可以选择只提供在成员对象中的方法的某个子集
 *
 * @author fengyu
 * @date 2015年8月9日
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
} /// :~
