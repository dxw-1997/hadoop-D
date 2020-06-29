package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.hdfsDAO;
import Dao.userDao;
import Moder.user;
import Util.Toolclass;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class userMange extends JInternalFrame {
	private JTextField nametextField;
	private JTextArea infotextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userMange frame = new userMange();
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
	public userMange() {
		setBackground(SystemColor.activeCaption);
		setTitle("用户管理");
		setBounds(100, 100, 480, 322);
		setClosable(true);
		setIconifiable(true);
		JLabel lblNewLabel = new JLabel("用户管理");
		lblNewLabel.setIcon(new ImageIcon(userMange.class.getResource("/Photo/yonghuguanli.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("查看用户：");
		lblNewLabel_1.setIcon(new ImageIcon(userMange.class.getResource("/Photo/chakan.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		nametextField = new JTextField();
		nametextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		nametextField.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(userMange.class.getResource("/Photo/查询.png")));
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("用户信息：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_2.setIcon(new ImageIcon(userMange.class.getResource("/Photo/banji.png")));
		
		infotextArea = new JTextArea();
		infotextArea.setFont(new Font("楷体", Font.PLAIN, 15));
		infotextArea.setBackground(SystemColor.activeCaption);
		
		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(e);
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 15));
		btnNewButton_1.setIcon(new ImageIcon(userMange.class.getResource("/Photo/icon--shanchu.png")));
		
		JButton btnNewButton_2 = new JButton("新增");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adduser(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(userMange.class.getResource("/Photo/tianjia (1).png")));
		btnNewButton_2.setFont(new Font("楷体", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(145)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(infotextArea))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nametextField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton_1))
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton)
								.addComponent(btnNewButton_2))))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnNewButton)
						.addComponent(nametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(infotextArea, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void delete(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = nametextField.getText().toString();
		userDao dao = new userDao();
		user usertmp= new user();
		usertmp.setName(name);
		if(JOptionPane.showConfirmDialog(this, "你确定要删除吗？")!=JOptionPane.OK_OPTION) {
			return;
		}
		String string = dao.deleteUser(name);
		JOptionPane.showMessageDialog(this, string);
		return;
	}

	protected void search(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = nametextField.getText().toString();
		if(Toolclass.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "请输入用户名");
			return;
		}
		userDao dao = new userDao();
		user usertmp= new user();
		usertmp.setName(name);
		user user = dao.search(usertmp);
		if(user==null) {
			JOptionPane.showMessageDialog(this, "此用户不存在");
			return;
		}
		infotextArea.setText("用户ID："+user.getId()+"\n"+"用户名："+user.getName()+"\n"+"密码："+user.getPassword());
		
	}

	protected void adduser(ActionEvent e) {
		// TODO Auto-generated method stub
		new createUser().setVisible(true);
		this.dispose();
		
	}
}
