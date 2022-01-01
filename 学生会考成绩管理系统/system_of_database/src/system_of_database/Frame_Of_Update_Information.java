package system_of_database;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Frame_Of_Update_Information extends JFrame {
	
	 private JPanel p;
	 private Clipboard clipboard = null;
	 private JButton jlId,jlGeo,jlChe,jlIT,jlHis,jlBio,jlMath,jlGen,jlPhy,jlEng,jlChi,jlPol;
	 private JButton jbInsert,jbAdmi;
	 private JTextField jtId,jtGeo,jtChe,jtIT,jtHis,jtBio,jtMath,jtGen,jtPhy,jtEng,jtChi,jtPol;
	
   public Frame_Of_Update_Information(){
	   super("���Ŀ�����Ϣ");
		ImageIcon qstIcon = new ImageIcon("images\\1.png");
		this.setIconImage(qstIcon.getImage());
		p = new JPanel();
		setBak();
		clipboard=getToolkit().getSystemClipboard();
		Container c = getContentPane();
		p.setOpaque(false);
		c.add(p);
		p.setLayout(null);
	    
		jlId = new JButton("����");
		jlGeo = new JButton("����");
		jlChe  = new JButton("��ѧ");
	    jlIT = new JButton("��Ϣ����");
		jlHis = new JButton("��ʷ");
		jlBio = new JButton("����");
		jlMath = new JButton("��ѧ");
		jlGen = new JButton("ͨ�ü���");
		jlPhy  = new JButton("����");
	    jlEng = new JButton("Ӣ��");
		jlChi = new JButton("����");
		jlPol = new JButton("����");
		
		jbInsert = new JButton("���Ŀ�����Ϣ");
		jbAdmi = new JButton("���ع������");
		
		jtId = new JTextField(20);
		jtGeo = new JTextField(20);
		jtChe  = new JTextField(20);
		jtIT = new JTextField(20);
		jtHis = new JTextField(20);
		jtBio = new JTextField(20);
		jtMath = new JTextField(20);
		jtGen = new JTextField(20);
		jtPhy  = new JTextField(20);
		jtEng = new JTextField(20);
		jtChi = new JTextField(20);
		jtPol = new JTextField(20);
		
		jlId.setBounds(130,10,60,25);
		jlGeo.setBounds(130,40,60,25);
		jlChe.setBounds(130,70,60,25);
		jlIT.setBounds(130,100,100,25);
		jlHis.setBounds(130,130,60,25);
		jlBio.setBounds(130,160,60,25);
		jlMath.setBounds(130,190,60,25);
		jlGen.setBounds(130,220,100,25);
		jlPhy.setBounds(130,250,60,25);
		jlEng.setBounds(130,280,60,25);
		jlChi.setBounds(130,310,60,25);
		jlPol.setBounds(130,340,60,25);
		
		jtId.setBounds(195,10,200,25);
		jtGeo.setBounds(195,40,200,25);
		jtChe.setBounds(195,70,200,25);
		jtIT.setBounds(235,100,160,25);
		jtHis.setBounds(195,130,200,25);
		jtBio.setBounds(195,160,200,25);
		jtMath.setBounds(195,190,200,25);
		jtGen.setBounds(235,220,160,25);
		jtPhy.setBounds(195,250,200,25);
		jtEng.setBounds(195,280,200,25);
		jtChi.setBounds(195,310,200,25);
		jtPol.setBounds(195,340,200,25);
		
		jbInsert.setBounds(130,400,120,25);
		jbAdmi.setBounds(275,400,120,25);
		
		p.add(jlId);
		p.add(jlGeo);
		p.add(jlChe);
		p.add(jlIT);
		p.add(jlHis);
		p.add(jlBio);
		p.add(jlMath);
		p.add(jlGen);
		p.add(jlPhy);
		p.add(jlEng);
		p.add(jlChi);
		p.add(jlPol);
		
		p.add(jtId);
		p.add(jtGeo);
		p.add(jtChe);
		p.add(jtIT);
		p.add(jtHis);
		p.add(jtBio);
		p.add(jtMath);
		p.add(jtGen);
		p.add(jtPhy);
		p.add(jtEng);
		p.add(jtChi);
		p.add(jtPol);

		p.add(jbInsert);
		p.add(jbAdmi);
		
		this.add(p);
		this.setLocation(200,100);
		this.setSize(500,550);
		this.setResizable(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	   jbInsert.addActionListener(new listener_of_insert());
	   jbAdmi.addActionListener(new AdministrationListener());
		
   }
   
   public class listener_of_insert implements ActionListener{
		   public void actionPerformed(ActionEvent e){
			   String id = jtId.getText();
			   DBUtil db = new DBUtil();
			   String sql1 = "update information_of_grade set geography = '"+jtGeo.getText()+"' where id = '"+id+"'";
			   String sql11 = "update information_of_grade set chemistry = '"+jtChe.getText()+"' where id = '"+id+"'";
			   String sql2 = "update information_of_grade set IT = '"+jtIT.getText()+"' where id = '"+id+"'";
			   String sql3 = "update information_of_grade set history = '"+jtHis.getText()+"' where id = '"+id+"'";
			   String sql4 = "update information_of_grade set mathematics = '"+jtMath.getText()+"' where id = '"+id+"'";
			   String sql5 = "update information_of_grade set general_technique = '"+jtGen.getText()+"' where id = '"+id+"'";
			   String sql6 = "update information_of_grade set physics = '"+jtPhy.getText()+"' where id = '"+id+"'";
			   String sql7 = "update information_of_grade set english = '"+jtEng.getText()+"' where id = '"+id+"'";
			   String sql8 = "update information_of_grade set chinese = '"+jtChi.getText()+"' where id = '"+id+"'";
			   String sql9 = "update information_of_grade set politics = '"+jtPol.getText()+"' where id = '"+id+"'";
			   String sql10 = "update information_of_grade set biology = '"+jtBio.getText()+"' where id = '"+id+"'";
			   
			   try {
				   db.getConnection();			  
				   db.executeUpdate(sql1, null);
				   db.executeUpdate(sql11,null);
				   db.executeUpdate(sql2, null);
				   db.executeUpdate(sql3, null);
				   db.executeUpdate(sql4, null);
				   db.executeUpdate(sql5, null);
				   db.executeUpdate(sql6, null);
				   db.executeUpdate(sql7, null);
				   db.executeUpdate(sql8, null);
				   db.executeUpdate(sql9,null);
				   db.executeUpdate(sql10,null);
			   } catch(Exception ee) {
				   System.out.println(ee.toString());
			   } finally {
				   db.closeAll();
			   }
			   JOptionPane.showMessageDialog(null, "�ɹ����Ŀ�����Ϣ");
		}
	}
   
   public class AdministrationListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Frame_Of_Update_Information.this.setVisible(false);
			new MainFrame_Of_Administration();
		}
	}
   
   public void setBak(){
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("images\\991.jpg"); 
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
	}
   
	public static void main(String agrs[]) {
			new Frame_Of_Update_Information();
	    }

}

