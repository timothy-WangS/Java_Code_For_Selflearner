package experiment;
//读取键盘录入：方法一：
//				开启输入流，StringBuilder str = new StringBuilder();
//				创建缓冲区，存储输入，StringBuilder str = new StringBuilder();与str.append((char)ch);
//				判断输入\r,\n,结束标记
//				输出syso;清空输入缓冲区，str.delete(0,str.length());等待下次输入
//				对于中文而言，由于2字节->1字符，无法这样读取
//
//				方法二：
//				开启输入流，StringBuilder str = new StringBuilder();
//				开启输入节符转换器，解码器InputStreamReader isr = new InputStreamReader(ikey);
//					|---->输出符节转换器OutputStreamWriter编码器
//				开启字符读取器，BufferedReader bfr = new BufferedReader(isr);
//				读取并判断，输出(自动清除缓冲区)
//				可以读取中文
//
//判断要用哪个对象：
//			1.明确源和目的(汇)
//				|---->源	：InputStream和StreamReader
//				|---->目的：OutputStream和StreamWriter
//			2.明确数据是否纯文本
//				|---->纯文本：Reader和Writer
//				|---->非文本：Input和Output---->.read;.write
//			3.如果是纯文本，明确设备
//				|---->源
//					|---->硬盘：File
//					|---->键盘：System.in
//					|---->内存：数组
//					|---->网络：Socket流
//				|---->目的
//					|---->硬盘：File
//					|---->控制台：System.out
//					|---->内存：数组
//					|---->网络：Socket流
//			4.是否需要其他额外功能
//				|---->高效：Buffered
//				|---->转换：	输入节符InputStreamReader因为System.in输入字节，要转成字符进入内存
//							输出符节OutputStreamWriter因为System.out接收字节，若输出字符要转换
//				|---->指定编码表：用输出符节转换器 并 指定码表->OutputStreamWriter(将输出的字符文件,"码表")
//							读取自定义编码方式的文件，要用 输入节符转换器 解析
//				|---->

//键盘读取的关闭：ikey.close();//一般不关，关流之后无法再开启InputStream ikey2 = System.in;
//
//
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class EXP20{
	public static void main(String[] args) throws IOException{
		rKeyBoard1();
//		rKeyBoard2();
		//输出到文件
//		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bfw = null;
//		bfw = new BufferedWriter(new FileWriter
//							("O:\\programme\\java\\experiment\\filepack\\EXP20F.txt"));
//								
//		String tmp = null;
//		while ((tmp=bfr.readLine())!=null) {
//			if(tmp.equals("-1")) {
//				break;
//			}
//			bfw.write(tmp);
//			bfw.flush();
//			bfw.newLine();
//		}
//		bfw.close();
//		writeText();
	}
	static void writeText() throws IOException {
		OutputStreamWriter fw = null;
		fw = new OutputStreamWriter(new FileOutputStream
								("O:\\programme\\java\\experiment\\filepack\\EXP20F.txt"),"UTF-8");
		fw.write("你好JAVA");
		fw.close();
	}
	static void rKeyBoard2() throws IOException {//ReadLine方法
		/*InputStream ikey = System.in;
		InputStreamReader isr = new InputStreamReader(ikey);//将字节转换为字符
		BufferedReader bfr = new BufferedReader(isr);*/
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));//简化写法
		String tmp = null;
		while ((tmp=bfr.readLine())!=null) {
			if(tmp.equals("-1")) {
				break;
			}
//			System.out.println(tmp);
			wKeyBoard(tmp);//调用输出节符转换器的输出(不用syso)
		}
	}
	static void rKeyBoard1() throws IOException {//自定义方法
		InputStream ikey = System.in;
		StringBuilder str = new StringBuilder();
		int ch = 0;//阻塞式方法
		while((ch = ikey.read())!=-1) {
			if(ch=='\r')
				continue;
			if(ch=='\n') {
				String tmp = str.toString();
				if(tmp.equals("-1"))
					break;
				System.out.println(tmp);
				str.delete(0,str.length());//清空输入缓冲区
			}
			else {
				str.append((char)ch);
			}
		}

	}
	static void wKeyBoard(String tmp) throws IOException {
		//输出到控制台
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		bfw.write(tmp);
		bfw.newLine();
		bfw.flush();//必须要刷新才能输出
		
	}
}