package experiment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//泛型：	从JDK 1.5以后出现解决安全问题，提高安全性
//		集合<元素类型1, 元素类型2...>  名称  = new 集合<元素类型1, 元素类型2...>();//左右两边类型相同
//		用于指定集合内所存储的元素类型(引用类型 或 自定义类型)
//		元素类型就是class,interface名称
//好处：	将运行时的ClassCastException转到编译时期
//		避免强制转换麻烦
//<>：	当操作的数据类型不确定时使用，将类型传入即可,接收参数
//		在api中带<>的类或接口在使用时都要带<>
//泛型类:在该类中，当数据操作中引用的数据类型不确定(引用类型 或 自定义类型)时使用，类比(int a)
//		class 类名<泛型元素类型1、2...>{
//			public void function<泛型元素类型  a>{//泛型定义在类上
//				CODE							//当方法静态时不可访问类定义泛型，只能定义在方法上
//			}
//			public static <泛型元素类型W> void function<W a>{//泛型定义在方法上(放在修饰符后,返回值前)
//				CODE
//			}
//		}
//泛型接口：类似泛型类+接口
//	------>实现:用泛型类+泛型方法(指定或不指定类型；如果不指定，在使用时要加泛型指定)
//泛型的通配符：?  未知类型
//泛型限定：	上限--<? extends Fu>只接受Fu及其子类(普遍使用于，取出时防止安全隐患)
//			下限--<? super Zi>只接受Zi及其父类(一般用于取出共性类型)
//
//
//Map：与Collection同级别接口，一次添加一对元素。也成为双列集合
//		用于存储键值对，每个键只对应一个值(唯一性)
//		key,value：Obj对象
//1.添加		put(key,value)将键与值关联，返回前一个关联的value值(也可为null)/
//
//2.删除		remove(key)根据key删除键值对，返回绑定的value/
//			clear()清空void/
//3.判断		containKey(key)、containValue(value)是否包含键、值boolean/
//			isEmpty()是否为空boolean/
//4.获取		get(key)获取绑定的值value/没有键返回null
//			size()键值对个数int/
//			keySet()返回包含的键的Set视图Set<K>/用于获取map所有元素
//			entrySet()返回映射关系Set视图Set<Map.Entry<K,V>>/用于获取map所有关系
//常用子类：	HashTable：内部哈希表，同步，不允许null作为键或值
//				--->Properties：属性集，存储存储键值对型配置文件
//			HashMap	  ：内部哈希表，不同步，允许null作为键或值
//			TreeMap	  ：内部二叉树，不同步，对键排序
//Map.Entry<K,V>：接口，用于Map迭代获取Iterator<Map.Entry<K,V>> i = map.entrySet.iterator
//			getKey,getValue获取键,值(Map.Entry<K,V> m = i.next;类型名 k = m.getKey;)
//			setValue设置替换值
public class EXP14{
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		method(map);
	}
	static void method(Map<Integer,String> map){	
//		System.out.println(map.put(12, "张三"));
//		System.out.println(map.put(12, "李四"));
//		map.put(15, "王五");
//		map.put(16, "赵六");
//		System.out.println(map);
//		map.remove(15);
//		System.out.println("remove 15"+map);
//		System.out.println("12:"+map.containsKey(12)+"，15:"+map.containsKey(15));
//		System.out.println("get 16："+map.get(16));
		map.put(13, "张三");
		map.put(14, "李四");
		map.put(15, "王五");
		map.put(16, "赵六");
		map.put(17, "孙七");
		//entrySet()获取
		//获取键值对的set集合
		Set<Map.Entry<Integer, String>> enSet = map.entrySet();
		Iterator<Map.Entry<Integer, String>> i = enSet.iterator();
		while(i.hasNext()) {
			Map.Entry<Integer, String> m = i.next();
			System.out.println(m);
			System.out.println(m.getKey()+"----"+m.getValue());
		}
//		//keySet获取
//		//获取key的set集合，再用Iterator遍历获取value
//		Set<Integer> kSet = map.keySet();
//		Iterator<Integer> i = kSet.iterator();
////	Iterator<Integer> m = map.keySet().iterator();
//		while(i.hasNext()) {
//			Integer key = i.next();
//			System.out.println(key+":"+map.get(key));
//		}
	}	
}
