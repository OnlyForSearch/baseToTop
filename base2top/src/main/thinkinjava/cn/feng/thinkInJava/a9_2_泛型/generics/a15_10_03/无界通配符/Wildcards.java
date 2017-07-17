package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_03.无界通配符;

//: generics/Wildcards.java
// Exploring the meaning of wildcards.

import cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_01.编译器有多聪明.Holder;


/**使用确切类型来代替通配符类型的好处是,可以使用泛型参数来做更多的事情,但是使用统配符使得你必须接受
 * 范围更宽的参数化类型作为参数
 * */
/**
 * 编译器何时才会关注原生类型和涉及无界通配符的类型之间的差异
 *
 * @author fengyu
 * @date 2015年8月13日
 */// 示例使用了Holder<T>类,它包含接受Holder作为参数的各种方法,但是它们具有不同的形式,作为原生类型,具有具体类型参数以及具有无界通配符参数
public class Wildcards {

    /**
     * 在rawArgs()中,编译器知道Holder是一个泛型类型,因此即使它在这里被表示成一个原生类型,编译器仍旧知道向set()
     * 传递一个Object是不安全的,由于他是原生类型,你可以将任何类型的对象都传递给set(),而这个对象被向上转型为Object,
     * 因此,无论何时,只要使用了原生类型,都会放弃编译期检查,对get()的调用说明了相同的问题,没有任何T类型的对象,因此
     * 结果是一个Object.
     *
     * 对于迁移兼容性,rawArgs()接受所有Holder的不同变体,而不会产生警告
     * //
     * //
     */
    // Raw argument:
    static void rawArgs(Holder holder, Object arg) {
        // holder.set(arg); // Warning:
        // Unchecked call to set(T) as a
        // member of the raw type Holder
        // holder.set(new Wildcards()); // Same warning
        // Can't do this; don't have any 'T':
        // T t = holder.get();
        // OK, but type information has been lost:
        Object obj = holder.get();
    }
    /**
     * 强调了Holder和Holder<?>是不相同的,---揭示了相同的问题,但是它将这些问题作为错误而不是警告,因为原生Holder
     * 将持有任何类型的组合,而Holder<?>将持有具有某种具体类型的同构集合,因此不能只是向其中传递Object.
     * 展示了对于在unboundedArg()中使用误解通配符能够做什么不能做什么所作出的限制
     * */
    // Similar to rawArgs(), but errors instead of warnings:
    static void unboundedArg(Holder<?> holder, Object arg) {
        // holder.set(arg); // Error:
        // set(capture of ?) in Holder<capture of ?>
        // cannot be applied to (Object)
        // holder.set(new Wildcards()); // Same error
        // Can't do this; don't have any 'T':
        // T t = holder.get();
        // OK, but type information has been lost:
        Object obj = holder.get();
    }
    /**使用了确切的泛型参数,没有任何通配符,,如果向一个确切泛型类型(没有通配符)的方法传递一个原生Holder引用
     * ,就会产生一个警告,因为确切的参数期望得到在原生类型中并不存在的信息,如果向exact1传递一个无界引用,就不会任何可以确定返回类型的类型信息.
     * */
    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }
    /**
     * 使用了确切的泛型参数,没有任何通配符,但是exact2有额外的参数,具有最多的限制,因为他希望精确的得到一个Holder<T>,以及一个具有类型T的参数,正由于此,它将产生错误或警告,除非提供确切的参数,有时候这样做很好,但是它过于受限,那么就可以使用
     * 通配符.这取决于是否想要从泛型参数中返回类型确定的返回值(就像wildSubtype),或者是否想要向泛型参数传递类型确切的参数
     * (就像wildSupertype)
     */
    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    /**在wildSubtype中,在Holder类型上的限制被放松为包括持有任何扩展自T的对象的Holder,这还是意味着
     * 如果T是Fruit,那么holder可以是Holder<Apple>,这是合法的,为了防止将Orange放置到Holder<Apple>中,
     * 对set()的调用(或者任何接受这个类型参数为参数的方法的调用)都是不允许的,但是你仍旧知道任何来自Holder<? extends Fruit> 的对象至少是Fruit,因此get()(或者任何产生具有这个类型参数的返回值方法)都是允许的
     * */
    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // holder.set(arg); // Error:
        // set(capture of ? extends T) in
        // Holder<capture of ? extends T>
        // cannot be applied to (T)
        T t = holder.get();
        return t;
    }
    /**
     * 展示了超类通配符,这个方法展示了与wildSubtype()相反的行为:holder可以是任何T的基类型的容器.因此,set()可以接受T,因为
     * 任何可以工作于基类的对象都可以多态地作用与导出类(这里就是T),但是,尝试着调用get()是没有用的,因为由holder持有的类型
     * 可以是任何超类型,因此唯一安全的类型就是Object
     * */
    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        // T t = holder.get(); // Error:
        // Incompatible types: found Object, required T
        // OK, but type information has been lost:
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        // Or:
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;
        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);
        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);
        // Object r1 = exact1(raw); // Warnings:
        // Unchecked conversion from Holder to Holder<T>
        // Unchecked method invocation: exact1(Holder<T>)
        // is applied to (Holder)
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded); // Must return Object
        Long r4 = exact1(bounded);
        // Long r5 = exact2(raw, lng); // Warnings:
        // Unchecked conversion from Holder to Holder<Long>
        // Unchecked method invocation: exact2(Holder<T>,T)
        // is applied to (Holder,Long)
        Long r6 = exact2(qualified, lng);
        // Long r7 = exact2(unbounded, lng); // Error:
        // exact2(Holder<T>,T) cannot be applied to
        // (Holder<capture of ?>,Long)
        // Long r8 = exact2(bounded, lng); // Error:
        // exact2(Holder<T>,T) cannot be applied
        // to (Holder<capture of ? extends Long>,Long)
        // Long r9 = wildSubtype(raw, lng); // Warnings:
        // Unchecked conversion from Holder
        // to Holder<? extends Long>
        // Unchecked method invocation:
        // wildSubtype(Holder<? extends T>,T) is
        // applied to (Holder,Long)
        Long r10 = wildSubtype(qualified, lng);
        // OK, but can only return Object:
        // Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);
        // wildSupertype(raw, lng); // Warnings:
        // Unchecked conversion from Holder
        // to Holder<? super Long>
        // Unchecked method invocation:
        // wildSupertype(Holder<? super T>,T)
        // is applied to (Holder,Long)
        wildSupertype(qualified, lng);
        // wildSupertype(unbounded, lng); // Error:
        // wildSupertype(Holder<? super T>,T) cannot be
        // applied to (Holder<capture of ?>,Long)
        // wildSupertype(bounded, lng); // Error:
        // wildSupertype(Holder<? super T>,T) cannot be
        // applied to (Holder<capture of ? extends Long>,Long)
    }
} /// :~
