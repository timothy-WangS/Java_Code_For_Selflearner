package experiment;
//IO�������ࣺ
//1.��ӡ����
//	PrintWriter�ַ����ֽ�
//		|---->���� �ַ���·����File�����ֽ���������ַ������
//		|---->PrintWriter.print��ӡ������������Ҫflush
//		|---->PrintWriter.println��ĩ����
//		|---->�����ļ����PrintWriter.print(�ļ�)
//		|---->�����Զ�ˢ�µ������new PrintWriter(new FileWriter(�ļ�),true)
//		|---->
//	PrintStream�ֽ�
//		|---->�Զ������ݴ�ӡ������������ʽ������IO�쳣
//		|---->���� �ַ���·����File�����ֽ������
//		|---->PrintStream.write��int�Ķ����ƵͰ�λת�ַ����
//		|---->PrintStream.printֱ�Ӵ�ӡ
//
//2.��������
//	SequenceInputStream��������ϲ���һ����
//	ֻҪ���������Ϳ��Բ����ڲ�������
//	���罫�ļ�1,2,3�ϲ����ļ�4��{
//		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
//		al.add(new FileInputStream("1.txt"));al.add(new FileInputStream("2.txt"));......
//		//��ArrayList˳���ȡ�������һ�����������־������������
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
//	������Ƭ�и��ļ��ĺϲ�
//	��Ƭ�ļ����и������������������(������Ƭ�ļ���С)��ѭ������� Ŀ¼+���+".part"
//	��Ƭ�ļ������ã����и�ʱ���������ļ�map.HashTable��������Ƭ����i(���)����׺��.NA
//	��Ƭ�ļ��ĺϲ����������ã�ѭ��(i)�������������ϣ�ö�ټ��ϣ������ϲ������������  ����+��.NA��
//
//3.��������
//	ObjectOutputStream�Ѷ���д���ļ���ʹ�������ô洢
//		writeObject(Obj)
//		|---->ֻ��ʵ����java.io.Serializable�ӿڵĶ�����ܽ���(��ǽӿ�)
//		|---->��׺��Ϊ.object
//		|---->static��transient�޷�д�뱣�棬
//		|---->ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("XX.object"));
//		|---->out.writeObject(p);
//	ObjectInputStream�Ѷ�����ļ��ж�ȡ
//		readObject()
//		|---->�������иö��󣬲��ܶ�ȡ
//		|---->ObjectInputStream in = new ObjectInputStream(new FileInputStrream("XX.object"));
//		|---->Person p = (Person)in.readObject;
//	Serializable�ӿ�
//		��������Ķ���һ�����кţ�����������ʱ��֤��ǰ���봴������ʱ�����Ƿ���ͬ����ͬ���쳣
//		���кţ����㷨�����ID��
//		�������Ĭ�ϵ�UID
//
//��IO���ļ���RandomAccessFile ��ȡ��д����������ļ�
//		�����ֽ�ָ��
//�ܵ���PipedInputStream��PipedInputStream
//		��������ֱ�����ӣ�һ���̵߳�����������һ���̵߳�����������ݣ����ڶ��߳�ʵʱ���ݴ���
//��������
//	������������	DataInputStream			DataOutputStream
//
//	�ֽ�����		ByteArrayInputStream	ByteArrayOutputStream
//		Դ��Ŀ�Ķ����ڴ�
//	�ַ�����		CharArrayReader			CharArrayWriter
//
//	�ַ���		tringReader				StringWriter
//
//
public class EXP23{
	public static void main(String[]args){
		
	}
}