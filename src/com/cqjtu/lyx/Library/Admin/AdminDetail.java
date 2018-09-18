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
 * @version ����ʱ�䣺2018��6��19�� ����10:02:07
 * @ClassName ������ AdminDetail
 * @Description ������ ��ѯ����Ա��Ϣ
 */
public class AdminDetail extends JFrame implements ActionListener {

	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();

	JLabel adminNumber = new JLabel("����Ա���:");
	JLabel adminName = new JLabel("��¼��:");
	JLabel adminPass = new JLabel("����:");
	JLabel numberField = new JLabel();
	JLabel nameField = new JLabel();
	JLabel passField = new JLabel();
	JButton cancel = new JButton("����");
	JLabel details = new JLabel("����Ա�嵥");
	Object[] s = { "����Ա���", "��¼��", 
					"����" };
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
