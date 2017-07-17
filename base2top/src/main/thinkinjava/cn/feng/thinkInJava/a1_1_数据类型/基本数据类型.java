package cn.feng.thinkInJava.a1_1_数据类型;

/**
 * @author fengyu
 * @date 2015年8月2日
 */
public class 基本数据类型 {

    /**
     * @param args
     * @author fengyu
     * @date 2015年8月2日
     */
    public static void main(String[] args) {
        // 输出系统属性
        System.getProperties().list(System.out);
        // 获取并输出系统
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }

    @Deprecated
    public void method() {


    }
}