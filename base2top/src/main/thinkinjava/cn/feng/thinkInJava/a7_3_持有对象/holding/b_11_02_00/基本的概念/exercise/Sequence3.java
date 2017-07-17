package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_02_00.基本的概念.exercise;// holding/Sequence3.java
// TIJ4 Chapter Holding, Exercise 3, page 396
/* Modify innerclasses/Sequence.java so that you can add any number
* of elements to it.
*/
/**修改innerclasses/Sequence.java ,使你可以向其中添加任意数量的元素*/
import java.util.ArrayList;

interface Selector {

    boolean end();

    Object current();

    void next();
}

public class Sequence3 {

    private ArrayList<Object> items = new ArrayList<Object>();
    public static void main(String[] args) {
        Sequence3 s3 = new Sequence3();
        for (int i = 0; i < 10; i++)
            s3.add(i);
        Selector selector = s3.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        s3.add(10);
        s3.add(11);
        s3.add(12);
        s3.add(13);
        s3.add(13);
        s3.add("good bye");
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
    public void add(Object x) {
        items.add(x);
    }
    public Selector selector() {
        return new Sequence3Selector();
    }

    private class Sequence3Selector implements Selector {

        private int i = 0;
        public boolean end() {
            return i == items.size();
        }
        public Object current() {
            return items.get(i);
        }
        public void next() {
            i++;
        }
    }
}