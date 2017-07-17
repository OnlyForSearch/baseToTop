package cn.feng.thinkInJava.a7_1_接口;


public class 接口的嵌套 {

}

class A {
    
    private D dRef1;

    interface B {

        void f();
    }

    public class BImp implements B {

        public void f() {}
    }

    private class BImp2 implements B {

        public void f() {}
    }

    public interface C {

        void f();
    }

    class CImp implements C {

        public void f() {}
    }

    private class CImp2 implements C {

        public void f() {}
    }

    private interface D {

        void f();
    }

    private class DImp implements D {

        public void f() {}
    }

    public class DImp2 implements D {

        public void f() {}
    }
    public D getD() { return new DImp2(); }
    private D dRef;
    public void receiveD(D d) {
        dRef = d;
        dRef1.f();
    }
}


interface E {

    interface G {

        void f();
    }

    // Redundant "public":
    interface H {

        void f();
    }

    void g();
    // Cannot be private within an interface:
    //! private interface I {}
}	
