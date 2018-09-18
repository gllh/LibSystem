package com.cqjtu.lyx.Library.Book;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月16日 下午5:43:31
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.management.openmbean.OpenDataException;
import javax.swing.*;

import com.cqjtu.lyx.Library.Entity.BookInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

public class ReturnBook extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JLabel bookNumber = new JLabel("图书编号:");
	JTextField numberField = new JTextField();
	JLabel readerNumber = new JLabel("读者编号:");
	JTextField readerNumberField = new JTextField();
	JButton cancel = new JButton("取消");
	JButton returnBook = new JButton("归还");

	public ReturnBook() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(3, 2, 20, 10));
		p1.add(bookNumber);
		p1.add(numberField);
		p1.add(readerNumber);
		p1.add(readerNumberField);
		p1.add(cancel);
		p1.add(returnBook);

		cancel.addActionListener(this);
		returnBook.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();
		}
		if (e.getSource() == returnBook) {
			String bookNumber = numberField.getText();
			ArrayList<String> strArray = new ArrayList<String>();
			strArray = op.addBookJudgement();
			int n = 0;
			int replicate = 0;
			while (n < Integer.parseInt(strArray.get(0))) {
				n++;
				if (bookNumber.equals(strArray.get(n))) {
					replicate++;
				}
			}

			String readerNumber = readerNumberField.getText();
			ArrayList<String> strArray1 = new ArrayList<String>();
			strArray1 = op.addReaderJudgement();
			int n1 = 0;
			int replicate1 = 0;
			while (n1 < Integer.parseInt(strArray1.get(0))) {
				n1++;
				if (readerNumber.equals(strArray1.get(n1))) {
					replicate1++;
				}
			}

			if (replicate == 0 || replicate1 == 0) {
				JOptionPane
						.showMessageDialog(
								null,
								"请输入正确图书编号和借阅读者编号",
								"Warning", JOptionPane.INFORMATION_MESSAGE);

			} else {
				if (op.returnCheck(numberField.getText(),
						readerNumberField.getText()) == 1) {
					JOptionPane.showMessageDialog(null, "无结果",
							"Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					BookInfo book = new BookInfo(bookNumber);
					ArrayList<String> s = new ArrayList<String>();
					s = op.outputBook(book);
					BookInfo book1 = new BookInfo(s.get(0), s.get(1),
							s.get(2), s.get(3), s.get(4), s.get(5),
							Integer.parseInt(s.get(6)),
							Integer.parseInt(s.get(7)) + 1);
					op.inputBook(book1);
					if(op.deleteResult(numberField.getText(), readerNumberField.getText())==1){
						JOptionPane.showMessageDialog(null, "还书成功",
								"Successful", JOptionPane.INFORMATION_MESSAGE);
						this.dispose();
						
					}else{
						JOptionPane.showMessageDialog(null, "还书失败",
								"Unsuccessful", JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}

		}
	}

}
