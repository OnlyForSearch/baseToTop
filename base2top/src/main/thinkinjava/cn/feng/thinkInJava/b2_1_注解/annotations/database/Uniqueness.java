//: annotations/database/Uniqueness.java
// Sample of nested annotations
package cn.feng.thinkInJava.b2_1_注解.annotations.database;

public @interface Uniqueness {

    Constraints constraints() default @Constraints(unique = true);
} ///:~
