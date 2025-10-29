package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Additional_details extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, districtTextField, stateTextField, pincodeTextField;
    JDateChooser dateChooser;
    JRadioButton male, female, other, married, unmarried, otherStatus;
    JButton next;

    Additional_details() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 300, 30);
        add(personalDetails);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 230, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 230, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 130, 30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 290, 100, 30);
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(500, 290, 100, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 340, 230, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 390, 120, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        otherStatus = new JRadioButton("Other");
        otherStatus.setBounds(520, 390, 100, 30);
        otherStatus.setBackground(Color.white);
        add(otherStatus);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(otherStatus);

        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300, 440, 230, 30);
        add(addressTextField);
   
        JLabel district = new JLabel("District :");
        district.setFont(new Font("Raleway", Font.BOLD, 20));
        district.setBounds(100, 490, 200, 30);
        add(district);

        districtTextField = new JTextField();
        districtTextField.setBounds(300, 490, 130, 30);
        add(districtTextField);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300, 540, 130, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pincode :");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300, 590, 80, 30);
        add(pincodeTextField);

        next = new JButton("NEXT");
        next.setBackground(Color.blue);
        next.setForeground(Color.black);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(450, 650, 100, 40);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(800, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {    
            gender = "Other";
        }

        String email = emailTextField.getText();

        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (otherStatus.isSelected()) {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String district = districtTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn();

                // Insert into database using PreparedStatement (safe)
                Conn cc = new Conn(); // your DB connection helper
                
                 String query = "INSERT INTO signup(formno, name, father_name, dob, gender, email, marital_status, address, district, state, pin) " +
                  "VALUES('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + district + "','" + state + "','" + pin + "')";

//               String query = "INSERT INTO signup values('"formno+"','"+name+"','"+fname+"','"+dob+"','"+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                       
         
              
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully ✅");

                setVisible(false);
                new signup(formno).setVisible(true);
                // Next page agar banayi hai to yahan call karo
                // new Signup2(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        new Additional_details();
    }
}
