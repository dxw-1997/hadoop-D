package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.hdfsDAO;
import Moder.admin;
import Moder.user;
import Moder.userType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.Desktop;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class mian extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static userType usertype;
	public static Object userobject;
	private JLabel userlblNewLabel;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public mian(userType usertype,Object userobject) {
		this.usertype = usertype;
		this.userobject = userobject;
		setFont(new Font("楷体", Font.BOLD, 20));
		setTitle("网盘主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 678);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		menu.setIcon(new ImageIcon(mian.class.getResource("/photo/icon-test (2).png")));
		menu.setFont(new Font("楷体", Font.BOLD, 18));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatepassword(e);
			}
		});
		menuItem.setIcon(new ImageIcon(mian.class.getResource("/photo/xiugaimima.png")));
		menuItem.setFont(new Font("楷体", Font.BOLD, 15));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(mian.this, "你要退出网盘吗？")==JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("用户管理");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adduser(e);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(mian.class.getResource("/Photo/banjiguanli.png")));
		mntmNewMenuItem.setFont(new Font("楷体", Font.BOLD, 15));
		menu.add(mntmNewMenuItem);
		menuItem_1.setIcon(new ImageIcon(mian.class.getResource("/photo/tuichu (1).png")));
		menuItem_1.setFont(new Font("楷体", Font.BOLD, 15));
		menu.add(menuItem_1);
		
		JMenu menu_2 = new JMenu("文件管理");
		menu_2.setIcon(new ImageIcon(mian.class.getResource("/Photo/wenjian (1).png")));
		menu_2.setFont(new Font("楷体", Font.BOLD, 18));
		menuBar.add(menu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("创建");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addclass(e);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("楷体", Font.BOLD, 15));
		mntmNewMenuItem_1.setIcon(new ImageIcon(mian.class.getResource("/Photo/wenjian.png")));
		menu_2.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem_3 = new JMenuItem("查看");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clasManger(e);
			}
		});
		menuItem_3.setIcon(new ImageIcon(mian.class.getResource("/Photo/查询.png")));
		menuItem_3.setFont(new Font("楷体", Font.BOLD, 15));
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_2 = new JMenuItem("删除");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(e);
			}
		});
		menuItem_2.setIcon(new ImageIcon(mian.class.getResource("/Photo/ziyuan.png")));
		menuItem_2.setFont(new Font("楷体", Font.BOLD, 15));
		menu_2.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("上传下载");
		menu_1.setIcon(new ImageIcon(mian.class.getResource("/Photo/xiazai.png")));
		menu_1.setFont(new Font("楷体", Font.BOLD, 18));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_4 = new JMenuItem("上传文件");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				putFile(e);
			}
		});
		menuItem_4.setFont(new Font("楷体", Font.BOLD, 15));
		menuItem_4.setIcon(new ImageIcon(mian.class.getResource("/Photo/upload.png")));
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("下载文件");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFile(e);
			}
		});
		menuItem_5.setIcon(new ImageIcon(mian.class.getResource("/Photo/iconfontzhizuobiaozhun023146.png")));
		menuItem_5.setFont(new Font("楷体", Font.BOLD, 15));
		menu_1.add(menuItem_5);
		
		JMenu mnNewMenu = new JMenu("\u5BFB\u6C42\u5E2E\u52A9");
		mnNewMenu.setIcon(new ImageIcon(mian.class.getResource("/photo/bangzhu.png")));
		mnNewMenu.setFont(new Font("楷体", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				help();
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(mian.class.getResource("/photo/guanyuwomen.png")));
		mntmNewMenuItem_2.setFont(new Font("楷体", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.activeCaption);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Hadoop网盘");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setIcon(new ImageIcon(mian.class.getResource("/Photo/海豚.png")));
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 32));
		lblNewLabel.setBounds(271, 85, 235, 91);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("主 机 名：");
		lblNewLabel_1.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_1.setBounds(226, 202, 91, 18);
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("网盘结构：");
		lblNewLabel_2.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_2.setBounds(226, 298, 80, 18);
		desktopPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("当前用户：");
		lblNewLabel_4.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_4.setBounds(226, 253, 91, 18);
		desktopPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("hdfs://hadoop15:9000");
		lblNewLabel_5.setFont(new Font("楷体", Font.BOLD, 15));
		lblNewLabel_5.setBounds(325, 202, 195, 18);
		desktopPane.add(lblNewLabel_5);
		
		userlblNewLabel = new JLabel("New label");
		userlblNewLabel.setFont(new Font("楷体", Font.BOLD, 15));
		userlblNewLabel.setBounds(325, 253, 181, 18);
		desktopPane.add(userlblNewLabel);
		
		JTextArea nametextArea = new JTextArea();
		nametextArea.setBackground(SystemColor.activeCaption);
		nametextArea.setFont(new Font("楷体", Font.BOLD, 15));
		nametextArea.setBounds(325, 296, 195, 91);
		desktopPane.add(nametextArea);
		
		JLabel label = new JLabel("网盘大小：");
		label.setFont(new Font("楷体", Font.BOLD, 15));
		label.setBounds(226, 416, 80, 18);
		desktopPane.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("20G");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_3.setBounds(325, 415, 72, 18);
		desktopPane.add(lblNewLabel_3);
		setLocationRelativeTo(null);
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			userlblNewLabel.setText("【"+admins.getName()+"】");
		}
		if("学生".equals(mian.usertype.getName())) {
			user us = (user) mian.userobject;
			userlblNewLabel.setText("【"+us.getName()+"】");
		}
		hdfsDAO dao = new hdfsDAO();
		
