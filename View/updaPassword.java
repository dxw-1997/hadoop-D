package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.adminDao;
import Dao.userDao;
import Moder.admin;
import Moder.user;
import Moder.userType;
import Util.Toolclass;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class updaPassword extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldtextField;
	private JTextField passtextField;
	private JTextField pass2textField;
	private JLabel countlblNewLabel;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public updaPassword() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("\u539F \u5BC6 \u7801\uFF1A");
		label.setIcon(new ImageIcon(updaPassword.class.getResource("/photo/\u5BC6\u7801 (1).png")));
		label.setFont(new Font("楷体", Font.BOLD, 16));
		
		oldtextField = new JTextField();
		oldtextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4FEE\u6539\u5BC6\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(updaPassword.class.getResource("/photo/xiugaimima.png")));
		label_1.setFont(new Font("楷体", Font.BOLD, 16));
		
		passtextField = new JTextField();
		passtextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(updaPassword.class.getResource("/photo/banjiguanli.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 16));
		
		pass2textField = new JTextField();
		pass2textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(updaPassword.class.getResource("/photo/banji.png")));
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 16));
		
		countlblNewLabel = new JLabel("New label");
		countlblNewLabel.setEnabled(false);
		countlblNewLabel.setFont(new Font("楷体", Font.BOLD, 16));
		
		JButton setbtnNewButton = new JButton("\u786E\u8BA4");
		setbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firm(e);
			}
		});
		setbtnNewButton.setIcon(new ImageIcon(updaPassword.class.getResource("/photo/icon-test (2).png")));
		setbtnNewButton.setFont(new Font("楷体", Font.BOLD, 16));
		
		JButton resetbtnNewButton = new JButton("\u91CD\u7F6E");
		resetbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}
		});
		resetbtnNewButton.setIcon(new ImageIcon(updaPassword.class.getResource("/photo/\u91CD\u7F6E.png")));
		resetbtnNewButton.setFont(new Font("楷体", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(countlblNewLabel))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(setbtnNewButton)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(resetbtnNewButton))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(pass2textField))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(label_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(passtextField))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(label)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(oldtextField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(countlblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(oldtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(pass2textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(setbtnNewButton)
						.addComponent(resetbtnNewButton))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			countlblNewLabel.setText("【"+mian.usertype.getName()+admins.getName()+"】");
		}
		if("学生".equals(mian.usertype.getName())) {
			user us = (user) mian.userobject;
			countlblNewLabel.setText("【"+mian.usertype.getName()+us.getName()+"】");
		}
		
		
	}
	
	protected void firm(ActionEvent e) {
		// TODO Auto-generated method stub
		String old = oldtextField.getText();
		String pass = passtextField.getText();
		String pass2 = pass2textField.getText();
		if(Toolclass.isEmpty(old)) {
			JOptionPane.showMessageDialog(this, "请输入旧密码");
			return;
		}
		if(Toolclass.isEmpty(pass)) {
			JOptionPane.showMessageDialog(this, "请输入新密码");
			return;
		}
		if(Toolclass.isEmpty(pass2)) {
			JOptionPane.showMessageDialog(this, "请在次输入密码");
			return;
		}
		if(!pass.equals(pass2)) {
			JOptionPane.showMessageDialog(this, "您两次输入的密码不一致");
			return;
		}
		if("管理员".equals(mian.usertype.getName())) {
			admin admintmp = new admin();
			adminDao adminDao = new adminDao();
			admintmp.setPassword(old);
			String updapass = adminDao.updapass(admintmp, pass2);
			JOptionPane.showMessageDialog(this, updapass);
			return;
		}
		if("学生".equals(mian.usertype.getName())) {
			user usertmp = new user();
			userDao dao = new userDao();
			usertmp.setPassword(old);
			String updapass = dao.updapass(usertmp, pass2);
			JOptionPane.showMessageDialog(this, updapass);
			return;
		}
		
		
	}

	protected void reset(ActionEvent e) {
		// TODO Auto-generated method stub
		oldtextField.setText("");
		passtextField.setText("");
		pass2textField.setText("");
	}
}
