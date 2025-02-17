import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;


public class CustomerOfferedPrice extends JFrame implements ActionListener
{
	private JButton button, button1, button2, button3, button4, button5;
	private JLabel label,label1,label2;
	private JTable table;
	private JScrollPane scroll, scroll1, scroll2;
	private DefaultTableModel model;
	private ImageIcon img;
	private JLabel BackgroundImage;
	private String[] column = {"Person", "Check In", "Check Out", "Vendor Price", "Customer Price"};
	private String[] column1 = {"Person", "Check In", "Check Out", "Vendor Price", "Customer Price"};
	private String[] column2 = {"Person", "Check In", "Check Out", "Vendor Price", "Customer Price"};
	
	public CustomerOfferedPrice()
	{
		super("Hotel Pricing");
		
		img = new ImageIcon(getClass().getResource("Pic/Background.png"));
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
		
		button3=new JButton("Vendor Pricing");
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
		
		
		button.setBounds(20,25,160,40);
		button1.setBounds(20,75,160,40);
		button2.setBounds(20,125,160,40);
		button3.setBounds(20,175,160,40);
		button4.setBounds(20,225,160,40);
		button5.setBounds(20,400,160,40);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		
		//table 1
		label = new JLabel("5 Star");
        label.setBounds(480, 5, 200, 30);
		
		// JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setBackground(Color.DARK_GRAY);
        table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(3).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setPreferredWidth(160);

        scroll1 = new JScrollPane(table);
        scroll1.setBounds(240, 35, 500, 119);
        scroll1.setBackground(Color.WHITE);
		
		//table 2
		label1 = new JLabel("3 Star");
        label1.setBounds(480, 150, 200, 30);
		
		// JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column1);

        table.setModel(model);
        table.setBackground(Color.GREEN);
        table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(3).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setPreferredWidth(160);

        scroll2 = new JScrollPane(table);
        scroll2.setBounds(240, 180, 500, 119);
        scroll2.setBackground(Color.WHITE);
		
		//table 3
		label2 = new JLabel("2 Star");
        label2.setBounds(480, 294, 200, 30);
		
		// JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column2);

        table.setModel(model);
        table.setBackground(Color.WHITE);
        table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(3).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setPreferredWidth(160);

        scroll = new JScrollPane(table);
        scroll.setBounds(240, 324, 500, 118);
        scroll.setBackground(Color.WHITE);
		
		
		add(button);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(scroll);
		add(scroll1);
		add(scroll2);
		add(label);
		add(label1);
		add(label2);
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
			new VendorPricing();
		}
		else if(e.getSource()==button4)
		{
			setVisible(false);
			new Admin_Balance();
		}
		else if(e.getSource()==button5)
		{
			setVisible(false);
			new Logout();
		}
	}
	
	public static void main(String[] args)
	{
		new CustomerOfferedPrice();
	}
}