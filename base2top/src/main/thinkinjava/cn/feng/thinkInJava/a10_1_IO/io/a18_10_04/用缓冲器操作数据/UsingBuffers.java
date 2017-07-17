package cn.feng.thinkInJava.a10_1_IO.io.a18_10_04.用缓冲器操作数据;

//: io/UsingBuffers.java

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import static net.mindview.util.Print.print;

/**
 * 用缓冲器操作数据
 *注意，ByteBuffer是将数据移进移出通道的唯一方式，并且只能创建一个独立的基本
 * 类型缓冲器，或者使用“as”方法从ByteBuffer中获得。也就是说，不能把基本类型的
 * 缓冲器转换成ByteBuffer。然而，由于可以经由视图缓冲器将基本类型数据移进移出
 * ByteBuffer，所以这也不是什么真正的限制了。
 *
 *
 * 缓冲器的细节

 Buffer由数据和可以高效地访问及操纵这些数据的四个索引（mark（标记）、position（位置）、limit（界限）、capacity（容量））组成。
 方法 	说明
 capacity( ) 	返回缓冲区容量
 clear( ) 	清空缓冲区，将position设置为0，limit设置为容量。我们可以调用此方法覆写缓冲区。
 flip( ) 	将position和limit设置为0，此方法用于准备从缓冲区读取已经写入的数据。
 limit( ) 	返回limit值
 limit(int lim) 	设置limit值
 mark( ) 	将mark设置为position
 reset() 	将position设置为mark
 rewind() 	将position设置为0，mark设置为-1
 position( ) 	返回position值
 position(int pos) 	设置position值
 remaining( ) 	返回(limit - position)
 hasRemaining( ) 	若有介于position和limit之间的元素，则返回true

 io.UsingBuffers的例子可以很好的理解这些方法。尽管可以通过对某个char数组调用wrap()方法（CharBuffer java.nio.CharBuffer.wrap(CharSequence csq)
 ）来直接产生一个CharBuffer，但是在本例中取而代之的是分配一个底层的ByteBuffer，产生的CharBuffer只是ByteBuffer上的一个视图而已。这里要强调的是，我们总是以操纵ByteBuffer为目标，因为它可以和通道进行交互。
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class UsingBuffers {

    private static void symmetricScramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);
        }
    }

    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        print(cb.rewind());
        symmetricScramble(cb);
        print(cb.rewind());
        symmetricScramble(cb);
        print(cb.rewind());
    }
} /*
 * Output: UsingBuffers sUniBgfuefsr UsingBuffers
 */// :~
