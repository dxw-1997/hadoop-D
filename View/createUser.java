package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.hdfsDAO;
import Dao.userDao;
import Util.Toolclass;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class createUser extends JFrame {
	private JTextField newNametextField;
	private JTextField newPasstextField;
	private JTextField conFirmtextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					createUser frame = new createUser();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public createUser() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setBackground(SystemColor.activeCaption);
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("新建用户：");
		lblNewLabel.setIcon(new ImageIcon(createUser.class.getResource("/Photo/tianjia (1).png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 15));
		
		newNametextField = new JTextField();
		newNametextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("新建密码：");
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_1.setIcon(new ImageIcon(createUser.class.getResource("/Photo/tianjia.png")));
		
		newPasstextField = new JTextField();
		newPasstextField.setColumns(10);
//		setClosable(true);
//		setIconifiable(true);
		JLabel lblNewLabel_2 = new JLabel("确认密码：");
		lblNewLabel_2.setIcon(new ImageIcon(createUser.class.getResource("/Photo/密码 (1).png")));
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 15));
		
		conFirmtextField = new JTextField();
		conFirmtextField.setColumns(10);
		
		JButton conFirmbtnNewButton = new JButton("确认");
		conFirmbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conFirm(e);
			}
		});
		conFirmbtnNewButton.setIcon(new ImageIcon(createUser.class.getResource("/Photo/登录 (1).png")));
		conFirmbtnNewButton.setFont(new Font("楷体", Font.BOLD, 18));
		
		JButton reSetbtnNewButton = new JButton("重置");
		reSetbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(e);
			}
		});
		reSetbtnNewButton.setIcon(new ImageIcon(createUser.class.getResource("/Photo/refresh01.png")));
		reSetbtnNewButton.setFont(new Font("楷体", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(conFirmbtnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(reSetbtnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(conFirmtextField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(newPasstextField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(newNametextField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(90, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(newNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(newPasstextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(conFirmtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(conFirmbtnNewButton)
						.addComponent(reSetbtnNewButton))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setLocationRelativeTo(null);

	}

	protected void conFirm(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = newNametextField.getText().toString();
		String password = newPasstextField.getText().toString();
		String password2 = conFirmtextField.getText().toString();
		if(Toolclass.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空");
			return;
		}
		if(Toolclass.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
		if(Toolclass.isEmpty(password2)) {
			JOptionPane.showMessageDialog(this, "请在次输入密码");
			return;
		}
		if(!password.equals(password2)) {
			JOptionPane.showMessageDialog(this, "您两次输入的密码不一致");
			return;
		}
		userDao dao = new userDao();
		String string = dao.creaUser(name, password);
		hdfsDAO hdfsDAO = new hdfsDAO();
		hdfsDAO.createDir("/admin/"+name);
		JOptionPane.showMessageDialog(this, string);
		return;
	}

	protected void reset(ActionEvent e) {
		// TODO Auto-generated method stub
		newNametextField.setText("");
		newPasstextField.setText("");
		conFirmtextField.setText("");
	}

}
