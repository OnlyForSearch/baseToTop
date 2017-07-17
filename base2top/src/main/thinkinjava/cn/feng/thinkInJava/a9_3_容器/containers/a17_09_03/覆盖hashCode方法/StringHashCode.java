package cn.feng.thinkInJava.a9_3_容器.containers.a17_09_03.覆盖hashCode方法;
//: containers/StringHashCode.java

/**
 * 覆盖hashCode()
 *覆盖hashCode()

 设计hashCode()时最重要的因素就是：无论何时，对同一个对象调用hashCode()都应该生成同样的值。如果在将一个对象用put()添加进HashMap时产生一个hashCode()，而用get()取出时却产生了另一个hashCode()值，那么就无法重新取得该对象了。

 此外，也不应该使hashCode()依赖于具有唯一性的对象信息，尤其是使用this的值，这只能产生很糟糕的hashCode()。因为这样做无法生成一个新的键，使之与put()中原始的键值对中的键相同。应该使用对象内有意义的识别信息。
 * @author fengyu
 * @date 2015年8月9日
 */
public class StringHashCode {

    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
} /* Output: (Sample)
69609650
69609650
*///:~
