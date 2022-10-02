import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.Date;

class UProfile extends JFrame implements ActionListener
{
	JPanel p,ph,p1,p2;
	ImageIcon img;
	JLabel  limg,l,l1,l2,lh,U_Nm,U_pass,gender,dob,add,city,email,phone;
	JTextField t,t1,t2,t3,t4,t5,t6,t7,ts;
	
	JComboBox c1,c2;
	JButton b1,b2,b3,b4;
	int count=0;
	String str1,str2;
	 //for database connectivity variable
	Connection con;
	PreparedStatement ps,ps1;
	ResultSet rs;
	Statement s;
	
	public UProfile()
	{
		
		
		this.setResizable(true);
		this.setVisible(true);
		this.setTitle("USER PROFILE");
		this.setSize(2000,2000);
		
		this.setResizable(true);
		
		
		 p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,1500,1500);
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
		Font ff=new Font("ArialBlack",Font.BOLD,24);
		Font f1=new Font("ArialBlack",Font.BOLD,18);
		Font f2=new Font("ArialBlack",Font.BOLD,16);
	
		
		
		lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lh.setBounds(430,10,800,30);
		lh.setForeground(Color.BLACK);
		lh.setFont(f);
		ph.add(lh);

	
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(420,150,520,580);
		p1.setBackground(new Color(221,221,221));
		
	
		l.add(p1);
		
			
		//label
		l1=new JLabel("USER PROFILE");
		l1.setBounds(150,15,700,30);
		l1.setFont(ff);
		
		p1.add(l1);
		
		
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(10,70,500,40);
		p2.setBackground(new Color(211,211,211));
		p1.add(p2);
		
		
		
	//set label 

		
		t=new JTextField("Enter Name");
		t.setBounds(10,5,150,30);
		t.setFont(f2);
		p2.add(t);

		
		ts=new JTextField("Enter Password");
		ts.setBounds(200,5,150,30);
		ts.setFont(f2);
		p2.add(ts);

		b1=new JButton("SEARCH");
		b1.setBounds(370,5,100,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		p2.add(b1);
		b1.addActionListener(this);

		
	

	

	
	
		U_Nm=new JLabel("YOUR NAME :");
		U_Nm.setBounds(20,140,200,30);
		U_Nm.setFont(f1);
		
		U_pass=new JLabel("YOUR PASSWORD :");
		U_pass.setBounds(20,190,250,30);
		U_pass.setFont(f1);

		gender=new JLabel("YOUR GENDER :");
		gender.setBounds(20,240,250,30);
		gender.setFont(f1);

		dob=new JLabel("YOUR D.O.B :");
		dob.setBounds(20,290,200,30);
		dob.setFont(f1);

		add=new JLabel("YOUR ADDRESS :");
		add.setBounds(20,340,200,30);
		add.setFont(f1);	

		city=new JLabel("YOUR CITY :");
		city.setBounds(20,390,200,30);
		city.setFont(f1);	
	
		email=new JLabel("YOUR E-MAIL :");
		email.setBounds(20,440,200,30);
		email.setFont(f1);	
	
		phone=new JLabel("YOUR PHONE NO :");
		phone.setBounds(20,490,200,30);
		phone.setFont(f1);	

		//setTextField
		
		t1=new JTextField();
		t1.setBounds(300,140,200,30);
		t1.setFont(f2);	
		t1.setEditable(false);
	
		t2=new JTextField();
		t2.setBounds(300,190,200,30);
		t2.setFont(f2);	
		t2.setEditable(false);
		
	
		
		
		c1=new JComboBox();
		c1.addItem("Select Gender");
		c1.addItem("male");
		c1.addItem("female");
		c1.setFont(f2);
		c1.setBounds(300,240,200,30);
		c1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent v)
		{

			str1=(String)c1.getSelectedItem();
		}

		});
	
	

		t3=new JTextField();
		t3.setBounds(300,290,200,30);
		t3.setFont(f2);
		t3.setEditable(false);
		
		t4=new JTextField();
		t4.setBounds(300,340,200,30);
		t4.setFont(f2);
		t4.setEditable(false);
		
		c2=new JComboBox();
		c2.addItem("Select City");
		c2.addItem("New Delhi");
		c2.addItem("Bombay");
		c2.addItem("Kolkata");
		c2.addItem("Chennai");
		c2.addItem("Uttrakhand");
		c2.addItem("Utt. Pradesh");
		c2.addItem("Rajastan");
		c2.addItem("Gujrat");
		c2.setFont(f2);
		c2.setBounds(300,390,200,30);
		c2.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent v)
		{

			str2=(String)c2.getSelectedItem();
		}

		});
	
		t5=new JTextField();
		t5.setBounds(300,440,200,30);
		t5.setFont(f2);
		t5.setEditable(false);

	

		t6=new JTextField();
		t6.setBounds(300,490,200,30);
		t6.setFont(f2);
		t6.setEditable(false);

		
		
		//setButton
		

		b2=new JButton("UPDATE");
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
		
		
		p1.add(U_Nm);
		p1.add(U_pass);
		p1.add(gender);
		p1.add(add);
		p1.add(phone);
		p1.add(email);
		p1.add(city);
		p1.add(dob);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(t4);
		p1.add(t5);
		p1.add(t6);
		
		p1.add(c1);
		p1.add(c2);
	p1.add(b2);
	p1.add(b3);
	p1.add(b4);
	
		
		
		
		connec();
		}

	public void connec()
	{
		try
		{

			
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

		s=con.createStatement();
		ps=con.prepareStatement("Select * from members where u_name=? and upass=?");
		ps1=con.prepareStatement("Update members set u_name=?,upass=?,gender=?,dob=?,address=?,city=?,email=?,contact=? where u_name=? and upass=?");

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
		
		search();
	}
	if(o==b2)
	{
		update();
	}
	if(o==b3)
	{
			t.setText(" ");
			t.setEditable(true);
			ts.setText(" ");
			ts.setEditable(true);
			t1.setText(" ");
			t1.setEditable(false);
			t2.setText(" ");
			t2.setEditable(false);
			t3.setText(" ");
			t3.setEditable(false);
			t4.setText(" ");
			t4.setEditable(false);
			t5.setText(" ");
			t5.setEditable(false);
			t6.setText(" ");
			t6.setEditable(false);
			c1.setSelectedItem("Select Gender");
			c2.setSelectedItem("Select City");
		
			
	}
	if(o==b4)
	{
		new UserPage();
		this.dispose();
	}

}

