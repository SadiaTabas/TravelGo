import java.awt.Color;
import java.awt.Font;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

import javax.swing.*;

public class cPack extends JFrame implements ActionListener{ 

private JLabel label1,label2,label3,label4,label7,label9,label10,label11,label12,label13,label14,label15,imLabel;
private JTextField field3;
private JComboBox box1,box2,box3,box4,box5,box6,box7,box8;
private JButton button2,preBt,cusBt,hisBt,infBt;
private ImageIcon icon;
public String a1,a2,a3,a4,a5,a6,a7,a8,a9;
public int a10;
private Login login_Obj;
private CustomerInfo CustomerInfo_obj;
private FileReader H5R,H3R,H2R,TAR,TBR;
private BufferedReader H5BR,H3BR,H2BR,TAbR,TBbR;
private String[] H5P = new String[5];
private String[] H3P = new String[5];
private String[] H2P = new String[5];
private String[] TAP = new String[2];
private String[] TBP = new String[2];

public String get_a1(){
    return a1;
}
public String get_a2(){
    return a2;
}
public String get_a3(){
    return a3;
}
public String get_a4(){
    return a4;
}
public String get_a5(){
    return a5;
}
public String get_a6(){
    return a6;
}
public String get_a7(){
    return a7;
}
public String get_a8(){
    return a8;
}
public String get_a9(){
    return a9;
}
public int get_a10(){
    return a10;
}


    public cPack(Login login_Obj,CustomerInfo CustomerInfo_obj){
        super("CUSTOM PACK");
		
		this.login_Obj=login_Obj;
		this.CustomerInfo_obj=CustomerInfo_obj;

        icon=new ImageIcon(getClass().getResource("Graphics/1x/r.jpg"));
        imLabel=new JLabel(icon);
        imLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        infBt=new JButton("CUSTOMER INFO");
        infBt.setBounds(45,20,150,30);
        infBt.setForeground(Color.white);
        infBt.setBackground(Color.DARK_GRAY);//light blue
        infBt.addActionListener(this);

		preBt=new JButton("PRE-MADE PACKS");
        preBt.setBounds(225,20,150,30);
        preBt.setForeground(Color.WHITE);
        preBt.setBackground(Color.DARK_GRAY);
        preBt.addActionListener(this);

		cusBt=new JButton("CUSTOM PACK");
        cusBt.setBounds(405,30,150,30);
        cusBt.setForeground(Color.BLACK);
        cusBt.setBackground(Color.LIGHT_GRAY);
        cusBt.addActionListener(this);

		hisBt=new JButton("HISTORY");
        hisBt.setBounds(585,20,150,30);
        hisBt.setForeground(Color.WHITE);
        hisBt.setBackground(Color.DARK_GRAY);
        hisBt.addActionListener(this);


        button2=new JButton("PURCHASE");
        button2.setBounds(600,400,100,30);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.DARK_GRAY);
        button2.addActionListener(this);


        label1=new JLabel("PLANE YOUR OWN TOUR");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Cooper Black",Font.BOLD, 38));
        label1.setBounds(130,40, 600, 100);

        label2=new JLabel("WHERE DO YOU WANT TO VISIT?");
        label2.setForeground(Color.white);
        label2.setBounds(265,125,300,30);
        label2.setFont(new Font("Calibri",Font.BOLD, 18));
        String arr1[]={"SELECT YOUR DESTENATION","Cox's bazar","Saint martin","Sajak","Srimangol"};
        box1=new JComboBox(arr1);
        box1.setBounds(250,155,280,30);

        label11=new JLabel("DEPARTURE DATE:");
        label11.setForeground(Color.WHITE);
        label11.setBounds(50,202,160,30);
        label11.setFont(new Font("Calibri",Font.BOLD, 18));
        field3=new JTextField("DD/MM/YY");
        field3.setBounds(200,200,150,30);

        label9=new JLabel("TRAVELLERS");
        label9.setForeground(Color.white);
        label9.setFont(new Font("Calibri",Font.BOLD, 18));
        label9.setBounds(430,202,160,30);
        String arr4[]={"NUMBER OF PERSONS","1","2","3","4"};
        box4=new JComboBox(arr4);
        box4.setBounds(550,200,150,30);

        label10=new JLabel("HOTEL");
        label10.setForeground(Color.white);
        label10.setFont(new Font("Calibri",Font.BOLD, 30));
        label10.setBounds(180,250,110,30);

        label7=new JLabel("HOTEL RATING");
        label7.setForeground(Color.white);
        label7.setFont(new Font("Calibri",Font.BOLD, 18));
        label7.setBounds(50,290,140,30);
        String arr3[]={"SELECT HOTEL TYPE","5 star","3 star","2 star"};
        box3=new JComboBox(arr3);
        box3.setBounds(200,290,150,30);

