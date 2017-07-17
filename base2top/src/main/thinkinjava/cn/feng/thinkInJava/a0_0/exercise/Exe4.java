package cn.feng.thinkInJava.a0_0.exercise;

/**
 * Created by Administrator on 2015/9/19.
 */
public class Exe4 {

    public static void main(String[] args) {
        class DataOnly {

            int anInt;
            boolean aBoolean;
            double aDouble;

            void show() {
                System.out.println(anInt);
                System.out.println(aBoolean);
                System.out.println(aDouble);

            }

        }

        DataOnly dataOnly = new DataOnly();
        dataOnly.show();
        dataOnly.anInt = 1;
        dataOnly.aBoolean = true;
        dataOnly.aDouble = 1.344;
        dataOnly.show();


    }

}
