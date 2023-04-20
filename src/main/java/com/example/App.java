package com.example;
import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {
        String user = "root";
        String passwd = "";
        
        String url = "jdbc:mysql://localhost:3306/locadora";
        String driveUrl = "com.mysql.jdbc.Driver";
        try {
            Class.forName(driveUrl);
            Connection conn = DriverManager.getConnection(url, user, passwd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cliente");
            
            while (rs.next()) {
                String nome = rs.getString("nome");
                String login = rs.getString("login");
                System.out.printf("Nome: %s - Login: %s%n", nome, login);
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
