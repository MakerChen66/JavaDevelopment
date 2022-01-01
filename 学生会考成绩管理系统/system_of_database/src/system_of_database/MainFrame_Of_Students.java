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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Font;
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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.awt.datatransfer.*;

public class MainFrame_Of_Students extends JFrame{
	
	 private JPanel p,p1;
	 private JButton JBid,JBTime,JBCode,JBOut,JBAdmi;
	 private JTextField txtId;
	 private JTextArea jt1;
	 private Clipboard clipboard = null;
	 private JScrollPane sp;
	 private DefaultTableModel model;
	 final private JTable table;
	 private JComboBox cmbExamTime;
	 
	public MainFrame_Of_Students() {
		super("Examinee");
		ImageIcon qstIcon = new ImageIcon("images\\1.png");
		this.setIconImage(qstIcon.getImage());
		p = new JPanel();
		p1 = new JPanel();
		setBak();
		clipboard=getToolkit().getSystemClipboard();
		Container c = getContentPane();
		p.setOpaque(false);
		p1.setOpaque(false);
		c.add(p);
		c.add(p1);
	//	p.setLayout(null);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sp = new JScrollPane(table);
		this.add(sp,BorderLayout.CENTER);
		JBid = new JButton("按考生号查询");
		JBTime = new JButton("考试时间");
		JBCode = new JButton("修改密码");
		JBOut = new JButton("导出");
		JBAdmi = new JButton("返回登录界面");
	    txtId = new JTextField(15);
	    jt1 = new JTextArea();
	    cmbExamTime = new JComboBox(new String[]{"2017","2018","2019","2020"});
	    
	/*  JBid.setBounds(0,20,120,25);
	    txtId.setBounds(125,20,90,25);
	    JBTime.setBounds(220,20,90,25);
	    cmbExamTime.setBounds(315,20,60,25);
	    jt1.setBounds(0,50,560,200);             */
		
	    p.add(JBid);
	    p.add(txtId);
	    p.add(JBTime);
	    p.add(cmbExamTime);
	    p.add(JBCode);
	//  p.add(jt1);
		this.add(p,BorderLayout.NORTH);
		
		p1.add(JBOut);
		p1.add(JBAdmi);
		this.add(p1,BorderLayout.SOUTH);
		
		this.setLocation(200,100);
		this.setSize(550,390);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JBid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData();
			}
		});
		
		JBAdmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame_Of_Students.this.setVisible(false);
				new LoginFrame_Of_Students();
			}
		});
		
		JBCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame_Of_Students.this.setVisible(false);
				new Frame_Of_Update_Code();
			}
		});
		
		JBOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
	}
		
	public void setBak(){
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("images\\2.jpg"); 
		JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		}
	
/*	public void showData() {
		String sql = "select id,geography,chemistry,IT,history,biology,mathematics,general_technique,physics,english,chinese,politics from information_of_grade";
		DBUtil db = new DBUtil();
		try {
			db.getConnection();
			ResultSet rs = db.executeQuery(sql, null);
			while(rs.next()) {
				if(rs.getString(1).equals(txtId.getText())){
					String str =(rs.getString("geography")+"    "+rs.getString("chemistry")+"     "+rs.getString("IT")+"             "+rs.getString("history")+"      "+rs.getString("biology")
					              +"      "+rs.getString("mathematics")+"       "+rs.getString("general_technique")+"            "+rs.getString("physics")+"       "+rs.getString("english")+"     "+rs.getString("chinese")
					              +"    "+rs.getString("politics"));
					jt1.setText("地理" + "   " + "化学" + "   " + "信息技术" + "   " + "历史" + "   "
					             + "生物" + "   " + "数学" + "   " + "通用技术" + "   "+ "物理" + "   " + "英语" + "   "
							     + "语文" + "   " + "政治");
					String str1 =jt1.getText();
			  		String s = str1+"\n"+str;
			  		jt1.setText(s);
			  		jt1.setFont(new Font(str,10,15));
				}
			}
		} catch(Exception ee) {
			System.out.println(ee.toString());
			JOptionPane.showMessageDialog(this, "系统出现异常错误。请检查数据库。系统即将推出！！！","错误",0);
		} finally {
			db.closeAll();
		}
		JOptionPane.showMessageDialog(null, "查询到该考生信息");
	}      */
	
	private void showData() {
		String id = txtId.getText();
		String sql = "select id as 考生号,geography as 地理,chemistry as 化学,IT as 信息技术,History as 历史 ,Biology as 生物,mathematics as 数学,general_technique as 通用技术,physics as 物理,english as 英语,chinese as 语文,politics as 政治  from information_of_grade where id = '"+id+"'";
		DBUtil db = new DBUtil();
		try {
			db.getConnection();
			ResultSet rs = db.executeQuery(sql, null);
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			Vector<String> title = new Vector<String>();  //存放标题
			for(int i = 1;i<=colCount;i++) {
				title.add(rsmd.getColumnLabel(i));
			}
			Vector<Vector<String>> data = new Vector<Vector<String>>();    //存放表格数据
			int rowCount = 0;
			while(rs.next()) {
				rowCount++;
				Vector<String> rowdata = new Vector<String>();         //存放行数据
				for(int i = 1;i<=colCount;i++) {
					rowdata.add(rs.getString(i));
				}
				data.add(rowdata);
			}
			if(rowCount == 0) {
				model.setDataVector(null, title);
			} else {
				model.setDataVector(data,title);
			}
		} catch(Exception ee) {
			System.out.println(ee.toString());
			JOptionPane.showMessageDialog(this, "系统出现异常错误。请检查数据库。系统即将推出！！！","错误",0);
		} finally {
			db.closeAll();
		}
		JOptionPane.showMessageDialog(null, "查询到该考生信息");
	}
	
	public void saveFile() {
		JFileChooser fc = new JFileChooser();
		int rVal = fc.showSaveDialog(this);
		if(rVal == JFileChooser.APPROVE_OPTION) {
			String fileName = fc.getSelectedFile().getName();
			String path = fc.getCurrentDirectory().toString();
			try {
				TableModel model = table.getModel(); 
				FileWriter fw = new FileWriter(path + "/" + fileName);
				for(int i=0; i < model.getColumnCount(); i++) { 
		            fw.write(model.getColumnName(i) + "\t"); 
		        } 
		        fw.write("\n"); 
		        for(int i=0; i< model.getRowCount(); i++) { 
		            for(int j=0; j < model.getColumnCount(); j++) { 
		                fw.write(model.getValueAt(i,j).toString()+"\t"); 
		            } 
		            fw.write("\n");
		        } 
				fw.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "导出成功");
		}
	}
	
	public static void main(String agrs[]) {
		new MainFrame_Of_Students();
	}

}

