  package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame{
    MiniStatement(String pinnumber){
       setTitle("Mini Statement");
       
       
       JLabel text = new JLabel();
       text.setBounds(20,140,400,200);
       add(text);
       
       JLabel bank = new JLabel("Indian Bank");
      bank .setBounds(150,20,100,20);
       add(bank);
       
         JLabel card = new JLabel();
      card .setBounds(20,80,400,200);
       add(card);
       
         JLabel balance = new JLabel();
      balance .setBounds(20,400,300,20);
       add(balance);
       
       
       try{
           
           Conn c = new Conn();
           ResultSet rs = c.s.executeQuery("select * from login where pin ='"+pinnumber+"'");
           while(rs.next()){
               card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4)+ "XXXXXXXX" + rs.getString("cardnumber").substring(12));
           }
       }catch (Exception e){
                          System.out.println(e);
       }
       
       
       try {
           
           Conn c = new Conn();
           int bal = 0;
           ResultSet rs = c.s.executeQuery("select * from bank where pinnumber ='"+pinnumber+"'");
           while (rs.next()){
               text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +rs.getString("amount") +"<br><br> <html>") ;
                       
             if(rs.getString("type").equals("Deposit")){
                                bal += Integer.parseInt(rs.getString("amount"));
                            }else {
                                bal -= Integer.parseInt(rs.getString("amount"));
                            }
                          }
                    balance.setText("Your current balance is Rs:" +bal);
                      }catch (Exception e){
                          System.out.println(e);
                      }
                               
    
           
               setLayout(null);
               setSize(400,600);
               setLocation(20,20);
               getContentPane().setBackground(Color.WHITE);
               setVisible(true);
}

public static void main(String args[]){
new MiniStatement("");
}
}