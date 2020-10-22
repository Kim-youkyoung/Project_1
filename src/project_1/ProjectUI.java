package project_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ProjectUI {
   //field
   ProjectEvent pro_event;
   
   JFrame loginFrame, tableInfoFrame, reserveFrame, infoFrame, menuFrame, payFrame, orderFrame;
   JPanel intro_panel, tableInfoPanel, reservePanel, res_tf_panel, infoPanel, menu_panel, save_panel, order_panel, content_panel,
   		  plate_panel, pizza_panel, pilaff_panel, pasta_panel, salad_panel, drink_panel,
   		  menu_panel2, payment_panel, payment_panel2, price_panel, btn_panel;
   JLabel content_label;
   JTextField tf_id;
   JPasswordField tf_pass;
   JButton btn_seat_1, btn_seat_2, btn_seat_3, btn_seat_4, btn_seat_5, btn_seat_6, btn_seat_7, btn_seat_8, btn_seat_9,
   		   btn_sales, btn_result, btn_menuOrder, btn_payment, btn_reserve, btn_info, btn_save, btn_order, btn_cash, btn_card;
   JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23,cb24,cb25,cb26,cb27,cb28;
   
   String[] menu_test = {"ũ���Ľ�Ÿ" ,"���̵�"};
   int[] price_test = {21000 , 7000};
   
   String[] resMenu = {"�̸�","�޴���","�ο���","�ð�"};
   String[] menu_names = {"�÷���Ʈ","����","�ʶ���","�Ľ�Ÿ","������","����"};
   ArrayList<JTextField> tf_list = new ArrayList<JTextField>(8);
   
   Object[] columns = {"NO","���ĸ�","�ܰ�","����","�ݾ�"};   
   DefaultTableModel model =new DefaultTableModel(columns,0);
   JTable table= new JTable(model);
   Object[] row =new Object[5];
   
   public static final int PLATE = 1;
   public static final int PIZZA = 2;
   public static final int PILAFF = 3;
   public static final int PASTA = 4;
   public static final int SALAD = 5;
   public static final int DRINK = 6;
   
   //constructor
   public ProjectUI() {
      //�α���â
      pro_event = new ProjectEvent(this);
      
      loginFrame = new JFrame("������ �α���");
      intro_panel = new JPanel();
      intro_panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

      ImageIcon img = new ImageIcon("images/recipe9_login.jpg");
      JLabel logo = new JLabel(img);
      
      JPanel login_panel = new JPanel(new GridLayout(2,1));
      JPanel id_panel = new JPanel();
      JPanel pass_panel = new JPanel();
      JLabel label_id = new JLabel("���̵�    ");
      JLabel label_pass = new JLabel("��й�ȣ");
      tf_id = new JTextField(9);
      tf_pass = new JPasswordField(9);
      JButton btn_login = new JButton("�α���");
      
      id_panel.add(label_id);
      id_panel.add(tf_id);
      pass_panel.add(label_pass);
      pass_panel.add(tf_pass);
      login_panel.add(id_panel);
      login_panel.add(pass_panel);
      
      intro_panel.add(BorderLayout.CENTER, logo);
      intro_panel.add(BorderLayout.SOUTH, login_panel);
      intro_panel.add(BorderLayout.WEST, btn_login);
      
      loginFrame.add(intro_panel);
      loginFrame.setSize(450,360);
      loginFrame.setLocationRelativeTo(null);
      loginFrame.setVisible(true);
      
      loginFrame.addWindowListener(pro_event);
      btn_login.addActionListener(pro_event);
      tf_pass.addActionListener(pro_event);
   }
   
   //method
   public void loginProc() {
      //�α��� ����
      String id = tf_id.getText().trim();
       String pass = tf_pass.getText().trim();
       
       if(id.equals("test") && pass.equals("1234")) {
          JOptionPane.showMessageDialog(null, "�α��� ����");
          mainForm();

       } else {
          JOptionPane.showMessageDialog(null, "�α��� ����. ���̵� ��й�ȣ�� Ȯ���ϼ���");
          tf_id.requestFocus();
       }  
   }
   public void mainForm() {
      //���̺� ���� ������
	  loginFrame.setVisible(false);
	  pro_event = new ProjectEvent(this);
      
      loginFrame = new JFrame("�����ֹ��ý���");
      
      intro_panel = new JPanel(new BorderLayout(30,30));
      intro_panel.setBackground(Color.white);
      intro_panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
      
      ImageIcon img = new ImageIcon("images/recipe9_main.png");
      JLabel logo = new JLabel(img);
      JPanel menu_panel2 = new JPanel(new GridLayout(2,1,30,30));
      JPanel seat_panel = new JPanel(new GridLayout(3,3,30,30));
      
      btn_seat_1 = new JButton("1��");
      btn_seat_2 = new JButton("2��");
      btn_seat_3 = new JButton("3��");
      btn_seat_4 = new JButton("4��");
      btn_seat_5 = new JButton("5��");
      btn_seat_6 = new JButton("6��");
      btn_seat_7 = new JButton("7��");
      btn_seat_8 = new JButton("8��");
      btn_seat_9 = new JButton("9��");
      btn_sales = new JButton("������Ȳ");
      btn_result = new JButton("����");
      
      seat_panel.add(btn_seat_1); seat_panel.add(btn_seat_2);
      seat_panel.add(btn_seat_3); seat_panel.add(btn_seat_4);
      seat_panel.add(btn_seat_5); seat_panel.add(btn_seat_6);
      seat_panel.add(btn_seat_7); seat_panel.add(btn_seat_8);
      seat_panel.add(btn_seat_9);
      seat_panel.setBackground(Color.WHITE);
      menu_panel2.add(btn_sales); menu_panel2.add(btn_result);
      menu_panel2.setBackground(Color.WHITE);
      
      intro_panel.add(BorderLayout.NORTH, logo);
      intro_panel.add(BorderLayout.CENTER, seat_panel);
      intro_panel.add(BorderLayout.EAST, menu_panel2);
      
      loginFrame.add(intro_panel);
      loginFrame.setSize(700,500);
      loginFrame.setLocationRelativeTo(null);
      loginFrame.setVisible(true);
      
      loginFrame.addWindowListener(pro_event);
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
   public void choiceForm() {
      //�ֹ�, ���, ����, ���� ���� â
      pro_event = new ProjectEvent(this);
      
      tableInfoFrame = new JFrame("���̺� ����");
      tableInfoPanel= new JPanel(new GridLayout(1,4));
            
      btn_menuOrder = new JButton("��  ��");
      btn_payment = new JButton("��  ��");
      btn_reserve = new JButton("��  ��");
      btn_info = new JButton("��  ��");

      tableInfoPanel.add(btn_menuOrder);
      tableInfoPanel.add(btn_payment);
      tableInfoPanel.add(btn_reserve);
      tableInfoPanel.add(btn_info);

      tableInfoFrame.add(tableInfoPanel);
      tableInfoFrame.setSize(300,100);
      tableInfoFrame.setVisible(true);
      
      tableInfoFrame.addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent e) {
            tableInfoFrame.setVisible(false);
            tableInfoFrame.dispose();
          }
       });      
      btn_menuOrder.addActionListener(pro_event);
      btn_payment.addActionListener(pro_event);
      btn_reserve.addActionListener(pro_event);
      btn_info.addActionListener(pro_event);
   }
   
   /**
    * �ֹ�
    */
   public void order() {         
      menuFrame = new JFrame("MENU");
      orderFrame = new JFrame("��ٱ���");
      menu_panel = new JPanel(new GridLayout(6,1));
      content_panel = new JPanel(new BorderLayout());
      order_panel = new JPanel();
      save_panel = new JPanel();
      plate_panel = new JPanel(new GridLayout(3,2));
      pizza_panel = new JPanel(new GridLayout(3,2));
      pilaff_panel = new JPanel(new GridLayout(3,2));
      pasta_panel = new JPanel(new GridLayout(3,2));
      salad_panel = new JPanel(new GridLayout(3,2));
      drink_panel = new JPanel(new GridLayout(2,2));

      btn_order = new JButton("�ֹ��ϱ�");
      btn_save = new JButton("���");
      
      //menu ��ư ����
      for(String name : menu_names) {
         JButton menu = new JButton(name);
         menu_panel.add(menu);
         menu.addActionListener(pro_event);
      }
      
      save_panel.add(btn_save);
      order_panel.add(btn_order);
      orderFrame.add(BorderLayout.SOUTH, order_panel);
      menuFrame.add(BorderLayout.WEST, menu_panel);
      menuFrame.add(BorderLayout.CENTER, content_panel);
      
      menuFrame.setSize(600,550);
      menuFrame.setLocationRelativeTo(null);
      menuFrame.setVisible(true);
      
      orderFrame.setSize(300,300);
      orderFrame.setLocation(180, 135);
      orderFrame.setVisible(true);
      
      menuFrame.addWindowListener(new WindowAdapter(){
          public void windowClosing(WindowEvent e) {
            menuFrame.setVisible(false);
            menuFrame.dispose();
          }
       });      
   }

      /** �г� reset **/
   public void resetMenuPanel() {
      plate_panel.setVisible(false);
      pizza_panel.setVisible(false);
      pilaff_panel.setVisible(false);
      pasta_panel.setVisible(false);
      salad_panel.setVisible(false);
      drink_panel.setVisible(false);
   }
   
   /** �޴� ���� �� �г� ����Ī**/
   public void switchPanel(int menu) {
      //��� �޴��� �г��� ��Ȱ��ȭ
      resetMenuPanel();
      switch(menu) {
         case 1:
            plate_panel.setVisible(true);   break;
         case 2:
            pizza_panel.setVisible(true);   break;
         case 3:
            pilaff_panel.setVisible(true);   break;
         case 4:
            pasta_panel.setVisible(true);   break;
         case 5:
            salad_panel.setVisible(true);   break;
         case 6:
            drink_panel.setVisible(true);   break;
      }
   }
   
   //�÷���Ʈ �޴�
      public void plate() {
         switchPanel(this.PLATE);
         plate_panel.removeAll();

         cb1 = new JCheckBox("�ٺ�ť ������ �÷���Ʈ 21000��");
         cb2 = new JCheckBox("�ߴٸ� ������ �÷���Ʈ 21000��");
         cb3 = new JCheckBox("�Թ� ������ũ ������ �÷���Ʈ 21000��");
         cb4 = new JCheckBox("�ҽ�����ũ/��ä�� 21000��");
         cb5 = new JCheckBox("������ �÷���Ʈ 19000��");
         
         ImageIcon img1 = new ImageIcon("images/plate1.png");
         ImageIcon img2 = new ImageIcon("images/plate2.png");
         ImageIcon img3 = new ImageIcon("images/plate3.png");
         ImageIcon img4 = new ImageIcon("images/plate4.png");
         ImageIcon img5 = new ImageIcon("images/plate5.png");
         
         JLabel logo1 = new JLabel(img1);
         JLabel logo2 = new JLabel(img2);
         JLabel logo3 = new JLabel(img3);
         JLabel logo4 = new JLabel(img4);
         JLabel logo5 = new JLabel(img5);
         
         JPanel menu1 = new JPanel(new BorderLayout());
         JPanel menu2 = new JPanel(new BorderLayout());
         JPanel menu3 = new JPanel(new BorderLayout());
         JPanel menu4 = new JPanel(new BorderLayout());
         JPanel menu5 = new JPanel(new BorderLayout());
         
         menu1.add(BorderLayout.SOUTH, cb1);
         menu2.add(BorderLayout.SOUTH, cb2);
         menu3.add(BorderLayout.SOUTH, cb3);
         menu4.add(BorderLayout.SOUTH, cb4);
         menu5.add(BorderLayout.SOUTH, cb5);
         
         menu1.add(BorderLayout.CENTER, logo1);
         menu2.add(BorderLayout.CENTER, logo2);
         menu3.add(BorderLayout.CENTER, logo3);
         menu4.add(BorderLayout.CENTER, logo4);
         menu5.add(BorderLayout.CENTER, logo5);
         
         plate_panel.add(menu1);
         plate_panel.add(menu2);
         plate_panel.add(menu3);
         plate_panel.add(menu4);
         plate_panel.add(menu5);
         content_panel.add(plate_panel);
         content_panel.add(BorderLayout.SOUTH, save_panel);
         menuFrame.setVisible(true);
      }
      
      //���� �޴�
      public void pizza() {
         switchPanel(this.PIZZA);
         pizza_panel.removeAll();
         
         cb6 = new JCheckBox("�������� ���� 14,000��");
         cb7 = new JCheckBox("��������Ʈ ���� 14,000��");
         cb8 = new JCheckBox("�����Ը�Ÿ ���� 14,000��");
         cb9 = new JCheckBox("�� ������ ���� 14,000��");
         cb10 = new JCheckBox("�ñ�ġ ���� 14,000��");
         
         ImageIcon img1 = new ImageIcon("images/pizza1.png");
         ImageIcon img2 = new ImageIcon("images/pizza2.png");
         ImageIcon img3 = new ImageIcon("images/pizza3.png");
         ImageIcon img4 = new ImageIcon("images/pizza4.png");
         ImageIcon img5 = new ImageIcon("images/pizza5.png");
         
         JLabel logo1 = new JLabel(img1);
         JLabel logo2 = new JLabel(img2);
         JLabel logo3 = new JLabel(img3);
         JLabel logo4 = new JLabel(img4);
         JLabel logo5 = new JLabel(img5);
         
         JPanel menu1 = new JPanel(new BorderLayout());
         JPanel menu2 = new JPanel(new BorderLayout());
         JPanel menu3 = new JPanel(new BorderLayout());
         JPanel menu4 = new JPanel(new BorderLayout());
         JPanel menu5 = new JPanel(new BorderLayout());

         menu1.add(BorderLayout.SOUTH, cb6);
         menu2.add(BorderLayout.SOUTH, cb7);
         menu3.add(BorderLayout.SOUTH, cb8);
         menu4.add(BorderLayout.SOUTH, cb9);
         menu5.add(BorderLayout.SOUTH, cb10);
         
         menu1.add(BorderLayout.CENTER, logo1);
         menu2.add(BorderLayout.CENTER, logo2);
         menu3.add(BorderLayout.CENTER, logo3);
         menu4.add(BorderLayout.CENTER, logo4);
         menu5.add(BorderLayout.CENTER, logo5);
   
         pizza_panel.add(menu1);
         pizza_panel.add(menu2);
         pizza_panel.add(menu3);
         pizza_panel.add(menu4);
         pizza_panel.add(menu5);
     
         content_panel.add(pizza_panel);
         content_panel.add(BorderLayout.SOUTH, save_panel);
         menuFrame.setVisible(true);
      }
      
      //�ʶ��� �޴�
      public void pilaff() {
         switchPanel(this.PILAFF);
         pilaff_panel.removeAll();
         
         cb11 = new JCheckBox("���� �ʶ��� 19,000��");
         cb12 = new JCheckBox("��ġ �ʶ��� 19,000��");
         cb13 = new JCheckBox("��� �ʶ��� 19,000��");
         cb14 = new JCheckBox("�Ҵ� �ʶ��� 19,000��");
         cb15 = new JCheckBox("�Ұ�� �ʶ��� 19,000��");
         
         ImageIcon img1 = new ImageIcon("images/pilaff1.png");
         ImageIcon img2 = new ImageIcon("images/pilaff2.png");
         ImageIcon img3 = new ImageIcon("images/pilaff3.png");
         ImageIcon img4 = new ImageIcon("images/pilaff4.png");
         ImageIcon img5 = new ImageIcon("images/pilaff5.png");
         
         JLabel logo1 = new JLabel(img1);
         JLabel logo2 = new JLabel(img2);
         JLabel logo3 = new JLabel(img3);
         JLabel logo4 = new JLabel(img4);
         JLabel logo5 = new JLabel(img5);
         
         JPanel menu1 = new JPanel(new BorderLayout());
         JPanel menu2 = new JPanel(new BorderLayout());
         JPanel menu3 = new JPanel(new BorderLayout());
         JPanel menu4 = new JPanel(new BorderLayout());
         JPanel menu5 = new JPanel(new BorderLayout());
         
         menu1.add(BorderLayout.SOUTH, cb11);
         menu2.add(BorderLayout.SOUTH, cb12);
         menu3.add(BorderLayout.SOUTH, cb13);
         menu4.add(BorderLayout.SOUTH, cb14);
         menu5.add(BorderLayout.SOUTH, cb15);
         
         menu1.add(BorderLayout.CENTER, logo1);
         menu2.add(BorderLayout.CENTER, logo2);
         menu3.add(BorderLayout.CENTER, logo3);
         menu4.add(BorderLayout.CENTER, logo4);
         menu5.add(BorderLayout.CENTER, logo5);
         
         pilaff_panel.add(menu1);
         pilaff_panel.add(menu2);
         pilaff_panel.add(menu3);
         pilaff_panel.add(menu4);
         pilaff_panel.add(menu5);
         
         content_panel.add(pilaff_panel);
         content_panel.add(BorderLayout.SOUTH, save_panel);
         menuFrame.setVisible(true);
      }

      //�Ľ�Ÿ �޴�
      public void pasta() {
         switchPanel(this.PASTA);
         pasta_panel.removeAll();
         
         cb16 = new JCheckBox("������� 19,000��");
         cb17 = new JCheckBox("���� 19,000��");
         cb18 = new JCheckBox("�ػ깰 ũ�����İ�Ƽ 19,000��");
         cb19 = new JCheckBox("�ػ깰 �丶�佺�İ�Ƽ 19,000��");
         cb20 = new JCheckBox("�ػ깰 �ø�����Ͻ��İ�Ƽ 19,000��");
         cb21 = new JCheckBox("��ö� �ػ깰 ���İ�Ƽ 19,000��");
         
         ImageIcon img1 = new ImageIcon("images/pasta1.png");
         ImageIcon img2 = new ImageIcon("images/pasta2.png");
         ImageIcon img3 = new ImageIcon("images/pasta3.png");
         ImageIcon img4 = new ImageIcon("images/pasta4.png");
         ImageIcon img5 = new ImageIcon("images/pasta5.png");
         ImageIcon img6 = new ImageIcon("images/pasta6.png");
         
         JLabel logo1 = new JLabel(img1);
         JLabel logo2 = new JLabel(img2);
         JLabel logo3 = new JLabel(img3);
         JLabel logo4 = new JLabel(img4);
         JLabel logo5 = new JLabel(img5);
         JLabel logo6 = new JLabel(img6);
         
         JPanel menu1 = new JPanel(new BorderLayout());
         JPanel menu2 = new JPanel(new BorderLayout());
         JPanel menu3 = new JPanel(new BorderLayout());
         JPanel menu4 = new JPanel(new BorderLayout());
         JPanel menu5 = new JPanel(new BorderLayout());
         JPanel menu6 = new JPanel(new BorderLayout());
         
         menu1.add(BorderLayout.SOUTH, cb16);
         menu2.add(BorderLayout.SOUTH, cb17);
         menu3.add(BorderLayout.SOUTH, cb18);
         menu4.add(BorderLayout.SOUTH, cb19);
         menu5.add(BorderLayout.SOUTH, cb20);
         menu6.add(BorderLayout.SOUTH, cb21);
         
         menu1.add(BorderLayout.CENTER, logo1);
         menu2.add(BorderLayout.CENTER, logo2);
         menu3.add(BorderLayout.CENTER, logo3);
         menu4.add(BorderLayout.CENTER, logo4);
         menu5.add(BorderLayout.CENTER, logo5);
         menu6.add(BorderLayout.CENTER, logo6);
         
         pasta_panel.add(menu1);
         pasta_panel.add(menu2);
         pasta_panel.add(menu3);
         pasta_panel.add(menu4);
         pasta_panel.add(menu5);
         pasta_panel.add(menu6);
         
         content_panel.add(pasta_panel);
         content_panel.add(BorderLayout.SOUTH, save_panel);
         menuFrame.setVisible(true);
      }
      
      //������ �޴�
      public void salad() {
         switchPanel(this.SALAD);
         salad_panel.removeAll();
         
         cb22 = new JCheckBox("���ȷ���/�������� ������ 14,000��");
         cb23 = new JCheckBox("���� ������ 19,000��");
         cb24 = new JCheckBox("������ ���İ�Ƽ 14,000��");
         
         ImageIcon img1 = new ImageIcon("images/salad1.png");
         ImageIcon img2 = new ImageIcon("images/salad2.png");
         ImageIcon img3 = new ImageIcon("images/salad3.png");
         
         JLabel logo1 = new JLabel(img1);
         JLabel logo2 = new JLabel(img2);
         JLabel logo3 = new JLabel(img3);
         JLabel logo4 = new JLabel("");
         JLabel logo5 = new JLabel("");
         
         JPanel menu1 = new JPanel(new BorderLayout());
         JPanel menu2 = new JPanel(new BorderLayout());
         JPanel menu3 = new JPanel(new BorderLayout());
         JPanel menu4 = new JPanel(new BorderLayout());
         JPanel menu5 = new JPanel(new BorderLayout());
         
         menu1.add(BorderLayout.SOUTH, cb22);
         menu2.add(BorderLayout.SOUTH, cb23);
         menu3.add(BorderLayout.SOUTH, cb24);
         
         menu1.add(BorderLayout.CENTER, logo1);
         menu2.add(BorderLayout.CENTER, logo2);
         menu3.add(BorderLayout.CENTER, logo3);
         menu4.add(BorderLayout.CENTER, logo4);
         menu5.add(BorderLayout.CENTER, logo5);
         
         salad_panel.add(menu1);
         salad_panel.add(menu2);
         salad_panel.add(menu3);
         salad_panel.add(menu4);
         salad_panel.add(menu5);
         
         content_panel.add(salad_panel);
         content_panel.add(BorderLayout.SOUTH, save_panel);
         menuFrame.setVisible(true);
      }
      
      //���� �޴�
      public void drink() {
         switchPanel(this.DRINK);
         drink_panel.removeAll();
         
         cb25 = new JCheckBox("�ݶ� 2,000��");
         cb26 = new JCheckBox("���̴� 2,000��");
         cb27 = new JCheckBox("�����̵� 5,000��");
         cb28 = new JCheckBox("�ڸ����̵� 5,000��");
         
         ImageIcon img1 = new ImageIcon("images/cola.png");
         ImageIcon img2 = new ImageIcon("images/cider.png");
         ImageIcon img3 = new ImageIcon("images/lemon.png");
         ImageIcon img4 = new ImageIcon("images/jamong.png");
         
         JLabel logo1 = new JLabel(img1);
         JLabel logo2 = new JLabel(img2);
         JLabel logo3 = new JLabel(img3);
         JLabel logo4 = new JLabel(img4);
         
         JPanel menu1 = new JPanel(new BorderLayout());
         JPanel menu2 = new JPanel(new BorderLayout());
         JPanel menu3 = new JPanel(new BorderLayout());
         JPanel menu4 = new JPanel(new BorderLayout());
         
         menu1.add(BorderLayout.SOUTH, cb25);
         menu2.add(BorderLayout.SOUTH, cb26);
         menu3.add(BorderLayout.SOUTH, cb27);
         menu4.add(BorderLayout.SOUTH, cb28);
         
         menu1.add(BorderLayout.CENTER, logo1);
         menu2.add(BorderLayout.CENTER, logo2);
         menu3.add(BorderLayout.CENTER, logo3);
         menu4.add(BorderLayout.CENTER, logo4);
         
         drink_panel.add(menu1);
         drink_panel.add(menu2);
         drink_panel.add(menu3);
         drink_panel.add(menu4);
         
         content_panel.add(drink_panel);
         content_panel.add(BorderLayout.SOUTH, save_panel);
         menuFrame.setVisible(true);
      }
      
      /**
    * ���
    */
      public void payment() {
    	 payFrame = new JFrame("����â");
         payment_panel = new JPanel();
         payment_panel2 = new JPanel(new GridLayout(10,1));
         menu_panel = new JPanel();
         price_panel = new JPanel();
         btn_panel = new JPanel();
         btn_cash = new JButton("CASH");
         btn_card = new JButton("CARD");
         
//         card.setBackground(new Color(255,255,255));
         
         content_label = new JLabel("<�� �� �� ��>");
         payment_panel.add(content_label);
         
         for(int i=0; i<menu_test.length; i++) {
            JPanel jp = new JPanel(new GridLayout(1,3));
            JLabel label1 = new JLabel("                     "+(i+1)+".");
            JLabel label2 = new JLabel(menu_test[i]);
            JLabel label3 = new JLabel(price_test[i]+"");
            jp.add(label1); jp.add(label2);  jp.add(label3);
            payment_panel2.add(jp);
         }
      
      
         btn_panel.add(btn_cash);
         btn_panel.add(btn_card);
         btn_cash.setPreferredSize(new Dimension(80,80));
         btn_card.setPreferredSize(new Dimension(80,80));
         
         payFrame.add(payment_panel, BorderLayout.NORTH);
         payFrame.add(payment_panel2, BorderLayout.CENTER);
         payFrame.add(btn_panel, BorderLayout.SOUTH);
         
         payFrame.setSize(300,500);
         payFrame.setLocationRelativeTo(null);
         payFrame.setVisible(true);
         
         payFrame.addWindowListener(new WindowAdapter(){
             public void windowClosing(WindowEvent e) {
            	 payFrame.setVisible(false);
            	 payFrame.dispose();
             }
          });      
         btn_cash.addActionListener(pro_event);
         btn_card.addActionListener(pro_event);
      }
      
      /**
    * ����
    */
      public void reserve() {
         reserveFrame = new JFrame();
         reservePanel = new JPanel();        
         reserveFrame.setTitle("����");
      
      JPanel label_panel = new JPanel(new GridLayout(4,1));
      JPanel tf_panel = new JPanel(new GridLayout(4,1));
      JPanel btn_panel = new JPanel();
      JButton btn_reserve = new JButton("����");
      JButton btn_cancel = new JButton("���");
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
      
      
      JTextField tf_name = new JTextField(7);
      JTextField tf_phone1 = new JTextField(3);
      JTextField tf_phone2 = new JTextField(4);
      JTextField tf_phone3 = new JTextField(4);
      JLabel extra1 = new JLabel("                                  ");
      JLabel extra2 = new JLabel("                                 ");
      JLabel extra3 = new JLabel("                                         ");

      JLabel phone1 = new JLabel("  -  ");
      JLabel phone2 = new JLabel("  -  ");
      
      JPanel t_panel1 = new JPanel();
      JPanel t_panel2 = new JPanel();
      JPanel t_panel3 = new JPanel();
      JPanel t_panel4 = new JPanel();

      
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
      reserveFrame.setLocationRelativeTo(null);
      
      btn_reserve.addActionListener(pro_event);
      btn_cancel.addActionListener(pro_event);
      
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
         infoFrame = new JFrame();
         infoPanel = new JPanel();        
         infoFrame.setTitle("���� ����");
         
         JPanel left_panel = new JPanel(new GridLayout(4,1));
      JPanel center_panel = new JPanel(new GridLayout(4,1));
      JPanel btn_panel = new JPanel();
      JButton btn_ok = new JButton("Ȯ��");
      
      JPanel t_panel1 = new JPanel();
      JPanel t_panel2 = new JPanel();
      JPanel t_panel3 = new JPanel();
      JPanel t_panel4 = new JPanel();
         
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
         infoFrame.setLocationRelativeTo(null);
         
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
         infoFrame = new JFrame();
         infoPanel = new JPanel();  
         
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
         infoFrame.setLocationRelativeTo(null);
         
         infoFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
               infoFrame.setVisible(false);
               infoFrame.dispose();
            }
         });
      }
}