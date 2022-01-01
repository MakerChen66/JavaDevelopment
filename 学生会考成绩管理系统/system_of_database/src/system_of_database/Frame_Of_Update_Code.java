package system_of_database;

import java.awt.Container;

import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Frame_Of_Update_Code extends JFrame {
	
	 private JPanel p;
	 private Clipboard clipboard = null;
	 private JButton jbDelete,jbAdmi,jbId,jbCode,jbCode1;
	 private JTextField jtId;
	 private JPasswordField jpCode,jpCode1;
	
   public Frame_Of_Update_Code(){
	   super("修改密码");
		ImageIcon qstIcon = new ImageIcon("images\\1.png");
		this.setIconImage(qstIcon.getImage());
		p = new JPanel();
		setBak();
		clipboard=getToolkit().getSystemClipboard();
		Container c = getContentPane();
		p.setOpaque(false);
		c.add(p);
		p.setLayout(null);
	    
		jtId = new JTextField(20);
		jpCode = new JPasswordField(20);
		jpCode1 = new JPasswordField(20);
		
		jbId = new JButton("考号");
		jbCode = new JButton("输入密码");
		jbCode1 = new JButton("确认密码");
		jbDelete = new JButton("修改密码");
		jbAdmi = new JButton("返回考生界面");
		
		jbId.setBounds(115,20,100,25);
		jbCode.setBounds(115,60,100,25);
		jbCode1.setBounds(115,100,100,25);
		jtId.setBounds(220,20,180,25);
		jpCode.setBounds(220,60,180,25);
		jpCode1.setBounds(220,100,180,25);
		
		
		jbDelete.setBounds(105,170,120,25);
		jbAdmi.setBounds(268,170,120,25);
		
		p.add(jtId);
		p.add(jpCode);
		p.add(jpCode1);
		p.add(jbId);
		p.add(jbCode);
		p.add(jbCode1);
		p.add(jbDelete);
		p.add(jbAdmi);
		
		this.add(p);
		this.setLocation(200,100);
		this.setSize(500,300);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	   jbDelete.addActionListener(new listener_of_delete());
	   jbAdmi.addActionListener(new AdministrationListener());
		
   }
   
   public class listener_of_delete implements ActionListener{
		   public void actionPerformed(ActionEvent e){
			   String id = jtId.getText();
			   String code = new String(jpCode.getPassword());
			   String code1 = new String(jpCode1.getPassword());
			   DBUtil db = new DBUtil();
			   String sql = "update information_of_students set pwd = '"+code+"' where id = '"+id+"'";
			   if(code.equals(code1)){
				   try {
					   db.getConnection();
					   db.executeUpdate(sql,null);
				   } catch(Exception ee) {
					   System.out.println(ee.toString());
				   } finally {
					   db.closeAll();
				   }
				   JOptionPane.showMessageDialog(null, "修改成功");
			   }
			   else{
				   JOptionPane.showMessageDialog(null, "两次密码不一样！");
			   }
		   }
	}
   
   public class AdministrationListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Frame_Of_Update_Code.this.setVisible(false);
			new MainFrame_Of_Students();
		}
	}
   
   public void setBak(){
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("images\\2.jpg"); 
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
   
	public static void main(String agrs[]) {
			new Frame_Of_Update_Code();
	    }

}


