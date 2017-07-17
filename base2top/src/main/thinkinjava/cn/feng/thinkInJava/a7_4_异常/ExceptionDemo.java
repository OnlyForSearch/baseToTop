package cn.feng.thinkInJava.a7_4_异常;

/*
 异常：就是程序在运行时出现不正常情况。
 异常由来：问题也是现实生活中一个具体的事物，也可以通过java的类的形式进行描述。并封装成对象。
 其实就是java对不正常情况进行描述后的对象体现。

 对于问题的划分：两种：一种是严重的问题，一种非严重的问题。

 对于严重的，java通过Error类进行描述。
 对于Error一般不编写针对性的代码对其进行处理。

 对与非严重的，java通过Exception类进行描述。
 对于Exception可以使用针对性的处理方式进行处理。

 无论Error或者Exception都具有一些共性内容。
 比如：不正常情况的信息，引发原因等。

 Throwable
 |--Error
 |--Exception




 2,异常的处理

 java 提供了特有的语句进行处理。
 try
 {
 需要被检测的代码；
 }
 catch(异常类 变量)
 {
 处理异常的代码；(处理方式)
 }
 
 
 finally
 {
	finally代码块：定义一定执行的代码。
	通常用于关闭资源。
 }


 3，对捕获到的异常对象进行常见方法操作。
 String getMessage()：获取异常信息。

在函数上声明异常。
便于提高安全性，让调用出进行处理。不处理编译失败。

对多异常的处理。

1，声明异常时，建议声明更为具体的异常。这样处理的可以更具体。
2，对方声明几个异常，就对应有几个catch块。不要定义多余的catch块。
	如果多个catch块中的异常出现继承关系，父类异常catch块放在最下面。


建立在进行catch处理时，catch中一定要定义具体处理方式。
不要简单定义一句 e.printStackTrace(),
也不要简单的就书写一条输出语句。

 */
public class ExceptionDemo {

    public static void f(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException, MyException {//在功能上通过throws的关键字声明了该功能有可能会出现问题。
        System.out.println("SimpleException");

        throw new MyException();
    }

    public static void main(String args[]) {
        try {
            f(5, 0);

/*
异常在子父类覆盖中的体现；
1，子类在覆盖父类时，如果父类的方法抛出异常，那么子类的覆盖方法，只能抛出父类的异常或者该异常的子类。
2，如果父类方法抛出多个异常，那么子类在覆盖该方法时，只能抛出父类异常的子集。
3，如果父类或者接口的方法中没有异常抛出，那么子类在覆盖方法时，也不可以抛出异常。
	如果子类方法发生了异常。就必须要进行try处理。绝对不能抛。

*/

        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("被零除了!!");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
            System.out.println("角标越界啦！！");
        } catch (Exception e) {
            System.out.println("Catch SimpleException");
            System.out.println(e.getMessage());//  / by zero;
            System.out.println(e.toString());// 异常名称 ： 异常信息。
            e.printStackTrace();//异常名称，异常信息，异常出现的位置。
            //其实jvm默认的异常处理机制，就是在调用printStackTrace方法。
            //打印异常的堆栈的跟踪信息。
        } finally {
            System.out.println("finally");//finally中存放的是一定会被执行的代码。
        }

        System.out.println("over");
    }

}

/**
 * 对于异常来说最重要的是应该在下列情况下使用异常 
 * a. 在恰当的级别处理问题(在知道该如何处理的情况下才捕获异常) b. 解决问题并且重新调用产生异常的方法 
 * c. 进行少许修补,然后绕过异常发生的地方继续执行 d. 用别的数据进行计算,以代替方法预计会返回的值 
 * e. 把当前运行环境下能做的事情尽量做完,然后把相同的异常重抛到更高层
 *  f.    把当前运行环境下能做的事情尽量做完,然后把不同的异常抛到更高层 g. 终止程序 
 * h. 进行简化(如果你的异常模式使问题变得太复杂,那用起来会非常痛苦也很烦人
 * ) i.    让类库和程序更安全(这既是在为调试做短期投资,也是在为程序的健壮性做长期投资)
 */
class MyException extends Exception {


    /*
    因为项目中会出现特有的问题，
    而这些问题并未被java所描述并封装对象。
    所以对于这些特有的问题可以按照java的对问题封装的思想。
    将特有的问题。进行自定义的异常封装。

    自定义异常。

    需求：在本程序中，对于除数是-1，也视为是错误的是无法进行运算的。
    那么就需要对这个问题进行自定义的描述。

    当在函数内部出现了throw抛出异常对象，那么就必须要给对应的处理动作。
    要么在内部try catch处理。
    要么在函数上声明让调用者处理。

    一般情况在，函数内出现异常，函数上需要声明。


    发现打印的结果中只有异常的名称，却没有异常的信息。
    因为自定义的异常并未定义信息。

    如何定义异常信息呢？
    因为父类中已经把异常信息的操作都完成了。
    所以子类只要在构造时，将异常信息传递给父类通过super语句。
    那么就可以直接通过getMessage方法获取自定义的异常信息。



    自定义异常：
    必须是自定义类继承Exception。


    继承Exception原因：
    异常体系有一个特点：因为异常类和异常对象都被抛出。
    他们都具备可抛性。这个可抛性是Throwable这个体系中独有特点。

    只有这个体系中的类和对象才可以被throws和throw操作。



    throws和throw的区别
    throws使用在函数上。
    throw使用在函数内。

    throws后面跟的异常类。可以跟多个。用逗号隔开。
    throw后跟的是异常对象。



    */
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

}


/*
Exceptoin中有一个特殊的子类异常RuntimeException 运行时异常。

如果在函数内容抛出该异常，函数上可以不用声明，编译一样通过。

如果在函数上声明了该异常。调用者可以不用进行处理。编译一样通过；

之所以不用在函数声明，是因为不需要让调用者处理。
当该异常发生，希望程序停止。因为在运行时，出现了无法继续运算的情况，希望停止程序后，
对代码进行修正。




自定义异常时：如果该异常的发生，无法在继续进行运算，
就让自定义异常继承RuntimeException。


对于异常分两种：
1，编译时被检测的异常。
	
2，编译时不被检测的异常(运行时异常。RuntimeException以及其子类)

*/
class FuShuException extends RuntimeException {

    FuShuException(String msg) {
        super(msg);
    }
}

class Demo {

    int div(int a, int b) throws Exception//throws ArithmeticException
    {

        if (b < 0)
            throw new Exception("出现了除数为负数了");
        if (b == 0)
            throw new ArithmeticException("被零除啦");
        return a / b;
    }
}
