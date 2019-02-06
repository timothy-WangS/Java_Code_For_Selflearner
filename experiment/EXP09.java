package experiment;
//同步synchronized在锁相同的一个处理过程中有效，在有多个处理过程，如output与input时要统一用一个锁
//这个锁一般在开启多线程的函数中创建，并以参数传入各个过程
//等待唤醒机制：在Input结束后启动Output，关闭Input；Output结束后再开启Input
//			wait():让线程冻结，使处于线程池中；锁.wait():使该锁线程冻结
//			notify():唤醒线程池任意线程；锁.notify:唤醒该锁中所应用的线程
//			notifyAll():唤醒所有线程
//生产消费模型：同时进行生产消费，且先有生产后有消费；生产达到满额停生产只消费，消费至空停消费只生产
//多个生产者消费者的问题：重复生产消费 与 同时wait
//解决：	重复生产：用while循环判断flag；		同时wait：由本方唤醒本方造成，用notifyAll()唤醒对方
//		while+notifyAll
//
//新的解决办法：util.concurrent包 Lock接口对synchronized替代
//		while+lock
//import java.util.concurrent.locks.Lock;
//Lock my_lock = new ReentrantLock;
			////Condition my_con = my_lock.newCondition;//相同于synchronized
			////	r.wait------->my_con.await
			////	r.notify----->my_con.signal
			////	r.notifyAll-->my_con.signalAll
//Condition pro_con = my_lock.newCondition//设置生产者监视器
//Condition usr_con = my_lock.newCondition//设置消费者监视器
//void show{
//		lock.lock();		//获取锁
//		try{				//对有Exception的代码，CODE放在try内，unlock放在finally内
//			CODE			//原来包裹在synchronized内部的代码
//		}
//		catch{      }
//		finally{
//			lock.unlock();	//释放锁
//		}		
//}
//一个lock锁可以有多组wait，notify对象监视器（多个condition对象）
//通过已有的锁获得对象
//r.wait------->pro_con.await或usr_con.await
//r.notify----->pro_con.signal或usr_con.signal
//pro_con.signal会唤醒因pro_con.await冻结的线程
//usr_con.signal会唤醒因usr_con.await冻结的线程
//参数timeout：要等待的最长时间
//
//线程的停止：r1.interrupt();//中断冻结
//强制退出wait或sleep状态，并抛出Exception异常，在catch中执行退出线程操作
//setDaemon():守护线程(后台)，定义线程时定义，与所有进程相同开启，当运行的线程只有守护线程时JVM自动结束
//join():r1.start();r1.join();r1加入运行，并优先执行完毕，其它线程才开启（继续）。也抛出中断异常
//setPriority():r1.start();r1.setPriority(Threaad.MAX_PRIORITY)设置优先级(MAX为最高优先级)
//				依然随机运行线程，但分配的时间改变
//Thread.yield():暂停当前线程,临时释放执行权
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
	private boolean flag;//服务于等待唤醒机制
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
				r.notify();//唤醒Input
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
				r.notify();//唤醒Output
			}
			x = (x+1)%2; 
		}
	}
}