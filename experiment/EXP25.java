package experiment;
//七层协议，四层协议
//DNS,IP,192.168.1.101,127.0.0.1,屏蔽原理
//UDP:快而不稳定，无需链接
//TCP:慢而稳定，三次握手
//socket通讯的两个端点之间数据IO传输
//传输结束后用socket.shutdownOutput,socket.shutdownInput结束输出输入
//多用户的TCP接收服务端(多线程)
//ServerSocket server =new ServerSocket(2314);
//while(true){
//	Socket socket = server.accept();//阻塞式
//	new Thread(new Task(socket)).start();//多线程开启
//}
//class Task implements Runnable{
//	private Socket socket;
//	private Task(Socket socket){
//		this.socket = socket;
//	}
//	public void run(){
//		try{
//			数据读写操作
//		}catch(IOException){
//			异常处理操作
//		}finally{
//			socket.close();//客户端
//		}	
//	}
//}
//

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class EXP25{
	public static void main(String[] args) throws Exception {
//		ipGet();
//		UdpThread t1 = new UdpThread();
//		new Thread(t1).start();
//		udpSend();
		
		TcpThread t2 = new TcpThread();
		new Thread(t2).start();
		tcpClient();
	}
	static void ipGet() throws UnknownHostException {
		InetAddress[] ips;
//		System.out.println(ip.getHostAddress());
//		System.out.println(ip.getHostName());
		ips = InetAddress.getAllByName("www.mygalgame.com");
		for(InetAddress ip:ips) {
			System.out.println(ip.getHostAddress());
		}
	}
	static void udpSend() throws IOException {
		//创建socket服务对象
		DatagramSocket datagram = new DatagramSocket(1987);
		//数据封装
		String str = "UDP传输测试";
		byte[] buf = str.getBytes();
		DatagramPacket dp = 
				new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"),2887);
		//包发送
		datagram.send(dp);
		System.out.println("已发送");
		//关闭资源
		datagram.close();
	}
	static void udpReceive() throws IOException {//阻塞式
		System.out.println("启动接收");
		//建立socket服务，必须明确端口号
		DatagramSocket datagram = new DatagramSocket(2887);
		//建立数据包储存区
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		//使用socket的receive方法存储
		datagram.receive(dp);
		//解析数据
		String ip = dp.getAddress().getHostAddress();//发送端地址
		int port = dp.getPort();//发送端口
		String data = new String(dp.getData(),0,dp.getLength());//数据
		System.out.println(ip+"////"+port+"////"+data);
		//关闭资源
		datagram.close();
	}
	static void tcpClient() throws UnknownHostException, IOException {
		System.out.println("开始传输");
		//创建客户端socket对象,确定要连接的主机，建立传输通道
		Socket socket = new Socket("192.168.0.101", 2314);
		//传输通道已建立(socket流)，可用getOutputStream与getInputStream获取字节流
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		//使用输入/输出流操作
		out.write("TCP传输测试".getBytes());
		socket.shutdownOutput();//结束传送
		//可选项目：客户端接受反馈
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String data = new String(buf, 0, len);
		System.out.println(data);
		//关闭资源
		socket.close();
	}
	static void tcpServer() throws IOException {
		System.out.println("开启接收");
		//创建服务端socket服务，ServerSocket,服务端对外提供端口给客户端连接
		ServerSocket server =new ServerSocket(2314);
		//获取连接的客户端对象
		Socket socket = server.accept();//阻塞式
		//获取客户端socket流，读取数据
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String data = new String(buf, 0, len);
		String ip = socket.getInetAddress().getHostAddress();
		System.out.println("来自"+ip+"的消息："+data);
		//可选项目：给客户端反馈
		out.write(("收到"+ip+"的数据").getBytes());
		//关闭资源(客户端和服务端)
		socket.close();//客户端
		server.close();//服务端，服务器一般是不关闭的
	}
}
class UdpThread implements Runnable{
	public void run() {
		try {
			EXP25.udpReceive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class TcpThread implements Runnable{
	public void run() {
		try {
			EXP25.tcpServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}