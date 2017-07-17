//: net/mindview/util/CollectionData.java
// A Collection filled with data using a generator object.
package cn.feng.thinkInJava.数据生成器;

import java.util.ArrayList;

/**
 * @param <T>
 * @author 只为追寻
 *         它将创建一个Collection对象,该对象中所填充的元素有生成器gen产生,而元素的数量有构造器的第二个参数确定
 *         所有的Collection子类型都拥有toArray方法,该方法将使用Collection中的元素来填充参数数组
 */
//这是一个适配器模式的实例
public class CollectionData<T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }
    // A generic convenience method:
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
} ///:~
