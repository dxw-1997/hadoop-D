package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.adminDao;
import Dao.userDao;
import Moder.admin;
import Moder.user;
import Moder.userType;
import Util.Toolclass;

import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JComboBox usertypeComboBox;
	private JTextField passwordtextField;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setType(Type.POPUP);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setFont(new Font("楷体", Font.PLAIN, 15));
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 433);
		contentPane = new JPanel();
		contentPane.setToolTipText("\u5B66\u751F\r\n\u8001\u5E08\r\n\u7BA1\u7406\u5458");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("我的Hadoop");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/Photo/bazhaoyu.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 20));
		
		JLabel label = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		label.setFont(new Font("楷体", Font.BOLD, 15));
		label.setIcon(new ImageIcon(login.class.getResource("/Photo/banji.png")));
		
		JLabel label_1 = new JLabel(" 密  码 ：");
		label_1.setIcon(new ImageIcon(login.class.getResource("/Photo/xiugaimima.png")));
		label_1.setFont(new Font("楷体", Font.BOLD, 15));
		
		usernameTextField = new JTextField();
		usernameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		usernameTextField.setColumns(10);
		
		JButton loginNewButton = new JButton("\u767B\u5F55");
		loginNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(e);
			}
		});
		loginNewButton.setIcon(new ImageIcon(login.class.getResource("/Photo/tuichu.png")));
		loginNewButton.setFont(new Font("楷体", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u7C7B\u522B\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/Photo/banjichengyuan.png")));
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
		
		usertypeComboBox = new JComboBox();
		usertypeComboBox.setFont(new Font("楷体", Font.BOLD, 15));
		usertypeComboBox.setModel(new DefaultComboBoxModel(new userType[] {userType.Manger,userType.Student}));
		
		passwordtextField = new JTextField();
		passwordtextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		passwordtextField.setColumns(10);
		
		JButton creatUserbtnNewButton = new JButton("注册");
		creatUserbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createUser(e);
			}
		});
		creatUserbtnNewButton.setIcon(new ImageIcon(login.class.getResource("/Photo/tianjia (1).png")));
		creatUserbtnNewButton.setFont(new Font("楷体", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(195, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(185))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(125)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(loginNewButton)
						.addComponent(lblNewLabel_1)
						.addComponent(label_1)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordtextField, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
						.addComponent(usernameTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
						.addComponent(usertypeComboBox, Alignment.TRAILING, 0, 175, Short.MAX_VALUE)
						.addComponent(creatUserbtnNewButton, Alignment.TRAILING))
					.addGap(126))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(usertypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginNewButton)
						.addComponent(creatUserbtnNewButton))
					.addGap(59))
		);
		
		contentPane.setLayout(gl_contentPane);
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	protected void createUser(ActionEvent e) {
		// TODO Auto-generated method stub
		new createUser().setVisible(true);
	}

	protected void login(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = usernameTextField.getText().toString();
		String password = passwordtextField.getText().toString();
		userType item = (userType) usertypeComboBox.getSelectedItem();
		if (Toolclass.isEmpty(username)) {
		JOptionPane.showMessageDialog(this,"用户名不能为空");
		return;
		}
		if(Toolclass.isEmpty(password)) {
		JOptionPane.showMessageDialog(this,"密码不能为空");
		return;
		}
		admin admins = null;
		if("管理员".equals(item.getName())) {
			admin admintmp = new admin();
			adminDao admindao = new adminDao();
			admintmp.setName(username);
			admintmp.setPassword(password);
			admins = admindao.login(admintmp);
			if(admins == null) {
				JOptionPane.showMessageDialog(this,"你的用户名或者密码错误");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "欢迎【"+item.getName()+admins.getName()+"】登录");
				this.dispose();
				new mian(item, admins).setVisible(true);;
			}
		}
		else if("学生".equals(item.getName())) {
			user usertmp = new user();
			usertmp.setName(username);
			usertmp.setPassword(password);
			userDao dao = new userDao();
			user user = dao.login(usertmp);
			if(user == null) {
				JOptionPane.showMessageDialog(this,"你的用户名或者密码错误");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "欢迎【"+item.getName()+user.getName()+"】登录");
				this.dispose();
				new mian(item, user).setVisible(true);;
			}
			
		}
}
}