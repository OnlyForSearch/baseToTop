package cn.feng.thinkInJava.a7_4_异常.exceptions.a12_11_00.异常匹配.exercise;// exceptions/Ex25.java
// TIJ4 Chapter Exceptions, Exercise 25, page 490
/* Create a three-level hierarchy of exceptions. Now create a 
* base-class A with a method that throws an exception at the base
* of your hierarchy. Inherit B from A and override the method so 
* it throws an exception at level two of your hierarchy. Repeat by
* inheriting class C from B. In main(), create a C and upcast it 
* to A, then call the method.
*/

/**
 * 建立一个三层的异常继承体系,然后创建基类A,他的一个方法能抛出异常体系
 * <p>
 * 的基类异常,让B继承A,并且覆盖这个方法,让它抛出第二个异常.让C继承B,再次覆盖这个方法,
 * 让它抛出第三层异常.在main()里创建一个C类型的对象,把它向上转型为A,然后调用这个方法
 */

class LevelOneException extends Exception {}

class LevelTwoException extends LevelOneException {}

class LevelThreeException extends LevelTwoException {}

class A {

    void f() throws LevelOneException {
        throw new LevelOneException();
    }
}

class B extends A {

    void f() throws LevelTwoException {
        throw new LevelTwoException();
    }
}

class C extends B {

    void f() throws LevelThreeException {
        throw new LevelThreeException();
    }
}

public class Ex25 {

    public static void main(String[] args) {
        A a = new C();
        try {
            a.f();
        } catch (LevelThreeException e3) {
            System.out.println("Caught e3");
        } catch (LevelTwoException e2) {
            System.out.println("Caught e2");
        } catch (LevelOneException e1) {
            System.out.println("Caught e1");
        }
    }
}