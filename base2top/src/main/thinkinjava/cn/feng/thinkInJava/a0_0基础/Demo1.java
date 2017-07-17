package cn.feng.thinkInJava.a0_0基础;

/**步骤：
 1，通过class关键字定义一个类。将代码都编写到该类中。
 2，为了保证该的独立运行。在类中定义个主函数。格式public static void main(String[] args)
 3,保存成一个扩展名为java的文件。
 4，在dos控制台中通过javac工具对java文件进行编译。
 5，在通过java命令对生成的class文件进行执行。
 */

class Demo1// 定义一个类。
{

    // 主函数。
    public static void main(String[] args) {

        int a = 0, b;//b未初始化

        // 输出语句。
        System.out.println("hello haha");


        // int x = 4270;
        // x = x /1000 * 1000;
        // System.out.println(-1%5);

        // 字符串数据和任何数据使用+都是相连接，最终都会变成字符串。
        System.out.println("5+5" + (5 + 5));// "5+5=55"
        /*
         * 转义字符：通过\ 来转变后面字母或者符号的含义。 \n:换行。 \b:退格。相当于backspace。
		 * \r:按下回车键。window系统，回车符是由两个字符来表示\r\n. \t:制表符。相当于tab键。
		 */
        System.out.println("hello \t world");
        // System.out.println("hello java");

        System.out.println("\\hello\\");

        char ch = '\'';

        char c = 'a';
    }
}