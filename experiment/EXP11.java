package experiment;
public class EXP11{
	//基本数据类型包装类
	//byte	short	int		long	float	double	char		boolean
	//Byte	Short	Integer	Long	Float	Double	Character 	Boolean
	//
	//Integer:
	//int最大最小，比特位，字符与进制转换，比较大小
	public static void main(String[] args) {
//		int num = 12;
//		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Integer.toHexString(num));
//
////-------------Integer.parseInt(string)字符串转数字int-------------/
////-------------Xxx.parse_xxx_(string)字符串转数字_xxx_-------------/
////-------------boolean必须要是Boolean类型，char无该方法-------------/
//		String s1 = "123";
//		String s2 = "true";
//		int x = Integer.parseInt(s1);
//		long y = Long.parseLong(s1);
//		boolean z = Boolean.parseBoolean(s2);
//		System.out.println(s1+1);
//		System.out.println(x+1);
//		System.out.println(y-1);
//		System.out.println(z);
//
////------------------如果字符串中对象被Integer封装------------------/
////------------------可用intValue将Integer转为int------------------/
//		Integer i = new Integer("123");
//		System.out.println(i.intValue(););
//
////--------------------------十进制->其他--------------------------/
////--------------------------to___String--------------------------/
////-------------------------toString(_,_)-------------------------/		
//		int x = 12;
//		System.out.println(Integer.toBinaryString(x));//2
//		System.out.println(Integer.toOctalString(x));//8
//		System.out.println(Integer.toHexString(x));//16
//		System.out.println(Integer.toString(x, 5));//5
//
////--------------------------其他->十进制--------------------------/
////-------------------------parseInt(_,_)-------------------------/
//		String s = "1100";
//		System.out.println(Integer.parseInt(s, 2));//二进制的s转为十进制
//
//
////----------------------------比较大小--------------------------/
////-------------------Integer.compareTo(Integer)----------------/
////-------------------大于为+1，小于为-1，相等为0-----------------/
//		Integer a = new Integer("5");
//		Integer b = new Integer("3");
//		System.out.println(a.compareTo(b));//+1
//
////-----------JDK 1.5以后出现的Integer简化书写(自动装箱)-----------/
////-----------------------类似于int操作方法-----------------------/
////-------------------------需要健壮性判断------------------------/
////--------赋值<-127(一个字节),不会开辟新空间，采用已有地址--------/
//		Integer a = 4;
//		//Integer b ="13";//不允许
//		a+=6;
//		Integer b1 =127;
//		Integer b2 =127;//b1==b2;b1 equals b2
//		Integer b3 =128;
//		Integer b4 =128;//b3!=b4;b3 equals b4
//
	}
}