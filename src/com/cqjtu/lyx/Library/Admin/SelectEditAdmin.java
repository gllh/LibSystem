package com.cqjtu.lyx.Library.Admin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��19�� ����9:30:18
 * @ClassName ������ û��
 * @Description ������ û��
 */
public class SelectEditAdmin extends JFrame implements ActionListener {
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JLabel adminName = new JLabel("����Ա��¼��:");
	JTextField nameField = new JTextField();
	JButton cancel = new JButton("ȡ��");
	JButton select = new JButton("ѡ��");

	public SelectEditAdmin() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(2, 2, 20, 10));
		p1.add(adminName);
		p1.add(nameField);
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
				EditAdmin f = new EditAdmin(nameField.getText());
				//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setTitle("�޸Ĺ���Ա");
				f.setLocation(300, 200);
				f.setSize(300, 250);
				f.setVisible(true);

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"�����¼������", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
				// TODO: handle exception
			}

		}
	}

}

