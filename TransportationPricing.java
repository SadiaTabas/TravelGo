import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;
import java.util.Arrays;



public class TransportationPricing extends JFrame implements ActionListener
{
	private JButton button, button1, button2, button3, button4, button5, button6, button7;
	private JLabel label,label1;
	private JTable table;
	private JScrollPane scroll, scroll1, scroll2;
	private DefaultTableModel model;
	private ImageIcon img;
	private JLabel BackgroundImage;
	public FileWriter FW;
	public FileReader reader;
    public BufferedReader bfreader;
	public String[] Places;
    public String[] Features;
	public JTextField  R1C4,  R2C4,  R3C4,  R4C4, bR1C4,  bR2C4,  bR3C4,  bR4C4,  tR4C4, tR1C4,  tR2C4,  tR3C4;
    public String[] Prices;

	
	
	public TransportationPricing()
	{
		super("Transportation Pricing");
		
		img = new ImageIcon(getClass().getResource("Graphics/1x/Background.png"));
		BackgroundImage = new JLabel (img);
		BackgroundImage.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		
		button=new JButton("Balance");
		Color c = new Color(102,102,102);
		button.setBackground(c);
        button.setForeground(Color.WHITE);
		
		button1=new JButton("User List");
		Color c1 = new Color(102,102,102);
		button1.setBackground(c1);
        button1.setForeground(Color.WHITE);
		
		button2=new JButton("Reserved Journey");
		Color c2 = new Color(102,102,102);
		button2.setBackground(c2);
        button2.setForeground(Color.WHITE);
		
		button3=new JButton("Transportation Pricing");
		Color c3 = new Color(204,204,204);
		Color ct = new Color(0,0,0);
		button3.setBackground(c3);
        button3.setForeground(ct);
		
		button4=new JButton("Hotel Pricing");
		Color c4 = new Color(102,102,102);
		button4.setBackground(c4);
        button4.setForeground(Color.WHITE);
		
		button5=new JButton("Logout");
		Color c5 = new Color(102,102,102);
		button5.setBackground(c5);
        button5.setForeground(Color.WHITE);
		
		button6=new JButton("Update Air");
		Color c6 = new Color(102,102,102);
		button6.setBackground(c6);
        button6.setForeground(Color.WHITE);
		
		button7=new JButton("Update Bus");
		Color c7 = new Color(102,102,102);
		button7.setBackground(c7);
        button7.setForeground(Color.WHITE);
		
		/*button8=new JButton("Update");
		Color c8 = new Color(102,102,102);
		button8.setBackground(c7);
        button8.setForeground(Color.WHITE);*/
		
		//Table 1
		label = new JLabel("Transportation Vendor(Air)");
        label.setBounds(400, 10, 400, 30);
		
		//Vendor Air Pricing
		
		
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
		
		//Admin Air Pricing
		
		
		String fPrice = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/AdminAir.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String fline = bufferedReader.readLine();
			while (fline != null) {
				fPrice += fline;
				fline = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] flines = fPrice.split("/n"); // Split text into an array of lines
		String[] fPrices = flines[0].split(","); // Split first line into an array of words using comma as delimiter
		
		
		
		
		//Table top
		
		JLabel Place= new JLabel("Place");
		Place.setBounds(250, 40,90,30);
		Top_Make_UP(Place);
		add(Place);
		
		
		JLabel Feature= new JLabel("Feature");
		Feature.setBounds(340, 40,90,30);
		Top_Make_UP(Feature);
		add(Feature);
		
		
		JLabel aPrice= new JLabel("Vendon Price");
		aPrice.setBounds(430, 40,90,30);
		Top_Make_UP(aPrice);
		add(aPrice);
		
		
		
		JLabel Current_Price= new JLabel("Current Price");
		Current_Price.setBounds(520, 40,90,30);
		Top_Make_UP(Current_Price);
		add(Current_Price);
		
		
		
		JLabel Update_Price= new JLabel("Update Price");
		Update_Price.setBounds(610, 40,90,30);
		Top_Make_UP(Update_Price);
		add(Update_Price);
		
		
		//Table Row 1 Contents 
		
		JLabel R1C1= new JLabel("Any");
		R1C1.setBounds(250, 70,90,30);
		Bottom_Make_UP(R1C1);
		add(R1C1);
	
		
		JLabel R1C2= new JLabel("Business");
		R1C2.setBounds(340, 70,90,30);
		Bottom_Make_UP(R1C2);
		add(R1C2);
		
		
		JLabel R1C3= new JLabel(Prices[0]);
		R1C3.setBounds(430, 70,90,30);
		Bottom_Make_UP(R1C3);
		add(R1C3);
		
		
		JLabel R1C5= new JLabel(fPrices[0]);
		R1C5.setBounds(520, 70,90,30);
		Top_Make_UP(R1C5);
		add(R1C5);
		
		
		R1C4 = new JTextField();
		R1C4.setBounds(610, 70,90,30);
		R1C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
															//Table Row 2 Contents 
		
		JLabel  R2C1= new JLabel("Any");
		R2C1.setBounds(250, 100,90,30);
		Bottom_Make_UP(R2C1);
		add(R2C1);
	
		
		JLabel  R2C2= new JLabel("Economy");
		R2C2.setBounds(340, 100,90,30);
		Bottom_Make_UP(R2C2);
		add(R2C2);
		
		
		JLabel  R2C3= new JLabel(Prices[1]);
		R2C3.setBounds(430, 100,90,30);
		Bottom_Make_UP(R2C3);
		add(R2C3);
		
		
		JLabel R2C5= new JLabel(fPrices[1]);
		R2C5.setBounds(520, 100,90,30);
		Top_Make_UP(R2C5);
		add(R2C5);


		R2C4 = new JTextField();
		R2C4.setBounds(610, 100,90,30);
		R2C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																	//Table Row 3 Contents 
		/*
		JLabel R3C1= new JLabel("TEKNAF");
		R3C1.setBounds(250, 130,90,30);
		Bottom_Make_UP(R3C1);
		add(R3C1);
	
		
		JLabel R3C2= new JLabel("Business");
		R3C2.setBounds(340, 130,90,30);
		Bottom_Make_UP(R3C2);
		add(R3C2);
		
		
		JLabel R3C3= new JLabel(fPrices[2]);
		R3C3.setBounds(430, 130,90,30);
		Bottom_Make_UP(R3C3);
		add(R3C3);
		
		
		JLabel R3C5= new JLabel(Prices[2]);
		R3C5.setBounds(520, 130,90,30);
		Top_Make_UP(R3C5);
		add(R3C5);
		
		
		R3C4 = new JTextField();
		R3C4.setBounds(610, 130,90,30);
		R3C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
																			//Table Row 4 Contents 
		
		JLabel R4C1= new JLabel("BANDORBAN");
		R4C1.setBounds(250, 160,90,30);
		Bottom_Make_UP(R4C1);
		add(R4C1);
	
		
		JLabel R4C2= new JLabel("Economy");
		R4C2.setBounds(340, 160,90,30);
		Bottom_Make_UP(R4C2);
		add(R4C2);

		
		JLabel R4C3= new JLabel(Prices[3]);
		R4C3.setBounds(430, 160,90,30);
		Bottom_Make_UP(R4C3);
		add(R4C3);
		
		
		JLabel R4C5= new JLabel(fPrices[3]);
		R4C5.setBounds(520, 160,90,30);
		Top_Make_UP(R4C5);
		add(R4C5);
		
		
		R4C4 = new JTextField();
		R4C4.setBounds(610, 160,90,30);
		R4C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		*/
		
		//Table 2
		
		
		//table 2
		label1 = new JLabel("Transportation Vendor(Bus)");
        label1.setBounds(400, 190, 400, 30);
		
		//Vendor Bus Pricing
		
		String bPrice = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/V_Pricing_Bus_Service.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				bPrice += line;
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] blines = bPrice.split("/n"); // Split text into an array of lines
		String[] bPrices = blines[0].split(","); // Split first line into an array of words using comma as delimiter
		
		
		//Admin Bur Pricing
		
		
		String h3Price = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/AdminBus.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String h3line = bufferedReader.readLine();
			while (h3line != null) {
				h3Price += h3line;
				h3line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] h3lines = h3Price.split("/n"); // Split text into an array of lines
		String[] h3Prices = h3lines[0].split(","); // Split first line into an array of words using comma as delimiter
		
		
		
		
		//Table top
		
