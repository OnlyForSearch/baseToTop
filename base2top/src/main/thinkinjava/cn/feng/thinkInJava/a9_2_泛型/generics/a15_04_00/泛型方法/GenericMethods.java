package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_00.泛型方法;

//: generics/GenericMethods.java

/**
 * 泛型方法:是否拥有泛型方法与其所在类是否是泛型没有关系,泛型方法能够独立类存在而产生变化
 * 基本指导原则:无论何时只要你能做到,你就应该尽量使用泛型方法,因为它可以使事情更清楚明白,
 * 另外,对于一个static的方法而言,需要使用泛型能力,就必须使其成为泛型方法
 *
 * @author fengyu
 * @date 2015年8月9日
 */

/**GenericMethods并不是参数化的,尽管这个类和其内部方法可以被同时参数化*/
public class GenericMethods {

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        //使用泛型方法时候通常不必指明参数类型,因为编译器会为我们找出具体的类型,这称为类型参数推断(type argumens inference)
        gm.f("");
        //如果调用f()时传入基本类型,自动打包机制就会介入其中,将基本类型的值包装为对应的对象,事实上
        //自动打包避免了我们自己不得不编写出来的代码
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
    //定义泛型方法,只需将泛型参数列表置于返回值之前
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
} /*
     * Output: java.lang.String java.lang.Integer java.lang.Double
	 * java.lang.Float java.lang.Character GenericMethods
	 */// :~
