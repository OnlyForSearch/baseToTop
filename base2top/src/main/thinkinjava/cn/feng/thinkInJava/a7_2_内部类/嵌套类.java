package cn.feng.thinkInJava.a7_2_内部类;

/**
 * 当内部类对象不需要与外围对象之间有联系，就可以将内部类申明为static。这个内部类称为嵌套类
 * 嵌套类特点：1要创建嵌套类对象，并不需要其外围类的对象；2不能从嵌套类的对象中访问非静态的外围类对象
 * 3普通内部类的字段与方法，只能放在类的外部层次的上，所以普通内部类不能有static数据和static字段，也不能包含嵌套类，嵌套类可以
 */
public class 嵌套类 {

    private static class PContext implements Context {

        private int value = 47;
        @Override
        public int readValue() {
            return value;
        }

    }

    protected static class PDestination implements Destination {


        public static int i = 10;
        private String label;
        public PDestination(String label) {
            this.label = label;
        }
        public static void f() {}
        public String readLabel() {
            return label;
        }

        static class AnotherLevel {

            public void method() {
                class B {


                }
            }

        }


        //由于可以访问外围static对象所以不能重复命名
            /*public static void f(){

			}
			static int i=11;*/
    }
}
