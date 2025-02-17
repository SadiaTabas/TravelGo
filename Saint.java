import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class Saint extends JFrame implements ActionListener{
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,imLabel1,imLabel2,imLabel3;
    private ImageIcon icon1,icon2,icon3;
    private JRadioButton rbt1,rbt2,rbt3;
    private TextField f1,f2,f3,f4,f5,f6;
    private JButton bt1,bt2;
    private ButtonGroup group;
    public String a1,a2,a3,a4,a5,a6,a7;
	private Login login_Obj;
	private CustomerInfo CustomerInfo_obj;
	private pPack pPack_obj;

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
    

    public Saint(Login login_Obj, CustomerInfo CustomerInfo_obj,pPack pPack_obj)
	{
        super("Saint Martin");
		this.login_Obj=login_Obj;
		this.CustomerInfo_obj=CustomerInfo_obj;
		this.pPack_obj=pPack_obj;

        icon1=new ImageIcon(getClass().getResource("Graphics/1x/st1.jpg"));
        imLabel1=new JLabel(icon1);
        imLabel1.setBounds(7,5,icon1.getIconWidth(),icon1.getIconHeight());

        icon2=new ImageIcon(getClass().getResource("Graphics/1x/st2.jpg"));
        imLabel2=new JLabel(icon2);
        imLabel2.setBounds(5,280,icon2.getIconWidth(),icon2.getIconHeight());

        icon3=new ImageIcon(getClass().getResource("Graphics/1x/st3.jpg"));
        imLabel3=new JLabel(icon3);
        imLabel3.setBounds(200,280,icon3.getIconWidth(),icon3.getIconHeight());

        bt1 =new JButton("Purchase");
        bt1.setBounds(600,425,100,25);
        bt1.addActionListener(this);

        bt2 =new JButton("Back");
        bt2.setBounds(470,425,100,25);
        bt2.addActionListener(this);

        l1=new JLabel("Want to visit Saint Martin?");
        l1.setFont(new Font("Calibri",Font.BOLD,30));
        l1.setBounds(410,10,350,30);

        l2=new JLabel("Packs available");
        l2.setFont(new Font("Calibri",Font.BOLD,28));
        l2.setBounds(485,40,300,30);

        l3=new JLabel("Choose a package");
        l3.setFont(new Font("Calibri",Font.BOLD,20));
        l3.setBounds(500,95,300,20);

        l4=new JLabel("Package details");
        l4.setFont(new Font("Calibri",Font.BOLD,20));
        l4.setBounds(510,150,350,30);

        l5=new JLabel("Hotel type");
        l5.setFont(new Font("Calibri",Font.BOLD,17));
        l5.setBounds(430,190,100,30);
        f1=new TextField();
        f1.setEditable(false);
        f1.setBounds(550,190,180,25);
        f1.setFont(new Font("calibri",Font.BOLD, 15));

        l6=new JLabel("Vehicle type");
        l6.setFont(new Font("Calibri",Font.BOLD,17));
        l6.setBounds(430,220,100,30);
        f2=new TextField();
        f2.setEditable(false);
        f2.setBounds(550,220,180,25);
        f2.setFont(new Font("calibri",Font.BOLD, 15));

        l7=new JLabel("Travelers");
        l7.setFont(new Font("Calibri",Font.BOLD,17));
        l7.setBounds(430,250,100,30);
        f3=new TextField();
        f3.setEditable(false);
        f3.setBounds(550,250,180,25);
        f3.setFont(new Font("calibri",Font.BOLD, 15));

        l8=new JLabel("Rooms");
        l8.setFont(new Font("Calibri",Font.BOLD,17));
        l8.setBounds(430,280,100,30);
        f4=new TextField();
        f4.setEditable(false);
        f4.setBounds(550,280,180,25);
        f4.setFont(new Font("calibri",Font.BOLD, 15));

        l9=new JLabel("Travel Days");
        l9.setFont(new Font("Calibri",Font.BOLD,17));
        l9.setBounds(430,310,100,30);
        f5=new TextField();
        f5.setEditable(false);
        f5.setBounds(550,310,180,25);
        f5.setFont(new Font("calibri",Font.BOLD, 15));

        l10=new JLabel("Cost");
        l10.setFont(new Font("Calibri",Font.BOLD,17));
        l10.setBounds(430,340,100,30);
        f6=new TextField();
        f6.setEditable(false);
        f6.setBounds(550,340,180,25);
        f6.setFont(new Font("calibri",Font.BOLD, 15));
		
		l11=new JLabel("Departure date");
        l11.setFont(new Font("Calibri",Font.BOLD,17));
        l11.setBounds(450,380,140,30);
        l12=new JLabel("16/05/2024");
        l12.setFont(new Font("Calibri",Font.BOLD,19));
        l12.setBounds(590,380,100,30);

        rbt1=new JRadioButton("Pack 1 (Gold)");
        rbt1.setBounds(400,120,100,20);
        rbt1.addActionListener(this);

        rbt2=new JRadioButton("Pack 2 (Silver)");
        rbt2.setBounds(515,120,110,20);
        rbt2.addActionListener(this);

        rbt3=new JRadioButton("Pack 3 (Bronze)");
        rbt3.setBounds(635,120,120,20);
        rbt3.addActionListener(this);
        

        group=new ButtonGroup();
        group.add(rbt1);
        group.add(rbt2);
        group.add(rbt3);

        setSize(800,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        add(bt1);
        add(bt2);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
		add(l11);
		add(l12);
        add(f1);
        add(f2);
        add(f3);
        add(f4);
        add(f5);
        add(f6);
        add(rbt1);
        add(rbt2);
        add(rbt3);
        add(imLabel1);
        add(imLabel2);
        add(imLabel3);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==rbt1){
            f1.setText("5 Star");
            f2.setText("AC Bus");
            f3.setText("4");
            f4.setText("2");
            f5.setText("3");
            f6.setText("35000");
        }
        else if(e.getSource()==rbt2){
            f1.setText("3 Star");
            f2.setText("Non-AC Bus");
            f3.setText("4");
            f4.setText("2");
            f5.setText("3");
            f6.setText("28000");
        }
        else if(e.getSource()==rbt3){
            f1.setText("2 Star");
            f2.setText("Non-AC Bus");
            f3.setText("2");
            f4.setText("2");
            f5.setText("1");
            f6.setText("22000");
        }
        else if(e.getSource()==bt1){
            try{
                if(!rbt1.isSelected()&&!rbt2.isSelected()&&!rbt3.isSelected()){
                    JOptionPane.showMessageDialog(null, "You forgot to select a package.", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
                }
                else if(rbt1.isSelected()){
                    a1=(String)f1.getText();
                    a2=(String)f2.getText();
                    a3=(String)f3.getText();
                    a4=(String)f4.getText();
                    a5=(String)f5.getText();
                    a6=(String)f6.getText();
					a7=(String)l12.getText();
                    setVisible(false);
                    new SaintPay(login_Obj,CustomerInfo_obj,pPack_obj,this);
                }
                else if(rbt2.isSelected()){
                    a1=(String)f1.getText();
                    a2=(String)f2.getText();
                    a3=(String)f3.getText();
                    a4=(String)f4.getText();
                    a5=(String)f5.getText();
                    a6=(String)f6.getText();
					a7=(String)l12.getText();
                    setVisible(false);
                    new SaintPay(login_Obj,CustomerInfo_obj,pPack_obj,this);
                }
                else if(rbt3.isSelected()){
                    a1=(String)f1.getText();
                    a2=(String)f2.getText();
                    a3=(String)f3.getText();
                    a4=(String)f4.getText();
                    a5=(String)f5.getText();
                    a6=(String)f6.getText();
					a7=(String)l12.getText();
                    setVisible(false);
                    new SaintPay(login_Obj,CustomerInfo_obj,pPack_obj,this);
                }
                else{}
            }
            catch(Exception ae){}
        }
        else if(e.getSource()==bt2){
            setVisible(false);
            new pPack(login_Obj,CustomerInfo_obj);
        }
        else{}
    }
    public static void main(String[]args){
        new Saint(new Login(), new CustomerInfo(new Login()), new pPack(new Login(), new CustomerInfo(new Login())));
    }
}

