package experiment;
public class EXP06{
	public static void main(String[] args) {
		AbC.funTmpS();
		Abs.funCoS();
		AbC abc = new AbC();
		abc.funAb();
		abc.funTmp();
		System.out.println(abc.a);
		System.out.println(Abs.b);
		//System.out.println(abc.b);//不推荐
		
//		System.out.println(InC.a);
//		System.out.println(InC.b);
//		InC inc = new InC();
//		inc.funAb();
	}
}

//interface Int{
//	int a = 10;//自动静态
//	static int b = 12;
//	public abstract void funAb();
//}
//class InC implements Int{
//		public void funAb() {
//		System.out.println("funAb");
//	}
//}

abstract class Abs{
	int a = 10;
	static int b = 12;
	public abstract void funAb();
	public static void funCoS() {
		System.out.println("funCoS");
	}
	public void funCo() {
		System.out.println("funCo");
	}
}
class AbC extends Abs{
	public void funAb() {
		System.out.println("funAb");
	}
	public static void funTmpS(){
		funCoS();
	}
	public void funTmp(){
		funCo();
	}
}

