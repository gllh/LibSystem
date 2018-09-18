package com.cqjtu.lyx.Library.Reader;
/**
 * @author liyixin new p
 * @version 创建时间：2018年6月15日 下午3:40:36
 * @ClassName 类名称 没得
 * @Description 类描述 没得
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
	JLabel readerNumber = new JLabel("读者编号:");
	JTextField numberField = new JTextField();
	JButton cancel = new JButton("取消");
	JButton delete = new JButton("删除");

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
								"删除失败，兄dei还书先",
								"Warning", JOptionPane.INFORMATION_MESSAGE);

			} else {
				if (op.deleteReader(reader) == 1) {
					JOptionPane.showMessageDialog(null,
							"删除成功", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane
							.showMessageDialog(
									null,
									"无此人",
									"Warning", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

}

