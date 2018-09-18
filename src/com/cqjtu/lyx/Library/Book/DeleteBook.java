package com.cqjtu.lyx.Library.Book;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月17日 下午8:40:14
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import com.cqjtu.lyx.Library.Entity.BookInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

public class DeleteBook extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JLabel bookNumber = new JLabel("图书编号:");
	JTextField numberField = new JTextField();
	JButton cancel = new JButton("取消");
	JButton delete = new JButton("删除");

	public DeleteBook() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(2, 2, 20, 10));
		p1.add(bookNumber);
		p1.add(numberField);
		p1.add(cancel);
		p1.add(delete);

		cancel.addActionListener(this);
		delete.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();
		}
		if (e.getSource() == delete) {
			BookInfo book = new BookInfo(numberField.getText());
			this.dispose();
			if (op.deleteBookCheck(numberField.getText()) != 0) {
				JOptionPane
						.showMessageDialog(
								null,
								"删除失败，已借出",
								"Warning", JOptionPane.INFORMATION_MESSAGE);

			} else {
				if (op.deleteBook(book) == 1) {
					JOptionPane.showMessageDialog(null,
							"删除成功", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"图书不存在",
									"Warning", JOptionPane.INFORMATION_MESSAGE);
				}

			}

		}
	}

}