public void  search()
{
	try
	{
		ps.setString(1,t.getText());
		ps.setString(2,ts.getText());
		rs=ps.executeQuery();
		
		if(rs.next())
	{
		rs=ps.executeQuery();
		while(rs.next())
		{
			
			t1.setText(rs.getString(1));
			t2.setText(rs.getString(2));
			
			String s1=rs.getString(3);					
			c1.setSelectedItem(s1);
			
			t3.setText(rs.getString(4));
			t4.setText(rs.getString(5));
			
			
			String s2=rs.getString(6);					
			c2.setSelectedItem(s2);
			
			t5.setText(rs.getString(7));

			t6.setText(rs.getString(8));
		

			ts.setEditable(false);
			t.setEditable(false);
			t1.setEditable(true);
			t2.setEditable(true);
			t3.setEditable(true);
			t4.setEditable(true);
			t5.setEditable(true);
			t6.setEditable(true);

			//t8.setEditable(true);
			
			

		}
	}
	else
	{
		JOptionPane.showMessageDialog(this,"Please Enter Correct Name or Password");
	
	}

	}catch(Exception ec)
	{
		System.out.println(ec);
	}

}
public void update()
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
			test=new Date(t3.getText());
			te=test.getTime();

		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Invalid Date Format!It Should be like(dd-aug(mm)-yyyy)");
			//t3.setText(" ");
			c=1;
	
		}
	

			
			
		
			 if(valid.isValidString(t1.getText()))
JOptionPane.showMessageDialog(null,"Name should be only in Alphabets");
			
			else if(t1.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Name,It field should not be blank!! ");
			else if(valid.isValidString(t2.getText()))
JOptionPane.showMessageDialog(null,"Your Password should be only in Alphabets");
			
			else if(t2.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Password ,It field should not be blank!! ");

			else if(c1.getSelectedItem().equals("Select Gender"))
	JOptionPane.showMessageDialog(null,"Select Gender,It field should not be blank!!");
			

 		 else if(te>mg)
JOptionPane.showMessageDialog(null,"Entered Date Should be in Limit");
			
		
			else if(t3.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Date-Of-Birth,It field should not be blank!! ");

			
			else if(t4.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Address,It field should not be blank!! ");
			
			else if(t5.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter E-Mail,It field should not be blank!! ");

			else if(!valid.isValidEmail(t5.getText()))
JOptionPane.showMessageDialog(null,"Enter a valid E-Mail");

			else if(c2.getSelectedItem().equals("Select City"))
	JOptionPane.showMessageDialog(null,"Select City,It field should not be blank!!");

			else if(valid.isValidNumber(t6.getText()))
JOptionPane.showMessageDialog(null,"Contact No. should be only in Numbers");
			else if(t6.getText().length()<10||t6.getText().length()>10)
JOptionPane.showMessageDialog(null,"Contact should be in 10 digits Only");
			else if(t6.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Contact No.,It field should not be blank!! ");		

			else
			{
				try
				{
				
						int m;
m=JOptionPane.showConfirmDialog(this,"Are You Sure You Want to Update Your Profile?","Confirm Message",JOptionPane.YES_NO_OPTION);
		if(m==0)
		{
		

		ps1.setString(1,t1.getText());
		ps1.setString(2,t2.getText());
		ps1.setString(3,str1);
		ps1.setString(4,t3.getText());
		ps1.setString(5,t4.getText());
		ps1.setString(6,str2);
		ps1.setString(7,t5.getText());
		ps1.setString(8,t6.getText());
		
	
		ps1.setString(9,t.getText());
		ps1.setString(10,ts.getText());		
		ps1.executeUpdate();
		JOptionPane.showMessageDialog(this,t1.getText()+"Record Successfully Updated in Database");
		
		

		}
	    
	}catch(Exception ex)
	{
		System.out.println(ex);
	}
	
}
}

public static void main(String ar[])
{

		new UProfile();
}
}