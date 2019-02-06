package experiment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.Set;

//Map--HashTable--Properties
//�ص�
//1.����ֵ�����ַ�������
//2.����������أ����ڲ����Լ�ֵ����ʽ���ڵ������ļ�
//Ӧ��
//	1.��ȡ
//		��prop.setProperty(str,str)
//		ȡprop.stringPropertyNames()��ȡ����Set����
//		  prop.getProperty(key)���ս���ȡֵ
//	2.IO���
//		���prop.list(PrintStream)����ֽ���
//		|---->�洢store(�ַ���/�ֽ�����ע����Ϣ)
//		����prop.load(InputStream)�����ֽ���
//		|---->ע��ڷ�ת��
//	3.��ȡ
//		getProperty
//
public class EXP22{
	public static void main(String[] args) throws IOException{
		Properties prop = new Properties();
//		sEt(prop);//��
//		gEt(prop);//ȡ
//		prop.setProperty("13", "����");//�޸�Ԫ�أ�����ͬ��ֵ����
//		gEt(prop);
//		dataStore(prop);
		prop = dataGet();
		keyGet(prop);//��������ֵ
		
	}
	static void sEt(Properties prop) {
		prop.setProperty("13", "����");
		prop.setProperty("14", "����");
		prop.setProperty("15", "����");
		prop.setProperty("16", "zhaoliu");
		prop.setProperty("17", "sunqi");
	}
	static void gEt(Properties prop) {
		Set<String> nums = prop.stringPropertyNames();
		for(String num:nums) {
			String value = prop.getProperty(num);
			System.out.println(num+":"+value);
		}
	}
	static void dataStore(Properties prop) throws IOException{
//		prop.list(System.out);//����̨���
		FileOutputStream fos = null;
		fos = new FileOutputStream("O:\\programme\\java\\experiment\\filepack\\EXP22F.txt");
		OutputStreamWriter out = new OutputStreamWriter(fos, "gbk");
		prop.store(out,"ѧ��+name");//prop��������޷���ת������������,��Ϊ���뷽ʽ��ͬ;ע����Ϣ����������
		out.close();
	}
	static Properties dataGet() throws IOException{
		FileInputStream fis = null;
		fis = new FileInputStream("O:\\programme\\java\\experiment\\filepack\\EXP22F.txt");
		Properties prop = new Properties();
		InputStreamReader ir = new InputStreamReader(fis,"gbk");
		prop.load(ir);
		ir.close();
		return prop;
	}
	static void keyGet(Properties prop) {
		System.out.println(prop.getProperty("16"));
	}
}
	