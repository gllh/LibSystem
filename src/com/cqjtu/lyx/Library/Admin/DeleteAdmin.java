package com.cqjtu.lyx.Library.Admin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 * @version ����ʱ�䣺2018��6��19�� ����8:58:15
 * @ClassName ������ û��
 * @Description ������ û��
 */
public class DeleteAdmin extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JLabel adminName = new JLabel("����Ա����:");
	JTextField nameField = new JTextField();
	JButton cancel = new JButton("ȡ��");
	JButton delete = new JButton("ɾ��");

	public DeleteAdmin() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(2, 2, 20, 10));
		p1.add(adminName);
		p1.add(nameField);
		p1.add(cancel);
		p1.add(delete);

		cancel.addActionListener(this);
		delete.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();
		}
		if (e.getSource() == delete) {
			AdminInfo admin = new AdminInfo(nameField.getText());
			this.dispose();		
				if (op.deleteAdmin(admin) == 1) {
					JOptionPane.showMessageDialog(null,
							"ɾ���ɹ�", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"����Ա������",
									"Warning", JOptionPane.INFORMATION_MESSAGE);
				}
		}
	}

}
