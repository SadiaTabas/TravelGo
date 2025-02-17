import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;


public class HotelPricing extends JFrame implements ActionListener
{
	private JButton button, button1, button2, button3, button4, button5, button6, button7, button8;
	private JLabel label,label1,label2;
	private JTable table;
	private JScrollPane scroll, scroll1, scroll2;
	private DefaultTableModel model;
	private ImageIcon img;
	private JLabel BackgroundImage;
	public FileWriter FW;
	public FileReader reader;
    public BufferedReader bfreader;
    public Font f1;
	public JTextField  H_5_R1C5,  H_5_R2C5,  H_5_R3C5,  H_5_R4C5, H_3_R1C5,  H_3_R2C5,  H_3_R3C5,  H_3_R4C5,  H_2_R4C5, H_2_R1C5,  H_2_R2C5,  H_2_R3C5;
	
	
	public HotelPricing()
	{
		super("Hotel Pricing");
		
		f1 = new Font("Segoe UI Black", Font.PLAIN, 10);
		
		img = new ImageIcon(getClass().getResource("Graphics/1x/Background.png"));
		BackgroundImage = new JLabel (img);
		BackgroundImage.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		
		
		
									//5 STAR HOTEL PRICE
		
		
		JLabel Sub_Title_label_1= new JLabel("5 STAR HOTEL PRICE");
		Sub_Title_label_1.setBounds(400, 10, 400, 15);
		Sub_Title_label_1.setFont(new Font("SansSerif ", Font.BOLD, 15));
		Sub_Title_label_1.setForeground(Color.decode("#477977"));
		
		
		JLabel Sub_Title_label_2= new JLabel("3 STAR HOTEL PRICE");
		Sub_Title_label_2.setBounds(400, 150, 400, 15);
		Sub_Title_label_2.setFont(new Font("SansSerif ", Font.BOLD, 15));
		Sub_Title_label_2.setForeground(Color.decode("#477977"));
		
		
		JLabel Sub_Title_label_3= new JLabel("2 STAR HOTEL PRICE");
		Sub_Title_label_3.setBounds(400, 290, 400, 15);
		Sub_Title_label_3.setFont(new Font("SansSerif ", Font.BOLD, 15));
		Sub_Title_label_3.setForeground(Color.decode("#477977"));
		
		
		JLabel BackgroundImage_label;
		ImageIcon img = new ImageIcon("Graphics/1x/H_Background.png");
		BackgroundImage_label = new JLabel ("",img,JLabel.CENTER);
		BackgroundImage_label.setBounds(0,0,800,500);
		
																//Vendor Price form File Reading 
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
		
		//Admin 5 Star Pricing
		
		
		String fPrice = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/Admin5Star.txt");
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
		
		JLabel H_5_Bed_label= new JLabel("Bed");
		H_5_Bed_label.setBounds(250, 30,50,20);
		Top_Make_UP(H_5_Bed_label);
		
		
		JLabel H_5_Day_label= new JLabel("Day");
		H_5_Day_label.setBounds(300, 30,50,20);
		Top_Make_UP(H_5_Day_label);
		
		
		JLabel H_5_Breakfast_label= new JLabel("B.fast");
		H_5_Breakfast_label.setBounds(350, 30,50,20);
		Top_Make_UP(H_5_Breakfast_label);
		
		
		JLabel H_5_Vendor_Price_label= new JLabel("Vendor Price");
		H_5_Vendor_Price_label.setBounds(400, 30,100,20);
		Top_Make_UP(H_5_Vendor_Price_label);
		
		
		JLabel H_5_Current_Price_label= new JLabel("Current Price");
		H_5_Current_Price_label.setBounds(500, 30,100,20);
		Top_Make_UP(H_5_Current_Price_label);
		
		
		JLabel H_5_Update_Price_label= new JLabel("Update Price");
		H_5_Update_Price_label.setBounds(600, 30,100,20);
		Top_Make_UP(H_5_Update_Price_label);
		
		
		//Table Row 1 Contents 
		
		JLabel H_5_R1C1= new JLabel("1");
		H_5_R1C1.setBounds(250, 50,50,20);
		Bottom_Make_UP(H_5_R1C1);
	
		
		JLabel H_5_R1C2= new JLabel("1");
		H_5_R1C2.setBounds(300, 50,50,20);
		Bottom_Make_UP(H_5_R1C2);
		
		
		JLabel H_5_R1C3= new JLabel("Y");
		H_5_R1C3.setBounds(350, 50,50,20);
		Bottom_Make_UP(H_5_R1C3);
		
		
		JLabel H_5_R1C4= new JLabel(Prices[0]);
		H_5_R1C4.setBounds(400, 50,100,20);
		Bottom_Make_UP(H_5_R1C4);
		
		JLabel H_5_R1C6= new JLabel(fPrices[0]);
		H_5_R1C6.setBounds(500, 50,100,20);
		Bottom_Make_UP(H_5_R1C6);
		
		
		H_5_R1C5 = new JTextField();
		H_5_R1C5.setBounds(600,50,100,20);
		H_5_R1C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
															//Table Row 2 Contents 
		
		JLabel  H_5_R2C1= new JLabel("2");
		 H_5_R2C1.setBounds(250, 70,50,20);
		Bottom_Make_UP( H_5_R2C1);
	
		
		JLabel  H_5_R2C2= new JLabel("1");
		 H_5_R2C2.setBounds(300, 70,50,20);
		Bottom_Make_UP( H_5_R2C2);
		
		
		JLabel  H_5_R2C3= new JLabel("Y");
		 H_5_R2C3.setBounds(350, 70,50,20);
		Bottom_Make_UP( H_5_R2C3);
		
		
		JLabel  H_5_R2C4= new JLabel(Prices[1]);
		H_5_R2C4.setBounds(400, 70,100,20);
		Bottom_Make_UP( H_5_R2C4);
		
		JLabel H_5_R2C6= new JLabel(fPrices[1]);
		H_5_R2C6.setBounds(500, 70,100,20);
		Bottom_Make_UP(H_5_R2C6);
		
		
		H_5_R2C5 = new JTextField();
		H_5_R2C5.setBounds(600,70,100,20);
		H_5_R2C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																	//Table Row 3 Contents 
		
		JLabel H_5_R3C1= new JLabel("1");
		H_5_R3C1.setBounds(250, 90,50,20);
		Bottom_Make_UP(H_5_R3C1);
	
		
		JLabel H_5_R3C2= new JLabel("3");
		H_5_R3C2.setBounds(300, 90,50,20);
		Bottom_Make_UP(H_5_R3C2);
		
		
		JLabel H_5_R3C3= new JLabel("Y");
		H_5_R3C3.setBounds(350, 90,50,20);
		Bottom_Make_UP(H_5_R3C3);
		
		
		JLabel H_5_R3C4= new JLabel(Prices[2]);
		H_5_R3C4.setBounds(400, 90,100,20);
		Bottom_Make_UP(H_5_R3C4);
		
		JLabel H_5_R3C6= new JLabel(fPrices[2]);
		H_5_R3C6.setBounds(500, 90,100,20);
		Bottom_Make_UP(H_5_R3C6);
		
		
		H_5_R3C5 = new JTextField();
		H_5_R3C5.setBounds(600,90,100,20);
		H_5_R3C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
																			//Table Row 4 Contents 
		
		JLabel H_5_R4C1= new JLabel("2");
		H_5_R4C1.setBounds(250, 110,50,20);
		Bottom_Make_UP(H_5_R4C1);
	
		
		JLabel H_5_R4C2= new JLabel("3");
		H_5_R4C2.setBounds(300, 110,50,20);
		Bottom_Make_UP(H_5_R4C2);
		
		
		JLabel H_5_R4C3= new JLabel("Y");
		H_5_R4C3.setBounds(350, 110,50,20);
		Bottom_Make_UP(H_5_R4C3);
		
		
		JLabel H_5_R4C4= new JLabel(Prices[3]);
		H_5_R4C4.setBounds(400, 110,100,20);
		Bottom_Make_UP(H_5_R4C4);
		
		JLabel H_5_R4C6= new JLabel(fPrices[3]);
		H_5_R4C6.setBounds(500, 110,100,20);
		Bottom_Make_UP(H_5_R4C6);
		
		
		H_5_R4C5 = new JTextField();
		H_5_R4C5.setBounds(600,110,100,20);
		H_5_R4C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		//Table 2
		
		//Vendor 3 Star Pricing
		String thPrice = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/V_Pricing_H_3_star.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				thPrice += line;
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] thlines = thPrice.split("/n"); // Split text into an array of lines
		String[] thPrices = thlines[0].split(","); // Split first line into an array of words using comma as delimiter
		
