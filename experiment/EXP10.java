package experiment;
public class EXP10{
	public static void main(String[] args) {
//		String a = "abc";
//		String A = "abc";			//System.out.println(a==A);true(��ֵַ)
//		//�ַ��������ڳ�����(�ַ���������)���������ã�������
//		//һ�����������޸ģ��޸ĵ���ָ��Ļ������ĵ�ַ
//		//String���е�equals��ʽ��д��Object�����жϵ����ַ�������
//		String b = new String("abc");//System.out.println(a==b);false(��ֵַ)
//		//������������new���ַ��������ڶ����洢�ַ�������ĳ���
//		String B = new String("abc");//System.out.println(B==b);false(��ֵַ)		
//		byte[] arr1 = {97,98,99,100};
//		char[] arr2 = {'a','a','a','1'};
//		//new String(arr);ת�ַ���ʱ�Զ�ASCIIת��
//		//new String(arr,m,n)��m�Ǳ꿪ʼȡn��
		//1.��ȡ:	s.length()�ַ�������int/
		//			s.charAt(�Ǳ�)��λȡֵchar/
		//			s.indexOf(ֵ(,int ��ʼλ))��һ�γ���λ��int/
		//					     ֵ������Ϊint(ASCII��)��char��string����ʼλ��дĬ��0/
		//			s.lastIndexOf(ֵ(,��ʼλ))������λ��int/
		//			s.subString(int begin(��int end))�������ַ���(begin��end-1),��дĬ�ϵ���βstring/
		//2.ת����	s.split(���зֱ�־��)�ַ����з�string[] arr/�漰��������ʽ
		//			s.toCharArray()���ֽ�ת���ַ�����(�������ֽ�)char[] arr/
		//			s.toUpperCase()ת��д//s.toLowerCase()תСдstring/
		//			s.replace("old","new")�滻(old��newΪ�ַ����ַ���)string/
		//			s.trim()ȥ��ǰ��ո�string/
		//			s.concat("���ַ���")�ַ�������/
		//3.�жϣ�	s.equals(Object(string))�ж�������ͬboolean/
		//			s.equalsIgnoreCase(Object(string))���Դ�Сд�ж�������ͬboolean/
		//			s.contains(string)�Ƿ����
		//			s.startsWith(string)�� ��ͷ//s.endsWith(string)�� ��βboolean/
		//			s.compareTo(a string)�����������ֵ�˳���жϣ�s<a���ظ��������Ϊ0������Ϊ��int/
		//
		//StringBuffer��������class�ַ���������
		//���ȿɱ䣬���ղ�ͬ�������ݣ�����ת���ַ���ʹ��
		//StringBuffer s = new StringBuffer(����);
		//��ִ�����в���ʱ�����ص�StringBuffer��ֵַ��Ȼ��s�ĵ�ֵַ
		//1.���		s.append(����)β��׷��StringBuffer/
		//			s.insert(intλ�ýǱ꣬����)ָ��λ�ò���StringBuffer/
		//2.ɾ��		s.delet(int begin,int end)ɾ����begin��end-1StringBuffer/
		//			s.deletCharAt(intλ�ýǱ�)ɾ��ָ��λ���ַ�StringBuffer/
		//			s.delet(0,s.length())��ջ�����StringBuffer/
		//3.����		s.charAt(�Ǳ�)��λȡֵchar/
		//			s.indexOf(ֵ(,int ��ʼλ))��һ�γ���λ��int/
		//			s.lastIndexOf(ֵ(,��ʼλ))������λ��int/
		//4.�޸�		s.replace(int begin,int end,string)�滻begin��end-1һ��StringBuffer/
		//			s.setChar(intλ�ýǱ�, char)�滻ָ��λ���ַ�void/
		//			s.setLength(int)���ó��ȣ���ļ�����ַ����ٵĴ�βɾ�ַ�����0���void/
		//			s.reverse()��תStringBuffer/
		//
		//StringBuilder������StringBuffer��
		//		���߳��£�Bufferִ�ж��߳�ͬ������Builder��Ϊ��ִ��ͬ������Ч�ʸ���
		//���߳���Builder�����߳���Buffer
	}
}
