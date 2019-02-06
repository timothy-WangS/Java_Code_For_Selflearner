package experiment;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

//List：有序的Collection，存入取出顺序一致，允许重复元素，且可根据索引访问元素
//	除了Collection还有：
//	添加		add(Obj/E)尾部boolean//add(角标，Obj/E)按位直接连接void/
//		
//	删除		remove(Obj)首个boolean//remove(角标)按位去除，返回删除的元素E/
//		
//	查找		get(角标)按位取元素E/indexOf(Obj)按对象索引位置/lastIndexOf(Obj)
//			subList(int begin,int end)从begin到end-1的子列/
//	修改		set(角标,Obj/E)按位修改/
//			ListIterater：Iterater的子接口，列表才有的迭代器，可在迭代中进行增删查改操作
//List下的常用对象：
//		Vector：数组数据结构，可变长度数组+100%，多线程同步，增删查找都很慢
//		ArrayList：数组数据结构，可变长度数组+50%，不同步(替代Vector)，查找速度更快
//					在同步下也用ArrayList，加锁用Collections的synchronizedXXX方法
//		LinkedList：链表数据结构，不同步，增删速度更快
//----Vector：1.0版本开始，1.2版本被收编到集合框架，正在被淘汰
//		特有方法：Enumeration枚举(被Iterator替代)
//----ArrayList：
//		特有方法:数组方法			
//----LinkedList：
//		特有方法:addFirst(Obj/E)/addLast(Obj/E)在头尾添加void/
//				getFirst,getLast 取头尾并返回，不删除(Obj/E)/为空抛出异常
//				removeFirst/Last返回删除的元素，并将其删除(Obj/E)/为空抛出异常
//				--1.6版本加入：
//				offerFirst(Obj/E)/offerLast(Obj/E)在头尾添加boolean/
//				peekFirst,peekLast 取头尾并返回，不删除(Obj/E)/为空返回空
//				pollFirst/Last返回删除的元素，并将其删除(Obj/E)/为空返回空
//				
//Set ：无序的Collection		不能有重复元素
//	与Collection方法一致
//	HashSet():	内部数据结构是哈希表，不同步
//				使用元素的hashCode算法计算存储位置，如果相同用equals判断元素是否相同
//				使用自定义类元素时要覆写public int hashCode(){}与public boolean equals(Object obj){}
//				hashCode一般计算时还要乘上一个值(质数)，减少hash冲突
//				String有自己的hashCode方法s.hashCode()
//			-------->LinkedHashSet()有序hashSet，链表与哈希表的结合
//
//	TreeSet():	对Set集合中的元素按字典顺序排序
//				自定义对象需要implements Comparable接口从而排序
//				return 0 表示两个对象相同，不重复载入
//				实现二叉树排序
public class EXP13{
	public static void main(String[] args) {
//		HashSet<Person> li = new HashSet<Person>();
//		ArrayList<Person> li = new ArrayList<Person>();
//		LinkedHashSet<Person> li = new LinkedHashSet<Person>();
//		TreeSet<Person> li = new TreeSet<Person>(); //运用implements Comparable接口
		TreeSet<Person> li = new TreeSet<Person>(new ComparatName()); //运用自定义比较器
		
		li.add(new Person("张三",25));
		li.add(new Person("李四",24));
		li.add(new Person("王五",26));
		li.add(new Person("李四",24));
		li.add(new Person("赵六",26));
		li.add(new Person("张三",27));
		Iterator<Person> i = li.iterator();//创建迭代器
		while(i.hasNext()) {
			Person p = /*(Person)*/i.next();//i是obj类型，强转为person(在不使用泛型情况下)
			System.out.println(p.getName()+p.getAge());
		}
	}
}
class Person implements Comparable<Person>{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public int hashCode(){
		return name.hashCode()+age*31;
	}
	public boolean equals(Object obj){
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Person)) {
			throw new ClassCastException("类型错误");
		}
		Person p = (Person) obj;
		return((this.name == p.name) && (this.age == p.age));
	}
	public int compareTo(Person obj) {//implements Comparable接口
		Person p = obj;
		if(this.hashCode() > p.hashCode()) {
			return 1;
		}
		else if(this.hashCode() < p.hashCode()) {
			return -1;
		}
		else
			return 0;
	}
}
class ComparatName implements Comparator<Person>{
	public int compare(Person o1, Person o2) {
		Person p1 = o1;
		Person p2 = o2;
		int tmp = p1.getName().compareTo(p2.getName());
		return tmp==0?p1.getAge()-p2.getAge():tmp;//如果姓名相同
	}

}



