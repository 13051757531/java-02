package www.woniu.rubbish;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class FeiQiu {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FeiQiu fq= new FeiQiu();
		fq.udpSend();

	}
	
	private void udpSend() throws Exception {
		// TODO Auto-generated method stub
		//long packageId= System.currentTimeMillis();
		//String message= "1:100:shirouzu:jupiter:32:Hello Welcome to woniu";
		DatagramSocket ds= new DatagramSocket();
		for(int i=0;i<200; i++) {
			String message= "1:100:Administrator:2013-20170128YS:32:Hello Welcome to woniu_"+i;
			InetAddress des= InetAddress.getByName("192.168.50.129");
			byte[] buf= message.getBytes("GBK");
			
			DatagramPacket dp= new DatagramPacket(buf, buf.length, des, 2425);
			ds.send(dp);
		}
		ds.close();
	}

}
