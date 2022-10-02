import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AdminPage extends JFrame implements ActionListener
{
	JLabel l,la,lh,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,ll;
	JPanel ph,ph1,p2,p1,p3;
	JButton b,b1,b2,b3,b4,b5,b6,b7,b8,b9;
	Font f1;
	ImageIcon  img,imga,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;

	public AdminPage()
	{
		this.setVisible(true);
		this.setTitle("ADMIN PAGE");
		this.setSize(2000,1000);
		this.setResizable(true);
		

		//set all panel
		
				
		
		
		 p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,1500,800);
		p1.setBackground(new Color(200,200,200));
	
	
		this.add(p1);
		
		
		
		
		Font f=new Font("ArialBlack",Font.BOLD,32);
		Font f1=new Font("ArialBlack",Font.BOLD,20);
		
		ph=new JPanel();
		ph.setLayout(null);
		ph.setBounds(0,60,1500,50);
		ph.setBackground(new Color(221,221,221));
		p1.add(ph);
		
		lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lh.setBounds(400,10,800,30);
		lh.setForeground(Color.BLACK);
		lh.setFont(f);
		ph.add(lh);
		
		ph1=new JPanel();
		ph1.setLayout(null);
		ph1.setBounds(0,130,200,40);
		ph1.setBackground(Color.BLACK);
	//	ph1.setBackground(new Color(221,221,221));
		p1.add(ph1);
	
		imga=new ImageIcon("ad.jpg");
		la=new JLabel(imga);
		la.setBounds(0,7,20,20);
		ph1.add(la);
		
	
		l1=new JLabel("ADMIN PORTAL");
		l1.setBounds(30,5,180,30);
	
		l1.setForeground(Color.WHITE);
		l1.setFont(f1);
		ph1.add(l1);
		
		b=new JButton("LOG OUT");
		b.setBounds(1150,130,120,40);
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		p1.add(b);
		
		img10=new ImageIcon("img10.jpg");
		l10=new JLabel(img10);
		l10.setLayout(null);
		l10.setBounds(1100,130,50,40);
		p1.add(l10);
		


		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(80,210,1200,210);
		p2.setBackground(new Color(221,221,221));
		p1.add(p2);
	

		img1=new ImageIcon("img1.jpg");
		l2=new JLabel(img1);
		l2.setLayout(null);
		l2.setBounds(10,10,200,140);
		p2.add(l2);
		b1=new JButton("VIEW BOOKS");
		b1.setBounds(60,160,120,40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		p2.add(b1);


		img2=new ImageIcon("img2.jpg");
		l3=new JLabel(img2);
		l3.setLayout(null);
		l3.setBounds(300,10,200,140);
		p2.add(l3);
		b2=new JButton("ADD BOOKS");
		b2.setBounds(350,160,120,40);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p2.add(b2);

		img3=new ImageIcon("img3.jpg");
		l4=new JLabel(img3);
		l4.setLayout(null);
		l4.setBounds(600,10,200,140);
		p2.add(l4);
		b3=new JButton("VIEW USER");
		b3.setBounds(650,160,120,40);
		p2.add(b3);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		
		img4=new ImageIcon("img4.jpg");
		l5=new JLabel(img4);
		l5.setLayout(null);
		l5.setBounds(900,10,200,140);
		p2.add(l5);
		b4=new JButton("ADD USER");
		b4.setBounds(950,160,120,40);
		p2.add(b4);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		
		
		
		
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBounds(80,460,1200,210);
		p3.setBackground(new Color(221,221,221));
		p1.add(p3);
	

		img5=new ImageIcon("img5.jpg");
		l6=new JLabel(img5);
		l6.setLayout(null);
		l6.setBounds(10,10,180,140);
		p3.add(l6);
		b5=new JButton("BOOK SEARCH");
		b5.setBounds(60,160,120,40);
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		p3.add(b5);


		img6=new ImageIcon("img6.jpg");
		l7=new JLabel(img6);
		l7.setLayout(null);
		l7.setBounds(290,10,180,140);
		p3.add(l7);
		b6=new JButton("UPDATE BOOK RECORD");
		b6.setBounds(300,160,170,40);
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		p3.add(b6);

		img7=new ImageIcon("img7.jpg");
		l8=new JLabel(img7);
		l8.setLayout(null);
		l8.setBounds(600,10,180,140);
		p3.add(l8);
		b7=new JButton("VIEW ISSUED BOOKS");
		b7.setBounds(630,160,160,40);
		p3.add(b7);
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		
		
		img8=new ImageIcon("img8.jpg");
		l9=new JLabel(img8);
		l9.setLayout(null);
		l9.setBounds(920,10,180,140);
		p3.add(l9);
		b8=new JButton("REMOVE BOOKS");
		b8.setBounds(940,160,140,40);
		p3.add(b8);
		b8.setBackground(Color.BLACK);
		b8.setForeground(Color.WHITE);
		
	
		//add action listener in buttons
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b.addActionListener(this);
	}
public void actionPerformed(ActionEvent ae)
{
	Object o = ae.getSource();
	if(o==b1)
	{
		new ViewBook();
		this.dispose();
	}
	if(o==b2)
	{
		new AddBook();
		this.dispose();
	}
	if(o==b3)
	{
		new ViewUser();
		this.dispose();
	}
	if(o==b4)
	{
		new AddUsr();
		this.dispose();
	}
	if(o==b5)
	{
		new ASearchBook();
		this.dispose();
	}
	if(o==b6)
	{
		new UpdateBook();
		this.dispose();
	}
	if(o==b7)
	{
		new ViewIssue();
		this.dispose();
	}
	if(o==b8)
	{
		new DeleteBook();
		this.dispose();
		
	}
	if(o==b)
	{
		int m;
		m=JOptionPane.showConfirmDialog(this,"Are You Sure ! You Want To exist From Library?","ConfirmMessage",JOptionPane.YES_NO_OPTION);
		if(m==0)
		{
			this.dispose();
		}
	}
	
	
}



public static void main (String ar[])
{
	new AdminPage();
}
}