package experiment;
//��ȡ����¼�룺����һ��
//				������������StringBuilder str = new StringBuilder();
//				�������������洢���룬StringBuilder str = new StringBuilder();��str.append((char)ch);
//				�ж�����\r,\n,�������
//				���syso;������뻺������str.delete(0,str.length());�ȴ��´�����
//				�������Ķ��ԣ�����2�ֽ�->1�ַ����޷�������ȡ
//
//				��������
//				������������StringBuilder str = new StringBuilder();
//				��������ڷ�ת������������InputStreamReader isr = new InputStreamReader(ikey);
//					|---->�������ת����OutputStreamWriter������
//				�����ַ���ȡ����BufferedReader bfr = new BufferedReader(isr);
//				��ȡ���жϣ����(�Զ����������)
//				���Զ�ȡ����
//
//�ж�Ҫ���ĸ�����
//			1.��ȷԴ��Ŀ��(��)
//				|---->Դ	��InputStream��StreamReader
//				|---->Ŀ�ģ�OutputStream��StreamWriter
//			2.��ȷ�����Ƿ��ı�
//				|---->���ı���Reader��Writer
//				|---->���ı���Input��Output---->.read;.write
//			3.����Ǵ��ı�����ȷ�豸
//				|---->Դ
//					|---->Ӳ�̣�File
//					|---->���̣�System.in
//					|---->�ڴ棺����
//					|---->���磺Socket��
//				|---->Ŀ��
//					|---->Ӳ�̣�File
//					|---->����̨��System.out
//					|---->�ڴ棺����
//					|---->���磺Socket��
//			4.�Ƿ���Ҫ�������⹦��
//				|---->��Ч��Buffered
//				|---->ת����	����ڷ�InputStreamReader��ΪSystem.in�����ֽڣ�Ҫת���ַ������ڴ�
//							�������OutputStreamWriter��ΪSystem.out�����ֽڣ�������ַ�Ҫת��
//				|---->ָ����������������ת���� �� ָ�����->OutputStreamWriter(��������ַ��ļ�,"���")
//							��ȡ�Զ�����뷽ʽ���ļ���Ҫ�� ����ڷ�ת���� ����
//				|---->

//���̶�ȡ�Ĺرգ�ikey.close();//һ�㲻�أ�����֮���޷��ٿ���InputStream ikey2 = System.in;
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
		//������ļ�
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
		fw.write("���JAVA");
		fw.close();
	}
	static void rKeyBoard2() throws IOException {//ReadLine����
		/*InputStream ikey = System.in;
		InputStreamReader isr = new InputStreamReader(ikey);//���ֽ�ת��Ϊ�ַ�
		BufferedReader bfr = new BufferedReader(isr);*/
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));//��д��
		String tmp = null;
		while ((tmp=bfr.readLine())!=null) {
			if(tmp.equals("-1")) {
				break;
			}
//			System.out.println(tmp);
			wKeyBoard(tmp);//��������ڷ�ת���������(����syso)
		}
	}
	static void rKeyBoard1() throws IOException {//�Զ��巽��
		InputStream ikey = System.in;
		StringBuilder str = new StringBuilder();
		int ch = 0;//����ʽ����
		while((ch = ikey.read())!=-1) {
			if(ch=='\r')
				continue;
			if(ch=='\n') {
				String tmp = str.toString();
				if(tmp.equals("-1"))
					break;
				System.out.println(tmp);
				str.delete(0,str.length());//������뻺����
			}
			else {
				str.append((char)ch);
			}
		}

	}
	static void wKeyBoard(String tmp) throws IOException {
		//���������̨
		BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));
		bfw.write(tmp);
		bfw.newLine();
		bfw.flush();//����Ҫˢ�²������
		
	}
}