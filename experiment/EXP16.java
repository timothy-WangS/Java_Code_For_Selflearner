package experiment;

import java.text.ParseException;
import java.util.Calendar;

//System类：全为静态方法,不可被实例化
//		err，out，in：标准错误输出，输出，输入流
//		常见方法：	currentTimeMillis()获取毫秒值long
//			exit()退出、gc()调用垃圾回收
//			getProperty()获取系统属性property/setProperty(Str key,Str value)HashTable的put string/
//			System.getProperty("line.separator")具有最佳跨系统平台性的换行符
//			可定义做：static final String LINE_SEPARATOR = System.getProperty("line.separator");
//Runtime类：与运行环境相连，不能创建对象，不全是静态的(有方法返回本类对象-->单例)
//		创建方式：Runtime r = Runtime.getRuntime();
//		常用方法：r.exec("XXX.exe")开启可执行文件，在当前路径或path下，或使用绝对路径c:\\abc\\123.exe
//					|---->注意，绝对路径的文件夹名\要转义，用\\
//					|---->XXX.exe 文件：用XXX.exe解析文件
//					|---->返回值Process，抽象的，进程
//Math类：执行基本数学运算，指数对数平方根三角
//		常用值：E，PI
//		常用方法：	abs(x)绝对值/
//					asin(x)acos()atan()/sin()cos()tan()(反)三角函数，x用弧度制表示
//					exp(x)e的x次方
//					ceil(x)向上取整floor()向下取整round()四舍五入double/
//					max(x,y)min()返回最大、最小值/
//					pow(x,y)x的y次方double/
//					random()0~1伪随机数double/
//Date类：日期对象
//		年：y-1900；月：0-11表示1-12月；日：1-31；小时：0-23；分钟：0-59；秒：0-61(60,61闰秒)
//		毫秒转日期---->Date(long 毫秒值) 或   setTime()
//		日期转毫秒---->getTime()
//		常用方法：after(),before(),equals()---->comapareTo()比较日期前后
//|-->DateFormat类：格式化和解析日期字符串
//|		常用方法：日期->字符串
//				getDateInstance(DateFormat.风格)获取日期格式器
//|				getDateTimeInstance(DateFormat.风格,DateFormat.风格)获取日期时间格式器
//|				|---->格式器.format(date)--->str/
//|				|---->用FULL，LONG，SHORT指定风格
//|				|---->自定义风格
//|					|---->用SimpleDateFormat子类
//|					|---->dateFormat = new SimpleDateFormat(pattern)
//|				字符串->日期
//|				DateFormat中的format方法Date date = dateFormat.parse(str)注意非日期抛异常
//|		日期计算：换算date毫秒值，运算后再转成日期
//|				
//|-->Calendar类：实现日期与字段转换
//		常用方法：Calendar c = Calendar.getInstance()获取对象
//				用c.get(Calendar.YEAR、MONTH+1、DAY_OF_MONTH)获取年，月(记得+1)，日(月)
//				用c.get(DAY_OF_WEEK)时,星期日对应1,星期六对应7,用自定义函数转换成星期
//				c.set(year,month-1,day)设置c所储存的时间
//				c.add(Calendar.YEAR,2)向c的年增加2/时间偏移
//				
public class EXP16{
	public static void main(String[] args) throws ParseException{
////	Runtime r = Runtime.getRuntime();
////	r.exec("notepad.exe");
////	System.out.println(Math.PI);
		
////	long time = System.currentTimeMillis();
////	Date date = new Date(System.currentTimeMillis());
////	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.SHORT);
//		String sdate = "2018--2--27";
//		DateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd");//年份4位，月日2位
//		Date date =  dateFormat.parse(sdate);
////	String time = dateFormat.format(date);
//		System.out.println(date);
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
	}
}