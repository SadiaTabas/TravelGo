import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.lang.*;


public class SignUP extends JFrame implements ActionListener
{
	public JButton Login_Button, Sign_up_Button,Confirm_Button, Clear_Button,Cencel_Button;
	public JTextField Name_Text,email_Text, Mobile_No_Text, password_Text, Cpassword_Text;
	public JTextField Address_Text, NID_Text,Birth_Certificate_text;
	public FileWriter FW;
	private Cursor cursor;
	
	
	public SignUP()
	{
		super("Sign UP Frame");
		
		
		//Cursor for JButtons
		 cursor = new Cursor(Cursor.HAND_CURSOR);
		
		
		JLabel BackgroundImage_label;
		ImageIcon img = new ImageIcon("Graphics/1x/Cover2.jpg");
		BackgroundImage_label = new JLabel ("",img,JLabel.CENTER);
		BackgroundImage_label.setBounds(0,0,800,500);
		
		
		
		JLabel Name_label =new JLabel("Name");
		Name_label.setBounds(20, 20,120,30);
		
		Name_Text =new JTextField();
		//F_Name=First_Name_Text.getText();
		Name_Text.setBounds(140,20,200,25);
		Name_Text.setBorder(null);
		
		
		JLabel Mobile_No_Label =new JLabel("Mobile Number");
		Mobile_No_Label.setBounds(400,20,120,30);
		
		Mobile_No_Text =new JTextField();
		//Mobile_no=Mobile_No_Text.getText();
		Mobile_No_Text.setBounds(540,20,200,25);
		Mobile_No_Text.setBorder(null);
		
		
		
		JLabel email_Label =new JLabel("E-mail");
		email_Label.setBounds(20, 60,120,30);	
		
		email_Text =new JTextField();
		//Email=email_Text.getText();
		email_Text.setBounds(140,60,200,25);
		email_Text.setBorder(null);
		
		
		
		JLabel NID_Label  =new JLabel("NID No:");
		NID_Label.setBounds(400,60,120,30);	
		
		NID_Text =new JTextField();
		//ID_No=NID_Text.getText();
		NID_Text.setBounds(540,60,200,25);
		NID_Text.setBorder(null);
		
		
		
		
		
		
		
		
		
		JLabel password_Lable = new JLabel("Password");
		password_Lable.setBounds(70,150,80,30);
		
		password_Text =new JPasswordField();
		//Password=password_Text.getText();
		password_Text.setBounds(170,150,200,25);
		password_Text.setBorder(null);
		
		
		JLabel Cpassword_Lable = new JLabel("Cnfm Password");
		Cpassword_Lable.setBounds(390,150,100,30);
		
		Cpassword_Text =new JPasswordField();
		//CPassword=Cpassword_Text.getText();
		Cpassword_Text.setBounds(500,150,200,25);
		Cpassword_Text.setBorder(null);
		
		
		
		
					// All Buttons 
		Login_Button = new JButton("Go to Login");
		Login_Button.setBounds(100,230,100,30);
		Login_Button.addActionListener(this);
		Login_Button.setBorder(null);
		Login_Button.setCursor(cursor);			
					
		Confirm_Button = new JButton("Confirm Registration");
		Confirm_Button.setBounds(300,230,200,30);
		Confirm_Button.addActionListener(this);
		Confirm_Button.setBorder(null);
		Confirm_Button.setCursor(cursor);
		

		Clear_Button = new JButton("Clear All");
		Clear_Button.setBounds(600,230,100,30);
		Clear_Button.addActionListener(this);
		Clear_Button.setBorder(null);
		Clear_Button.setCursor(cursor);
		
		
		
		Cencel_Button = new JButton("Cancel");
		Cencel_Button.setBounds(350,290,100,30);
		Cencel_Button.addActionListener(this);
		Cencel_Button.setBorder(null);
		Cencel_Button.setCursor(cursor);
		
		
		
					// SignUP Frame Properties 
		this.setSize(800,500);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false	);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
					//Adding Properties in SignUP Frame//
		
		this.add(Name_label);
		this.add(Name_Text);
		this.add(email_Label);
		this.add(email_Text);
		this.add(Mobile_No_Label);
		this.add(Mobile_No_Text);
		this.add(password_Lable);
		this.add(password_Text);
		this.add(Cpassword_Lable);
		this.add(Cpassword_Text); 
		this.add(NID_Label);
		this.add(NID_Text);
		
		
		
		
		this.add(Confirm_Button); 
		this.add(Clear_Button); 
		this.add(Login_Button); 
		this.add(Cencel_Button); 
		
		
		
		this.add(BackgroundImage_label);
		
	}
	
	
	
	public void ClearAll()
	{
			Name_Text.setText("");
			email_Text.setText("");
			Mobile_No_Text.setText("");
			NID_Text.setText("");
			password_Text.setText("");
			Cpassword_Text.setText("");
	}
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==Confirm_Button)
		{
			if(Name_Text.getText().isEmpty() || email_Text.getText().isEmpty() ||Mobile_No_Text.getText().isEmpty() ||password_Text.getText().isEmpty() ||Cpassword_Text.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(this,"Please fill up all the fields");
				}
				
			else
			{
				String Pass = password_Text.getText();
			String CPass = Cpassword_Text.getText();
			if(Pass.equals(CPass))
			{
				try{
				
				
				String Str = email_Text.getText()+","+
							 password_Text.getText()+","+
							 Name_Text.getText()+","+
							 Mobile_No_Text.getText()+","+
							 NID_Text.getText()+","+"200000.00"+"\n";
				
				
				
				FW= new FileWriter("All Text Files/UserInfo.txt",true);
				
				FW.write(Str);

				FW.close();
			}
			catch(Exception E)
			{
				
			}
			
			ClearAll();
			JOptionPane.showMessageDialog(null,"Registration Successfull");
			}
			
			else{
				JOptionPane.showMessageDialog(null,"Password does'n macthed");
			}
			}			
		}
		
		else if(e.getSource()==Clear_Button)
		{
			ClearAll();
		}
		
		else if(e.getSource()==Login_Button)
		{
			this.setVisible(false);
			new Login();
		}
		
		else if (e.getSource()==Cencel_Button)
		{
			this.setVisible(false);
			//this.dispose();
			  System.exit(0);
		}
		
		
	}
	
	
	public static void main(String [] args)
	{
		new SignUP();
	}
}