package cn.feng.thinkInJava.a1_6_访问权限控制.access.cookie2.exercise;
//: access/local/E04_PackagedClass.java
/**
 * *************** Exercise 4 ****************
 * Show that protected methods have package
 * access but are not public.
 * *********************************************
 */
/*
package access.local;

public class E04_PackagedClass {

    protected static void greeting() {
        System.out.println("Hello client programmer!");
    }
} ///:~
//: access/local/E04_ConsumerInSamePackage.java
package access.local;

public class E04_ConsumerInSamePackage {

    public static void main(String[] args) {
        E04_PackagedClass.greeting();
    }
} */
/* Output:
Hello client programmer!
*//*
//:~
//: access/E04_ForeignClass.java
// {CompileTimeError} to see results
package access;

public class E04_ForeignClass {

    public static void main(String[] args) {
        access.local.E04_PackagedClass.greeting();
    }
} ///:~*/

/**
 *
 Explain why the compiler generates an error for E04_ForeignClass.java.
 Would making the E04_ForeignClass class part of the access.local package
 make a difference?
 Solution: E04_PackagedClass is in its own package, and greeting( ) is not
 a public method so is generally unavailable outside of the package
 access.local. If E04_ForeignClass were included in access.local, it would
 share the same package as E04_PackagedClass.greeting( ), and so could
 access it. (See Exercises 6 & 9.)
 * */
