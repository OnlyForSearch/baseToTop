package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_02.逆变;
//: generics/SuperTypeWildcards.java

import java.util.List;


/**
 * 逆变
 *超类型通配符。可以声明通配符是由某个特定类的任何基类来界定的，方法是指定<? super MyClass>，可以使用类型参数：<? super T>(不能声明类型参数为<T super MyClass>)
 * Apple是下界，这样你就知道向其中添加Apple或Apple的子类型是安全的，而添加Fruit是不安全的了。

 小结：
 子类型通配符(指定上界)：如<? extends Apple>，Apple是指定的上界，表示可以接收Apple或Apple的任意子类, 但是现在还不确定是什么。这种不确定性带来的问题是无法写入（传递给一个方法）。
 超类型通配符(指定下界)：如<? super Apple>，Apple是指定的下界，表示可以接收Apple或Apple的任意超类, 但是现在还不确定是什么。确保是Apple或Apple的任意超类，所以可以写入。
 * @author fengyu
 * @date 2015年8月9日
 */
public class SuperTypeWildcards {

    //超类通配符
    //参数Apple是Apple的某种基类型的List,这样就知道向其中添加的Apple或Apple的子类型是安全的,,但是既然Apple是下界,那么就知道向
    //	这样的List中添加是Fruit是不安全的,因为将使这个List敞开扣子,从而可以向其中添加一个非Apple类型的对象,而这是违反静态类型安全的
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }
} ///:~

class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}