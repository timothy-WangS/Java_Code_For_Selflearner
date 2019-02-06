package experiment;
//字符流缓冲区：提高效率，如EXP17的char[]
//BufferedReader
//		read()读取单个字符(从缓冲区内读取单个)
//		readLine()读取一行(不含换行符)
//		LineNumberReader类：装饰类，行号
//		
//BufferedWriter
//		write()写入单个字符、字符串
//		write(char[],int begin,int len)写字符串一部分
//		newLine()换行
//		flush(),close()刷新，关闭
//
//装饰设计模式：对一组对象的功能进行增强
//		尽量不修改原来类代码，建立新类
//		在构造函数中传入原有类型p，且用this.p = p关联旧类
//		装饰类与被装饰类必须同属于一个接口或父类
//		其实还是基于旧类
//		|---->比较于继承：都能进行增强
//			|---->继承：要有继承体系，面向对象提高效率
//			|---->装饰：没有继承体系，一脉单传。比继承灵活，用继承会使继承体系臃肿

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;

public class EXP18{
	public static void main(String[] args) throws IOException {
//		bWrite();
//		bReader();
		lnReader();
		
	}
	static void bWrite() throws IOException {
		final String LINE_SEPARATOR = System.getProperty("line.separator");//多系统兼容
		FileWriter fwriter = new FileWriter("D:\\programe\\java\\experiment\\filepack\\EXP18F.txt");
		//创建缓冲区
		BufferedWriter bfwriter = new BufferedWriter(fwriter);
		//缓冲区写入 
		bfwriter.write("abc"+LINE_SEPARATOR+"def");
		bfwriter.newLine();//缓冲区特有换行方法
		bfwriter.write("aaa");
		bfwriter.flush();
		//一律使用缓冲区方式操作，输出流已封装，无需额外关闭
		bfwriter.close();
	}
	static void bReader()throws IOException  {
		FileReader freader = new FileReader("D:\\programe\\java\\experiment\\filepack\\EXP18F.txt");
		BufferedReader bfreader = new BufferedReader(freader);
		String line = null;
		while((line = bfreader.readLine())!=null) {
			System.out.println(line);

		}
		bfreader.close();
	}
	static void lnReader() throws IOException{
		FileReader freader = new FileReader("D:\\programe\\java\\experiment\\filepack\\EXP18F.txt");
		LineNumberReader lnr = new LineNumberReader(freader);
		String line = null;
		lnr.setLineNumber(10);//设置第0行行号
		while ((line = lnr.readLine())!=null) {
			System.out.println(lnr.getLineNumber()+":"+line);
			
		}
		lnr.close();
	}
}
