import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;
import java.util.Arrays;



public class UserList extends JFrame implements ActionListener
{
	private JButton button, button1, button2, button3, button4, button5, button6, button7;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private String[] column = {"Email", "Password", "Name", "Phone", "NID","Balance"};
	private ImageIcon img;
	private JLabel BackgroundImage;
	public FileReader reader;
    public BufferedReader bfreader;
    public String[] Names;
    public String[] Phones;
    public String[] Emails;
    public String[] Passwords;
    public String[] NIDs;
    public String[] Balances;
	public String[] rows = new String[10000];
	
	public UserList()
	{
		super("User List");
		
		img = new ImageIcon(getClass().getResource("Graphics/1x/Background.png"));
		BackgroundImage = new JLabel (img);
		BackgroundImage.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		
		button=new JButton("Balance");
		Color c = new Color(102,102,102);
		button.setBackground(c);
        button.setForeground(Color.WHITE);
		
		button1=new JButton("User List");
		Color c1 = new Color(204,204,204);
		Color ct = new Color(0,0,0);
		button1.setBackground(c1);
        button1.setForeground(ct);
		
		button2=new JButton("Reserved Journey");
		Color c2 = new Color(102,102,102);
		button2.setBackground(c2);
        button2.setForeground(Color.WHITE);
		
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
		
		button6=new JButton("Add");
		Color c6 = new Color(102,102,102);
		button6.setBackground(c6);
        button6.setForeground(Color.WHITE);
		
		button7=new JButton("Delete");
		Color c7 = new Color(102,102,102);
		button7.setBackground(c7);
        button7.setForeground(Color.WHITE);
		
		
		button.setBounds(10,25,180,40);
		button1.setBounds(10,75,180,40);
		button2.setBounds(10,125,180,40);
		button3.setBounds(10,175,180,40);
		button4.setBounds(10,225,180,40);
		button5.setBounds(10,400,180,40);
		button6.setBounds(270,400,180,40);
		button7.setBounds(530,400,180,40);
		button.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		
		// JTable Layout
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
		Color ctb = new Color(102,102,102);
        table.setBackground(ctb);
        table.setRowHeight(40);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(160);
        table.getColumnModel().getColumn(1).setPreferredWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(3).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setPreferredWidth(160);
        table.getColumnModel().getColumn(5).setPreferredWidth(160);
		table.setForeground(Color.WHITE);

        scroll = new JScrollPane(table);
        scroll.setBounds(240, 25, 500, 360);
        scroll.setBackground(Color.WHITE);

		
		String line;
        int Number_of_Lines = 0;

        try 
		{
            reader = new FileReader("All Text Files/UserInfo.txt");
            bfreader = new BufferedReader(reader);

            while ((line = bfreader.readLine()) != null) 
			{
                Number_of_Lines++;
            }

            // initialize arrays with appropriate size
            Names = new String[Number_of_Lines];
            Phones = new String[Number_of_Lines];
            Emails = new String[Number_of_Lines];
            Passwords = new String[Number_of_Lines];
            NIDs = new String[Number_of_Lines];
            Balances = new String[Number_of_Lines];

            // reset reader to start from the beginning
            reader = new FileReader("All Text Files/UserInfo.txt");
            bfreader = new BufferedReader(reader);

            int i = 0;
            while ((line = bfreader.readLine()) != null) 
			{
                String[] parts = line.split(",");
                Emails[i] = parts[0];
                Passwords[i] = parts[1];
				Names[i] = parts[2];
                Phones[i] = parts[3];
                NIDs[i] = parts[4];
                Balances[i] = parts[5];
                i++;
            }
            reader.close();
        } 
		catch (Exception E) 
		{

        }

        for (int i = 0; i < Number_of_Lines; i++)
		{
            rows[0] = Emails[i]; // Email
            rows[1] = Passwords[i]; // Password
            rows[2] = Names[i]; // Name
            rows[3] = Phones[i]; // Phone
            rows[4] = NIDs[i]; // NID
            rows[5] = Balances[i]; // Balance
            model.addRow(rows);
        }
		
		
		add(button);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
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
		else if(e.getSource()==button6)
		{
			setVisible(false);
			new AddAdmin();
		}
		else if(e.getSource()==button7)
		{
			
			if (table.getSelectedRows().length>0) 
				{
                    int selectedRows[] = table.getSelectedRows(); 
				Arrays.sort(selectedRows);
                    String str [] = new String[100000];
				try{
                     File	f = new File("All Text Files/UserInfo.txt");				
				FileReader fr=new FileReader(f);
				BufferedReader bfr=new BufferedReader(fr);
				String singleLine;
				
				while((singleLine=bfr.readLine())!=null)
				{
					for(int i=0 ; i<str.length; i++)
					{
						if(str[i]==null)
						{
							str[i]=singleLine;
							break;
						}
					}
					
				}
				fr.close();
				}
				catch(FileNotFoundException fnf)
						{
							
						}
						catch(IOException ioe)
						{
							ioe.printStackTrace();
						}
				if(selectedRows!=null){
					for(int i=selectedRows.length-1; i>=0 ;i--){
						String email = table.getModel().
										getValueAt(selectedRows[i], 0).
										toString();
										
						model.removeRow(selectedRows[i]);
						
						for(int w=0; w<str.length; w++)
							{
							
							if(str[w]!=null && str[w].contains(email))
						  {
							str[w]=null;
							break;
							
						   }
							}
					}
				}
						
						FileWriter fw ;
						try 
						{
							fw = new FileWriter("All Text Files/UserInfo.txt",false);
							for(int j=0; j<str.length; j++)
							{
							
							if(str[j]!=null)
						  {
							fw.write(str[j]+"\n");
							
						   }
							}
							fw.close();
							
						}
						catch(FileNotFoundException fnf)
						{
							
						}
						catch(IOException ioe)
						{
							ioe.printStackTrace();
						}
						
	}
		else
		{
			JOptionPane.showMessageDialog(this,"You must have to Select User","Error",JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
}
}