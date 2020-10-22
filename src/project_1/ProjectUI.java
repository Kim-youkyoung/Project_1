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
   
   String[] menu_test = {"크림파스타" ,"에이드"};
   int[] price_test = {21000 , 7000};
   
   String[] resMenu = {"이름","휴대폰","인원수","시간"};
   String[] menu_names = {"플레이트","피자","필라프","파스타","샐러드","음료"};
   ArrayList<JTextField> tf_list = new ArrayList<JTextField>(8);
   
   Object[] columns = {"NO","음식명","단가","수량","금액"};   
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
      //로그인창
      pro_event = new ProjectEvent(this);
      
      loginFrame = new JFrame("관리자 로그인");
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
      //로그인 로직
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
      //테이블 선택 메인폼
	  loginFrame.setVisible(false);
	  pro_event = new ProjectEvent(this);
      
      loginFrame = new JFrame("음식주문시스템");
      
      intro_panel = new JPanel(new BorderLayout(30,30));
      intro_panel.setBackground(Color.white);
      intro_panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
      
      ImageIcon img = new ImageIcon("images/recipe9_main.png");
      JLabel logo = new JLabel(img);
      JPanel menu_panel2 = new JPanel(new GridLayout(2,1,30,30));
      JPanel seat_panel = new JPanel(new GridLayout(3,3,30,30));
      
      btn_seat_1 = new JButton("1번");
      btn_seat_2 = new JButton("2번");
      btn_seat_3 = new JButton("3번");
      btn_seat_4 = new JButton("4번");
      btn_seat_5 = new JButton("5번");
      btn_seat_6 = new JButton("6번");
      btn_seat_7 = new JButton("7번");
      btn_seat_8 = new JButton("8번");
      btn_seat_9 = new JButton("9번");
      btn_sales = new JButton("매출현황");
      btn_result = new JButton("정산");
      
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
      //주문, 계산, 예약, 정보 선택 창
      pro_event = new ProjectEvent(this);
      
      tableInfoFrame = new JFrame("테이블 정보");
      tableInfoPanel= new JPanel(new GridLayout(1,4));
            
      btn_menuOrder = new JButton("주  문");
      btn_payment = new JButton("계  산");
      btn_reserve = new JButton("예  약");
      btn_info = new JButton("정  보");

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
    * 주문
    */
   public void order() {         
      menuFrame = new JFrame("MENU");
      orderFrame = new JFrame("장바구니");
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

      btn_order = new JButton("주문하기");
      btn_save = new JButton("담기");
      
      //menu 버튼 생성
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

      /** 패널 reset **/
   public void resetMenuPanel() {
      plate_panel.setVisible(false);
      pizza_panel.setVisible(false);
      pilaff_panel.setVisible(false);
      pasta_panel.setVisible(false);
      salad_panel.setVisible(false);
      drink_panel.setVisible(false);
   }
   
   /** 메뉴 선택 시 패널 스위칭**/
   public void switchPanel(int menu) {
      //모든 메뉴의 패널을 비활성화
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
   
   //플레이트 메뉴
      public void plate() {
         switchPanel(this.PLATE);
         plate_panel.removeAll();

         cb1 = new JCheckBox("바베큐 샐러드 플레이트 21000원");
         cb2 = new JCheckBox("닭다리 샐러드 플레이트 21000원");
         cb3 = new JCheckBox("함박 스테이크 샐러드 플레이트 21000원");
         cb4 = new JCheckBox("팬스테이크/부채살 21000원");
         cb5 = new JCheckBox("떡볶이 플레이트 19000원");
         
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
      
      //피자 메뉴
      public void pizza() {
         switchPanel(this.PIZZA);
         pizza_panel.removeAll();
         
         cb6 = new JCheckBox("고르곤졸라 피자 14,000원");
         cb7 = new JCheckBox("갈릭스위트 피자 14,000원");
         cb8 = new JCheckBox("마르게리타 피자 14,000원");
         cb9 = new JCheckBox("썬 베이컨 피자 14,000원");
         cb10 = new JCheckBox("시금치 피자 14,000원");
         
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
      
      //필라프 메뉴
      public void pilaff() {
         switchPanel(this.PILAFF);
         pilaff_panel.removeAll();
         
         cb11 = new JCheckBox("새우 필라프 19,000원");
         cb12 = new JCheckBox("김치 필라프 19,000원");
         cb13 = new JCheckBox("목살 필라프 19,000원");
         cb14 = new JCheckBox("불닭 필라프 19,000원");
         cb15 = new JCheckBox("불고기 필라프 19,000원");
         
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

      //파스타 메뉴
      public void pasta() {
         switchPanel(this.PASTA);
         pasta_panel.removeAll();
         
         cb16 = new JCheckBox("까르보나라 19,000원");
         cb17 = new JCheckBox("봉골레 19,000원");
         cb18 = new JCheckBox("해산물 크림스파게티 19,000원");
         cb19 = new JCheckBox("해산물 토마토스파게티 19,000원");
         cb20 = new JCheckBox("해산물 올리브오일스파게티 19,000원");
         cb21 = new JCheckBox("루꼴라 해산물 스파게티 19,000원");
         
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
      
      //샐러드 메뉴
      public void salad() {
         switchPanel(this.SALAD);
         salad_panel.removeAll();
         
         cb22 = new JCheckBox("버팔로윙/웨지감자 샐러드 14,000원");
         cb23 = new JCheckBox("연어 샐러드 19,000원");
         cb24 = new JCheckBox("샐러드 스파게티 14,000원");
         
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
      
      //음료 메뉴
      public void drink() {
         switchPanel(this.DRINK);
         drink_panel.removeAll();
         
         cb25 = new JCheckBox("콜라 2,000원");
         cb26 = new JCheckBox("사이다 2,000원");
         cb27 = new JCheckBox("레몬에이드 5,000원");
         cb28 = new JCheckBox("자몽에이드 5,000원");
         
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
    * 계산
    */
      public void payment() {
    	 payFrame = new JFrame("결제창");
         payment_panel = new JPanel();
         payment_panel2 = new JPanel(new GridLayout(10,1));
         menu_panel = new JPanel();
         price_panel = new JPanel();
         btn_panel = new JPanel();
         btn_cash = new JButton("CASH");
         btn_card = new JButton("CARD");
         
//         card.setBackground(new Color(255,255,255));
         
         content_label = new JLabel("<주 문 내 역>");
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
    * 예약
    */
      public void reserve() {
         reserveFrame = new JFrame();
         reservePanel = new JPanel();        
         reserveFrame.setTitle("예약");
      
      JPanel label_panel = new JPanel(new GridLayout(4,1));
      JPanel tf_panel = new JPanel(new GridLayout(4,1));
      JPanel btn_panel = new JPanel();
      JButton btn_reserve = new JButton("예약");
      JButton btn_cancel = new JButton("취소");
      Choice people = new Choice();
      people.add("1명");
      people.add("2명");
      people.add("3명");
      people.add("4명");
      people.add("5명");
      people.add("6~9명");
      people.add("10명 이상");
      Choice time = new Choice();
      time.add("11시");
      time.add("12시");
      time.add("13시");
      time.add("14시");
      time.add("15시");
      time.add("16시");
      time.add("17시");
      time.add("18시");
      time.add("19시");
      time.add("20시");
      time.add("21시");
      time.add("22시");
      
      
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
    * 예약 정보 확인
    */
      public void info1() {         
         infoFrame = new JFrame();
         infoPanel = new JPanel();        
         infoFrame.setTitle("예약 정보");
         
         JPanel left_panel = new JPanel(new GridLayout(4,1));
      JPanel center_panel = new JPanel(new GridLayout(4,1));
      JPanel btn_panel = new JPanel();
      JButton btn_ok = new JButton("확인");
      
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
       * 주문 정보 확인
       */
      public void info2() {         
         infoFrame = new JFrame();
         infoPanel = new JPanel();  
         
         Panel under_panel = new Panel(new GridLayout(2,1));
         Panel btn_panel = new Panel(new GridLayout(2,1));
         
         
         infoFrame.setTitle("주문 정보");
         
         model.setColumnIdentifiers(columns);
      table.setModel(model);
      
      DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
       TableColumnModel tcm = table.getColumnModel();
         
       table.getColumn("NO").setCellRenderer(dtcr);
       table.getColumn("음식명").setCellRenderer(dtcr);
       table.getColumn("단가").setCellRenderer(dtcr);
       table.getColumn("수량").setCellRenderer(dtcr);
       table.getColumn("금액").setCellRenderer(dtcr);
       
       
       
       JScrollPane pane=new JScrollPane(table);
      pane.setBounds(20,24,300,200);
      
      Label sum = new Label("합  계 : ");
      under_panel.add(sum);
         
      infoPanel.setLayout(new BorderLayout());
      infoPanel.add(BorderLayout.NORTH, new Label("<< 주문 내역 >>"));
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