package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_03_02.exercise.exe4;// innerclasses/Sequence4.java
// TIJ4 Chapter Innerclasses, Exercise 4, page 352
/* Add a method to the class Sequence.SequenceSelector that produces the 
* reference to the outer class Sequence.
*//**
 *在Sequence.SequenceSelector类中增加一个方法,它可以生成对外部类Sequence的引用
 * */

interface Selector {

    boolean end();

    Object current();

    void next();
}

public class Sequence4 {

    private Object[] items;
    private int next = 0;
    public Sequence4(int size) { items = new Object[size]; }
    public static void main(String[] args) {
        Sequence4 sequence = new Sequence4(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        // cast and test://测试生成对外部类Sequence的引用
        ((SequenceSelector) selector).sequence4().test();
    }
    // to test SequenceSelector sequence4() in main():
    public void test() { System.out.println("Sequence4.test()"); }
    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }
    public Selector selector() {
        return new SequenceSelector();
    }

    private class SequenceSelector implements Selector {

        private int i = 0;
        public boolean end() { return i == items.length; }
        public Object current() { return items[i]; }
        public void next() {
            if (i < items.length)
                i++;
        }
        // method to produce outer class reference://类中增加一个方法,它可以生成对外部类Sequence的引用
        public Sequence4 sequence4() { return Sequence4.this; }
    }
}