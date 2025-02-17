package net.codejava.io;
 
import java.io.FileReader;
import java.io.IOException;
 

public class TextFileReadingExample1 {
 
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("LoginInfo.txt");
            String S1;
 
            while (S1.reader.read() == "TT") {
                System.out.println("Welcome to our Program");
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}