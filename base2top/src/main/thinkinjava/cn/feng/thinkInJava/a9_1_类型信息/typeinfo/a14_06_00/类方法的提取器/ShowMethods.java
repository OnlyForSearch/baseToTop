package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_06_00.类方法的提取器;
//: typeinfo/ShowMethods.java
// Using reflection to show all the methods of a class,
// even if the methods are defined in the base class.
// {Args: ShowMethods}

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/**
 * 类方法提取器
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class ShowMethods {

    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";
    //用正则去掉了命名修饰符
    private static Pattern p = Pattern.compile("\\w+\\.");
    public static void main(String[] args) {
        args = new String[]{"cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_06_00.类方法的提取器.ShowMethods"};
        if (args.length < 1) {
            print(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();//返回Method对象的数组
            Constructor[] ctors = c.getConstructors();//返回Constructor对象数组
            if (args.length == 1) {
                for (Method method : methods)
                    //只使用toString()生成一个含有完整的方法特征签名的
                    print(p.matcher(method.toString()).replaceAll(""));
                for (Constructor ctor : ctors)
                    //只使用toString()生成一个含有完整的方法特征签名的
                    print(p.matcher(ctor.toString()).replaceAll(""));
                lines = methods.length + ctors.length;
            } else {
                for (Method method : methods)
                    if (method.toString().indexOf(args[1]) != -1) {
                        print(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                for (Constructor ctor : ctors)
                    if (ctor.toString().indexOf(args[1]) != -1) {
                        print(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
            }
        } catch (ClassNotFoundException e) {
            print("No such class: " + e);
        }
    }
} /* Output:
public static void main(String[])
public native int hashCode()
public final native Class getClass()
public final void wait(long,int) throws InterruptedException
public final void wait() throws InterruptedException
public final native void wait(long) throws InterruptedException
public boolean equals(Object)
public String toString()
public final native void notify()
public final native void notifyAll()
public ShowMethods()
*///:~
