package experiment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//���ͣ�	��JDK 1.5�Ժ���ֽ����ȫ���⣬��߰�ȫ��
//		����<Ԫ������1, Ԫ������2...>  ����  = new ����<Ԫ������1, Ԫ������2...>();//��������������ͬ
//		����ָ�����������洢��Ԫ������(�������� �� �Զ�������)
//		Ԫ�����;���class,interface����
//�ô���	������ʱ��ClassCastExceptionת������ʱ��
//		����ǿ��ת���鷳
//<>��	���������������Ͳ�ȷ��ʱʹ�ã������ʹ��뼴��,���ղ���
//		��api�д�<>�����ӿ���ʹ��ʱ��Ҫ��<>
//������:�ڸ����У������ݲ��������õ��������Ͳ�ȷ��(�������� �� �Զ�������)ʱʹ�ã����(int a)
//		class ����<����Ԫ������1��2...>{
//			public void function<����Ԫ������  a>{//���Ͷ���������
//				CODE							//��������̬ʱ���ɷ����ඨ�巺�ͣ�ֻ�ܶ����ڷ�����
//			}
//			public static <����Ԫ������W> void function<W a>{//���Ͷ����ڷ�����(�������η���,����ֵǰ)
//				CODE
//			}
//		}
//���ͽӿڣ����Ʒ�����+�ӿ�
//	------>ʵ��:�÷�����+���ͷ���(ָ����ָ�����ͣ������ָ������ʹ��ʱҪ�ӷ���ָ��)
//���͵�ͨ�����?  δ֪����
//�����޶���	����--<? extends Fu>ֻ����Fu��������(�ձ�ʹ���ڣ�ȡ��ʱ��ֹ��ȫ����)
//			����--<? super Zi>ֻ����Zi���丸��(һ������ȡ����������)
//
//
//Map����Collectionͬ����ӿڣ�һ�����һ��Ԫ�ء�Ҳ��Ϊ˫�м���
//		���ڴ洢��ֵ�ԣ�ÿ����ֻ��Ӧһ��ֵ(Ψһ��)
//		key,value��Obj����
//1.���		put(key,value)������ֵ����������ǰһ��������valueֵ(Ҳ��Ϊnull)/
//
//2.ɾ��		remove(key)����keyɾ����ֵ�ԣ����ذ󶨵�value/
//			clear()���void/
//3.�ж�		containKey(key)��containValue(value)�Ƿ��������ֵboolean/
//			isEmpty()�Ƿ�Ϊ��boolean/
//4.��ȡ		get(key)��ȡ�󶨵�ֵvalue/û�м�����null
//			size()��ֵ�Ը���int/
//			keySet()���ذ����ļ���Set��ͼSet<K>/���ڻ�ȡmap����Ԫ��
//			entrySet()����ӳ���ϵSet��ͼSet<Map.Entry<K,V>>/���ڻ�ȡmap���й�ϵ
//�������ࣺ	HashTable���ڲ���ϣ��ͬ����������null��Ϊ����ֵ
//				--->Properties�����Լ����洢�洢��ֵ���������ļ�
//			HashMap	  ���ڲ���ϣ����ͬ��������null��Ϊ����ֵ
//			TreeMap	  ���ڲ�����������ͬ�����Լ�����
//Map.Entry<K,V>���ӿڣ�����Map������ȡIterator<Map.Entry<K,V>> i = map.entrySet.iterator
//			getKey,getValue��ȡ��,ֵ(Map.Entry<K,V> m = i.next;������ k = m.getKey;)
//			setValue�����滻ֵ
public class EXP14{
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		method(map);
	}
	static void method(Map<Integer,String> map){	
//		System.out.println(map.put(12, "����"));
//		System.out.println(map.put(12, "����"));
//		map.put(15, "����");
//		map.put(16, "����");
//		System.out.println(map);
//		map.remove(15);
//		System.out.println("remove 15"+map);
//		System.out.println("12:"+map.containsKey(12)+"��15:"+map.containsKey(15));
//		System.out.println("get 16��"+map.get(16));
		map.put(13, "����");
		map.put(14, "����");
		map.put(15, "����");
		map.put(16, "����");
		map.put(17, "����");
		//entrySet()��ȡ
		//��ȡ��ֵ�Ե�set����
		Set<Map.Entry<Integer, String>> enSet = map.entrySet();
		Iterator<Map.Entry<Integer, String>> i = enSet.iterator();
		while(i.hasNext()) {
			Map.Entry<Integer, String> m = i.next();
			System.out.println(m);
			System.out.println(m.getKey()+"----"+m.getValue());
		}
//		//keySet��ȡ
//		//��ȡkey��set���ϣ�����Iterator������ȡvalue
//		Set<Integer> kSet = map.keySet();
//		Iterator<Integer> i = kSet.iterator();
////	Iterator<Integer> m = map.keySet().iterator();
//		while(i.hasNext()) {
//			Integer key = i.next();
//			System.out.println(key+":"+map.get(key));
//		}
	}	
}
