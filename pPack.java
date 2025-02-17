import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class pPack extends JFrame implements ActionListener{
    
    private JButton coxBt,smBt,sriBt,sajBt,preBt,cusBt,hisBt,infBt;
    private ImageIcon icon,icon1,icon2,icon3,icon4;
    private JLabel label1,label2,imLabel,l1,l2,l3,l4;
	public Login login_Obj;
	public CustomerInfo CustomerInfo_obj;

    public pPack(Login login_Obj,CustomerInfo CustomerInfo_obj)
	{
        super("PRE-MADE PACKS");
		
		this.login_Obj=login_Obj;
		this.CustomerInfo_obj=CustomerInfo_obj;

        icon=new ImageIcon(getClass().getResource("Graphics/1x/mn.jpg"));
        imLabel=new JLabel(icon);
        imLabel.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());

        infBt=new JButton("CUSTOMER INFO");
        infBt.setBounds(45,20,150,30);
        infBt.setForeground(Color.white);
        infBt.setBackground(Color.DARK_GRAY);//light blue
        infBt.addActionListener(this);

		preBt=new JButton("PRE-MADE PACKS");
        preBt.setBounds(225,30,150,30);
        preBt.setForeground(Color.BLACK);
        preBt.setBackground(Color.LIGHT_GRAY);
        preBt.addActionListener(this);

		cusBt=new JButton("CUSTOM PACK");
        cusBt.setBounds(405,20,150,30);
        cusBt.setForeground(Color.WHITE);
        cusBt.setBackground(Color.DARK_GRAY);
        cusBt.addActionListener(this);

		hisBt=new JButton("HISTORY");
        hisBt.setBounds(585,20,150,30);
        hisBt.setForeground(Color.WHITE);
        hisBt.setBackground(Color.DARK_GRAY);
        hisBt.addActionListener(this);

        label1=new JLabel("CHOOSE YOUR  FAVOURITE PACK");
        label1.setFont(new Font("Cooper Black",Font.BOLD, 38));
        label1.setForeground(Color.WHITE);
        label1.setBounds(40,40,750,100);

        label2=new JLabel("PLEASE CLICK ON PICTURE");
        label2.setFont(new Font("Cooper Black",Font.BOLD, 20));
        label2.setForeground(Color.WHITE);
        label2.setBounds(240,100,750,100);

        l1=new JLabel("COX'S BAZAR");
        l1.setBounds(50,180,120,20);
        l1.setFont(new Font("Calibri",Font.BOLD,20));
        icon1=new ImageIcon(getClass().getResource("Graphics/1x/i1.jpg"));
        coxBt=new JButton(icon1);
        coxBt.setBounds(30,200,160,140);
        coxBt.addActionListener(this);

        l2=new JLabel("SAINT MARTIN");
        l2.setBounds(240,180,140,20);
        l2.setFont(new Font("Calibri",Font.BOLD,20));
        icon2=new ImageIcon(getClass().getResource("Graphics/1x/i4.jpg"));
        smBt=new JButton(icon2);
        smBt.setBounds(220,200,160,140);
        smBt.addActionListener(this);

        l3=new JLabel("SRIMANGAL");
        l3.setBounds(440,180,120,20);
        l3.setFont(new Font("Calibri",Font.BOLD,20));
        icon3=new ImageIcon(getClass().getResource("Graphics/1x/i3.jpg"));
        sriBt=new JButton(icon3);
        sriBt.setBounds(410,200,160,140);
        sriBt.addActionListener(this);

        l4=new JLabel("SAJEK");
        l4.setBounds(655,180,120,20);
        l4.setFont(new Font("Calibri",Font.BOLD,20));
        icon4=new ImageIcon(getClass().getResource("Graphics/1x/i2.jpg"));
        sajBt=new JButton(icon4);
        sajBt.setBounds(600,200,160,140);
        sajBt.addActionListener(this);


        //sunBt=new JButton("Sundarban");

        setSize(800,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(preBt);
        add(cusBt);
        add(hisBt);
        add(infBt);
        add(coxBt);
        add(smBt);
        add(sriBt);
        add(sajBt);
        add(label1);
        add(label2);
        add(imLabel);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==coxBt){
            setVisible(false);
            new coxe(login_Obj,CustomerInfo_obj,this);
        }else if(e.getSource()==smBt){
            setVisible(false);
            new Saint(login_Obj,CustomerInfo_obj,this);
        }else if(e.getSource()==sriBt){
            setVisible(false);
            new srimangol(login_Obj,CustomerInfo_obj,this);
        }else if(e.getSource()==sajBt){
            setVisible(false);
            new sajek(login_Obj,CustomerInfo_obj,this);
        }else if(e.getSource()==infBt){
            setVisible(false);
            new CustomerInfo(login_Obj);
        }else if(e.getSource()==cusBt){
            setVisible(false);
            new cPack(login_Obj,CustomerInfo_obj);
        }else if(e.getSource()==hisBt){
            setVisible(false);
            new history(login_Obj,CustomerInfo_obj);
        }
    }

    public static void main(String[]args){
        new pPack(new Login(), new CustomerInfo(new Login()));
    }
}
