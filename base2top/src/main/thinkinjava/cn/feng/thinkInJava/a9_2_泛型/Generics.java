package cn.feng.thinkInJava.a9_2_泛型;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Generics {

    /**
     * 泛型方法
     * 泛型方法使得该方法能够独立于类而产生变化.基本指导原则:无论何时只要你能做到,那么就应该使用泛型方法
     * 另外,对于static方法而言,无法访问泛型类的类型参数,所以,如果static需要使用泛型的能力,就必须使其成为泛型方法
     * <p>
     * <p>
     * 使用泛型方法时候,通常不必指明参数类型,因为编译器会为我们找出具体的类型:称为类型参数推断
     */
    //基本类型无法作为类型参数,但是会通过自动包装机制转化成包装类
    //将泛型参数列表置于返回值之前
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    //显示类型说明,很少用到
    static void f(Map<String, List<String>> maps) {}

    //可变参数列表与泛型方法可以共存
    public static <T> List<T> makeList(T... args) {
        List<T> resutltList = new ArrayList<>();
        for (T t : args) {
            resutltList.add(t);
        }
        return resutltList;
    }
    @Test
    //擦除 
    //List<String>.class 与 List<Integer>.class相同类型的 运行时对应的类型都是list
    public void erasedTypeEquivalence() {
        List<String> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        System.out.println(a.getClass() == b.getClass());
    }

}

/**
 * 泛型接口
 */

interface GenericsInterface<T> {

    T next();
}
