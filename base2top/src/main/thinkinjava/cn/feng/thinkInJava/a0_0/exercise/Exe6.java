package cn.feng.thinkInJava.a0_0.exercise;

/**
 * Created by Administrator on 2015/9/19.
 */
public class Exe6 {

    public static void main(String[] args) {
        final int j = 1;
        class StoreBuff {

            int b = j;
            int store(String s) {
                return s.length() * 2;
            }
        }
        StoreBuff storeBuff = new StoreBuff();
        System.out.println(storeBuff.store("sde"));
    }
}
