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
 * @version ����ʱ�䣺2018��6��19�� ����9:33:33
 * @ClassName ������ EditAdmin
 * @Description ������ �޸Ĺ���Ա��Ϣ
 */
public class EditAdmin extends JFrame implements ActionListener {
	
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();

	JLabel adminNumber = new JLabel("����Ա���:");
	JLabel adminName = new JLabel("����Ա����:");
	JLabel adminPass = new JLabel("����Ա����:");
	JLabel nameField = new JLabel();
	JTextField numberField = new JTextField();
	JTextField passField = new JTextField();
	JButton cancel = new JButton("ȡ��");
	JButton save = new JButton("�޸�");

	public EditAdmin(String name) {
		System.out.println("2222DQAWDQWDQWD");
		nameField.setText(name);
		AdminInfo admin = new AdminInfo(name);
		ArrayList<String> strArray = new ArrayList<String>();
		strArray = op.outputAdmin(admin);
		System.out.println(strArray);
		nameField.setText(name);
		numberField.setText(strArray.get(1));
		passField.setText(strArray.get(2));

		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(6, 2, 20, 10));
		p1.add(adminNumber);
		p1.add(numberField);
		p1.add(adminName);
		p1.add(nameField);
		p1.add(adminPass);
		p1.add(passField);
		p1.add(cancel);
		p1.add(save);

		cancel.addActionListener(this);
		save.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();
		}
		if (e.getSource() == save) {
			if(numberField.getText().equals("")||nameField.getText().equals("")
					||passField.getText().equals("")){
				JOptionPane.showMessageDialog(null,
						"����Ϊ��", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
			AdminInfo admin = new AdminInfo(numberField.getText(),
					nameField.getText(), passField.getText());
				op.inputAdmin(admin);
				JOptionPane.showMessageDialog(null,
						"�޸ĳɹ�", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}
		}

	}

}
