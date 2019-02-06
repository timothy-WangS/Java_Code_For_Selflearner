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

//图形界面GUI
//awt:依赖于系统图形界面窗口
//swing：拥有自己的图形界面组件
//布局：流式布局，边界布局(默认，需要制定位置:东南西北中)，网格(包)布局，卡片布局，坐标式布局
//
//事件监听机制：事件源，事件，监听器，事件处理
//WindowAdapter:窗体，用匿名内部类，创建监听器对象
//ActionListener：组件，匿名内部类
//MouseListener：按下并释放，按下，释放，进入，离开，拖动，滚轮
//|---->MouseAdapter
//	|---->MouseEvent利用e.get可以获得左中右单击，连击次数，点击位置信息
//KeyListener:键入，按下，释放
//|---->KeyAdapter
//	|---->KeyEvent获取键入的值，码，阻止输入(e.consumer)，判断组合键(e.isXXXDown)，键值常量(VK_XXX)
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
		frame = new Frame("My Frame");//窗体名称
//		frame.setSize(500,400);//设置大小像素(宽，高)
//		frame.setLocation(300,100);//设置边距(左，上)
		frame.setBounds(300, 100, 500, 400);//设置边距(左，上)设置大小(宽，高)
		frame.setLayout(new FlowLayout());//设置流式布局
		frame.setVisible(true);//设置可见性
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {//覆盖windowClosing方法
				super.windowClosing(e);//这是空方法
				System.out.println("closing"+e);
				System.exit(0);
			}
		});
	}
	private void buttonSet() {
		bt = new Button("按钮");
//		bt.addActionListener(new ActionListener() {//设置按钮动作
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("Button Actived");//点击动作
//			}
//		});
		bt.addMouseListener(new MouseAdapter() {
//			int count = 0;
//			public void mouseEntered(MouseEvent e) {
//				System.out.println("进入"+count++);
//				tf.setText(""+count);
//			}
//			public void mouseExited(MouseEvent e) {
//				System.out.println("离开");
//			}
			public void mouseClicked(MouseEvent e) {
				System.out.println(e);
				if(e.getClickCount()==2) {
					System.out.println("双击");
				}
				
			}
		});
	}
	private void fileTextSet() {
		tf = new TextField("你好JAVA",50);
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				
				System.out.println(KeyEvent.getKeyText(e.getKeyCode()));
			}
		});
	}
}