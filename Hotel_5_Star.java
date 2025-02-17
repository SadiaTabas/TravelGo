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

public class Hotel_5_Star extends JFrame implements ActionListener{
	private JLabel label2;
	private JButton balance_button,offerd_price_button,logout_button, Update_Price_Button;
	public FileWriter FW;
	public JTextField R1C5, R2C5, R3C5, R4C5;
	public Login login;
	
	
	public Login getLogin()
	{
		return login;
	}
	
	public Hotel_5_Star()
	{
		super("5 Star Hotel");
		
		JLabel Title_label= new JLabel("5 STAR HOTEL PRICE");
		Title_label.setBounds(350, 50, 400, 50);
		Title_label.setFont(new Font("SansSerif ", Font.BOLD, 30));
		Title_label.setForeground(Color.decode("#477977"));
		
		
		JLabel BackgroundImage_label;
		ImageIcon img = new ImageIcon("Graphics/1x/H_Background.png");
		BackgroundImage_label = new JLabel ("",img,JLabel.CENTER);
		BackgroundImage_label.setBounds(0,0,800,500);
		
																//Current Price form File Reading 
		String Price = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/V_Pricing_H_5_star.txt");
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
		
		JLabel Day_label= new JLabel("Bed");
		Day_label.setBounds(250, 150,100,30);
		Top_Make_UP(Day_label);
		
		
		JLabel Person_label= new JLabel("Day");
		Person_label.setBounds(350, 150,100,30);
		Top_Make_UP(Person_label);
		
		
		
		JLabel Breakfast_label= new JLabel("Breakfast");
		Breakfast_label.setBounds(450, 150,100,30);
		Top_Make_UP(Breakfast_label);
		
		
		JLabel Current_Price_label= new JLabel("Current Price");
		Current_Price_label.setBounds(550, 150,100,30);
		Top_Make_UP(Current_Price_label);
		
		
		JLabel Update_Price_label= new JLabel("Update Price");
		Update_Price_label.setBounds(650, 150,100,30);
		Top_Make_UP(Update_Price_label);
		
		
		//Table Row 1 Contents 
		
		JLabel R1C1= new JLabel("1");
		R1C1.setBounds(250, 180,100,30);
		Bottom_Make_UP(R1C1);
	
		
		JLabel R1C2= new JLabel("1");
		R1C2.setBounds(350, 180,100,30);
		Bottom_Make_UP(R1C2);
		
		
		JLabel R1C3= new JLabel("Y");
		R1C3.setBounds(450, 180,100,30);
		Bottom_Make_UP(R1C3);
		
		
		JLabel R1C4= new JLabel(Prices[0]);
		R1C4.setBounds(550, 180,100,30);
		Bottom_Make_UP(R1C4);
		
		
		R1C5 = new JTextField();
		R1C5.setBounds(650,180,100,30);
		R1C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
															//Table Row 2 Contents 
		
		JLabel R2C1= new JLabel("2");
		R2C1.setBounds(250, 210,100,30);
		Bottom_Make_UP(R2C1);
	
		
		JLabel R2C2= new JLabel("1");
		R2C2.setBounds(350, 210,100,30);
		Bottom_Make_UP(R2C2);
		
		
		JLabel R2C3= new JLabel("Y");
		R2C3.setBounds(450, 210,100,30);
		Bottom_Make_UP(R2C3);
		
		
		JLabel R2C4= new JLabel(Prices[1]);
		R2C4.setBounds(550, 210,100,30);
		Bottom_Make_UP(R2C4);
		
		
		R2C5 = new JTextField();
		R2C5.setBounds(650,210,100,30);
		R2C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																	//Table Row 3 Contents 
		
		JLabel R3C1= new JLabel("1");
		R3C1.setBounds(250, 240,100,30);
		Bottom_Make_UP(R3C1);
	
		
		JLabel R3C2= new JLabel("3");
		R3C2.setBounds(350, 240,100,30);
		Bottom_Make_UP(R3C2);
		
		
		JLabel R3C3= new JLabel("Y");
		R3C3.setBounds(450, 240,100,30);
		Bottom_Make_UP(R3C3);
		
		
		JLabel R3C4= new JLabel(Prices[2]);
		R3C4.setBounds(550, 240,100,30);
		Bottom_Make_UP(R3C4);
		
		
		R3C5 = new JTextField();
		R3C5.setBounds(650,240,100,30);
		R3C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
																			//Table Row 4 Contents 
		
		JLabel R4C1= new JLabel("2");
		R4C1.setBounds(250, 270,100,30);
		Bottom_Make_UP(R4C1);
	
		
		JLabel R4C2= new JLabel("3");
		R4C2.setBounds(350, 270,100,30);
		Bottom_Make_UP(R4C2);
		
		
		JLabel R4C3= new JLabel("Y");
		R4C3.setBounds(450, 270,100,30);
		Bottom_Make_UP(R4C3);
		
		
		JLabel R4C4= new JLabel(Prices[3]);
		R4C4.setBounds(550, 270,100,30);
		Bottom_Make_UP(R4C4);
		
		
		R4C5 = new JTextField();
		R4C5.setBounds(650,270,100,30);
		R4C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
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
		add(Day_label);
		add(Person_label);
		add(Breakfast_label);
		add(Current_Price_label);
		add(Update_Price_label);
		
		add(R1C1);
		add(R1C2);
		add(R1C3);
		add(R1C4);
		add(R1C5);
		
		add(R2C1);
		add(R2C2);
		add(R2C3);
		add(R2C4);
		add(R2C5);
		
		add(R3C1);
		add(R3C2);
		add(R3C3);
		add(R3C4);
		add(R3C5);
		
		add(R4C1);
		add(R4C2);
		add(R4C3);
		add(R4C4);
		add(R4C5);
		
		
		
		add(BackgroundImage_label);
    }
	
	
	
	public void Top_Make_UP(JLabel jlabel)
	{
		jlabel.setForeground(Color.WHITE);
		jlabel.setHorizontalAlignment(SwingConstants.CENTER);
        jlabel.setVerticalAlignment(SwingConstants.CENTER);
        jlabel.setOpaque(true); 
        jlabel.setBackground(Color.decode("#477977"));
        jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
	
	public void Bottom_Make_UP(JLabel jlabel)
	{
		jlabel.setHorizontalAlignment(SwingConstants.CENTER);
        jlabel.setVerticalAlignment(SwingConstants.CENTER);
        jlabel.setOpaque(true); 
        jlabel.setBackground(Color.decode("#E7F2EE"));
        jlabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==balance_button)
		{
			setVisible(false);
			new H_5_Balance();
		}
		else if(e.getSource()==offerd_price_button)
		{
			setVisible(false);
			new Hotel_5_Star();
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
					String Str = R1C5.getText() + "," + R2C5.getText() + "," + R3C5.getText() + "," + R4C5.getText() + "\n";
						
						FW= new FileWriter("All Text Files/V_Pricing_H_5_star.txt");
						
						FW.write(Str);

						FW.close();
						
						JOptionPane.showMessageDialog(null,"Price Has been Updated");
						this.setVisible(false);
						new Hotel_5_Star();
				}
					
					
			}catch(Exception E)
					{
						
					}
		}
		
	}
    public static void main(String[] args) 
	{
        new Hotel_5_Star();
    }
}
