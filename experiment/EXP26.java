package experiment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EXP26{
	public static void main(String[] args) throws IOException, Exception {
		//运用反射完成类对象获取与方法应用
//		System.out.println("main run");
//		setPCI();
		//正则表达式
		//判断某一位上的字符
			//[abc]与[a-z与[^a]==>a或b或c、a到z内所有、除了a以外
			//[a-d[f-g]]a到d并上f到g、[a-j&&[f-g]]a到j交上f到g、[a-j[^f-g]]a到j除去f到g
			//预定义字符:"."所有字符"\d与\D"[0-9]与[^0-9]"\s与\S"空白字符 与 非空白字符"\w与\W"字母与非字母
			//注意，在写反斜线时要写两个，转义为正则的反斜线，如"\\d"
		//边界匹配器"$"行结尾
		//数量词
			//X?一次或无，X*有或无，X+一次或多次，X{n}n次,X{n,}至少n次,X{n,m}n-m次
			//这个X就是上述"判断某一位上的字符"的字符串，如[a-g]{3,6}表示a到g范围内字符有3到6个
		//匹配
//		String strqq = "1234567812";
//		String regex = "[1-9][0-9]{4,14}";/*第一位1到9，从第二位开始为0到9且共有4到14个数字*/
//		boolean b = strqq.matches(regex);
//		System.out.println(b);
		//切割
//		String str = "a     hj   ki k";
//		String regex = " +";
//		String[] words = str.split(regex);
//		for( String word:words) {
//			System.out.println(word);
		//替换replaceAll
		//获取find
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
