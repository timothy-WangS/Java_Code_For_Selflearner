package experiment;

public class EXP04C{
//	private EXP04C() {}//阻止其他程序初始化耗费内存
	/**
	*提供一个int型数组，返回其中最大值
	*@author Timothy
	*@return int
	*@param int[] array
	*/
	public static int getMax(int[] arr) {//无内部变量，使用静态函数
		int j = arr[0];//赋初值
		for (int i = 1; i < arr.length; i++) {
			if(j < arr[i])
				j = arr[i];
		}
		return j;
	}
	int a;
	int b;
//	private static EXP04C n = null; 		//单例设计模式:1、构造自体变量
//	private EXP04C() {}						//	 （懒汉式 ) 2、阻止外部访问
//	public static EXP04C setUp() {			//			  3、构造创建变量
//		if (n == null) {					//两个if提高效率
//			synchronized(EXP04C.class) {	//用同步synchronized解决安全问题，效率低
//				if (n == null) {			//在多线程下很麻烦，但面试常考。一般不采用
//					n = new EXP04C();				
//				}
//			}
//		}
//		return n;						
//	}	
	private static EXP04C n = new EXP04C(); //单例设计模式:1、构造自体变量
	private EXP04C() {}						//	(饿汉式)	  2、阻止外部访问
	public static EXP04C setUp() {			//			  3、构造创建变量
		return n;	
	}
}