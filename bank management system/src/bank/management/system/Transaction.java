package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,statement,pinchange, fastcase,enquiry,exit;
    String pinnumber;
    
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconss/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,680);
        add(image);
        
        JLabel text =  new JLabel("Please select your Transaction");
        text.setBounds(160,200,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        image. add(text);
        
        deposit = new JButton("Deposit");
       deposit.setBounds(120,310,100,25);
       deposit.setForeground(Color.BLACK);
       deposit.addActionListener(this);
       image.add(deposit);
       
       
        fastcase = new JButton("Fast cash");
       fastcase.setBounds(120,340,100,25);
       fastcase.setForeground(Color.BLACK);
       fastcase.addActionListener(this);
       image.add( fastcase);
        
        pinchange = new JButton("Pin Change");
       pinchange.setBounds(120,370,100,25);
       pinchange.setForeground(Color.BLACK);
       pinchange.addActionListener(this);
       image.add(pinchange);
        
       
        withdrawl = new JButton("Cash Withdrawl");
       withdrawl.setBounds(310,310,150,25);
       withdrawl.setForeground(Color.BLACK);
       withdrawl.addActionListener(this);
       image.add(withdrawl);
       
        statement = new JButton("Mini statement");
       statement.setBounds(310,340,150,25);
       statement.setForeground(Color.BLACK);
       statement.addActionListener(this);
       image.add(statement);
       
       
        enquiry = new JButton("Balance Enquiry");
       enquiry.setBounds(310,370,150,25);
       enquiry.setForeground(Color.BLACK);
       enquiry.addActionListener(this);
       image.add(enquiry);
       
       
        exit = new JButton("Exit");
       exit.setBounds(310,400,150,25);
       exit.setForeground(Color.BLACK);
       exit.addActionListener(this);
       image.add(exit);
       
       
       
           
        
        setSize(900,900);
        setLocation(300,0);
//      setUndecorated(true);
        setVisible(true);
        
    }

     public void actionPerformed(ActionEvent ae){
     if (ae.getSource()== exit){
        System.exit(0);
    }else if(ae.getSource() == deposit){
         setVisible(false);
         new Deposit(pinnumber).setVisible(true);
         
    } else if(ae.getSource()== withdrawl){
                 setVisible(false);
                 new Withdrawl(pinnumber).setVisible(true);
    }else if(ae.getSource() == fastcase){
                     setVisible(false);
                     new FastCash(pinnumber).setVisible(true);
                 }else if (ae.getSource()== pinchange){
                     setVisible(false);
                     new Pinchange(pinnumber).setVisible(true);
                 }
                    else if (ae.getSource()== enquiry){
                     setVisible(false);
                     new BalanceEnquiry(pinnumber).setVisible(true);
                 }
                    else if (ae .getSource() == statement){
                     new MiniStatement(pinnumber).setVisible(true);
    }
}

public static void main(String args[]) {
new Transaction("");
    
}
}