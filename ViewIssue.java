import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

class ViewIssue extends JFrame implements ActionListener
{

	JPanel p,ph,ph1,p1;
	ImageIcon img;
	JLabel l,lh,l1,l2;
	String Head[]={"U_NAME","U_PASSWORD","BOOK_NAME","PUBLISHER_NAME","ISSUE_DATE","PERIOD"};
	String data[][];
	JButton b;
	JScrollPane s;
	JTable t;
	JTableHeader header;
	Font f;
	
	//for connect into database
	Connection con;
	Statement smt;
	ResultSet  rs;
	
	
	public ViewIssue()
	{
		this.setVisible(true);
		this.setTitle("ISSUE BOOKS");
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
		l1.setBounds(17,5,200,30);
	
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
	
	

		//panel
		p1=new JPanel();
		p1.setBounds(200,250,1000,200);
		
		p1.setLayout(new BorderLayout(12,12));
		p1.setBackground(new Color(221,221,221));
		l.add(p1);
	
			getTable();
	
	}
	
	public void getTable()
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			
			//query
			smt=con.createStatement();
			rs=smt.executeQuery("select * from view_issue");
			
			//count record
			
			int r=0;
			while(rs.next())
			{
				r++;
				
			}
			
			rs=smt.executeQuery("select * from view_issue");
			data=new String[r][6];
			
			int i,j;
			i=j=0;
			while(rs.next())
			{
				data[i][j]=rs.getString(1);
				j++;
				data[i][j]=rs.getString(6);
				j++;
				data[i][j]=rs.getString(2);
				j++;
				data[i][j]=rs.getString(3);
				j++;
				data[i][j]=rs.getString(4);
				j++;
				data[i][j]=rs.getString(5);
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
			
			
			
			
			
		}catch(Exception e)
			{
				
				System.out.println(e);
				
			}
		
		
		
	}



public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		if(o==b)
		{
			new AdminPage();
			this.dispose();
		}

	}

public static void main(String ar[])
{
	
	new ViewIssue();
	
}



}