import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

class UBook extends JFrame implements ActionListener
{

	JPanel p,ph,ph1,p1,p2;
	ImageIcon img;
	JLabel l,lh,l1,l2;
	String Head[]={"U_NAME","U_PASSWORD","BOOK_NAME","PUBLISHER_NAME","ISSUE_DATE","PERIOD"};
	String data[][];
	JButton b,b1;
	JTextField t1,t2;
	JScrollPane s;
	JTable t;
	JTableHeader header;
	Font f;
	
	//for connect into database
	Connection con;
	Statement smt;
	PreparedStatement ps;
	ResultSet  rs;
	
	
	public UBook()
	{
		this.setVisible(true);
		this.setTitle("Books Record");
		this.setSize(2000,2000);
		
		//setPanel
		
		
				
		 p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,1500,800);
		//p.setBackground(Color.WHITE);
		p.setBackground(new Color(200,200,200));
		this.add(p);
		
		
		img=new ImageIcon("book.jpg");
		l=new JLabel(img);
		l.setLayout(null);
		l.setBounds(-10,-50,1500,800);
		this.add(p);
		p.add(l);
		
		
		
		
		

	
	
		ph=new JPanel();
		ph.setLayout(null);
		ph.setBounds(0,60,1500,50);
		ph.setBackground(new Color(221,221,221));
		l.add(ph);
		
		
		Font f=new Font("ArialBlack",Font.BOLD,32);
		Font f1=new Font("ArialBlack",Font.BOLD,20);
		Font f2=new Font("ArialBlack",Font.BOLD,15);
		
		lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lh.setBounds(430,10,800,30);
		lh.setForeground(Color.BLACK);
		lh.setFont(f);
		ph.add(lh);

		
		ph1=new JPanel();
		ph1.setLayout(null);
		ph1.setBounds(0,150,200,40);
		ph1.setBackground(Color.BLACK);
	//	ph1.setBackground(new Color(221,221,221));
		l.add(ph1);
		
		
	
		l1=new JLabel("ISSUED BOOKS ");
		l1.setBounds(20,5,200,30);
	
		l1.setForeground(Color.WHITE);
		l1.setFont(f1);
		ph1.add(l1);
		
		b=new JButton("BACK");
		b.setBounds(1200,150,100,40);
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setFont(f2);
		
		
		b.addActionListener(this);
		
		l.add(b);
	
	
		
			
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(400,240,600,50);
		p2.setBackground(new Color(211,211,211));
		l.add(p2);
		
		
		
	
		t1=new JTextField("Your Name :");
		t1.setBounds(10,10,200,30);
		t1.setFont(f2);
		p2.add(t1);
		
		t2=new JTextField("Your Password :");
		t2.setBounds(230,10,200,30);
		t2.setFont(f2);
		p2.add(t2);
	
	
		b1=new JButton("SELECT");
		b1.setBounds(450,10,100,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(f2);

		b1.addActionListener(this);
		p2.add(b1);
	
		//panel
		p1=new JPanel();
		p1.setBounds(150,300,1000,200);
		
		p1.setLayout(new BorderLayout(12,12));
		p1.setBackground(new Color(221,221,221));
		l.add(p1);
	
			getTable();
	
	}
	
	public void getTable()
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","mysqlpasswd@25");
			
			//query
			//query
			smt=con.createStatement();
			ps=con.prepareStatement("select * from view_issue where name=? and password=?");
			
		}catch(Exception e)
			{
				
				System.out.println(e);
				
			}
		
	}

public void getBk()
{
		try
		{
		
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				
				rs=ps.executeQuery();
		
			//count record
			
			int r=0;
			while(rs.next())
			{
				r++;
				
			}
			
			
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				
				rs=ps.executeQuery();
		
			data=new String[r][6];
			
			int i,j;
			i=j=0;
			while(rs.next())
			{
				data[i][j]=rs.getString(2);
				j++;
				data[i][j]=rs.getString(3);
				j++;
				data[i][j]=rs.getString(4);
				j++;
				data[i][j]=rs.getString(5);
				j++;
				data[i][j]=rs.getString(6);
				j++;
				data[i][j]=rs.getString(7);
				j++;
				
			
				
				
				i++;
				j=0;
				
				
				
			}
			
			//table declarartion 
			t=new JTable(data,Head);
			t.setBounds(20,20,1000,200);
			p1.add(t);

			s=new JScrollPane(t);
			
			s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			p1.add(s);
			
			header= t.getTableHeader();
			header.setBackground(new Color(211,211,211));
			header.setFont(new Font ("Arial",Font.BOLD,16));
			
			
			
			
				
		
		
		
		}catch(Exception ex)
		{
			System.out.println(ex);
				
		}
	
}

public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if(o==b)
		{
			new UserPage();
			this.dispose();
		}
		if(o==b1)
		{
			t1.setEditable(false);
			t2.setEditable(false);
			getBk();
		}
	}

public static void main(String ar[])
{
	
	new UBook();
	
}



}