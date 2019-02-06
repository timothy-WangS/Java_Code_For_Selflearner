package experiment;

public class EXP01 {
	
	public static void main(String[] args) 
	{
//		byte a = 3;
//		a +=2;
//		int b = 125;
//		b%=2000000;
//		double c = 3;
//		c--;
//		int d1=2147483647;
//		int d2=1;
//		int d;
//		d=d1+d2;
//		System.out.println(a);
//		System.out.println(c);
//		System.out.println(a==c);
//		a+=b;
//		System.out.println(a);
//		System.out.println("һ"+2+2);
//		System.out.println(-24>>2);
//		int y;
//		for(y=1;y<3;y++){
//			System.out.println(y);
//		}
//		System.out.println(y);	
//		System.out.println("\"hello\r\nworld\"");
//		int all = 5;
//		for (int i = 0; i < all; i++) {
//			for(int j = i; j > 0; j--){
//				System.out.print(" ");
//			}
//			for(int j = all-i; j > 0; j--){
//				System.out.print("* ");
//			}
//			System.out.println();
//		}	
//		p1: for (int i = 0; i < 2; i++){
//				for (int j = 0; j < 2; j++){
//					System.out.println("x="+i);
//					if(i == 1)
//						continue;
//					System.out.println("y="+j);
//					break p1;
//				}
//		}
		int a = 3, b = 4, t = 5;
		double m = 0.7, n = 0.5;
		int c = myAdd(a, b);
		int e = myAdd(a, b, t);
		double d = myAdd(m, n);
		System.out.println(c);
		System.out.println(e);
		System.out.println(d);
		mySwap(a,b);
		System.out.println("a="+a+",b="+b);
		
	}
	
	public static int myAdd(int x, int y) {
		return x+y;
	}
	public static double myAdd(double x, double y) {
		return x+y;
	}
	public static int myAdd(int x, int y, int z) {
		return x+y+z;
	}
	public static void mySwap(int x, int y){
		int t;
		t = x;
		x = y;
		y = t;
		System.out.println("a="+x+",b="+y);
	}

}