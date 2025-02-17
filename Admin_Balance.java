import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;


public class Admin_Balance extends JFrame implements ActionListener
{
	private JButton button, button1, button2, button3, button4, button5,
	                button6, button7, button8, button9, button0, button11;
	private JLabel label,label3,Balance_Label;
	private Font f1;
	private ImageIcon img;
	private JLabel BackgroundImage;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private String[] column = {"Name", "NID", "Phone", "Email"};
	private FileReader reader;
	private BufferedReader bfreader;
	
	public Admin_Balance()
	{
		super("Admin Balance Information");
		
		f1 = new Font("Segoe UI Black", Font.PLAIN, 20);
		
		img = new ImageIcon(getClass().getResource("Graphics/1x/Balance.png"));
		BackgroundImage = new JLabel (img);
		BackgroundImage.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		
		button=new JButton("Balance");
		Color c = new Color(204,204,204);
		Color ct = new Color(0,0,0);
		button.setBackground(c);
        button.setForeground(ct);
		
		button1=new JButton("User List");
		Color c1 = new Color(102,102,102);
		button1.setBackground(c1);
        button1.setForeground(Color.WHITE);
		
		button2=new JButton("Reserved Journey");
		Color c2 = new Color(102,102,102);
		button2.setBackground(c2);
        button2.setForeground(Color.WHITE);
		
		button3=new JButton("Transportation Pricing");
		Color c3 = new Color(102,102,102);
		button3.setBackground(c3);
        button3.setForeground(Color.WHITE);
		
		button4=new JButton("Hotel Pricing");
		Color c4 = new Color(102,102,102);
		button4.setBackground(c4);
        button4.setForeground(Color.WHITE);
		
		button5=new JButton("Logout");
		Color c5 = new Color(102,102,102);
		button5.setBackground(c5);
        button5.setForeground(Color.WHITE);
		
		button6=new JButton("Bus");
		Color c6 = new Color(102,102,102);
		button6.setBackground(c6);
        button6.setForeground(Color.WHITE);
		
		button7=new JButton("Ship");
		Color c7 = new Color(102,102,102);
		button7.setBackground(c7);
        button7.setForeground(Color.WHITE);
		
		button8=new JButton("Train");
		Color c8 = new Color(102,102,102);
		button8.setBackground(c8);
        button8.setForeground(Color.WHITE);
		
		button9=new JButton("5 Star Hotel");
		Color c9 = new Color(102,102,102);
		button9.setBackground(c9);
        button9.setForeground(Color.WHITE);
		
		button0=new JButton("3 Star Hotel");
		Color c0 = new Color(102,102,102);
		button0.setBackground(c0);
        button0.setForeground(Color.WHITE);
		
		button11=new JButton("2 Star Hotel");
		Color c11 = new Color(102,102,102);
		button11.setBackground(c11);
        button11.setForeground(Color.WHITE);
		
		label=new JLabel("Admin Balance");
		label.setBounds(300,5,300,40);
		label.setFont(f1);
		
		String Balance ="";
		try{
			reader = new FileReader("All Text Files/Admin_Banlance.txt");
			bfreader= new BufferedReader(reader);
		
			Balance= bfreader.readLine();
		}catch(Exception E)
		{
			
		}
		
		Font font = new Font("Arial", Font.BOLD, 25);
		
		JLabel Balance_Label= new JLabel("Balance: "+ Balance);
		Balance_Label.setBounds(250, 100,200,50);
		Balance_Label.setFont(font);
		
		
		
		label3=new JLabel("Pay Bills");
		label3.setBounds(640,10,160,40);
		label3.setForeground(Color.WHITE);
		label3.setFont(f1);
		
		
		
		button.setBounds(10,25,180,40);
		button1.setBounds(10,75,180,40);
		button2.setBounds(10,125,180,40);
		button3.setBounds(10,175,180,40);
		button4.setBounds(10,225,180,40);
		button5.setBounds(10,400,180,40);
		button6.setBounds(590,85,180,40);
		button7.setBounds(590,145,180,40);
		button8.setBounds(590,205,180,40);
		button9.setBounds(590,265,180,40);
		button0.setBounds(590,325,180,40);
		button11.setBounds(590,385,180,40);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		button11.addActionListener(this);
		
		
		add(button);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
		add(button0);
		add(button11);
		add(label);
		add(label3);
		add(Balance_Label);
		add(BackgroundImage);
		
		setLayout(null);
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==button)
		{
			setVisible(false);
			new Admin_Balance();
		}
		else if(e.getSource()==button1)
		{
			setVisible(false);
			new UserList();
		}
		else if(e.getSource()==button2)
		{
			setVisible(false);
			new ReservedJourney();
		}
		else if(e.getSource()==button3)
		{
			setVisible(false);
			new TransportationPricing();
		}
		else if(e.getSource()==button4)
		{
			setVisible(false);
			new HotelPricing();
		}
		else if(e.getSource()==button5)
		{
			setVisible(false);
			new Login();
		}
		else if(e.getSource()==button6)
		{
			setVisible(false);
			new Bus();
		}
		else if(e.getSource()==button7)
		{
			setVisible(false);
			new Ship();
		}
		else if(e.getSource()==button8)
		{
			setVisible(false);
			new Train();
		}
		else if(e.getSource()==button9)
		{
			setVisible(false);
			new H5Star();
		}
		else if(e.getSource()==button0)
		{
			setVisible(false);
			new H3Star();
		}
		else if(e.getSource()==button11)
		{
			setVisible(false);
			new H2Star();
		}
	}
	
	public static void main(String[] args)
	{
		new Admin_Balance();
	}
}