package com.cqjtu.lyx.Library.MainOption;

/**
 * @author liyixin new p
 * @version 创建时间：2018年6月15日 下午5:39:47
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cqjtu.lyx.Library.Sql.SQLOperation;

public class BorrowList extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JButton back=new JButton("返回");
	Object[] s = { "图书编号", "读者编号", "借阅时间", 
					"截止日期","超过时间"};
	Object[][] ob = new Object[100][5];
	JTable table = new JTable(ob, s);
	JScrollPane scrollPane = new JScrollPane(table);
	
	public BorrowList() {
		// TODO Auto-generated constructor stub
		Object[][] ob1 = op.borrowList();
		for (int i = 0; i < 5; i++) {
			DefaultTableModel list = new DefaultTableModel(ob, s);
			for (int n = 0; n < 100; n++) {
				for (int m = 0; m < 5; m++) {
					ob[n][m] = ob1[n][m];
				}
				table.setModel(list);
				table.invalidate();
			}
		}
		c.add(p1, BorderLayout.CENTER);
		c.add(p2,BorderLayout.SOUTH);
		scrollPane.setBounds(0, 0, 800, 300);
		p1.add(scrollPane);
		p2.add(back);
		table.setPreferredScrollableViewportSize(new Dimension(500, 400));
		back.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			this.dispose();
			MyFrame f = new MyFrame();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("图书管理系统");
			f.setLocation(500, 200);
			f.setSize(300, 200);
			f.setVisible(true);
		}
		// TODO Auto-generated method stub
		
	}

}



