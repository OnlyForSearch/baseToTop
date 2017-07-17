package cn.feng.thinkInJava.a9_2_泛型.generics.a15_04_04.可变参数和泛型方法;

//: generics/GenericVarargs.java

import java.util.ArrayList;
import java.util.List;

/**
 * 可变参数与泛型方法可以很好的共存
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class GenericVarargs {
        //展示了与标准类库中java.util.Arrays.asList()相同的功能
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<T>();
        for (T item : args)
            result.add(item);
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
} /*
 * Output: [A] [A, B, C] [, A, B, C, D, E, F, F, H, I, J, K, L, M, N, O, P, Q,
 * R, S, T, U, V, W, X, Y, Z]
 *///:~