//		String[] split = buffer.toString().split("/");
//		for(int i=0;i<split.length;i++) {
//			
//		}
		
		if("管理员".equals(mian.usertype.getName())) {
			admin admins = (admin) mian.userobject;
			List<Object> list = dao.listAllFilesOfPath("/"+admins.getName());
			StringBuffer buffer = new StringBuffer();
			for(Object it:list) {
				buffer.append(it+"\n");
			}
			nametextArea.setText(buffer.toString());			
		}
		if("学生".equals(mian.usertype.getName())) {
			user us = (user) mian.userobject;
			List<Object> list = dao.listAllFilesOfPath("/admin/"+us.getName());
			StringBuffer buffer = new StringBuffer();
			for(Object it:list) {
				buffer.append(it+"\n");
			}
			nametextArea.setText(buffer.toString());
		}
	}

	protected void adduser(ActionEvent e) {
		// TODO Auto-generated method stub
		if("学生".equals(mian.usertype.getName())) {
			JOptionPane.showMessageDialog(this, "你没有管理员权限");
			return;
		}
		if("管理员".equals(mian.usertype.getName())) {
			userMange userMange = new userMange();
			userMange.setVisible(true);
			desktopPane.add(userMange);
		}
		
	}

	protected void getFile(ActionEvent e) {
		// TODO Auto-generated method stub
		getFile getFile = new getFile();
		getFile.setVisible(true);
		desktopPane.add(getFile);
	}

	protected void putFile(ActionEvent e) {
		// TODO Auto-generated method stub
		putFile putFile = new putFile();
		putFile.setVisible(true);
		desktopPane.add(putFile);
	}

	protected void delete(ActionEvent e) {
		// TODO Auto-generated method stub
		deleteFile file = new deleteFile();
		file.setVisible(true);
		desktopPane.add(file);
	}

	protected void clasManger(ActionEvent e) {
		// TODO Auto-generated method stub
		fileManger fileManger = new fileManger();
		fileManger.setVisible(true);
		desktopPane.add(fileManger);
	}

	protected void addclass(ActionEvent e) {
		// TODO Auto-generated method stub
		creatFile info = new creatFile();
		info.setVisible(true);
		desktopPane.add(info);
	}

	protected void updatepassword(ActionEvent e) {
		
		updaPassword updaPassword = new updaPassword();
		updaPassword.setVisible(true);
		desktopPane.add(updaPassword);
	}

	protected void help() {
		String info = "羡慕那些冷漠无情说走就走的人，我不行我走的时候还得拿你点儿吃的。";
		String[] butt = {"我们去官网看一看","心情不好"};
 		int count = JOptionPane.showOptionDialog(this,info,null, JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.DEFAULT_OPTION,new ImageIcon(login.class.getResource("/photo/\u6D77\u8C5A.png")),butt , null);
 		if(count==0) {
 			try {
				URI uri = new URI("https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-hdfs/WebHDFS.html");
				Desktop.getDesktop().browse(uri);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
	}
}
