
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

class AddBook extends JFrame implements ActionListener
{
	JPanel p,p1,ph;
	ImageIcon img;
	JLabel  limg,l,lh,l1,Bk_id,Bk_Nm,Bk_P_Nm,Bk_P_Y,Bk_Price,Bk_Q,Bk_pg,Bk_C,Bk_S;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JComboBox c1;
	Font f,f1,f2;
	JButton b1,b2,b3;
	String bid=null,str;
	int count=0;

	 //for database connectivity variable
	Connection con;
	PreparedStatement smt;
	ResultSet rs;
	Statement s;
	
	public AddBook()
	{
		//p=new JPanel();
		
		this.setVisible(true);
		this.setTitle("New Books Record");
		this.setSize(2000,2000);
		//p.setLayout(null);
		this.setResizable(true);
		//p.setBackground(new Color(71,198,235));
		//this.add(p);

		
		
		
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
		p1.setBounds(420,170,520,570);
		p1.setBackground(new Color(221,221,221));
		
	
		l.add(p1);
		
		

	
		//label
		l1=new JLabel("ADD NEW BOOK ");
		l1.setBounds(150,10,800,30);
		
		l1.setFont(ff);
		
		
		p1.add(l1);
		
		
		
		
		
	
		//set label 

		Bk_id=new JLabel("BOOK ID");
		Bk_id.setBounds(20,60,200,30);
		
		Bk_id.setFont(f1);
		
		Bk_Nm=new JLabel("BOOK NAME");
		Bk_Nm.setBounds(20,110,200,30);

		Bk_Nm.setFont(f1);
		
		Bk_P_Nm=new JLabel("BOOK PUBLISHER NAME");
		Bk_P_Nm.setBounds(20,160,250,30);
		
		Bk_P_Nm.setFont(f1);

		Bk_P_Y=new JLabel("BOOK PUBLISHED YEAR");
		Bk_P_Y.setBounds(20,210,250,30);
	
		Bk_P_Y.setFont(f1);

		Bk_Price=new JLabel("BOOK PRICE");
		Bk_Price.setBounds(20,260,200,30);
		
		Bk_Price.setFont(f1);

		Bk_Q=new JLabel("BOOK QUANTITY");
		Bk_Q.setBounds(20,310,200,30);

		Bk_Q.setFont(f1);	
	
		Bk_pg=new JLabel("BOOK PAGES");
		Bk_pg.setBounds(20,360,200,30);
		
		Bk_pg.setFont(f1);	
	
		Bk_C=new JLabel("BOOK CATEGORY");
		Bk_C.setBounds(20,410,200,30);
	
		Bk_C.setFont(f1);	
	
		Bk_S=new JLabel("BOOK SHELF");
		Bk_S.setBounds(20,460,200,30);
	
		Bk_S.setFont(f1);	
	
			
		

		//setTextField
	
		t1=new JTextField();
		t1.setBounds(300,60,200,30);
		t1.setFont(f2);	
		
		t2=new JTextField();
		t2.setBounds(300,110,200,30);
		t2.setFont(f2);

		t3=new JTextField();
		t3.setBounds(300,160,200,30);
		t3.setFont(f2);

		t4=new JTextField();
		t4.setBounds(300,210,200,30);
		t4.setFont(f2);

		t5=new JTextField();
		t5.setBounds(300,260,200,30);
		t5.setFont(f2);
	
		t6=new JTextField();
		t6.setBounds(300,310,200,30);
		t6.setFont(f2);
	
		t7=new JTextField();
		t7.setBounds(300,360,200,30);
		t7.setFont(f2);
	
		

		t8=new JTextField();
		t8.setBounds(300,460,200,30);
		t8.setFont(f2);

		//set combobox
		c1=new JComboBox();
		c1.addItem("Select Category");
		c1.addItem("computer");
		c1.addItem("math");
		c1.addItem("science");
		c1.addItem("english");
		c1.addItem("hindi");
		c1.setFont(f2);
		c1.setBounds(300,410,200,30);
		c1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent v)
		{

			str=(String)c1.getSelectedItem();
		}

		});
		


		//setButton
		b1=new JButton("ADD");
		b1.setBounds(60,520,100,40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);

		b2=new JButton("CLEAR");
		b2.setBounds(210,520,100,40);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);

		b3=new JButton("BACK");
		b3.setBounds(360,520,100,40);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);

	
		
		//p1.add(limg);
		
		p1.add(Bk_id);
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
		p1.add(c1);
		p1.add(t8);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);

		connec();
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		
		Object o = ae.getSource();
		if(o==b1)
		{
			
			Validation valid = new Validation();
			//validation check to receive correct data by user

			if(valid.isValidString(t2.getText()))
JOptionPane.showMessageDialog(null,"Book Name should be only in Alphabets");
			
			else if(t2.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Book Name,It field should not be blank!! ");
			
			else if(valid.isValidString(t3.getText()))
JOptionPane.showMessageDialog(null,"Book Publisher Name should be only in Alphabets");
			
			else if(t3.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Book publisher Name,It field should not be blank!! ");

			else if(valid.isValidNumber(t4.getText()))
JOptionPane.showMessageDialog(null,"Book Published Year should be only in Number");
			
			else if(t4.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Book Published Year,It field should not be blank!! ");
	
			else if(valid.isValidNumber(t5.getText()))
JOptionPane.showMessageDialog(null,"Book Price should be only in Number");
			
			else if(t5.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Book Price,It field should not be blank!! ");

			else if(valid.isValidNumber(t6.getText()))
JOptionPane.showMessageDialog(null,"Book Quantity should be only in Number");
			
			else if(t6.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Book Quantity,It field should not be blank!! ");

			else if(valid.isValidNumber(t7.getText()))
JOptionPane.showMessageDialog(null,"Book Pages should be only in Number");
			
			else if(t7.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Book Pages,It field should not be blank!! ");


			else if(c1.getSelectedItem().equals("Select Category"))
	JOptionPane.showMessageDialog(null,"Select Category,It field should not be blank!!");
	

			else if(valid.isValidNumber(t8.getText()))
JOptionPane.showMessageDialog(null,"Book Shelf should be only in Number");
			
			else if(t8.getText().length()==0)
JOptionPane.showMessageDialog(null,"Enter Book Shelf,It field should not be blank!! ");

			
			
			else
			enterRecord();
		}
		if(o==b2)
		{
			
			t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
			t6.setText(" ");
			t7.setText(" ");
			t8.setText(" ");
			c1.setSelectedItem("Select Category");
		}
		if(o==b3)
		{
			new AdminPage();
			this.dispose();
		}


	}

public void connec()
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

		getId();	

smt=con.prepareStatement("Insert into books_detail values(?,?,?,?,?,?,?,?,?)");
	}catch(Exception ae)
	{
		JOptionPane.showMessageDialog(null,"NOT ANY NEW RECORD ADD");
		
		t2.setText(" ");
		t3.setText(" ");
		t4.setText(" ");
		t5.setText(" ");
		t6.setText(" ");
		t7.setText(" ");
		t8.setText(" ");
		c1.setSelectedItem("Select Category");
		
	}
}
public void getId() throws Exception
{
	count=1;
	s=con.createStatement();
	rs=s.executeQuery("Select * from books_detail");
	while(rs.next())
	{
		count++;
	}
	if(count<10)
	bid="10"+(Integer.toString(count));
	else if(count<100)
	bid="1"+(Integer.toString(count));
	
	t1.setText(bid);
	t1.setEditable(false);
}
public void enterRecord()
{
	try
	{
		
		int m;
		m=JOptionPane.showConfirmDialog(this,"Are You Sure ! You Want To Save Date? ","Confirm Message",JOptionPane.YES_NO_OPTION);
	
		if(m==0)
	{
		smt.setString(1,t1.getText());
		smt.setString(2,t2.getText());
		smt.setString(3,t3.getText());
		smt.setString(4,t4.getText());
		smt.setString(5,t5.getText());
		smt.setString(6,t6.getText());
		smt.setString(7,t7.getText());
		smt.setString(8,str);
		smt.setString(9,t8.getText());
				
		smt.executeUpdate();
		JOptionPane.showMessageDialog(this,t1.getText()+"Record Successfully Saved in Database");

	}

	}catch(Exception e)
	{
		System.out.println(e);
	}
	



}

public static void main(String ar[])
{

	new AddBook();

}


}