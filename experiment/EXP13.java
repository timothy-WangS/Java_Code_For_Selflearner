package experiment;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

//List�������Collection������ȡ��˳��һ�£������ظ�Ԫ�أ��ҿɸ�����������Ԫ��
//	����Collection���У�
//	���		add(Obj/E)β��boolean//add(�Ǳ꣬Obj/E)��λֱ������void/
//		
//	ɾ��		remove(Obj)�׸�boolean//remove(�Ǳ�)��λȥ��������ɾ����Ԫ��E/
//		
//	����		get(�Ǳ�)��λȡԪ��E/indexOf(Obj)����������λ��/lastIndexOf(Obj)
//			subList(int begin,int end)��begin��end-1������/
//	�޸�		set(�Ǳ�,Obj/E)��λ�޸�/
//			ListIterater��Iterater���ӽӿڣ��б���еĵ����������ڵ����н�����ɾ��Ĳ���
//List�µĳ��ö���
//		Vector���������ݽṹ���ɱ䳤������+100%�����߳�ͬ������ɾ���Ҷ�����
//		ArrayList���������ݽṹ���ɱ䳤������+50%����ͬ��(���Vector)�������ٶȸ���
//					��ͬ����Ҳ��ArrayList��������Collections��synchronizedXXX����
//		LinkedList���������ݽṹ����ͬ������ɾ�ٶȸ���
//----Vector��1.0�汾��ʼ��1.2�汾���ձൽ���Ͽ�ܣ����ڱ���̭
//		���з�����Enumerationö��(��Iterator���)
//----ArrayList��
//		���з���:���鷽��			
//----LinkedList��
//		���з���:addFirst(Obj/E)/addLast(Obj/E)��ͷβ���void/
//				getFirst,getLast ȡͷβ�����أ���ɾ��(Obj/E)/Ϊ���׳��쳣
//				removeFirst/Last����ɾ����Ԫ�أ�������ɾ��(Obj/E)/Ϊ���׳��쳣
//				--1.6�汾���룺
//				offerFirst(Obj/E)/offerLast(Obj/E)��ͷβ���boolean/
//				peekFirst,peekLast ȡͷβ�����أ���ɾ��(Obj/E)/Ϊ�շ��ؿ�
//				pollFirst/Last����ɾ����Ԫ�أ�������ɾ��(Obj/E)/Ϊ�շ��ؿ�
//				
//Set �������Collection		�������ظ�Ԫ��
//	��Collection����һ��
//	HashSet():	�ڲ����ݽṹ�ǹ�ϣ����ͬ��
//				ʹ��Ԫ�ص�hashCode�㷨����洢λ�ã������ͬ��equals�ж�Ԫ���Ƿ���ͬ
//				ʹ���Զ�����Ԫ��ʱҪ��дpublic int hashCode(){}��public boolean equals(Object obj){}
//				hashCodeһ�����ʱ��Ҫ����һ��ֵ(����)������hash��ͻ
//				String���Լ���hashCode����s.hashCode()
//			-------->LinkedHashSet()����hashSet���������ϣ��Ľ��
//
//	TreeSet():	��Set�����е�Ԫ�ذ��ֵ�˳������
//				�Զ��������Ҫimplements Comparable�ӿڴӶ�����
//				return 0 ��ʾ����������ͬ�����ظ�����
//				ʵ�ֶ���������
public class EXP13{
	public static void main(String[] args) {
//		HashSet<Person> li = new HashSet<Person>();
//		ArrayList<Person> li = new ArrayList<Person>();
//		LinkedHashSet<Person> li = new LinkedHashSet<Person>();
//		TreeSet<Person> li = new TreeSet<Person>(); //����implements Comparable�ӿ�
		TreeSet<Person> li = new TreeSet<Person>(new ComparatName()); //�����Զ���Ƚ���
		
		li.add(new Person("����",25));
		li.add(new Person("����",24));
		li.add(new Person("����",26));
		li.add(new Person("����",24));
		li.add(new Person("����",26));
		li.add(new Person("����",27));
		Iterator<Person> i = li.iterator();//����������
		while(i.hasNext()) {
			Person p = /*(Person)*/i.next();//i��obj���ͣ�ǿתΪperson(�ڲ�ʹ�÷��������)
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
			throw new ClassCastException("���ʹ���");
		}
		Person p = (Person) obj;
		return((this.name == p.name) && (this.age == p.age));
	}
	public int compareTo(Person obj) {//implements Comparable�ӿ�
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
		return tmp==0?p1.getAge()-p2.getAge():tmp;//���������ͬ
	}

}



