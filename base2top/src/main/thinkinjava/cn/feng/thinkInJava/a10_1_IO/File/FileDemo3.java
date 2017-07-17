package cn.feng.thinkInJava.a10_1_IO.File;


/*
�г�ָ��Ŀ¼���ļ������ļ��У�����Ŀ¼�е����ݡ�
Ҳ�����г�ָ��Ŀ¼���������ݡ�

��ΪĿ¼�л���Ŀ¼��ֻҪʹ��ͬһ���г�Ŀ¼���ܵĺ�����ɼ��ɡ�
���г�����г��ֵĻ���Ŀ¼�Ļ����������ٴε��ñ����ܡ�
Ҳ���Ǻ�������������?
���ֱ�����ʽ�����߱���ַ�����Ϊ�ݹ顣

�ݹ�Ҫע�⣺
1���޶�������

2��Ҫע��ݹ�Ĵ����������ڴ������





*/

import java.io.File;

class FileDemo3 {

    public static void main(String[] args) {
        File dir = new File("d:\\");
        showDir(dir, 0);

        //toBin(6);
        //int n = getSum(8000);
        //System.out.println("n="+n);

        //	System.out.println(dir.delete());
    }
    public static String getLevel(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("|--");
        for (int x = 0; x < level; x++) {
            //sb.append("|--");
            sb.insert(0, "|  ");

        }
        return sb.toString();
    }
    public static void showDir(File dir, int level) {

        System.out.println(getLevel(level) + dir.getName());

        level++;
        File[] files = dir.listFiles();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory())
                showDir(files[x], level);
            else
                System.out.println(getLevel(level) + files[x]);
        }
    }


    public static int getSum(int n) {
        if (n == 1)
            return 1;
        return n + getSum(n - 1);
    }

    public static void toBin(int num) {
        if (num > 0) {
            toBin(num / 2);
            System.out.println(num % 2);
        }
    }


    public static void method() {
        method();
    }


}