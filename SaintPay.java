import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SaintPay extends JFrame implements ActionListener{
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label13,imLabel1,imLabel2,imLabel3,imLabel4;
    private JTextField field1,field2,field3,field4,field5,field6,field7;
    private ImageIcon icon1,icon2,icon3,icon4;
    private JRadioButton rbt1,rbt2;
    private ButtonGroup group;
    private JButton bt1;
    public String hotel,vehicle,person,room,day,cost,payday,date,email;
    public FileWriter writer;
	private Login login_Obj;
	private CustomerInfo CustomerInfo_obj;
	private pPack pPack_obj;
	private Saint Saint_obj;

    public Saint get_pack_obj(){
        return Saint_obj;
    }

    public SaintPay(Login login_Obj,CustomerInfo CustomerInfo_obj,pPack pPack_obj,Saint Saint_obj){
        super("PAYMENT");
		
		this.login_Obj=login_Obj;
		this.CustomerInfo_obj=CustomerInfo_obj;
		this.pPack_obj=pPack_obj;
        this.Saint_obj=Saint_obj;
		
        hotel=this.get_pack_obj().get_a1();
        vehicle=this.get_pack_obj().get_a2();
        person=this.get_pack_obj().get_a3();
        room=this.get_pack_obj().get_a4();
        day=this.get_pack_obj().get_a5();
        cost=this.get_pack_obj().get_a6();
		date=this.get_pack_obj().get_a7();
		email=this.login_Obj.get_email();

        bt1=new JButton("Purchase");
        bt1.setBounds(620,400,100,30);
        bt1.addActionListener(this);

        label1=new JLabel("Complete your payment");
        label1.setFont(new Font("Calibri",Font.BOLD, 40));
        label1.setBounds(195,5, 600, 100);

        label2=new JLabel("to ensure your package");
        label2.setFont(new Font("Calibri",Font.BOLD, 30));
        label2.setBounds(250,40, 600, 100);

        label3=new JLabel("You can pay with");
        label3.setFont(new Font("Calibri",Font.BOLD, 25));
        label3.setBounds(50,140, 400, 60);
       
        icon1=new ImageIcon(getClass().getResource("Graphics/1x/MasterCard.png"));
        imLabel1=new JLabel("",icon1,JLabel.CENTER);
        imLabel1.setBounds(300,140,icon1.getIconWidth(),icon1.getIconHeight());
        icon2=new ImageIcon(getClass().getResource("Graphics/1x/VisaCard.png"));
        imLabel2=new JLabel("",icon2,JLabel.CENTER);
        imLabel2.setBounds(380,140,icon2.getIconWidth(),icon2.getIconHeight());

        label4=new JLabel("or");
        label4.setFont(new Font("Calibri",Font.BOLD, 25));
        label4.setBounds(470,138, 400, 60);

        icon3=new ImageIcon(getClass().getResource("Graphics/1x/bkash.png"));
        imLabel3=new JLabel("",icon3,JLabel.CENTER);
        imLabel3.setBounds(550,140,icon3.getIconWidth(),icon3.getIconHeight());
        icon4=new ImageIcon(getClass().getResource("Graphics/1x/nagod.png"));
        imLabel4=new JLabel("",icon4,JLabel.CENTER);
        imLabel4.setBounds(630,140,icon4.getIconWidth(),icon4.getIconHeight());		

        rbt1=new JRadioButton();
        rbt1.setBounds(270,150,30,30);
        rbt2=new JRadioButton();
        rbt2.setBounds(520,150,30,30);
        rbt1.addActionListener(this);
        rbt2.addActionListener(this);

        group=new ButtonGroup();
        group.add(rbt1);
        group.add(rbt2);

        label5=new JLabel("Card Details");
        label5.setFont(new Font("Calibri",Font.BOLD, 25));
        label5.setBounds(50,190, 400, 60);

        label6=new JLabel("Name on card");
        label6.setFont(new Font("Calibri",Font.BOLD, 20));
        label6.setBounds(50,260, 400, 20);
        field1=new JTextField();
        field1.setBounds(180,250,210,30);
        field1.disable();

        label7=new JLabel("Card number");
        label7.setFont(new Font("Calibri",Font.BOLD, 20));
        label7.setBounds(50,300, 400, 20);
        field2=new JTextField();
        field2.setBounds(180,293,210,30);
        field2.disable();

        label8=new JLabel("valid no");
        label8.setFont(new Font("Calibri",Font.BOLD, 20));
        label8.setBounds(50,340, 400, 20);
        field3=new JTextField();
        field3.setBounds(130,335,80,30);
        field3.disable();

        label9=new JLabel("CVV code");
        label9.setFont(new Font("Calibri",Font.BOLD, 20));
        label9.setBounds(220,340, 400, 20);
        field4=new JTextField();
        field4.setBounds(310,335,80,30);
        field4.disable(); 
        
        label10=new JLabel("Mobile Banking");
        label10.setFont(new Font("Calibri",Font.BOLD, 25));
        label10.setBounds(430,190, 400, 60);

        label11=new JLabel("Mob No");
        label11.setFont(new Font("Calibri",Font.BOLD, 20));
        label11.setBounds(430,260, 400, 20);
        field5=new JTextField();
        field5.setBounds(510,250,210,30);
        field5.disable();

        label12=new JLabel("Pin code");
        label12.setFont(new Font("Calibri",Font.BOLD, 20));
        label12.setBounds(430,300, 400, 20);
        field6=new JTextField();
        field6.setBounds(510,293,210,30);
        field6.disable();

        label13=new JLabel("Payment date");
        label13.setFont(new Font("Calibri",Font.BOLD, 20));
        label13.setBounds(240,390,120,30);
        field7=new JTextField("DD/MM/YY");
        field7.setBounds(370,385,150,30);
        field7.disable();
        field7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                field7.setText("");
            }
        });


        setSize(800,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(label7);
        add(label8);
        add(label9);
        add(label10);
        add(label11);
        add(label12);
        add(label13);
        add(imLabel1);
        add(imLabel2);
        add(imLabel3);
        add(imLabel4);
        add(rbt1);
        add(rbt2);
        add(field1);
        add(field2);
        add(field3);
        add(field4);
        add(field5);
        add(field6);
        add(field7);
        add(bt1);
        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt1){
            String nc=field1.getText();
            String cn=field2.getText();
            String vo=field3.getText();
            String cvv=field4.getText();
            String pn=field5.getText();
            String pin=field6.getText();
            payday=field7.getText();
                
            if(rbt1.isSelected()==true){
                if(!nc.isEmpty()&&!cn.isEmpty()&&!vo.isEmpty()&&!cvv.isEmpty()){
                    //File cPack_info=new File("cPack_info.txt");
                    //cPack_info.createNewFile();
                    FileWriter writer=null;
                    try{
                        writer=new FileWriter("All Text Files/All_History.txt",true);
                        writer.write(email+","+"Saint Martin"+","+date+","+person+","+hotel+","+day+",2,"+room+","+vehicle+","+payday+","+cost+"\n");//
                        JOptionPane.showMessageDialog(this, "Payment successful");
                        writer.close();
                    }
                    catch(Exception ae){
                        JOptionPane.showMessageDialog(this, "ERROR");
                    }
                    JOptionPane.showMessageDialog(null, "Purchase Done", "Congratulation!",
                    JOptionPane.INFORMATION_MESSAGE);
                }else if(nc.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You forgot to set name on card.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }else if(cn.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You forgot to set card number.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }else if(vo.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You forgot to set valid on.", "Warning!",
                     JOptionPane.WARNING_MESSAGE);
                }else if(cvv.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You forgot to set CVV code.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
				setVisible(false);
				new pPack(login_Obj, CustomerInfo_obj);
            }
			
                
            else if(rbt2.isSelected()==true){
                if(!pn.isEmpty()&&!pin.isEmpty()){
                try{
                    writer=new FileWriter("All Text Files/All_History.txt",true);
                    writer.write(email+","+"Saint Martin"+","+date+","+person+","+hotel+","+day+",2,"+room+","+vehicle+","+payday+","+cost+"\n");//
                    JOptionPane.showMessageDialog(this, "Payment successful");
                    writer.close();
                }
                catch(Exception ae){
                    JOptionPane.showMessageDialog(this, "ERROR");
                }
                JOptionPane.showMessageDialog(null, "Purchase Done", "Congratulation!",
                JOptionPane.INFORMATION_MESSAGE);
                }
                else if(pn.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You forgot to set phone number.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
                else if(pin.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You forgot to set pin code.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
			
            }
			setVisible(false);
            new pPack(login_Obj, CustomerInfo_obj);
        }
        else if(e.getSource()==rbt1){
            field1.enable();
            field2.enable();
            field3.enable();
            field4.enable();
            field7.enable();
            field5.setText("");
            field6.setText("");
            field5.disable();
            field6.disable();
        }
        else if(e.getSource()==rbt2){
            field1.setText("");
            field2.setText("");
            field3.setText("");
            field4.setText("");
            field1.disable();
            field2.disable();
            field3.disable();
            field4.disable();
            field5.enable();
            field6.enable();
            field7.enable();
        } 
            
    }

    public static void main(String[]args){
        new SaintPay(new Login(), new CustomerInfo(new Login()), new pPack(new Login(), new CustomerInfo(new Login())),new Saint(new Login(), new CustomerInfo(new Login()), new pPack(new Login(), new CustomerInfo(new Login()))));
    }
}