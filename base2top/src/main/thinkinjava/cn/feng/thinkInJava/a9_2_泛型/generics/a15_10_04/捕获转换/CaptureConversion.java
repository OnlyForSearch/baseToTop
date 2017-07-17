package cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_04.捕获转换;
//: generics/CaptureConversion.java

import cn.feng.thinkInJava.a9_2_泛型.generics.a15_10_01.编译器有多聪明.Holder;

/**
 * 捕获转换:有一种情况特别需要使用<?>而不是原生类型,如果向一个使用<?>的方法传递原生类型,那么对编译器来说,可能会推断出实际类型参数
 * ,使得这个方法可以回转并调用另一个使用这个确切类型的而方法.
 * 捕获转换:因为未指定通配符类型被捕获,并被转换为确切类型
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class CaptureConversion {

    /**
     * f1类型参数都是确切的,没有通配符或边界
     */
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    /**
     * f2参数是一个无界通配符,因此它看起来是未知的
     * 捕获转换这项技术是否可以用于写入,但是这要求要在传递Holder<?>时同时传递以个具体类型,捕获转换只有在这样的的情况下可以工作
     * :即在方法内部,你需要使用确切类型.
     */
    static void f2(Holder<?> holder) {
        //参数类型在调用f2()过程中被捕获,因此它可以在对f1的调用中被使用

        f1(holder); // Call with captured type
        //注意f2不能返回T,因为T对f2来说是未知的,捕获转换十分有趣,但是非常受限
    }

    //	@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<Integer>(1);
        // f1(raw); // Produces warnings
        f2(raw); // No warnings
        Holder rawBasic = new Holder();
        rawBasic.set(new Object()); // Warning
        f2(rawBasic); // No warnings
        // Upcast to Holder<?>, still figures it out:
        Holder<?> wildcarded = new Holder<Double>(1.0);
        f2(wildcarded);
    }
} /*
 * Output: Integer Object Double
 */// :~
