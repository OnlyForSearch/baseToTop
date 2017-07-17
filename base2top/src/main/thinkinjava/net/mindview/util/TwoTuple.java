//: net/mindview/util/TwoTuple.java
package net.mindview.util;

/**
 * 一个元组类库
 *元组，它是将一组对象直接打包存储于其中的一个单一对象。这个容器对象允许读取其中元素，但是不允许存放新的对象。
 * @param <A>
 * @param <B>
 * @author fengyu
 * @date 2015年8月9日
 */
public class TwoTuple<A, B> {

    //这是不是违反了java安全性原则吗?
    //first和second应该声明为private,然后提供get和set方法才对
    //看着这个例子中的安全性:客户端程序可以读取first或second对象,然后可以随心所以的使用这两个对象
    //但是,它们却无法将其他值赋予给first和second.因为final的声明为了你买了相同的安全保险,而且这种格式更简洁
    public final A first;
    public final B second;
    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
} ///:~
