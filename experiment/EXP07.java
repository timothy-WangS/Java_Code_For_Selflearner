package experiment;

public class EXP07{
	//��̬{������������ת�ͣ�����ͳһ̬Ӧ�á�ͬ����ֹ��ת}���ڲ���{�ڲ����ã�Fu.Zi a = new Fu.new Zi()��}
	//�쳣����{�쳣�����࣬error Exception��throw throws,try catch finally}
	//Object
	//Ȩ��				public		protected		default		private	
	//same-class		ok			ok				ok			ok
	//same-package		ok			ok				ok
	//son-class			ok			ok
	//diff-package		ok
	//���߳�״̬��run(),start(),stop()����,
	//			������->����->(����)->����->����
	//���᣺sleep(time)˯�� ʱ�䵽�ָ��,wait()ֹͣ<->notify()����
	//CPUִ���ʸ�:�ɱ�CPU�����Ŷ���
	//CPUִ��Ȩ     :����CPU����
	//��������  ִ���ʸ���ִ��Ȩ
	//��ʱ����  �߱�ִ���ʸ񵫲��߱�ִ��Ȩ�����ڵȴ�
	//wait: ����ָ��ʱ��timeoutҲ���Բ�ָ�����ͷ�ִ��ȨҲ�ͷ���
	//sleep:����ָ��ʱ�䣻				         �ͷ�ִ��Ȩ���ͷ���
	//�����̵߳�һ�ַ�ʽ���̳�Thread��
	public static void main(String[] args) {
		MultiThread task01 = new MultiThread("task01");
		MultiThread task02 = new MultiThread("task02");
		task01.start();
		task02.start();
//		task01.run();
//		task02.run();
		for (int i = 0; i < 10; i++) {//��ʱ
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