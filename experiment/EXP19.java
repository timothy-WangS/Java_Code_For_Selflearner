package experiment;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//�ֽ���:�������Բ����ַ��������Բ��������ļ�
//д��ʱ����Ҫ��ʱ�洢��ֱ��д��Ŀ�ĵأ�����Ҫflush������Ҫclose
//InputStream
//			fir.available()�������ļ���С
//OutputStream
//
//��������byte����������byte[]
//
public class EXP19{
	public static void main(String[] args) throws IOException {
//		btWrite();
//		btRead();
		//�����ļ�_1���Զ��建����
//		FileInputStream fir = null;
//		FileOutputStream fow = null;
//		fir = new FileInputStream("O:\\programme\\java\\experiment\\filepack\\EXP19B\\007.jpg");
//		fow = new FileOutputStream("O:\\programme\\java\\experiment\\filepack\\EXP19B\\007(j1).jpg");
//		byte [] buff = new byte[1024];
//		int temp;
//		while((temp = fir.read(buff))!=-1) {
//			fow.write(buff, 0, temp);
//			fow.flush();
//		}
//		fir.close();
//		fow.close();
		
		//�����ļ�_2��ϵͳ������
		FileInputStream fir = null;
		FileOutputStream fow = null;
		fir = new FileInputStream("O:\\programme\\java\\experiment\\filepack\\EXP19B\\007.jpg");
		fow = new FileOutputStream("O:\\programme\\java\\experiment\\filepack\\EXP19B\\007(j2).jpg");
		BufferedInputStream bfir = new BufferedInputStream(fir);
		BufferedOutputStream bfow = new BufferedOutputStream(fow);
//		byte [] buff = new byte[1024];	//Ҳ����д��,��ʱ����ٶ�???
		int len = 0;					//|---->
		while((len = bfir.read())!=-1) {//while((len = bfir.read(buff))!=-1) {
			bfow.write(len);			//bfow.write(buff, 0, len);
			bfow.flush();
		}
		bfir.close();
		bfow.close();
	}
	static void btWrite() throws IOException {
		FileOutputStream fow = null;
		fow = new FileOutputStream("O:\\programme\\java\\experiment\\filepack\\EXP19F.txt"); 
		fow.write("abcd".getBytes());
		fow.close();
	}
	static void btRead() throws IOException {
		FileInputStream fir = null;
		fir = new FileInputStream("O:\\programme\\java\\experiment\\filepack\\EXP19F.txt");
//		byte [] buff = new byte[fir.available()];//���ļ�ȫ���ŵ�������(�����ļ�Сʱʹ��)
		byte [] buff = new byte[1024];//�����ȡ��ʽ
		int temp;
		while((temp = fir.read(buff))!=-1) {
			System.out.println(new String(buff,0,temp));
		}
		fir.close();
	}
}
	