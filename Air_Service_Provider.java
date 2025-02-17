import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.lang.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class Air_Service_Provider extends JFrame implements ActionListener{

	private JLabel label2;
	private JButton balance_button,offerd_price_button,logout_button, Update_Price_Button;
	public FileWriter FW;
	public JTextField R1C5, R2C5, R3C5, R4C5, R5C5, R6C5;
	
	
	public Air_Service_Provider()
	{
		super("AIR SERVICE PROVIDER");
		
		
		
		JLabel Title_label= new JLabel("AIR SERVICE PROVIDER");
		Title_label.setBounds(350, 10, 400, 50);
		Title_label.setFont(new Font("SansSerif ", Font.BOLD, 30));
		Title_label.setForeground(Color.decode("#295982"));
		
		
		JLabel BackgroundImage_label;
		ImageIcon img = new ImageIcon("Graphics/1x/T_Background.png");
		BackgroundImage_label = new JLabel ("",img,JLabel.CENTER);
		BackgroundImage_label.setBounds(0,0,800,500);
		
																//Current Price form File Reading 
		String Price = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/V_Pricing_Air_Service.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				Price += line;
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] lines = Price.split("/n"); // Split text into an array of lines
		String[] Prices = lines[0].split(","); // Split first line into an array of words using comma as delimiter
		
		
		//Table top
		
		JLabel Place_label= new JLabel("Place");
		Place_label.setBounds(250, 100,200,30);
		Place_label.setForeground(Color.WHITE);
		Place_label.setHorizontalAlignment(SwingConstants.CENTER);
        Place_label.setVerticalAlignment(SwingConstants.CENTER);
        Place_label.setOpaque(true); 
        Place_label.setBackground(Color.decode("#295982"));
        Place_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	
		
		JLabel Feature_label= new JLabel("Class");
		Feature_label.setBounds(450, 100,100,30);
		Feature_label.setForeground(Color.WHITE);
		Feature_label.setHorizontalAlignment(SwingConstants.CENTER);
        Feature_label.setVerticalAlignment(SwingConstants.CENTER);
        Feature_label.setOpaque(true); 
        Feature_label.setBackground(Color.decode("#295982"));
        Feature_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		JLabel Current_Price_label= new JLabel("Current Price");
		Current_Price_label.setBounds(550, 100,100,30);
		Current_Price_label.setForeground(Color.WHITE);
		Current_Price_label.setHorizontalAlignment(SwingConstants.CENTER);
        Current_Price_label.setVerticalAlignment(SwingConstants.CENTER);
        Current_Price_label.setOpaque(true); 
        Current_Price_label.setBackground(Color.decode("#295982"));
        Current_Price_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		JLabel Update_Price_label= new JLabel("Update Price");
		Update_Price_label.setBounds(650, 100,100,30);
		Update_Price_label.setForeground(Color.WHITE);
		Update_Price_label.setHorizontalAlignment(SwingConstants.CENTER);
        Update_Price_label.setVerticalAlignment(SwingConstants.CENTER);
        Update_Price_label.setOpaque(true); 
        Update_Price_label.setBackground(Color.decode("#295982"));
        Update_Price_label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
														//Cox's Bazar Business class
		
		JLabel R1C1= new JLabel("Cox's Bazar");
		R1C1.setBounds(250, 130,200,30);
		R1C1.setHorizontalAlignment(SwingConstants.CENTER);
        R1C1.setVerticalAlignment(SwingConstants.CENTER);
        R1C1.setOpaque(true); 
        R1C1.setBackground(Color.decode("#E7F2EE"));
        R1C1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	
	
		JLabel R1C3= new JLabel("Business");
		R1C3.setBounds(450, 130,100,30);
		R1C3.setHorizontalAlignment(SwingConstants.CENTER);
        R1C3.setVerticalAlignment(SwingConstants.CENTER);
        R1C3.setOpaque(true); 
        R1C3.setBackground(Color.decode("#E7F2EE"));
        R1C3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		JLabel R1C4= new JLabel(Prices[0]);
		R1C4.setBounds(550, 130,100,30);
		R1C4.setHorizontalAlignment(SwingConstants.CENTER);
        R1C4.setVerticalAlignment(SwingConstants.CENTER);
        R1C4.setOpaque(true); 
        R1C4.setBackground(Color.decode("#E7F2EE"));
        R1C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		R1C5 = new JTextField();
		R1C5.setBounds(650,130,100,30);
		R1C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
															//Cox's Bazar Economy Class
		
		JLabel R2C1= new JLabel("Cox's Bazar");
		R2C1.setBounds(250, 160,200,30);
		R2C1.setHorizontalAlignment(SwingConstants.CENTER);
        R2C1.setVerticalAlignment(SwingConstants.CENTER);
        R2C1.setOpaque(true); 
        R2C1.setBackground(Color.decode("#E7F2EE"));
        R2C1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	
		
		JLabel R2C3= new JLabel("Economy");
		R2C3.setBounds(450, 160,100,30);
		R2C3.setHorizontalAlignment(SwingConstants.CENTER);
        R2C3.setVerticalAlignment(SwingConstants.CENTER);
        R2C3.setOpaque(true); 
        R2C3.setBackground(Color.decode("#E7F2EE"));
        R2C3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		JLabel R2C4= new JLabel(Prices[1]);
		R2C4.setBounds(550, 160,100,30);
		R2C4.setHorizontalAlignment(SwingConstants.CENTER);
        R2C4.setVerticalAlignment(SwingConstants.CENTER);
        R2C4.setOpaque(true); 
        R2C4.setBackground(Color.decode("#E7F2EE"));
        R2C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		R2C5 = new JTextField();
		R2C5.setBounds(650,160,100,30);
		R2C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																	//Sylhet  Business
		
		JLabel R3C1= new JLabel("Sylhet");
		R3C1.setBounds(250, 190,200,30);
		R3C1.setHorizontalAlignment(SwingConstants.CENTER);
        R3C1.setVerticalAlignment(SwingConstants.CENTER);
        R3C1.setOpaque(true); 
        R3C1.setBackground(Color.decode("#E7F2EE"));
        R3C1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	
		
		JLabel R3C3= new JLabel("Business");
		R3C3.setBounds(450, 190,100,30);
		R3C3.setHorizontalAlignment(SwingConstants.CENTER);
        R3C3.setVerticalAlignment(SwingConstants.CENTER);
        R3C3.setOpaque(true); 
        R3C3.setBackground(Color.decode("#E7F2EE"));
        R3C3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		JLabel R3C4= new JLabel(Prices[2]);
		R3C4.setBounds(550, 190,100,30);
		R3C4.setHorizontalAlignment(SwingConstants.CENTER);
        R3C4.setVerticalAlignment(SwingConstants.CENTER);
        R3C4.setOpaque(true); 
        R3C4.setBackground(Color.decode("#E7F2EE"));
        R3C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		R3C5 = new JTextField();
		R3C5.setBounds(650,190,100,30);
		R3C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
																			//Sylhet Economy Class
		
		JLabel R4C1= new JLabel("Sylhet");
		R4C1.setBounds(250, 220,200,30);
		R4C1.setHorizontalAlignment(SwingConstants.CENTER);
        R4C1.setVerticalAlignment(SwingConstants.CENTER);
        R4C1.setOpaque(true); 
        R4C1.setBackground(Color.decode("#E7F2EE"));
        R4C1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	
		
		JLabel R4C3= new JLabel("Economy");
		R4C3.setBounds(450, 220,100,30);
		R4C3.setHorizontalAlignment(SwingConstants.CENTER);
        R4C3.setVerticalAlignment(SwingConstants.CENTER);
        R4C3.setOpaque(true); 
        R4C3.setBackground(Color.decode("#E7F2EE"));
        R4C3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		JLabel R4C4= new JLabel(Prices[3]);
		R4C4.setBounds(550, 220,100,30);
		R4C4.setHorizontalAlignment(SwingConstants.CENTER);
        R4C4.setVerticalAlignment(SwingConstants.CENTER);
        R4C4.setOpaque(true); 
        R4C4.setBackground(Color.decode("#E7F2EE"));
        R4C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		R4C5 = new JTextField();
		R4C5.setBounds(650,220,100,30);
		R4C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
																			//Bandarban  Business Class
		
		JLabel R5C1= new JLabel("Bandarban");
		R5C1.setBounds(250, 250,200,30);
		R5C1.setHorizontalAlignment(SwingConstants.CENTER);
        R5C1.setVerticalAlignment(SwingConstants.CENTER);
        R5C1.setOpaque(true); 
        R5C1.setBackground(Color.decode("#E7F2EE"));
        R5C1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	
		
		JLabel R5C3= new JLabel("Business");
		R5C3.setBounds(450, 250,100,30);
		R5C3.setHorizontalAlignment(SwingConstants.CENTER);
        R5C3.setVerticalAlignment(SwingConstants.CENTER);
        R5C3.setOpaque(true); 
        R5C3.setBackground(Color.decode("#E7F2EE"));
        R5C3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		JLabel R5C4= new JLabel(Prices[4]);
		R5C4.setBounds(550, 250,100,30);
		R5C4.setHorizontalAlignment(SwingConstants.CENTER);
        R5C4.setVerticalAlignment(SwingConstants.CENTER);
        R5C4.setOpaque(true); 
        R5C4.setBackground(Color.decode("#E7F2EE"));
        R5C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		R5C5 = new JTextField();
		R5C5.setBounds(650,250,100,30);
		R5C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
																			//Bandarban Economy Class
		
		JLabel R6C1= new JLabel("Bandarban");
		R6C1.setBounds(250, 280,200,30);
		R6C1.setHorizontalAlignment(SwingConstants.CENTER);
        R6C1.setVerticalAlignment(SwingConstants.CENTER);
        R6C1.setOpaque(true); 
        R6C1.setBackground(Color.decode("#E7F2EE"));
        R6C1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	
		
		JLabel R6C3= new JLabel("Economy");
		R6C3.setBounds(450, 280,100,30);
		R6C3.setHorizontalAlignment(SwingConstants.CENTER);
        R6C3.setVerticalAlignment(SwingConstants.CENTER);
        R6C3.setOpaque(true); 
        R6C3.setBackground(Color.decode("#E7F2EE"));
        R6C3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		JLabel R6C4= new JLabel(Prices[5]);
		R6C4.setBounds(550, 280,100,30);
		R6C4.setHorizontalAlignment(SwingConstants.CENTER);
        R6C4.setVerticalAlignment(SwingConstants.CENTER);
        R6C4.setOpaque(true); 
        R6C4.setBackground(Color.decode("#E7F2EE"));
        R6C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		R6C5 = new JTextField();
		R6C5.setBounds(650,280,100,30);
		R6C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																		//All Buttons 
		
		
		offerd_price_button = new JButton("Offered Price");
        offerd_price_button.setBounds(20, 50, 150, 30);
		offerd_price_button.addActionListener(this);
		
        balance_button = new JButton("Balance");
        balance_button.setBounds(20, 100, 150, 30);
		balance_button.addActionListener(this);		
		 
		logout_button = new JButton("Logout");
        logout_button.setBounds(20, 420, 150, 30);
		logout_button.addActionListener(this);
		
		Update_Price_Button = new JButton("UPDATE");
        Update_Price_Button.setBounds(375, 350, 200, 50);
        Update_Price_Button.setFont(new Font("SansSerif ", Font.BOLD, 30));
		Update_Price_Button.addActionListener(this);
		
        
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
		add(Title_label);
		add(Update_Price_Button);
		add(Place_label);
		add(Feature_label);
		add(Current_Price_label);
		add(Update_Price_label);
		
		add(R1C1);
		add(R1C3);
		add(R1C4);
		add(R1C5);
		
		add(R2C1);
		add(R2C3);
		add(R2C4);
		add(R2C5);
		
		add(R3C1);
		add(R3C3);
		add(R3C4);
		add(R3C5);
		
		add(R4C1);
		add(R4C3);
		add(R4C4);
		add(R4C5);
		
		add(R5C1);
		add(R5C3);
		add(R5C4);
		add(R5C5);
		
		add(R6C1);
		add(R6C3);
		add(R6C4);
		add(R6C5);
		
		
		
		add(BackgroundImage_label);
    }
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==balance_button)
		{
			setVisible(false);
			new Air_Provider_Balance();
		}
		else if(e.getSource()==offerd_price_button)
		{
			setVisible(false);
			new Air_Service_Provider();
		}
		else if(e.getSource()==logout_button)
		{
			setVisible(false);
			new Login();
		}
		else if(e.getSource()==Update_Price_Button)
		{
			
		try
			{
				String R1C5_S=R1C5.getText(), R2C5_S=R2C5.getText(), R3C5_S=R3C5.getText(), R4C5_S=R4C5.getText();
				if(R1C5_S.isEmpty() || R2C5_S.isEmpty()|| R3C5_S.isEmpty()|| R4C5_S.isEmpty())
				{	
					JOptionPane.showMessageDialog(this,"Please fill up all the fields");
				}
				else
				{
					String Str = R1C5.getText() + ","+ R2C5.getText()+ "," + R3C5.getText() + "," + R4C5.getText()+"," + R5C5.getText()+"," + R6C5.getText() + "\n";
						
						FW= new FileWriter("All Text Files/V_Pricing_Air_Service.txt");
						
						FW.write(Str);

						FW.close();
						
						JOptionPane.showMessageDialog(null,"Price Has been Updated");
						this.setVisible(false);
						new Air_Service_Provider();
				}
					
					
			}catch(Exception E)
					{
						
					}
		}
		
	}
    public static void main(String[] args) {
		
        new Air_Service_Provider();
    }
}
