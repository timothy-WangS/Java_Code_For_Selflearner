package experiment;

public class EXP04{
	
	public static void main(String[] args) {
		int[] arr = {5,6,2,1,3,7,8,9};
//		EXP04C tmp = new EXP04C();
		int max = EXP04C.getMax(arr);
		System.out.println(max);
		trySingle();

	}
	
	public static void trySingle() {
		EXP04C m1 = EXP04C.setUp();
		EXP04C m2 = EXP04C.setUp();
		EXP04C m3 = EXP04C.setUp();
		System.out.println("trySingle!!!");
		m1.a = 10;
		System.out.println(m1.a);
		m2.a = 12;
		System.out.println(m1.a);
		m3.a = 15;
		System.out.println(m1.a);
//		System.out.println(EXP04C.n.a);
	}
}