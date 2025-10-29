package bank.management.system;
 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Pinchange extends JFrame implements ActionListener {
    
    JPasswordField pin , repinn;
    JButton change, back;
    String pinnumber;
    
// constructor
   Pinchange(String pinnumber){
       this. pinnumber = pinnumber;
   setLayout(null);


  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("iconss/atm.jpg"));
  Image i2 = i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
  ImageIcon i3 = new ImageIcon(i2);
  JLabel image = new JLabel(i3);
  image.setBounds(0,0,800,670);
  add(image);
  
   JLabel text = new JLabel("CHANGE YOUR PIN");
   text.setForeground(Color.WHITE);
   text.setFont(new Font("System",Font.BOLD,20));
   text.setBounds(190,200,500,25);
   image.add(text);
   

  JLabel pintext = new JLabel("New PIN:");
  pintext.setForeground(Color.WHITE);
  pintext.setFont(new Font("System",Font.BOLD,14));
  pintext.setBounds(125,240,100,25);
  image.add(pintext);
  
   pin = new JPasswordField();
  pin.setFont(new Font("Raleway",Font.BOLD,25));
  pin.setBounds(270,238,180,25);
  image.add(pin);
  
  JLabel repin = new JLabel("Re-Enter New PIN:");
  repin.setForeground(Color.WHITE);
  repin.setFont(new Font("Raleway",Font.BOLD,14));
  repin.setBounds(125,275,150,25);
  image.add(repin);
   
    repinn = new JPasswordField ();
   repinn.setFont(new Font("Raleway",Font.BOLD,25));
   repinn.setBounds(270,275,180,25);
   image.add(repinn);
   
   
   change = new JButton("Change");
   change.setForeground(Color.BLACK);
   change.setBounds(330,370,120,25);
   change.addActionListener(this);
   image.add(change);
   
   back = new JButton("Back");
   back.setForeground(Color.BLACK);
   back.setBounds(330,400,120,25);
   back.addActionListener(this);
   image.add(back);
   
   
setSize(900,900);
setLocation(300,0);
//setUndecorated(true);
setVisible(true);

}

   public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== change){
    try{
        String npin = pin.getText();
        String rpin = repinn.getText();
        
        
        if(!npin.equals(rpin)){
            JOptionPane.showMessageDialog(null,"Entered PIN does not match");
            return;
        }
        
        if (npin.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter new PIN");
            return;
        }
        if (rpin.equals("")){
            JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
            return;
        }
        
        
        Conn conn = new Conn();
        String query1 ="update bank set pinnumber ='"+rpin+"'where  pinnumber ='"+pinnumber+"'";
        String query2 ="update login set pin ='"+rpin+"'where  pin ='"+pinnumber+"'";
        String query3 ="update signupthree set pin ='"+rpin+"'where  pin ='"+pinnumber+"'";

        
        conn.s.executeUpdate(query1);
        conn.s.executeUpdate(query2);
        conn.s.executeUpdate(query3);

        
         JOptionPane.showMessageDialog(null,"PIN changed successFully ");

         
         setVisible(false);
         new Transaction(rpin).setVisible(true);
        
    } catch(Exception e){
        System.out.println(e);
    }
 
       }else{
           setVisible(false);
           new Transaction(pinnumber).setVisible(true);
       }
   

   }
   
   
//main mathod
public static void main(String args[]){
 new Pinchange("").setVisible(true);

}
}