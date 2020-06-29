package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Dao.hdfsDAO;
import Moder.admin;
import Moder.user;
import Util.Toolclass;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class putFile extends JInternalFrame {
	private JTextField localpathtextField;
	private JTextField fileStatustextField;
	private JTextField hdfspathtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					putFile frame = new putFile();
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
	public putFile() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setTitle("上传文件界面");
		setBounds(100, 100, 449, 350);
		
		JLabel lblNewLabel = new JLabel("上传文件");
		lblNewLabel.setIcon(new ImageIcon(putFile.class.getResource("/Photo/shangchuanwenjian.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("本地文件路径：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		localpathtextField = new JTextField();
		localpathtextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		localpathtextField.setColumns(10);
		setClosable(true);
		setIconifiable(true);
		fileStatustextField = new JTextField();
		fileStatustextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		fileStatustextField.setColumns(10);
		
		JLabel label = new JLabel("文件状态信息：");
		label.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		JLabel lblNewLabel_2 = new JLabel("上传文件路径：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		hdfspathtextField = new JTextField();
		hdfspathtextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		hdfspathtextField.setColumns(10);
		
		JButton btnNewButton = new JButton("上传");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFile(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(putFile.class.getResource("/Photo/upload.png")));
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 15));
		
		JButton btnNewButton_1 = new JButton("查看");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(putFile.class.getResource("/Photo/chakan.png")));
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(167)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(87)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(label)
										.addComponent(lblNewLabel_2))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(hdfspathtextField)
										.addComponent(fileStatustextField, Alignment.LEADING)
										.addComponent(localpathtextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNewButton_1)))))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(localpathtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(fileStatustextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(hdfspathtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(28))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void putFile(ActionEvent e) {
		// TODO Auto-generated method stub
		String local = localpathtextField.getText().toString();
		String hdfs = hdfspathtextField.getText().toString();
		String status = fileStatustextField.getText().toString();
		if(Toolclass.isEmpty(status)) {
			JOptionPane.showMessageDialog(this, "请先查看文件");
			return;
		}
		if(status.equals("不存在")) {
			JOptionPane.showMessageDialog(this, "此文件不存在，不可以上传");
			return;
		}
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean file = dao.putFile(local, "/"+admins.getName()+"/"+hdfs);
			if(file) {
				JOptionPane.showMessageDialog(this, "上传成功");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "上传失败");
				return;
			}
		}
		if("学生".equals(mian.usertype.getName())) {
			user us = (user) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean file = dao.putFile(local, "/admin/"+us.getName()+"/"+hdfs);
			if(file) {
				JOptionPane.showMessageDialog(this, "上传成功");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "上传失败");
				return;
			}
		}
		
	}

	protected void search(ActionEvent e) {
		// TODO Auto-generated method stub
		String loacl = localpathtextField.getText().toString();
		hdfsDAO dao = new hdfsDAO();
		boolean b = dao.localexist(loacl);
		if(b) {
			fileStatustextField.setText("存在");
		}
		else {
			fileStatustextField.setText("不存在");
		}
	}

}
