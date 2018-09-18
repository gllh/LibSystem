package com.cqjtu.lyx.Library.MainOption;

/**
 * @author liyixin new p
 * @version 创建时间：2018年6月15日 下午4:42:14
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.management.openmbean.OpenDataException;
import javax.swing.*;

import com.cqjtu.lyx.Library.Sql.SQLOperation;

import java.awt.Font;

public class LogIn {

	public static void main(String[] args) {

		My f = new My();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("图书馆移动管理系统");
		f.setLocation(500, 200);
		f.setSize(300, 150);
		f.setVisible(true);
	}
}

class My extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JLabel userName = new JLabel("管理员用户名:");
	JLabel password = new JLabel("管理员密码:");
	JTextField nameField = new JTextField();
	JPasswordField passField = new JPasswordField();
	JButton confirm = new JButton("login");

	public My() {
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.SOUTH);
//		2行2列，水平间距1，垂直间距10
		p1.setLayout(new GridLayout(2, 2, 1, 10));
		p1.add(userName);
		p1.add(nameField);
		p1.add(password);
		p1.add(passField);
		p2.add(confirm);
		confirm.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == confirm) {
			String name = nameField.getText();
			String pass = passField.getText();
			if(name.equals("")){
				JOptionPane.showMessageDialog(null,
						"姓名不能为空",
						"Warning", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(pass.equals("")){
				JOptionPane.showMessageDialog(null,
						"密码不能为空",
						"Warning", JOptionPane.INFORMATION_MESSAGE);
			}else{
				int i = op.logCheck(name, pass);
			if (i == 1) {
				this.dispose();
				MyFrame f = new MyFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("图书管理系统");
				f.setLocation(500, 200);
				f.setSize(300, 200);
				f.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null,
						"用户名或密码错误",
						"Warning", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		// TODO Auto-generated method stub
	}

}
