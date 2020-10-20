package project_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuUI extends WindowAdapter implements ActionListener {
	//Field
	JFrame menu;
	JPanel menu_panel, save_panel, order_panel, content_panel, plate_panel, pizza_panel, pilaff_panel, pasta_panel, salad_panel, drink_panel;
	JButton btn_save, btn_order;
	String[] menu_names = {"플레이트","피자","필라프","파스타","샐러드","음료"};
	
	public static final int PLATE = 1;
	public static final int PIZZA = 2;
	public static final int PILAFF = 3;
	public static final int PASTA = 4;
	public static final int SALAD = 5;
	public static final int DRINK = 6;
	
	//Constructor
	public MenuUI() {
		menu = new JFrame("MENU");
		menu_panel = new JPanel(new GridLayout(7,1));
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
			Button menu = new Button(name);
			menu_panel.add(menu);
			menu.addActionListener(this);
		}
		
		save_panel.add(btn_save);
		order_panel.add(btn_order);
		menu_panel.add(order_panel);
		
		menu.add(BorderLayout.WEST, menu_panel);
		menu.add(BorderLayout.CENTER, content_panel);
		
		menu.setSize(600,550);
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
		
		menu.addWindowListener(new WindowAdapter(){
   			public void windowClosing(WindowEvent e) {
   				menu.setVisible(false);
   				menu.dispose();
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
				plate_panel.setVisible(true);	break;
			case 2:
				pizza_panel.setVisible(true);	break;
			case 3:
				pilaff_panel.setVisible(true);	break;
			case 4:
				pasta_panel.setVisible(true);	break;
			case 5:
				salad_panel.setVisible(true);	break;
			case 6:
				drink_panel.setVisible(true);	break;
		}
	}
	
	//플레이트 메뉴
	public void plate() {
		switchPanel(MenuUI.PLATE);
		plate_panel.removeAll();

		JCheckBox cb1 = new JCheckBox("바베큐 샐러드 플레이트 21000원");
		JCheckBox cb2 = new JCheckBox("닭다리 샐러드 플레이트 21000원");
		JCheckBox cb3 = new JCheckBox("함박 스테이크 샐러드 플레이트 21000원");
		JCheckBox cb4 = new JCheckBox("팬스테이크/부채살 21000원");
		JCheckBox cb5 = new JCheckBox("떡볶이 플레이트 19000원");
		
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
		menu.setVisible(true);
	}
	
	//피자 메뉴
	public void pizza() {
		switchPanel(MenuUI.PIZZA);
		pizza_panel.removeAll();
		
		JCheckBox cb1 = new JCheckBox("고르곤졸라 피자 14,000원");
		JCheckBox cb2 = new JCheckBox("갈릭스위트 피자 14,000원");
		JCheckBox cb3 = new JCheckBox("마르게리타 피자 14,000원");
		JCheckBox cb4 = new JCheckBox("썬 베이컨 피자 14,000원");
		JCheckBox cb5 = new JCheckBox("시금치 피자 14,000원");
		
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
		
		pizza_panel.add(menu1);
		pizza_panel.add(menu2);
		pizza_panel.add(menu3);
		pizza_panel.add(menu4);
		pizza_panel.add(menu5);
		
		content_panel.add(pizza_panel);
		content_panel.add(BorderLayout.SOUTH, save_panel);
		menu.setVisible(true);
	}
	
	//필라프 메뉴
	public void pilaff() {
		switchPanel(MenuUI.PILAFF);
		pilaff_panel.removeAll();
		
		JCheckBox cb1 = new JCheckBox("새우 필라프 19,000원");
		JCheckBox cb2 = new JCheckBox("김치 필라프 19,000원");
		JCheckBox cb3 = new JCheckBox("목살 필라프 19,000원");
		JCheckBox cb4 = new JCheckBox("불닭 필라프 19,000원");
		JCheckBox cb5 = new JCheckBox("불고기 필라프 19,000원");
		
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
		
		pilaff_panel.add(menu1);
		pilaff_panel.add(menu2);
		pilaff_panel.add(menu3);
		pilaff_panel.add(menu4);
		pilaff_panel.add(menu5);
		
		content_panel.add(pilaff_panel);
		content_panel.add(BorderLayout.SOUTH, save_panel);
		menu.setVisible(true);
	}

	//파스타 메뉴
	public void pasta() {
		switchPanel(MenuUI.PASTA);
		pasta_panel.removeAll();
		
		JCheckBox cb1 = new JCheckBox("까르보나라 19,000원");
		JCheckBox cb2 = new JCheckBox("봉골레 19,000원");
		JCheckBox cb3 = new JCheckBox("해산물 크림스파게티 19,000원");
		JCheckBox cb4 = new JCheckBox("해산물 토마토스파게티 19,000원");
		JCheckBox cb5 = new JCheckBox("해산물 올리브오일스파게티 19,000원");
		JCheckBox cb6 = new JCheckBox("루꼴라 해산물 스파게티 19,000원");
		
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
		
		menu1.add(BorderLayout.SOUTH, cb1);
		menu2.add(BorderLayout.SOUTH, cb2);
		menu3.add(BorderLayout.SOUTH, cb3);
		menu4.add(BorderLayout.SOUTH, cb4);
		menu5.add(BorderLayout.SOUTH, cb5);
		menu6.add(BorderLayout.SOUTH, cb6);
		
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
		menu.setVisible(true);
	}
	
	//샐러드 메뉴
	public void salad() {
		switchPanel(MenuUI.SALAD);
		salad_panel.removeAll();
		
		JCheckBox cb1 = new JCheckBox("버팔로윙/웨지감자 샐러드 14,000원");
		JCheckBox cb2 = new JCheckBox("연어 샐러드 19,000원");
		JCheckBox cb3 = new JCheckBox("샐러드 스파게티 14,000원");
		
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
		
		menu1.add(BorderLayout.SOUTH, cb1);
		menu2.add(BorderLayout.SOUTH, cb2);
		menu3.add(BorderLayout.SOUTH, cb3);
		
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
		menu.setVisible(true);
	}
	
	//음료 메뉴
	public void drink() {
		switchPanel(MenuUI.DRINK);
		drink_panel.removeAll();
		
		JCheckBox cb1 = new JCheckBox("콜라 2,000원");
		JCheckBox cb2 = new JCheckBox("사이다 2,000원");
		JCheckBox cb3 = new JCheckBox("레몬에이드 5,000원");
		JCheckBox cb4 = new JCheckBox("자몽에이드 5,000원");
		
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
		
		menu1.add(BorderLayout.SOUTH, cb1);
		menu2.add(BorderLayout.SOUTH, cb2);
		menu3.add(BorderLayout.SOUTH, cb3);
		menu4.add(BorderLayout.SOUTH, cb4);
		
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
		menu.setVisible(true);
	}
	
	
	//Method
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	} 
	
	public void actionPerformed(ActionEvent ae) {
		String name = ae.getActionCommand().trim();
		Object obj = ae.getSource();
		if(name.equals("플레이트")) {
			plate();
		}else if(name.equals("피자")) {
			pizza();
		}else if(name.equals("필라프")) {
			pilaff();
		}else if(name.equals("파스타")) {
			pasta();
		}else if(name.equals("샐러드")) {
			salad();
		}else if(name.equals("음료")) {
			drink();
		}
	}

}//CLASS
















































