package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_03.擦除的兼容性;
//: generics/ErasureAndInheritance.java

/**
 * 擦除的兼容性
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月9日
 */
class GenericBase<T> {

    private T element;
    public void set(T arg) { arg = element; }
    public T get() { return element; }
}

class Derived1<T> extends GenericBase<T> {}
//Derived2继承GenericBase,但是没有任何泛型参数,而编译器不会发出任何警告,警告在set()被调用时候才会出现
class Derived2 extends GenericBase {} // No warning

// class Derived3 extends GenericBase<?> {}
// Strange error:
//   unexpected type found : ?
//   required: class or interface without bounds	

public class ErasureAndInheritance {
    //为来关闭警告,注意这个注解可以放置在可以产生这个类警告的方法之上,而不是整个类,
    //当要关闭警告时候,最好尽量的"聚集",这样就不会因为过于宽泛的关闭警告,而导致意外地遮蔽掉真正的问题
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj); // Warning here!
    }
} ///:~
