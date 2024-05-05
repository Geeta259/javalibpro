//add user in library
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;
import java.text.SimpleDateFormat;



class SignIn extends JFrame	 implements ActionListener,ItemListener
{
	JPanel p,ph,p1;
	ImageIcon img;
	JLabel  lh,l,l1,l2,name,passwd,gender,dob,email,number,address,city;
	JTextField t1,t2,t3,t4,t5,t6;
	JComboBox c1,c2;
	
	JButton b1,b2,b3;
	
	String str1,str2;
	String u_id=null;
	
	
	int count=0;

	//for database connectivity variable
	Connection con;
	PreparedStatement smt;
	ResultSet rs;
	Statement s; 

	public SignIn()
	{
		
		
		this.setVisible(true);
		this.setTitle("SIGN IN");
		this.setSize(2000,2050);

		this.setResizable(true);
		
		
		
		 p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,1500,800);
		//p.setBackground(Color.WHITE);
		p.setBackground(new Color(200,200,200));
	
		img=new ImageIcon("login.jpg");
		l=new JLabel(img);
		l.setLayout(null);
		l.setBounds(-10,-50,1500,800);
		this.add(p);
		p.add(l);
		

	
		ph=new JPanel();
		ph.setLayout(null);
		ph.setBounds(0,100,1500,50);
		ph.setBackground(new Color(221,221,221));
		l.add(ph);
		
		
		Font f=new Font("ArialBlack",Font.BOLD,32);
		Font f1=new Font("ArialBlack",Font.BOLD,26);
		Font f2=new Font("ArialBlack",Font.BOLD,20);
		Font f3=new Font("ArialBlack",Font.BOLD,18);
		
		lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lh.setBounds(430,10,800,30);
		lh.setForeground(Color.BLACK);
		lh.setFont(f);
		ph.add(lh);

		
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(390,190,600,460);
		p1.setBackground(new Color(221,221,221));
	
		l.add(p1);
		
		
		

	
		

		
		
		
		//label
		l1=new JLabel("MEMBERSHIP FORM");
		l1.setBounds(150,10,800,30);
		
		l1.setFont(f1);
		
		
		p1.add(l1);
		
	
		
		
		//set label
		
		name=new JLabel("Your_Name :");
		name.setBounds(10,60,250,30);
		name.setFont(f2);
	
		p1.add(name);
		
		t1=new JTextField();
		t1.setBounds(10,90,250,30);
		t1.setFont(f3);
		
		p1.add(t1);

		passwd=new JLabel("Your_Password :");
		passwd.setBounds(310,60,250,30);
		passwd.setFont(f2);
		p1.add(passwd);
		

		t2=new JTextField();
		t2.setBounds(310,90,250,30);
		t2.setFont(f3);
		p1.add(t2);
		
	
		gender=new JLabel("Gender :");
		gender.setBounds(10,150,250,30);
		gender.setFont(f2);
		
		p1.add(gender);
		
		c1=new JComboBox();
		c1.addItem("Select Gender");
		c1.addItem("male");
		c1.addItem("female");
		c1.setFont(f3);
		c1.setBounds(10,180,250,30);
		c1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent v)
		{

			str1=(String)c1.getSelectedItem();
		}

		});
	
		p1.add(c1);
		
		dob=new JLabel("D-O-B(YYYY-MM-DD)");
		dob.setBounds(310,150,250,30);
		dob.setFont(f2);
		
		p1.add(dob);
		
		t3=new JTextField();
		t3.setBounds(310,180,250,30);
		t3.setFont(f3);
		
		p1.add(t3);
		
	
		
		
		

		address=new JLabel("Address :");
		address.setBounds(10,240,250,30);
		address.setFont(f2);
	
		p1.add(address);

		t4=new JTextField();
		t4.setBounds(10,270,250,30);
		t4.setFont(f3);
		
		p1.add(t4);
		
		city=new JLabel("City :");
		city.setBounds(310,240,250,30);
		city.setFont(f2);
		
		p1.add(city);
		
			c2=new JComboBox();
		c2.addItem("Select City");
		c2.addItem("Delhi");
		c2.addItem("Bombay");
		c2.addItem("Kolkata");
		c2.addItem("Chennai");
		c2.addItem("Uttrakhand");
		c2.addItem("Utt. Pradesh");
		c2.addItem("Rajastan");
		c2.addItem("Gujrat");
		c2.setFont(f3);
		c2.setBounds(310,270,250,30);
		c2.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent v)
		{

			str2=(String)c2.getSelectedItem();
		}

		});
		
		
	p1.add(c2);
	
		email=new JLabel("Your_E-Mail :");
		email.setBounds(10,330,250,30);
		email.setFont(f2);
		
		p1.add(email);
		
		t5=new JTextField();
		t5.setBounds(10,360,250,30);
		t5.setFont(f3);
	
		p1.add(t5);


		number=new JLabel("Phone_Number :");
		number.setBounds(310,330,250,30);
		number.setFont(f2);
		
		p1.add(number);

			t6=new JTextField();
		t6.setBounds(310,360,250,30);
		t6.setFont(f3);
	
		p1.add(t6);

	

		//setButton
		b1=new JButton("SUBMIT");
		b1.setBounds(100,410,80,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);

		b2=new JButton("CLEAR");
		b2.setBounds(250,410,80,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

		b3=new JButton("BACK");
		b3.setBounds(400,410,80,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);


		
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		
		connec();
	}
	
	public void connec()
{
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","mysqlpasswd@25");
		
		smt=con.prepareStatement("Insert into user_req(name,password,gender,dob,address,city,email,phone) values(?,?,?,?,?,?,?,?)");
		
	}catch(Exception e)
	{
		
		JOptionPane.showMessageDialog(null,"NOT ANY REQUEST SUBMIT");
		t1.setText(" ");
		t2.setText(" ");
		t3.setText(" ");
		t4.setText(" ");
		t5.setText(" ");
		t6.setText(" ");
		
	}
}

