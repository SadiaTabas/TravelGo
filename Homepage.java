import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Homepage extends JFrame implements ActionListener {

    private JButton preBt,cusBt,redBt,hisBt,infBt, RedBt;

    public Homepage(){
        super("HOME PAGE");



        preBt=new JButton("PRE-MADE PACKS");
		preBt.setBounds(20,50,150,50);

        cusBt=new JButton("CUSTOM PACK");
		cusBt.setBounds(20,120,150,50);
        cusBt.addActionListener(this);
		
        redBt=new JButton("REDEEM CODE");
		redBt.setBounds(20,190,150,50);
		redBt.setVisible(false);
		
		RedBt=new JButton("REDEEM CODE 2");
		RedBt.setBounds(20,190,150,50);
		RedBt.setVisible(false);
	

        hisBt=new JButton("HISTORY");
		hisBt.setBounds(20,260,150,50);


        infBt=new JButton("CUSTOMER INFO");
		infBt.setBounds(20,330,150,50);

        setSize(800,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        
        this.add(preBt);
        this.add(cusBt);
        this.add(redBt);
		this.add(RedBt);
        this.add(hisBt);
        this.add(infBt);
		
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==hisBt)
		{
            //setVisible(false);
            //new CustomPack();
			RedBt.setVisible(true);
        }
		else if(e.getSource()==cusBt)
		{
			redBt.setVisible(true);
		}
    }
    public static void main(String[]args){
        new Homepage();
    }
}
