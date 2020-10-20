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
		
		if(name.equals("�α���") || obj == ui.tf_pass) {
			ui.loginProc();
		}else if(name.equals("1��") ||name.equals("2��") ||name.equals("3��") ||name.equals("4��") ||name.equals("5��") ||
				name.equals("6��") ||name.equals("7��") || name.equals("8��") ||name.equals("9��") ) {
			Recipe9_UI rec = new Recipe9_UI();
		}else if(name.equals("������Ȳ")) {
			int sales = 10000;
			JOptionPane.showMessageDialog(null, "�Ϸ� ������� "+ sales+"�� �Դϴ�.");
		}else if(name.equals("����")) {
			String date = "2020-10-19";
			int price = 30000;
			int sales = 10000;
			String str = date + ": " + price +"�� \n\n���� ����: "+ sales +"��\n������ �մϴ�";
			int result = JOptionPane.showConfirmDialog(null,  str, "����", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.CLOSED_OPTION) {}
			else if(result == JOptionPane.YES_OPTION) {
				
			}else {
				
			}
		}
	}
}
