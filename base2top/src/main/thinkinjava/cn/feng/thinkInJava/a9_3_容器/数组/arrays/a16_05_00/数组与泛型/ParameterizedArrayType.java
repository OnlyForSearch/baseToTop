package cn.feng.thinkInJava.a9_3_容器.数组.arrays.a16_05_00.数组与泛型;
//: arrays/ParameterizedArrayType.java

/**
 * 数组与泛型:数组与泛型不能很好地结合,你不能实例化具有参数化类型的数组
 * Pee<Banane>[] peels=new Peel<Banal>[10];//错误
 * 擦除会移除参数类型信息,而数组必须知道他们所持有的确切类型,以强制保证类型安全,但是可以参数化数组本身类型
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月9日
 *///参数化数组本身的类型
class ClassParameter<T> {

    public T[] f(T[] arg) { return arg; }
}

//参数化数组本身的类型
/**使用参数化方法而不使用参数化类的方便之处在于:你不必为需要应用的每种不同
 * 的类型都使用一个参数去实例化这个类,并且你可以将其定义为静态的,当然你不能
 * 总是选择使用参数化方法而不是参数化类,但是他因该是首选的
 * */
class MethodParameter {

    public static <T> T[] f(T[] arg) { return arg; }
}

public class ParameterizedArrayType {

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);
        ints2 = MethodParameter.f(ints);
        doubles2 = MethodParameter.f(doubles);
    }
} ///:~
