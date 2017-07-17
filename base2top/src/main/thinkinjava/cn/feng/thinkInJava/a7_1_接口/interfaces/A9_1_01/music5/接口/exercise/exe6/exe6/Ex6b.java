package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_1_01.music5.接口.exercise.exe6.exe6;

/**
 * Created by Administrator on 2015/10/21.
 */
interface Ex6 {

    void sayOne();

    void sayTwo();

    void sayThree();
}

public class Ex6b implements Ex6 {

    // Error: cannot assign weaker access to public methods:
    // void sayOne() { System.out.println("one"); } // implies package
    // protected void sayTwo() { System.out.println("two"); }
    // private void sayThree() { System.out.println("three"); }
    // must be maintained public:
    public void sayOne() { System.out.println("one"); }
    public void sayTwo() { System.out.println("two"); }
    public void sayThree() { System.out.println("three"); }
}
