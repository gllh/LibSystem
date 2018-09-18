package com.cqjtu.lyx.Library.MainOption;

/**
 * @author liyixin new p
 * @version 创建时间：2018年6月11日 下午3:38:48
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cqjtu.lyx.Library.Book.AddBook;
import com.cqjtu.lyx.Library.Book.BookDetails;
import com.cqjtu.lyx.Library.Book.BorrowBook;
import com.cqjtu.lyx.Library.Book.DeleteBook;
import com.cqjtu.lyx.Library.Book.ReturnBook;
import com.cqjtu.lyx.Library.Book.SelectEdit;
import com.cqjtu.lyx.Library.Entity.BookInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

public class BookOption extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JLabel bookNumber = new JLabel("图书编号:");
	JLabel bookName = new JLabel("图书姓名:");
	JTextField number = new JTextField();
	JTextField name = new JTextField();
	JButton back = new JButton("返回");
	JButton addBook = new JButton("添加图书");
	JButton deleteBook = new JButton("删除图书");
	JButton editBook = new JButton("修改图书");
	JButton search = new JButton("查询图书");
	JButton borrowBook = new JButton("借书");
	JButton returnBook = new JButton("归书");
	Object[] s = { "图书编号", "图书姓名", "作者", 
					"出版社", "出版时间","摘要",
					"库存量", "剩余量" };
	Object[][] ob = new Object[40][8];
	JTable table = new JTable(ob, s);
	JScrollPane scrollPane = new JScrollPane(table);

	public BookOption() {

		BookInfo book = new BookInfo();
		ob = op.allBook(book);
		for (int i = 0; i < 5; i++) {
			DefaultTableModel books = new DefaultTableModel(ob, s);
			for (int n = 0; n < 20; n++) {
				for (int m = 0; m < 8; m++) {
					ob[n][m] = this.ob[n][m];
				}
				table.setModel(books);
				table.invalidate();
			}
		}
		c.add(p4, BorderLayout.NORTH);
		c.add(p1, BorderLayout.CENTER);
		c.add(p5, BorderLayout.SOUTH);
		p4.setLayout(new GridLayout(2, 4, 20, 10));
		p4.add(back);
		p4.add(addBook);
		p4.add(editBook);
		p4.add(deleteBook);
		p4.add(borrowBook);
		p4.add(returnBook);
		p1.setLayout(null);
		scrollPane.setBounds(0, 0, 790, 300);
		p1.add(scrollPane);
		p5.setLayout(new GridLayout(5, 1, 0, 0));
		p5.add(bookNumber);
		p5.add(number);
		p5.add(bookName);
		p5.add(name);
		p5.add(search);
		table.setPreferredScrollableViewportSize(new Dimension(400, 300));

		addBook.addActionListener(this);
		search.addActionListener(this);
		back.addActionListener(this);
		deleteBook.addActionListener(this);
		editBook.addActionListener(this);
		borrowBook.addActionListener(this);
		returnBook.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
			ArrayList<String> strArray = new ArrayList<String>();
			strArray = op.addBookJudgement();
			String s1 = number.getText();
			String s2 = name.getText();
			int n = 0;
			int replicate = 0;
			while (n < Integer.parseInt(strArray.get(0))) {
				n++;
				if (s1.equals(strArray.get(n))) {
					replicate++;
				}
			}
			ArrayList<String> strArray1 = new ArrayList<String>();
			strArray1 = op.addBookJudgement1();
			int n1 = 0;
			int replicate1 = 0;
			while (n1 < Integer.parseInt(strArray1.get(0))) {
				n1++;
				if (s2.equals(strArray1.get(n1))) {
					replicate1++;
				}
			}
			if (replicate == 0 && replicate1 == 0) {
				JOptionPane.showMessageDialog(null,
						"输入错误重新输入",
						"Warning", JOptionPane.INFORMATION_MESSAGE);
			} else if (replicate != 0 || replicate1 != 0) {
				if (replicate == 0 && replicate1 != 0) {
					BookInfo book = new BookInfo(s1, s2);
					String s = op.searchBookByName(book);

					BookDetails f = new BookDetails(s);
					f.setTitle("图书信息");
					f.setLocation(300, 200);
					f.setSize(480, 470);
					f.setVisible(true);

				} else if (replicate != 0) {

					BookDetails f = new BookDetails(s1);
					f.setTitle("图书信息");
					f.setLocation(300, 200);
					f.setSize(480, 470);
					f.setVisible(true);

				}
			}

		}
		if (e.getSource() == back) {
			this.dispose();
			MyFrame f = new MyFrame();
			f.setTitle("图书管理系统");
			f.setLocation(500, 200);
			f.setSize(300, 200);
			f.setVisible(true);
		}
		if (e.getSource() == addBook) {
			AddBook f = new AddBook();
			f.setTitle("增加图书");
			f.setLocation(500, 200);
			f.setSize(300, 360);
			f.setVisible(true);
		}
		if (e.getSource() == deleteBook) {
			DeleteBook f = new DeleteBook();
			f.setTitle("删除图书");
			f.setLocation(500, 200);
			f.setSize(300, 100);
			f.setVisible(true);
		}
		if (e.getSource() == borrowBook) {
			BorrowBook f = new BorrowBook();
			f.setTitle("借书");
			f.setLocation(500, 200);
			f.setSize(300, 150);
			f.setVisible(true);
		}
		if (e.getSource() == returnBook) {
			ReturnBook f = new ReturnBook();
			f.setTitle("还书");
			f.setLocation(500, 200);
			f.setSize(300, 150);
			f.setVisible(true);
		}
		if (e.getSource() == editBook) {
			SelectEdit f = new SelectEdit();
			f.setTitle("修改图书");
			f.setLocation(500, 200);
			f.setSize(300, 100);
			f.setVisible(true);
		}
	}
}

