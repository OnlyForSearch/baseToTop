package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_12_04.把被检查的异常转换为不检查的异常.exercise;// exceptions/Human30.java
// TIJ4 Chapter Exceptions, Exercise 30, page 500
/* Modify Human.java so that the exceptions inherit from 
* RuntimeException. Modify main() so that the technique
* in TurnOffChecking.java is used to handle the different
* types of exceptions.
*/
/**
 * 修改Human.java使得异常继承自RuntimeException修改main(),使得
 * 其用TurnOffChecking.java类处理不同的类型的异常
 */

import static net.mindview.util.Print.print;

class Annoyance extends RuntimeException {}

class Sneeze extends Annoyance {}


class WrapCheckedExceptions {

    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case (0):
                    throw new Annoyance();
                case (1):
                    throw new Sneeze();
                case (2):
                    throw new RuntimeException("Where am I?");
                default:
                    return;
            }
        } catch (Exception e) {
            // Adapt to unchecked:
            throw new RuntimeException(e);
        }
    }
}

public class Human30 {

    public static void main(String[] args) {
        WrapCheckedExceptions wce = new WrapCheckedExceptions();
        for (int i = 0; i < 3; i++)
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new RuntimeException();
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (Sneeze e) {
                    print("Sneeze: " + e);
                } catch (Annoyance e) {
                    print("Annoyance: " + e);
                } catch (Throwable e) {
                    print("Throwable: " + e);
                }
            }
    }
}