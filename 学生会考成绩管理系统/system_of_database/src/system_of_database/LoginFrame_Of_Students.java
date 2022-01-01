package system_of_database;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Container;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame_Of_Students extends JFrame{
	
	private JPanel p;
	private JLabel lblName,lblPwd,lblMsg1,lblMsg2;
	private JTextField txtName;
	private JPasswordField txtPwd;
	private JButton btnOk,btnCancel,btnAdministration;
	private User_Of_Students user;
	private UserService_Of_Students userService;
	private Clipboard clipboard = null;
	
	public LoginFrame_Of_Students() {
		super("Examinee");
		userService = new UserService_Of_Students();
		ImageIcon qstIcon = new ImageIcon("images\\1.png");
		this.setIconImage(qstIcon.getImage());
		p = new JPanel();
		setBak();
		clipboard=getToolkit().getSystemClipboard();
		Container c = getContentPane();
		p.setOpaque(false);
		c.add(p);
		p.setLayout(null);
		lblName = new JLabel("考生号：");
		lblPwd = new JLabel("密   码：");
		txtName = new JTextField(20);
		txtPwd = new JPasswordField(20);
		lblMsg1 = new JLabel();
		lblMsg1.setForeground(Color.red);
		lblMsg2 = new JLabel();
		lblMsg2.setForeground(Color.red);
		txtPwd.setEchoChar('*');
		
		btnOk = new JButton("登录");
		btnOk.addActionListener(new LoginListener());
		btnCancel = new JButton("重置");
		btnCancel.addActionListener(new ResetListener());
		btnAdministration = new JButton("管理员");
		btnAdministration.addActionListener(new AdministrationListener());
		
		lblName.setBounds(30,30,60,25);
		lblPwd.setBounds(30,60,60,25);
		txtName.setBounds(95,30,120,25);
		lblMsg1.setBounds(220,30,120,25);
		txtPwd.setBounds(95,60,120,25);
		lblMsg2.setBounds(220,60,120,25);
		btnOk.setBounds(30,90,60,25);
		btnCancel.setBounds(95,90,60,25);
		btnAdministration.setBounds(160,90,80,25);
		
		p.add(lblName);
		p.add(lblPwd);
		p.add(txtName);
		p.add(txtPwd);
		p.add(btnOk);
		p.add(btnCancel);
		p.add(btnCancel);
		p.add(btnAdministration);
		p.add(lblMsg1);
		p.add(lblMsg2);
		
		this.add(p);
		this.setLocationRelativeTo(null);
		this.setSize(350,185);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class LoginListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			lblMsg1.setText("");
			lblMsg2.setText("");
			user = userService.findUserByName(txtName.getText().trim());
			if(user != null) {
				if(user.getPassword().equals(new String(txtPwd.getPassword()))) {
					LoginFrame_Of_Students.this.setVisible(false);
					new MainFrame_Of_Students();
				} else {
					lblMsg2.setText("密码错误!");
					txtPwd.setText("");
				}
			} else {
				lblMsg1.setText("该考生不存在 !");
			}
		}
	}

	public class ResetListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			txtName.setText("");
			txtPwd.setText("");
		}
	}
	
	public class AdministrationListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			LoginFrame_Of_Students.this.setVisible(false);
			new LoginFrame_Of_Administration();
		}
	}
	
	public void setBak(){
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("images\\1586966533729.jpg"); 
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
	
	public static void main(String agrs[]) {
		new LoginFrame_Of_Students();
	}

}


