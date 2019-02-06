package experiment;
//�����̵߳ڶ��ַ�ʽ����չ�Զ����๦�ܣ��ӿ�ʵ��
//�����̵߳İ�ȫ���� �� ����������������������ݵĴ����װ�������̲߳����������߳�����ʱ��������
//synchronized(����)��ͬ������飬��װ��Ҫ��ͬ���Ĵ��룻�׶ˣ�ͬ���������̷߳�����Ч�жϣ���Խ���Ч��
//ͬ����ǰ�᣺���̳߳���ͬһ��(����)->��ʶλ
//	��ʶλ����һ������������һ��������߳�Ϊ�ñ�ʶλΨһ��ɶ���
//	���о�����ͬ��ʶλ��������������룬�Ǹ��̲߳�����롣���̳߳���������һ��������̳߳�Ϊ����ɶ���
//synchronized + �Զ��庯����(){}:ͬ����������ʶλΪ��ǰ��,��synchronized(this);��̬ʱΪ...(��.class)
//ʹ ͬ���������ͬ������ ����ͬһ��this��ʶλ����Эͬ����
//����ʹ��ͬ������飬ͬ�����������д
//����������ͬ��Ƕ���з�������
//	�߳�1��ʼִ�У��õ�����A��
//	�߳�2ִ�У����õ�����B������������A�������ڴ�ʱ�߳�1�Ѿ�ռ������A�����Ծ͵ȴ��߳�1�ͷ���A��
//	�߳�1��������ִ�У������õ���B������B���߳�2ռ�ã��Ӷ��γ���������
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

//ͬ�������
//class Ticket implements Runnable{
//	private int num = 100;
//	Object obj = new Object();
//	public void run() {
////		Object obj = new Object();//��ͬ(����)->��ʶλ(���ĸ�)
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

//ͬ������
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