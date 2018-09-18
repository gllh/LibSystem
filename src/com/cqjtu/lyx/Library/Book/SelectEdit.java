package com.cqjtu.lyx.Library.Book;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月13日 下午6:43:46
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

public class SelectEdit extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	BookInfo book = new BookInfo();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JLabel bookNumber = new JLabel("图书编号:");
	JTextField numberField = new JTextField();
	JButton cancel = new JButton("取消");
	JButton select = new JButton("修改");

	public SelectEdit() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(2, 2, 20, 10));
		p1.add(bookNumber);
		p1.add(numberField);
		p1.add(cancel);
		p1.add(select);

		cancel.addActionListener(this);
		select.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();
		}
		if (e.getSource() == select) {

			this.dispose();
			try {
				EditBook f = new EditBook(numberField.getText());
				//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("修改图书");
				f.setLocation(300, 200);
				f.setSize(300, 360);
				f.setVisible(true);

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "输图书编号错误",
						"Warning", JOptionPane.INFORMATION_MESSAGE);
				// TODO: handle exception
			}

		}
	}

}

