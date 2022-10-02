
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HomePage extends JFrame implements ActionListener
{

	JLabel l,l1,l2,l3,lh,li,lii;
	JPanel p,p1,p2,ph;
	Font f;
	JButton b1,b2,b3;
	ImageIcon img,img1,img2,img3;

	public HomePage()
	{
		this.setVisible(true);
		this.setTitle("WELCOME PAGE");
		this.setSize(600,350);
		this.setLocation(400,150);
		this.setResizable(false);

		//set all panel
		
		 p=new JPanel();
		p.setLayout(null);
		p.setBounds(0,0,600,350);
		//p.setBackground(Color.WHITE);
		p.setBackground(new Color(200,200,200));
		
		
		
		
		
		Font f=new Font("ArialBlack",Font.BOLD,28);
		//Font f1=new Font("ArialBlack",Font.BOLD,28);
		//Font f2=new Font("ArialBlack",Font.BOLD,24);


				ph=new JPanel();
		ph.setLayout(null);
		ph.setBounds(0,10,800,50);
		ph.setBackground(new Color(221,221,221));
		p.add(ph);
		
		lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lh.setBounds(40,10,800,30);
		lh.setForeground(Color.BLACK);
		lh.setFont(f);
		ph.add(lh);

	
		
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.BLACK);
		p1.setBounds(0,80,80,20);
		p.add(p1);
		
		l3=new JLabel("LOGIN AS");
		l3.setBounds(10,0,80,20);
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.WHITE);
		p1.add(l3);
		
		
		
		//img=new ImageIcon("log.jpg");
		img=new ImageIcon("log1.jpg");
		l=new JLabel(img);
		l.setLayout(null);
		l.setBounds(70,80,200,130);
		this.add(p);
		p.add(l);
		
		
		img=new ImageIcon("log2.jpg");
		l=new JLabel(img);
		l.setLayout(null);
		l.setBounds(290,80,200,130);
		this.add(p);
		p.add(l);
	/*	
	
		
		
		
				ph=new JPanel();
		ph.setLayout(null);
		ph.setBounds(0,100,1500,50);
		ph.setBackground(new Color(221,221,221));
		l.add(ph);
		
		
		Font f=new Font("ArialBlack",Font.BOLD,32);
		Font f1=new Font("ArialBlack",Font.BOLD,28);
		Font f2=new Font("ArialBlack",Font.BOLD,24);

		lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
		lh.setBounds(400,10,800,30);
		lh.setForeground(Color.BLACK);
		lh.setFont(f);
		ph.add(lh);
*/


		

		b1=new JButton("ADMIN");
		b1.setBounds(120,210,100,40);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		
		
		p.add(b1);
		
		
		/*img2=new ImageIcon("user.jpg");
		l2=new JLabel(img2);
		l2.setLayout(null);
		l2.setBounds(500,300,400,200);
		l.add(l2);*/
		
		b2=new JButton("MEMBER");
		b2.setBounds(350,210,100,40);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		p.add(b2);
	
		
		

		f=new Font("Arial",Font.BOLD,20);
			
		li=new JLabel("New User? Register Here!!!");
		li.setLayout(null);
		li.setBounds(100,265,320,40);
		//li.setForeground(new Color(85,244,1570));
		li.setForeground(Color.BLACK);
		li.setFont(f);
		p.add(li);
		
		lii=new JLabel("*****************************************************");
		lii.setBounds(90,295,310,10);
		lii.setForeground(Color.BLACK);
		p.add(lii);
		
		b3=new JButton("SIGN IN");
		b3.setBounds(370,270,80,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		p.add(b3);
		
		
	
	b1.addActionListener(this);
	b2.addActionListener(this);	
	b3.addActionListener(this);
		
	}
public void actionPerformed(ActionEvent e)
{
	Object o = e.getSource();
	if(o==b1)
	{
		new ALogin();
		this.dispose();
	}
	if(o==b2)
	{
		new ULogin();
		this.dispose();
	}
	if(o==b3)
	{
		new SignIn();
		this.dispose();
	}

}
public static void main(String ar[])
{
	new HomePage();
}
}