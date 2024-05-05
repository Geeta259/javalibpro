import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;


class IssueBook extends JFrame implements ActionListener
{
	JPanel p,ph,p1,p2;
	ImageIcon img;
	JLabel l,l1,l2,lh,U_passwd,U_Nm,Bk_Nm,Bk_Author,Period,Isue_Dt;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,b3;
	Font f,f1,f2;

	//for database connectivity variable
	Connection con;
	PreparedStatement smt,ps1,ps2;
	ResultSet rs1,rs2;
	Statement s;

	public IssueBook()
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
		p1.setBounds(420,200,520,450);
		p1.setBackground(new Color(221,221,221));
		
	
		l.add(p1);
		
		

	
		//label
		l1=new JLabel("ISSUE BOOK ");
		l1.setBounds(160,10,850,30);
		
		l1.setFont(ff);
		
		
		p1.add(l1);
		
	
		
		
	//set label 

		
		
		U_Nm=new JLabel("User_Name :");
		U_Nm.setBounds(20,70,200,30);
		U_Nm.setFont(f1);
		
		U_passwd=new JLabel("User_Password : ");
		U_passwd.setBounds(20,120,200,30);
		U_passwd.setFont(f1);


		Bk_Nm=new JLabel("Book_Name : ");
		Bk_Nm.setBounds(20,170,200,30);
		Bk_Nm.setFont(f1);

		Bk_Author =new JLabel("Book_Author :");
		Bk_Author.setBounds(20,220,200,30);
		Bk_Author.setFont(f1);

		Isue_Dt=new JLabel("Issued_Date : (YYYY-MM-DD)");
		Isue_Dt.setBounds(20,270,200,30);
		Isue_Dt.setFont(f1);
		
		Period=new JLabel("Period (Days) :  ");
		Period.setBounds(20,320,200,30);
		Period.setFont(f1);


		//set Text Field
		t1=new JTextField();
		t1.setBounds(300,70,200,30);
		t1.setFont(f2);
	
		
		
		t2=new JTextField();
		t2.setBounds(300,120,200,30);
		t2.setFont(f2);
		
		
		t3=new JTextField();
		t3.setBounds(300,170,200,30);
		t3.setFont(f2);

		
		t4=new JTextField();
		t4.setBounds(300,220,200,30);
		t4.setFont(f2);

		
		t5=new JTextField();
		t5.setBounds(300,270,200,30);
		t5.setFont(f2);

		
		t6=new JTextField();
		t6.setBounds(300,320,200,30);
		t6.setFont(f2);

		
	

		//set Button
		
		b1=new JButton("ISSUE");
		b1.setBounds(60,400,80,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		b1.addActionListener(this);

		b2=new JButton("CLEAR");
		b2.setBounds(210,400,80,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

		b3=new JButton("BACK");
		b3.setBounds(360,400,80,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);

		//set all labels , textfields and buttons in to panel

		
	
		p1.add(Bk_Nm);
		p1.add(U_passwd);
		p1.add(U_Nm);
		p1.add(Period);
		p1.add(Isue_Dt);
		p1.add(Bk_Author);

	
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
			Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","mysqlpasswd@25");
			
			
				
				ps1=con.prepareStatement("select * from members where  name=? and password=?");
				ps2=con.prepareStatement("select * from books_detail where book_name=? and publisher=?");
				smt=con.prepareStatement("Insert into view_issue(name,password,book_name,author,issued,period) values(?,?,?,?,?,?)");
				
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
		
		if(o==b1)
		{
				try
				{
							
					Validation valid = new Validation();
							//validation check to receive correct data by user
														
														int c=0;
									Date date=new Date();
									Date test=null;
									long te=0;
									long mg=date.getTime();
									
									try
									{
										test=new Date(t5.getText());
										te=test.getTime();

									}catch(Exception e)
									{
										JOptionPane.showMessageDialog(null,"Invalid Date Format It must be like this(dd-may(mm)-yyyy)");
										//t5.setText(" ");
										c=1;
								
									}
				
	

							if(valid.isValidString(t1.getText()))
							JOptionPane.showMessageDialog(null,"User Name should be only in Alphabets");
			
							else if(t1.getText().length()==0)
							JOptionPane.showMessageDialog(null,"User Name,It field should not be blank!! ");	
						
							else if(valid.isValidString(t2.getText()))
							JOptionPane.showMessageDialog(null,"User Password should be only in Alphabets");
			
							else if(t2.getText().length()==0)
							JOptionPane.showMessageDialog(null,"User Password,It field should not be blank!! ");
						
						
							
							else if(valid.isValidString(t3.getText()))
							JOptionPane.showMessageDialog(null,"Book Name should be only in Alphabets");
			
							else if(t3.getText().length()==0)
							JOptionPane.showMessageDialog(null,"Enter Book Name,It field should not be blank!! ");
			
							else if(valid.isValidString(t4.getText()))
							JOptionPane.showMessageDialog(null,"Book Publisher Name should be only in Alphabets");
			
							else if(t4.getText().length()==0)
							JOptionPane.showMessageDialog(null,"Enter Book publisher Name,It field should not be blank!! ");
						
						
							else if(t5.getText().trim().equals(""))
							JOptionPane.showMessageDialog(null,"Enter issue date !! It field should not be blank!");
						
					
							
							 else if(te>mg)
							JOptionPane.showMessageDialog(null,"Entered Date Should be in Limit !!");
							//else if(valid.isValidDate(t5.getText()))
							//JOptionPane.showMessageDialog(null,"Invalid Date Format!");
							
							else if(valid.isValidNumber(t6.getText()))
							JOptionPane.showMessageDialog(null,"Period should be only in Number");
						
							else if(t6.getText().length()==0)
							JOptionPane.showMessageDialog(null,"Enter period ,It field should not be blank!!");

							

							else
							getbook();

					
			}catch(Exception e)
				{
					
					System.out.println(e);
				}
		}

		if(o==b2)
		{
		
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

	public void getbook()
	{
		try
		{
			
			ps1.setString(1,t1.getText());
			ps1.setString(2,t2.getText());
		
				
			ps2.setString(1,t3.getText());
			ps2.setString(2,t4.getText());
								
			
				rs2=ps2.executeQuery();
				rs1=ps1.executeQuery();
				
				if(rs1.next())
					{
						
						
						if(rs2.next())
						{
					
													int i;
								i=JOptionPane.showConfirmDialog(this,"Are You Sure!! You  Want To Issue This Book? ","Confirm Message",JOptionPane.YES_NO_OPTION);
						
								if(i==0)
								{
									
									smt.setString(1,t1.getText());
									smt.setString(2,t2.getText());
									smt.setString(3,t3.getText());
									smt.setString(4,t4.getText());
									smt.setString(5,t5.getText());
									smt.setString(6,t6.getText());
									smt.executeUpdate();
								
							JOptionPane.showMessageDialog(this,t1.getText()+" Successfully Issued Book!!");

							t1.setText(" ");
							t2.setText(" ");
							t3.setText(" ");
							t4.setText(" ");
							t5.setText(" ");
							t6.setText(" ");

							}
						}
						else
						{
					
						JOptionPane.showMessageDialog(null,"Please! Enter correct Book_Name or Publisher_Name");
						}
					}
				else
					{
						
						JOptionPane.showMessageDialog(null,"Please! Enter correct U_Name or U_Password");
					}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}


	}

	public static void main(String args[])
	{
		new IssueBook();
	}
}