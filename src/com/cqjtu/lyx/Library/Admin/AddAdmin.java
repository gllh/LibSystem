package com.cqjtu.lyx.Library.Admin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.cqjtu.lyx.Library.Entity.AdminInfo;
import com.cqjtu.lyx.Library.Sql.SQLOperation;

/**
 * @author liyixin new p
 * @version 创建时间：2018年6月14日 下午10:31:12
 * @ClassName 类名称 没得
 * @Description 类描述 没得
 */
public class AddAdmin extends JFrame implements ActionListener {
	SQLOperation op = new SQLOperation();
	Container c = getContentPane();
	JPanel p1 = new JPanel();

	JLabel adminnumber = new JLabel("管理员编号:");
	JLabel adminname = new JLabel("管理员姓名:");
	JLabel adminpass = new JLabel("管理员密码:");
	JTextField numberField = new JTextField();
	JTextField nameField = new JTextField();
	JTextField passField = new JTextField();
	JButton back = new JButton("返回");
	JButton confirm = new JButton("添加");

	public AddAdmin() {
		c.add(p1, BorderLayout.NORTH);
		p1.setLayout(new GridLayout(7, 1, 1, 10));
		p1.add(adminnumber);
		p1.add(numberField);
		p1.add(adminname);
		p1.add(nameField);
		p1.add(adminpass);
		p1.add(passField);
		p1.add(back);
		p1.add(confirm);

		back.addActionListener(this);
		confirm.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			this.dispose();
		}
		if (e.getSource() == confirm) {
			if(nameField.getText().equals("")||passField.getText().equals("")){
				JOptionPane.showMessageDialog(null,
						"不能为空", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				
			AdminInfo ai = new AdminInfo(numberField.getText(),nameField.getText(),passField.getText());
			ArrayList<String> strArray = new ArrayList<String>();
			strArray = op.addAdminJudgement();
			int n = 0;
			int replicate = 0;
			while (n < Integer.parseInt(strArray.get(0))) {
				n++;
				if (nameField.getText().equals(strArray.get(n))) {
					replicate++;
				}
			}
			if (replicate == 0) {
				op.saveAdmin(ai);
				JOptionPane.showMessageDialog(null, "添加成功",
						"Information", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"已存在此管理员！！！！", "Warning",
						JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}	
	}
}
