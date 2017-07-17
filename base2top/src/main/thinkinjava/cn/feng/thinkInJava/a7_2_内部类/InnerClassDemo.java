package cn.feng.thinkInJava.a7_2_内部类;

import static cn.feng.utils.Print.println;

/*
内部类的访问规则：
1，内部类可以直接访问外部类中的成员，包括私有。
	之所以可以直接访问外部类中的成员，是因为内部类中持有了一个外部类的引用，格式 外部类名.this
2，外部类要访问内部类，必须建立内部类对象。

访问格式：
1,当内部类定义在外部类的成员位置上，而且非私有，可以在外部其他类中。
可以直接建立内部类对象。
格式
	外部类名.内部类名  变量名 = 外部类对象.内部类对象;
	Outer.Inner in = new Outer().new Inner();

2,当内部类在成员位置上，就可以被成员修饰符所修饰。
	比如，private：将内部类在外部类中进行封装。
		static:内部类就具备static的特性。
		当内部类被static修饰后，只能直接访问外部类中的static成员。出现了访问局限。

		在外部其他类中，如何直接访问static内部类的非静态成员呢？
		new Outer.Inner().function();

		在外部其他类中，如何直接访问static内部类的静态成员呢？
		Outer.Inner.function();

	注意：当内部类中定义了静态成员，该内部类必须是static的。
		  当外部类中的静态方法访问内部类时，内部类也必须是static的。

当描述事物时，事物的内部还有事物，该事物用内部类来描述。
因为内部事务在使用外部事物的内容。
*/
public class InnerClassDemo {

    private int x = 3;
    private static int x2 = 3;

    static class Inner2// 静态内部类
    {

        static void function() {
            System.out.println("innner :" + x2);
        }
    }

    class Inner//内部类
    {

        //int x = 4;
        void function() {
            //int x = 6;
            System.out.println("innner :" + InnerClassDemo.this.x);
        }
    }

    /**/
    void method() {
        Inner in = new Inner();
        in.function();
    }

    /********************************************************************************************/

    /**
     * ****************************************************************************************
     */
    public static void main(String args[]) {

        InnerClassDemo out = new InnerClassDemo();
        out.method();

        //直接访问内部类中的成员。
        //		Outer.Inner in = new Outer().new Inner();
        //		in.function();
        System.out.println("1");
    }

    /********************************************************************************************/
    /**
     * 3匿名內部類（1）
     */
    /* 方法将方法的返回值的生成与表示这个返回值的类的定义结合在一起，这个类是匿名的，没有名字 */
    public Context anonymousInnerClass() {
        //
        return new Context() {
            private int i = 11;

            public int readValue() {
                return i;
            }

        };// ";"表示表达式的结束
    }

    class MyContexts implements Context {

        private int i = 11;

        @Override
        public int readValue() {
            // TODO Auto-generated method stub
            return i;
        }

    }

    /* anonymousInnerClass是anonymousInnerClass2形式的缩写 */
    public Context anonymousInnerClass2() {
        return new MyContexts();
    }

	/*-********************************************************************************************-*/
    // 有参构造器的匿名内部类

    /**
     * 在定义一个匿名内部类，并且希望使用一个外部的定义的对象，参数必须是final
     */
	/*
	内部类定义在局部时，
	1，不可以被成员修饰符修饰
	2，可以直接访问外部类中的成员，因为还持有外部类中的引用。
		但是不可以访问它所在的局部中的变量。只能访问被final修饰的局部变量。
	*/
    public Wrap warp(final String i) {
		/*	
		匿名内部类:
		1，匿名内部类其实就是内部类的简写格式。
		2，定义匿名内部类的前提：
			内部类必须是继承一个类或者实现接口。
		3，匿名内部类的格式：  new 父类或者接口(){定义子类的内容}
		4，其实匿名内部类就是一个匿名子类对象。而且这个对象有点胖。	可以理解为带内容的对象。
		5，匿名内部类中定义的方法最好不要超过3个。


		*/
        return new Wrap(i) {
            final int y = 4;
            public int value() {
                return super.intValue().length() * 47;
            }
            void function() {
                System.out.println(y);
            }

        };
    }

	/*-********************************************************************************************-*/

    /********************************************************************************************/
    /**
     * 2在任意作用域中嵌入一个内部类
     */
    public static void methodInnerScope(boolean flag) {
        if (flag) {
            class TrackingSkip {

                private String id;

                public TrackingSkip() {
                }

            }
        }
    }

    /********************************************************************************************/

    /**
     * 1方法中的内部类演示
     */
    private static void methodInnerClass() {
        InnerClassDemo demo = new InnerClassDemo();

        println(demo.destination("method innerClass").readLabel());
    }

    /********************************************************************************************/

    /**
     * 1在方法的作用域内，创建一个内部类，局部内部类
     */

    public Destination destination(String s) {
        class PDestination implements Destination {

            private String label;

            public PDestination(String whereTo) {
                this.label = whereTo;
            }

            public String readLabel() {

                return label;
            }

        }
        return new PDestination(s);
    }
}

interface Destination {

    String readLabel();
}

interface Context {

    int readValue();
}

class Wrap {

    private String i;

    public Wrap(String i) {
        this.i = i;
    }

    public String intValue() {
        return i;
    }
}