package com.cqjtu.lyx.Library.MainOption;

/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��15�� ����4:42:14
 * @ClassName ������ û��
 * @Description ������ û��
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
		f.setTitle("ͼ����ƶ�����ϵͳ");
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
	JLabel userName = new JLabel("����Ա�û���:");
	JLabel password = new JLabel("����Ա����:");
	JTextField nameField = new JTextField();
	JPasswordField passField = new JPasswordField();
	JButton confirm = new JButton("login");

	public My() {
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.SOUTH);
//		2��2�У�ˮƽ���1����ֱ���10
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
						"��������Ϊ��",
						"Warning", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(pass.equals("")){
				JOptionPane.showMessageDialog(null,
						"���벻��Ϊ��",
						"Warning", JOptionPane.INFORMATION_MESSAGE);
			}else{
				int i = op.logCheck(name, pass);
			if (i == 1) {
				this.dispose();
				MyFrame f = new MyFrame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("ͼ�����ϵͳ");
				f.setLocation(500, 200);
				f.setSize(300, 200);
				f.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null,
						"�û������������",
						"Warning", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
		// TODO Auto-generated method stub
	}

}
