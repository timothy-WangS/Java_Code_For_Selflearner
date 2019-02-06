package experiment;
//File�ࣺ�����ڻ򲻴��ڵ��ļ����ļ��з�װ�ɶ���
//		���Ʒָ���System.getProperties("file.separator")--->File.separator
//���÷�����
//	1.��ȡ	
//		�ļ�����file.getName()/string
//		�ļ�·��file.getPath()�������ʱд��·�� file.getAbsolutePath()����·��/string
//		�ļ���Сfile.length()/long
//		�޸�ʱ��file.lastModified()/long
//	2.������ɾ��
//		�����ļ�file.createNewFile()/boolean���򴴽�true����ʧ��false
//		ɾ���ļ�file.delete()/boolean����ɾ��true����ʧ��false
//				file.deleteOnExit()/void��JVM�˳�ʱɾ������һIO���쳣Ҳ����ɾ��
//		�����ļ���file.mkdir()/booleanֻ��������Ŀ¼
//				file.mkdirs()/boolean�����༶Ŀ¼
//		ɾ���ļ���file.delete()/boolean
//	3.�ж�
//		�Ƿ�����ļ�file.exists()/boolean
//		|-->�Ƿ����ļ�file.isFile()/boolean
//		|-->�Ƿ���Ŀ¼file.isDirectory()/boolean
//	4.��ȡ
//		�г�������ϵͳ��Ŀ¼File[] files = File.listRoots();/File[]
//		Ŀ¼�����¿���ռ�file.getFreeSpace()/file.getUsableSpace()/long
//		Ŀ¼�������ܿռ�file.getTotalSpace()/long
//		��ȡĿ¼�µ��ļ���Ŀ¼file.list()/str[]���������ļ���Ŀ¼�������ļ������ܷ���ϵͳ��Ŀ¼
//		��ȡĿ¼��ָ�����������ļ���Ŀ¼file.list(FilenameFilter)
//		|---->FilenameFilter�ӿ�
//		|---->accept(File dir,str)
//		|---->�ļ�Ŀ¼���ļ���
//		|---->�����࣬ʵ�ֹ������ӿڣ�����Ϊ��ͨ��������
//		
//	����
//		������file.renameTo()/booleanҲ���������ļ��ƶ�(�ı�·����)
//		��ȱ�����ʹ�õݹ鲻�ϱ�������Ŀ¼
//		ɾ�������ݵ�Ŀ¼����ȱ�������ײ㿪ʼɾ
//
//

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class EXP21{
	public static void main(String[] args) throws IOException{
//		fileConsrtruct();
//		creatFile();
//		deletFile();
//		judgeFile();
//		renaMe();
//		listRoot();
//		liSt();
//		{	//��ȱ���
//			File root = new File("O:\\programme\\java\\experiment\\filepack\\EXP21Z");
//			listAll(root,0);
//		}
		{	//ȫ��ɾ��
			File root = new File("O:\\programme\\java\\experiment\\filepack\\EXP21Z");
			deleteAll(root);
		}
	}
	static void fileConsrtruct() {
		//���ֹ��췽��
//		File file1 = new File("O:\\programme\\java\\experiment\\filepack\\EXP21F.txt");
//		File file2 = new File("O:\\programme\\java\\experiment\\filepack", "EXP21F.txt");
//		File file = new File("O:\\programme\\java\\experiment\\filepack");
//		File file3 = new File(file,"EXP21F.txt");
	}
	static void creatFile() throws IOException {
		File filef = new File("O:\\programme\\java\\experiment\\filepack\\EXP21F.txt");
		boolean creatf = filef.createNewFile();
		File filep = new File("O:\\programme\\java\\experiment\\filepack\\EXP21P.txt");
		boolean creatp = filep.mkdir();
		System.out.println(creatf);
		System.out.println(creatp);
	}
	static void deletFile() {
		File filef = new File("O:\\programme\\java\\experiment\\filepack\\EXP21F.txt");
		boolean deletef = filef.delete();
		File filep = new File("O:\\programme\\java\\experiment\\filepack\\EXP21P");
		boolean deletp = filep.delete();
		System.out.println(deletef);
		System.out.println(deletp);
	}
	static void judgeFile() {
		File file = new File("O:\\programme\\java\\experiment\\filepack\\EXP21F.txt");
		boolean judge = file.exists();
		System.out.println(judge);
	}
	static void renaMe() {
		File file1 = new File("O:\\programme\\java\\experiment\\filepack\\EXP21F.txt");
		File file2 = new File("O:\\programme\\java\\experiment\\filepack\\EXP21FN.txt");
		file1.renameTo(file2);
	}
	static void listRoot() {
		File[] files = File.listRoots();
		for(File file : files) {
			System.out.println(file);
		}
	}
	static void liSt() {
		File file = new File("O:\\programme\\java\\experiment\\filepack");
		String[] lists = file.list(new FileFilter()) ;
		for(String list:lists) {
			System.out.println(list);
		}
	}
	static void listAll(File root,int level) {
		level++;
		System.out.println(root.getAbsolutePath());
		File[] files = root.listFiles();
		for(int x=0;x<files.length;x++) {
			if(files[x].isDirectory()) {
				listAll(files[x],level);
			}
			else {
				for (int i = 0; i < level; i++) {
					System.out.print("  ");
				}
				System.out.println(files[x].getAbsolutePath());
			}
		}
	}
	static void deleteAll(File root) {
		File[] files = root.listFiles();
		for(File file : files ) {
			if(file.isDirectory()) {
				deleteAll(file);
			}
			else {
				System.out.println(file.delete());
			}
		}
		System.out.println(root.delete());
	}
}
class FileFilter implements FilenameFilter{
	public boolean accept(File dir, String name) {
		File file = new File(dir+"\\"+name);
		return ((file.isFile())&&(name.endsWith(".txt")));//��.txt��β��Ϊ�棬������Ϊ��
	}
}