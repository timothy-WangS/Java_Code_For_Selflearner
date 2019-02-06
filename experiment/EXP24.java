package experiment;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//ͼ�ν���GUI
//awt:������ϵͳͼ�ν��洰��
//swing��ӵ���Լ���ͼ�ν������
//���֣���ʽ���֣��߽粼��(Ĭ�ϣ���Ҫ�ƶ�λ��:����������)������(��)���֣���Ƭ���֣�����ʽ����
//
//�¼��������ƣ��¼�Դ���¼������������¼�����
//WindowAdapter:���壬�������ڲ��࣬��������������
//ActionListener������������ڲ���
//MouseListener�����²��ͷţ����£��ͷţ����룬�뿪���϶�������
//|---->MouseAdapter
//	|---->MouseEvent����e.get���Ի�������ҵ������������������λ����Ϣ
//KeyListener:���룬���£��ͷ�
//|---->KeyAdapter
//	|---->KeyEvent��ȡ�����ֵ���룬��ֹ����(e.consumer)���ж���ϼ�(e.isXXXDown)����ֵ����(VK_XXX)
//
//swing
//
//
//
//
//
public class EXP24{
	public static void main(String[] args) {
		WindowSet ws = new WindowSet();
		ws.appMaker();
		System.out.println("over");
	}
}
class WindowSet{
	private Frame frame;
	private TextField tf;
	private Button bt;
	
	public void appMaker() {
		
		buttonSet();
		fileTextSet();
		frameSet();
		
		frame.add(tf);
		frame.add(bt);
	}
	private void frameSet() {
		frame = new Frame("My Frame");//��������
//		frame.setSize(500,400);//���ô�С����(����)
//		frame.setLocation(300,100);//���ñ߾�(����)
		frame.setBounds(300, 100, 500, 400);//���ñ߾�(����)���ô�С(����)
		frame.setLayout(new FlowLayout());//������ʽ����
		frame.setVisible(true);//���ÿɼ���
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {//����windowClosing����
				super.windowClosing(e);//���ǿշ���
				System.out.println("closing"+e);
				System.exit(0);
			}
		});
	}
	private void buttonSet() {
		bt = new Button("��ť");
//		bt.addActionListener(new ActionListener() {//���ð�ť����
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("Button Actived");//�������
//			}
//		});
		bt.addMouseListener(new MouseAdapter() {
//			int count = 0;
//			public void mouseEntered(MouseEvent e) {
//				System.out.println("����"+count++);
//				tf.setText(""+count);
//			}
//			public void mouseExited(MouseEvent e) {
//				System.out.println("�뿪");
//			}
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
				if(e.getClickCount()==2) {
					System.out.println("˫��");
				}
				
			}
		});
	}
	private void fileTextSet() {
		tf = new TextField("���JAVA",50);
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
			}
		});
	}
}