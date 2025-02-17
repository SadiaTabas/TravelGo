import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;



public class H3Star extends JFrame implements ActionListener
{
	private JButton button, button1;
	private JTextField tf, tf1, tf2, tf3;
	private JPasswordField pf;
	private ImageIcon img, img1, img2;
	private JLabel BackgroundImage, imgLabel, label, label1, label2, label3;
	
	public H3Star()
	{
		super("Payment of 3 Star Hotel Provider Vendor");
		
		img = new ImageIcon(getClass().getResource("Graphics/1x/payment.png"));
		BackgroundImage = new JLabel (img);
		BackgroundImage.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		
		img1 = new ImageIcon(getClass().getResource("Graphics/1x/VisaCard.png"));
        imgLabel = new JLabel(img1);
        imgLabel.setBounds(300, 40, img1.getIconWidth(), img1.getIconHeight());
        add(imgLabel);
		
		img2 = new ImageIcon(getClass().getResource("Graphics/1x/MasterCard.png"));
        imgLabel = new JLabel(img2);
        imgLabel.setBounds(370, 40, img2.getIconWidth(), img2.getIconHeight());
        add(imgLabel);
		
		label = new JLabel();
        label.setText("CARD NUMBER");
        label.setBounds(50, 70, 200, 50);
		label.setForeground(Color.WHITE);
        
		
		tf = new JTextField();
        tf.setBounds(50, 115, 200, 30);
        
		
		label1 = new JLabel();
        label1.setText("CARD HOLDER");
        label1.setBounds(50, 170, 200, 50);
		label1.setForeground(Color.WHITE);
        
		
		tf1 = new JTextField();
        tf1.setBounds(50, 215, 200, 30);
        
		
		label2 = new JLabel();
        label2.setText("EXPIRATION DATE");
        label2.setBounds(280, 170, 200, 50);
		label2.setForeground(Color.WHITE);
        
		
		tf2 = new JTextField();
        tf2.setBounds(280, 215, 140, 30);
        
		
		label3 = new JLabel();
        label3.setText("CVV");
        label3.setBounds(470, 270, 100, 50);
		label3.setForeground(Color.WHITE);
		
		tf3 = new JTextField();
        tf3.setBounds(470, 315, 200, 30);
        
		
		button = new JButton("Confirm Payment->");
        button.setBounds(600, 400, 170, 50);
        button.setForeground(Color.WHITE);
        Color c = new Color(51,153,255);
		button.setBackground(c);
		
		
		button1 = new JButton("<-Back");
        button1.setBounds(600, 20, 170, 50);
        button1.setForeground(Color.WHITE);
        Color c1 = new Color(51,153,255);
		button1.setBackground(c1);
		
		
		
		add(label);
		add(tf);
		add(label1);
		add(tf1);
		add(label2);
		add(tf2);
        add(label3);
        add(tf3);
		add(button);
		add(button1);
		add(BackgroundImage);
		
		
		button.addActionListener(this);
		button1.addActionListener(this);
		
		
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
            String cn=tf.getText();
            String ch=tf1.getText();
            String ed=tf2.getText();
            String cvv=tf3.getText();
			
                
            if(!cn.isEmpty()&&!ch.isEmpty()&&!ed.isEmpty()&&!cvv.isEmpty())
				{
                    FileWriter writer=null;
                    try
					{
                        writer=new FileWriter("All Text Files/H3PaymentInfo.txt",true);
                        writer.write(cn+","+ch+","+ed+","+cvv+"\n");//card number, card holder, expiration date, cvv
                        JOptionPane.showMessageDialog(this, "Payment Done");
                        writer.close();
						tf.setText("");
			            tf1.setText("");
			            tf2.setText("");
			            tf3.setText("");
                        setVisible(false);
                        new Admin_Balance();
                    }
                    catch(IOException ae)
					{
                        JOptionPane.showMessageDialog(this, "ERROR");
                    }
                    JOptionPane.showMessageDialog(null, "Payment successful", "Congratulation!",
                    JOptionPane.INFORMATION_MESSAGE);
                }
				else if(cn.isEmpty() && ch.isEmpty() && ed.isEmpty() && cvv.isEmpty())
				{
					JOptionPane.showMessageDialog(this, "You forgot to fill Every Field.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
				}
				else if(cn.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill Card Number.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				else if(ch.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill Card Holder's Name.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				else if(ed.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill The Expiration Date.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				else if(cvv.isEmpty())
				{
                    JOptionPane.showMessageDialog(this, "You forgot to fill CVV code.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				
        }
		    else if(e.getSource()==button1)
		    {
			setVisible(false);
			new Admin_Balance();
		    }
	}
	
	public static void main(String[] args)
	{
		new H3Star();
	}
}