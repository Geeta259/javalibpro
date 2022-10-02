import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import java.util.Date;

class AddUsr extends JFrame implements ActionListener,MouseListener

{
	//Declaring Label , TextField , Panel , ScrollPane , etc......
	JPanel p,ph,p1,p2;
	JButton b1,b2,b3;
	ImageIcon img;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JScrollPane s;
	JTable tb;
	JTableHeader header;
	String Data[][];
	String Head[]={"Name","Password","Gender","D-O-B","Address","City","E-Mail","Contact"};
	JLabel l,l1,l2,lh,li;

	

	Connection con;
	ResultSet rs;
	Statement smt;
	PreparedStatement ps,ps1;
	

	public AddUsr()
	{
		
		this.setVisible(true);
		this.setTitle("ADD USER");
		this.setSize(2000,2000);
		this.setResizable(true);
	
		
		
			
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
		Font f1=new Font("ArialBlack",Font.BOLD,24);
		Font f2=new Font("ArialBlack",Font.BOLD,15);
		
		lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lh.setBounds(430,10,800,30);
		lh.setForeground(Color.BLACK);
		lh.setFont(f);
		ph.add(lh);

		
		
	
	

		//panel
		p1=new JPanel();
		p1.setBounds(80,180,1200,150);
		
		p1.setLayout(new BorderLayout(12,12));
		p1.setBackground(new Color(221,221,221));
		
		l.add(p1);
		
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(380,330,580,320);
		p2.setBackground(new Color(221,221,221));
		l.add(p2);
		
		lh=new JLabel("NEW USER DETAILS");
		lh.setBounds(180,5,350,30);
		lh.setFont(f1);
		p2.add(lh);

		
	
		
		
		
	//set label 

		
		
		
		t1=new JTextField("NAME");
		t1.setBounds(10,60,250,30);
		t1.setFont(f2);
		t1.setEditable(false);
		p2.add(t1);
	
		t2=new JTextField("PASSWORD");
		t2.setBounds(320,60,250,30);
		t2.setFont(f2);
		t2.setEditable(false);
		p2.add(t2);
	
	
		t3=new JTextField("GENDER");
		t3.setBounds(10,110,250,30);
		t3.setFont(f2);
		t3.setEditable(false);
		p2.add(t3);
	
		t4=new JTextField("D.O.B (DD/MM/YYYY)");
		t4.setBounds(320,110,250,30);
		t4.setFont(f2);
		t4.setEditable(false);
		p2.add(t4);
	
	
		t5=new JTextField("ADDRESS");
		t5.setBounds(10,160,250,30);
		t5.setFont(f2);
		t5.setEditable(false);
		p2.add(t5);
		
		t6=new JTextField("CITY");
		t6.setBounds(320,160,250,30);
		t6.setFont(f2);
		t6.setEditable(false);
		p2.add(t6);
	
	
		t7=new JTextField("E-MAIL");
		t7.setBounds(10,210,250,30);
		t7.setFont(f2);
		t7.setEditable(false);
		p2.add(t7);
	
		t8=new JTextField("CONTACT");
		t8.setBounds(320,210,250,30);
		t8.setFont(f2);
		t8.setEditable(false);
		p2.add(t8);
	
		//button
		b1=new JButton("ADD");
		b1.setBounds(50,270,80,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		p2.add(b1);
		
		b2=new JButton("DELETE");
		b2.setBounds(250,270,80,30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p2.add(b2);
		
		b3=new JButton("BACK");
		b3.setBounds(450,270,80,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		p2.add(b3);
		
		
		
		
		
		
		
		

		
		b1.addActionListener(this);
		
		b2.addActionListener(this);
		b3.addActionListener(this);
		
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
			rs=smt.executeQuery("select * from user_req");
			ps=con.prepareStatement("Insert into members values(?,?,?,?,?,?,?,?)");

			ps1=con.prepareStatement("Delete from user_req where name=? and passwd=?");
			
			

			//count record
			int r=0;
			while(rs.next())
			{
				r++;
			}
			

			rs=smt.executeQuery("select * from user_req");
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
			tb=new JTable(Data,Head);
			tb.setBounds(10,10,1300,250);
			p1.add(tb);

			s=new JScrollPane(tb);
			
			s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			
			p1.add(s);
			
			header= tb.getTableHeader();
			header.setBackground(Color.WHITE);
			header.setFont(new Font ("Arial",Font.BOLD,16));
			

		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		tb.addMouseListener(this);
}



public void mouseClicked(MouseEvent e)
{
	
	int i=tb.getSelectedRow();
	
	t1.setText(tb.getValueAt(i,0).toString());
	t2.setText(tb.getValueAt(i,1).toString());
	t3.setText(tb.getValueAt(i,2).toString());
	t4.setText(tb.getValueAt(i,3).toString());
	t5.setText(tb.getValueAt(i,4).toString());
	t6.setText(tb.getValueAt(i,5).toString());
	t7.setText(tb.getValueAt(i,6).toString());
	t8.setText(tb.getValueAt(i,7).toString());
	
	

	t1.setEditable(false);
	t2.setEditable(false);
	t3.setEditable(false);
	t4.setEditable(true);
	t5.setEditable(false);
	t6.setEditable(false);
	t7.setEditable(false);
	t8.setEditable(false);
}

public void mousePressed(MouseEvent e)
{
	
}
public void mouseEntered(MouseEvent e)
{
	
}
public void mouseExited(MouseEvent e)
{
	
}
public void mouseReleased(MouseEvent e)
{}





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
			test=new Date(t4.getText());
			te=test.getTime();

		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Invalid Date Format!!It must be like this(dd-jan(mm)-yyyy)");
			JOptionPane.showMessageDialog(null,"Please enter correct given format d.o.b before add any user ");
			//t3.setText(" ");
			c=1;
	
		}
		
		int m;
		m=JOptionPane.showConfirmDialog(this,"Are You Sure ! You Want To Add This Member? ","Confirm Message",JOptionPane.YES_NO_OPTION);
	
		if(m==0)
	{
		ps.setString(1,t1.getText());
		ps.setString(2,t2.getText());
		ps.setString(3,t3.getText());
		ps.setString(4,t4.getText());
		ps.setString(5,t5.getText());
		ps.setString(6,t6.getText());
		ps.setString(7,t7.getText());
		ps.setString(8,t8.getText());	
		ps.executeUpdate();
		
	
		JOptionPane.showMessageDialog(this,t1.getText()+" "+"User Record Successfully Saved in Database");
		
		ps1.setString(1,t1.getText());
		ps1.setString(2,t2.getText());
		ps1.executeUpdate();
		
	
		
	
		t1.setText("NAME");
		t2.setText("PASSWORD");
		t3.setText("GENDER");
		t4.setText("D.O.B(DD/MM/YYYY)");
		
		t5.setText("ADDRESS");
		t6.setText("CITY");
		t7.setText("E-MAIL");
		t8.setText("CONTACT");
		
		new AddUsr();
		this.dispose();

		}

	}catch(Exception e)
	{
		System.out.println(e);
	}
	
			
			
				
		}
		
		
		if(o==b2)
		{
			
									try
						{
						
						int m;
						m=JOptionPane.showConfirmDialog(this,"Are You Sure ! You Want To Delete This User Request? ","Confirm Message",JOptionPane.YES_NO_OPTION);
					
						if(m==0)
						{
									
										ps1.setString(1,t1.getText());
										ps1.setString(2,t2.getText());
										ps1.executeUpdate();
									
									JOptionPane.showMessageDialog(this,t1.getText()+" "+"Record Successfully Deleted from New User Record");
											t1.setText("NAME");
											t2.setText("PASSWORD");
											t3.setText("GENDER");
											t4.setText("D.O.B(DD/MM/YYYY)");
											t4.setEditable(false);
											t5.setText("ADDRESS");
											t6.setText("CITY");
											t7.setText("E-MAIL");
											t8.setText("CONTACT");
										
											new AddUsr();
											this.dispose();
										

																	
						}
					}catch(Exception e)
				{
						System.out.println(e);
				}
	
				
		}
		
		if(o==b3)
		{
			new AdminPage();
			this.dispose();
		}

	}


public static void main(String ar[])
{
	new AddUsr();
}	
	

}