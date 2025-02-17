 import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CustomerInfo extends JFrame implements ActionListener {
    public JLabel Name_Label, Phone_Label, Email_Label, NID_Label, Balance_Label;
    public JLabel tital, name, phone, email, nid, balance, imLabel;
    private JButton preBt, cusBt, hisBt, infBt, lgBt;
    private ImageIcon icon;
    private String Email;
    private FileReader reader;
    private BufferedReader bfreader;
    private String[] Info = new String[6];
    public payment paymentobj;
    private Login login_obj;
    private CustomerInfo CustomerInfo_obj;

    public Login get_Login_obj() {
        return login_obj;
    }

    public payment get_payment_obj() {
        return paymentobj;
    }

    public CustomerInfo(Login login_obj) {
        this.login_obj = login_obj;
        Email = this.get_Login_obj().get_email();

        icon = new ImageIcon(getClass().getResource("Graphics/1x/pr.jpg"));
        imLabel = new JLabel(icon);
        imLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        infBt = new JButton("CUSTOMER INFO");
        infBt.setBounds(45, 30, 150, 30);
        infBt.setForeground(Color.BLACK);
        infBt.setBackground(Color.LIGHT_GRAY); //light blue
        infBt.addActionListener(this);

        preBt = new JButton("PRE-MADE PACKS");
        preBt.setBounds(225, 20, 150, 30);
        preBt.setForeground(Color.WHITE);
        preBt.setBackground(Color.DARK_GRAY);
        preBt.addActionListener(this);

        cusBt = new JButton("CUSTOM PACK");
        cusBt.setBounds(405, 20, 150, 30);
        cusBt.setForeground(Color.WHITE);
        cusBt.setBackground(Color.DARK_GRAY);
        cusBt.addActionListener(this);

        lgBt = new JButton("LOG OUT");
        lgBt.setBounds(75, 420, 100, 25);
        lgBt.setForeground(Color.WHITE);
        lgBt.setBackground(Color.DARK_GRAY);
        lgBt.addActionListener(this);

        tital = new JLabel("Customer Information");
        tital.setFont(new Font("Cooper Black", Font.BOLD, 38));
        tital.setForeground(Color.WHITE);
        tital.setBounds(160, 40, 480, 100);

        name = new JLabel("Name:");
        name.setFont(new Font("Calibri", Font.BOLD, 25));
        name.setForeground(Color.WHITE);
        name.setBounds(190, 150, 70, 30);

        phone = new JLabel("Phone No:");
        phone.setFont(new Font("Calibri", Font.BOLD, 25));
        phone.setForeground(Color.WHITE);
        phone.setBounds(190, 190, 110, 30);

        email = new JLabel("Email address:");
        email.setFont(new Font("Calibri", Font.BOLD, 25));
        email.setForeground(Color.WHITE);
        email.setBounds(190, 230, 150, 30);

        nid = new JLabel("NID No:");
        nid.setFont(new Font("Calibri", Font.BOLD, 25));
        nid.setForeground(Color.WHITE);
        nid.setBounds(190, 270, 90, 30);

        balance = new JLabel("Balance:");
        balance.setFont(new Font("Calibri", Font.BOLD, 25));
        balance.setForeground(Color.WHITE);
        balance.setBounds(190, 310, 100, 30);

        add(tital);
        add(name);
        add(phone);
        add(email);
        add(nid);
        add(balance);
        add(preBt);
        add(cusBt);
        add(infBt);
        add(lgBt);

        reader = null;
        bfreader = null;
        String line;

        try {
            reader = new FileReader("All Text Files/UserInfo.txt");
            bfreader = new BufferedReader(reader);

            while ((line = bfreader.readLine()) != null) {
                String[] parts = line.split(",");
                String email = parts[0];

                if (Email.equals(email)) {
                    Info = parts;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Name_Label = new JLabel(Info[2]);
        Name_Label.setBounds(450, 150, 300, 30);
        Name_Label.setFont(new Font("Calibri", Font.BOLD, 25));
        Name_Label.setForeground(Color.WHITE);

        Phone_Label = new JLabel(Info[3]);
        Phone_Label.setBounds(450, 190, 200, 30);
        Phone_Label.setFont(new Font("Calibri", Font.BOLD, 25));
        Phone_Label.setForeground(Color.WHITE);

        Email_Label = new JLabel(Info[0]);
        Email_Label.setBounds(450, 230, 300, 30);
        Email_Label.setFont(new Font("Calibri", Font.BOLD, 25));
        Email_Label.setForeground(Color.WHITE);

        NID_Label = new JLabel(Info[4]);
        NID_Label.setBounds(450, 270, 200, 30);
        NID_Label.setFont(new Font("Calibri", Font.BOLD, 25));
        NID_Label.setForeground(Color.WHITE);

        Balance_Label = new JLabel(Info[5]);
        Balance_Label.setFont(new Font("SansSerif ", Font.BOLD, 32));
        Balance_Label.setBounds(450, 300, 200, 40);
        Balance_Label.setForeground(Color.WHITE);

        add(Name_Label);
        add(Phone_Label);
        add(Email_Label);
        add(NID_Label);
        add(Balance_Label);
        add(imLabel);

        this.setSize(800, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cusBt) {
            setVisible(false);
            new cPack(login_obj, this);
        } else if (e.getSource() == preBt) {
            setVisible(false);
            new pPack(login_obj, CustomerInfo_obj);
        } else if (e.getSource() == lgBt) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new CustomerInfo(new Login());
    }
}


	