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

public class Creader extends JFrame
{
    public FileReader reader;
    public BufferedReader bfreader;
    public String[] Names;
    public String[] Phones;
    public String[] Emails;
    public String[] Passwords;

    public Creader()
    {
        String line;
        int Number_of_Lines = 0;

        try {
            reader = new FileReader("All Text Files/UserInfo.txt");
            bfreader = new BufferedReader(reader);

            while ((line = bfreader.readLine()) != null) {
                Number_of_Lines++;
            }

            // initialize arrays with appropriate size
            Names = new String[Number_of_Lines];
            Phones = new String[Number_of_Lines];
            Emails = new String[Number_of_Lines];
            Passwords = new String[Number_of_Lines];

            // reset reader to start from the beginning
            reader = new FileReader("All Text Files/UserInfo.txt");
            bfreader = new BufferedReader(reader);

            int i = 0;
            while ((line = bfreader.readLine()) != null) {
                String[] parts = line.split(",");
                Emails[i] = parts[0];
                Passwords[i] = parts[1];
                Names[i] = parts[2];
                Phones[i] = parts[3];
                i++;
            }
            reader.close();
        } catch (Exception E) {

        }

        for (int i = 0; i < Number_of_Lines; i++) {
            System.out.println(Names[i]);
            System.out.println(Emails[i]);
            System.out.println(Phones[i]);
            System.out.println(Passwords[i]);
        }
    }

    public static void main(String[] args)
    {
        new Creader();
    }
}
