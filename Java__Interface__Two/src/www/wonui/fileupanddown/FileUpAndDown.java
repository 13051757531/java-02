package www.wonui.fileupanddown;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUpAndDown {
	public String myCookie;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileUpAndDown fad = new FileUpAndDown();
		// fad.fileDown_one();
		// fad.fileDown_two();
		// fad.fileDown_one("http://www.woniuxy.com/learn/train/icon/android-icon.png",
		// "D:\\");
		// fad.fileUp_one();
		// fad.fileUp_two();
		// fad.fileUp_three();
		//fad.fileUp_five();
		fad.fileUp_four("http://localhost/secure/defect.php", "C:\\Users\\Administrator\\Desktop\\123.png", "attachment");
		fad.fileUp_four("http://localhost/Agileone/index.php/attach/upload/refertype/defect/referid/3", "C:\\Users\\Administrator\\Desktop\\123.png", "fileToUpload");

	}

	private void fileUp_one() {
		// TODO Auto-generated method stub
		String url_upWeb = "http://localhost/secure/defect.php";
		String path_file = "C:\\Users\\Administrator\\Desktop\\123.png";
		HttpURLConnection urlConnection = null;

		try {
			URL url = new URL(url_upWeb);
			urlConnection = (HttpURLConnection) url.openConnection();

			// 本次连接相关的参数设置
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);
			urlConnection.setConnectTimeout(10000);
			urlConnection.setReadTimeout(10000);
			urlConnection.setUseCaches(false);
			urlConnection.setRequestMethod("POST");

			// setRequestProperty设置HTTP请求的头部信息
			urlConnection.setRequestProperty("User-Agent", "Jvaa-Client");
			urlConnection.setRequestProperty("Cookie", this.myCookie);
			urlConnection.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=---------------------------29883193625667");

			// 定义数据输出流
			OutputStream os = urlConnection.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			dos.writeBytes("-----------------------------29883193625667\r\n");
			// String path= "C:\\Users\\Administrator\\Desktop\\123.png";
			// dos.writeBytes("Content-Disposition: form-data;
			// name=\"attachment\";
			// filename=\"C:\\Users\\Administrator\\Desktop\\123.png\"\r\n");
			dos.writeBytes("Content-Disposition: form-data; name=\"attachment\"; filename=" + path_file + "\r\n\r\n");
			dos.writeBytes("Content-Type: image/png\r\n\r\n");

			// 定义文件输入流
			FileInputStream fis = new FileInputStream(path_file);
			DataInputStream dis = new DataInputStream(fis);

			byte[] buf = new byte[1024];
			int bufLen = 0;
			while ((bufLen = dis.read(buf)) != -1) {
				dos.write(buf, 0, bufLen);
			}
			// dos.writeBytes("\r\n");
			dos.writeBytes("\r\n-----------------------------29883193625667--\r\n");
			dos.flush();
			System.out.println(urlConnection.getResponseCode());

			dis.close();
			fis.close();
			dos.close();
			urlConnection.disconnect();

			// 正式建立连接并发送POST报文
			// urlConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void fileUp_two() {
		// TODO Auto-generated method stub
		String url_upWeb = "http://localhost/secure/defect.php";
		String path_file = "C:\\Users\\Administrator\\Desktop\\123.png";
		HttpURLConnection urlConnection = null;

		try {
			URL url = new URL(url_upWeb);
			urlConnection = (HttpURLConnection) url.openConnection();

			// 本次连接相关的参数设置
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);

			// setRequestProperty设置HTTP请求的头部信息
			urlConnection.setRequestProperty("Content-Type",
					"multipart/form-data; boundary=---------------------------29883193625667");

			// 定义数据输出流
			OutputStream os = urlConnection.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			dos.writeBytes("-----------------------------29883193625667\r\n");
			// String path= "C:\\Users\\Administrator\\Desktop\\123.png";
			// dos.writeBytes("Content-Disposition: form-data;
			// name=\"attachment\";
			// filename=\"C:\\Users\\Administrator\\Desktop\\123.png\"\r\n");
			dos.writeBytes("Content-Disposition: form-data; name=\"attachment\"; filename=" + path_file + "\r\n");
			dos.writeBytes("Content-Type: image/png\r\n\r\n");

			// 定义文件输入流
			FileInputStream fis = new FileInputStream(path_file);
			DataInputStream dis = new DataInputStream(fis);

			byte[] buf = new byte[1024];
			int bufLen = 0;
			while ((bufLen = dis.read(buf)) != -1) {
				dos.write(buf, 0, bufLen);
			}
			// dos.writeBytes("\r\n");
			dos.writeBytes("\r\n-----------------------------29883193625667--\r\n");
			dos.flush();
			System.out.println("返回码为：" + urlConnection.getResponseCode());

			dis.close();
			fis.close();
			dos.close();
			urlConnection.disconnect();

			// 正式建立连接并发送POST报文
			// urlConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void fileUp_three() {
		// TODO Auto-generated method stub
		String url_upWeb = "http://localhost/secure/defect.php";
		String path_file = "C:\\Users\\Administrator\\Desktop\\123.png";
		HttpURLConnection urlConnection = null;
		String boundary = "##bodary__body##";
		try {
			URL url = new URL(url_upWeb);
			urlConnection = (HttpURLConnection) url.openConnection();

			// 本次连接相关的参数设置
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);

			// setRequestProperty设置HTTP请求的头部信息
			urlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

			// 定义数据输出流
			OutputStream os = urlConnection.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			dos.writeBytes("--" + boundary + "\r\n");
			// String path= "C:\\Users\\Administrator\\Desktop\\123.png";
			// dos.writeBytes("Content-Disposition: form-data;
			// name=\"attachment\";
			// filename=\"C:\\Users\\Administrator\\Desktop\\123.png\"\r\n");
			dos.writeBytes("Content-Disposition: form-data; name=\"attachment\"; filename=" + path_file + "\r\n");
			dos.writeBytes("Content-Type: image/png\r\n\r\n");

			// 定义文件输入流
			FileInputStream fis = new FileInputStream(path_file);
			DataInputStream dis = new DataInputStream(fis);

			byte[] buf = new byte[1024];
			int bufLen = 0;
			while ((bufLen = dis.read(buf)) != -1) {
				dos.write(buf, 0, bufLen);
			}
			// dos.writeBytes("\r\n");
			dos.writeBytes("\r\n--" + boundary + "--\r\n");
			dos.flush();
			System.out.println("返回码为：" + urlConnection.getResponseCode());

			dis.close();
			fis.close();
			dos.close();
			urlConnection.disconnect();

			// 正式建立连接并发送POST报文
			// urlConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void fileUp_four(String urlWeb, String pathFile, String spaceName) {
		// TODO Auto-generated method stub
		// String url_upWeb= "http://localhost/secure/defect.php";
		// String path_file= "C:\\Users\\Administrator\\Desktop\\123.png";
		// String space_Name= "fileToUpload";
		 String url_upWeb= urlWeb;
		 String path_file= pathFile;
		 String space_Name= spaceName;
		HttpURLConnection urlConnection = null;
		String boundary = "##bodary__body##";
		try {
			URL url = new URL(url_upWeb);
			urlConnection = (HttpURLConnection) url.openConnection();

			// 本次连接相关的参数设置
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);

			// setRequestProperty设置HTTP请求的头部信息
			urlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

			// 定义数据输出流
			OutputStream os = urlConnection.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			dos.writeBytes("--" + boundary + "\r\n");
			// String path= "C:\\Users\\Administrator\\Desktop\\123.png";
			// dos.writeBytes("Content-Disposition: form-data;
			// name=\"attachment\";
			// filename=\"C:\\Users\\Administrator\\Desktop\\123.png\"\r\n");
			dos.writeBytes("Content-Disposition: form-data; name=" + space_Name + "; filename=" + path_file + "\r\n");
			dos.writeBytes("Content-Type: image/png\r\n\r\n");

			// 定义文件输入流
			FileInputStream fis = new FileInputStream(path_file);
			DataInputStream dis = new DataInputStream(fis);

			byte[] buf = new byte[1024];
			int bufLen = 0;
			while ((bufLen = dis.read(buf)) != -1) {
				dos.write(buf, 0, bufLen);
			}
			// dos.writeBytes("\r\n");
			dos.writeBytes("\r\n--" + boundary + "--\r\n");
			dos.flush();
			System.out.println("返回码为：" + urlConnection.getResponseCode());

			dis.close();
			fis.close();
			dos.close();
			urlConnection.disconnect();

			// 正式建立连接并发送POST报文
			// urlConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void fileUp_five() {
		// TODO Auto-generated method stub
		String url_upWeb = "http://localhost/Agileone/index.php/attach/upload/refertype/defect/referid/3";
		String path_file = "C:\\Users\\Administrator\\Desktop\\123.png";
		String spaceName = "fileToUpload";
		HttpURLConnection urlConnection = null;
		String boundary = "##bodary__body##";
		try {
			URL url = new URL(url_upWeb);
			urlConnection = (HttpURLConnection) url.openConnection();

			// 本次连接相关的参数设置
			urlConnection.setDoOutput(true);
			urlConnection.setDoInput(true);

			// setRequestProperty设置HTTP请求的头部信息
			urlConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

			// 定义数据输出流
			OutputStream os = urlConnection.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			dos.writeBytes("--" + boundary + "\r\n");
			// String path= "C:\\Users\\Administrator\\Desktop\\123.png";
			// dos.writeBytes("Content-Disposition: form-data;
			// name=\"attachment\";
			// filename=\"C:\\Users\\Administrator\\Desktop\\123.png\"\r\n");
			dos.writeBytes("Content-Disposition: form-data; name=" + spaceName + "; filename=" + path_file + "\r\n");
			dos.writeBytes("Content-Type: image/png\r\n\r\n");

			// 定义文件输入流
			FileInputStream fis = new FileInputStream(path_file);
			DataInputStream dis = new DataInputStream(fis);

			byte[] buf = new byte[1024];
			int bufLen = 0;
			while ((bufLen = dis.read(buf)) != -1) {
				dos.write(buf, 0, bufLen);
			}
			// dos.writeBytes("\r\n");
			dos.writeBytes("\r\n--" + boundary + "--\r\n");
			dos.flush();
			System.out.println("返回码为：" + urlConnection.getResponseCode());

			dis.close();
			fis.close();
			dos.close();
			urlConnection.disconnect();

			// 正式建立连接并发送POST报文
			// urlConnection.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void fileDown_one() {
		// TODO Auto-generated method stub
		String url_file = "http://www.woniuxy.com/learn/train/icon/communicate.png";
		String path_fileSave = "D:\\";

		URL url;
		try {
			url = new URL(url_file);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			// 连接参数设置
			urlconnection.setConnectTimeout(30000);
			urlconnection.setReadTimeout(30000);
			urlconnection.setUseCaches(false);
			urlconnection.setRequestMethod("GET");

			urlconnection.connect();

			InputStream is = urlconnection.getInputStream();
			byte[] buf = new byte[1024];// 新建字节数组，缓存由服务器获取的内容
			while (is.read(buf) != -1) {
				for (int i = 0; i < buf.length; i++) {
					System.out.println(buf[i]);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void fileDown_two() {
		// TODO Auto-generated method stub
		String url_file = "http://www.woniuxy.com/learn/train/icon/communicate.png";
		String path_fileSave = "D:\\";

		URL url;
		try {
			url = new URL(url_file);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			// 连接参数设置
			urlconnection.setConnectTimeout(30000);
			urlconnection.setReadTimeout(30000);
			urlconnection.setUseCaches(false);
			urlconnection.setRequestMethod("GET");

			urlconnection.connect();

			// 定义个输入流，获取服务器端文件字节流
			InputStream is = urlconnection.getInputStream();

			// 定义文件输出流，将下载文件保存到硬盘
			int postLast = url_file.lastIndexOf("/") + 1;
			String fileName = url_file.substring(postLast);
			// System.out.println(fileName);
			fileName = path_fileSave + fileName;
			File outFile = new File(fileName);
			// System.out.println(fileName);
			OutputStream os = new FileOutputStream(outFile);

			byte[] buf = new byte[1024];// 定义个数组，用于缓存从服务器获取的数据
			int bufLen = 0;
			while ((bufLen = is.read(buf)) != -1) {
				byte[] temp = new byte[bufLen];
				System.arraycopy(buf, 0, temp, 0, bufLen);
				os.write(temp);
			}

			urlconnection.disconnect();
			os.close();
			is.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fileDown_one(String urlTemp, String pathTemp) {
		// TODO Auto-generated method stub
		// String url_file=
		// "http://www.woniuxy.com/learn/train/icon/communicate.png";
		// String path_fileSave= "D:\\";
		String url_file = urlTemp;
		String path_fileSave = pathTemp;

		URL url;
		try {
			url = new URL(url_file);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			// 连接参数设置
			urlconnection.setConnectTimeout(30000);
			urlconnection.setReadTimeout(30000);
			urlconnection.setUseCaches(false);
			urlconnection.setRequestMethod("GET");

			urlconnection.connect();

			// 定义个输入流，获取服务器端文件字节流
			InputStream is = urlconnection.getInputStream();

			// 定义文件输出流，将下载文件保存到硬盘
			int postLast = url_file.lastIndexOf("/") + 1;
			String fileName = url_file.substring(postLast);
			// System.out.println(fileName);
			fileName = path_fileSave + fileName;
			File outFile = new File(fileName);
			// System.out.println(fileName);
			OutputStream os = new FileOutputStream(outFile);

			byte[] buf = new byte[1024];// 定义个数组，用于缓存从服务器获取的数据
			int bufLen = 0;
			while ((bufLen = is.read(buf)) != -1) {
				byte[] temp = new byte[bufLen];
				System.arraycopy(buf, 0, temp, 0, bufLen);
				os.write(temp);
			}

			urlconnection.disconnect();
			os.close();
			is.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
