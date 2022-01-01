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


public class Frame_Of_Insert_Information extends JFrame {
	
	 private JPanel p;
	 private Clipboard clipboard = null;
	 private JButton jlId,jlGeo,jlChe,jlIT,jlHis,jlBio,jlMath,jlGen,jlPhy,jlEng,jlChi,jlPol;
	 private JButton jbInsert,jbAdmi;
	 private JTextField jtId,jtGeo,jtChe,jtIT,jtHis,jtBio,jtMath,jtGen,jtPhy,jtEng,jtChi,jtPol;
	
   public Frame_Of_Insert_Information(){
	   super("添加考生信息");
		ImageIcon qstIcon = new ImageIcon("images\\1.png");
		this.setIconImage(qstIcon.getImage());
		p = new JPanel();
		setBak();
		clipboard=getToolkit().getSystemClipboard();
		Container c = getContentPane();
		p.setOpaque(false);
		c.add(p);
		p.setLayout(null);
	    
		jlId = new JButton("考号");
		jlGeo = new JButton("地理");
		jlChe  = new JButton("化学");
	    jlIT = new JButton("信息技术");
		jlHis = new JButton("历史");
		jlBio = new JButton("生物");
		jlMath = new JButton("数学");
		jlGen = new JButton("通用技术");
		jlPhy  = new JButton("物理");
	    jlEng = new JButton("英语");
		jlChi = new JButton("语文");
		jlPol = new JButton("政治");
		
		jbInsert = new JButton("添加考生信息");
		jbAdmi = new JButton("返回管理界面");
		
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
			   DBUtil db = new DBUtil();
			   String preparedsql = "insert into information_of_grade(id,geography,chemistry,IT,history,biology,mathematics,general_technique,physics,english,chinese,politics)"+"values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			   try {
				   db.getConnection();
				   Object param[] = {jtId.getText(),jtGeo.getText(),jtChe.getText(),jtIT.getText(),jtHis.getText(),jtBio.getText(),jtMath.getText(),jtGen.getText(),jtPhy.getText(),jtEng.getText(),jtChi.getText(),jtPol.getText()};
				   db.executeUpdate(preparedsql, param);
			   } catch(Exception ee) {
				   System.out.println(ee.toString());
			   } finally {
				   db.closeAll();
			   }
			   JOptionPane.showMessageDialog(null, "成功添加考生信息");
		}
	}
   
   public class AdministrationListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Frame_Of_Insert_Information.this.setVisible(false);
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
			new Frame_Of_Insert_Information();
	    }

}
