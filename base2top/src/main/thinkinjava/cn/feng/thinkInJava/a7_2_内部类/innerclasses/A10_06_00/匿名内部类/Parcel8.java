package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_06_00.匿名内部类;

public class Parcel8 {

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
    }
    public Wrapping wrapping(int x) {
        // Base constructor call://传递参数的匿名内部类
        //尽管Wrapping只是一个具有具体实现的普通类,但它还是被其他导出类当作公共"接口"来使用
        return new Wrapping(x) { // Pass constructor argument.
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
        /**匿名内部类末尾的分号,并不是用来标记此内部类结束的.实际上,是标记表达式结束的.只不过这个表达式正巧包含了匿名内部类罢了*/
    }
} // /:~
