package cn.feng.thinkInJava.a10_1_IO.File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/*
File�ೣ����
1��������
	boolean createNewFile():��ָ��λ�ô����ļ��������ļ��Ѿ����ڣ��򲻴���������false��
						���������һ�����������һ���������ļ��������ļ��Ѿ����ڣ��Ḳ�ǡ�

	boolean mkdir():�����ļ��С�
	boolean mkdirs():�����༶�ļ��С�
2��ɾ��
	boolean delete()��ɾ��ʧ�ܷ���false������ļ����ڱ�ʹ�ã���ɾ���˷���false��
	void deleteOnExit();�ڳ����˳�ʱɾ��ָ���ļ���


3���жϡ�
	boolean exists() :�ļ��Ƿ����.
	isFile():
	isDirectory();
	isHidden();
	isAbsolute();

4����ȡ��Ϣ��
	getName():
	getPath():
	getParent():

	getAbsolutePath() 
	long lastModified() 
	long length() 


	


*/


class FileDemo {

    public static void main(String[] args) throws IOException {
    }
    @Test
    public static void method_1() throws IOException {
        File f = new File("file.txt");
        //		sop("create:"+f.createNewFile());
        //sop("delete:"+f.delete());


    }
    @Test
    public static void method_2() {
        File f = new File("file.txt");

        //sop("exists:"+f.exists());

        //sop("execute:"+f.canExecute());

        //�����ļ���
        File dir = new File("abc\\kkk\\a\\a\\dd\\ee\\qq\\aaa");

        sop("mkdir:" + dir.mkdirs());
    }
    @Test
    public static void method_3() throws IOException {
        File f = new File("d:\\java1223\\day20\\file2.txt");

        //f.createNewFile();

        //f.mkdir();


        //��ס���ж��ļ������Ƿ����ļ�����Ŀ��ʱ������Ҫ���жϸ��ļ������װ�������Ƿ���ڡ�
        //ͨ��exists�жϡ�
        sop("dir:" + f.isDirectory());
        sop("file:" + f.isFile());

        sop(f.isAbsolute());
    }
    @Test
    public static void method_4() {
        File f = new File("file.txt");

        sop("path:" + f.getPath());
        sop("abspath:" + f.getAbsolutePath());
        sop("parent:" + f.getParent());//�÷������ص��Ǿ��·���еĸ�Ŀ¼������ȡ�������·��������null��
        //������·��������һ��Ŀ¼��ô��Ŀ¼���Ƿ��ؽ��


    }
    //����File����
    public static void consMethod() {
        //��a.txt��װ��file���󡣿��Խ����еĺ�Ϊ���ֵ��ļ������ļ��з�װ�ɶ���
        File f1 = new File("a.txt");

        //
        File f2 = new File("c:\\abc", "b.txt");


        File d = new File("c:\\abc");
        File f3 = new File(d, "c.txt");

        sop("f1:" + f1);
        sop("f2:" + f2);
        sop("f3:" + f3);

        File f4 = new File("c:" + File.separator + "abc" + File.separator + "zzz" + File.separator + "a.txt");


    }
    public static void sop(Object obj) {
        System.out.println(obj);
    }
    @Test
    public void method_5() {
        File f1 = new File("c:\\Test.java");
        File f2 = new File("d:\\hahah.java");

        sop("rename:" + f2.renameTo(f1));

    }
}
