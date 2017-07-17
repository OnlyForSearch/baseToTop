package cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_06_00.类方法的提取器.exercise;// typeinfo/ShowMethods17.java
// TIJ4 Chapter Typeinfo, Exercise 17, page 593
// Modify the regular expression in ShowMethods.java to additionally
// strip off the keywords native and final (hint: us the OR operator '|').
// {Args: ShowMethods17}

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static net.mindview.util.Print.print;

/**
 * 修改ShowMethods.java中的正则表达式,以去掉native和final关键字(提示:使用或操作符"|")
 */
public class ShowMethods17 {

    private static String usage = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all methods in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("(\\w+\\.)|\\s*final|\\s*native");
    public static void main(String[] args) {
        args = new String[]{"cn.feng.thinkInJava.a9_1_类型信息.typeinfo.a14_06_00.类方法的提取器.exercise.ShowMethods17"};

        if (args.length < 1) {
            print(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    print(p.matcher(method.toString()).replaceAll(""));
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