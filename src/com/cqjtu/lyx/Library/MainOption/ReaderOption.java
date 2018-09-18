package com.cqjtu.lyx.Library.MainOption;

/**
 * @author liyixin new p
 * @version ����ʱ�䣺2018��6��13�� ����7:43:13
 * @ClassName ������ û��
 * @Description ������ û��
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.cqjtu.lyx.Library.Entity.ReaderInfo;
import com.cqjtu.lyx.Library.Reader.AddReader;
import com.cqjtu.lyx.Library.Reader.DeleteReader;
import com.cqjtu.lyx.Library.Reader.ReaderDetails;
import com.cqjtu.lyx.Library.Reader.SelectEditReader;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

class ReaderOption extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JLabel readerNumber = new JLabel("���߱��:");
	JLabel readerName = new JLabel("��������:");
	JTextField number = new JTextField();
	JTextField name = new JTextField();
	JButton back = new JButton("����");
	JButton addReader = new JButton("��Ӷ���");
	JButton deleteReader = new JButton("ɾ������");
	JButton editReader = new JButton("�޸Ķ���");
	JButton search = new JButton("��ѯ����");
	Object[] s = { "���߱��", "��������", "�Ա�", "רҵ", "�꼶" };
	Object[][] ob = new Object[20][5];
	JTable table = new JTable(ob, s);
	JScrollPane scrollPane = new JScrollPane(table);

	public ReaderOption() {
		ReaderInfo reader = new ReaderInfo();
		op.allReader(reader);
		ob = op.allReader(reader);
		for (int i = 0; i < 5; i++) {
			DefaultTableModel readers = new DefaultTableModel(ob, s);
			for (int n = 0; n < 20; n++) {
				for (int m = 0; m < 5; m++) {
					ob[n][m] = this.ob[n][m];
				}
				table.setModel(readers);
				table.invalidate();
			}
		}
		c.add(p4, BorderLayout.NORTH);
		c.add(p1, BorderLayout.CENTER);
		c.add(p5, BorderLayout.SOUTH);
		p4.setLayout(new GridLayout(2, 4, 20, 10));
		p4.add(back);
		p4.add(addReader);
		p4.add(editReader);
		p4.add(deleteReader);
		p1.setLayout(null);
		scrollPane.setBounds(0, 0, 790, 300);
		p1.add(scrollPane);
		p5.setLayout(new GridLayout(5, 1, 0, 0));
		p5.add(readerNumber);
		p5.add(number);
		p5.add(readerName);
		p5.add(name);
		p5.add(search);

		addReader.addActionListener(this);
		search.addActionListener(this);
		back.addActionListener(this);
		deleteReader.addActionListener(this);
		editReader.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == search) {
			ArrayList<String> strArray = new ArrayList<String>();
			strArray = op.addReaderJudgement();
			String s1 = number.getText();
			String s2 = name.getText();
			int n = 0;
			int replicate = 0;
			while (n < Integer.parseInt(strArray.get(0))) {
				n++;
				if (s1.equals(strArray.get(n))) {
					replicate++;
				}
			}
			ArrayList<String> strArray1 = new ArrayList<String>();
			strArray1 = op.addReaderJudgement1();
			int n1 = 0;
			int replicate1 = 0;
			while (n1 < Integer.parseInt(strArray1.get(0))) {
				n1++;
				if (s2.equals(strArray1.get(n1))) {
					replicate1++;
				}
			}

			if (replicate == 0 && replicate1 == 0) {
				JOptionPane.showMessageDialog(null,
						"��������ȷ��������",
						"Warning", JOptionPane.INFORMATION_MESSAGE);
			} else if (replicate != 0 || replicate1 != 0) {
				if (replicate == 0 && replicate1 != 0) {
					ReaderInfo reader = new ReaderInfo(s1, s2);
					String s = op.searchReaderByName(reader);

					ReaderDetails f = new ReaderDetails(s);
					//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setTitle("�����б�");
					f.setLocation(300, 200);
					f.setSize(480, 470);
					f.setVisible(true);

				} else if (replicate != 0) {

					ReaderDetails f = new ReaderDetails(s1);
					//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					f.setTitle("�����б�");
					f.setLocation(300, 200);
					f.setSize(480, 470);
					f.setVisible(true);

				}
			}

		}
		if (e.getSource() == back) {
			this.dispose();
			MyFrame f = new MyFrame();
			//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("ͼ�����ϵͳ");
			f.setLocation(500, 200);
			f.setSize(300, 200);
			f.setVisible(true);
		}
		if (e.getSource() == addReader) {
			AddReader f = new AddReader();
			//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("��Ӷ���");
			f.setLocation(500, 200);
			f.setSize(300, 250);
			f.setVisible(true);
		}
		if (e.getSource() == deleteReader) {
			DeleteReader f = new DeleteReader();
			//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("ɾ������");
			f.setLocation(500, 200);
			f.setSize(300, 100);
			f.setVisible(true);
		}
		if (e.getSource() == editReader) {
			SelectEditReader f = new SelectEditReader();
			//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("�޸Ķ���");
			f.setLocation(500, 200);
			f.setSize(300, 100);
			f.setVisible(true);
		}
	}
}