		//Admin 3 Star Pricing
		
		
		String h3Price = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/Admin3Star.txt");
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
		
		
		
		//Table 2 top
		
		JLabel H_3_Bed_label= new JLabel("Bed");
		H_3_Bed_label.setBounds(250, 170,50,20);
		Top_Make_UP(H_3_Bed_label);
		
		
		JLabel H_3_Day_label= new JLabel("Day");
		H_3_Day_label.setBounds(300, 170,50,20);
		Top_Make_UP(H_3_Day_label);
		
		
		JLabel H_3_Breakfast_label= new JLabel("B.fast");
		H_3_Breakfast_label.setBounds(350, 170,50,20);
		Top_Make_UP(H_3_Breakfast_label);
		
		
		JLabel H_3_Vendor_Price_label= new JLabel("Vendor Price");
		H_3_Vendor_Price_label.setBounds(400, 170,100,20);
		Top_Make_UP(H_3_Vendor_Price_label);
		
		
		JLabel H_3_Current_Price_label= new JLabel("Current Price");
		H_3_Current_Price_label.setBounds(500, 170,100,20);
		Top_Make_UP(H_3_Current_Price_label);
		
		
		JLabel H_3_Update_Price_label= new JLabel("Update Price");
		H_3_Update_Price_label.setBounds(600, 170,100,20);
		Top_Make_UP(H_3_Update_Price_label);
		
		
		//Table Row 1 Contents 
		
