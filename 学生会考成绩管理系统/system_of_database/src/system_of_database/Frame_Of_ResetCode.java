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


public class Frame_Of_ResetCode extends JFrame {
	
	 private JPanel p;
	 private Clipboard clipboard = null;
	 private JButton jbDelete,jbAdmi,jbId,jbCode,jbCode1;
	 private JTextField jtId;
	 private JPasswordField jpCode,jpCode1;
	
   public Frame_Of_ResetCode(){
	   super("重置考生密码");
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
		
		jbId = new JButton("考号");
		jbDelete = new JButton("重置密码");
		jbAdmi = new JButton("返回管理界面");
		
		jbId.setBounds(115,20,100,25);
		jtId.setBounds(220,20,180,25);		
		
		jbDelete.setBounds(105,150,120,25);
		jbAdmi.setBounds(268,150,120,25);
		
		p.add(jtId);
		p.add(jbId);
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
			   DBUtil db = new DBUtil();
			   String sql = "update information_of_students set pwd = '000000' where id = '"+id+"'";
			   try {
				   db.getConnection();
				   db.executeUpdate(sql,null);
			   } catch(Exception ee) {
				   System.out.println(ee.toString());
			   } finally {
				   db.closeAll();
				 }
				 JOptionPane.showMessageDialog(null, "重置成功");
		   }
	}
   
   public class AdministrationListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Frame_Of_ResetCode.this.setVisible(false);
			new MainFrame_Of_Administration();
		}
	}
   
   public void setBak(){
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("images\\990.jpg"); 
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
   
	public static void main(String agrs[]) {
			new Frame_Of_ResetCode();
	    }

}