		JLabel bPlace= new JLabel("Place");
		bPlace.setBounds(250, 220,90,30);
		Top_Make_UP(bPlace);
		add(bPlace);
		
		
		JLabel bFeature= new JLabel("Feature");
		bFeature.setBounds(340, 220,90,30);
		Top_Make_UP(bFeature);
		add(bFeature);
		
		
		JLabel bbPrice= new JLabel("Vendor Price");
		bbPrice.setBounds(430, 220,90,30);
		Top_Make_UP(bbPrice);
		add(bbPrice);
		
		
		JLabel CPrice= new JLabel("Current Price");
		CPrice.setBounds(520, 220,90,30);
		Top_Make_UP(CPrice);
		add(CPrice);
		
		
		JLabel bUpdate_Price= new JLabel("Update Price");
		bUpdate_Price.setBounds(610, 220,90,30);
		Top_Make_UP(bUpdate_Price);
		add(bUpdate_Price);
		
		
		//Table Row 1 Contents 
		
		JLabel bR1C1= new JLabel("Any");
		bR1C1.setBounds(250, 250,90,30);
		Bottom_Make_UP(bR1C1);
		add(bR1C1);
	
		
		JLabel bR1C2= new JLabel("AC");
		bR1C2.setBounds(340, 250,90,30);
		Bottom_Make_UP(bR1C2);
		add(bR1C2);
		
		
		JLabel bR1C3= new JLabel(bPrices[0]);
		bR1C3.setBounds(430, 250,90,30);
		Bottom_Make_UP(bR1C3);
		add(bR1C3);
		
		
		JLabel bR1C5= new JLabel(h3Prices[0]);
		bR1C5.setBounds(520, 250,90,30);
		Top_Make_UP(bR1C5);
		add(bR1C5);
		
		
		bR1C4 = new JTextField();
		bR1C4.setBounds(610, 250,90,30);
		bR1C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
															//Table Row 2 Contents 
		
