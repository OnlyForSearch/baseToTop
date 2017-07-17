//: interfaces/nesting/NestingInterfaces.java
package cn.feng.thinkInJava.a7_1_接口.interfaces.nesting.嵌套接口;
/**
接口中嵌套接口
 */
interface E {

    // Redundant "public":

    /**
 g();
    //   inte     * 接口中成员默认就是public的，接口嵌套在接口中只能是public的。
     */
    interface G {

        void f();
    }

    interface H {

        void f();
    }


    //! Cannot be private interface I {}
}

/**
 * 在
/**
 * 在类中嵌套接口
 */
class A {

    private D dRef;
    public D getD() { return new DImp2(); }
    public void receiveD(D d) {
        dRef = d;
        dRef.f();
    }

    /**
     * 类中嵌套接口或类可以是4种访问权限。
     */
    interface B {

        void f();
    }

    public interface C {

        void f();
    }

    //接口也可以被实现为private
    private interface D {

        void f();
    }

    public class BImp implements B {

        public void f() {}
    }

    private class BImp2 implements B {

        public void f() {}
    }

    class CImp implements C {

        public void f() {}
    }

    private class CImp2 implements C {

        public void f() {}
    }

    private class DImp implements D {

        public void f() {}
    }

    public class DImp2 implements D {

        public void f() {}
    }
}

/**
 * 接
口的嵌套
 * 接口中成员默认就是public的，接口嵌套在接口中只能是public的。类中嵌套接口或类可以是4种访问权限。
 * <p>
 * 当实现某个接口时，并不需要实现嵌套在其内部的任何接口。而且，private接口不能在定义它的类之外被发现，返回private接口仅可以被定义它的类的方法使用。
 *
 * @author fengyu
 * @date 2015年8月8日
 */
public class A9_8_01_NestingInterfaces {

    public static void main(String[] args) {
        A a = new A();
        // Can't access A.D:
        //! A.D ad = a.getD();
        // Doesn't return anything but A.D:
        //! A.DImp2 di2 = a.getD();
        // Cannot access a member of the interface:
        //! a.getD().f();
        // Only another A can do anything with getD():
        A a2 = new A();
        a2.receiveD(a.getD());
    }
} ///:~  clasic
class BImp implements A.B {

        public void f() {}
    }


    class  CImp implements A.C {

        public void f() {}
    }


    // within that interface's defining class:
    //! class DImp implements A.D {
    //!  public void f() {}
    //! }
    class EImp implements E {

        public void g() {}
    }


class EGImp implements E.G {

        public void f() {}
    }


class EImp2 implements E {

        public void g() {}
        class EG implements G {

            public void f() {}
        }
    }

