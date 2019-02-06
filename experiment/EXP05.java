package experiment;

public class EXP05{
	public static void main(String[] args) {
//		E05_C1 m = new E05_C1();
////		m.age = 10;
//		System.out.println("C1:"+m.age);
//		m.showP();
//		E05_C2 n = new E05_C2();
//		n.showPp();
		/*static*/ final double PI = 3.141592635;
		int r = 5;
		System.out.println("S = "+PI*r*r);
	}
}

//class E05_P1{
//	int age = 15;
//	String name;
//}
//class E05_P2 extends E05_P1{
//	E05_P2(){
//		System.out.println("P2 setup");
//	}
//	int weight;
//	int age = 9;
//}
////class E05_C1 extends E05_P1,E05_P2{//不支持，可能产生相同调用
//									 //java支持多层继承：C继承B，B继承A==>C继承A,B,见C2
//class E05_C1 extends E05_P1{
//	int age = 12;
//	String job;
//	void showP(){
//		System.out.println("P1:"+super.age);
//	}
//}
//class E05_C2 extends E05_P2{
//	int money;
//	int age = 6;
//	void showPp(){
//		System.out.println("P2:"+super.age);
//	}
//}
