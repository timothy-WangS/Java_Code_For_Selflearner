package experiment;
//�ַ��������������Ч�ʣ���EXP17��char[]
//BufferedReader
//		read()��ȡ�����ַ�(�ӻ������ڶ�ȡ����)
//		readLine()��ȡһ��(�������з�)
//		LineNumberReader�ࣺװ���࣬�к�
//		
//BufferedWriter
//		write()д�뵥���ַ����ַ���
//		write(char[],int begin,int len)д�ַ���һ����
//		newLine()����
//		flush(),close()ˢ�£��ر�
//
//װ�����ģʽ����һ�����Ĺ��ܽ�����ǿ
//		�������޸�ԭ������룬��������
//		�ڹ��캯���д���ԭ������p������this.p = p��������
//		װ�����뱻װ�������ͬ����һ���ӿڻ���
//		��ʵ���ǻ��ھ���
//		|---->�Ƚ��ڼ̳У����ܽ�����ǿ
//			|---->�̳У�Ҫ�м̳���ϵ������������Ч��
//			|---->װ�Σ�û�м̳���ϵ��һ���������ȼ̳����ü̳л�ʹ�̳���ϵӷ��

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
		final String LINE_SEPARATOR = System.getProperty("line.separator");//��ϵͳ����
		FileWriter fwriter = new FileWriter("D:\\programe\\java\\experiment\\filepack\\EXP18F.txt");
		//����������
		BufferedWriter bfwriter = new BufferedWriter(fwriter);
		//������д�� 
		bfwriter.write("abc"+LINE_SEPARATOR+"def");
		bfwriter.newLine();//���������л��з���
		bfwriter.write("aaa");
		bfwriter.flush();
		//һ��ʹ�û�������ʽ������������ѷ�װ���������ر�
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
		lnr.setLineNumber(10);//���õ�0���к�
		while ((line = lnr.readLine())!=null) {
			System.out.println(lnr.getLineNumber()+":"+line);
			
		}
		lnr.close();
	}
}
