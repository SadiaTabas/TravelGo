
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class Threestar extends JFrame {
    private JLabel label1;
    private JButton button;
	private JButton button2;
	private JButton button3;
	private JTable table;
	private JScrollPane scroll;
    private Font f;
	
	private String[]cols = {"BED","Day","Breakfast","Price"};
	private String[][] rows={
		                     {"1","1","Y","2500"},
		                     {"2","1","Y","4000"},
							 {"2","3","Y","10000"},
		                       };
	
	
	

    public Threestar() {
        //title
        super(" 3 Star Hotel ");
	
        //label1
        label1 = new JLabel(" 3 STAR HOTEL");
        label1.setBounds(400, 100, 200,40);
       
        //font size,style
        f= new Font("Arial",Font.BOLD,20);
		
		//balance button
        button = new JButton("Balance");
        button.setBounds(20, 50, 150, 35);
		button.setFont(f);
		this.button.setBackground(Color.GREEN);
      
        //offerd price button
		button2 = new JButton("Offerd Price");
        button2.setBounds(20, 200, 150, 35);
		button2.setFont(f);
        this.button2.setBackground(Color.GREEN);
	   
		//logout button
		button3 = new JButton("Logout");
        button3.setBounds(20,400, 150,35);
		button3.setFont(f);
		this.button3.setBackground(Color.GREEN);
		
		//3star hotel table 
		table= new JTable(rows,cols);
		
		table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		scroll= new JScrollPane(table);
		scroll.setBounds(200,160,500,173);

		
   
		add(label1);
	
        add(button);
        add(button2);
		add(button3);
		add(scroll);
	    
        
		//layout,size,color
        setLayout(null);
        setSize(800, 500); //(width,height)
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    

    public static void main(String[] args) {
        new Threestar();
    }
}