        label12=new JLabel("DAYS");
        label12.setForeground(Color.white);
        label12.setBounds(50,330,120,30);
        label12.setFont(new Font("Calibri",Font.BOLD, 18));
        String arr2[]={"NUMBER OF DAYS","1","3"};
        box2=new JComboBox(arr2);
        box2.setBounds(200,330,150,30);

        label3=new JLabel("BED TYPE");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Calibri",Font.BOLD, 18));
        label3.setBounds(50,370,100,30);
        String arr8[]={"SELECT TYPE","1","2"};
        box5=new JComboBox(arr8);
        box5.setBounds(200,370,150,30);
		
		label15=new JLabel("SELECT TYPE");
        label15.setForeground(Color.white);
        label15.setFont(new Font("Calibri",Font.BOLD, 18));
        label15.setBounds(50,410,100,30);
        String arr9[]={"ROOM NO","1","2"};
        box8=new JComboBox(arr9);
        box8.setBounds(200,410,150,30);
		

        label4=new JLabel("TRANSPORT");
        label4.setForeground(Color.white);
        label4.setFont(new Font("Calibri",Font.BOLD, 30));
        label4.setBounds(500,250,160,30);

        label13=new JLabel("VEHICLE: ");
        label13.setForeground(Color.white);
        label13.setFont(new Font("Calibri",Font.BOLD, 18));
        label13.setBounds(430,290,120,30);
        String arr6[]={"TRAVEL BY","BUS","FLIGHT"};
        box6=new JComboBox(arr6);
        box6.setBounds(550,290,150,30);

        label14=new JLabel("TYPE");
        label14.setForeground(Color.white);
        label14.setFont(new Font("Calibri",Font.BOLD, 18));
        label14.setBounds(430,330,100,30);
        String arr7[]={"NON-AC","AC"};
        box7=new JComboBox(arr7);
        box7.setBounds(550,330,150,30);
        box7.disable();
        
		String Line5, Line3, Line2,LineTA,LineTB;
		
		try{
			
			H5R = new FileReader("All Text Files/Admin5Star.txt");
		H5BR= new BufferedReader(H5R);
		while((Line5=H5BR.readLine())!=null)
				{
					H5P = Line5.split(",");
				}
				
		H3R = new FileReader("All Text Files/Admin3Star.txt");
		H3BR= new BufferedReader(H3R);
		while((Line3=H3BR.readLine())!=null)
				{
					H3P = Line3.split(",");
				}
				
		TAR = new FileReader("All Text Files/AdminAir.txt");
		TAbR= new BufferedReader(TAR);
		while((LineTA=TAbR.readLine())!=null)
				{
					TAP = LineTA.split(",");
				}
		
		TBR = new FileReader("All Text Files/AdminBus.txt");
		TBbR= new BufferedReader(TBR);
		while((LineTB=TBbR.readLine())!=null)
				{
					TBP = LineTB.split(",");
				}
				
		}catch(IOException E){
			
		}
		
		
		
        setSize(800,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        add(button2);
        add(preBt);
        add(cusBt);
        add(hisBt);
        add(infBt);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label7);
        add(label9);
        add(label10);
        add(label11);
        add(label12);
        add(label13);
        add(label14);
		add(label15);
        add(field3);
        add(box1);
        add(box2);
        add(box3);
        add(box4);
        add(box5);
        add(box6);
        add(box7);
		add(box8);
		
        add(imLabel);

        box6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int s = box6.getSelectedIndex();
                if (s == 0) {
                    box7.removeAllItems();
                    box7.addItem("Select vehicle First!");
                    box7.disable();
                } else if (s == 1) {
                    box7.removeAllItems();
                    box7.addItem("Select bus type");
                    box7.addItem("AC");
                    box7.addItem("Non-AC");
                    box7.enable();;
                } else if (s == 2) {
                    box7.removeAllItems();
                    box7.addItem("Sellect seat type");
                    box7.addItem("Business");
                    box7.addItem("Economy");
                    box7.enable();
                }
            }
        });


        field3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                field3.setText("");
            }
        }); 
    }

