import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;

class DeleteBook extends JFrame implements ActionListener
{
	JPanel p,ph,p1,p2;
	ImageIcon img;
	JLabel  limg,l,l1,l2,lh,Bk_id,Bk_Nm,Bk_P_Nm,Bk_P_Y,Bk_Price,Bk_Q,Bk_pg,Bk_C,Bk_S;;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,ts;
	Font f,f1,f2;
	
	JButton b1,b2,b3,b4;
	int count=0;
	String str;
	 //for database connectivity variable
	Connection con;
	PreparedStatement ps,ps1;
	ResultSet rs;
	Statement s;
	
	public DeleteBook ()
	{
		
		
		this.setResizable(true);
		this.setVisible(true);
		this.setTitle("UPDATE BOOKS");
		this.setSize(2000,2000);
		
		this.setResizable(true);
		
		
		 p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,1500,1000);
		//p.setBackground(Color.WHITE);
		p.setBackground(new Color(200,200,200));
	
		img=new ImageIcon("book.jpg");
		l=new JLabel(img);
		l.setLayout(null);
		l.setBounds(-10,-50,1500,800);
		this.add(p);
		p.add(l);
		

	
		ph=new JPanel();
		ph.setLayout(null);
		ph.setBounds(0,70,1500,50);
		ph.setBackground(new Color(221,221,221));
		l.add(ph);
		
		
		Font f=new Font("ArialBlack",Font.BOLD,32);
		Font ff=new Font("ArialBlack",Font.BOLD,26);
		Font f1=new Font("ArialBlack",Font.BOLD,20);
		Font f2=new Font("ArialBlack",Font.BOLD,15);
		
		
		lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lh.setBounds(430,10,800,30);
		lh.setForeground(Color.BLACK);
		lh.setFont(f);
		ph.add(lh);

	
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(420,160,520,580);
		p1.setBackground(new Color(221,221,221));
		
	
		l.add(p1);
		
			
		//label
		l1=new JLabel("REMOVE BOOK ");
		l1.setBounds(150,10,700,40);
		l1.setFont(ff);
		
		p1.add(l1);
		
		
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(10,60,500,50);
		p2.setBackground(new Color(211,211,211));
		p1.add(p2);
		
		
		
	//set label 

		Bk_id=new JLabel("ENTER BOOK ID");
		Bk_id.setBounds(10,0,200,50);
		Bk_id.setFont(f1);
		p2.add(Bk_id);
		
		ts=new JTextField();
		ts.setBounds(200,10,120,30);
		ts.setFont(f2);
		p2.add(ts);

