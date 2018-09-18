package com.cqjtu.lyx.Library.MainOption;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月14日 下午9:41:44
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import java.awt.Font;

public class HomePage {
}

class MyFrame extends JFrame implements ActionListener {

	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JLabel welcome = new JLabel("Bonjour World！！！！！！！！！！！！");
	JButton book = new JButton("图书操作");
	JButton reader = new JButton("读者操作");
	JButton list = new JButton("借阅情况");
	JButton admin = new JButton("管理员操作");

	public MyFrame() {
		c.add(p1, BorderLayout.CENTER);
		c.add(p2, BorderLayout.EAST);
		c.add(p3, BorderLayout.WEST);
		p1.setLayout(new GridLayout(5, 1, 50, 10));
		p1.add(welcome);
		p1.add(book);
		p1.add(reader);
		p1.add(list);
		p1.add(admin);
		list.addActionListener(this);
		book.addActionListener(this);
		reader.addActionListener(this);
		admin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == book) {
			this.dispose();
			BookOption page1 = new BookOption();
			page1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			page1.setTitle("图书操作");
			page1.setLocation(300, 50);
			page1.setSize(800, 600);
			page1.setVisible(true);
		}
		if (e.getSource() == reader) {
			this.dispose();
			ReaderOption page2 = new ReaderOption();
			page2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			page2.setTitle("读者操作");
			page2.setLocation(300, 50);
			page2.setSize(800, 600);
			page2.setVisible(true);
		}
		if (e.getSource() == list) {
			this.dispose();
			BorrowList page2 = new BorrowList();
			page2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			page2.setTitle("借阅情况");
			page2.setLocation(400, 100);
			page2.setSize(600, 400);
			page2.setVisible(true);
		}
		if (e.getSource() == admin) {
			this.dispose();
			AO aa = new AO();
			aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			aa.setTitle("管理员操作");
			aa.setLocation(500, 100);
			aa.setSize(300, 250);
			aa.setVisible(true);
		}
	}
}

