package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_07_01.接口内部的类;

//: innerclasses/ClassInInterface.java
// {main: ClassInInterface$Test}

/**
 * 接口内部的类
 *
 *
 * 如果想要创建某些公共代码,使得他们可以被某个接口的所有不同实现类所公用,那么使用
 * 接口内部的嵌套类会显得方便
 */
public interface ClassInInterface {

    void howdy();

    /**
     * 嵌套类可以作为接口的一部分,放到接口中 任何类都是pubilc static 的
     * ,因为类是static的,只是将嵌套类置于接口的命名空间内的,并不违反规则,
     *///内部类实现其外围接口
    class Test implements ClassInInterface {

        public static void main(String[] args) {
            new Test().howdy();
        }
        public void howdy() {
            System.out.println("Howdy!");
        }
    }
} /*
 * Output: Howdy!
 */// :~
