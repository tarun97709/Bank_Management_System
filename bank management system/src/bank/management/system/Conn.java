package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load the MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // DB Connection (username/password apne MySQL ke hisaab se rakhna)
            c = DriverManager.getConnection(
                "jdbc:mysql:///bankmanagementsystem", "root", "1234");
            
            // Statement banaya query run karne ke liye
            s = c.createStatement();
            
            System.out.println("✅ Connection Successful!");
        } catch (Exception e) {
            System.out.println("❌ Connection Failed: " + e);
        }
    }
}
