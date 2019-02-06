package experiment;
//�߲�Э�飬�Ĳ�Э��
//DNS,IP,192.168.1.101,127.0.0.1,����ԭ��
//UDP:������ȶ�����������
//TCP:�����ȶ�����������
//socketͨѶ�������˵�֮������IO����
//�����������socket.shutdownOutput,socket.shutdownInput�����������
//���û���TCP���շ����(���߳�)
//ServerSocket server =new ServerSocket(2314);
//while(true){
//	Socket socket = server.accept();//����ʽ
//	new Thread(new Task(socket)).start();//���߳̿���
//}
//class Task implements Runnable{
//	private Socket socket;
//	private Task(Socket socket){
//		this.socket = socket;
//	}
//	public void run(){
//		try{
//			���ݶ�д����
//		}catch(IOException){
//			�쳣�������
//		}finally{
//			socket.close();//�ͻ���
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
		//����socket�������
		DatagramSocket datagram = new DatagramSocket(1987);
		//���ݷ�װ
		String str = "UDP�������";
		byte[] buf = str.getBytes();
		DatagramPacket dp = 
				new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"),2887);
		//������
		datagram.send(dp);
		System.out.println("�ѷ���");
		//�ر���Դ
		datagram.close();
	}
	static void udpReceive() throws IOException {//����ʽ
		System.out.println("��������");
		//����socket���񣬱�����ȷ�˿ں�
		DatagramSocket datagram = new DatagramSocket(2887);
		//�������ݰ�������
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		//ʹ��socket��receive�����洢
		datagram.receive(dp);
		//��������
		String ip = dp.getAddress().getHostAddress();//���Ͷ˵�ַ
		int port = dp.getPort();//���Ͷ˿�
		String data = new String(dp.getData(),0,dp.getLength());//����
		System.out.println(ip+"////"+port+"////"+data);
		//�ر���Դ
		datagram.close();
	}
	static void tcpClient() throws UnknownHostException, IOException {
		System.out.println("��ʼ����");
		//�����ͻ���socket����,ȷ��Ҫ���ӵ���������������ͨ��
		Socket socket = new Socket("192.168.0.101", 2314);
		//����ͨ���ѽ���(socket��)������getOutputStream��getInputStream��ȡ�ֽ���
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		//ʹ������/���������
		out.write("TCP�������".getBytes());
		socket.shutdownOutput();//��������
		//��ѡ��Ŀ���ͻ��˽��ܷ���
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String data = new String(buf, 0, len);
		System.out.println(data);
		//�ر���Դ
		socket.close();
	}
	static void tcpServer() throws IOException {
		System.out.println("��������");
		//���������socket����ServerSocket,����˶����ṩ�˿ڸ��ͻ�������
		ServerSocket server =new ServerSocket(2314);
		//��ȡ���ӵĿͻ��˶���
		Socket socket = server.accept();//����ʽ
		//��ȡ�ͻ���socket������ȡ����
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String data = new String(buf, 0, len);
		String ip = socket.getInetAddress().getHostAddress();
		System.out.println("����"+ip+"����Ϣ��"+data);
		//��ѡ��Ŀ�����ͻ��˷���
		out.write(("�յ�"+ip+"������").getBytes());
		//�ر���Դ(�ͻ��˺ͷ����)
		socket.close();//�ͻ���
		server.close();//����ˣ�������һ���ǲ��رյ�
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