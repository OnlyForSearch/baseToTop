package cn.feng.thinkInJava.a9_1_类型信息;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/**
 * 运行时的类型信息  
 * Class类和java.lang.reflect类库一起对反射的概念进行了支持 实现Member接口的类,主要是Constructor
 * ,Field,Method 
 */
/*
 * RTTI和反射的区别
 * 
 *   RTTI:编译器在编译时打开和检查.class文件  反射:.class文件在编译时是不可获取的,所以是在运行时打开和检查.class文件
 */
public class ShowMethods {

    private static String usage = "usage:\n" + "ShowMethods qualified.class.name\n" + "To show all methods in class or:\n" + "ShowMethods qualified.class.name word\n" + "To " +
            "search for methods involving 'word'";
    private static Pattern p = Pattern.compile("(([\u4E00-\u9FA5])|\\w)+\\.");//[\u4E00-\u9FA5]匹配汉字

    @Test
    public void showMethod() {
        this.showMethod(new String[]{"cn.feng.test.类型信息.ShowMethods"});//全限定名
    }

    public void showMethod(String[] args) {
        if (args.length < 1) {
            print(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            // getMethods()返回Method对象数组,Method用来解析其对象所代表的方法,并获取其名字,输入参数以及返回值
            Method[] methods = c.getMethods();
            // getConstructors()返回Constructor对象数组
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    print(method.getName());//获取方法名showMethod
                    print(p.matcher(method.toString()).replaceAll(""));//去掉全限定名public void showMethod(String[])
                    print(method.toString());//全限定名public void cn.feng.test.类型信息.ShowMethods.showMethod(java.lang.String[])
                }
                for (Constructor ctor : ctors)
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
}
/*
 * Output: public static void main(String[]) public native int hashCode() public
 * final native Class getClass() public final void wait(long,int) throws
 * InterruptedException public final void wait() throws InterruptedException
 * public final native void wait(long) throws InterruptedException public
 * boolean equals(Object) public String toString() public final native void
 * notify() public final native void notifyAll() public ShowMethods()
 */// :~
