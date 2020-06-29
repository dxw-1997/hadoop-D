package View;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.apache.hadoop.fs.FileStatus;
import Dao.hdfsDAO;
import Moder.admin;
import Moder.user;
import Util.Toolclass;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class fileManger extends JInternalFrame {

	private JTextField fileNametextField;
	JButton searchbutton;
	private JLabel label_1;
	private JTextField filename2textField;
	private JTextField pathtextField;
	private JTextField typetextField;
	private JTextField roottextField;
	private JLabel lblNewLabel_1;
	private JTextField sizetextField;
	private JTextArea sonFiletextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fileManger frame = new fileManger();
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
	public fileManger() {
		getContentPane().setBackground(SystemColor.activeCaption);
		setBackground(SystemColor.activeCaption);
		getContentPane().setFont(new Font("楷体", Font.BOLD, 15));
		setBounds(100, 100, 727, 528);
		
		JLabel label = new JLabel("文件名称：");
		label.setIcon(new ImageIcon(fileManger.class.getResource("/Photo/file2.png")));
		label.setFont(new Font("楷体", Font.BOLD, 20));
		setClosable(true);
		setIconifiable(true);
		fileNametextField = new JTextField();
		fileNametextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		fileNametextField.setColumns(10);
		
		searchbutton = new JButton("查询");
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search(e);
			}
		});
		searchbutton.setIcon(new ImageIcon(fileManger.class.getResource("/photo/查询.png")));
		searchbutton.setFont(new Font("楷体", Font.PLAIN, 20));
		
		label_1 = new JLabel("文件名称：");
		label_1.setIcon(new ImageIcon(fileManger.class.getResource("/Photo/file-1.png")));
		label_1.setFont(new Font("楷体", Font.BOLD, 18));
		
		filename2textField = new JTextField();
		filename2textField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		filename2textField.setColumns(10);
		
		JButton btnNewButton = new JButton("重命名");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rename(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(fileManger.class.getResource("/Photo/zhongmingming (1).png")));
		btnNewButton.setFont(new Font("楷体", Font.BOLD, 15));
		
		JLabel lblNewLabel = new JLabel("文件信息");
		lblNewLabel.setIcon(new ImageIcon(fileManger.class.getResource("/Photo/bangzhu.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 20));
		
		JLabel label_2 = new JLabel("文件路径:");
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		pathtextField = new JTextField();
		pathtextField.setBackground(SystemColor.activeCaption);
		pathtextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		pathtextField.setColumns(10);
		
		JLabel label_3 = new JLabel("文件类型：");
		label_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		typetextField = new JTextField();
		typetextField.setBackground(SystemColor.activeCaption);
		typetextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		typetextField.setColumns(10);
		
		JLabel label_4 = new JLabel("文件权限：");
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		roottextField = new JTextField();
		roottextField.setBackground(SystemColor.activeCaption);
		roottextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		roottextField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("文件大小：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		sizetextField = new JTextField();
		sizetextField.setBackground(SystemColor.activeCaption);
		sizetextField.setFont(new Font("微软雅黑", Font.BOLD, 15));
		sizetextField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetname(e);
				
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 10));
		btnNewButton_1.setIcon(new ImageIcon(fileManger.class.getResource("/Photo/tuichu.png")));
		
		JLabel lblNewLabel_2 = new JLabel("子文件夹：");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		
		sonFiletextArea = new JTextArea();
		sonFiletextArea.setFont(new Font("微软雅黑", Font.BOLD, 15));
		sonFiletextArea.setBackground(SystemColor.activeCaption);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(150)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(typetextField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(roottextField, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblNewLabel_2)
											.addComponent(lblNewLabel_1))
										.addComponent(label_2))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(sonFiletextArea, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(pathtextField, Alignment.TRAILING)
											.addComponent(sizetextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)))))
							.addGap(29)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(95)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addGap(26)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnNewButton)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(fileNametextField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
												.addGap(82)
												.addComponent(searchbutton)))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(filename2textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))))
					.addGap(53))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(label))
						.addComponent(fileNametextField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchbutton))
					.addGap(29)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(typetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(roottextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(sizetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(pathtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_2))
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(sonFiletextArea, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(filename2textField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(52))
		);
		getContentPane().setLayout(groupLayout);
	}

	protected void resetname(ActionEvent e) {
		// TODO Auto-generated method stub
		String path = pathtextField.getText().toString();
		filename2textField.setText(path);
	}

	protected void rename(ActionEvent e) {
		// TODO Auto-generated method stub
		String one = pathtextField.getText().toString();
		String two = filename2textField.getText().toString();
		try {
			hdfsDAO dao = new hdfsDAO();
			boolean b = dao.renameFile(one, two);
			if(Toolclass.isEmpty(two)) {
				JOptionPane.showMessageDialog(this,"重命名名称不能为空");
				return;
			}
			if(one.equals(two)) {
				JOptionPane.showMessageDialog(this,"你没有做任何修改");
				return;
			}
			if(b) {
				JOptionPane.showMessageDialog(this,"重命名成功");
				return;
			}
			else {
				JOptionPane.showMessageDialog(this,"重命名是失败");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void search(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = fileNametextField.getText().toString();
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			try {
				set("/"+admins.getName()+"/"+name);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,"查看的文件不存在");
				return;
			}
		}
		if("学生".equals(mian.usertype.getName())) {
			user us = (user) mian.userobject;
			try {
				set("/admin/"+us.getName()+"/"+name);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this,"查看的文件不存在");
				return;
			}
		}
		
		
	}
	protected void set(String path) {
		// TODO Auto-generated method stub
			hdfsDAO dao = new hdfsDAO();
			FileStatus status = null;
			try {
				status = dao.info(path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			pathtextField.setText(status.getPath().toString());
			if(status.isDirectory()) {
				typetextField.setText("文件夹");
			}
			else {
				typetextField.setText("文件");
			}
			roottextField.setText(status.getPermission().toString());
			sizetextField.setText(String.valueOf(status.getLen()/1024)+"kb");
			if("管理员".equals(mian.usertype.getName())) {
				admin admins = (admin) mian.userobject;
				List<Object> list = dao.listAllFilesOfPath(path);
				StringBuffer buffer = new StringBuffer();
				for(Object it:list) {
					buffer.append(it+"\n");
				}
				sonFiletextArea.setText(buffer.toString());			
			}
			if("学生".equals(mian.usertype.getName())) {
				user us = (user) mian.userobject;
				List<Object> list = dao.listAllFilesOfPath(path);
				StringBuffer buffer = new StringBuffer();
				for(Object it:list) {
					buffer.append(it+"\n");
				}
				sonFiletextArea.setText(buffer.toString());
			}
	}
}



























