package com.cqjtu.lyx.Library.Book;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��17�� ����8:40:14
 * @ClassName ������ û��
 * @Description ������ û��
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
	JLabel bookNumber = new JLabel("ͼ����:");
	JTextField numberField = new JTextField();
	JButton cancel = new JButton("ȡ��");
	JButton delete = new JButton("ɾ��");

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
								"ɾ��ʧ�ܣ��ѽ��",
								"Warning", JOptionPane.INFORMATION_MESSAGE);

			} else {
				if (op.deleteBook(book) == 1) {
					JOptionPane.showMessageDialog(null,
							"ɾ���ɹ�", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"ͼ�鲻����",
									"Warning", JOptionPane.INFORMATION_MESSAGE);
				}

			}

		}
	}

}
