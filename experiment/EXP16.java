package experiment;

import java.text.ParseException;
import java.util.Calendar;

//System�ࣺȫΪ��̬����,���ɱ�ʵ����
//		err��out��in����׼��������������������
//		����������	currentTimeMillis()��ȡ����ֵlong
//			exit()�˳���gc()������������
//			getProperty()��ȡϵͳ����property/setProperty(Str key,Str value)HashTable��put string/
//			System.getProperty("line.separator")������ѿ�ϵͳƽ̨�ԵĻ��з�
//			�ɶ�������static final String LINE_SEPARATOR = System.getProperty("line.separator");
//Runtime�ࣺ�����л������������ܴ������󣬲�ȫ�Ǿ�̬��(�з������ر������-->����)
//		������ʽ��Runtime r = Runtime.getRuntime();
//		���÷�����r.exec("XXX.exe")������ִ���ļ����ڵ�ǰ·����path�£���ʹ�þ���·��c:\\abc\\123.exe
//					|---->ע�⣬����·�����ļ�����\Ҫת�壬��\\
//					|---->XXX.exe �ļ�����XXX.exe�����ļ�
//					|---->����ֵProcess������ģ�����
//Math�ִࣺ�л�����ѧ���㣬ָ������ƽ��������
//		����ֵ��E��PI
//		���÷�����	abs(x)����ֵ/
//					asin(x)acos()atan()/sin()cos()tan()(��)���Ǻ�����x�û����Ʊ�ʾ
//					exp(x)e��x�η�
//					ceil(x)����ȡ��floor()����ȡ��round()��������double/
//					max(x,y)min()���������Сֵ/
//					pow(x,y)x��y�η�double/
//					random()0~1α�����double/
//Date�ࣺ���ڶ���
//		�꣺y-1900���£�0-11��ʾ1-12�£��գ�1-31��Сʱ��0-23�����ӣ�0-59���룺0-61(60,61����)
//		����ת����---->Date(long ����ֵ) ��   setTime()
//		����ת����---->getTime()
//		���÷�����after(),before(),equals()---->comapareTo()�Ƚ�����ǰ��
//|-->DateFormat�ࣺ��ʽ���ͽ��������ַ���
//|		���÷���������->�ַ���
//				getDateInstance(DateFormat.���)��ȡ���ڸ�ʽ��
//|				getDateTimeInstance(DateFormat.���,DateFormat.���)��ȡ����ʱ���ʽ��
//|				|---->��ʽ��.format(date)--->str/
//|				|---->��FULL��LONG��SHORTָ�����
//|				|---->�Զ�����
//|					|---->��SimpleDateFormat����
//|					|---->dateFormat = new SimpleDateFormat(pattern)
//|				�ַ���->����
//|				DateFormat�е�format����Date date = dateFormat.parse(str)ע����������쳣
//|		���ڼ��㣺����date����ֵ���������ת������
//|				
//|-->Calendar�ࣺʵ���������ֶ�ת��
//		���÷�����Calendar c = Calendar.getInstance()��ȡ����
//				��c.get(Calendar.YEAR��MONTH+1��DAY_OF_MONTH)��ȡ�꣬��(�ǵ�+1)����(��)
//				��c.get(DAY_OF_WEEK)ʱ,�����ն�Ӧ1,��������Ӧ7,���Զ��庯��ת��������
//				c.set(year,month-1,day)����c�������ʱ��
//				c.add(Calendar.YEAR,2)��c��������2/ʱ��ƫ��
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
//		DateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd");//���4λ������2λ
//		Date date =  dateFormat.parse(sdate);
////	String time = dateFormat.format(date);
//		System.out.println(date);
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
	}
}