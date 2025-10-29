
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconss/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,680);
        add(image);
        
        
        back = new JButton("Back");
        back.setBounds(330,400,120,25);
        back.addActionListener(this);
        image.add(back);
        
                   Conn c = new Conn();
                      int balance = 0;
                      
      
                      
             try{
             ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                          
                   while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                                balance += Integer.parseInt(rs.getString("amount"));
                            }else {
                                balance -= Integer.parseInt(rs.getString("amount"));
                            }
                          }
                      }catch (Exception e){
                          System.out.println(e);
                      }
                      
        
        JLabel text = new JLabel("Your current Account Balance "+ balance);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,200,300,25);
        image.add(text);
        
        
      setSize(900,900);
      setLocation(300,0);
      setLayout(null);
      setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }
  


public static void main(String args[]){
new BalanceEnquiry("");

}
}