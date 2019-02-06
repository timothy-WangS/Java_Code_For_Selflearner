package experiment;
//ͬ��synchronized������ͬ��һ�������������Ч�����ж��������̣���output��inputʱҪͳһ��һ����
//�����һ���ڿ������̵߳ĺ����д��������Բ��������������
//�ȴ����ѻ��ƣ���Input����������Output���ر�Input��Output�������ٿ���Input
//			wait():���̶߳��ᣬʹ�����̳߳��У���.wait():ʹ�����̶߳���
//			notify():�����̳߳������̣߳���.notify:���Ѹ�������Ӧ�õ��߳�
//			notifyAll():���������߳�
//��������ģ�ͣ�ͬʱ�����������ѣ������������������ѣ������ﵽ����ͣ����ֻ���ѣ���������ͣ����ֻ����
//��������������ߵ����⣺�ظ��������� �� ͬʱwait
//�����	�ظ���������whileѭ���ж�flag��		ͬʱwait���ɱ������ѱ�����ɣ���notifyAll()���ѶԷ�
//		while+notifyAll
//
//�µĽ���취��util.concurrent�� Lock�ӿڶ�synchronized���
//		while+lock
//import java.util.concurrent.locks.Lock;
//Lock my_lock = new ReentrantLock;
			////Condition my_con = my_lock.newCondition;//��ͬ��synchronized
			////	r.wait------->my_con.await
			////	r.notify----->my_con.signal
			////	r.notifyAll-->my_con.signalAll
//Condition pro_con = my_lock.newCondition//���������߼�����
//Condition usr_con = my_lock.newCondition//���������߼�����
//void show{
//		lock.lock();		//��ȡ��
//		try{				//����Exception�Ĵ��룬CODE����try�ڣ�unlock����finally��
//			CODE			//ԭ��������synchronized�ڲ��Ĵ���
//		}
//		catch{      }
//		finally{
//			lock.unlock();	//�ͷ���
//		}		
//}
//һ��lock�������ж���wait��notify��������������condition����
//ͨ�����е�����ö���
//r.wait------->pro_con.await��usr_con.await
//r.notify----->pro_con.signal��usr_con.signal
//pro_con.signal�ỽ����pro_con.await������߳�
//usr_con.signal�ỽ����usr_con.await������߳�
//����timeout��Ҫ�ȴ����ʱ��
//
//�̵߳�ֹͣ��r1.interrupt();//�ж϶���
//ǿ���˳�wait��sleep״̬�����׳�Exception�쳣����catch��ִ���˳��̲߳���
//setDaemon():�ػ��߳�(��̨)�������߳�ʱ���壬�����н�����ͬ�����������е��߳�ֻ���ػ��߳�ʱJVM�Զ�����
//join():r1.start();r1.join();r1�������У�������ִ����ϣ������̲߳ſ�������������Ҳ�׳��ж��쳣
//setPriority():r1.start();r1.setPriority(Threaad.MAX_PRIORITY)�������ȼ�(MAXΪ������ȼ�)
//				��Ȼ��������̣߳��������ʱ��ı�
//Thread.yield():��ͣ��ǰ�߳�,��ʱ�ͷ�ִ��Ȩ
public class EXP09{
	public static void main(String[] args) {
		Resource r = new Resource();
		Input i = new Input(r);
		Output o = new Output(r); 
		Thread r1 = new Thread(i);
		Thread r2 = new Thread(o);
		r1.start();
		r2.start();
	}
}

class Resource{
	private String name;
	private String sex;
	private boolean flag;//�����ڵȴ����ѻ���
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
class Output implements Runnable{
	Resource r;
	Output(Resource r) {
		this.r = r;
	}	
	public void run() {
		while(true) {
			synchronized (r) {
				if(!r.isFlag()) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(r.getName()+"......"+r.getSex());
				r.setFlag(false);
				r.notify();//����Input
			}
		}
	}
}
class Input implements Runnable{
	Resource r;
	Input(Resource r) {
		this.r = r;
	}
	public void run() {
		int x = 0;
		while (true) {
			synchronized (r) {
				if(r.isFlag()) {
					try {
						r.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(x==0) {
					r.setName("AA");
					r.setSex("M");
				}
				else {
					r.setName("IIIIII");
					r.setSex("ffffff");
				}
				r.setFlag(true);
				r.notify();//����Output
			}
			x = (x+1)%2; 
		}
	}
}