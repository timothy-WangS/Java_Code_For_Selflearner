package experiment;

public class EXP04C{
//	private EXP04C() {}//��ֹ���������ʼ���ķ��ڴ�
	/**
	*�ṩһ��int�����飬�����������ֵ
	*@author Timothy
	*@return int
	*@param int[] array
	*/
	public static int getMax(int[] arr) {//���ڲ�������ʹ�þ�̬����
		int j = arr[0];//����ֵ
		for (int i = 1; i < arr.length; i++) {
			if(j < arr[i])
				j = arr[i];
		}
		return j;
	}
	int a;
	int b;
//	private static EXP04C n = null; 		//�������ģʽ:1�������������
//	private EXP04C() {}						//	 ������ʽ ) 2����ֹ�ⲿ����
//	public static EXP04C setUp() {			//			  3�����촴������
//		if (n == null) {					//����if���Ч��
//			synchronized(EXP04C.class) {	//��ͬ��synchronized�����ȫ���⣬Ч�ʵ�
//				if (n == null) {			//�ڶ��߳��º��鷳�������Գ�����һ�㲻����
//					n = new EXP04C();				
//				}
//			}
//		}
//		return n;						
//	}	
	private static EXP04C n = new EXP04C(); //�������ģʽ:1�������������
	private EXP04C() {}						//	(����ʽ)	  2����ֹ�ⲿ����
	public static EXP04C setUp() {			//			  3�����촴������
		return n;	
	}
}