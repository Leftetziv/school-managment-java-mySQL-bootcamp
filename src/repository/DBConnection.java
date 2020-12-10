/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leyteris
 */
public class DBConnection {

    public static Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        String url = "";
        String user = "";
        String password = "";
        Connection con = null;

        try {
            prop.load(new FileInputStream("src\\resources\\mysql.properties"));
            url = prop.getProperty("url");
            user = prop.getProperty("username");
            password = prop.getProperty("password");
        } catch (IOException ex) {
            System.out.println("Error: Can not load credentials file.");
        }

        con = DriverManager.getConnection(url, user, password);
        return con;
    }
    
    public static void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) {
        try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }
    }

}
