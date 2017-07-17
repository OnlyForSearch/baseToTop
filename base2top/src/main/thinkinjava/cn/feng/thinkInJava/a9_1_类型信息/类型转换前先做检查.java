package cn.feng.thinkInJava.a9_1_类型信息;

public class 类型转换前先做检查 {

    // RTTI形式包括:
    //
    // (1)传统的类型转换,如(Shape),由RTTI确保类型转换的正确性,如果执行了一个错误的类型转换,
    // 就会抛出一个ClassCastException异常
    // (2)代表对象的类型的Class对象,通过查询Class对象可以获取运行时所需的信息.
    // 在C++中,经典的类型转换(Shape)并不使用RTTI,它只是简单地告诉编译器将这个对象作为新的类型对待;而Java要执行类型检查,
    // 这通常称为"类型安全的向下转换",之所以叫"向下转型",是由于类层次结果图从来就是这么排列的.
    // 如果将Circle类型转换为Shape类型被称作向上转型,那么由Shape转型为Circle,就被称为向下转型.我们知道Circle
    // 肯定是一个Shape,所以编译器允许自由地做向上转型的赋值操作;然而,却不能保证一个Shape肯定是一个Circle,因此,如果不显式地做类型转换,编译器是
    // 不会自动做向下转型操作的. RTTI在Java中还有第三种形式
    //
    // (3)就是关键字instanceof,它返回一个布尔值,告诉我们对象是不是某个特定类型的实例,可以用提问的方式使用它,例如: if(x
    // instanceof Dog){ ((Dog)x).bark(); }
    // Instanceof保持了类型的概念,它指的是:你是这个类吗,或者你是这个类的派生类吗
    // 在将x转型成一个Dog前,上面的if语句会检查对象x是否从属于Dog类 .进行向下转型前,如果没有其他信息可以告诉
    // 你这个对象是什么类型,那么使用instanceof是非常重要的
    // ,否则会得到一个ClassCastException异常
    public static void main(String args[]) {
        // RTTI和反射的区别 
        // RTTI:编译器在编译时打开和检查.class文件 
        // 反射:.class文件在编译时是不可获取的,所以是在运行时打开和检查.class文件
    }
}
