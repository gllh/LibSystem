package com.cqjtu.lyx.Library.Reader;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月15日 下午2:37:03
 * @ClassName 类名称 没得
 * @Description 类描述 没得
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

	JLabel readerNumber = new JLabel("读者编号:");
	JLabel readerName = new JLabel("读者姓名:");
	JLabel sex = new JLabel("性别:");
	JLabel dpt = new JLabel("专业:");
	JLabel grade = new JLabel("年级:");
	JTextField numberField = new JTextField();
	JTextField nameField = new JTextField();
	JTextField sexField = new JTextField();
	JTextField dptField = new JTextField();
	JTextField gradeField = new JTextField();
	JButton cancel = new JButton("取消");
	JButton confirm = new JButton("添加");

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
						"不能为空", "Warning",
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
				if (!sexField.getText().equals("男")
						&& !sexField.getText().equals("女")		
							&& !sexField.getText().equals("gay")) {
					JOptionPane
							.showMessageDialog(
									null,
									"性别只能为‘男’或‘女’",
									"Warning", JOptionPane.INFORMATION_MESSAGE);
				} else {
					op.saveReader(reader);
					JOptionPane.showMessageDialog(null,
							"添加成功", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(null,
						"已有此人", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}
			}
		}

	}

}

