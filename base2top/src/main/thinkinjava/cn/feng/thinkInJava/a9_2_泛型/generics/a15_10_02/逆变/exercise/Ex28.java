package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_02.逆变.exercise;// generics/Ex28.java
// TIJ4 Chapter Generics, Exercise 28, page 685
/* Create a generic class Generic1<T> with a single method that takes an argument
* of type T. Create a second generic class Generic2<T> with a single method that 
* returns an argument of type T. Write a generic method with a contravariant 
* argument of the first generic class that calls its method. Write a second generic
* method with a covariant argument of the second class that calls its method. Test
* using the typeinfo.pets library.
*/

import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Cat;
import cn.feng.thinkInJava.a9_1_类型信息.typeinfo.pets.Pet;

/**
 * 创建一个泛型类Generic1<T> ,他只有一个方法,接受一个T类型的参数,创建第二个泛型类 Generic2<T>
 * ,它只有一个方法将返回类型T的参数,编写一个泛型方法,它具有调用第一个泛型类的方法的逆变参数,
 * <p>
 * 编写第二个泛型方法,它具有调用第二个泛型类的方法的协变参数,使用 typeinfo.pets类库进行测试
 */
public class Ex28 {

    public static void main(String[] args) {
        Ex28 e28 = new Ex28();
        e28.contra(e28.new Generic1<Pet>(), new Cat("kitty"));
        e28.co(e28.new Generic2<Pet>());
    }
    <T> void contra(Generic1<? super T> g1t, T t) {
        g1t.take(t);
    }
    <T> T co(Generic2<? extends T> g2t) {
        return g2t.give();
    }

    class Generic1<T> {

        T t;
        void take(T t) { this.t = t; }
    }

    // note that generic type T in Generic1 is not the same as type T in Generic2
    class Generic2<T> {

        T t;
        T give() { return t; }
    }
}