package cn.feng.thinkInJava.a7_4_异常;


/**
 * @author Administrator
 *         异常丢失
 */
public class LostMessage {

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {

                //  lm.f();抛出的异常别lm中的被lm.dispose()抛出的异常取代
                lm.dispose();
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