public void itemStateChanged(ItemEvent i)
	{
		/*ItemSelectable s;
		s=i.getItemSelectable();
		if(s==ml)
			gndr="male";
		else
			gndr="female";*/
	}

public void actionPerformed(ActionEvent ae)
{
	
	Object o= ae.getSource();
	
	if(o==b1)
	{
		enterRecord();
	}
			if(o==b2)
		{
			t1.setText(" ");
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
			c1.setSelectedItem("Select Gender");
			t6.setText(" ");
			
		
			c2.setSelectedItem("Select City");			
		}
		if(o==b3)
		{
			new HomePage();
			this.dispose();
		}


}


public void enterRecord()
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
			test=new Date();
			te=test.getTime();

		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Invalid Date Format!!It must be like this 'yyyy-mm-dd'");
			JOptionPane.showMessageDialog(null,"Please enter correct given format d.o.b before submit your form ");
			//t3.setText(" ");
			c=1;
	
		}
	

		 if(valid.isValidString(t2.getText()))
JOptionPane.showMessageDialog(null,"Your Password should be only in Alphabets");
			
			else if(t2.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Password ,It field should not be blank!! ");
			
			else if(valid.isValidString(t1.getText()))
JOptionPane.showMessageDialog(null,"Name should be only in Alphabets");
			
			else if(t1.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Name,It field should not be blank!! ");

			else if(c1.getSelectedItem().equals("Select Gender"))
	JOptionPane.showMessageDialog(null,"Select Gender,It field should not be blank!!");
	

 		 else if(te>mg)
JOptionPane.showMessageDialog(null,"Entered Date Should be in Limit");
			
		
			else if(t3.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Date-Of-Birth,It field should not be blank!! ");

			
			else if(t4.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Address,It field should not be blank!! ");


			else if(c2.getSelectedItem().equals("Select City"))
	JOptionPane.showMessageDialog(null,"Select City,It field should not be blank!!");
			
			else if(t5.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter E-Mail,It field should not be blank!! ");

		else if(t5.getText().length()==0)
		JOptionPane.showMessageDialog(null,"Enter E-Mail,It field should not be blank!! ");


	else if(!valid.isValidEmail(t5.getText()))
JOptionPane.showMessageDialog(null,"Enter a valid email");		

			
			else if(valid.isValidNumber(t6.getText()))
JOptionPane.showMessageDialog(null,"Contact No. should be only in Numbers");
			else if(t6.getText().length()<10||t6.getText().length()>10)
JOptionPane.showMessageDialog(null,"Contact should be in 10 digits Only");
		
	else
	{
		
	try
	{
		
		int m;
		m=JOptionPane.showConfirmDialog(this,"Are You Sure ! You Want To Be Member's Of Library? ","Confirm Message",JOptionPane.YES_NO_OPTION);
	
		if(m==0)
	{
		smt.setString(1,t1.getText());
		smt.setString(2,t2.getText());
		smt.setString(3,str1);
		//smt.setString(4,gndr);
		smt.setString(4,t3.getText());
		smt.setString(5,t4.getText());
		smt.setString(6,str2);
		smt.setString(7,t5.getText());
		smt.setString(8,t6.getText());
	
		
		
		
		
		smt.executeUpdate();
		JOptionPane.showMessageDialog(this,t1.getText()+"!!"+"Your Request Successfully Submitted !!!!!");

		t1.setText(" ");
		t2.setText(" ");
		t3.setText(" ");
		t4.setText(" ");
		t5.setText(" ");
		t6.setText(" ");
		

		}

	}catch(Exception e)
	{
		System.out.println(e);
	}
	
	
}

}

public static void main(String ar[])
{
	new SignIn();
}


}
