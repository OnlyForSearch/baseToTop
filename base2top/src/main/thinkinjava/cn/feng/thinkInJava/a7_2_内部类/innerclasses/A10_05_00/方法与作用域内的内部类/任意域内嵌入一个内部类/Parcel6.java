package cn.feng.thinkInJava.a7_2_内部类.innerclasses.A10_05_00.方法与作用域内的内部类.任意域内嵌入一个内部类;

//: innerclasses/Parcel6.java
// Nesting a class within a scope.

public class Parcel6 {

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
    private void internalTracking(boolean b) {
        if (b) {
            /** 在任意作用域嵌入一个内部类 ,只在作用域内有效,作用域外是不可用的,除此之外于普通的类一样*/
            class TrackingSlip {

                private String id;

                TrackingSlip(String s) {
                    id = s;
                }

                String getSlip() {
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        // Can't use it here! Out of scope:
        // ! TrackingSlip ts = new TrackingSlip("x");
    }
    public void track() {
        internalTracking(true);
    }
} // /:~
