package cn.feng.thinkInJava.a9_3_容器.数组;

import cn.feng.utils.Print;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组与其它容器之间的区别  效率 类型和保存基本类型  而在泛型出现之后,唯一的区别就在于效率,而效率又是以固定长度为代价
 * 数组是一种效率最高的存储和随机访问对象引用序列的方式
 */
public class Array {

    public static Random random = new Random(47);
    public static String[] color = {"red", "blue", "green", "black", "yellow"};

    // 返回一个数组
    public static String[] returnArray(int n) {
        if (n > color.length)
            throw new IllegalArgumentException("参数太大");
        boolean[] bool = new boolean[color.length];
        String[] strings = new String[n];

        // 保证元素不重复
        for (int i = 0; i < n; i++) {
            int t;
            do {
                t = random.nextInt(n);
            } while (bool[t]);
            strings[i] = color[t];
            bool[t] = true;

        }

        return strings;

    }
    public static void main(String args[]) {
        for (int i = 0; i < 6; i++)
            Print.println(Arrays.toString(returnArray(4)));
    }
    @Test
    public void arrayDemo1() {
        // 1 元素类型[] 数组名 = new 元素类型[元素个数或数组长度];

        // 需求：想定义一个可以存储3个整数的容器。
        // x在栈内存存放引用 //new int[3]在堆内存中一被定义都有默认初始化值,根据元素类型进行初始化,数据对象
        int[] x = new int[3];
        int[] y = x;// 将x的引用地址传递给y
        /*******************************************/
        // 2 打印数组中角标为0的元素的值。
        System.out.println(x[1]);
        y[1] = 1;// ,y修改值,x的也被修改
        System.out.println(x[1]);
        /*******************************************/

        int[] arr = new int[3];
        arr = null;
        System.out.println(arr[1]);
        // ArrayIndexOutOfBoundsException: 3:操作数组时，访问到了数组中不存在的角标。
        // NullPointerException:空指针异常：当引用没有任何指向值为null的情况，该引用还在用于操作实体。
        /*******************************************/
        // 数组的操作：
        // 获取数组中的元素。通常会用到遍历。
        // int[] arr2 = new int[3];
        int[] arr2 = {3, 6, 5, 1, 8, 9, 67};
        // 数组中有一个属性可以直接获取到数组元素个数。length.
        // 使用方式：数组名称.length =
        // System.out.println("length:"+arr2.length);
        /*******************************************/
        /*******************************************/
        /*******************************************/
        /*******************************************/
        /*******************************************/
        /*******************************************/

    }
    @Test
    // 多维数组
    public void MultidimensionnalPrimitiveArray() {
        int[][] a = {{1, 2, 3,}, {4, 5, 5,},};
        System.out.println("打印多维数组" + Arrays.deepToString(a));

        int[][][] b = new int[2][2][4];
        System.out.println("打印多维数组" + Arrays.deepToString(b));

    }

    // 数组与泛型
    // 通常数组与泛型不能很好的结合,不能实例化具有参数化类型的数组,擦除
    // 会移除参数类型信息,而数组必须知道他们所持有的确切类型,以强制保证类型安全
    /* 但是可以参数化数组本身的类型 */
    /*
	 * 使用参数化方法而不使用参数化类的方便之处在于:不必为需要应用的每种不同的类型都使用 一个参数去实例化这个类,并且可以将其定义为静态的.
	 * 当然,你不能总选择使用从参数化的方法而不是参数化类,但是他应该成为首选
	 */
    // 粗糙数组:数组中构成矩阵的每个向量都可以具有任意长度
    @Test
    public void ragegdArray() {
        Random random = new Random();
        // 确定一维的长度
        int[][][] a = new int[random.nextInt(6)][][];
        for (int i = 0; i < a.length; i++) {
            // 确定二维的长度
            a[i] = new int[random.nextInt(4)][];
            for (int j = 0; j < a[i].length; j++) {
                // 确定三维的长度
                a[i][j] = new int[random.nextInt(5)];
            }
        }
        System.out.println(Arrays.deepToString(a));
    }
    public <T> T[] arrayOfGenerics(T[] args) {
        return args;
    }

}
