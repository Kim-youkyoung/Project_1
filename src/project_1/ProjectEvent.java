package project_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ProjectEvent extends WindowAdapter implements ActionListener{
	//field
	ProjectUI ui;
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
		
		if(name.equals("로그인") || obj == ui.tf_pass) {
			ui.loginProc();
		}else if(name.equals("1번") ||name.equals("2번") ||name.equals("3번") ||name.equals("4번") ||name.equals("5번") ||
				name.equals("6번") ||name.equals("7번") || name.equals("8번") ||name.equals("9번") ) {
			Recipe9_UI rec = new Recipe9_UI();
		}else if(name.equals("매출현황")) {
			int sales = 10000;
			JOptionPane.showMessageDialog(null, "하루 매출액은 "+ sales+"원 입니다.");
		}else if(name.equals("정산")) {
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
}
