package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import java.awt.SystemColor;

public class deleteFile extends JInternalFrame {
	private JTextField fileNametextField;
	private JTextField filrInfotextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteFile frame = new deleteFile();
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
	public deleteFile() {
		setBackground(SystemColor.activeCaption);
		setTitle("删除文件界面");
		setBounds(100, 100, 475, 321);
		
		JLabel label = new JLabel("删除文件和目录");
		label.setIcon(new ImageIcon(deleteFile.class.getResource("/Photo/wenjianjia (5).png")));
		label.setFont(new Font("楷体", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("文件路径：");
		lblNewLabel.setIcon(new ImageIcon(deleteFile.class.getResource("/Photo/file2.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 15));
		
		fileNametextField = new JTextField();
		fileNametextField.setColumns(10);
		
		JButton conFirmbtnNewButton = new JButton("确认");
		conFirmbtnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(e);
			}
		});
		setClosable(true);
		setIconifiable(true);
		conFirmbtnNewButton.setIcon(new ImageIcon(deleteFile.class.getResource("/Photo/icon-test (2).png")));
		conFirmbtnNewButton.setFont(new Font("楷体", Font.BOLD, 15));
		
		JButton btnNewButton_1 = new JButton("查看");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				research(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(deleteFile.class.getResource("/Photo/查询.png")));
		btnNewButton_1.setFont(new Font("楷体", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("（请看清楚文件和目录哦）");
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 10));
		
		filrInfotextField = new JTextField();
		filrInfotextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("状态信息：");
		lblNewLabel_2.setIcon(new ImageIcon(deleteFile.class.getResource("/Photo/xueshengziping.png")));
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(135, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(106))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(186, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(141))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(101)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(filrInfotextField)
								.addComponent(fileNametextField, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(conFirmbtnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)))
					.addGap(83))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(fileNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(filrInfotextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(conFirmbtnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(24))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void delete(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = fileNametextField.getText().toString();
		String info = filrInfotextField.getText().toString();
		if(Toolclass.isEmpty(name)) {
			JOptionPane.showMessageDialog(this, "文件名称不能为空");
			return;
		}
		if(Toolclass.isEmpty(info)) {
			JOptionPane.showMessageDialog(this, "请先查找文件");
			return;
		}
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			String path = "/"+admins.getName()+'/'+name;
			boolean exist = dao.exist(path);
			if(JOptionPane.showConfirmDialog(this, "你确定要输出吗？")!=JOptionPane.OK_OPTION) {
				return;
			}
			if(exist) {
				boolean b = dao.delFile(path);
				if(b) {
					JOptionPane.showMessageDialog(this, "删除成功");
					return;
				}else {
					JOptionPane.showMessageDialog(this, "删除失败");
					return;
				}
			}
		}
		if("学生".equals(mian.usertype.getName())) {
			hdfsDAO dao = new hdfsDAO();
			user us = (user) mian.userobject;
			String path = "/admin/"+us.getName()+'/'+name;
			boolean exist = dao.exist(path);
			if(JOptionPane.showConfirmDialog(this, "你确定要输出吗？")!=JOptionPane.OK_OPTION) {
				return;
			}
			if(exist) {
				boolean b = dao.delFile(path);
				if(b) {
					JOptionPane.showMessageDialog(this, "删除成功");
					return;
				}else {
					JOptionPane.showMessageDialog(this, "删除失败");
					return;
				}
			}
		}
		
	}

	protected void research(ActionEvent e) {
		// TODO Auto-generated method stub
		String filename = fileNametextField.getText().toString();
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean exist = dao.exist("/"+admins.getName()+'/'+filename);
			if(exist) {
				filrInfotextField.setText("文件存在");
				return;
			}else {
				filrInfotextField.setText("文件不存在，请重新输入");
				return;
			}
		}
		if("学生".equals(mian.usertype.getName())) {
			hdfsDAO dao = new hdfsDAO();
			user us = (user) mian.userobject;
			boolean exist = dao.exist("/admin/"+us.getName()+'/'+filename);
			if(exist) {
				filrInfotextField.setText("文件存在");
				return;
			}else {
				filrInfotextField.setText("文件不存在，请重新输入");
				return;
			}
		}
		
	}
}
