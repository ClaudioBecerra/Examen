package dao.impl;

import dao.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql implements Conexion {
    private static final String DB = "prestamo";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String URL = "jdbc:mysql://localhost/" + DB + "?useSSL=false";


    @Override
    public Connection getConexion() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found Check jdbc Driver");
            throw e;
        } catch (SQLException e) {
            System.out.println("Connection error..." + e.getMessage());
            throw e;
        }
    }

    @Override
    public void closeConexion(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Close error: " + e);
        }
    }
}
