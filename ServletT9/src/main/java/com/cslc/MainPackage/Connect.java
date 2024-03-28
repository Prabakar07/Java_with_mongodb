package com.cslc.MainPackage;
import java.sql.*;

public class Connect {
    public ResultSet rs;
    public Connection con;

    public void getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3310/mysql", "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void executeSelectQuery(String query) {
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void executeUpdateQuery(String query) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}