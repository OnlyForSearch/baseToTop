package cn.feng.thinkInJava.a10_1_IO.io.a18_14_00.PreferencesAPI.exercise;
//: io/E33_PreferencesDemo.java
// {RunByHand}
/**
 * *************** Exercise 33 *****************
 * Write a program that displays the current value
 * of a directory called "base directory" and
 * prompts you for a new value. Use the Preferences
 * API to store the value.
 * *********************************************
 */
/**
 * 编写一个程序,显示被称为"基目录"的目录中的当前值,并将其改编为你的值,使用Preferences
 * API来存储这个值
 * */
import java.util.Scanner;
import java.util.prefs.Preferences;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

public class E33_PreferencesDemo {

    public static void main(String[] args) throws Exception {
        Preferences prefs = Preferences.userNodeForPackage(E33_PreferencesDemo.class);
        String directory = prefs.get("base directory", "Not defined");
        print("directory: " + directory);
        Scanner sc = new Scanner(System.in);
        printnb("Enter a new directory: ");
        directory = sc.nextLine();
        prefs.put("base directory", directory);
        print("\ndirectory: " + directory);
    }
} ///:~