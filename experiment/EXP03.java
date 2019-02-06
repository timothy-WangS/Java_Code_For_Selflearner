package experiment;

public class EXP03{
	
	public static void main(String[] args){
		ClaTest m = new ClaTest();		
		ClaTest n = new ClaTest(-2);
		ClaTest p = new ClaTest(10,"Jav");
		m.print();
		n.print();
		p.print();
		System.out.println(ClaTest.gender);
		System.out.println(args);
		System.out.println(args.length);
	}
}	
	
class ClaTest{
	private int numb;
	private String name;
	static String gender = "male";
	
	public int getNumb() {
		return numb;
	}
	public void setNumb(int numb) {
		this.numb = numb;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ClaTest() {
		this.numb = 1;
		this.name = "Aka";
	}
	public ClaTest(int number){
		if(number > 0) {
			this.numb = number;
		}
		else
			System.out.println("ERROR!NO. MUST > 0");
	}
	public ClaTest(int numb,String name) {
		this(numb);
		this.name = name;
	}	
	public void print() {
		if(this.name != null && this.name.length() > 0 && this.numb > 0) {
			System.out.println(this.name+"("+gender+"):No."+this.numb);
		}
		else {
			System.out.println("ERROR!NO. MUST > 0 AND NAME MORE THAN ONE CHAR");
		}
	}
	
	
}