package experiment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//IO流：Input & Output
//输入：硬盘等外设到内存(读)；输出：内存到硬盘等外设(写)
//按操作的数据分为：字节流(能处理所有数据)，字符流(字节流读取后，先查编码表获取文字再操作)
//文字数据优先考虑字符流
//IO流基类： 			输入			输出
//			字节流：InputStream	OutputStream
//			字符流：Reader		Writer
//子类后缀为父类名，前缀为功能
//IO异常处理：创建文件，写入失败，关闭失败
//			在try外创建对象，在try内初始化
//			在finally如果已创建输出流对象 fW!=null，则定义关闭动作并用try包围
//
//
//FileWriter：创建一个可以写入数据的文件,不存在会创建,存在会覆盖
//				FileWriter fWriter = new FileWriter("EXP17F.txt");
//				调用Write方法写入数据到临时存储缓冲区
//				用刷新(flush)将数据写入目标(最后一次写入用close，数据写入且关闭流和资源)
//				在创建时，写做("EXP17F.txt",true)可以进行续写
//				
//FileReader：初始化时必须有文件，否则抛异常
//				每读取一次向后移动一位
//				每一位为char类型，写做int类型，最末尾以-1结束
//				可以用char[]方式读取数据，效率更高
//				|---->先创建char数组,长度最好是1024整数倍
//				|---->fReader.read(char[] tmp)返回值int为本次读到的位数
//				|---->一次读长度数量的位数,并移动到该位的下一位
//				|---->下一次读取时，数组会从0角标开始覆盖字符,无字符时保留上一次读取的
//				
public class EXP17{
	public static void main(String[] args) throws IOException {
		//文件的复制操作
//		FileReader fR = new FileReader("O:\\programme\\java\\experiment\\filepack\\EXP17F.txt");
//		FileWriter fW = new FileWriter("O:\\programme\\java\\experiment\\filepack\\EXP17E.txt");
//		char[] temp = new char[1024];
//		int num = 0;
//		while((num = fR.read(temp))!=-1) {
//			fW.write(temp, 0, num);
//		}
//		fR.close();
//		fW.close();
		
		fileWrite();
		fileRead();
	}
	static void fileWrite() {
		final String LINE_SEPARATOR = System.getProperty("line.separator");//多系统兼容
		FileWriter fWriter = null;
		try {
			fWriter = new FileWriter("D:\\programe\\java\\experiment\\filepack\\EXP17F.txt");
			fWriter.write("abc1"+LINE_SEPARATOR);//Win换行必须要用\r\n才行,此处用了多系统兼容
			fWriter.flush();
			fWriter.write("我爱JAVA");
			fWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fWriter!=null) {
				try {
					fWriter.close();
				}catch (IOException e) {
					throw new RuntimeException("关闭失败");
				}
			}
		}
	}
	static void fileRead() throws IOException {
		FileReader fReader = null;
		fReader = new FileReader("D:\\programe\\java\\experiment\\filepack\\EXP17F.txt");
//		int tmp;
//		while((tmp = fReader.read())!=-1) {
//			System.out.print((char)tmp);
//		}
//		fReader.close();
		char[] tmp = new char[7];//创建数组,一次读7位,并移动到该位的下一位,长度最好是1024倍数;多的空位补
		int num = fReader.read(tmp);//num为本次读取到的字符数,换行\r\n两位
		System.out.println(num+":"+new String(tmp));
		num = fReader.read(tmp);//num为第二次次读取到的字符数
		System.out.println(num+":"+new String(tmp));//数组会从0角标开始覆盖字符,无字符时保留上一次的
		fReader.close();
	}
}