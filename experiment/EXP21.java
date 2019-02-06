package experiment;
//File类：将存在或不存在的文件或文件夹封装成对象
//		名称分隔符System.getProperties("file.separator")--->File.separator
//常用方法：
//	1.获取	
//		文件名称file.getName()/string
//		文件路径file.getPath()构造对象时写的路径 file.getAbsolutePath()绝对路径/string
//		文件大小file.length()/long
//		修改时间file.lastModified()/long
//	2.创建与删除
//		创建文件file.createNewFile()/boolean无则创建true有则失败false
//		删除文件file.delete()/boolean有则删除true无则失败false
//				file.deleteOnExit()/void在JVM退出时删除，万一IO抛异常也可以删除
//		创建文件夹file.mkdir()/boolean只创建单级目录
//				file.mkdirs()/boolean创建多级目录
//		删除文件夹file.delete()/boolean
//	3.判断
//		是否存在文件file.exists()/boolean
//		|-->是否是文件file.isFile()/boolean
//		|-->是否是目录file.isDirectory()/boolean
//	4.获取
//		列出可以用系统根目录File[] files = File.listRoots();/File[]
//		目录分区下空余空间file.getFreeSpace()/file.getUsableSpace()/long
//		目录分区下总空间file.getTotalSpace()/long
//		获取目录下的文件和目录file.list()/str[]包括隐藏文件，目录不能是文件，不能访问系统级目录
//		获取目录下指定过滤器的文件和目录file.list(FilenameFilter)
//		|---->FilenameFilter接口
//		|---->accept(File dir,str)
//		|---->文件目录，文件名
//		|---->创建类，实现过滤器接口，返回为真通过过滤器
//		
//	其他
//		重命名file.renameTo()/boolean也可以用于文件移动(改变路径名)
//		深度遍历：使用递归不断遍历深层次目录
//		删除带内容的目录：深度遍历从最底层开始删
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
//		{	//深度遍历
//			File root = new File("O:\\programme\\java\\experiment\\filepack\\EXP21Z");
//			listAll(root,0);
//		}
		{	//全部删除
			File root = new File("O:\\programme\\java\\experiment\\filepack\\EXP21Z");
			deleteAll(root);
		}
	}
	static void fileConsrtruct() {
		//四种构造方法
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
		return ((file.isFile())&&(name.endsWith(".txt")));//以.txt结尾都为真，其他都为假
	}
}