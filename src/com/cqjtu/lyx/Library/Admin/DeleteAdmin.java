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
 * @version 创建时间：2018年6月19日 下午8:58:15
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
public class DeleteAdmin extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JLabel adminName = new JLabel("管理员姓名:");
	JTextField nameField = new JTextField();
	JButton cancel = new JButton("取消");
	JButton delete = new JButton("删除");

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
							"删除成功", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"管理员不存在",
									"Warning", JOptionPane.INFORMATION_MESSAGE);
				}
		}
	}

}
