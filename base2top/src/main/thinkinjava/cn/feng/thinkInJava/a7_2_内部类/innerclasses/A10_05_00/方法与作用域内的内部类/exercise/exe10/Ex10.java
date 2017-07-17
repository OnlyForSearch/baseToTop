package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_05_00.方法与作用域内的内部类.exercise.exe10;// innerclasses/Ex10.java
// TIJ4 Chapter Innerclasses, Exercise 10, page 356
/* Repeat the previous exercise but define the inner class within a
* scope with scope within a method.
*/
//重复前一个练习,但将内部类定义在某个方法的一个作用域之内
interface Ex10Interface {
	void say(String s); 
}

public class Ex10 {	
	Ex10Interface f(boolean b) {
		if(b) {
			class Inner implements Ex10Interface {
				public void say(String s) {
					System.out.println(s); 
				}
			}
			return new Inner();
		}
		return null;
	}
	public static void main(String[] args) {
		Ex10 x = new Ex10();
		x.f(true).say("hi");
	} 
}
