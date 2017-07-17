package cn.feng.thinkInJava.a7_2_内部类.innerclasses.a10_03_00.使用DotThis;
//: innerclasses/DotThis.java
// Qualifying access to the outer-class object.

/**
 * 使用.this
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class DotThis {

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        Inner dti = dt.inner();
        dti.outer().f();
    }
    void f() { System.out.println("DotThis.f()"); }
    public Inner inner() { return new Inner(); }

    public class Inner {

        public DotThis outer() {
            //生成一个外部类对象的引用:外部类的名字.this;在编译期知晓,没有任何运行开销
            return DotThis.this;
            // A plain "this" would be Inner's "this"
        }
    }
} /* Output:
DotThis.f()
*///:~
