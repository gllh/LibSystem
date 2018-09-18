package com.cqjtu.lyx.Library.Book;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��11�� ����7:35:45
 * @ClassName ������ û��
 * @Description ������ û��
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.cqjtu.lyx.Library.Entity.BookInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

public class AddBook extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();

	JLabel bookNumber = new JLabel("ͼ����:");
	JLabel bookName = new JLabel("ͼ������:");
	JLabel bookAuthor = new JLabel("����:");
	JLabel press = new JLabel("������:");
	JLabel pressTime = new JLabel("����ʱ��:");
	JLabel bookAbstract = new JLabel("ժҪ:");
	JLabel storage = new JLabel("�����:");
	JLabel remain = new JLabel("����");
	JTextField numberField = new JTextField();
	JTextField nameField = new JTextField();
	JTextField authorField = new JTextField();
	JTextField pressField = new JTextField();
	JTextField pressTimeField = new JTextField();
	JTextField abstractField = new JTextField();
	JTextField storageField = new JTextField();
	JTextField remainField = new JTextField();
	JButton cancel = new JButton("ȡ��");
	JButton confirm = new JButton("���");

	public AddBook() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(9, 2, 20, 10));
		p1.add(bookNumber);
		p1.add(numberField);
		p1.add(bookName);
		p1.add(nameField);
		p1.add(bookAuthor);
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
		p1.add(cancel);
		p1.add(confirm);

		cancel.addActionListener(this);
		confirm.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();
		}
		if (e.getSource() == confirm) {
			if(numberField.getText().equals("")||nameField.getText().equals("")
				||authorField.getText().equals("")||pressField.getText().equals("")
				||pressTimeField.getText().equals("")||abstractField.getText().equals("")
				||storageField.getText().equals("")||remainField.getText().equals("")){
				JOptionPane.showMessageDialog(null,
						"����Ϊ��", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				
			this.dispose();
			BookInfo book = new BookInfo(numberField.getText(),
					nameField.getText(), authorField.getText(),
					pressField.getText(), pressTimeField.getText(),
					abstractField.getText(), Integer.parseInt(storageField
							.getText()),
					Integer.parseInt(remainField.getText()));
			ArrayList<String> strArray = new ArrayList<String>();
			strArray = op.addBookJudgement();
			int n = 0;
			int replicate = 0;
			while (n < Integer.parseInt(strArray.get(0))) {
				n++;
				if (numberField.getText().equals(strArray.get(n))) {
					replicate++;
				}
			}
			if (replicate == 0) {
				op.saveBook(book);
				JOptionPane.showMessageDialog(null, "��ӳɹ�",
						"Information", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"����ͼ�飡������", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}
			}

		}
	}

}

