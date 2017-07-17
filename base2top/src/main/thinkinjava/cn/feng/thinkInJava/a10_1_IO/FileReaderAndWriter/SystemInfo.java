package cn.feng.thinkInJava.a10_1_IO.FileReaderAndWriter;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

class SystemInfo {

    public static void main(String[] args) throws IOException {
        Properties prop = System.getProperties();

        //System.out.println(prop);
        prop.list(new PrintStream("sysinfo.txt"));
    }
}
