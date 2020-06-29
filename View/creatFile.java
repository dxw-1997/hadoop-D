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
import Moder.admin;
import Moder.user;
import Util.Toolclass;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class creatFile extends JInternalFrame {
	private JTextField fileNametextField;
	private JTextField filejiaNametextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creatFile frame = new creatFile();
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
	public creatFile() {
		setBackground(SystemColor.activeCaption);
		setTitle("创建文件界面");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("文件名称：");
		lblNewLabel.setIcon(new ImageIcon(creatFile.class.getResource("/Photo/file-1.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 15));
		setClosable(true);
		setIconifiable(true);
		fileNametextField = new JTextField();
		fileNametextField.setColumns(10);
		
		JButton confim_btnNewButton = new JButton("确认");
		confim_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = fileNametextField.getText().toString();
				String filejia = filejiaNametextField.getText().toString();
				if(Toolclass.isEmpty(file)&&Toolclass.isEmpty(filejia)) {
					JOptionPane.showMessageDialog(null, "请选中其中一个");
				}
				if(!Toolclass.isEmpty(file)) {
					creatFile(e);
				}
				else {
					createFilejia(e);
				}
				
			}
		});
		confim_btnNewButton.setFont(new Font("楷体", Font.BOLD, 15));
		confim_btnNewButton.setIcon(new ImageIcon(creatFile.class.getResource("/photo/tuichu.png")));
		
		JButton concal_btnNewButton = new JButton("取消");
		concal_btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel(e);
			}
		});
		concal_btnNewButton.setFont(new Font("楷体", Font.BOLD, 15));
		concal_btnNewButton.setIcon(new ImageIcon(creatFile.class.getResource("/photo/重置.png")));
		
		JLabel lblNewLabel_1 = new JLabel("创建文件和目录");
		lblNewLabel_1.setIcon(new ImageIcon(creatFile.class.getResource("/Photo/wenjianjia (5).png")));
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 25));
		
		JLabel label = new JLabel("目录名称：");
		label.setIcon(new ImageIcon(creatFile.class.getResource("/Photo/wenjian.png")));
		label.setFont(new Font("楷体", Font.BOLD, 15));
		
		filejiaNametextField = new JTextField();
		filejiaNametextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("（请分清楚文件和目录哦）");
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 10));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(confim_btnNewButton)
										.addComponent(label))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(filejiaNametextField, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
									.addComponent(fileNametextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
								.addComponent(concal_btnNewButton))
							.addGap(85))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(104))))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(156)
					.addComponent(lblNewLabel_2)
					.addContainerGap(206, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(fileNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(filejiaNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(confim_btnNewButton)
						.addComponent(concal_btnNewButton))
					.addGap(21))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void createFilejia(ActionEvent e) {
		// TODO Auto-generated method stub
		String filename = filejiaNametextField.getText().toString();
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean b= dao.createDir("/"+admins.getName()+"/"+filename);
			if(b) {
				JOptionPane.showMessageDialog(this, "创建目录成功！");
				return;
			}else {
				JOptionPane.showMessageDialog(this, "创建目录失败！");
				return;
			}
		}
		if("学生".equals(mian.usertype.getName())) {
			user us = (user) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean b= dao.createDir("/admin/"+us.getName()+"/"+filename);
			if(b) {
				JOptionPane.showMessageDialog(this, "创建目录成功！");
				return;
			}else {
				JOptionPane.showMessageDialog(this, "创建目录失败！");
				return;
			}
		}
		
	}

	protected void creatFile(ActionEvent e) {
		// TODO Auto-generated method stub
		String filename = fileNametextField.getText().toString();
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean b= dao.createFile("/"+admins.getName()+"/"+filename);
			if(b) {
				JOptionPane.showMessageDialog(this, "创建文件成功！");
				return;
			}else {
				JOptionPane.showMessageDialog(this, "创建文件失败！");
				return;
			}
		}
		if("学生".equals(mian.usertype.getName())) {	
			user us = (user) mian.userobject;
			hdfsDAO dao = new hdfsDAO();
			boolean b= dao.createFile("/admin/"+us.getName()+"/"+filename);
			if(b) {
				JOptionPane.showMessageDialog(this, "创建文件成功！");
				return;
			}else {
				JOptionPane.showMessageDialog(this, "创建文件失败！");
				return;
			}
		}
		
	}

	protected void cancel(ActionEvent e) {
		// TODO Auto-generated method stub
		fileNametextField.setText("");
		filejiaNametextField.setText("");
	}
}
