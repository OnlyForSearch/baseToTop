//: net/mindview/util/BinaryFile.java
// Utility for reading files in binary form.
package net.mindview.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读取二进制文件,简化了读取二进制文件的过程
 *
 * @author fengyu
 * @date 2015年8月9日
 */
public class BinaryFile {

    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        try {
            //available()方法用来产生恰当的尺寸数组
            byte[] data = new byte[bf.available()];
            //read()方法的特定的重载版本填充这个数组
            bf.read(data);
            return data;
        } finally {
            bf.close();
        }
    }
    /**接受一个表示文件名的String参数
     * @author fengyu
     * @date
     */
    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }
} ///:~