		b1=new JButton("SEARCH");
		b1.setBounds(350,10,100,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		p2.add(b1);
		b1.addActionListener(this);

		
	

	

	
	
	
		Bk_Nm=new JLabel("BOOK NAME");
		Bk_Nm.setBounds(20,150,200,30);
		Bk_Nm.setFont(f1);
		
		Bk_P_Nm=new JLabel("BOOK PUBLISHER NAME");
		Bk_P_Nm.setBounds(20,200,250,30);
		Bk_P_Nm.setFont(f1);

		Bk_P_Y=new JLabel("BOOK PUBLISHED YEAR");
		Bk_P_Y.setBounds(20,250,250,30);
		Bk_P_Y.setFont(f1);

		Bk_Price=new JLabel("BOOK PRICE");
		Bk_Price.setBounds(20,300,200,30);
		Bk_Price.setFont(f1);

		Bk_Q=new JLabel("BOOK QUANTITY");
		Bk_Q.setBounds(20,350,200,30);
		Bk_Q.setFont(f1);	

		Bk_pg=new JLabel("BOOK PAGES");
		Bk_pg.setBounds(20,400,200,30);
		Bk_pg.setFont(f1);	
	
		Bk_C=new JLabel("BOOK CATEGORY");
		Bk_C.setBounds(20,450,200,30);
		Bk_C.setFont(f1);	
	
		Bk_S=new JLabel("BOOK SHELF");
		Bk_S.setBounds(20,500,200,30);
		Bk_S.setFont(f1);	

		//setTextField
	
		t1=new JTextField();
		t1.setBounds(300,150,200,30);
		t1.setFont(f2);	
		t1.setEditable(false);
		
		t2=new JTextField();
		t2.setBounds(300,200,200,30);
		t2.setFont(f2);
		t2.setEditable(false);
		
		t3=new JTextField();
		t3.setBounds(300,250,200,30);
		t3.setFont(f2);
		t3.setEditable(false);

		t4=new JTextField();
		t4.setBounds(300,300,200,30);
		t4.setFont(f2);
		t4.setEditable(false);
		
		t5=new JTextField();
		t5.setBounds(300,350,200,30);
		t5.setFont(f2);
		t5.setEditable(false);
	
		t6=new JTextField();
		t6.setBounds(300,400,200,30);
		t6.setFont(f2);
		t6.setEditable(false);

		
		t7=new JTextField();
		t7.setBounds(300,450,200,30);
		t7.setFont(f2);
		t7.setEditable(false);

		t8=new JTextField();
		t8.setBounds(300,500,200,30);
		t8.setFont(f2);
		t8.setEditable(false);

		
		
		//setButton
		

		b2=new JButton("DELETE");
		b2.setBounds(50,540,100,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

			
		b3=new JButton("CLEAR");
		b3.setBounds(200,540,100,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		
		
		b4=new JButton("BACK");
		b4.setBounds(350,540,100,30);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.addActionListener(this);


		

		//set all label,textfield and button in to panel
		
		
	
		p1.add(Bk_Nm);
		p1.add(Bk_P_Nm);
		p1.add(Bk_P_Y);
		p1.add(Bk_Price);
		p1.add(Bk_Q);
		p1.add(Bk_pg);
		p1.add(Bk_C);
		p1.add(Bk_S);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		p1.add(t7);
		p1.add(t8);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);
	
		
		
		
		connec();
		}

	public void connec()
	{
		try
		{

			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","mysqlpasswd@25");
			
		s=con.createStatement();
		ps=con.prepareStatement("Select * from books_detail where id=?");
		
		}catch(Exception ae)
		{
			System.out.println(ae);
		
		}
	}
	

		
public void actionPerformed(ActionEvent e)
{
	Object o =e.getSource();
	
	if(o==b1)
	{
		//get all deatils based on bid
		String st =ts.getText();
		search(st);
	}
	if(o==b2)
	{
		delete();
	}
	if(o==b3)
	{
		
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
			t6.setText(" ");
			t7.setText(" ");
			t8.setText(" ");
			ts.setText(" ");
			ts.setEditable(true);
	}
	if(o==b4)
	{
		new AdminPage();
		this.dispose();
	}

}

public void  search(String st)
{
	try
	{
		ps.setString(1,st);
		rs=ps.executeQuery();
		
		if(rs.next())
	{
		rs=ps.executeQuery();
		while(rs.next())
		{
			
			t1.setText(rs.getString(2));
			t2.setText(rs.getString(3));
			t3.setText(rs.getString(4));
			t4.setText(rs.getString(5));
			t5.setText(rs.getString(6));
			t6.setText(rs.getString(7));
			t7.setText(rs.getString(8));					
			t8.setText(rs.getString(9));

			
			t1.setEditable(false);
			t2.setEditable(false);
			t3.setEditable(false);
			t4.setEditable(false);
			t5.setEditable(false);
			t6.setEditable(false);
			t7.setEditable(false);
			t8.setEditable(false);
			
			

		}
	}
	else
	{
		JOptionPane.showMessageDialog(this,"This Book Record Does NOT Exist In Database");
	
	}

	}catch(Exception ec)
	{
		System.out.println(ec);
	}

}

public void delete()
{
	try
	{
		int c;
		c=JOptionPane.showConfirmDialog(this,"Are You Sure ! You Want To Delete This Book Record Permanently?","Confirm Message",JOptionPane.YES_NO_OPTION);
	
		if(c==0)
		{
			ps1=con.prepareStatement("Delete  from books_detail where id=?");
			ps1.setString(1,ts.getText());
			ps1.executeUpdate();
			JOptionPane.showMessageDialog(this,ts.getText()+"Book Record Delete Successfully");

			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
			t6.setText(" ");
			t7.setText(" ");
			t8.setText(" ");
			ts.setText(" ");
		}
		


	}catch(Exception e)
	{
		System.out.println(e);
	}



}

public static void main(String ar[])
{

		new  DeleteBook();
}
}