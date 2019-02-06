package experiment;
//IO流其他类：
//1.打印流：
//	PrintWriter字符和字节
//		|---->接收 字符串路径，File对象，字节输出流，字符输出流
//		|---->PrintWriter.print打印到缓冲区，需要flush
//		|---->PrintWriter.println行末换行
//		|---->构造文件输出PrintWriter.print(文件)
//		|---->可以自动刷新的输出流new PrintWriter(new FileWriter(文件),true)
//		|---->
//	PrintStream字节
//		|---->对多种数据打印，并保持其形式，不抛IO异常
//		|---->接收 字符串路径，File对象，字节输出流
//		|---->PrintStream.write将int的二进制低八位转字符输出
//		|---->PrintStream.print直接打印
//
//2.序列流：
//	SequenceInputStream将多个流合并成一个流
//	只要操作该流就可以操作内部所有流
//	比如将文件1,2,3合并到文件4中{
//		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
//		al.add(new FileInputStream("1.txt"));al.add(new FileInputStream("2.txt"));......
//		//按ArrayList顺序读取流，最后一个流结束后标志着所有流结束
//		Enumeration<FileInputStream> en = Collections.enumeration(al);
//		SequenceInputStream sis = new SequenceInputStream(en)
//		FileOutputStream fow = null;
//		fow = new FileOutputStream("4.txt");
//		byte [] buff = new byte[1024];
//		int temp;
//		while((temp = fir.read(buff))!=-1) {
//			fow.write(buff, 0, temp);
//			fow.flush();
//		}
//		fow.close();
//		sis.close();
//	}
//	用于碎片切割文件的合并
//	碎片文件的切割：创建输入流，缓冲区(调控碎片文件大小)，循环输出流 目录+序号+".part"
//	碎片文件的配置：在切割时创建配置文件map.HashTable，表明碎片个数i(序号)，后缀名.NA
//	碎片文件的合并：导入配置，循环(i)创建输入流集合，枚举集合，多流合并，设置输出流  名称+“.NA”
//
//3.操作对象：
//	ObjectOutputStream把对象写入文件，使对象永久存储
//		writeObject(Obj)
//		|---->只有实现了java.io.Serializable接口的对象才能进行(标记接口)
//		|---->后缀名为.object
//		|---->static与transient无法写入保存，
//		|---->ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("XX.object"));
//		|---->out.writeObject(p);
//	ObjectInputStream把对象从文件中读取
//		readObject()
//		|---->必须先有该对象，才能读取
//		|---->ObjectInputStream in = new ObjectInputStream(new FileInputStrream("XX.object"));
//		|---->Person p = (Person)in.readObject;
//	Serializable接口
//		赋予输出的对象一个序列号，用于在输入时验证当前类与创建对象时的类是否相同，不同抛异常
//		序列号：用算法计算的ID号
//		建议添加默认的UID
//
//非IO流文件类RandomAccessFile 读取和写入随机访问文件
//		运用字节指针
//管道流PipedInputStream和PipedInputStream
//		输入和输出直接连接：一个线程的输入流到另一个线程的输出流的数据，用于多线程实时数据传输
//操作对象：
//	基本数据类型	DataInputStream			DataOutputStream
//
//	字节数组		ByteArrayInputStream	ByteArrayOutputStream
//		源和目的都是内存
//	字符数组		CharArrayReader			CharArrayWriter
//
//	字符串		tringReader				StringWriter
//
//
public class EXP23{
	public static void main(String[]args){
		
	}
}