		JLabel  bR2C1= new JLabel("Any");
		bR2C1.setBounds(250, 280,90,30);
		Bottom_Make_UP(bR2C1);
		add(bR2C1);
	
		
		JLabel  bR2C2= new JLabel("Non AC");
		bR2C2.setBounds(340, 280,90,30);
		Bottom_Make_UP(bR2C2);
		add(bR2C2);
		
		JLabel  bR2C3= new JLabel(bPrices[1]);
		bR2C3.setBounds(430, 280,90,30);
		Bottom_Make_UP(bR2C3);
		add(bR2C3);
		
		
		JLabel bR2C5= new JLabel(h3Prices[1]);
		bR2C5.setBounds(520, 280,90,30);
		Top_Make_UP(bR2C5);
		add(bR2C5);


		bR2C4 = new JTextField();
		bR2C4.setBounds(610, 280,90,30);
		bR2C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																	//Table Row 3 Contents 
		/*
		JLabel bR3C1= new JLabel("TEKNAF");
		bR3C1.setBounds(250, 310,90,30);
		Bottom_Make_UP(bR3C1);
		add(bR3C1);
	
		
		JLabel bR3C2= new JLabel("AC");
		bR3C2.setBounds(340, 310,90,30);
		Bottom_Make_UP(bR3C2);
		add(bR3C2);
		
		
		JLabel bR3C3= new JLabel(bPrices[2]);
		bR3C3.setBounds(430, 310,90,30);
		Bottom_Make_UP(bR3C3);
		add(bR3C3);
		
		
		JLabel bR3C5= new JLabel(h3Prices[2]);
		bR3C5.setBounds(520, 310,90,30);
		Top_Make_UP(bR3C5);
		add(bR3C5);
		
		
		bR3C4 = new JTextField();
		bR3C4.setBounds(610, 310,90,30);
		bR3C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																					//Table Row 4 Contents 
		
		JLabel bR4C1= new JLabel("BANDORBAN");
		bR4C1.setBounds(250, 340,90,30);
		Bottom_Make_UP(bR4C1);
		add(bR4C1);
	
		
		JLabel bR4C2= new JLabel("Non AC");
		bR4C2.setBounds(340, 340,90,30);
		Bottom_Make_UP(bR4C2);
		add(bR4C2);

		
		JLabel bR4C3= new JLabel(bPrices[3]);
		bR4C3.setBounds(430, 340,90,30);
		Bottom_Make_UP(bR4C3);
		add(bR4C3);
		
		
		JLabel bR4C5= new JLabel(h3Prices[3]);
		bR4C5.setBounds(520, 340,90,30);
		Top_Make_UP(bR4C5);
		add(bR4C5);
		
		
		bR4C4 = new JTextField();
		bR4C4.setBounds(610, 340,90,30);
		bR4C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		
		*/
		//Table 3
		/*
		
		//table 3
		label2 = new JLabel("Transportation Vendor(Train)");
        label2.setBounds(400, 290, 400, 15);
		
		
		String tPrice = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/V_Pricing_Train_Service.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				tPrice += line;
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] tlines = tPrice.split("/n"); // Split text into an array of lines
		String[] tPrices = tlines[0].split(","); // Split first line into an array of words using comma as delimiter
		
		
		//Table top
		
		JLabel tPlace= new JLabel("Place");
		tPlace.setBounds(250, 310,113,20);
		Top_Make_UP(tPlace);
		add(tPlace);
		
		
		JLabel tFeature= new JLabel("Feature");
		tFeature.setBounds(363, 310,113,20);
		Top_Make_UP(tFeature);
		add(tFeature);
		
		
		JLabel ttPrice= new JLabel("Price");
		ttPrice.setBounds(476, 310,112,20);
		Top_Make_UP(ttPrice);
		add(ttPrice);
		
		
		JLabel tUpdate_Price= new JLabel("Update Price");
		tUpdate_Price.setBounds(588, 310,112,20);
		Top_Make_UP(tUpdate_Price);
		add(tUpdate_Price);
		
		
		//Table Row 1 Contents 
		
		JLabel tR1C1= new JLabel("Any");
		tR1C1.setBounds(250, 330,113,20);
		Bottom_Make_UP(tR1C1);
		add(tR1C1);
	
		
		JLabel tR1C2= new JLabel("Business");
		tR1C2.setBounds(363, 330,113,20);
		Bottom_Make_UP(tR1C2);
		add(tR1C2);
		
		
		JLabel tR1C3= new JLabel(tPrices[0]);
		tR1C3.setBounds(476, 330,112,20);
		Bottom_Make_UP(tR1C3);
		add(tR1C3);
		
		
		tR1C4 = new JTextField();
		tR1C4.setBounds(588, 330,112,20);
		tR1C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
															//Table Row 2 Contents 
		
		JLabel  tR2C1= new JLabel("Any");
		tR2C1.setBounds(250, 350,113,20);
		Bottom_Make_UP(tR2C1);
		add(tR2C1);
	
		
		JLabel  tR2C2= new JLabel("Economy");
		tR2C2.setBounds(363, 350,113,20);
		Bottom_Make_UP(tR2C2);
		add(tR2C2);
		
		
		JLabel  tR2C3= new JLabel(tPrices[1]);
		tR2C3.setBounds(476, 350,112,20);
		Bottom_Make_UP(tR2C3);
		add(tR2C3);


		tR2C4 = new JTextField();
		tR2C4.setBounds(588, 350,112,20);
		tR2C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																	//Table Row 3 Contents 
		
		JLabel tR3C1= new JLabel("TEKNAF");
		tR3C1.setBounds(250, 370,113,20);
		Bottom_Make_UP(tR3C1);
		add(tR3C1);
	
		
		JLabel tR3C2= new JLabel("Business");
		tR3C2.setBounds(363, 370,113,20);
		Bottom_Make_UP(tR3C2);
		add(tR3C2);
		
		
		JLabel tR3C3= new JLabel(tPrices[2]);
		tR3C3.setBounds(476, 370,112,20);
		Bottom_Make_UP(tR3C3);
		add(tR3C3);
		
		
		tR3C4 = new JTextField();
		tR3C4.setBounds(588, 370,112,20);
		tR3C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
																			//Table Row 4 Contents 
		
		JLabel tR4C1= new JLabel("BANDORBAN");
		tR4C1.setBounds(250, 390,113,20);
		Bottom_Make_UP(tR4C1);
		add(tR4C1);
	
		
		JLabel tR4C2= new JLabel("Economy");
		tR4C2.setBounds(363, 390,113,20);
		Bottom_Make_UP(tR4C2);
		add(tR4C2);

		
		JLabel tR4C3= new JLabel(tPrices[3]);
		tR4C3.setBounds(476, 390,112,20);
		Bottom_Make_UP(tR4C3);
		add(tR4C3);
		
		
		tR4C4 = new JTextField();
		tR4C4.setBounds(588, 390,112,20);
		tR4C4.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));*/
		
		
		
