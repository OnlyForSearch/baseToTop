package cn.feng.thinkInJava.a0_0.exercise;

/**测试
 * Created by Administrator on 2015/9/19.
 */
public class Ex3 {

    public static void main(String[] args) {

        class AType {

            int i = 0;
            double d = 1;
            boolean b = true;

            void show() {
                System.out.println(i);
                System.out.println(d);
                System.out.println(b);
            }

        }
        AType aType = new AType();
        aType.show();
    }
}

