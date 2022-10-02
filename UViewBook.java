import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class UViewBook extends JFrame implements ActionListener
{
	//Declaring Label , TextField , Panel , ScrollPane , etc......
	JPanel p,ph,p1,ph1;
	JButton b;
	ImageIcon img;
	JScrollPane s;
	JTable t;
	JTableHeader header;
	String Data[][];
	String Head[]={"Book_Id","Book_Name","Publisher_Name","Published_Year","Book_Price","Quantity","Pages","Category","Shelf_No."};
	JLabel l1,lh,li;
	

	Connection con;
	ResultSet rs;
	Statement smt;

	public UViewBook()
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
		
	
		l1=new JLabel("LIBRARY BOOKS");
		l1.setBounds(10,5,180,30);
	
		l1.setForeground(Color.WHITE);
		l1.setFont(f1);
		ph1.add(l1);
		
		b=new JButton("BACK");
		b.setBounds(1200,130,100,40);
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setFont(f2);
		
		p.add(b);

		//panel
	
		p1=new JPanel();
		//p1.setBounds(30,150,1300,420);
		p1.setBounds(80,200,1200,400);
		p1.setBackground(new Color(221,221,221));
		p1.setLayout(new BorderLayout(20,20));
		p.add(p1);

		

	
		
	
		

		
		b.addActionListener(this);
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
			rs=smt.executeQuery("select * from books_detail");

			//count record
			int r=0;
			while(rs.next())
			{
				r++;
			}
			

			rs=smt.executeQuery("select * from books_detail");
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
			
			//table declearation and table header
			t=new JTable(Data,Head);
			t.setBounds(20,20,1200,300);
			//t.setBackground(new Color(221,221,221));
			p1.add(t);

			s=new JScrollPane(t);
			
			s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
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
			new UserPage();
			this.dispose();
		}

	}


public static void main(String ar[])
{
	new UViewBook();
}	
	

}