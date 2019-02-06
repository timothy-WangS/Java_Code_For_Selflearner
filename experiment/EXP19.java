package experiment;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//字节流:不仅可以操作字符，还可以操作其他文件
//写入时不需要临时存储，直接写入目的地，不需要flush，但仍要close
//InputStream
//			fir.available()：返回文件大小
//OutputStream
//
//操作的是byte，缓冲区是byte[]
//
public class EXP19{
	public static void main(String[] args) throws IOException {
//		btWrite();
//		btRead();
		//拷贝文件_1：自定义缓冲区
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
		
		//拷贝文件_2：系统缓冲区
		FileInputStream fir = null;
		FileOutputStream fow = null;
		fir = new FileInputStream("O:\\programme\\java\\experiment\\filepack\\EXP19B\\007.jpg");
		fow = new FileOutputStream("O:\\programme\\java\\experiment\\filepack\\EXP19B\\007(j2).jpg");
		BufferedInputStream bfir = new BufferedInputStream(fir);
		BufferedOutputStream bfow = new BufferedOutputStream(fow);
//		byte [] buff = new byte[1024];	//也可以写上,有时提高速度???
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
//		byte [] buff = new byte[fir.available()];//将文件全部放到缓冲区(仅在文件小时使用)
		byte [] buff = new byte[1024];//建议读取方式
		int temp;
		while((temp = fir.read(buff))!=-1) {
			System.out.println(new String(buff,0,temp));
		}
		fir.close();
	}
}
	