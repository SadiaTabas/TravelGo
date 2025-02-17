import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;

public class AddAdmin extends JFrame implements ActionListener
{
	private JButton button, button1;
	private JTextField tf, tf1, tf2, tf3, tf4, tf5;
	private ImageIcon img;
	private JLabel BackgroundImage, label, label1, label2, label3, label4,label5, label6;
	private Font f1, f2;
	
	public AddAdmin()
	{
		super("Admin Planel/Add Admin");
		
		f1 = new Font("Segoe UI Black", Font.PLAIN, 25);
		f2 = new Font("Segoe UI Black", Font.PLAIN, 15);
		
		img = new ImageIcon(getClass().getResource("Graphics/1x/Admin_Background.png"));
		BackgroundImage = new JLabel (img);
		BackgroundImage.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		
		button=new JButton("<-Back");
		Color c = new Color(102,102,102);
		button.setBackground(c);
        button.setForeground(Color.WHITE);
		
		button1=new JButton("Add->");
		Color c1 = new Color(102,102,102);
		button1.setBackground(c1);
        button1.setForeground(Color.WHITE);
		
		button.setBounds(10,25,130,40);
		button1.setBounds(640,395,130,40);
		button.addActionListener(this);
		button1.addActionListener(this);
		
		
		label6 = new JLabel();
        label6.setText("Enter Your All Informations");
        label6.setBounds(225,5,400,40);
		Color c2 = new Color(102,102,102);
		label6.setForeground(c2);
		label6.setFont(f1);
		
		
		label = new JLabel();
        label.setText("Enter Your Email     :");
        label.setBounds(220, 75, 200, 40);
		Color c6 = new Color(102,102,102);
		label.setForeground(c6);
		label.setFont(f2);
        
		
		tf = new JTextField();
        tf.setBounds(400, 75, 270, 40);
        
		
		label1 = new JLabel();
        label1.setText("Enter Your Password    :");
        label1.setBounds(220, 130, 200, 40);
		Color c3 = new Color(102,102,102);
		label1.setForeground(c3);
		label1.setFont(f2);
        
		
		tf1 = new JTextField();
        tf1.setBounds(400, 130, 270, 40);
        
		
		label2 = new JLabel();
        label2.setText("Enter Your Name		:");
        label2.setBounds(220, 185, 200, 40);
		Color c4 = new Color(102,102,102);
		label2.setForeground(c4);
		label2.setFont(f2);
        
		
		tf2 = new JTextField();
        tf2.setBounds(400, 185, 270, 40);
        
		
		label3 = new JLabel();
        label3.setText("Enter Your Phone :");
        label3.setBounds(220, 240, 200, 40);
		Color c5 = new Color(102,102,102);
		label3.setForeground(c5);
		label3.setFont(f2);
		
		tf3 = new JTextField();
        tf3.setBounds(400, 240, 270, 40);
		
		label4 = new JLabel();
        label4.setText("Enter Your NID :");
        label4.setBounds(220, 295, 200, 40);
		Color c8 = new Color(102,102,102);
		label4.setForeground(c8);
		label4.setFont(f2);
		
		tf4 = new JTextField();
        tf4.setBounds(400, 295, 270, 40);
		
		label5 = new JLabel();
        label5.setText("Enter Your Balance :");
        label5.setBounds(220, 350, 200, 40);
		Color c7 = new Color(102,102,102);
		label5.setForeground(c7);
		label5.setFont(f2);
		
		tf5 = new JTextField();
        tf5.setBounds(400, 350, 270, 40);
		
		
		add(button);
		add(button1);
		add(label);
		add(tf);
		add(label1);
		add(tf1);
		add(label2);
		add(tf2);
        add(label3);
        add(tf3);
		add(label4);
        add(tf4);
		add(label5);
        add(tf5);
		add(label4);
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
			new UserList();
		}
		else if(e.getSource()==button1)
		{
            String email=tf.getText();
            String password=tf1.getText();
            String name=tf2.getText();
            String phone=tf3.getText();
            String nid=tf4.getText();
            String balance=tf5.getText();
			
                
            if(!email.isEmpty()&&!password.isEmpty()&&!name.isEmpty()&&!phone.isEmpty()&&!nid.isEmpty()&&!balance.isEmpty())
				{
                    FileWriter writer=null;
                    try
					{
                        writer=new FileWriter("All Text Files/UserInfo.txt",true);
                        writer.write(email+","+password+","+name+","+phone+","+nid+","+balance+"\n");//name, phone, email, password
                        JOptionPane.showMessageDialog(this, "Information Successfully Added");
                        writer.close();
						tf.setText("");
			            tf1.setText("");
			            tf2.setText("");
			            tf3.setText("");
			            tf4.setText("");
			            tf5.setText("");
                        setVisible(false);
                        new UserList();
                    }
                    catch(IOException ae)
					{
                        JOptionPane.showMessageDialog(this, "ERROR");
                    }
                    JOptionPane.showMessageDialog(null, "Adding was successful", "Congratulation!",
                    JOptionPane.INFORMATION_MESSAGE);
                }
				else if(email.isEmpty() && password.isEmpty() && name.isEmpty() && phone.isEmpty() && nid.isEmpty() && balance.isEmpty())
				{
					JOptionPane.showMessageDialog(this, "You forgot to fill Every Field.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
				}
				else if(name.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill Name.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				else if(phone.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill Phone Number.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				else if(email.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill Mail Address.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				else if(password.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill Password.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				else if(nid.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill Password.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				else if(balance.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill Password.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
		}
	}
	
	public static void main(String[] args)
	{
		new AddAdmin();
	}
}