import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

class ULogin extends JFrame implements ActionListener
{

	JPanel p,ph,p1;
	ImageIcon img,img1,img2;
	JLabel lh,ll,l,li,l1,l2,l3,l4;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2,b3;
	
		//variable for connectivity
	Connection con;
	Statement smt;
	PreparedStatement ps;
	ResultSet rs;


	public ULogin()
	{
		this.setVisible(true);
		this.setSize(1600,1000);
		//this.setLocation(250,200);
		this.setTitle("ADMIN LOGIN");
		//this.setResizable(false);
		
	
	
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
		Font f1=new Font("ArialBlack",Font.BOLD,28);
		Font f2=new Font("ArialBlack",Font.BOLD,24);
		Font f3=new Font("ArialBlack",Font.BOLD,15);
			
		lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lh.setBounds(430,10,800,30);
		lh.setForeground(Color.BLACK);
		lh.setFont(f);
		ph.add(lh);

		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(500,250,400,400);
		p1.setBackground(new Color(221,221,221));
		l.add(p1);
	
		
		//Font f1=new Font("Broadway",Font.BOLD,28);
		

		l1=new JLabel("LOGIN HERE");
		l1.setBounds(110,10,200,50);
		l1.setFont(f1);
		l1.setForeground(Color.BLACK);
		l2=new JLabel("USER LOGIN FORM");
		l2.setBounds(80,60,300,40);
		l2.setFont(f2);
		l2.setForeground(Color.BLACK);
		
		img1=new ImageIcon("user.jpg");
		l3=new JLabel(img1);
		l3.setLayout(null);
		l3.setBounds(12,130,50,50);
		//l3.setForeground(Color.WHITE);
		
		
		img2=new ImageIcon("lock.jpg");
		l4=new JLabel(img2);
		l4.setLayout(null);
		l4.setBounds(10,220,50,50);
		

		t1=new JTextField("USER NAME");
		t1.setBounds(80,140,250,30);
		t1.setFont(f3);

		t2=new JPasswordField();
		t2.setEchoChar('*');
		t2.setBounds(80,230,250,30);
	
		


		b1=new JButton("Login");
		b1.setBounds(50,320,80,40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);

		b2=new JButton("Clear");
		b2.setBounds(140,320,80,40);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);

		b3=new JButton("Back");
		b3.setBounds(230,320,80,40);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);

		

		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(t1);
		p1.add(t2);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		connect();

	}
	
	public void connect()
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","mysqlpasswd@25");
				
			ps=con.prepareStatement("select * from members where name=? and password=?");
				
			
				
		}catch(Exception ae)
		{
			System.out.println(ae);
		}
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		Object o = ae.getSource();
		
		if(o==b1)
		{
				try
				{
					ps.setString(1,t1.getText());
					ps.setString(2,t2.getText());
					
					rs=ps.executeQuery();
					
					
					if(rs.next())
					{
						JOptionPane.showMessageDialog(this,"Login Successfully!!!!!");
						new UserPage();
						this.dispose();
						
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Login Not Successfully!!!!!");
					
					}
					
				}catch(Exception a)
					{
						
						System.out.println(a);
					}
		}
		if(o==b2)
			{
				t1.setText("");
				t2.setText("");

			}
			if(o==b3)
			{
				new HomePage();
				this.dispose();
			}

		}
		
		public static void main(String ar[])
		{
			new ULogin();
		}

}