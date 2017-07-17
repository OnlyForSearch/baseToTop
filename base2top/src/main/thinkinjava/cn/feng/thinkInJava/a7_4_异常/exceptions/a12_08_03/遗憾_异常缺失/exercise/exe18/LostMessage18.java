package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_08_03.遗憾_异常缺失.exercise.exe18;// exceptions/LostMessage18.java
// TIJ4 Chapter Exceptions, Exercise 18, page 479
// Add a second level of exception loss to LostMessage.java so that the
// HoHumException is itself replaced by a third exception.

/**
 * 为LostMessage.java添加第二层异常丢失,以便用第三个异常来代替HoHumException异常
 */
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

class MeaninglessException extends Exception {

    public String toString() {
        return "A meaningless exception";
    }
}

public class LostMessage18 {

    public static void main(String[] args) {
        try {
            LostMessage18 lm = new LostMessage18();
            try {
                try {
                    lm.f();
                    lm.dispose();
                } finally {
                    lm.eliminate();
                }
            } catch (Exception e) {
                System.out.println(e);
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
    void eliminate() throws MeaninglessException {
        throw new MeaninglessException();
    }
}