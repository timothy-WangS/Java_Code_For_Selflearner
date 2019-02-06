package experiment;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;

//集合：
//	用于存储对象的容器
//	长度可变
//	不可存储基本类型数据
//集合由于内部数据结构差异，有多种容器
//不断向上抽取共性顶层为Collection(Iterator,Map)(接口),JDK1.5后又抽取了最顶层Iterable接口,提供iterator方法
//Collection：
//添	加	add(Obj/E)一个//addAll(Collection)直接连接boolean/
//
//删	除	remove(Obj)一个//removeAll(Collection)去交集boolean/
//		clear();清空，集合还在/
//判断	contains(Obj)包含一个//containsAll(Collection)包含另一全部boolean/
//		isEmpty()是否为空boolean/
//获取	size()大小int/
//		iterator()迭代Iterator/用于取出元素
//其他	retainAll(Collection)取交集boolean/
//		toArray(arr)将集合转成数组Obj/
//
public class EXP12{
	public static void main(String[] args) {
//		Collection<String> cola = new ArrayList<String>();
//		Collection<String> colb = new ArrayList<String>();
		Collection<String> coll = new ArrayList<String>();
//		show(coll);
//		showAll(cola,colb);
		iter(coll);
	}

	static void iter(Collection<String> coll) {
		coll.add("a");
		coll.add("bb");
		coll.add("ccc");
//		java.util.Iterator<String> i;
//		i = coll.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}//结束后不自动清除i变量
		for(Iterator<String> i = coll.iterator();i.hasNext();){
			System.out.println(i.next());
		}//结束后清除i变量
	}
//	static void show(Collection<String> coll) {
//		//添加
//		coll.add("abcde");
//		coll.add("abcdf");
//		coll.add("abcdg");
//		System.out.println(coll);
//		//判断
//		System.out.println(coll.contains("abcdf"));
//		System.out.println(coll.contains("abcdh"));
//		//删除
////		coll.remove("abcdf");//会改变集合长度
////		coll.clear();
//		System.out.println(coll);
//	}
//	static void showAll(Collection<String> c1,Collection<String> c2) {
//		c1.add("a");
//		c1.add("aa");
//		c1.add("aaa");
//		c2.add("aaa");
//		c2.add("aaaa");
//		boolean b;
//		System.out.println(c1);
//		System.out.println(c2);
////		b=c1.addAll(c2);
////		b=c1.removeAll(c2);
////		b=c1.containsAll(c2);
////		c1.retainAll(c2);
//		System.out.println(c1);
////		System.out.println(b);
//	}
}