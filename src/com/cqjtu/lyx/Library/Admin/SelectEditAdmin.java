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

/**
 * @author liyixin new p
 * @version 创建时间：2018年6月19日 下午9:30:18
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
public class SelectEditAdmin extends JFrame implements ActionListener {
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JLabel adminName = new JLabel("管理员登录名:");
	JTextField nameField = new JTextField();
	JButton cancel = new JButton("取消");
	JButton select = new JButton("选择");

	public SelectEditAdmin() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(2, 2, 20, 10));
		p1.add(adminName);
		p1.add(nameField);
		p1.add(cancel);
		p1.add(select);

		cancel.addActionListener(this);
		select.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();
		}
		if (e.getSource() == select) {
			this.dispose();
			try {
				EditAdmin f = new EditAdmin(nameField.getText());
				//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("修改管理员");
				f.setLocation(300, 200);
				f.setSize(300, 250);
				f.setVisible(true);

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"输入登录名错误", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
				// TODO: handle exception
			}

		}
	}

}

