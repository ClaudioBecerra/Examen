/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {

    private static Connection con;
    private static final String DB = "";
    private static final String USER = "";
    private static final String PASS = "";
    private static final String URL = "jdbc:mysql://localhost/" + DB +"?useSSL=false";

    public static Connection open() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException ce) {
            System.out.println("Class not found Check jdbc Driver");
        }  catch (SQLException e) {
            System.out.println("Connection error..."+e.getMessage());
            throw e;
        }
        return con;
    }

    public static void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Close error: "+e);
        }
 
    }
 
}
