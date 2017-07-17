package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_07_00.标准异常.exercise;// exceptions/Sequence12.java

// TIJ4 Chapter Exceptions, Excercise 12, page 471
/* Modify innerclasses/Sequence.java so that it throws an appropriate
* exception if you try to put in too many elements.
*/
//修改 innerclasses/Sequence.java,使其在试图向其中放置过多地元素时,抛出一个合适的异常
interface Selector {

    boolean end();

    Object current();

    void next();
}

public class Sequence12 {

    private Object[] items;
    private int next = 0;
    public Sequence12(int size) { items = new Object[size]; }
    public static void main(String[] args) {
        Sequence12 sequence = new Sequence12(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();
        // attempt to add object to full array produces
        // ArrayIndexOutOfBoundsException:
        sequence.add(Integer.toString(10));
    }
    public void add(Object x) throws ArrayIndexOutOfBoundsException {
        // check for full array first:放置过多地元素时,抛出一个合适的异常
        if (next == items.length)
            throw new ArrayIndexOutOfBoundsException();
        // if not full, fill:
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
    }
}