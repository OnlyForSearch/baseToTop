package cn.feng.thinkInJava.a9_3_容器.containers.a17_04_01.未获得支持的操作.exercise;// containers/Ex4.java
// TIJ4 Chapter Containers, Exercise 4, page 809
/* Create a Collection initializer that opens a file and breaks
* it into words using TextFile, and then uses the words as the
* source of data for the resulting Collection. Demonstrate that 
* it works.
*/

import net.mindview.util.TextFile;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

import static cn.feng.utils.Print.println;

/**
 * 创建一个Collection初始化器,它将打开一个文件,并用TextFilej将
 * 其断开为单词然后将这些单词作为所产生的Collection的数据源使用,
 * 请演示他是可以工作的
 * *
 */
public class Ex4 {

    static Collection<String> CollectFromText(String fileName) {
        String[] sa = TextFile.read(fileName).split(" ");
        return Arrays.asList(sa);
    }
    static Collection<String> CollectFromText2(String fileName) {
        String[] sa = TextFile.read(fileName).split(" ");
        return new TreeSet<String>(new TextFile(fileName, "\\W+"));
    }
    public static void main(String[] args) {
        println(CollectFromText("Ex4.java"));
        println(CollectFromText2("Ex4.java"));
    }
}