package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_02_00.向enum中添加新方法.覆盖enum的方法;
//: enumerated/SpaceShip.java

/**
 * 覆盖enum的方法
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
    public static void main(String[] args) {
        for (SpaceShip s : values()) {
            System.out.println(s);
        }
    }
    //覆盖toString()方法给我们提供了另一种方式来为枚举实例生成不同字符串描述信息
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;//首字符大写
    }
} /* Output:
Scout
Cargo
Transport
Cruiser
Battleship
Mothership
*///:~
