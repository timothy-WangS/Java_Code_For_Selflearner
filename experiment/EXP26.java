package experiment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EXP26{
	public static void main(String[] args) throws IOException, Exception {
		//���÷������������ȡ�뷽��Ӧ��
//		System.out.println("main run");
//		setPCI();
		//������ʽ
		//�ж�ĳһλ�ϵ��ַ�
			//[abc]��[a-z��[^a]==>a��b��c��a��z�����С�����a����
			//[a-d[f-g]]a��d����f��g��[a-j&&[f-g]]a��j����f��g��[a-j[^f-g]]a��j��ȥf��g
			//Ԥ�����ַ�:"."�����ַ�"\d��\D"[0-9]��[^0-9]"\s��\S"�հ��ַ� �� �ǿհ��ַ�"\w��\W"��ĸ�����ĸ
			//ע�⣬��д��б��ʱҪд������ת��Ϊ����ķ�б�ߣ���"\\d"
		//�߽�ƥ����"$"�н�β
		//������
			//X?һ�λ��ޣ�X*�л��ޣ�X+һ�λ��Σ�X{n}n��,X{n,}����n��,X{n,m}n-m��
			//���X��������"�ж�ĳһλ�ϵ��ַ�"���ַ�������[a-g]{3,6}��ʾa��g��Χ���ַ���3��6��
		//ƥ��
//		String strqq = "1234567812";
//		String regex = "[1-9][0-9]{4,14}";/*��һλ1��9���ӵڶ�λ��ʼΪ0��9�ҹ���4��14������*/
//		boolean b = strqq.matches(regex);
//		System.out.println(b);
		//�и�
//		String str = "a     hj   ki k";
//		String regex = " +";
//		String[] words = str.split(regex);
//		for( String word:words) {
//			System.out.println(word);
		//�滻replaceAll
		//��ȡfind
//		}
		
	}
	static void setPCI() throws IOException, Exception {
		File config = new File("F:\\program\\java\\experiment\\filepack\\EXP26F.txt");
		FileInputStream fis = new FileInputStream(config);
		Properties prop = new Properties();
		prop.load(fis);
		for(int x=0;x<prop.size();x++) {
			String pciname = prop.getProperty("pci"+x);
			Class<?> clazz = Class.forName(pciname);
			@SuppressWarnings("deprecation")
			PCI p = (PCI)clazz.newInstance();
			usePCI(p);
		}
	}
	static void usePCI(PCI p) {
		if(p!=null) {
			p.turnon();
			p.turnoff();
		}
		
	}
}
interface PCI{
	void turnon();
	void turnoff();
}
