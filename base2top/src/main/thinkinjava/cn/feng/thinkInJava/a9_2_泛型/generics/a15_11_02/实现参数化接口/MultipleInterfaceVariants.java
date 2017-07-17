package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_02.实现参数化接口;/*
 * package cn.feng.thinkInJava.a9_2_泛型.generics.a15_11_02; //实现参数化接口 //:
 * generics/MultipleInterfaceVariants.java // {CompileTimeError} (Won't compile)
 * interface Payable<T> { }
 * 
 * class Employee implements Payable<Employee> { }
 * //一个类不能实现同一个泛型接口的两种变体,由于擦除的原因,这两个变体会变成相同的接口 //Hourly
 * 不能编译,因为擦除会将Payable<employee>和Payable<Hourly>简化为相同的类型Payable,这样,
 * //代码就以为着在重复两次地实现了相同的接口.有趣的是,如果从Payable的两种用法中都移除泛型参数(就像编译器在擦除阶段所做的那样)这段代码就可以编译
 * class Hourly extends Employee implements Payable<Hourly> { }
 */// /:~
// 实现参数化接口
