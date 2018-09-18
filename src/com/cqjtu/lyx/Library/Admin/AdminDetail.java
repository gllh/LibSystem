package com.cqjtu.lyx.Library.Admin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.cqjtu.lyx.Library.Entity.AdminInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

/**
 * @author liyixin new p
 * @version 创建时间：2018年6月19日 下午10:02:07
 * @ClassName 类名称 AdminDetail
 * @Description 类描述 查询管理员信息
 */
public class AdminDetail extends JFrame implements ActionListener {

	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();

	JLabel adminNumber = new JLabel("管理员编号:");
	JLabel adminName = new JLabel("登录名:");
	JLabel adminPass = new JLabel("密码:");
	JLabel numberField = new JLabel();
	JLabel nameField = new JLabel();
	JLabel passField = new JLabel();
	JButton cancel = new JButton("返回");
	JLabel details = new JLabel("管理员清单");
	Object[] s = { "管理员编号", "登录名", 
					"密码" };
	Object[][] ob1 = new Object[40][3];
	JTable table = new JTable(ob1, s);
	JScrollPane scrollPane = new JScrollPane(table);

	public AdminDetail() {
		AdminInfo admin = new AdminInfo();

		ob1 = op.allAdmin(admin);
		for (int i = 0; i < 5; i++) {
			DefaultTableModel admins = new DefaultTableModel(ob1, s);
			for (int n = 0; n < 20; n++) {
				for (int m = 0; m < 3; m++) {
					ob1[n][m] = this.ob1[n][m];
				}
				table.setModel(admins);
				table.invalidate();
			}
		}
		c.add(p1, BorderLayout.NORTH);
		c.add(p2, BorderLayout.CENTER);
		c.add(p3, BorderLayout.SOUTH);
		p1.setLayout(new GridLayout(1, 2, 20, 10));
		scrollPane.setBounds(0, 0, 790, 300);
		p1.add(scrollPane);
		p3.add(cancel);
		table.setPreferredScrollableViewportSize(new Dimension(400, 200));
		cancel.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();
		}

	}

}
