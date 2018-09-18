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
 * @version 创建时间：2018年6月19日 下午8:48:47
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
public class AdminOption {

}
class AO extends JFrame implements ActionListener {

	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JLabel welcome = new JLabel("管理员操作");
	JButton addAdmin = new JButton("添加管理员");
	JButton deleteAdmin = new JButton("删除管理员");
	JButton editAdmin = new JButton("修改管理员");
	JButton searchAdmin = new JButton("查询管理员");
	JButton back = new JButton("返回");

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
			f.setTitle("图书管理系统");
			f.setLocation(500, 200);
			f.setSize(300, 200);
			f.setVisible(true);
		}
		if (e.getSource() == addAdmin) {
			AddAdmin aa = new AddAdmin();
			aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aa.setTitle("添加管理员");
			aa.setLocation(500, 200);
			aa.setSize(300, 200);
			aa.setVisible(true);
		}
		if (e.getSource() == deleteAdmin) {
			DeleteAdmin da = new DeleteAdmin();
			da.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			da.setTitle("删除管理员");
			da.setLocation(500, 200);
			da.setSize(300, 200);
			da.setVisible(true);
		}
		if (e.getSource() == editAdmin) {
			SelectEditAdmin f = new SelectEditAdmin();
			//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("修改管理员");
			f.setLocation(500, 200);
			f.setSize(300, 100);
			f.setVisible(true);
		}
		if (e.getSource() == searchAdmin) {
			AdminDetail aa = new AdminDetail();
			aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aa.setTitle("管理员清单");
			aa.setLocation(500, 200);
			aa.setSize(300, 300);
			aa.setVisible(true);
		}
	}
}