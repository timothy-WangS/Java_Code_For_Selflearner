package experiment;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
//静态导入：导入类中的静态成员，如
//import static java.util.Collections.sort
//在使用时允许不加包名，但注意防止冲突可以加上包名
//
//Collections：Collection工具类(都是静态方法)
//Arrays：数组工具类(都是静态方法)
//		|--->asList(arr)数组转列表(引用型存元素，基本型存数组)
//			|--->对应的，在Collection中有list.toArray(new 类型名[长度])集合转数组方法,长度多用null补
//Iterable接口：JDK1.5以后出现的最顶层接口，提供iterator方法
//			给出语句foreach：for(类型   变量  ：Collection集合 或 数组)用于取出目标
//			其他对数据的操作(角标操作)foreach做不了，必须用一般for
//			不能遍历map，要转换为set
public class EXP15{
	public static void main(String[] args) {
		demo_1();
	}
	static void demo_1(){
		ArrayList<String> list = new ArrayList<String>();
//		TreeSet<String> list = new TreeSet<String>(Collections.reverseOrder(new ComparatorByLength()));
//		TreeSet<String> list = new TreeSet<String>(Collections.reverseOrder());//自带比较器的逆序
		list.add("aaa");
		list.add("c");
		list.add("b");
		list.add("aaa");
		list.add("aa");
		list.add("a");
		System.out.println(list);
		//排序
//		Collections.sort(list, new ComparatorByLength());//自定义
//		Collections.sort(list);//list的comparator方法(自然排序)
//			|---->折半查找(排序之后才能使用，且比较器相同)
//			System.out.println(Collections.binarySearch(list, "aaa"));//list的comparator方法
//			System.out.println(Collections.binarySearch(list, "aaa",new ComparatorByLength()));//自定义
		//交换
//		Collections.swap(list, 1, 2);
		//逆序
//		Collections.reverse(list);
		//A替换B		原理:set方法->set(indexOf(old),new);
//		Collections.replaceAll(list, "aaa", "zzz");
		//全部替换
//		Collections.fill(list, "a");
		//随机换位
//		Collections.shuffle(list);
		//foreach语句
//			Iterator<String> i = list.iterator();//原方法
//			while (i.hasNext()) {
//				System.out.println(i.next());
//			}
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println(list);
	}
}
class ComparatorByLength implements Comparator<String>{
	public int compare(String arg0, String arg1) {
		int tmp = arg0.length()-arg1.length();
		return tmp == 0?arg0.compareTo(arg1):tmp;
	}
	
}