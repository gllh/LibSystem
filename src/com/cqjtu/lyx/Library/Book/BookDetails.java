package com.cqjtu.lyx.Library.Book;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��16�� ����8:37:50
 * @ClassName ������ û��
 * @Description ������ û��
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cqjtu.lyx.Library.Entity.BookInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

public class BookDetails extends JFrame implements ActionListener {

	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();

	JLabel bookNumber = new JLabel("ͼ����:");
	JLabel bookName = new JLabel("ͼ������:");
	JLabel author = new JLabel("����:");
	JLabel press = new JLabel("������:");
	JLabel pressTime = new JLabel("����ʱ��:");
	JLabel bookAbstract = new JLabel("ժҪ:");
	JLabel storage = new JLabel("���:");
	JLabel remain = new JLabel("����:");
	JLabel numberField = new JLabel();
	JLabel nameField = new JLabel();
	JLabel authorField = new JLabel();
	JLabel pressField = new JLabel();
	JLabel pressTimeField = new JLabel();
	JLabel abstractField = new JLabel();
	JLabel storageField = new JLabel();
	JLabel remainField = new JLabel();
	JButton cancel = new JButton("ȡ��");
	JLabel details = new JLabel("�����嵥");
	Object[] s = { "���߱��", "����ʱ��", "��ֹʱ��", "����ʱ��" };
	Object[][] ob1 = new Object[7][4];
	JTable table = new JTable(ob1, s);
	JScrollPane scrollPane = new JScrollPane(table);

	public BookDetails(String number) {

		BookInfo book = new BookInfo(number);
		ob1 = op.borrowListForBook(number);
		for (int i = 0; i < 5; i++) {
			DefaultTableModel books = new DefaultTableModel(ob1, s);
			for (int n = 0; n < 7; n++) {
				for (int m = 0; m < 4; m++) {
					ob1[n][m] = this.ob1[n][m];
				}
				table.setModel(books);
				table.invalidate();
			}
		}
		ArrayList<String> strArray = new ArrayList<String>();
		strArray = op.outputBook(book);
		numberField.setText(number);
		nameField.setText(strArray.get(1));
		authorField.setText(strArray.get(2));
		pressField.setText(strArray.get(3));
		pressTimeField.setText(strArray.get(4));
		abstractField.setText(strArray.get(5));
		storageField.setText(strArray.get(6));
		remainField.setText(strArray.get(7));
		c.add(p1, BorderLayout.NORTH);
		c.add(p2, BorderLayout.CENTER);
		c.add(p3, BorderLayout.SOUTH);
		p1.setLayout(new GridLayout(9, 2, 20, 10));
		p1.add(bookNumber);
		p1.add(numberField);
		p1.add(bookName);
		p1.add(nameField);
		p1.add(author);
		p1.add(authorField);
		p1.add(press);
		p1.add(pressField);
		p1.add(pressTime);
		p1.add(pressTimeField);
		p1.add(bookAbstract);
		p1.add(abstractField);
		p1.add(storage);
		p1.add(storageField);
		p1.add(remain);
		p1.add(remainField);
		p1.add(details);
		scrollPane.setBounds(0, 0, 800, 300);
		p2.add(scrollPane);
		p3.add(cancel);
		table.setPreferredScrollableViewportSize(new Dimension(400, 100));
		cancel.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();
		}
	}

}

