package cn.feng.thinkInJava.b5_1_网络通讯;
/*package cn.feng.test.����ͨѶ;


��дһ���������
������ݵĲ��֣��ͷ���ݵĲ��֡�
����������Ҫͬʱִ�С�
�Ǿ���Ҫ�õ����̼߳�����
һ���߳̿����գ�һ���߳̿��Ʒ���

��Ϊ�պͷ������ǲ�һ�µģ�����Ҫ��������run������
��������������Ҫ��װ����ͬ�����С�


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.Socket;
class Send implements Runnable
{
	private DatagramSocket ds;
	public Send(DatagramSocket ds)
	{
		this.ds = ds;
	}


	public void run()
	{
		try
		{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

			String line = null;

			while((line=bufr.readLine())!=null)
			{
				

				byte[] buf = line.getBytes();

				Socket s = new Socket("192.168.1.254",10004);
		
		        OutputStream out = s.getOutputStream();
				out.write(buf.length);

				if("886".equals(line))
					break;
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("���Ͷ�ʧ��");
		}
	}
}

class Rece implements Runnable
{

	private DatagramSocket ds;
	public Rece(DatagramSocket ds)
	{
		this.ds = ds;
	}
	public void run()
	{
		try
		{
			while(true)
			{
				byte[] buf = new byte[1024];
					Socket s = new Socket(10004);

				ds.receive(dp);


				String ip = dp.getAddress().getHostAddress();

				String data = new String(dp.getData(),0,dp.getLength());

				if("886".equals(data))
				{
					System.out.println(ip+"....�뿪������");
					break;
				}


				System.out.println(ip+":"+data);
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException("���ն�ʧ��");
		}
	}
}


class  ChatDemo
{
	public static void main(String[] args) throws Exception
	{
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10002);

		new Thread(new Send(sendSocket)).start();
		new Thread(new Rece(receSocket)).start();

	}
}
*/