import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;



public class ReservedJourney extends JFrame implements ActionListener
{
	private JButton button, button1, button2, button3, button4, button5;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private ImageIcon img;
	private JLabel BackgroundImage;
	public FileReader reader;
    public BufferedReader bfreader;
	public String[] email;
    public String[] place;
    public String[] date;
    public String[] travellars;
    public String[] htype;
	public String[] day;
	public String[] bed;
	public String[] room;
	public String[] vehicle;
	public String[] cost;
	private String[] column = {"Email", "Destination", "Deperture date", "Travellars", "Hotel type","Days","Bed type","Rooms","Vehicle","Total cost"};
	public String[] rows = new String[10000];
	
	
	public ReservedJourney()
	{
		super("Reserved Journey");
		
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
		Color c2 = new Color(204,204,204);
		Color ct = new Color(0,0,0);
		button2.setBackground(c2);
        button2.setForeground(ct);
		
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
		
		
		button.setBounds(10,25,180,40);
		button1.setBounds(10,75,180,40);
		button2.setBounds(10,125,180,40);
		button3.setBounds(10,175,180,40);
		button4.setBounds(10,225,180,40);
		button5.setBounds(10,400,180,40);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		
		// JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setBackground(Color.DARK_GRAY);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.setForeground(Color.WHITE);

        scroll = new JScrollPane(table);
        scroll.setBounds(240, 25, 500, 415);
        scroll.setBackground(Color.WHITE);
		
		String line;
        int Number_of_Lines = 0;

        try 
		{
            reader = new FileReader("All Text Files/All_History.txt");
            bfreader = new BufferedReader(reader);

            while ((line = bfreader.readLine()) != null) 
			{
                Number_of_Lines++;
            }

            // initialize arrays with appropriate size
            email = new String[Number_of_Lines];
            place = new String[Number_of_Lines];
            date = new String[Number_of_Lines];
            travellars = new String[Number_of_Lines];
            htype = new String[Number_of_Lines];
			day = new String[Number_of_Lines];
			bed = new String[Number_of_Lines];
			room = new String[Number_of_Lines];
			vehicle = new String[Number_of_Lines];
			cost = new String[Number_of_Lines];

            // reset reader to start from the beginning
            reader = new FileReader("All Text Files/All_History.txt");
            bfreader = new BufferedReader(reader);

            int i = 0;
            while ((line = bfreader.readLine()) != null) 
			{
                String[] parts = line.split(",");
                email[i] = parts[0];
                place[i] = parts[1];
				date[i] = parts[2];
				travellars[i] = parts[3];
				htype[i] = parts[4];
				day[i] = parts[5];
				bed[i] = parts[6];
				room[i] = parts[7];
				vehicle[i] = parts[8];
				cost[i] = parts[10];
                i++;
            }
            reader.close();
        } 
		catch (Exception E) 
		{

        }

        for (int i = 0; i < Number_of_Lines; i++)
		{
            rows[0] = email[i]; // Bed
            rows[1] = place[i]; // Quantity
            rows[2] = date[i]; // Day
            rows[3] = travellars[i]; // Breakfast
            rows[4] = htype[i]; // Price
			rows[5] = day[i];
			rows[6] = bed[i];
			rows[7] = room[i];
			rows[8] = vehicle[i];
			rows[9] = cost[i];
            model.addRow(rows);
        }
		
		
		add(button);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(scroll);
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
	}
	
	public static void main(String[] args)
	{
		new ReservedJourney();
	}
}	