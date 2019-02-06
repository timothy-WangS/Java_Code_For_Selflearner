package experiment;

public class EXP02{
	
	public static void main(String[] args){
//		int[] arr1 = new int[3];
//		int[] arr2 = new int[]{11,23,33,54,56};
//		int[] arr3 = {9,8,7,6};//静态初始化		
//		for (int i = 0; i < 3; i++) {
//			System.out.println(arr1[i]);
//			System.out.println(arr2[i]);
//			System.out.println(arr3[i]);
//		}	
//		for (int i = 0; i < arr2.length; i++) {
//			System.out.println("arr2["+i+"]="+arr2[i]);
//		}
//		int index1=Arrays.binarySearch(arr2, 13);
//		System.out.println(index1);		
//		Arrays.sort(arr2);
//		for (int i = 0; i < arr2.length; i++) {
//			System.out.println("arr2["+i+"]="+arr2[i]);
//		}
//		int num = 62;{
//			String result1 = Integer.toBinaryString(num);
//			String result2 = Integer.toHexString(num);
//			String result3 = Integer.toOctalString(num);
//			System.out.println(result1);
//			System.out.println(result2);
//			System.out.println(result3);
//		}				
//		int[][] arrp1 = new int[3][4];
		int[][] arrp2 = new int[][] {{1,2,3,4},
									 {2,3,4,5},
									 {3,4,5,6}};
//		int[][] arrp3 = new int[2][];
		System.out.println("add"+add(1,2,3,4,5));
//		System.out.println(arrp3);
//		System.out.println(arrp3[0]);
//		System.out.println(arrp3[0][0]);
//		arrp3[0] = new int[] {12,23,45,56};
//		arrp3[1] = new int[2];
//		System.out.println(arrp2[2][3]);
//		System.out.println(arrp1);
//		System.out.println(arrp1[0]);
//		System.out.println(arrp1[0][0]);
//		System.out.println(arrp3[0][3]);
		Struct m = new Struct(3);
		m.set_aNum(-6);
		m.b = "I love java";
		m.print(arrp2[1][2],m.b);
		
	}
	static int add(int... arr) {//可变参数函数，以数组接收，可变参数类型必须定义在函数参数表结尾
		int sum = 0;
		for(int i = 0; i<arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
}

class Struct{
	private int a;
	public void set_aNum(int tmp){
		if(tmp >= 0) {
		a = tmp;
		}
		else {
			System.out.println("ERROR!num must>=0");
		}
	}
	public int get_aNum() {
		return a;
	}
	String b;
	
	public Struct() {
		System.out.println("hello java");
	}
	public Struct(int k){
		System.out.println("2"+k+""+k+k);
	}
	
	public void print(int tmp,String ch) {
		System.out.println(a);
		System.out.println(tmp);
		System.out.println(ch);
	}
}