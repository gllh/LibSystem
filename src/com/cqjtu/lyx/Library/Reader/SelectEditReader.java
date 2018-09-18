package com.cqjtu.lyx.Library.Reader;
/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��13�� ����10:44:00
 * @ClassName ������ û��
 * @Description ������ û��
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class SelectEditReader extends JFrame implements ActionListener {
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JLabel readerNumber = new JLabel("���߱��:");
	JTextField numberField = new JTextField();
	JButton cancel = new JButton("ȡ��");
	JButton select = new JButton("ѡ��");

	public SelectEditReader() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(2, 2, 20, 10));
		p1.add(readerNumber);
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
				EditReader f = new EditReader(numberField.getText());
				//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("�޸Ķ���");
				f.setLocation(300, 200);
				f.setSize(300, 250);
				f.setVisible(true);

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"������߱�Ŵ���", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
				// TODO: handle exception
			}

		}
	}

}

