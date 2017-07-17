//: enumerated/Outcome.java
package cn.feng.thinkInJava.b1_1_枚举类型.enumerated.a19_11_00.多路分发;

public enum Outcome {WIN, LOSE, DRAW} ///:~
//多路分发

/**
 * Java只支持单路分发。也就是说，如果要执行的操作包含了不止一个类型未知的对象时，那么Java的动态绑定机制只能处理其中一个类型。

 例如，Number是各种数字的超类，a，b都是Number类对象，执行a.plus(b)时，java的动态绑定机制可以判断调用方法的对象a的确切类型，但是却不知道b的确切类型。

 解决问题的办法就是多路分发（在上例中只有两个分发，一般称之为两路分发）。如果想使用两路分发，那么就必须有两个方法调用：第一个方法调用决定第一个未知类型，第二个方法调用决定第二个未知的类型。例如在plus方法中再执行 b.plus(this)

 书中举了“石头、剪刀、布”的例子，使用enum、常量相关的方法、EnumMap、二维数组进行多路的分发。
 * */