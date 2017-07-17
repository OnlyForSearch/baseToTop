package cn.feng.thinkInJava.a7_1_接口.interfaces.A9_1_01.music5.接口.exercise.exe6;// interfaces.TestEx6.java
// TIJ4 Chapter Interfaces, Exercise 6, page 320
// Prove that all the methods in an interface are automatically public
//证明接口中所有的方法都是public的
/* Solution includes, in package interfaces.ex6:
* package interfaces.ex6;
*
* interface Ex6 {
*	void sayOne();
*	void sayTwo();
*	void sayThree();
* }
* 
* public class Ex6b implements Ex6 {
*	// Error: cannot assign weaker access to public methods:
*	// void sayOne() { System.out.println("one"); } // implies package *							// access
*	// protected void sayTwo() { System.out.println("two"); }
*	// private void sayThree() { System.out.println("three"); }
*	// must be maintained public:
*	public void sayOne() { System.out.println("one"); }
*	public void sayTwo() { System.out.println("two"); }
*	public void sayThree() { System.out.println("three"); }
* } 
*/

import cn.feng.thinkInJava.a7_1_接口.interfaces.A9_1_01.music5.接口.exercise.exe6.exe6.Ex6b;

public class TestEx6 {

    public static void main(String[] args) {
        Ex6b x = new Ex6b();
        x.sayOne();
        x.sayTwo();
        x.sayThree();
    }
}