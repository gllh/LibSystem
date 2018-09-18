package com.cqjtu.lyx.Library.MainOption;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.cqjtu.lyx.Library.Admin.AddAdmin;
import com.cqjtu.lyx.Library.Admin.AdminDetail;
import com.cqjtu.lyx.Library.Admin.DeleteAdmin;
import com.cqjtu.lyx.Library.Admin.SelectEditAdmin;

/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��19�� ����8:48:47
 * @ClassName ������ û��
 * @Description ������ û��
 */
public class AdminOption {

}
class AO extends JFrame implements ActionListener {

	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JLabel welcome = new JLabel("����Ա����");
	JButton addAdmin = new JButton("��ӹ���Ա");
	JButton deleteAdmin = new JButton("ɾ������Ա");
	JButton editAdmin = new JButton("�޸Ĺ���Ա");
	JButton searchAdmin = new JButton("��ѯ����Ա");
	JButton back = new JButton("����");

	public AO() {
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.EAST);
		c.add(p3, BorderLayout.WEST);
		p1.setLayout(new GridLayout(6, 1, 50, 10));
		p1.add(welcome);
		p1.add(addAdmin);
		p1.add(deleteAdmin);
		p1.add(editAdmin);
		p1.add(searchAdmin);
		p1.add(back);
		addAdmin.addActionListener(this);
		deleteAdmin.addActionListener(this);
		editAdmin.addActionListener(this);
		searchAdmin.addActionListener(this);
		back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			this.dispose();
			MyFrame f = new MyFrame();
			f.setTitle("ͼ�����ϵͳ");
			f.setLocation(500, 200);
			f.setSize(300, 200);
			f.setVisible(true);
		}
		if (e.getSource() == addAdmin) {
			AddAdmin aa = new AddAdmin();
			aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aa.setTitle("��ӹ���Ա");
			aa.setLocation(500, 200);
			aa.setSize(300, 200);
			aa.setVisible(true);
		}
		if (e.getSource() == deleteAdmin) {
			DeleteAdmin da = new DeleteAdmin();
			da.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			da.setTitle("ɾ������Ա");
			da.setLocation(500, 200);
			da.setSize(300, 200);
			da.setVisible(true);
		}
		if (e.getSource() == editAdmin) {
			SelectEditAdmin f = new SelectEditAdmin();
			//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("�޸Ĺ���Ա");
			f.setLocation(500, 200);
			f.setSize(300, 100);
			f.setVisible(true);
		}
		if (e.getSource() == searchAdmin) {
			AdminDetail aa = new AdminDetail();
			aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aa.setTitle("����Ա�嵥");
			aa.setLocation(500, 200);
			aa.setSize(300, 300);
			aa.setVisible(true);
		}
	}
}