package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_01_01.将静态导入用与enum;//: enumerated/Burrito.java

/**
 * 将静态导入用于enum

 如果使用静态导入不会使你的代码难以理解，那么使用静态导入还是有好处的。

 在定义enum的同一个文件中，这种技巧无法使用；在默认包中定义enum，这种技巧也无法使用。
 */
public class Burrito {

    Spiciness degree;
    public Burrito(Spiciness degree) { this.degree = degree;}
    /**
     * 将静态导入用于enum :import static能够将enum实例的标识符带入当前的命名空间无需,所以无需再用enum修饰实例
     * 在定义enum的同一个文件中,无法使用,如果是在默认包中定义enum,这种技巧也无法使用
     *
     * @param args
     * @author fengyu
     * @date 2015年8月9日
     */
    public static void main(String[] args) {
        System.out.println(new Burrito(Spiciness.NOT));
        System.out.println(new Burrito(Spiciness.MEDIUM));
        System.out.println(new Burrito(Spiciness.HOT));
    }
    public String toString() { return "Burrito is " + degree;}
} /* Output:
Burrito is NOT
Burrito is MEDIUM
Burrito is HOT
*///:~
