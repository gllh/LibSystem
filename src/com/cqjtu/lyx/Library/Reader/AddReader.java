package com.cqjtu.lyx.Library.Reader;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��15�� ����2:37:03
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

public class AddReader extends JFrame implements ActionListener {

	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();

	JLabel readerNumber = new JLabel("���߱��:");
	JLabel readerName = new JLabel("��������:");
	JLabel sex = new JLabel("�Ա�:");
	JLabel dpt = new JLabel("רҵ:");
	JLabel grade = new JLabel("�꼶:");
	JTextField numberField = new JTextField();
	JTextField nameField = new JTextField();
	JTextField sexField = new JTextField();
	JTextField dptField = new JTextField();
	JTextField gradeField = new JTextField();
	JButton cancel = new JButton("ȡ��");
	JButton confirm = new JButton("���");

	public AddReader() {
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
			if(numberField.getText().equals("")||
					nameField.getText().equals("")||
					sexField.getText().equals("")||
					dptField.getText().equals("")||
					gradeField.getText().equals("")){
				JOptionPane.showMessageDialog(null,
						"����Ϊ��", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
			this.dispose();
			ReaderInfo reader = new ReaderInfo(numberField.getText(),
					nameField.getText(), sexField.getText(),
					dptField.getText(), Integer.parseInt(gradeField.getText()));
			ArrayList<String> strArray = new ArrayList<String>();
			strArray = op.addReaderJudgement();
			int n = 0;
			int replicate = 0;
			while (n < Integer.parseInt(strArray.get(0))) {
				n++;
				if (numberField.getText().equals(strArray.get(n))) {
					replicate++;
				}
			}
			if (replicate == 0) {
				if (!sexField.getText().equals("��")
						&& !sexField.getText().equals("Ů")		
							&& !sexField.getText().equals("gay")) {
					JOptionPane
							.showMessageDialog(
									null,
									"�Ա�ֻ��Ϊ���С���Ů��",
									"Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					op.saveReader(reader);
					JOptionPane.showMessageDialog(null,
							"��ӳɹ�", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null,
						"���д���", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}
			}
		}

	}

}

