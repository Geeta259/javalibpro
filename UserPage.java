import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UserPage extends JFrame implements ActionListener
{
	JLabel l,la,lh,l1,l2,l3,l4,l5,l6,l7,ll,l8;
	JPanel ph,ph1,p2,p1,p3;
	JButton b,b1,b2,b3,b4,b5,b6;
	Font f1;
	ImageIcon  img,imga,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10;

	public UserPage()
	{
		this.setVisible(true);
		this.setTitle("USER PAGE");
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
		
	
		l1=new JLabel("USER PORTAL");
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
		l8=new JLabel(img10);
		l8.setLayout(null);
		l8.setBounds(1100,130,50,40);
		p1.add(l8);
		


		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(210,210,900,210);
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


		img2=new ImageIcon("img5.jpg");
		l3=new JLabel(img2);
		l3.setLayout(null);
		l3.setBounds(300,10,200,140);
		p2.add(l3);
		b2=new JButton("SEARCH BOOKS");
		b2.setBounds(350,160,130,40);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p2.add(b2);

		img3=new ImageIcon("img7.jpg");
		l4=new JLabel(img3);
		l4.setLayout(null);
		l4.setBounds(600,10,200,140);
		p2.add(l4);
		b3=new JButton("ISSUE BOOKS");
		b3.setBounds(650,160,120,40);
		p2.add(b3);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		
		
		
		
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBounds(210,460,900,210);
		p3.setBackground(new Color(221,221,221));
		p1.add(p3);
	
		img4=new ImageIcon("img2.jpg");
		l5=new JLabel(img4);
		l5.setLayout(null);
		l5.setBounds(10,10,200,140);
		p3.add(l5);
		b4=new JButton("MY BOOKS");
		b4.setBounds(60,160,120,40);
		p3.add(b4);
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		
		
		

		img5=new ImageIcon("img11.jpg");
		l6=new JLabel(img5);
		l6.setLayout(null);
		l6.setBounds(300,10,180,140);
		p3.add(l6);
		b5=new JButton("RETURN BOOK");
		b5.setBounds(330,160,120,40);
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		p3.add(b5);


		img6=new ImageIcon("img9.jpg");
		l7=new JLabel(img6);
		l7.setLayout(null);
		l7.setBounds(600,10,180,140);
		p3.add(l7);
		b6=new JButton("MY PROFILE");
		b6.setBounds(630,160,120,40);
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		p3.add(b6);

		
		//add action listener in buttons
		b.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
	}
public void actionPerformed(ActionEvent ae)
{
	Object o = ae.getSource();
	if(o==b1)
	{
		new UViewBook();
		this.dispose();
	}
	if(o==b2)
	{
		new USearchBook();
		this.dispose();
	}
	if(o==b3)
	{
		new IssueBook();
		this.dispose();
	}
	if(o==b4)
	{
		new UBook();
		this.dispose();
	}
	if(o==b5)
	{
		new ReturnBook();
		this.dispose();
	}
	if(o==b6)
	{
		new UProfile();
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
	new UserPage();
}
}