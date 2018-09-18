package com.cqjtu.lyx.Library.Reader;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��11�� ����4:41:21
 * @ClassName ������ û��
 * @Description ������ û��
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import com.cqjtu.lyx.Library.Entity.ReaderInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

public class EditReader extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();

	JLabel readerNumber = new JLabel("���߱��:");
	JLabel readerName = new JLabel("��������:");
	JLabel sex = new JLabel("�Ա�:");
	JLabel dpt = new JLabel("רҵ:");
	JLabel grade = new JLabel("�꼶:");
	JLabel numberField = new JLabel();
	JTextField nameField = new JTextField();
	JTextField sexField = new JTextField();
	JTextField dptField = new JTextField();
	JTextField gradeField = new JTextField();
	JButton cancel = new JButton("ȡ��");
	JButton save = new JButton("�޸�");

	public EditReader(String number) {
		numberField.setText(number);
		ReaderInfo reader = new ReaderInfo(number);
		ArrayList<String> strArray = new ArrayList<String>();
		strArray = op.outputReader(reader);
		System.out.println(strArray);
		numberField.setText(number);
		nameField.setText(strArray.get(1));
		sexField.setText(strArray.get(2));
		dptField.setText(strArray.get(3));
		gradeField.setText(strArray.get(4));

		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(6, 2, 20, 10));
		p1.add(readerNumber);
		p1.add(numberField);
		p1.add(readerName);
		p1.add(nameField);
		p1.add(sex);
		p1.add(sexField);
		p1.add(dpt);
		p1.add(dptField);
		p1.add(grade);
		p1.add(gradeField);
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
					||sexField.getText().equals("")||sexField.getText().equals("")
					||dptField.getText().equals("")||gradeField.getText().equals("")){
				JOptionPane.showMessageDialog(null,
						"����Ϊ��", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
			ReaderInfo reader = new ReaderInfo(numberField.getText(),
					nameField.getText(), sexField.getText(),
					dptField.getText(), Integer.parseInt(gradeField.getText()));
			if (!sexField.getText().equals("��")
					&&!sexField.getText().equals("Ů")
						&&!sexField.getText().equals("gay")) {
				JOptionPane
						.showMessageDialog(
								null,
								"�Ա�ֻ�ܡ��С���Ů��",
								"Warning", JOptionPane.INFORMATION_MESSAGE);
			} else {
				op.inputReader(reader);
				JOptionPane.showMessageDialog(null,
						"�޸ĳɹ�", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				}
			}
		}

	}

}
