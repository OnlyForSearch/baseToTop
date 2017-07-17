package cn.feng.thinkInJava;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FantTest {

    public static void main(String[] args) throws ParseException {
        System.out.println("我的");
        // TODO Auto-generated method stub
        /*FantTest fantTest=new FantTest();
        String times="我的话";
		System.out.println(times.length());
			
		
		int i=1_2;
		*/
	/*	System.out.println(new Date(1432172945));
		Double d=2525125125.21521245124;
		Double d2=2525125125.21521245123;
		System.out.println(d>=d2);*/
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time = new Long(143334720);
        String d = format.format(time);
        Date date = format.parse(d);
        System.out.println("Format To String(Date):" + d);
        System.out.println("Format To Date:" + date);
        //System.out.println(Double.MAX_VALUE);
        //1433347200
        //Date或者String转化为时间戳
        times1();

        Demo demo = new Demo();
        demo.setS1(null);
        System.out.println(demo.getS1());
    }
    //Date或者String转化为时间戳
    private static void times1() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2015-06-04 00:00:00";
        Date date = format.parse(time);
        System.out.print("Format To times:" + date.getTime());
    }

    public static boolean test(String time) {

        return true;
    }
    @Test
    public void test1() {
        String string = "    ";
        System.out.println(string.isEmpty());
    }


}

class Demo {

    String s1;

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

}
