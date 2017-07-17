package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_02_00.链接到外部类;
//: innerclasses/Sequence.java
// Holds a sequence of Objects.

/**
 * 链接到外部类
 *
 * @author fengyu
 * @date 2015年8月8日
 */
//Selector 是一个接口,所以别的类可以按它们自己的方式来实现接口,并且别的方法可以以此接口为参数,来生成更通用的代码
interface Selector {

    /**
     * 检查是否到达末尾了
     */
    boolean end();

    /**
     * 访问当前对象
     *
     * @return
     */
    Object current();

    /**
     * 移动到下一个序列对象
     */
    void next();
}

/**
 * Sequence固定大小的Object数组,以类的形式包装起来
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class Sequence {

    private Object[] items;
    private int next = 0;
    public Sequence(int size) { items = new Object[size]; }
    public static void main(String[] args) {
        Sequence a10_02_00_Sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            a10_02_00_Sequence.add(Integer.toString(i));
        Selector selector = a10_02_00_Sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
    //调用add()方法在末尾添加新的Object元素,只要还有空间
    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }
    public Selector selector() {
        return new SequenceSelector();
    }

    /**
     * SequenceSelector提供 Selector功能的private类
     * 内部类拥有其外围类的所有成员的访问权限,不需要任何特殊条件
     *
     * @author fengyu
     * @date 2015年8月8日
     */
    private class SequenceSelector implements Selector {

        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() {
            if (i < items.length)
                i++;
        }
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~
