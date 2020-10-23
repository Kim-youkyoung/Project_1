package project_1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProjectEvent extends WindowAdapter implements ActionListener{
   //field
   ProjectUI ui;
   int i = 1;
   //constructor
   public ProjectEvent(ProjectUI ui) {
      this.ui = ui;

   }
   //method
   
   public void windowClosing(WindowEvent e) {
      System.exit(0);
   }
   
   public void actionPerformed(ActionEvent ae) {
      String name = ae.getActionCommand().trim();
      Object obj = ae.getSource();
      
      int sum = 0;
      for(int p: ui.price_test) {
         sum += p;
      }
      
      if(name.equals("로그인") || obj == ui.tf_pass) {
         ui.loginProc();
      } else if((JButton)obj == ui.btn_seat_1 || (JButton)obj == ui.btn_seat_2 || (JButton)obj == ui.btn_seat_3 || 
            (JButton)obj == ui.btn_seat_4 || (JButton)obj == ui.btn_seat_5 || (JButton)obj == ui.btn_seat_6 ||
            (JButton)obj == ui.btn_seat_7 || (JButton)obj == ui.btn_seat_8 || (JButton)obj == ui.btn_seat_9) {
         ui.choiceForm();
      } else if((JButton)obj == ui.btn_menuOrder) {      
         ui.order();
      } else if((JButton)obj == ui.btn_payment) {   
         ui.payment();
      } else if((JButton)obj == ui.btn_reserve) {
         ui.reserve();
      } else if((JButton)obj == ui.btn_info) {
         ui.info1();
      } else if(name.equals("플레이트")) {
         ui.plate();
      } else if(name.equals("피자")) {
         ui.pizza();
      } else if(name.equals("필라프")) {
         ui.pilaff();
      } else if(name.equals("파스타")) {
         ui.pasta();
      } else if(name.equals("샐러드")) {
         ui.salad();
      } else if(name.equals("음료")) {
         ui.drink();
      }else if((JButton)obj == ui.btn_save1){
    	  OrderCheck();
      }else if((JButton)obj == ui.btn_save2){
    	  System.out.println("dd");
    	  OrderCheck2();
      }else if((JButton)obj == ui.btn_save3){
    	  OrderCheck();
      }else if((JButton)obj == ui.btn_save4){
    	  OrderCheck();
      }else if((JButton)obj == ui.btn_save5){
    	  OrderCheck();
      }else if((JButton)obj == ui.btn_save6){
    	  OrderCheck();
      }
      else if(name.equals("주문하기")) {
         
    	  
      }else if(obj == ui.btn_cash) {
         int result = JOptionPane.showConfirmDialog(null, sum+"원 현금결제 하시겠습니까?", "결제확인", JOptionPane.YES_NO_OPTION);
         if(result == JOptionPane.CLOSED_OPTION) {}
         else if(result == JOptionPane.YES_OPTION) {
            
         }else {
            
         }
      } else if(obj == ui.btn_card) {
         int result = JOptionPane.showConfirmDialog(null, sum+"원 카드결제 하시겠습니까?", "결제확인", JOptionPane.YES_NO_OPTION);
         if(result == JOptionPane.CLOSED_OPTION) {}
         else if(result == JOptionPane.YES_OPTION) {
            
         }else {
            
         }
      } else if(obj == ui.btn_sales) {
         int sales = 10000;
         JOptionPane.showMessageDialog(null, "하루 매출액은 "+ sales+"원 입니다.");
      } else if(obj == ui.btn_result) {
         String date = "2020-10-19";
         int price = 30000;
         int sales = 10000;
         String str = date + ": " + price +"원 \n\n오늘 매출: "+ sales +"원\n정산을 합니다";
         int result = JOptionPane.showConfirmDialog(null,  str, "정산", JOptionPane.YES_NO_OPTION);
         if(result == JOptionPane.CLOSED_OPTION) {}
         else if(result == JOptionPane.YES_OPTION) {
            
         }else {
           
         }
      }
   }
   
   public void OrderCheck() {
	   if(ui.cb1.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb1.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb1.setSelected(false);
		   i++;
	   }
	   if(ui.cb2.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb2.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb2.setSelected(false);
		   i++;
	   }
	   if(ui.cb3.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb3.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb3.setSelected(false);
		   i++;
	   }
	   if(ui.cb4.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb4.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb4.setSelected(false);
		   i++;
	   }
	   if(ui.cb5.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb5.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb5.setSelected(false);
		   i++;
	   }
   }
   
   public void OrderCheck2() {
	   if(ui.cb6.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb6.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb6.setSelected(false);
		   i++;
	   }
	   if(ui.cb7.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb7.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb7.setSelected(false);
		   i++;
	   }
	   if(ui.cb8.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb8.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb8.setSelected(false);
		   i++;
	   }
	   if(ui.cb9.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb9.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb9.setSelected(false);
		   i++;
	   }
	   if(ui.cb10.isSelected()) {
		   ui.cart_panel.add(new JLabel(i+". "+ui.cb10.getText()));
		   ui.orderFrame.setVisible(true);
		   ui.cb10.setSelected(false);
		   i++;
	   }
   }
}