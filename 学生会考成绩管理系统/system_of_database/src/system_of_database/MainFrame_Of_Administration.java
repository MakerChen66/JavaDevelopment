package system_of_database;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import system_of_database.Frame_Of_Insert_Information.AdministrationListener;
import system_of_database.LoginFrame_Of_Administration.Listener_Of_Students;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import  java.awt.datatransfer.*;

public class MainFrame_Of_Administration extends JFrame{
	
	 private JPanel p;
	 private Clipboard clipboard = null;
	 private JButton jbInsert,jbDelete,jbUpdate,jbAdministration,jbResetCode;
	
	public MainFrame_Of_Administration() {
		super("Administration");
		ImageIcon qstIcon = new ImageIcon("images\\1.png");
		this.setIconImage(qstIcon.getImage());
		p = new JPanel();
		setBak();
		clipboard=getToolkit().getSystemClipboard();
		Container c = getContentPane();
		p.setOpaque(false);
		c.add(p);
		p.setLayout(null);
		
		jbInsert = new JButton("添加考生信息");
		jbDelete = new JButton("删除考生信息");
		jbUpdate = new JButton("修改考生信息");
		jbAdministration = new JButton("返回登录界面");
		jbResetCode = new JButton("重置考生密码");
		
		jbAdministration.addActionListener(new loginframe_of_administration());
		jbDelete.addActionListener(new listener_of_delete());
		jbInsert.addActionListener(new listener_of_insert());
		jbUpdate.addActionListener(new listener_of_update());
		jbResetCode.addActionListener(new listener_of_reset());
		
		jbInsert.setBounds(0,20,120,25);
		jbDelete.setBounds(0,55,120,25);
		jbUpdate.setBounds(0,90,120,25);
		jbAdministration.setBounds(0,125,120,25);
		jbResetCode.setBounds(0,165,120,25);
		
		p.add(jbInsert);
		p.add(jbDelete);
		p.add(jbUpdate);
		p.add(jbAdministration);
		p.add(jbResetCode);
    	this.add(p);
		this.setLocation(200,100);
		this.setSize(533,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public void setBak(){
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("images\\990.jpg"); 
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
	
	public class loginframe_of_administration implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainFrame_Of_Administration.this.setVisible(false);
			new LoginFrame_Of_Administration();
		}
	}
	
	public class listener_of_insert implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainFrame_Of_Administration.this.setVisible(false);
			new Frame_Of_Insert_Information();
		}
	}
	
	public class listener_of_delete implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainFrame_Of_Administration.this.setVisible(false);
			new Frame_Of_Delete_Information();
		}
	}
	
	public class listener_of_update implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainFrame_Of_Administration.this.setVisible(false);
			new Frame_Of_Update_Information();
		}
	}
	
	public class listener_of_reset implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			MainFrame_Of_Administration.this.setVisible(false);
			new Frame_Of_ResetCode();
		}
	}
	
	public static void main(String agrs[]) {
		new MainFrame_Of_Administration();
	}

}


