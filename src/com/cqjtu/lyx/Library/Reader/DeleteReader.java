package com.cqjtu.lyx.Library.Reader;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��15�� ����3:40:36
 * @ClassName ������ û��
 * @Description ������ û��
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import com.cqjtu.lyx.Library.Entity.ReaderInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

public class DeleteReader extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JLabel readerNumber = new JLabel("���߱��:");
	JTextField numberField = new JTextField();
	JButton cancel = new JButton("ȡ��");
	JButton delete = new JButton("ɾ��");

	public DeleteReader() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(2, 2, 20, 10));
		p1.add(readerNumber);
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
			ReaderInfo reader = new ReaderInfo(numberField.getText());
			this.dispose();
			if (op.deleteReaderCheck(numberField.getText()) != 0) {
				JOptionPane
						.showMessageDialog(
								null,
								"ɾ��ʧ�ܣ���dei������",
								"Warning", JOptionPane.INFORMATION_MESSAGE);

			} else {
				if (op.deleteReader(reader) == 1) {
					JOptionPane.showMessageDialog(null,
							"ɾ���ɹ�", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"�޴���",
									"Warning", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

}