public void actionPerformed(ActionEvent e) {
    if(e.getSource()==button2){
            String date=field3.getText();
        try{
            if (box1.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "You forgot to select destination.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else if (box2.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "You forgot to select number of days.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else if (box3.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "You forgot to select total hotel rating.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else if (box4.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "You forgot to select number number of travellers.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else if (box5.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "You forgot to select number number of rooms", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else if (box6.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "You forgot to select vehicle.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else if (box7.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "You forgot to select Vehicle Type.", "Warning!",
                JOptionPane.WARNING_MESSAGE);
            }else if(date.isEmpty()){
                JOptionPane.showMessageDialog(null, "You forget to set departure date.", "Warning!",
                JOptionPane.WARNING_MESSAGE);
            }
            else{
				int hotel_cost=0;
                int seat_prize=0;
                int total_cost;
                int person=0;
                
                //hotel cost
                if(box3.getSelectedIndex()==1 && box2.getSelectedIndex()==1 && box5.getSelectedIndex()==1){
                    hotel_cost=Integer.parseInt(H5P[0]);
                }else if(box3.getSelectedIndex()==1 && box2.getSelectedIndex()==1 && box5.getSelectedIndex()==2){
                    hotel_cost=Integer.parseInt(H5P[1]);
                }else if(box3.getSelectedIndex()==1 && box2.getSelectedIndex()==2 && box5.getSelectedIndex()==1){
                    hotel_cost=Integer.parseInt(H5P[2]);
                }else if(box3.getSelectedIndex()==1 && box2.getSelectedIndex()==2 && box5.getSelectedIndex()==2){
                    hotel_cost=Integer.parseInt(H5P[3]);
                }
                else if(box3.getSelectedIndex()==2 && box2.getSelectedIndex()==1 && box5.getSelectedIndex()==1){
                    hotel_cost=Integer.parseInt(H3P[0]);
                }else if(box3.getSelectedIndex()==2 && box2.getSelectedIndex()==1 && box5.getSelectedIndex()==2){
                    hotel_cost=Integer.parseInt(H3P[1]);
                }else if(box3.getSelectedIndex()==2 && box2.getSelectedIndex()==2 && box5.getSelectedIndex()==1){
                    hotel_cost=Integer.parseInt(H3P[2]);
                }else if(box3.getSelectedIndex()==2 && box2.getSelectedIndex()==2 && box5.getSelectedIndex()==2){
                    hotel_cost=Integer.parseInt(H3P[2]);
                }
                else if(box3.getSelectedIndex()==3 && box2.getSelectedIndex()==1 && box5.getSelectedIndex()==1){
                    hotel_cost=Integer.parseInt(H2P[0]);
                }else if(box3.getSelectedIndex()==3 && box2.getSelectedIndex()==1 && box5.getSelectedIndex()==2){
                    hotel_cost=Integer.parseInt(H2P[1]);
                }else if(box3.getSelectedIndex()==3 && box2.getSelectedIndex()==2 && box5.getSelectedIndex()==1){
                    hotel_cost=Integer.parseInt(H2P[2]);
                }else if(box3.getSelectedIndex()==3 && box2.getSelectedIndex()==2 && box5.getSelectedIndex()==2){
                    hotel_cost=Integer.parseInt(H2P[3]);
                }
                

                //transport cost
                if(box6.getSelectedIndex()==1 && box7.getSelectedIndex()==1){
                    seat_prize=Integer.parseInt(TBP[0]);
                }else if(box6.getSelectedIndex()==1 && box7.getSelectedIndex()==2){
                    seat_prize=Integer.parseInt(TBP[1]);
                }else if(box6.getSelectedIndex()==2 && box7.getSelectedIndex()==1){
                    seat_prize=Integer.parseInt(TAP[0]);
                }else if(box6.getSelectedIndex()==2 && box7.getSelectedIndex()==2){
                    seat_prize=Integer.parseInt(TAP[1]);
                }

                if(box4.getSelectedIndex()==1){
                    person=1;
                }else if(box4.getSelectedIndex()==2){
                    person=2;
                }else if(box4.getSelectedIndex()==3){
                    person=3;
                }else if(box4.getSelectedIndex()==4){
                    person=4;
                }
                
                try{        
                    total_cost=hotel_cost+(seat_prize*person);
                    JOptionPane.showMessageDialog(null,"Your total cost is: "+ total_cost, "Total cost",
                    JOptionPane.INFORMATION_MESSAGE);

                    a1=(String)box1.getSelectedItem();
                    a2=(String)field3.getText();
                    a3=(String)box4.getSelectedItem();
                    a4=(String)box3.getSelectedItem();
                    a5=(String)box2.getSelectedItem();
                    a6=(String)box5.getSelectedItem();
                    a7=(String)box6.getSelectedItem();
                    a8=(String)box7.getSelectedItem();
					a9=(String)box8.getSelectedItem();
					a10=(int)total_cost;

                    setVisible(false);
                    new payment(login_Obj,CustomerInfo_obj,this);
                }
                catch(Exception ae){
                }
                
            }
        }
        catch(Exception ae){
                
        }
    }if(e.getSource()==infBt){
        setVisible(false);
        new CustomerInfo(login_Obj);
    }
    else if(e.getSource()==preBt){
        setVisible(false);
        new pPack(login_Obj,CustomerInfo_obj);
    }else if(e.getSource()==hisBt){
        setVisible(false);
        new history(login_Obj,CustomerInfo_obj);
    }
}
}
