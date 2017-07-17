package cn.feng.thinkInJava.a9_2_泛型.generics.a15_08_02.泛型数组;

//: generics/ArrayOfGeneric.java

/**
 * @author fengyu
 * @date 2015年8月12日
 */
public class ArrayOfGeneric {

    static final int SIZE = 100;
    // 所有数组无论它们持有的类型如何,都具有相同的结构(每个数组的槽位的尺寸和数组的布局,那么看起来你应该能够创建一个Object数组,并将其转型为所希望的数组类型)
    //事实上可以编译,但是不能运行,它将产生ClassCastException

    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Compiles; produces ClassCastException:
        // ! gia = (Generic<Integer>[])new Object[SIZE];
        // Runtime type is the raw (erased) type:

        //数组将跟踪它们的实际类型,而这个类型是在数组被创建的时候确定的,因此,即使gia已经被转型为Generic<Integer>[],但是这个信息只存在于编译期(如果没有
        //@SuppressWarnings("unchecked"),将得到转型的警告),运行时仍旧是Object数组,这将引发问题.
        //成功创建泛型数组的唯一方式就是创建一个被擦除类型的新数组,然后对其转型
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<Integer>();
        // ! gia[1] = new Object(); // Compile-time error
        // Discovers type mismatch at compile time:
        // ! gia[2] = new Generic<Double>();
    }
} /*
     * Output: Generic[]
	 */// :~