		JLabel H_3_R1C1= new JLabel("1");
		H_3_R1C1.setBounds(250, 190,50,20);
		Bottom_Make_UP(H_3_R1C1);
	
		
		JLabel H_3_R1C2= new JLabel("1");
		H_3_R1C2.setBounds(300, 190,50,20);
		Bottom_Make_UP(H_3_R1C2);
		
		
		JLabel H_3_R1C3= new JLabel("Y");
		H_3_R1C3.setBounds(350, 190,50,20);
		Bottom_Make_UP(H_3_R1C3);
		
		
		JLabel H_3_R1C4= new JLabel(thPrices[0]);
		H_3_R1C4.setBounds(400, 190,100,20);
		Bottom_Make_UP(H_3_R1C4);
		
		JLabel H_3_R1C6= new JLabel(h3Prices[0]);
		H_3_R1C6.setBounds(500, 190,100,20);
		Bottom_Make_UP(H_3_R1C6);
		
		
		H_3_R1C5 = new JTextField();
		H_3_R1C5.setBounds(600,190,100,20);
		H_3_R1C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
															//Table Row 2 Contents 
		
		JLabel  H_3_R2C1= new JLabel("2");
		 H_3_R2C1.setBounds(250, 210,50,20);
		Bottom_Make_UP( H_3_R2C1);
	
		
		JLabel  H_3_R2C2= new JLabel("1");
		 H_3_R2C2.setBounds(300, 210,50,20);
		Bottom_Make_UP( H_3_R2C2);
		
		
		JLabel  H_3_R2C3= new JLabel("Y");
		 H_3_R2C3.setBounds(350, 210,50,20);
		Bottom_Make_UP( H_3_R2C3);
		
		
		JLabel  H_3_R2C4= new JLabel(thPrices[1]);
		H_3_R2C4.setBounds(400, 210,100,20);
		Bottom_Make_UP( H_3_R2C4);
		
		JLabel H_3_R2C6= new JLabel(h3Prices[1]);
		H_3_R2C6.setBounds(500, 210,100,20);
		Bottom_Make_UP(H_3_R2C6);
		
		
		H_3_R2C5 = new JTextField();
		H_3_R2C5.setBounds(600,210,100,20);
		H_3_R2C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																	//Table Row 3 Contents 
		
