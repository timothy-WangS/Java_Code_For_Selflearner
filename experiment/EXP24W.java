package experiment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JDialog;

public class EXP24W extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JDialog dialog;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EXP24W frame = new EXP24W();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EXP24W() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("°´Å¥");
		btnNewButton.setBounds(286, 29, 110, 32);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				turnTo();
			}
		});
		contentPane.setLayout(null);
		
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 30, 265, 32);
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					turnTo();
			}
		});
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 73, 384, 179);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, -2, 434, 21);
		contentPane.add(menuBar);
		
		JMenu menu_0 = new JMenu("\u6587\u4EF6");
		menuBar.add(menu_0);
		
		JMenuItem menuItem_0 = new JMenuItem("\u6253\u5F00");
		menuItem_0.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dialog = new JDialog();
				dialog.setBounds(100, 200, 200, 150);
				dialog.setVisible(true);
			}
		});
		menu_0.add(menuItem_0);
		menu_0.add(menuItem_0);
		
		JMenuItem menuItem_1 = new JMenuItem("\u65B0\u5EFA");
		menu_0.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4FDD\u5B58");
		menu_0.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u53E6\u5B58\u4E3A");
		menu_0.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("\u7F16\u8F91");
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u6784\u5EFA");
		menuBar.add(menu_2);
		
		JMenu menu_3 = new JMenu("\u6D4F\u89C8");
		menuBar.add(menu_3);
		
		JMenu menu_4 = new JMenu("\u9879\u76EE");
		menuBar.add(menu_4);
		
		JMenu menu_5 = new JMenu("\u5E2E\u52A9");
		menuBar.add(menu_5);
	}

	public void turnTo() {
		String dir_str = textField.getText();
		File dir = new File(dir_str);
		if(dir.exists()&&dir.isDirectory()) {
			textArea.setText("");
			String[] names = dir.list();
			for(String name : names) {
				textArea.append(name+"\r\n");
			}
		}
	}
}
