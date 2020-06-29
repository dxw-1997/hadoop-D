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

public class getFile extends JInternalFrame {
	private JTextField hdfspathtextField;
	private JTextField fileStatustextField;
	private JTextField localpathtextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getFile frame = new getFile();
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
	public getFile() {
		getContentPane().setFont(new Font("微软雅黑", Font.BOLD, 15));
		setBackground(SystemColor.activeCaption);
		setTitle("下载界面");
		setBounds(100, 100, 451, 345);
		
		JLabel lblNewLabel = new JLabel("文件下载");
		lblNewLabel.setIcon(new ImageIcon(getFile.class.getResource("/Photo/wenjianxiazai2.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("文件名称：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		setClosable(true);
		setIconifiable(true);
		hdfspathtextField = new JTextField();
		hdfspathtextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		hdfspathtextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("文件状态：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		fileStatustextField = new JTextField();
		fileStatustextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		fileStatustextField.setColumns(10);
		
		JButton btnNewButton = new JButton("下载");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFile(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(getFile.class.getResource("/Photo/iconfontzhizuobiaozhun023146.png")));
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 15));
		
		JButton btnNewButton_1 = new JButton("查看");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(getFile.class.getResource("/Photo/chakan.png")));
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 15));
		
		JLabel lblNewLabel_3 = new JLabel("存放路径：");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		localpathtextField = new JTextField();
		localpathtextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		localpathtextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(142)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(hdfspathtextField, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton)
									.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
									.addComponent(btnNewButton_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(localpathtextField, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
										.addComponent(fileStatustextField))))))
					.addContainerGap(94, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addComponent(lblNewLabel)
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(hdfspathtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(fileStatustextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(localpathtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(25))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void getFile(ActionEvent e) {
		// TODO Auto-generated method stub
		String local = localpathtextField.getText().toString();
		String status = fileStatustextField.getText().toString();
		String hdfs = hdfspathtextField.getText().toString();
		if(Toolclass.isEmpty(status)) {
			JOptionPane.showMessageDialog(this, "请先查看文件");
			return;
		}
		if(status.equals("不可以下载")) {
			JOptionPane.showMessageDialog(this, "此文件为不能下载文件");
			return;
		}
		if(Toolclass.isEmpty(local)) {
			JOptionPane.showMessageDialog(this, "本地路径不能为空");
			return;
		}
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean file = dao.getFile("/"+admins.getName()+"/"+hdfs, local);
			if(file) {
				JOptionPane.showMessageDialog(this, "下载成功");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "下载失败");
				return;
			}
		}
		if("学生".equals(mian.usertype.getName())) {
			user us = (user) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean file = dao.getFile("/admin/"+us.getName()+"/"+hdfs, local);
			if(file) {
				JOptionPane.showMessageDialog(this, "下载成功");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, "下载失败");
				return;
			}
		}
		
	}

	protected void search(ActionEvent e) {
		// TODO Auto-generated method stub
		String hdfs = hdfspathtextField.getText().toString();
		
		if(Toolclass.isEmpty(hdfs)) {
			JOptionPane.showMessageDialog(this, "文件名称不能为空");
			return;
		}
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean exist = dao.exist("/"+admins.getName()+"/"+hdfs);
			if(exist) {
				fileStatustextField.setText("可以下载");
			}
			else {
				fileStatustextField.setText("不可以下载");
			}
		}
		if("学生".equals(mian.usertype.getName())) {
			user us = (user) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean exist = dao.exist("/admin/"+us.getName()+"/"+hdfs);
			if(exist) {
				fileStatustextField.setText("可以下载");
			}
			else {
				fileStatustextField.setText("不可以下载");
			}
		}
		
		
	}

}
