// interfaces/interfaceprocessor/StringMixerProcessor.java
// TIJ4 Chapter Interfaces, Exercise 11, page 324
/* Create a class with a method that takes a String argument and produces a result
* that swaps each pair of characters in that argument. Adapt the class so that it
* works with interfaceprocessor.Apply.process().
*///接受一个String类型的参数,生成的结果是每一对字符串,进行互换
/* Solution includes, in same package:
* package interfaces.interfaceprocessor;

* public class StringMixer {
*	static String process(String s) {
*		char[] ca = new char[s.length()];
*		if((s.length())%2 == 0) {
*			for(int i = 0; i < s.length(); i += 2) {
*				ca[i] = s.charAt(i + 1);
*				ca[i + 1] = s.charAt(i);			
*			}		
*			return new String(ca);
*		}
*		else {
*		for(int i = 0; i < s.length() - 1; i += 2) {
*				ca[i] = s.charAt(i + 1);
*				ca[i + 1] = s.charAt(i);			
*			}
*			ca[s.length() - 1] = s.charAt(s.length() - 1);		
*			return new String(ca);
*		}
*	}	
* }
*/
// program takes command line String argument:
package cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.exercise.exe11;

import cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_7.Processor;
import cn.feng.thinkInJava.a7_1_接口.interfaces.interfaceprocessor.完全解耦3.A9_3_8.Apply;

class StringMixerAdapter implements Processor {

    StringMixer stringMixer;
    public StringMixerAdapter(StringMixer stringMixer) {
        this.stringMixer = stringMixer;
    }
    public String name() { return "StringMixerAdapter"; }
    public String process(Object input) {
        return stringMixer.process((String) input);
    }
}

public class StringMixerProcessor {

    public static void main(String[] args) {
        String s = new String(args[0]);
        Apply.process(new StringMixerAdapter(new StringMixer()), s);
    }
}

class StringMixer {

    //接受一个String类型的参数,生成的结果是每一对字符串,进行互换
    static String process(String s) {
        char[] ca = new char[s.length()];
        if ((s.length()) % 2 == 0) {
            for (int i = 0; i < s.length(); i += 2) {
                ca[i] = s.charAt(i + 1);
                ca[i + 1] = s.charAt(i);
            }
            return new String(ca);
        } else {
            for (int i = 0; i < s.length() - 1; i += 2) {

                ca[i] = s.charAt(i + 1);
                ca[i + 1] = s.charAt(i);
            }
            ca[s.length() - 1] = s.charAt(s.length() - 1);
            return new String(ca);
        }
    }
}