package cn.feng.thinkInJava.a7_2_内部类;

import cn.feng.utils.Print;


/**
 * 内部类:将一个类的定义放在另外一个类的定义内部，看起来是一种内部隐藏机制：将类置于其他类的内部
 */
public class Parcel {

    class Inner {

    }

    class Content {

        public Parcel outer() {
        /*生成外部类对象的引用，产生的引用自动具有正确的类型，在编译期被知晓
		 * 使用.this语法
		 * */
            return Parcel.this;
        }

        private int value = 1;
        public int readValue() {
            return value;
        }
    }

    class Destination {

        private String label;
        public Destination(String whereTo) {
            this.label = whereTo;
        }
        public String readLabel() {
            return label;
        }
    }

    /**
     * 返回一个指向内部类的引用
     */
    public Content initContent() {
        return new Content();
    }
    /**
     * 返回一个指向内部类的引用
     */
    public Destination initDestination(String whereTo) {
        return new Destination(whereTo);
    }


    public void ship(String dest) {
        Content content = initContent();
        Destination destination = initDestination(dest);
        content.readValue();
        Print.println(destination.readLabel());


    }
    public static void main(String args[]) {
        Parcel parcel = new Parcel();
        Parcel parcel2 = new Parcel();
        //从外部类的“非静态”方法之外的任意位置创建内部类对象：OuterClassName.InnerClassName
        Content initContent = parcel.initContent();
        Destination initDestination = parcel.initDestination("initTo");
        parcel.ship("dest");
		/*创建外部类的内部类对象*/
        Parcel parcel3 = new Parcel();
        //示例.new语法
        Inner inner = parcel3.new Inner();
		/**/
		/**/
		/**/
		/**/
    }


}
