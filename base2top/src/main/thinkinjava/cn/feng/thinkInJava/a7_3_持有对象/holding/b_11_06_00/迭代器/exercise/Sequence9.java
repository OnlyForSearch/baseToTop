package cn.feng.thinkInJava.a7_3_持有对象.holding.b_11_06_00.迭代器.exercise;// holding/Sequence9.java
// TIJ4 Chapter Holding, Exercise 9, page 409
// Modify innerclasses/Sequence.java so that Sequence works with an Iterator
// instead of a Selector.
//修改innerclasses/Sequence.java ,使得Sequence中,用Iterator取代Selector
import java.util.ArrayList;
import java.util.Iterator;

public class Sequence9 {

    private ArrayList<Object> items = new ArrayList<Object>();
    public static void main(String[] args) {
        Sequence9 sequence = new Sequence9();
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Iterator it = sequence.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
    public void add(Object x) {
        items.add(x);
    }
    public Iterator iterator() {
        return items.iterator();
    }
}





