package experiment;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.Comparator;
//��̬���룺�������еľ�̬��Ա����
//import static java.util.Collections.sort
//��ʹ��ʱ�����Ӱ�������ע���ֹ��ͻ���Լ��ϰ���
//
//Collections��Collection������(���Ǿ�̬����)
//Arrays�����鹤����(���Ǿ�̬����)
//		|--->asList(arr)����ת�б�(�����ʹ�Ԫ�أ������ʹ�����)
//			|--->��Ӧ�ģ���Collection����list.toArray(new ������[����])����ת���鷽��,���ȶ���null��
//Iterable�ӿڣ�JDK1.5�Ժ���ֵ����ӿڣ��ṩiterator����
//			�������foreach��for(����   ����  ��Collection���� �� ����)����ȡ��Ŀ��
//			���������ݵĲ���(�Ǳ����)foreach�����ˣ�������һ��for
//			���ܱ���map��Ҫת��Ϊset
public class EXP15{
	public static void main(String[] args) {
		demo_1();
	}
	static void demo_1(){
		ArrayList<String> list = new ArrayList<String>();
//		TreeSet<String> list = new TreeSet<String>(Collections.reverseOrder(new ComparatorByLength()));
//		TreeSet<String> list = new TreeSet<String>(Collections.reverseOrder());//�Դ��Ƚ���������
		list.add("aaa");
		list.add("c");
		list.add("b");
		list.add("aaa");
		list.add("aa");
		list.add("a");
		System.out.println(list);
		//����
//		Collections.sort(list, new ComparatorByLength());//�Զ���
//		Collections.sort(list);//list��comparator����(��Ȼ����)
//			|---->�۰����(����֮�����ʹ�ã��ұȽ�����ͬ)
//			System.out.println(Collections.binarySearch(list, "aaa"));//list��comparator����
//			System.out.println(Collections.binarySearch(list, "aaa",new ComparatorByLength()));//�Զ���
		//����
//		Collections.swap(list, 1, 2);
		//����
//		Collections.reverse(list);
		//A�滻B		ԭ��:set����->set(indexOf(old),new);
//		Collections.replaceAll(list, "aaa", "zzz");
		//ȫ���滻
//		Collections.fill(list, "a");
		//�����λ
//		Collections.shuffle(list);
		//foreach���
//			Iterator<String> i = list.iterator();//ԭ����
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