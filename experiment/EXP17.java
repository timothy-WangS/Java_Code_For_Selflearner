package experiment;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//IO����Input & Output
//���룺Ӳ�̵����赽�ڴ�(��)��������ڴ浽Ӳ�̵�����(д)
//�����������ݷ�Ϊ���ֽ���(�ܴ�����������)���ַ���(�ֽ�����ȡ���Ȳ������ȡ�����ٲ���)
//�����������ȿ����ַ���
//IO�����ࣺ 			����			���
//			�ֽ�����InputStream	OutputStream
//			�ַ�����Reader		Writer
//�����׺Ϊ��������ǰ׺Ϊ����
//IO�쳣���������ļ���д��ʧ�ܣ��ر�ʧ��
//			��try�ⴴ��������try�ڳ�ʼ��
//			��finally����Ѵ������������ fW!=null������رն�������try��Χ
//
//
//FileWriter������һ������д�����ݵ��ļ�,�����ڻᴴ��,���ڻḲ��
//				FileWriter fWriter = new FileWriter("EXP17F.txt");
//				����Write����д�����ݵ���ʱ�洢������
//				��ˢ��(flush)������д��Ŀ��(���һ��д����close������д���ҹر�������Դ)
//				�ڴ���ʱ��д��("EXP17F.txt",true)���Խ�����д
//				
//FileReader����ʼ��ʱ�������ļ����������쳣
//				ÿ��ȡһ������ƶ�һλ
//				ÿһλΪchar���ͣ�д��int���ͣ���ĩβ��-1����
//				������char[]��ʽ��ȡ���ݣ�Ч�ʸ���
//				|---->�ȴ���char����,���������1024������
//				|---->fReader.read(char[] tmp)����ֵintΪ���ζ�����λ��
//				|---->һ�ζ�����������λ��,���ƶ�����λ����һλ
//				|---->��һ�ζ�ȡʱ��������0�Ǳ꿪ʼ�����ַ�,���ַ�ʱ������һ�ζ�ȡ��
//				
public class EXP17{
	public static void main(String[] args) throws IOException {
		//�ļ��ĸ��Ʋ���
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
		final String LINE_SEPARATOR = System.getProperty("line.separator");//��ϵͳ����
		FileWriter fWriter = null;
		try {
			fWriter = new FileWriter("D:\\programe\\java\\experiment\\filepack\\EXP17F.txt");
			fWriter.write("abc1"+LINE_SEPARATOR);//Win���б���Ҫ��\r\n����,�˴����˶�ϵͳ����
			fWriter.flush();
			fWriter.write("�Ұ�JAVA");
			fWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fWriter!=null) {
				try {
					fWriter.close();
				}catch (IOException e) {
					throw new RuntimeException("�ر�ʧ��");
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
		char[] tmp = new char[7];//��������,һ�ζ�7λ,���ƶ�����λ����һλ,���������1024����;��Ŀ�λ��
		int num = fReader.read(tmp);//numΪ���ζ�ȡ�����ַ���,����\r\n��λ
		System.out.println(num+":"+new String(tmp));
		num = fReader.read(tmp);//numΪ�ڶ��δζ�ȡ�����ַ���
		System.out.println(num+":"+new String(tmp));//������0�Ǳ꿪ʼ�����ַ�,���ַ�ʱ������һ�ε�
		fReader.close();
	}
}