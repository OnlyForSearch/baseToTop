package cn.feng.thinkInJava.a9_3_容器.数组;

import org.junit.Test;

public class ArrayTest {

    /*获取数组中的最大值。
    思路：
    1，获取最值需要进行比较。每一次比较都会有一个较大的值。因为该值不确定。
    通过一个变量进行临储。
    2，让数组中的每一个元素都和这个变量中的值进行比较。
    如果大于了变量中的值，就用该该变量记录较大值。
    3，当所有的元素都比较完成，那么该变量中存储的就是数组中的最大值了。

    步骤：
    1，定义变量。初始化为数组中任意一个元素即可。
    2，通过循环语句对数组进行遍历。
    3，在变量过程中定义判断条件，如果遍历到的元素比变量中的元素大，就赋值给该变量；

    需要定义一个功能来完成。以便提高复用性。
    1，明确结果，数组中的最大元素 int。、
    2，未知内容：一个数组。int[]
    */
    public static int getMax(int[] arr) {
        int max = arr[0];

        for (int x = 1; x < arr.length; x++) {
            if (arr[x] > max)
                max = arr[x];
        }
        return max;
    }
    /*
    获取最大值的另一种方式。
    可不可以将临时变量初始化为0呢？可以。这种方式，其实是在初始化为数组中任意一个角标。


    */
    public static int getMax_2(int[] arr) {
        int max = 0;

        for (int x = 1; x < arr.length; x++) {
            if (arr[x] > arr[max])
                max = x;
        }
        return arr[max];
    }
    /*
    获取最小值。
    */
    public static int getMin(int[] arr) {
        int min = 0;
        for (int x = 1; x < arr.length; x++) {
            if (arr[x] < arr[min])
                min = x;
        }
        return arr[min];
    }
    /*
    选择排序。
    内循环结束一次，最值出现头角标位置上。
    */
    public static void selectSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
					/*
					int temp = arr[x];
					arr[x] = arr[y];
					arr[y]= temp;
					*/
                    swap(arr, x, y);
                }
            }
        }
    }

    //获取double类型数组的最大值。因为功能一致，所以定义相同函数名称。以重载形式存在。
    /*
    public static double getMax(double[] arr)
	{
		
	}
	*/
	/* *******************************************************************/
    public static void bubbleSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = 0; y < arr.length - x - 1; y++)//-x:让每一次比较的元素减少，-1：避免角标越界。
            {
                if (arr[y] < arr[y + 1]) {
					/*
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
					*/
                    swap(arr, y, y + 1);
                }
            }
        }
    }
    /*
    发现无论什么排序。都需要对满足条件的元素进行位置置换。
    所以可以把这部分相同的代码提取出来，单独封装成一个函数。
    */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
	/*
	冒泡排序
	*/
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int x = 0; x < arr.length; x++) {
            if (x != arr.length - 1)
                System.out.print(arr[x] + ", ");
            else
                System.out.println(arr[x] + "]");

        }
    }
    public static void reverseArray(int[] arr) {
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
			/*
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			*/
            swap(arr, start, end);
        }
    }
    public static int getIndex_2(int[] arr, int key) {
        int min = 0, max = arr.length - 1, mid;

        while (min <= max) {
            mid = (max + min) >> 1;

            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max = mid - 1;
            else
                return mid;
        }
        return min;
    }
	
	
	/* *******************************************************************/
    /*
    折半的第二种方式。
    */
    public static int halfSearch_2(int[] arr, int key) {
        int min = 0, max = arr.length - 1, mid;

        while (min <= max) {
            mid = (max + min) >> 1;

            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max = mid - 1;
            else
                return mid;
        }
        return -1;
    }
    /*
    折半查找。提高效率，但是必须要保证该数组是有序的数组。
    */
    public static int halfSearch(int[] arr, int key) {
        int min, max, mid;
        min = 0;
        max = arr.length - 1;
        mid = (max + min) / 2;

        while (arr[mid] != key) {
            if (key > arr[mid])
                min = mid + 1;
            else if (key < arr[mid])
                max = mid - 1;

            if (min > max)
                return -1;
            mid = (max + min) / 2;
        }
        return mid;
    }
    //定义功能，获取key第一次出现在数组中的位置。如果返回是-1，那么代表该key在数组中不存在。
    public static int getIndex(int[] arr, int key) {
        for (int x = 0; x < arr.length; x++) {
            if (arr[x] == key)
                return x;
        }
        return -1;
    }
    /*
    十进制-->十六进制。
    */
    public static void toHex(int num) {

        //定义二进制的表。
        char[] chs = {'0', '1'};

        //定义一个临时存储容器。
        char[] arr = new char[32];

        //定义一个操作数组的指针
        int pos = arr.length;

        while (num != 0) {
            int temp = num & 1;

            arr[--pos] = chs[temp];

            num = num >>> 1;
        }

        for (int x = pos; x < arr.length; x++) {
            System.out.print(arr[x]);
        }

    }
    /*
    0 1 2 3 4 5 6 7 8 9 A  B  C   D  E  F  ==十六进制中的元素。
    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

    查表法：将所有的元素临时存储起来。建立对应关系。
    每一次&15后的值作为索引去查建立好的表。就可以找对应的元素。
    这样比 -10+'a'简单的多。

    这个表怎么建立呢？
    可以通过数据的形式来定义。

    发现终于出结果了。但是是反着的。想要正过来呢？可以通过StringBuffer reverse功能来完成。
    但是这个工具还没有学习。

    所以可以使用已经学习过的容器：数组来完成存储。；

*/
    public static void toBin(int num) {

        char[] chs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        //定义一个临时容器。
        char[] arr = new char[8];
        int pos = arr.length;

        while (num != 0) {
            int temp = num & 15;

            //System.out.println(chs[temp]);
            arr[--pos] = chs[temp];


            num = num >>> 4;
        }
        System.out.println("pos=" + pos);
        //存储数据的arr数组遍历。
        for (int x = pos; x < arr.length; x++) {
            System.out.print(arr[x] + ",");
        }
    }
    /*
    十进制-->二进制
    */
    public static void toBin2(int num) {
        trans(num, 1, 1);
    }
    /*
    十进制-->八进制
    */
    public static void toBa2(int num) {
        trans(num, 7, 3);
    }
	
	/* *******************************************************************/
    /*
    十进制-->十六进制
    */
    public static void toHex2(int num) {
        trans(num, 15, 4);
    }
    public static void trans(int num, int base, int offset) {

        if (num == 0) {
            System.out.println(0);
            return;
        }
        char[] chs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] arr = new char[32];

        int pos = arr.length;

        while (num != 0) {
            int temp = num & base;
            arr[--pos] = chs[temp];
            num = num >>> offset;
        }

        for (int x = pos; x < arr.length; x++) {
            System.out.print(arr[x]);
        }

        return;
    }
    /**
     * 给定一个数组{5,1,6,4,2,8,9}。 1，获取数组中的最大值，以及最小值。
     */
    @Test
    public void testArray1() {
        int[] arr = {5, 1, 6, 4, 2, 8, 9};

        int max = getMax_2(arr);
        int min = getMin(arr);
        System.out.println("max=" + max);
        System.out.println("min=" + min);


        //		boolean[] ar = new boolean[3];
        //		System.out.println(ar[1]);
    }
    /**
     * 2 对给定数组进行排序。 {5,1,6,4,2,8,9}
     */
    @Test
    public void testArray2() {
        int[] arr = {5, 1, 6, 4, 2, 8, 9};
        //排序前；
        printArray(arr);

        //排序
        //selectSort(arr);
        //bubbleSort(arr);

        //Arrays.sort(arr);//java中已经定义好的一种排序方式。开发中，对数组排序。要使用该句代码。
        //排序后：
        printArray(arr);
    }
    /*
     * 对给定的数组进行反转。 {3,1,5,6,2} ---> {2,6,5,1,3}
     */
    @Test
    public void testArray3() {

        int[] arr = {3, 1, 5, 6, 2};
        printArray(arr);

        //反转后;
        reverseArray(arr);

        printArray(arr);
    }
    /* *******************************************************************/
	/*
	 * 数组的查找操作。
	 *
	 * 练习：有一个有序的数组，想要将一个元素插入到该数组中， 还要保证该数组是有序的。如何获取该元素在数组中的位置。
	 */
    @Test
    public void testArray4() {
        //	int[] arr = {3,2,1,5,4,2,9};
        //		int index = getIndex(arr,2);
        //		System.out.println("index="+index);

        int[] arr = {2, 4, 5, 7, 8, 19, 32, 45};//8

        int index = getIndex_2(arr, 190);
        System.out.println("index=" + index);

        //		int x = Arrays.binarySearch(arr,190);//java提供好的一个进行折半查找的功能。开发时使用这个。
        //		System.out.println("x="+x);

    }
    /* 进制转化*/
    @Test
    public void testArray5() {

        //toBin(6);
        toHex(60);
    }
    /* *******************************************************************/
    @Test
    public void testArray6() {
        //toBin(-6);
        //toHex(-60);
        //toBa(60);

        //				System.out.println(Integer.toBinaryString(6));
        //				System.out.println(Integer.toHexString(6));

    }
	
	/* *******************************************************************/
	/* *******************************************************************/

}
