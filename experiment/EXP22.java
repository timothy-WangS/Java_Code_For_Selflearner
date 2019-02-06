package experiment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;
import java.util.Set;

//Map--HashTable--Properties
//特点
//1.键和值都是字符串类型
//2.集合与流相关，用于操作以键值对形式存在的配置文件
//应用
//	1.存取
//		存prop.setProperty(str,str)
//		取prop.stringPropertyNames()获取键的Set集合
//		  prop.getProperty(key)按照建获取值
//	2.IO结合
//		输出prop.list(PrintStream)输出字节流
//		|---->存储store(字符流/字节流，注释信息)
//		输入prop.load(InputStream)输入字节流
//		|---->注意节符转换
//	3.获取
//		getProperty
//
public class EXP22{
	public static void main(String[] args) throws IOException{
		Properties prop = new Properties();
//		sEt(prop);//存
//		gEt(prop);//取
//		prop.setProperty("13", "张四");//修改元素，键相同，值覆盖
//		gEt(prop);
//		dataStore(prop);
		prop = dataGet();
		keyGet(prop);//按键索引值
		
	}
	static void sEt(Properties prop) {
		prop.setProperty("13", "张三");
		prop.setProperty("14", "李四");
		prop.setProperty("15", "王五");
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
//		prop.list(System.out);//控制台输出
		FileOutputStream fos = null;
		fos = new FileOutputStream("O:\\programme\\java\\experiment\\filepack\\EXP22F.txt");
		OutputStreamWriter out = new OutputStreamWriter(fos, "gbk");
		prop.store(out,"学号+name");//prop内容如果无符节转换不能有中文,因为编码方式不同;注释信息不能是中文
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
	