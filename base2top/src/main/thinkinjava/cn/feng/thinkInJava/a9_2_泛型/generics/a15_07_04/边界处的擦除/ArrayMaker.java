package cn.feng.thinkInJava.a9_2_泛型.generics.a15_07_04.边界处的擦除;

//: generics/ArrayMaker.java

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 边界处的动作
 *
 * @param <T>
 * @author fengyu
 * @date 2015年8月9日
 */
public class ArrayMaker<T> {

    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }
    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
    @SuppressWarnings("unchecked")
    T[] create(int size) {
        //即使Kind被存储为Class<T>,擦除也意味着他实际将被存储为Class,没有任何参数.
        //因此在使用它时候,例如在创建数组时候,Array.newInstance()实际上并未拥有king所蕴含的类型信息,,因此不会产生具体的结果,因此必须转型
        //这将产生一条令你无法满意的警告
        return (T[]) Array.newInstance(kind, size);//在泛型中创建数组推荐使用Array.newInstance()
    }
} /* Output:
[null, null, null, null, null, null, null, null, null]
*///:~
