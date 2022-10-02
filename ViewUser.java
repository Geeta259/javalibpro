import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class ViewUser extends JFrame implements ActionListener
{
	//Declaring Label , TextField , Panel , ScrollPane , etc......
	JPanel p,ph,ph1,p1;
	JButton b;
	JScrollPane s;
	JTable t;
	JTableHeader header;
	String Data[][];
	String Head[]={"Name","Password","Gender","D-O-B","Address","City","E-Mail","Contact"};
	JLabel l,l1,l2,lh;
	Font f;

	Connection con;
	ResultSet rs;
	Statement smt;
	

	public ViewUser()
	{
		
		this.setVisible(true);
		this.setTitle("Member's Record");
		this.setSize(2000,2000);
		this.setResizable(true);
	
		
	
		
		
			
		 p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,1500,800);
		//p.setBackground(Color.WHITE);
		p.setBackground(new Color(200,200,200));
		this.add(p);
		
		
		this.add(p);
		
		

	
	
		ph=new JPanel();
		ph.setLayout(null);
		ph.setBounds(0,60,1500,50);
		ph.setBackground(new Color(221,221,221));
		p.add(ph);
		
		
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
		ph1.setBounds(0,150,220,40);
		ph1.setBackground(Color.BLACK);
	//	ph1.setBackground(new Color(221,221,221));
		p.add(ph1);
		
		
	
		l1=new JLabel("LIBRARY MEMBERS");
		l1.setBounds(12,5,220,30);
	
		l1.setForeground(Color.WHITE);
		l1.setFont(f1);
		ph1.add(l1);
		
		b=new JButton("BACK");
		b.setBounds(1200,150,100,40);
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setFont(f2);
		
		
		b.addActionListener(this);
		
		p.add(b);
	
	

		//panel
		p1=new JPanel();
		p1.setBounds(40,250,1300,250);
		
		p1.setLayout(new BorderLayout(12,12));
		p1.setBackground(new Color(221,221,221));
		p.add(p1);
	
		

		getTable();
	}
	
	public void getTable()
	{
		try
		{
			//for connect into database

			Class.forName("oracle.jdbc.driver.OracleDriver");
		   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			

			//query
			smt=con.createStatement();
			rs=smt.executeQuery("select * from members");

			//count record
			int r=0;
			while(rs.next())
			{
				r++;
			}
			

			rs=smt.executeQuery("select * from members");
			Data = new String[r][8];
			
			int j,i;
			i=j=0;
			
			while(rs.next())
			{
				
				Data[i][j]=rs.getString(1);
				j++;
				Data[i][j]=rs.getString(2);
				j++;
				Data[i][j]=rs.getString(3);
				j++;
				Data[i][j]=rs.getString(4);
				j++;
				Data[i][j]=rs.getString(5);
				j++;
				Data[i][j]=rs.getString(6);
				j++;
				Data[i][j]=rs.getString(7);
				j++;
				Data[i][j]=rs.getString(8);
				j++;
			
				i++;
				j=0;
			}
			
			//table declearation and table header
			t=new JTable(Data,Head);
			t.setBounds(40,250,1300,250);
			p1.add(t);

			s=new JScrollPane(t);
			
			s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			
			p1.add(s);
			
			header= t.getTableHeader();
			header.setBackground(new Color(211,211,211));
			header.setForeground(Color.BLACK);
			header.setFont(new Font ("Arial",Font.BOLD,18));
		

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
	new ViewUser();
}	
	

}