		button.setBounds(20,25,160,40);
		button1.setBounds(20,75,160,40);
		button2.setBounds(20,125,160,40);
		button3.setBounds(20,175,160,40);
		button4.setBounds(20,225,160,40);
		button5.setBounds(20,400,160,40);
		button6.setBounds(250, 385,200,40);
		button7.setBounds(500, 385,200,40);
		//button8.setBounds(660,415,100,30);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		//button8.addActionListener(this);
		
		
		
		//Add Text Field
		
		add(R1C4);
		add(R2C4);
		//add(R3C4);
		//add(R4C4);
		add(bR1C4);
		add(bR2C4);
		//add(bR3C4);
		//add(bR4C4);
		/*add(tR4C4);
		add(tR1C4);
		add(tR2C4);
		add(tR3C4);*/
		
		//Add Button
		
		add(button);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		//add(button8);
		add(label);
		add(label1);
		//add(label2);
		add(BackgroundImage);
		
		
		
		
		setLayout(null);
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
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
			
		try
			{
				String aR1C4=R1C4.getText(), aR2C4=R2C4.getText();
				if(aR1C4.isEmpty() || aR2C4.isEmpty())
				{	
					JOptionPane.showMessageDialog(this,"Please fill up all the fields");
				}
				else
				{
					String Str = R1C4.getText() + "," + R2C4.getText() + "\n";
						
						FW= new FileWriter("All Text Files/AdminAir.txt");
						
						FW.write(Str);

						FW.close();
						
						JOptionPane.showMessageDialog(null,"Price Has been Updated");
						this.setVisible(false);
						new TransportationPricing();
				}
					
					
			}
			catch(Exception E)
					{
						
					}
		}
		else if(e.getSource()==button7)
		{
			
		try
			{
				String cR1C4=bR1C4.getText(), cR2C4=bR2C4.getText();
				if(cR1C4.isEmpty() || cR2C4.isEmpty())
				{	
					JOptionPane.showMessageDialog(this,"Please fill up all the fields");
				}
				else
				{
					String Str = bR1C4.getText() + "," + bR2C4.getText()+ "\n";
						
						FW= new FileWriter("All Text Files/AdminBus.txt");
						
						FW.write(Str);

						FW.close();
						
						JOptionPane.showMessageDialog(null,"Price Has been Updated");
						this.setVisible(false);
						new TransportationPricing();
				}
					
					
			}
			catch(Exception E)
					{
						
					}
		}
		/*else if(e.getSource()==button8)
		{
			
		try
			{
				String dR1C4=tR1C4.getText(), dR2C4=tR2C4.getText(), dR3C4=tR3C4.getText(), dR4C4=tR4C4.getText();
				if(dR1C4.isEmpty() || dR2C4.isEmpty()|| dR3C4.isEmpty()|| dR4C4.isEmpty())
				{	
					JOptionPane.showMessageDialog(this,"Please fill up all the fields");
				}
				else
				{
					String Str = tR1C4.getText() + "," + tR2C4.getText() + "," + tR3C4.getText() + "," + tR4C4.getText() + "\n";
						
						FW= new FileWriter("All Text Files/V_Pricing_Train_Service.txt");
						
						FW.write(Str);

						FW.close();
						
						JOptionPane.showMessageDialog(null,"Price Has been Updated");
						this.setVisible(false);
						new TransportationPricing();
				}
					
					
			}
			catch(Exception E)
					{
						
					}
		}*/
	}
	
	public static void main(String[] args)
	{
		new TransportationPricing();
	}
}