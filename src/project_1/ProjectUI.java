package project_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProjectUI {

	//field
	ProjectEvent pro_event;
	JFrame f;
	JPanel intro_panel;
	JTextField tf_id;
	JPasswordField tf_pass;
	//constructor
	
	public ProjectUI() {
		pro_event = new ProjectEvent(this);
		
		f = new JFrame("관리자 로그인");
		intro_panel = new JPanel();
		intro_panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		ImageIcon img = new ImageIcon("images/recipe9_login.jpg");
		JLabel logo = new JLabel(img);
		
		JPanel login_panel = new JPanel(new GridLayout(2,1));
		JPanel id_panel = new JPanel();
		JPanel pass_panel = new JPanel();
		JLabel label_id = new JLabel("아이디    ");
		JLabel label_pass = new JLabel("비밀번호");
		tf_id = new JTextField(9);
		tf_pass = new JPasswordField(9);
		JButton btn_login = new JButton("로그인");
		
		id_panel.add(label_id);
		id_panel.add(tf_id);
		pass_panel.add(label_pass);
		pass_panel.add(tf_pass);
		login_panel.add(id_panel);
		login_panel.add(pass_panel);
		
		intro_panel.add(BorderLayout.CENTER, logo);
		intro_panel.add(BorderLayout.SOUTH, login_panel);
		intro_panel.add(BorderLayout.WEST, btn_login);
		
		f.add(intro_panel);
		f.setSize(450,360);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter(){
   			public void windowClosing(WindowEvent e) {
   				f.setVisible(false);
   				f.dispose();
   			}
   		});		
		btn_login.addActionListener(pro_event);
		tf_pass.addActionListener(pro_event);
	}
	
	//method
	public void loginProc() {
		String id = tf_id.getText().trim();
	    String pass = tf_pass.getText().trim();
	    
	    if(id.equals("test") && pass.equals("1234")) {
	    	JOptionPane.showMessageDialog(null, "로그인 성공");
	    	mainForm();
	    } else {
	    	JOptionPane.showMessageDialog(null, "로그인 실패. 아이디나 비밀번호를 확인하세요");
	    	tf_id.requestFocus();
	    }  
	}
	public void mainForm() {
		pro_event = new ProjectEvent(this);
		
		f = new JFrame("음식주문시스템");
		
		intro_panel = new JPanel(new BorderLayout(30,30));
		intro_panel.setBackground(Color.white);
		intro_panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		ImageIcon img = new ImageIcon("images/recipe9_main.png");
		JLabel logo = new JLabel(img);
		Panel menu_panel = new Panel(new GridLayout(2,1,30,30));
		Panel seat_panel = new Panel(new GridLayout(3,3,30,30));
		JButton btn_seat_1 = new JButton("1번");
		JButton btn_seat_2 = new JButton("2번");
		JButton btn_seat_3 = new JButton("3번");
		JButton btn_seat_4 = new JButton("4번");
		JButton btn_seat_5 = new JButton("5번");
		JButton btn_seat_6 = new JButton("6번");
		JButton btn_seat_7 = new JButton("7번");
		JButton btn_seat_8 = new JButton("8번");
		JButton btn_seat_9 = new JButton("9번");
		JButton btn_sales = new JButton("매출현황");
		JButton btn_result = new JButton("정산");
		
		seat_panel.add(btn_seat_1); seat_panel.add(btn_seat_2);
		seat_panel.add(btn_seat_3); seat_panel.add(btn_seat_4);
		seat_panel.add(btn_seat_5); seat_panel.add(btn_seat_6);
		seat_panel.add(btn_seat_7); seat_panel.add(btn_seat_8);
		seat_panel.add(btn_seat_9);
		menu_panel.add(btn_sales); menu_panel.add(btn_result);
		
		intro_panel.add(BorderLayout.NORTH, logo);
		intro_panel.add(BorderLayout.CENTER, seat_panel);
		intro_panel.add(BorderLayout.EAST, menu_panel);
		
		f.add(intro_panel);
		f.setSize(700,500);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.addWindowListener(pro_event);
		btn_seat_1.addActionListener(pro_event);
		btn_seat_2.addActionListener(pro_event);
		btn_seat_3.addActionListener(pro_event);
		btn_seat_4.addActionListener(pro_event);
		btn_seat_5.addActionListener(pro_event);
		btn_seat_6.addActionListener(pro_event);
		btn_seat_7.addActionListener(pro_event);
		btn_seat_8.addActionListener(pro_event);
		btn_seat_9.addActionListener(pro_event);
		btn_sales.addActionListener(pro_event);
		btn_result.addActionListener(pro_event);
		
	}
}
