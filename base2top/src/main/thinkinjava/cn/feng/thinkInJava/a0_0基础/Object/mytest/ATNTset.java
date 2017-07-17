package cn.feng.thinkInJava.a0_0基础.Object.mytest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

/**
 * Created by fengYu Administrator on 2015/11/9.
 */
public class ATNTset {
    
    public static void main(String[] args) {
        class ATypeName{
            int i;
            boolean b;
            char c;
            void show(){
                System.out.println("i = " + i);
                System.out.println("b = " + b);
                System.out.println("c = " + c);
                
            }
        }
        ATypeName aTypeName = new ATypeName();
        aTypeName.i=1;
        aTypeName.b=false;
        aTypeName.c = 'c';
        aTypeName.show();

    }
    public Object foo(){
        return Collections.EMPTY_MAP;
    }

    public  String foo(String text) {

        if (text == null) {

            text="";
            text += "x";
            return text;
        }else {text += "a";}
        return null;


    }

    String greet(String message) {
        if (message != null) {
            return null;


        }
     else
            return "";

    }

    public static Integer parseFile(File file) throws IOException {
        if (file.isDirectory()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            return fileInputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e.getCause());
        } finally {
        return 0;
        }


    }
}
