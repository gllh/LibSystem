package com.cqjtu.lyx.Library.Admin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cqjtu.lyx.Library.Entity.AdminInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��14�� ����10:31:12
 * @ClassName ������ û��
 * @Description ������ û��
 */
public class AddAdmin extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();

	JLabel adminnumber = new JLabel("����Ա���:");
	JLabel adminname = new JLabel("����Ա����:");
	JLabel adminpass = new JLabel("����Ա����:");
	JTextField numberField = new JTextField();
	JTextField nameField = new JTextField();
	JTextField passField = new JTextField();
	JButton back = new JButton("����");
	JButton confirm = new JButton("���");

	public AddAdmin() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(7, 1, 1, 10));
		p1.add(adminnumber);
		p1.add(numberField);
		p1.add(adminname);
		p1.add(nameField);
		p1.add(adminpass);
		p1.add(passField);
		p1.add(back);
		p1.add(confirm);

		back.addActionListener(this);
		confirm.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			this.dispose();
		}
		if (e.getSource() == confirm) {
			if(nameField.getText().equals("")||passField.getText().equals("")){
				JOptionPane.showMessageDialog(null,
						"����Ϊ��", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				
			AdminInfo ai = new AdminInfo(numberField.getText(),nameField.getText(),passField.getText());
			ArrayList<String> strArray = new ArrayList<String>();
			strArray = op.addAdminJudgement();
			int n = 0;
			int replicate = 0;
			while (n < Integer.parseInt(strArray.get(0))) {
				n++;
				if (nameField.getText().equals(strArray.get(n))) {
					replicate++;
				}
			}
			if (replicate == 0) {
				op.saveAdmin(ai);
				JOptionPane.showMessageDialog(null, "��ӳɹ�",
						"Information", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"�Ѵ��ڴ˹���Ա��������", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}	
	}
}
