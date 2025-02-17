import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.File; 
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.lang.*;
import java.awt.Color;
import java.util.Scanner;

public class Bus_Provider_Balance extends JFrame implements ActionListener{
	private JLabel label2;
	private JButton balance_button,offerd_price_button,logout_button;
	private Login login;
	public FileReader reader;
	public BufferedReader bfreader;
	
	
	public Bus_Provider_Balance()
	{
		super("BUS SERVICE PROVIDER");
		
		this.login=login;
		
		JLabel Title_label= new JLabel("BUS SERVICE PROVIDER");
		Title_label.setBounds(350, 10, 400, 50);
		Title_label.setFont(new Font("SansSerif ", Font.BOLD, 30));
		Title_label.setForeground(Color.decode("#477977"));
		
		
		
		String Balance ="";
		try{
			reader = new FileReader("All Text Files/balance_Bus_Provider.txt");
			bfreader= new BufferedReader(reader);
		
			Balance= bfreader.readLine();
		}catch(Exception E)
		{
			
		}
		
		Font font = new Font("Arial", Font.BOLD, 25);
		
		JLabel Balance_Label= new JLabel("Balance: "+ Balance);
		Balance_Label.setBounds(250, 100,200,50);
		Balance_Label.setForeground(Color.decode("#477977"));
		Balance_Label.setFont(font);
		
		
		
		JLabel BackgroundImage_label;
		ImageIcon img = new ImageIcon("Graphics/1x/H_Background.png");
		BackgroundImage_label = new JLabel ("",img,JLabel.CENTER);
		BackgroundImage_label.setBounds(0,0,800,500);
		
		
		offerd_price_button = new JButton("Offered Price");
        offerd_price_button.setBounds(20, 50, 150, 30);
		offerd_price_button.addActionListener(this);
		
        balance_button = new JButton("Balance");
        balance_button.setBounds(20, 100, 150, 30);
		balance_button.addActionListener(this);		
		 
		logout_button = new JButton("Logout");
        logout_button.setBounds(20, 420, 150, 30);
		logout_button.addActionListener(this);
		
        
		//layout,size,color
		
		this.setSize(800,500);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		add(balance_button);
        add(offerd_price_button);
		add(logout_button);
		add(Balance_Label);
		add(Title_label);
		add(BackgroundImage_label);
    }
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==balance_button)
		{
			setVisible(false);
			new Bus_Provider_Balance();
		}
		else if(e.getSource()==offerd_price_button)
		{
			setVisible(false);
			new Bus_Service_Provider();
		}
		else if(e.getSource()==logout_button)
		{
			setVisible(false);
			new Login();
		}
	}

    

    public static void main(String[] args) {
        new Bus_Provider_Balance();
    }
}