		JLabel H_3_R3C1= new JLabel("1");
		H_3_R3C1.setBounds(250,230,50,20);
		Bottom_Make_UP(H_3_R3C1);
	
		
		JLabel H_3_R3C2= new JLabel("3");
		H_3_R3C2.setBounds(300, 230,50,20);
		Bottom_Make_UP(H_3_R3C2);
		
		
		JLabel H_3_R3C3= new JLabel("Y");
		H_3_R3C3.setBounds(350, 230,50,20);
		Bottom_Make_UP(H_3_R3C3);
		
		
		JLabel H_3_R3C4= new JLabel(thPrices[2]);
		H_3_R3C4.setBounds(400, 230,100,20);
		Bottom_Make_UP(H_3_R3C4);
		
		JLabel H_3_R3C6= new JLabel(h3Prices[2]);
		H_3_R3C6.setBounds(500, 230,100,20);
		Bottom_Make_UP(H_3_R3C6);
		
		
		H_3_R3C5 = new JTextField();
		H_3_R3C5.setBounds(600,230,100,20);
		H_3_R3C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
																			//Table Row 4 Contents 
		
		JLabel H_3_R4C1= new JLabel("2");
		H_3_R4C1.setBounds(250, 250,50,20);
		Bottom_Make_UP(H_3_R4C1);
	
		
		JLabel H_3_R4C2= new JLabel("3");
		H_3_R4C2.setBounds(300, 250,50,20);
		Bottom_Make_UP(H_3_R4C2);
		
		
		JLabel H_3_R4C3= new JLabel("Y");
		H_3_R4C3.setBounds(350, 250,50,20);
		Bottom_Make_UP(H_3_R4C3);
		
		
		JLabel H_3_R4C4= new JLabel(thPrices[3]);
		H_3_R4C4.setBounds(400, 250,100,20);
		Bottom_Make_UP(H_3_R4C4);
		
		JLabel H_3_R4C6= new JLabel(h3Prices[3]);
		H_3_R4C6.setBounds(500, 250,100,20);
		Bottom_Make_UP(H_3_R4C6);
		
		
		H_3_R4C5 = new JTextField();
		H_3_R4C5.setBounds(600,250,100,20);
		H_3_R4C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		//Table 3
		
		//Vendor 2 Star Pricing
		
		String tPrice = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/V_Pricing_H_2_star.txt");
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
		
