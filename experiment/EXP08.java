package experiment;
//创建线程第二种方式：扩展自定义类功能，接口实现
//创建线程的安全问题 与 解决：将多条操作共享数据的代码封装，其它线程不可以在有线程运算时参与运算
//synchronized(对象)：同步代码块，封装需要被同步的代码；弊端：同步外其它线程发生无效判断，相对降低效率
//同步的前提：多线程程序，同一个(对象)->标识位
//	标识位就是一个“锁”，第一个进入的线程为该标识位唯一许可对象，
//	所有具有相同标识位的锁都允许其进入，非该线程不许进入。该线程出代码块后下一个进入的线程成为新许可对象
//synchronized + 自定义函数名(){}:同步函数，标识位为当前类,即synchronized(this);静态时为...(类.class)
//使 同步代码块与同步函数 都用同一个this标识位，可协同工作
//建议使用同步代码块，同步函数是其简写
//死锁：易在同步嵌套中发生，如
//	线程1开始执行，拿到了锁A；
//	线程2执行，先拿到了锁B，在请求拿锁A，而由于此时线程1已经占用了锁A，所以就等待线程1释放锁A；
//	线程1继续往下执行，请求拿到锁B，而锁B被线程2占用，从而形成了死锁。
class MyLock{
	static final Object locka = new Object();
	static final Object lockb = new Object();
}
class DeadLock implements Runnable{
	private boolean flag;
	DeadLock(boolean flag) {
		this.flag = flag;
	}
	public void run(){
		if(flag) {
			synchronized(MyLock.locka) {
				System.out.println(Thread.currentThread().getName()+"if-a");
				synchronized (MyLock.lockb) {
					System.out.println(Thread.currentThread().getName()+"if-b");
				}
			}
		}
		else {
			synchronized(MyLock.lockb) {
				System.out.println(Thread.currentThread().getName()+"else-b");
				synchronized (MyLock.locka) {
					System.out.println(Thread.currentThread().getName()+"else-a");
				}
			}
		}
	}
}

public class EXP08{
	public static void main(String[] args) {
		DeadLock d1 = new DeadLock(true);
		DeadLock d2 = new DeadLock(false);
		Thread m = new Thread(d1);
		Thread n = new Thread(d2);
		m.start();
		n.start();
		
//		Ticket  t = new  Ticket();
//	
//		Thread t1 = new Thread(t);
//		Thread t2 = new Thread(t);
//		Thread t3 = new Thread(t);
//		Thread t4 = new Thread(t);
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
	}
}

//同步代码块
//class Ticket implements Runnable{
//	private int num = 100;
//	Object obj = new Object();
//	public void run() {
////		Object obj = new Object();//不同(对象)->标识位(有四个)
//		while(num>0) {
//			synchronized (obj) {
//				if(num>0) {
////					try {
////						Thread.sleep(50);
////					} catch (InterruptedException e) {
////							e.printStackTrace();
////					}
//				System.out.println(Thread.currentThread().getName()+"......."+num--);
//				}
//			}
//		}
//	}
//}

//同步函数
//class Ticket implements Runnable{
//	private /*static */int num = 100;
//	public void run() { 
//		while(num>0) {
//			sold(); 
//		}
//	}
//	public /*static */synchronized void sold() {
//			if(num>0) {
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println(Thread.currentThread().getName()+"......."+num--);
//		}
//	}
//}