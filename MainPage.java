import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
		
class MainPage extends JFrame implements ActionListener
{		
			
		JPanel p,ph;
		JButton b,b1;
		JLabel l,lh;
		ImageIcon img;
		
		public MainPage()
		{
				this.setVisible(true);
				this.setTitle("HOME PAGE");
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
			
				img=new ImageIcon("home.jpg");
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
				
				Font f1=new Font("ArialBlack",Font.BOLD,18);
				
				
				lh=new JLabel("LIBRARY MANAGEMENT SYSTEM");
				lh.setBounds(430,10,800,30);
				lh.setForeground(Color.BLACK);
				lh.setFont(f);
				ph.add(lh);
				
				b=new JButton("LOGIN");
				b.setBounds(10,150,120,40);
				b.setBackground(Color.BLACK);
				b.setForeground(Color.WHITE);
				b.setFont(f1);
				b.addActionListener(this);
				l.add(b);
		
					
				b1=new JButton("LOGOUT");
				b1.setBounds(10,200,120,40);
				b1.setBackground(Color.BLACK);
				b1.setForeground(Color.WHITE);
				b1.setFont(f1);
				b1.addActionListener(this);
				l.add(b1);

	}
	
	public void actionPerformed(ActionEvent e)
{
	Object o = e.getSource();
	if(o==b)
	{
		new HomePage();
			
		
	}
	if(o==b1)
	{
		
		int m;
		m=JOptionPane.showConfirmDialog(this,"Are You Sure ! You Want To exist From Library?","ConfirmMessage",JOptionPane.YES_NO_OPTION);
		if(m==0)
		{
			this.dispose();
		}
		
	}
}
			public static void main(String ar[])
		{
			
			new MainPage();
			
		}
}		
