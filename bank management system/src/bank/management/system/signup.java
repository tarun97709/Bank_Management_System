
package bank.management.system;
    


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener {

    long random;
    JButton next;
    
    JComboBox<String> religionChoice, categoryChoice, incomeChoice, educationChoice, occupationChoice;
    JTextField panField, aadharField;
    JRadioButton seniorYes, seniorNo, accYes, accNo;
    ButtonGroup seniorGroup, accGroup;
    String formno;

    signup(String formno) {
        this.formno =formno;
        
        setLayout(null);
        
        setTitle("NEW APPLICATION FORM -- 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(250, 60, 400, 30);
        add(additionalDetails);

        // Religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Times New Roman", Font.BOLD, 20));
        religion.setBounds(150, 150, 200, 30);
        add(religion);

        religionChoice = new JComboBox<>(new String[]{"Hindu", "Muslim", "Christian", "Sikh", "Other"});
        religionChoice.setBounds(450, 150, 200, 30);
        add(religionChoice);

        // Category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Times New Roman", Font.BOLD, 20));
        category.setBounds(150, 200, 200, 30);
        add(category);

        categoryChoice = new JComboBox<>(new String[]{"General", "OBC", "SC", "ST", "Other"});
        categoryChoice.setBounds(450, 200, 200, 30);
        add(categoryChoice);

        // Income
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Times New Roman", Font.BOLD, 20));
        income.setBounds(150, 250, 200, 30);
        add(income);

        incomeChoice = new JComboBox<>(new String[]{
                "Less than 1 Lakh",
                "1 Lakh - 5 Lakhs",
                "5 Lakhs - 10 Lakhs",
                "Above 10 Lakhs"});
        incomeChoice.setBounds(450, 250, 200, 30);
        add(incomeChoice);

        // Education
        JLabel education = new JLabel("Educational Qualification:");
        education.setFont(new Font("Times New Roman", Font.BOLD, 20));
        education.setBounds(150, 300, 250, 30);
        add(education);

        educationChoice = new JComboBox<>(new String[]{
                "Non-Graduate",
                "Graduate",
                "Post-Graduate",
                "Doctorate",
                "Other"});
        educationChoice.setBounds(450, 300, 200, 30);
        add(educationChoice);

        // Occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Times New Roman", Font.BOLD, 20));
        occupation.setBounds(150, 350, 200, 30);
        add(occupation);

        occupationChoice = new JComboBox<>(new String[]{
                "Salaried",
                "Self-Employed",
                "Business",
                "Student",
                "Retired",
                "Other"});
        occupationChoice.setBounds(450, 350, 200, 30);
        add(occupationChoice);

        // PAN
        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan.setBounds(150, 400, 200, 30);
        add(pan);

        panField = new JTextField();
        panField.setBounds(450, 400, 200, 30);
        add(panField);

        // Aadhar
        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        aadhar.setBounds(150, 450, 200, 30);
        add(aadhar);

        aadharField = new JTextField();
        aadharField.setBounds(450, 450, 200, 30);
        add(aadharField);

        // Senior Citizen
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Times New Roman", Font.BOLD, 20));
        senior.setBounds(150, 500, 200, 30);
        add(senior);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(450, 500, 80, 30);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(550, 500, 80, 30);
        add(seniorNo);

        seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        // Existing Account
        JLabel acc = new JLabel("Existing Account:");
        acc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        acc.setBounds(150, 550, 200, 30);
        add(acc);

        accYes = new JRadioButton("Yes");
        accYes.setBounds(450, 550, 80, 30);
        add(accYes);

        accNo = new JRadioButton("No");
        accNo.setBounds(550, 550, 80, 30);
        add(accNo);

        accGroup = new ButtonGroup();
        accGroup.add(accYes);
        accGroup.add(accNo);

        // Next Button
        next = new JButton("Next");
        next.setBounds(450, 620, 100, 30);
        next.addActionListener(this);
        add(next);

        
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 750);
        setLocation(350, 100);
        setVisible(true);
    }

   
    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionChoice.getSelectedItem();
        String category = (String) categoryChoice.getSelectedItem();
        String income = (String) incomeChoice.getSelectedItem();
        String education = (String) educationChoice.getSelectedItem();
        String occupation = (String) occupationChoice.getSelectedItem();
        String pan = panField.getText();
        String aadhar = aadharField.getText();
        String seniorCitizen = seniorYes.isSelected() ? "Yes" : "No";
        String existingAccount = accYes.isSelected() ? "Yes" : "No";

        try {
            if (aadhar.equals("")) {
                JOptionPane.showMessageDialog(null, "Aadhar Number is required");
            } else {
                Conn c = new Conn();
                String q = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pan, aadhar, seniorCitizen, existingAccount) " +
                        "VALUES ('" +formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + pan + "','" + aadhar + "','" + seniorCitizen + "','" + existingAccount + "')";
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Additional Details Saved Successfully!");
                
                setVisible(false);
               new signupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
          System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new signup("");
    }
}