		//Admin 2 Star Pricing
		
		
		String h2Price = "";
		try {
			FileReader fileReader = new FileReader("All Text Files/Admin2Star.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String h2line = bufferedReader.readLine();
			while (h2line != null) {
				h2Price += h2line;
				h2line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] h2lines = h2Price.split("/n"); // Split text into an array of lines
		String[] h2Prices = h2lines[0].split(","); // Split first line into an array of words using comma as delimiter
		
		
		
		//Table 3 top
		
		JLabel H_2_Bed_label= new JLabel("Bed");
		H_2_Bed_label.setBounds(250, 310,50,20);
		Top_Make_UP(H_2_Bed_label);
		
		
		JLabel H_2_Day_label= new JLabel("Day");
		H_2_Day_label.setBounds(300, 310,50,20);
		Top_Make_UP(H_2_Day_label);
		
		
		JLabel H_2_Breakfast_label= new JLabel("B.fast");
		H_2_Breakfast_label.setBounds(350, 310,50,20);
		Top_Make_UP(H_2_Breakfast_label);
		
		
		JLabel H_2_Vendor_Price_label= new JLabel("Vendor Price");
		H_2_Vendor_Price_label.setBounds(400, 310,100,20);
		Top_Make_UP(H_2_Vendor_Price_label);
		
		
		JLabel H_2_Current_Price_label= new JLabel("Current Price");
		H_2_Current_Price_label.setBounds(500, 310,100,20);
		Top_Make_UP(H_2_Current_Price_label);
		
		
		JLabel H_2_Update_Price_label= new JLabel("Update Price");
		H_2_Update_Price_label.setBounds(600, 310,100,20);
		Top_Make_UP(H_2_Update_Price_label);
		
		
		//Table Row 1 Contents 
		
		JLabel H_2_R1C1= new JLabel("1");
		H_2_R1C1.setBounds(250, 330,50,20);
		Bottom_Make_UP(H_2_R1C1);
	
		
		JLabel H_2_R1C2= new JLabel("1");
		H_2_R1C2.setBounds(300, 330,50,20);
		Bottom_Make_UP(H_2_R1C2);
		
		
		JLabel H_2_R1C3= new JLabel("Y");
		H_2_R1C3.setBounds(350, 330,50,20);
		Bottom_Make_UP(H_2_R1C3);
		
		
		JLabel H_2_R1C4= new JLabel(tPrices[0]);
		H_2_R1C4.setBounds(400, 330,100,20);
		Bottom_Make_UP(H_2_R1C4);
		
		JLabel H_2_R1C6= new JLabel(h2Prices[0]);
		H_2_R1C6.setBounds(500, 330,100,20);
		Bottom_Make_UP(H_2_R1C6);
		
		
		H_2_R1C5 = new JTextField();
		H_2_R1C5.setBounds(600,330,100,20);
		H_2_R1C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
															//Table Row 2 Contents 
		
		JLabel  H_2_R2C1= new JLabel("2");
		 H_2_R2C1.setBounds(250, 350,50,20);
		Bottom_Make_UP( H_2_R2C1);
	
		
		JLabel  H_2_R2C2= new JLabel("1");
		 H_2_R2C2.setBounds(300, 350,50,20);
		Bottom_Make_UP( H_2_R2C2);
		
		
		JLabel  H_2_R2C3= new JLabel("Y");
		 H_2_R2C3.setBounds(350, 350,50,20);
		Bottom_Make_UP( H_2_R2C3);
		
		
		JLabel  H_2_R2C4= new JLabel(tPrices[1]);
		H_2_R2C4.setBounds(400, 350,100,20);
		Bottom_Make_UP( H_2_R2C4);
		
		JLabel H_2_R2C6= new JLabel(h2Prices[1]);
		H_2_R2C6.setBounds(500, 350,100,20);
		Bottom_Make_UP(H_2_R2C6);
		
		
		H_2_R2C5 = new JTextField();
		H_2_R2C5.setBounds(600,350,100,20);
		H_2_R2C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
																	//Table Row 3 Contents 
		
		JLabel H_2_R3C1= new JLabel("1");
		H_2_R3C1.setBounds(250, 370,50,20);
		Bottom_Make_UP(H_2_R3C1);
	
		
		JLabel H_2_R3C2= new JLabel("3");
		H_2_R3C2.setBounds(300, 370,50,20);
		Bottom_Make_UP(H_2_R3C2);
		
		
		JLabel H_2_R3C3= new JLabel("Y");
		H_2_R3C3.setBounds(350, 370,50,20);
		Bottom_Make_UP(H_2_R3C3);
		
		
		JLabel H_2_R3C4= new JLabel(tPrices[2]);
		H_2_R3C4.setBounds(400, 370,100,20);
		Bottom_Make_UP(H_2_R3C4);
		
		JLabel H_2_R3C6= new JLabel(h2Prices[2]);
		H_2_R3C6.setBounds(500, 370,100,20);
		Bottom_Make_UP(H_2_R3C6);
		
		
		H_2_R3C5 = new JTextField();
		H_2_R3C5.setBounds(600,370,100,20);
		H_2_R3C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
																			//Table Row 4 Contents 
		
		JLabel H_2_R4C1= new JLabel("2");
		H_2_R4C1.setBounds(250, 390,50,20);
		Bottom_Make_UP(H_2_R4C1);
	
		
		JLabel H_2_R4C2= new JLabel("3");
		H_2_R4C2.setBounds(300, 390,50,20);
		Bottom_Make_UP(H_2_R4C2);
		
		
		JLabel H_2_R4C3= new JLabel("Y");
		H_2_R4C3.setBounds(350, 390,50,20);
		Bottom_Make_UP(H_2_R4C3);
		
		
		JLabel H_2_R4C4= new JLabel(tPrices[3]);
		H_2_R4C4.setBounds(400, 390,100,20);
		Bottom_Make_UP(H_2_R4C4);
		
		JLabel H_2_R4C6= new JLabel(h2Prices[3]);
		H_2_R4C6.setBounds(500, 390,100,20);
		Bottom_Make_UP(H_2_R4C6);
		
		
		H_2_R4C5 = new JTextField();
		H_2_R4C5.setBounds(600,390,100,20);
		H_2_R4C5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		
		
		
		
		
		
											//All Buttons 
		
		
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
		Color c3 = new Color(102,102,102);
		button3.setBackground(c3);
        button3.setForeground(Color.WHITE);
		
		button4=new JButton("Hotel Pricing");
		Color c4 = new Color(204,204,204);
		Color ct = new Color(0,0,0);
		button4.setBackground(c4);
        button4.setForeground(ct);
		
		button5=new JButton("Logout");
		Color c5 = new Color(102,102,102);
		button5.setBackground(c5);
        button5.setForeground(Color.WHITE);
		
		button6=new JButton("Update");
		Color c6 = new Color(102,102,102);
		button6.setBackground(c6);
        button6.setForeground(Color.WHITE);
		button6.setFont(f1);
		
		button7=new JButton("Update");
		Color c7 = new Color(102,102,102);
		button7.setBackground(c7);
        button7.setForeground(Color.WHITE);
		button7.setFont(f1);
		
		button8=new JButton("Update");
		Color c8 = new Color(102,102,102);
		button8.setBackground(c7);
        button8.setForeground(Color.WHITE);
		button8.setFont(f1);
		
		
		button.setBounds(10,25,180,40);
		button1.setBounds(10,75,180,40);
		button2.setBounds(10,125,180,40);
		button3.setBounds(10,175,180,40);
		button4.setBounds(10,225,180,40);
		button5.setBounds(10,400,180,40);
		button6.setBounds(660, 135,100,30);
		button7.setBounds(660, 275,100,30);
		button8.setBounds(660,415,100,30);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		
		
		add(Sub_Title_label_1);
		add(Sub_Title_label_2);
		add(Sub_Title_label_3);
		
		//table 1
		
		add(H_5_Day_label);
		add(H_5_Bed_label);
		add(H_5_Breakfast_label);
		add(H_5_Vendor_Price_label);
		add(H_5_Current_Price_label);
		add(H_5_Update_Price_label);
		
		
		add(H_5_R1C1);
		add(H_5_R1C2);
		add(H_5_R1C3);
		add(H_5_R1C4);
		add(H_5_R1C5);
		add(H_5_R1C6);
		add(H_5_R2C1);
		add(H_5_R2C2);
		add(H_5_R2C3);
		add(H_5_R2C4);
		add(H_5_R2C5);
		add(H_5_R2C6);
		add(H_5_R3C1);
		add(H_5_R3C2);
		add(H_5_R3C3);
		add(H_5_R3C4);
		add(H_5_R3C5);
		add(H_5_R3C6);
		add(H_5_R4C1);
		add(H_5_R4C2);
		add(H_5_R4C3);
		add(H_5_R4C4);
		add(H_5_R4C5);
		add(H_5_R4C6);
		
		//table 2
		
		add(H_3_Day_label);
		add(H_3_Bed_label);
		add(H_3_Breakfast_label);
		add(H_3_Vendor_Price_label);
		add(H_3_Current_Price_label);
		add(H_3_Update_Price_label);
		
		
		add(H_3_R1C1);
		add(H_3_R1C2);
		add(H_3_R1C3);
		add(H_3_R1C4);
		add(H_3_R1C5);
		add(H_3_R1C6);
		add(H_3_R2C1);
		add(H_3_R2C2);
		add(H_3_R2C3);
		add(H_3_R2C4);
		add(H_3_R2C5);
		add(H_3_R2C6);
		add(H_3_R3C1);
		add(H_3_R3C2);
		add(H_3_R3C3);
		add(H_3_R3C4);
		add(H_3_R3C5);
		add(H_3_R3C6);
		add(H_3_R4C1);
		add(H_3_R4C2);
		add(H_3_R4C3);
		add(H_3_R4C4);
		add(H_3_R4C5);
		add(H_3_R4C6);
		
		
		//table 3
		
		add(H_2_Day_label);
		add(H_2_Bed_label);
		add(H_2_Breakfast_label);
		add(H_2_Vendor_Price_label);
		add(H_2_Current_Price_label);
		add(H_2_Update_Price_label);
		
		add(H_2_R1C1);
		add(H_2_R1C2);
		add(H_2_R1C3);
		add(H_2_R1C4);
		add(H_2_R1C5);
		add(H_2_R1C6);
		add(H_2_R2C1);
		add(H_2_R2C2);
		add(H_2_R2C3);
		add(H_2_R2C4);
		add(H_2_R2C5);
		add(H_2_R2C6);
		add(H_2_R3C1);
		add(H_2_R3C2);
		add(H_2_R3C3);
		add(H_2_R3C4);
		add(H_2_R3C5);
		add(H_2_R3C6);
		add(H_2_R4C1);
		add(H_2_R4C2);
		add(H_2_R4C3);
		add(H_2_R4C4);
		add(H_2_R4C5);
		add(H_2_R4C6);
		
		
		
		
		
		
		
		
		
		add(button);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
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
				String R1C5=H_5_R1C5.getText(), R2C5=H_5_R2C5.getText(), R3C5=H_5_R3C5.getText(), R4C5=H_5_R4C5.getText();
				if(R1C5.isEmpty() || R2C5.isEmpty()|| R3C5.isEmpty()|| R4C5.isEmpty())
				{	
					JOptionPane.showMessageDialog(this,"Please fill up all the fields");
				}
				else
				{
					String Str = H_5_R1C5.getText() + "," + H_5_R2C5.getText() + "," + H_5_R3C5.getText() + "," + H_5_R4C5.getText() + "\n";
						
						FW= new FileWriter("All Text Files/Admin5Star.txt");
						
						FW.write(Str);

						FW.close();
						
						JOptionPane.showMessageDialog(null,"Price Has been Updated");
						this.setVisible(false);
						new HotelPricing();
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
				String thR1C5=H_3_R1C5.getText(), thR2C5=H_3_R2C5.getText(), thR3C5=H_3_R3C5.getText(), thR4C5=H_3_R4C5.getText();
				if(thR1C5.isEmpty() || thR2C5.isEmpty()|| thR3C5.isEmpty()|| thR4C5.isEmpty())
				{	
					JOptionPane.showMessageDialog(this,"Please fill up all the fields");
				}
				else
				{
					String Str = H_3_R1C5.getText() + "," + H_3_R2C5.getText() + "," + H_3_R3C5.getText() + "," + H_3_R4C5.getText() + "\n";
						
						FW= new FileWriter("All Text Files/Admin3Star.txt");
						
						FW.write(Str);

						FW.close();
						
						JOptionPane.showMessageDialog(null,"Price Has been Updated");
						this.setVisible(false);
						new HotelPricing();
				}
					
					
			}
			catch(Exception E)
					{
						
					}
		}
		else if(e.getSource()==button8)
		{
			
		try
			{
				String tR1C5=H_2_R1C5.getText(), tR2C5=H_2_R2C5.getText(), tR3C5=H_2_R3C5.getText(), tR4C5=H_2_R4C5.getText();
				if(tR1C5.isEmpty() || tR2C5.isEmpty()|| tR3C5.isEmpty()|| tR4C5.isEmpty())
				{	
					JOptionPane.showMessageDialog(this,"Please fill up all the fields");
				}
				else
				{
					String Str = H_2_R1C5.getText() + "," + H_2_R2C5.getText() + "," + H_2_R3C5.getText() + "," + H_2_R4C5.getText() + "\n";
						
						FW= new FileWriter("All Text Files/Admin2Star.txt");
						
						FW.write(Str);

						FW.close();
						
						JOptionPane.showMessageDialog(null,"Price Has been Updated");
						this.setVisible(false);
						new HotelPricing();
				}
					
					
			}
			catch(Exception E)
					{
						
					}
		}
	}
	
	public static void main(String[] args)
	{
		new HotelPricing();
	}
}