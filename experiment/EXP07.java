package experiment;

public class EXP07{
	//多态{子类向上向下转型，向上统一态应用、同级禁止互转}、内部类{内部调用，Fu.Zi a = new Fu.new Zi()、}
	//异常处理{异常处理类，error Exception，throw throws,try catch finally}
	//Object
	//权限				public		protected		default		private	
	//same-class		ok			ok				ok			ok
	//same-package		ok			ok				ok
	//son-class			ok			ok
	//diff-package		ok
	//多线程状态：run(),start(),stop()结束,
	//			被创建->运行->(冻结)->结束->消亡
	//冻结：sleep(time)睡眠 时间到恢复活动,wait()停止<->notify()唤醒
	//CPU执行资格:可被CPU处理，排队中
	//CPU执行权     :正被CPU处理
	//冻结会放弃  执行资格与执行权
	//临时阻塞  具备执行资格但不具备执行权，正在等待
	//wait: 可以指定时间timeout也可以不指定；释放执行权也释放锁
	//sleep:必须指定时间；				         释放执行权不释放锁
	//创建线程第一种方式：继承Thread类
	public static void main(String[] args) {
		MultiThread task01 = new MultiThread("task01");
		MultiThread task02 = new MultiThread("task02");
		task01.start();
		task02.start();
//		task01.run();
//		task02.run();
		for (int i = 0; i < 10; i++) {//延时
			for (int j = -999999999; j < 999999999; j++) {
				for (int k = -999999999; k < 999999999; k++) {}
			}
			System.out.println("main");
		}
	}
}
class MultiThread extends Thread{
	private String tab;
	MultiThread(String a){
		this.tab = a;
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			for (int j = -999999999; j < 999999999; j++) {
				for (int k = -999999999; k < 999999999; k++) {}
			}
			System.out.println(tab);
		}
	}
}