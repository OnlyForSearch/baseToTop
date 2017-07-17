package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_03.遗憾_异常缺失.exercise;// exceptions/LostMessageFound19.java

// TIJ4 Chapter Exceptions, Exercise 19, page 479
// Repair the problem in LostMessage.java by guarding the call in the
// finally clause.
//通过确保finally子句中的调用,来修复 LostMessage.javazho
class VeryImportantException extends Exception {

    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {

    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessageFound19 {

    public static void main(String[] args) {
        try {
            LostMessageFound19 lmf = new LostMessageFound19();
            try {
                lmf.f();
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                lmf.dispose();
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
}