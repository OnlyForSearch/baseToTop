package cn.feng.thinkInJava.a10_1_IO.FileReaderAndWriter;


import java.io.FileReader;
import java.io.IOException;

class FileReaderDemo {

    public static void main(String[] args) throws IOException {
        //����һ���ļ���ȡ�����󣬺�ָ����Ƶ��ļ��������
        //Ҫ��֤���ļ����Ѿ����ڵģ������ڣ��ᷢ���쳣FileNotFoundException
        FileReader fr = new FileReader("FileReaderDemo.java");

        //���ö�ȡ�������read������
        //read():һ�ζ�һ���ַ���һ��Զ����¶���

        int ch = 0;

        while ((ch = fr.read()) != -1) {
            System.out.println("ch=" + (char) ch);
        }


		/*
        while(true)
		{
			int ch = fr.read();
			if(ch==-1)
				break;
			System.out.println("ch="+(char)ch);
		}
		*/


        fr.close();


    }
}
