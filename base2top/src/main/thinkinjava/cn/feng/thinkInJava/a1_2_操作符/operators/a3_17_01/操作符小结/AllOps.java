package cn.feng.thinkInJava.a1_2_操作符.operators.a3_17_01.操作符小结;
//: operators/AllOps.java
// Tests all the operators on all the primitive data types
// to show which ones are accepted by the Java compiler.

/**
 * 操作符小结
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class AllOps {

    // To accept the results of a boolean test:
    void f(boolean b) {}
    //对boolean进行的操作十分有限,只能赋值它true或false,并判断它为真还是为假,不能进行任何其他运算
    void boolTest(boolean x, boolean y) {
        // Arithmetic operators:  算术运算符：
        //! x = x * y;
        //! x = x / y;
        //! x = x % y;
        //! x = x + y;
        //! x = x - y;
        //! x++;
        //! x--;
        //! x = +y;
        //! x = -y;
        // Relational and logical: 关系和逻辑：
        //! f(x > y);
        //! f(x >= y);
        //! f(x < y);
        //! f(x <= y);
        f(x == y);
        f(x != y);
        f(!y);
        x = x && y;
        x = x || y;
        // Bitwise operators:    位运算符：
        //! x = ~y;
        x = x & y;
        x = x | y;
        x = x ^ y;
        //! x = x << 1;
        //! x = x >> 1;
        //! x = x >>> 1;
        // Compound assignment:
        //! x += y;
        //! x -= y;
        //! x *= y;
        //! x /= y;
        //! x %= y;
        //! x <<= 1;
        //! x >>= 1;
        //! x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! char c = (char)x;
        //! byte b = (byte)x;
        //! short s = (short)x;
        //! int i = (int)x;
        //! long l = (long)x;
        //! float f = (float)x;
        //! double d = (double)x;
    }
    void charTest(char x, char y) {
        // Arithmetic operators:
        x = (char) (x * y);
        x = (char) (x / y);
        x = (char) (x % y);
        x = (char) (x + y);
        x = (char) (x - y);
        x++;
        x--;
        x = (char) +y;
        x = (char) -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = (char) ~y;
        x = (char) (x & y);
        x = (char) (x | y);
        x = (char) (x ^ y);
        x = (char) (x << 1);
        x = (char) (x >> 1);
        x = (char) (x >>> 1);
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        byte b = (byte) x;
        short s = (short) x;
        int i = (int) x;
        long l = (long) x;
        float f = (float) x;
        double d = (double) x;
    }
    void byteTest(byte x, byte y) {
        // Arithmetic operators:
        x = (byte) (x * y);
        x = (byte) (x / y);
        x = (byte) (x % y);
        x = (byte) (x + y);
        x = (byte) (x - y);
        x++;
        x--;
        x = (byte) +y;
        x = (byte) -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = (byte) ~y;
        x = (byte) (x & y);
        x = (byte) (x | y);
        x = (byte) (x ^ y);
        x = (byte) (x << 1);
        x = (byte) (x >> 1);
        x = (byte) (x >>> 1);
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        short s = (short) x;
        int i = (int) x;
        long l = (long) x;
        float f = (float) x;
        double d = (double) x;
    }
    void shortTest(short x, short y) {
        // Arithmetic operators:
        x = (short) (x * y);
        x = (short) (x / y);
        x = (short) (x % y);
        x = (short) (x + y);
        x = (short) (x - y);
        x++;
        x--;
        x = (short) +y;
        x = (short) -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = (short) ~y;
        x = (short) (x & y);
        x = (short) (x | y);
        x = (short) (x ^ y);
        x = (short) (x << 1);
        x = (short) (x >> 1);
        x = (short) (x >>> 1);
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        int i = (int) x;
        long l = (long) x;
        float f = (float) x;
        double d = (double) x;
    }
    void intTest(int x, int y) {
        // Arithmetic operators:
        x = x * y;
        x = x / y;
        x = x % y;
        x = x + y;
        x = x - y;
        x++;
        x--;
        x = +y;
        x = -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = ~y;
        x = x & y;
        x = x | y;
        x = x ^ y;
        x = x << 1;
        x = x >> 1;
        x = x >>> 1;
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        short s = (short) x;
        long l = (long) x;
        float f = (float) x;
        double d = (double) x;
    }
    void longTest(long x, long y) {
        // Arithmetic operators:
        x = x * y;
        x = x / y;
        x = x % y;
        x = x + y;
        x = x - y;
        x++;
        x--;
        x = +y;
        x = -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        x = ~y;
        x = x & y;
        x = x | y;
        x = x ^ y;
        x = x << 1;
        x = x >> 1;
        x = x >>> 1;
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        x <<= 1;
        x >>= 1;
        x >>>= 1;
        x &= y;
        x ^= y;
        x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        short s = (short) x;
        int i = (int) x;
        float f = (float) x;
        double d = (double) x;
    }
    void floatTest(float x, float y) {
        // Arithmetic operators:
        x = x * y;
        x = x / y;
        x = x % y;
        x = x + y;
        x = x - y;
        x++;
        x--;
        x = +y;
        x = -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        //! x = ~y;
        //! x = x & y;
        //! x = x | y;
        //! x = x ^ y;
        //! x = x << 1;
        //! x = x >> 1;
        //! x = x >>> 1;
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        //! x <<= 1;
        //! x >>= 1;
        //! x >>>= 1;
        //! x &= y;
        //! x ^= y;
        //! x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        short s = (short) x;
        int i = (int) x;
        long l = (long) x;
        double d = (double) x;
    }
    void doubleTest(double x, double y) {
        // Arithmetic operators:
        x = x * y;
        x = x / y;
        x = x % y;
        x = x + y;
        x = x - y;
        x++;
        x--;
        x = +y;
        x = -y;
        // Relational and logical:
        f(x > y);
        f(x >= y);
        f(x < y);
        f(x <= y);
        f(x == y);
        f(x != y);
        //! f(!x);
        //! f(x && y);
        //! f(x || y);
        // Bitwise operators:
        //! x = ~y;
        //! x = x & y;
        //! x = x | y;
        //! x = x ^ y;
        //! x = x << 1;
        //! x = x >> 1;
        //! x = x >>> 1;
        // Compound assignment:
        x += y;
        x -= y;
        x *= y;
        x /= y;
        x %= y;
        //! x <<= 1;
        //! x >>= 1;
        //! x >>>= 1;
        //! x &= y;
        //! x ^= y;
        //! x |= y;
        // Casting:
        //! boolean bl = (boolean)x;
        char c = (char) x;
        byte b = (byte) x;
        short s = (short) x;
        int i = (int) x;
        long l = (long) x;
        float f = (float) x;
    }
} ///:~
