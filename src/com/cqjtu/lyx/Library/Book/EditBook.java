package com.cqjtu.lyx.Library.Book;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��18�� ����7:41:03
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

public class EditBook extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();

	JLabel bookNumber = new JLabel("ͼ����:");
	JLabel bookName = new JLabel("ͼ������:");
	JLabel author = new JLabel("����:");
	JLabel press = new JLabel("������:");
	JLabel pressTime = new JLabel("����ʱ��:");
	JLabel bookAbstract = new JLabel("ժҪ:");
	JLabel storage = new JLabel("���:");
	JLabel remain = new JLabel("����:");
	JLabel numberField = new JLabel();
	JTextField nameField = new JTextField();
	JTextField authorField = new JTextField();
	JTextField pressField = new JTextField();
	JTextField pressTimeField = new JTextField();
	JTextField abstractField = new JTextField();
	JTextField storageField = new JTextField();
	JTextField remainField = new JTextField();

	JTextField temp1 = new JTextField();
	JTextField temp2 = new JTextField();

	JButton cancel = new JButton("ȡ��");
	JButton save = new JButton("�޸�");

	public EditBook(String number) {
		BookInfo book = new BookInfo(number);
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
		p1.add(cancel);
		p1.add(save);

		cancel.addActionListener(this);
		save.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancel) {
			this.dispose();

		}
		if (e.getSource() == save) {
			if(numberField.getText().equals("")||nameField.getText().equals("")
					||authorField.getText().equals("")||pressField.getText().equals("")||
					pressTimeField.getText().equals("")
					||abstractField.getText().equals("")||storageField.getText().equals("")
					||remainField.getText().equals("")){
				JOptionPane.showMessageDialog(null,
						"����Ϊ��", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
			BookInfo book = new BookInfo(numberField.getText(),
					nameField.getText(), authorField.getText(),
					pressField.getText(), pressTimeField.getText(),
					abstractField.getText(), Integer.parseInt(storageField
							.getText()), Integer.parseInt(remainField
									.getText()));
			op.inputBook(book);
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�",
					"Information", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			}
		}
	}
}

