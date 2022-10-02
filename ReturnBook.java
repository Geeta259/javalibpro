import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.*;
import java.text.SimpleDateFormat;


class ReturnBook extends JFrame implements ActionListener
{
	JPanel p,ph,p1,p2;
	ImageIcon img;
	JLabel l,l1,l2,lh,U_Nm,U_passwd,Bk_Nm,Bk_Author,Isue_Dt,Period,Return_Dt;
	JTextField t,ts,t1,t2,t3,t4,t5,t6;
	JButton b,b1,b2,b3;
	Font f,f1,f2;

	//for database connectivity variable
	Connection con;
	PreparedStatement smt,ps1;
	ResultSet rs1;
	Statement s;

	public ReturnBook()
	{
		this.setVisible(true);
		this.setTitle("ISSUE BOOKS");
		this.setSize(2000,1000);
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
		p1.setBounds(420,200,520,500);
		p1.setBackground(new Color(221,221,221));
		
	
		l.add(p1);
		
		

	
		//label
		l1=new JLabel("RETURN BOOK ");
		l1.setBounds(160,10,850,30);
		
		l1.setFont(ff);
		
		
		p1.add(l1);
		
			
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(10,60,500,40);
		p2.setBackground(new Color(211,211,211));
		p1.add(p2);
		
		
		t=new JTextField("Enter Name");
		t.setBounds(10,5,150,30);
		t.setFont(f2);
		p2.add(t);

		
		ts=new JTextField("Enter Book_Name ");
		ts.setBounds(200,5,150,30);
		ts.setFont(f2);
		p2.add(ts);

		b=new JButton("SELECT");
		b.setBounds(370,5,100,30);
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		p2.add(b);
		b.addActionListener(this);
		
		
		U_Nm=new JLabel("User_Name :");
		U_Nm.setBounds(20,130,200,30);
		U_Nm.setFont(f1);
		
		Bk_Nm=new JLabel("Book_Name : ");
		Bk_Nm.setBounds(20,180,200,30);
		Bk_Nm.setFont(f1);

		Bk_Author =new JLabel("Book_Author :");
		Bk_Author.setBounds(20,230,200,30);
		Bk_Author.setFont(f1);

		Isue_Dt=new JLabel("Issued_Date : ");
		Isue_Dt.setBounds(20,280,200,30);
		Isue_Dt.setFont(f1);
		
		Period=new JLabel("Period");
		Period.setBounds(20,330,200,30);
		Period.setFont(f1);
		
		Return_Dt=new JLabel("Return_Date :  ");
		Return_Dt.setBounds(20,380,200,30);
		Return_Dt.setFont(f1);


		//set Text Field
		
		t1=new JTextField();
		t1.setBounds(300,130,200,30);
		t1.setEditable(false);
		t1.setFont(f2);
		
		
		t2=new JTextField();
		t2.setBounds(300,180,200,30);
		t2.setEditable(false);
		t2.setFont(f2);

		
		t3=new JTextField();
		t3.setBounds(300,230,200,30);
		t3.setEditable(false);
		t3.setFont(f2);

		
		t4=new JTextField();
		t4.setBounds(300,280,200,30);
		t4.setEditable(false);
		t4.setFont(f2);

		
		t5=new JTextField();
		t5.setBounds(300,330,200,30);
		t5.setEditable(false);
		t5.setFont(f2);

		
		t6=new JTextField("YYYY/MM/DD");
		t6.setBounds(300,380,200,30);
		//t6.setEditable(false);
		t6.setFont(f2);

		//set Button
		
		b1=new JButton("RETURN");
		b1.setBounds(60,440,80,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b1.addActionListener(this);

		b2=new JButton("CLEAR");
		b2.setBounds(210,440,80,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

		b3=new JButton("BACK");
		b3.setBounds(360,440,80,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);

		
		//set all labels , textfields and buttons in to panel

		
		p1.add(Bk_Nm);
		p1.add(Isue_Dt);
		p1.add(U_Nm);
		p1.add(Return_Dt);
		p1.add(Bk_Author);
		p1.add(Period);

		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);

		p1.add(b1);
		p1.add(b2);
		p1.add(b3);

		connect();
	}
	
	public void connect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
				
							
			ps1=con.prepareStatement("select u_name,bk_name,publisher,isue_dt,period from view_issue where u_name=? and bk_name=?");
			smt=con.prepareStatement("delete from view_issue where u_name=? and bk_name=?");
			
			
		}catch(Exception ae)
		{
		JOptionPane.showMessageDialog(null,"NOT ANY BOOK ISSUED");
		t1.setText(" ");
		t2.setText(" ");
		t3.setText(" ");
		t4.setText(" ");
		t5.setText(" ");
		t6.setText(" ");
		
		}                                                                            
	}


	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		
		if(o==b)
		{
			try
			{
					ps1.setString(1,t.getText());
					ps1.setString(2,ts.getText());
					rs1=ps1.executeQuery();
					
					if(rs1.next())
					{
						t1.setText(rs1.getString(1));
						t2.setText(rs1.getString(2));
						t3.setText(rs1.getString(3));
						t4.setText(rs1.getString(4));
						t5.setText(rs1.getString(5));
			
						
					}
					else
					{
						JOptionPane.showMessageDialog(this,"This book not issued by this user!!!");
						
					}
			}catch(Exception e)
			{
				System.out.println(e);
			}
		
		}
		
		if(o==b1)
		{
				try
				{
							
						
								if(t6.getText().length()==0)
								JOptionPane.showMessageDialog(null,"Enter Return Date,It field should not be blank!! ");
	
								else
								check();

					
			}catch(Exception e)
				{
					
					System.out.println(e);
				}
		}

		if(o==b2)
		{
			t.setText(" ");
			ts.setText(" ");
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
			t6.setText(" ");		

		}
		if(o==b3)
		{
			new UserPage();
			this.dispose();
		}
	}


	public void check()
	{
		
					try
					{
						String date1=rs1.getString(4);
						String date2=t6.getText();
					
						
				
						
						
						
							Date d1=new SimpleDateFormat("yyyy-mm-dd").parse(date1);
                            Date d2=new SimpleDateFormat("yyyy-mm-dd").parse(date2);
							
						
                            //subtract the dates and store in diff
                            long diff =d2.getTime()-d1.getTime();
						 
						
								
								float days=TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
								
								
							
							int p =Integer.parseInt(t5.getText());
								
							
							if(days>p)
							{
								float fn =(days-p)*10;
								String fine=("Fine: Rs."+fn); 
								JOptionPane.showMessageDialog(null,fine);
								
							}
							
							return_book();
								
							
						}catch(Exception e)
							{
								System.out.println(e);
							}
					
		
		
	}
	public void return_book()
	{
		try
		{
			
			
					
						int i;
						i=JOptionPane.showConfirmDialog(this,"Are You Sure!! You  Want To Return This Book? ","Confirm Message",JOptionPane.YES_NO_OPTION);
						
								if(i==0)
								{
									
									
									
									smt.setString(1,t.getText());
									smt.setString(2,ts.getText());
							
											smt.executeUpdate();
						
									JOptionPane.showMessageDialog(this,t.getText()+"Successfully Returned Book!!");
								}
						
			
		

		}catch(Exception e)
		{
			System.out.println(e);
		}


	}

	public static void main(String args[])
	{
		new ReturnBook();
	}
}