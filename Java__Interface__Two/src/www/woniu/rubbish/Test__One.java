package www.woniu.rubbish;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test__One {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Test__One testClient = new Test__One();
		// testClient.tcpSend();
		//testClient.doNumber();
		testClient.tcpSend__Two();
		//testClient.tcpSend__Three();

	}

	private void doNumber() throws Exception {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			this.tcpSend(i);
		}

	}

	private void tcpSend(int i) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		// System.out.println("aa");
		Socket socket = new Socket("192.168.50.1", 554);
		OutputStream out = socket.getOutputStream();
		String content = "Hello,Welcome to woniuxy_" + i;
		byte[] msg = content.getBytes();
		out.write(msg);
		socket.close();
	}

	private void tcpSend__Two() throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		// System.out.println("aa");
		for (int i = 0; i < 20; i++) {
			Socket socket = new Socket("192.168.50.1", 554);
			OutputStream out = socket.getOutputStream();
			String content = "Hello,Welcome to woniuxy_" + i;
			byte[] msg = content.getBytes();
			out.write(msg);
			out.flush();
			socket.close();
		}

		
	}
	
	private void tcpSend__Three() throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("aa");
		Socket socket = new Socket("192.168.50.1", 554);
		OutputStream out = socket.getOutputStream();
		for (int i = 0; i < 20; i++) {
			
			String content = "Hello,Welcome to woniuxy_" + i;
			byte[] msg = content.getBytes();
			out.write(msg);
			out.flush();
			Thread.sleep(2000);
		}
		socket.close();
	}

}