package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;   // ✅ Required import




public class FastCash extends JFrame implements ActionListener{
    
    JButton cash,withdrawl,statement,pinchange, fastcase,enquiry,exit;
    String pinnumber;
    
    FastCash(String pinnumber){

        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconss/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,680);
        add(image);
        
        JLabel text =  new JLabel("SELECT WITHDRAWL AMOUNT ");
        text.setBounds(160,200,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,18));
        image. add(text);
        
       cash= new JButton("Rs 100");
       cash.setBounds(120,310,100,25);
       cash.setForeground(Color.BLACK);
       cash.addActionListener(this);
       image.add(cash);
       
       
        fastcase = new JButton("Rs 500");
       fastcase.setBounds(120,340,100,25);
       fastcase.setForeground(Color.BLACK);
       fastcase.addActionListener(this);
       image.add( fastcase);
        
        pinchange = new JButton("Rs 1000 ");
       pinchange.setBounds(120,370,100,25);
       pinchange.setForeground(Color.BLACK);
       pinchange.addActionListener(this);
       image.add(pinchange);
        
       
        withdrawl = new JButton("Rs 2000");
       withdrawl.setBounds(310,310,150,25);
       withdrawl.setForeground(Color.BLACK);
       withdrawl.addActionListener(this);
       image.add(withdrawl);
       
        statement = new JButton("Rs 5000 ");
       statement.setBounds(310,340,150,25);
       statement.setForeground(Color.BLACK);
       statement.addActionListener(this);
       image.add(statement);
       
       
        enquiry = new JButton("Rs 10000");
       enquiry.setBounds(310,370,150,25);
       enquiry.setForeground(Color.BLACK);
       enquiry.addActionListener(this);
       image.add(enquiry);
       
       
        exit = new JButton("Back");
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
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }else  {
        String amount =((JButton)ae.getSource()).getText().substring(3);
         Conn c = new Conn();
         try {
           
             ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+ pinnumber +"'");
             int balance = 0;
             while (rs.next()) {
             if(rs.getString("type").equals("Deposit")){
                 balance += Integer.parseInt(rs.getString("amount"));
             }else {
                 balance -= Integer.parseInt(rs.getString("amount"));
            }
         }
           if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
               JOptionPane.showMessageDialog(null,"Insufficient Balance");
               return;
           }
           
           // inside your actionPerformed:
                Date date = new Date();
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formattedDate = sdf.format(date);

           
           
           String query ="insert into bank(pinnumber,date,type,amount) values('"+pinnumber +"','"+formattedDate+"', 'Withdrawl','"+amount+"')";
           c.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Rs "+ amount + " Debited sucessFully");
           
           
           setVisible(false);
           new Transaction(pinnumber).setVisible( true);            
         } catch(Exception e){
                 System.out.println(e);
                 }
                      
    }
        
    }


public static void main(String args[]) {
new FastCash("");
    
}
}