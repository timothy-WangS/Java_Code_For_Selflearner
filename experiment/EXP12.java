package experiment;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;

//���ϣ�
//	���ڴ洢���������
//	���ȿɱ�
//	���ɴ洢������������
//���������ڲ����ݽṹ���죬�ж�������
//�������ϳ�ȡ���Զ���ΪCollection(Iterator,Map)(�ӿ�),JDK1.5���ֳ�ȡ�����Iterable�ӿ�,�ṩiterator����
//Collection��
//��	��	add(Obj/E)һ��//addAll(Collection)ֱ������boolean/
//
//ɾ	��	remove(Obj)һ��//removeAll(Collection)ȥ����boolean/
//		clear();��գ����ϻ���/
//�ж�	contains(Obj)����һ��//containsAll(Collection)������һȫ��boolean/
//		isEmpty()�Ƿ�Ϊ��boolean/
//��ȡ	size()��Сint/
//		iterator()����Iterator/����ȡ��Ԫ��
//����	retainAll(Collection)ȡ����boolean/
//		toArray(arr)������ת������Obj/
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
//		}//�������Զ����i����
		for(Iterator<String> i = coll.iterator();i.hasNext();){
			System.out.println(i.next());
		}//���������i����
	}
//	static void show(Collection<String> coll) {
//		//���
//		coll.add("abcde");
//		coll.add("abcdf");
//		coll.add("abcdg");
//		System.out.println(coll);
//		//�ж�
//		System.out.println(coll.contains("abcdf"));
//		System.out.println(coll.contains("abcdh"));
//		//ɾ��
////		coll.remove("abcdf");//��ı伯�ϳ���
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