package www.wujianbo.socket.one;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TestClient testClient= new TestClient();
		testClient.tcpSend();

	}
	
	private void tcpSend() throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("aa");
		Socket socket= new Socket("192.168.0.104", 554);
		OutputStream out= socket.getOutputStream();
		byte[] msg= "Hello,Welcome to woniuxy 2".getBytes();
		out.write(msg);
		socket.close();

	}

}
