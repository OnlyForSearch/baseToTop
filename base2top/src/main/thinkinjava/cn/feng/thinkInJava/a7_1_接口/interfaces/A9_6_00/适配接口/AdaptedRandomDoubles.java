package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_6_00.适配接口;
//: interfaces/AdaptedRandomDoubles.java
// Creating an adapter with inheritance.

import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * 适配器模式
 * 被适配的类可以通过继承和实现Readable接口创建,因此,使用interface关键字提供伪多重继承机制
 * ,在这种方式中,我们可以在任何现有类之上添加新的接口,所以意味着让方法接受接口类型,是一种让任何类都可以对该方法进行适配的的方式
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {

    private int count;
    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomDoubles(7));
        while (s.hasNextDouble())
            System.out.println(s.nextDouble() + " ");
    }
    public int read(CharBuffer cb) {
        if (count-- == 0)
            return -1;
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }
} /* Output:
0.7271157860730044 0.5309454508634242 0.16020656493302599 0.18847866977771732 0.5166020801268457 0.2678662084200585 0.2613610344283964
*///:~
