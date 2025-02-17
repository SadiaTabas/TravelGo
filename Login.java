 import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.imageio.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.*;
import java.awt.Color;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener {
    public JButton Login_Button, Sign_up_Button, Forget_Password_Button, About_us_Button;
    public JTextField Email_Text;
    public JPasswordField Password_Text;
    public ImageIcon BackgroundImage;
    public String checkPass, checkusername;
    public FileReader reader;
    private Cursor cursor;
    public String email_to_check;
    public JCheckBox checkBox;

    public String get_email() {
        return email_to_check;
    }

    public Login() {
        super("Login Frame");

        // Cursor for JButtons
        cursor = new Cursor(Cursor.HAND_CURSOR);

        JLabel BackgroundImage_label;
        ImageIcon img = new ImageIcon("Graphics/1x/Cover1.jpg");
        BackgroundImage_label = new JLabel("", img, JLabel.CENTER);
        BackgroundImage_label.setBounds(0, 0, 800, 500);

        JLabel Email_Label = new JLabel("Email");
        Email_Label.setBounds(300, 50, 80, 30);
        Email_Label.setForeground(Color.white);
        Email_Label.setFont(new Font("SansSerif", Font.BOLD, 15));

        Email_Text = new JTextField();
        Email_Text.setBounds(400, 50, 150, 25);
        Email_Text.setBorder(null);

        JLabel password_Lable = new JLabel("Password");
        password_Lable.setBounds(300, 80, 80, 30);
        password_Lable.setForeground(Color.white);
        password_Lable.setFont(new Font("SansSerif", Font.BOLD, 15));

        Password_Text = new JPasswordField();
        Password_Text.setBounds(400, 80, 150, 25);
        Password_Text.setBorder(null);

        checkBox = new JCheckBox();
        checkBox.setText("Show Password");
        checkBox.setBounds(395, 100, 150, 30);
        checkBox.setOpaque(false);
        checkBox.addActionListener(this);

        Login_Button = new JButton("Login");
        Login_Button.setBounds(300, 150, 100, 30);
        Login_Button.addActionListener(this);
        Login_Button.setBorder(null);
        Login_Button.setCursor(cursor);

        JLabel Sign_Up_Lable = new JLabel("Don't Have any account?");
        Sign_Up_Lable.setBounds(200, 420, 200, 30);
        Sign_Up_Lable.setForeground(Color.white);
        Sign_Up_Lable.setFont(new Font("SansSerif", Font.BOLD, 15));

        Sign_up_Button = new JButton("Sign Up");
        Sign_up_Button.setBounds(400, 420, 100, 30);
        Sign_up_Button.setBorder(null);
        Sign_up_Button.addActionListener(this);
        Sign_up_Button.setCursor(cursor);

        this.setSize(800, 500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(Email_Label);
        add(password_Lable);
        add(Email_Text);
        add(Password_Text);
        add(Login_Button);
        add(Sign_up_Button);
        add(Sign_Up_Lable);
        add(checkBox);

        add(BackgroundImage_label);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login_Button) {
            String email = Email_Text.getText();
            String password = Password_Text.getText();

            String LoginInfo = email + "," + password;

            String AdminLoginInfo = "admin" + "," + "admin";

            String Hotel_5_Star_LoginInfo = "h5admin" + "," + "h5admin";
            String Hotel_3_Star_LoginInfo = "h3admin" + "," + "h3admin";
            String Hotel_2_Star_LoginInfo = "h2admin" + "," + "h2admin";

            String Bus_provider_LoginInfo = "adminBus" + "," + "adminBus";
            String Air_Provider_LoginInfo = "adminAir" + "," + "adminAir";

            BufferedReader bfreader = null;
            String line;
            int count = 0;
            try {
                reader = new FileReader("All Text Files/UserInfo.txt");
                bfreader = new BufferedReader(reader);

                while ((line = bfreader.readLine()) != null) {
                    String[] parts = line.split(",");
                    String Email = parts[0];
                    String Password = parts[1];

                    String User_login_info = Email + "," + Password;

                    if (LoginInfo.equals(User_login_info)) {
                        count++;
                    }
                }

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill up all the fields");
                } else if (count == 1) {
                    email_to_check = Email_Text.getText();
                    this.setVisible(false);
                    new CustomerInfo(this);
                } else if (LoginInfo.equals(AdminLoginInfo)) {
                    this.setVisible(false);
                    new Admin_Balance();
                } else if (LoginInfo.equals(Hotel_5_Star_LoginInfo)) {
                    this.setVisible(false);
                    H_5_Balance H5S = new H_5_Balance();
                } else if (LoginInfo.equals(Hotel_3_Star_LoginInfo)) {
                    this.setVisible(false);
                    H_3_Balance H3S = new H_3_Balance();
                } else if (LoginInfo.equals(Hotel_2_Star_LoginInfo)) {
                    this.setVisible(false);
                    H_2_Balance H2S = new H_2_Balance();
                } else if (LoginInfo.equals(Bus_provider_LoginInfo)) {
                    this.setVisible(false);
                    Bus_Provider_Balance BpB = new Bus_Provider_Balance();
                } else if (LoginInfo.equals(Air_Provider_LoginInfo)) {
                    this.setVisible(false);
                    Air_Provider_Balance ApB = new Air_Provider_Balance();
                } else {
                    JOptionPane.showMessageDialog(this, "Enter Correct ID & Password");
                }

                reader.close();
                bfreader.close();
            } catch (Exception ex) {

            }

        } else if (e.getSource() == Sign_up_Button) {
            this.setVisible(false);
            new SignUP();
        }
    else if (checkBox.isSelected()) {
            Password_Text.setEchoChar((char) 0);

        } else if (!checkBox.isSelected()) {
            Password_Text.setEchoChar('\u2022');
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
