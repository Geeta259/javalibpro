import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class USearchBook  extends JFrame implements ActionListener
{
	
	JPanel p,p1,ph,ph1;
	JButton b,b1,b2;
	JScrollPane s;
	JTable t;
	JTableHeader header;
	String Data[][];
	String Head[]={"Book_Id","Book_Name","Publisher_Name","Published_Year","Book_Price","Quantity","Pages","Category","Shelf_No."};
	JLabel l,l1,l2,lh;
	//JTextField t1;
	JComboBox c1;
	String str;
	Font f,f1;

	Connection con;
	ResultSet rs;
	Statement smt;
	PreparedStatement ps;
	
	public USearchBook()
	{
		
		//p=new JPanel();
		this.setVisible(true);
		this.setTitle("Books Record");
		this.setSize(2000,2000);
	//	p.setLayout(null);
		this.setResizable(true);
		
			
		 p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,1500,800);
		//p.setBackground(Color.WHITE);
		p.setBackground(new Color(200,200,200));
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
		ph1.setBounds(0,130,180,40);
		ph1.setBackground(Color.BLACK);
	//	ph1.setBackground(new Color(221,221,221));
		p.add(ph1);
		
		/*img=new ImageIcon("img1.jpg");
		li=new JLabel(img);
		li.setBounds(0,7,20,20);
		ph1.add(li);*/
		
	
		l1=new JLabel("SEARCH BOOKS");
		l1.setBounds(10,5,180,30);
	
		l1.setForeground(Color.WHITE);
		l1.setFont(f1);
		ph1.add(l1);
		
		b=new JButton("BACK");
		b.setBounds(1200,130,100,40);
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.addActionListener(this);
		b.setFont(f2);
		
		p.add(b);


	
		c1=new JComboBox();
		c1.addItem("Select Category");
		c1.addItem("computer");
		c1.addItem("science");
		c1.addItem("hindi");
		c1.addItem("math");
		c1.addItem("english");
		c1.setBounds(560,250,200,30);
		
		c1.addItemListener(new ItemListener()
				{
					public void itemStateChanged(ItemEvent v)
					{
						
						//	str=(String)c1.getSelectedItem();
					}
				});
				
			/*t1=new JTextField();
			t1.setBounds(560,250,200,30);
			l.add(t1);*/
				
				
				
		lh=new JLabel("BOOK_CATEGORY");
		lh.setBounds(350,250,200,30);
		
		f1=new Font("Arial",Font.BOLD,20);
		
		lh.setFont(f1);
		
		
		//t1=new JTextField();
		//t1.setBounds(560,250,200,30);
		
		b1=new JButton("SEARCH");
		b1.setBounds(800,250,100,30);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
	
		b2=new JButton("CLEAR");
		b2.setBounds(600,500,100,30);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
	

		
		p.add(c1);
		p.add(lh);
		p.add(b1);
		p.add(b2);

	
		//panel
	
		p1=new JPanel();
		//p1.setBounds(30,150,1300,420);
		p1.setBounds(80,300,1200,200);
		p1.setBackground(new Color(221,221,221));
		p1.setLayout(new BorderLayout(20,20));
		p.add(p1);

		
		connect();
	}
	
	public void connect()
	{
		try
		{
			//for connect into database

			Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","mysqlpasswd@25");
		
			//query
			smt=con.createStatement();
			ps=con.prepareStatement("select * from books_detail where category=?");
			
		}catch(Exception ex)
		{
			System.out.println(ex);
			
		}
	}

 public void srch()
 { 
 
 
	try
	{
	
		ps.setString(1,(String)c1.getSelectedItem());
	
		rs=ps.executeQuery();
		
			//count record
			int r=0;
			while(rs.next())
			{
				r++;
			}
			
			
	
			rs=ps.executeQuery();
			Data = new String[r][9];
			
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
				Data[i][j]=rs.getString(9);
				j++;


				i++;
				j=0;
			}
					//panel
	
			//table declearation and table header
			t=new JTable(Data,Head);
			t.setBounds(10,10,1300,150);
			p1.add(t);

			s=new JScrollPane(t);
			
			s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
			p1.add(s);
			
			header= t.getTableHeader();
			header.setBackground(Color.WHITE);
			header.setFont(new Font ("Arial",Font.BOLD,16));

		c1.setEnabled(false);
		

		}catch(Exception ae)
		{
			System.out.println(ae);
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
			
			srch();
		}
		if(o==b2)
		{
			new USearchBook();
			this.dispose();
			
		}

	}





public static void main(String ar[])
{
	new USearchBook();
}	
	

}
		
		
	

