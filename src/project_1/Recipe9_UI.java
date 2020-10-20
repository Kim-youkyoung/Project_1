package project_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Recipe9_UI extends WindowAdapter implements ActionListener{
	Frame tableInfoFrame, reserveFrame, calculateFrame, infoFrame;
	Button btn1, btn2, btn3, btn4;
	Panel tableInfoPanel, reservePanel, res_tf_panel, infoPanel;
	String[] resMenu = {"�̸�","�޴���","�ο���","�ð�"};
	JPanel content_panel, content_panel2, menu_panel, price_panel, btn_panel;
	JLabel content_label;
	JButton cash, card;

	ArrayList<TextField> tf_list = new ArrayList<TextField>(8);
	
	Object[] columns = {"NO","���ĸ�","�ܰ�","����","�ݾ�"};	
	DefaultTableModel model =new DefaultTableModel(columns,0);
	JTable table= new JTable(model);
	Object[] row =new Object[5];
	
	String[] menu = {"ũ���Ľ�Ÿ" ,"���̵�"};
	int[] price = {21000 , 7000};
	
	//Constructor
	public Recipe9_UI() {  //1. ȭ�鱸��
		tableInfoFrame=new Frame();
		tableInfoPanel= new Panel();
		tableInfoPanel.setLayout(new GridLayout(1,4));
				
		btn1 = new Button("��  ��");
		btn2 = new Button("��  ��");
		btn3 = new Button("��  ��");
		btn4 = new Button("��  ��");

		tableInfoFrame.setTitle("���̺� ����");
		tableInfoFrame.add(tableInfoPanel);
		tableInfoPanel.add(btn1);
		tableInfoPanel.add(btn2);
		tableInfoPanel.add(btn3);
		tableInfoPanel.add(btn4);

		
		tableInfoFrame.setSize(300,100);
		tableInfoFrame.setVisible(true);
		
		tableInfoFrame.addWindowListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
	}
	
 	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand().trim();
		Object obj = e.getSource();
		
		int sum = 0;
		for(int p: price) {
			sum += p;
		}
		if(obj == btn1) {		
			order();			
		}else if(obj == btn2) {	
			calculate();
		}else if(obj == btn3) {
			reserve();
		}else if(obj == btn4) {
			info1();
		}else if(obj == cash) {
			int result = JOptionPane.showConfirmDialog(null, sum+"�� ���ݰ��� �Ͻðڽ��ϱ�?", "����Ȯ��", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.CLOSED_OPTION) {}
			else if(result == JOptionPane.YES_OPTION) {
				
			}else {
				
			}
		}else if(obj == card) {
			int result = JOptionPane.showConfirmDialog(null, sum+"�� ī����� �Ͻðڽ��ϱ�?", "����Ȯ��", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.CLOSED_OPTION) {}
			else if(result == JOptionPane.YES_OPTION) {
				
			}else {
				
			}
		}
		
	}
   	
	/**
	 * �ֹ�
	 */
   	public void order() {			
   		MenuUI ui = new MenuUI();
   	}
   	
   	/**
	 * ���
	 */
   	public void calculate() {			
   		calculateFrame = new Frame("����â");
   		content_panel = new JPanel();
   		content_panel2 = new JPanel(new GridLayout(10,1));
  		menu_panel = new JPanel();
   		price_panel = new JPanel();
  		btn_panel = new JPanel();
   		cash = new JButton("CASH");
   		card = new JButton("CARD");
   			   			
   		content_label = new JLabel("<�� �� �� ��>");
   		content_panel.add(content_label);
   			
   		for(int i=0; i<menu.length; i++) {
   			JPanel jp = new JPanel(new GridLayout(1,3));
 			JLabel label1 = new JLabel("                     "+(i+1)+".");
  			JLabel label2 = new JLabel(menu[i]);
   			JLabel label3 = new JLabel(price[i]+"");
  			jp.add(label1); jp.add(label2);  jp.add(label3);
   			content_panel2.add(jp);
   		}
   		
  		btn_panel.add(cash);
   		btn_panel.add(card);
   		cash.setPreferredSize(new Dimension(80,80));
   		card.setPreferredSize(new Dimension(80,80));
   			
   		calculateFrame.add(content_panel, BorderLayout.NORTH);
   		calculateFrame.add(content_panel2, BorderLayout.CENTER);
   		calculateFrame.add(btn_panel, BorderLayout.SOUTH);
   			
   		calculateFrame.setSize(300,500);
   		calculateFrame.setLocationRelativeTo(null);
   		calculateFrame.setVisible(true);
   			
   		
   		calculateFrame.addWindowListener(new WindowAdapter(){
   			public void windowClosing(WindowEvent e) {
   				calculateFrame.setVisible(false);
   				calculateFrame.dispose();
   			}
   		});		
   		cash.addActionListener(this);
   		card.addActionListener(this);
   	}
   	
   	/**
	 * ����
	 */
   	public void reserve() {
   		reserveFrame=new Frame();
   		reservePanel=new Panel();  		
   		reserveFrame.setTitle("����");
		
		Panel label_panel = new Panel(new GridLayout(4,1));
		Panel tf_panel = new Panel(new GridLayout(4,1));
		Panel btn_panel = new Panel();
		Button btn_reserve = new Button("����");
		Button btn_cancel = new Button("���");
		Choice people = new Choice();
		people.add("1��");
		people.add("2��");
		people.add("3��");
		people.add("4��");
		people.add("5��");
		people.add("6~9��");
		people.add("10�� �̻�");
		Choice time = new Choice();
		time.add("11��");
		time.add("12��");
		time.add("13��");
		time.add("14��");
		time.add("15��");
		time.add("16��");
		time.add("17��");
		time.add("18��");
		time.add("19��");
		time.add("20��");
		time.add("21��");
		time.add("22��");
		
		
		TextField tf_name = new TextField(7);
		TextField tf_phone1 = new TextField(2);
		TextField tf_phone2 = new TextField(2);
		TextField tf_phone3 = new TextField(2);
		Label extra1 = new Label("                           ");
		Label extra2 = new Label("                               ");
		Label extra3 = new Label("                                       ");

		Label phone1 = new Label("  -");
		Label phone2 = new Label("  -");
		
		Panel t_panel1 = new Panel();
		Panel t_panel2 = new Panel();
		Panel t_panel3 = new Panel();
		Panel t_panel4 = new Panel();

		
		tf_panel.add(t_panel1);
		tf_panel.add(t_panel2);
		tf_panel.add(t_panel3);
		tf_panel.add(t_panel4);
		
		t_panel1.add(tf_name);t_panel1.add(extra1);
		t_panel2.add(tf_phone1);t_panel2.add(phone1);t_panel2.add(tf_phone2);t_panel2.add(phone2);t_panel2.add(tf_phone3);
		t_panel3.add(people);t_panel3.add(extra2);
		t_panel4.add(time);t_panel4.add(extra3);
		
		tf_list.add(tf_name); 
		tf_list.add(tf_phone1); 
				
		btn_panel.add(btn_reserve);
		btn_panel.add(btn_cancel);
   				
		for(String name : resMenu) {
			Label label = new Label(name);
			Panel panel = new Panel();
			panel.add(label);
			label_panel.add(panel);
		}
		
		
		reservePanel.add(BorderLayout.WEST,label_panel);
		reservePanel.add(BorderLayout.CENTER,tf_panel);
		reservePanel.add(BorderLayout.SOUTH,btn_panel);
		reserveFrame.add(reservePanel);
		
		reserveFrame.setSize(370,230);
		reserveFrame.setVisible(true);
		
		btn_reserve.addActionListener(this);
		btn_cancel.addActionListener(this);
		
		reserveFrame.addWindowListener(new WindowAdapter(){
   			public void windowClosing(WindowEvent e) {
   				reserveFrame.setVisible(false);
   				reserveFrame.dispose();
   			}
   		});		
   	}
  
   	/**
	 * ���� ���� Ȯ��
	 */
   	public void info1() {			
   		infoFrame=new Frame();
   		infoPanel=new Panel();  		
   		infoFrame.setTitle("���� ����");
   		
   		Panel left_panel = new Panel(new GridLayout(4,1));
		Panel center_panel = new Panel(new GridLayout(4,1));
		Panel btn_panel = new Panel();
		Button btn_ok = new Button("Ȯ��");
		
		Panel t_panel1 = new Panel();
		Panel t_panel2 = new Panel();
		Panel t_panel3 = new Panel();
		Panel t_panel4 = new Panel();
   		
		center_panel.add(t_panel1);
		center_panel.add(t_panel2);
		center_panel.add(t_panel3);
		center_panel.add(t_panel4);
		
		btn_panel.add(btn_ok);
		
		for(String name : resMenu) {
			Label label1 = new Label(name);
			Panel panel = new Panel();
			Label label2 = new Label(" : ");			
			panel.add(label1);
			panel.add(label2);
			left_panel.add(panel);
		}
		
		infoPanel.add(BorderLayout.WEST,left_panel);
		infoPanel.add(BorderLayout.CENTER,center_panel);
		infoPanel.add(BorderLayout.SOUTH,btn_panel);
		infoFrame.add(infoPanel);
		
   		infoFrame.setSize(370,230);
   		infoFrame.setVisible(true);
   		
   		infoFrame.addWindowListener(new WindowAdapter(){
   			public void windowClosing(WindowEvent e) {
   				infoFrame.setVisible(false);
   				infoFrame.dispose();
   			}
   		});
   	}
   	
   	/**
   	 * �ֹ� ���� Ȯ��
   	 */
   	public void info2() {			
   		infoFrame=new Frame();
   		infoPanel=new Panel();  
   		
   		Panel under_panel = new Panel(new GridLayout(2,1));
   		Panel btn_panel = new Panel(new GridLayout(2,1));
   		
   		
   		infoFrame.setTitle("�ֹ� ����");
   		
   		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
	    TableColumnModel tcm = table.getColumnModel();
   		
	    table.getColumn("NO").setCellRenderer(dtcr);
	    table.getColumn("���ĸ�").setCellRenderer(dtcr);
	    table.getColumn("�ܰ�").setCellRenderer(dtcr);
	    table.getColumn("����").setCellRenderer(dtcr);
	    table.getColumn("�ݾ�").setCellRenderer(dtcr);
	    
	    
	    
	    JScrollPane pane=new JScrollPane(table);
		pane.setBounds(20,24,300,200);
		
		Label sum = new Label("��  �� : ");
		under_panel.add(sum);
			
		infoPanel.setLayout(new BorderLayout());
		infoPanel.add(BorderLayout.NORTH, new Label("<< �ֹ� ���� >>"));
		infoPanel.add(BorderLayout.CENTER,pane);
		infoPanel.add(BorderLayout.SOUTH,under_panel);

		infoFrame.add(infoPanel);

   		infoFrame.setSize(370,300);
   		infoFrame.setVisible(true);
   		
   		
   		infoFrame.addWindowListener(new WindowAdapter(){
   			public void windowClosing(WindowEvent e) {
   				infoFrame.setVisible(false);
   				infoFrame.dispose();
   			}
   		});
   	}
}