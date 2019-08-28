package dao;

import java.sql.Connection;

public interface Conexion {

    Connection getConexion() throws Exception;

    void closeConexion(Connection connection);
}