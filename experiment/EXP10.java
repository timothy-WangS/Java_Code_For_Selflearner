package experiment;
public class EXP10{
	public static void main(String[] args) {
//		String a = "abc";
//		String A = "abc";			//System.out.println(a==A);true(地址值)
//		//字符串存在于常量池(字符串缓冲区)，有则利用，无则建立
//		//一旦创建不可修改，修改的是指向的缓冲区的地址
//		//String类中的equals方式覆写了Object方法判断的是字符串内容
//		String b = new String("abc");//System.out.println(a==b);false(地址值)
//		//产生两个对象，new和字符串对象，在堆区存储字符串对象的池中
//		String B = new String("abc");//System.out.println(B==b);false(地址值)		
//		byte[] arr1 = {97,98,99,100};
//		char[] arr2 = {'a','a','a','1'};
//		//new String(arr);转字符串时自动ASCII转码
//		//new String(arr,m,n)从m角标开始取n个
		//1.获取:	s.length()字符串长度int/
		//			s.charAt(角标)按位取值char/
		//			s.indexOf(值(,int 开始位))第一次出现位置int/
		//					     值：可以为int(ASCII码)，char，string。开始位不写默认0/
		//			s.lastIndexOf(值(,开始位))最后出现位置int/
		//			s.subString(int begin(，int end))返回子字符串(begin到end-1),不写默认到结尾string/
		//2.转换：	s.split(“切分标志”)字符串切分string[] arr/涉及到正则表达式
		//			s.toCharArray()按字节转成字符数组(中文两字节)char[] arr/
		//			s.toUpperCase()转大写//s.toLowerCase()转小写string/
		//			s.replace("old","new")替换(old、new为字符或字符串)string/
		//			s.trim()去除前后空格string/
		//			s.concat("后字符串")字符串链接/
		//3.判断：	s.equals(Object(string))判断内容相同boolean/
		//			s.equalsIgnoreCase(Object(string))忽略大小写判断内容相同boolean/
		//			s.contains(string)是否包含
		//			s.startsWith(string)以 开头//s.endsWith(string)以 结尾boolean/
		//			s.compareTo(a string)按次序依照字典顺序判断，s<a返回负数，相等为0，否则为正int/
		//
		//StringBuffer容器对象class字符串缓冲区
		//长度可变，接收不同类型数据，最终转成字符串使用
		//StringBuffer s = new StringBuffer(内容);
		//在执行下列操作时，返回的StringBuffer地址值仍然是s的地址值
		//1.添加		s.append(内容)尾部追加StringBuffer/
		//			s.insert(int位置角标，内容)指定位置插入StringBuffer/
		//2.删除		s.delet(int begin,int end)删除从begin到end-1StringBuffer/
		//			s.deletCharAt(int位置角标)删除指定位置字符StringBuffer/
		//			s.delet(0,s.length())清空缓冲区StringBuffer/
		//3.查找		s.charAt(角标)按位取值char/
		//			s.indexOf(值(,int 开始位))第一次出现位置int/
		//			s.lastIndexOf(值(,开始位))最后出现位置int/
		//4.修改		s.replace(int begin,int end,string)替换begin到end-1一段StringBuffer/
		//			s.setChar(int位置角标, char)替换指定位置字符void/
		//			s.setLength(int)设置长度；多的加入空字符，少的从尾删字符，设0清空void/
		//			s.reverse()反转StringBuffer/
		//
		//StringBuilder相似于StringBuffer；
		//		单线程下：Buffer执行多线程同步，但Builder因为不执行同步所以效率更高
		//单线程用Builder，多线程用Buffer
	}
}
